package com.example.easy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.example.easy.model.Product;
import com.example.easy.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;
     @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void testDB() {
        System.out.println("Connected DB: " + mongoTemplate.getDb().getName());
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product add(Product p) {
    System.out.println("Saving product: " + p.getName());
    return repo.save(p);
}

    public Product update(String id, Product newData) {
        Product p = repo.findById(id).orElseThrow();
        p.setName(newData.getName());
        p.setPrice(newData.getPrice());
        return repo.save(p);
    }

    public void delete(String id) {
        Product p = repo.findById(id).orElseThrow();

        if (!p.isInCart()) {
            throw new RuntimeException("Add to cart before deleting");
        }

        repo.deleteById(id);
    }

    public Product addToCart(String id) {
        Product p = repo.findById(id).orElseThrow();
        p.setInCart(true);
        return repo.save(p);
    }
}