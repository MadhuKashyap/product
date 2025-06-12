package com.example.product.dao;

import com.example.product.pojo.InventoryPojo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryDao extends MongoRepository<InventoryPojo, Long> {
    InventoryPojo findBySkuId(String skuId);
}
