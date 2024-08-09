package com.labclinico.omega.inventario;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class InventoryCacheService {

    private final ConcurrentHashMap<String, InventoryModel> inventoryCache = new ConcurrentHashMap<>();

    public void addInventoryItemToCache(InventoryModel inventoryItem) {
        inventoryCache.put(inventoryItem.getId(), inventoryItem);
    }

    public InventoryModel getInventoryItemFromCache(String id) {
        return inventoryCache.get(id);
    }

    public void updateInventoryItemInCache(InventoryModel inventoryItem) {
        inventoryCache.put(inventoryItem.getId(), inventoryItem);
    }

    public void deleteInventoryItemFromCache(String id) {
        inventoryCache.remove(id);
    }

}
