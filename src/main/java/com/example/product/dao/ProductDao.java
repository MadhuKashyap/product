package com.example.product.dao;

import com.example.product.pojo.ProductPojo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends MongoRepository<ProductPojo, String> {

}
