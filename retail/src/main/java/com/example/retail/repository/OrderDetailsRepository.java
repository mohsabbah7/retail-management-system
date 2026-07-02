package com.example.retail.repository;

import com.example.retail.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

    List<OrderDetails> findByCustomerId(Long customerId);

    List<OrderDetails> findByStoreId(Long storeId);
}