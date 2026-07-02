package com.example.retail.service;

import com.example.retail.model.OrderDetails;
import com.example.retail.model.OrderItem;
import com.example.retail.repository.OrderDetailsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderDetailsRepository orderDetailsRepository;

    public OrderService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public List<OrderDetails> getAllOrders() {
        return orderDetailsRepository.findAll();
    }

    public OrderDetails getOrderById(Long id) {
        return orderDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public List<OrderDetails> getOrdersByCustomerId(Long customerId) {
        return orderDetailsRepository.findByCustomerId(customerId);
    }

    public List<OrderDetails> getOrdersByStoreId(Long storeId) {
        return orderDetailsRepository.findByStoreId(storeId);
    }

    public OrderDetails createOrder(OrderDetails order) {
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");

        // Link each item back to this order + calculate total
        double total = 0.0;
        for (OrderItem item : order.getItems()) {
            item.setOrderDetails(order);
            total += item.getQuantity() * item.getPriceAtOrder();
        }
        order.setTotalAmount(total);

        return orderDetailsRepository.save(order);
    }

    public OrderDetails updateOrderStatus(Long id, String status) {
        OrderDetails existing = getOrderById(id);
        existing.setStatus(status);
        return orderDetailsRepository.save(existing);
    }

    public void deleteOrder(Long id) {
        orderDetailsRepository.deleteById(id);
    }
}
