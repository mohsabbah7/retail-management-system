package com.example.retail.service;

import com.example.retail.model.Store;
import com.example.retail.repository.StoreRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Store getStoreById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found with id: " + id));
    }

    public Store createStore(Store store) {
        return storeRepository.save(store);
    }

    public Store updateStore(Long id, Store updatedStore) {
        Store existing = getStoreById(id);
        existing.setName(updatedStore.getName());
        existing.setLocation(updatedStore.getLocation());
        existing.setPhone(updatedStore.getPhone());
        existing.setEmail(updatedStore.getEmail());
        return storeRepository.save(existing);
    }

    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }
}