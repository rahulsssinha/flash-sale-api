package com.example.flashsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flashsale.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}