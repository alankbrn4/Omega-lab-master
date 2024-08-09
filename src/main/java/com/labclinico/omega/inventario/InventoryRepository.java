package com.labclinico.omega.inventario;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<InventoryModel, String> {
}
