package com.labclinico.omega.inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryCacheService inventoryCacheService;
    

    public Optional<InventoryModel> getInventorsyItemById(String id) {
        InventoryModel inventoryCachedItem = inventoryCacheService.getInventoryItemFromCache(id);
        if (inventoryCachedItem != null) {
            return Optional.of(inventoryCachedItem);
        }

        Optional<InventoryModel> inventoryItem = inventoryRepository.findById(id);
        inventoryItem.ifPresent(inventoryCacheService::addInventoryItemToCache);
        return inventoryItem;
       
    }

    //Métodos de Búsqueda y Ordenamiento
    public List<InventoryModel> searchInventoryItems(String keyword){
        List<InventoryModel> allInventoryItems = inventoryRepository.findAll();
        return allInventoryItems.stream()
                .filter(inventoryItem -> inventoryItem.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                        inventoryItem.getCategory().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<InventoryModel> sortInventoryItems(String sortBy){
        List<InventoryModel> allInventoryItems = inventoryRepository.findAll();
        switch (sortBy.toLowerCase()){
            case "name":
                return allInventoryItems.stream()
                        .sorted(Comparator.comparing(InventoryModel::getName))
                        .collect(Collectors.toList());
            case "quantity":
                return allInventoryItems.stream()
                        .sorted(Comparator.comparing(InventoryModel::getQuantity).reversed())
                        .collect(Collectors.toList());
            default:
                return allInventoryItems;
        }
    }

    public List<InventoryModel> getAllInventoryItems() {
        return inventoryRepository.findAll();
    }

    public InventoryModel getInventoryItemById(String id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    public InventoryModel addInventoryItem(InventoryModel inventoryItem) {
        return inventoryRepository.save(inventoryItem);
    }

    public InventoryModel updateInventoryItem(InventoryModel inventoryItem) {
        return inventoryRepository.save(inventoryItem);
    }

    public void deleteInventoryItem(String id) {
        inventoryRepository.deleteById(id);
    }   
    


}
