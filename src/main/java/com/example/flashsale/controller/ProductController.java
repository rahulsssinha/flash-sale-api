package com.example.flashsale.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flashsale.model.Product;
import com.example.flashsale.service.ProductService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
    @PostMapping("/api/products")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);

    }
    @PostMapping("/api/purchase/{productId}")
    public Product purchaseProduct(@PathVariable Long productId){
        return productService.purchaseProduct(productId);
    }
}