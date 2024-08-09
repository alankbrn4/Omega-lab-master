package com.labclinico.omega.inventario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@Tag(name = "Inventory", description = "API for managing lab inventory items")
public class InventoryController {
    
    @Autowired
    public InventoryService inventoryService;

    @GetMapping
    @Operation(summary = "Get all inventory items", description = "Get all inventory items from the database")
    public List<InventoryModel> getAllInventoryItems() {
        return inventoryService.getAllInventoryItems();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get inventory item by ID", description = "Get inventory item from the database by ID")
    public InventoryModel getInventoryItemById(@PathVariable String id) {
        return inventoryService.getInventoryItemById(id);
    }

    @PostMapping
    @Operation(summary = "Add inventory item", description = "Add inventory item to the database")
    public InventoryModel addInventoryItem(@RequestBody InventoryModel inventoryItem) {
        return inventoryService.addInventoryItem(inventoryItem);
    }

    @PutMapping
    @Operation(summary = "Update inventory item", description = "Update inventory item in the database")
    public InventoryModel updateInventoryItem(@RequestBody InventoryModel inventoryItem) {
        return inventoryService.updateInventoryItem(inventoryItem);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete inventory item", description = "Delete inventory item from the database")
    public void deleteInventoryItem(@PathVariable String id) {
        inventoryService.deleteInventoryItem(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Search inventory items", description = "Search inventory items based on a keyword")
    public List<InventoryModel> searchInventoryItems(@RequestParam String keyword) {
        return inventoryService.searchInventoryItems(keyword);
    }

    @GetMapping("/sorted")
    @Operation(summary = "Get sorted inventory items", description = "Retrieves inventory items sorted by a specific field")
    public List<InventoryModel> sortInventoryItems(@RequestParam String sortBy) {
        return inventoryService.sortInventoryItems(sortBy);
    }



}
