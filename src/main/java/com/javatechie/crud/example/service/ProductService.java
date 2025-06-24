package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;

@Service
public class ProductService {
    // v1.1: Search products by keyword
    public List<Product> searchProductsByKeyword(String keyword) {
    return repository.findByNameContainingIgnoreCase(keyword);
}

// v2.0: Search by name and price range
public List<Product> searchProducts(String name, Double minPrice, Double maxPrice) {
    if (name == null) name = "";
    if (minPrice == null) minPrice = 0.0;
    if (maxPrice == null) maxPrice = Double.MAX_VALUE;
    List<Product> results = repository.findByNameContainingIgnoreCaseAndPriceBetween(name, minPrice, maxPrice);
    if (results.isEmpty()) {
        throw new RuntimeException("No products found matching criteria");
    }
    return results;
}
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }


}
