package com.example.ordermanagement.repository;

import com.example.ordermanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStockQuantityLessThanEqual(Integer stockQuantity);
    List<Product> findByStockQuantityGreaterThan(Integer stockQuantity);
}