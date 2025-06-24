package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
    // v1.1: Find products whose name contains a substring (case-insensitive)
    List<Product> findByNameContainingIgnoreCase(String keyword);
// v2.0: Find products by name containing substring and price range
List<Product> findByNameContainingIgnoreCaseAndPriceBetween(String name, double minPrice, double maxPrice);
}

