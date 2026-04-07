package com.example.easy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.easy.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}