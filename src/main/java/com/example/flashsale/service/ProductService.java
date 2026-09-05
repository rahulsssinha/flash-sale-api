package com.example.flashsale.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.flashsale.model.Product;
import com.example.flashsale.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Product purchaseProduct(Long productId){
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

                if(product.getStock()<=0){
                    throw new RuntimeException("Product out of stock");
                }
                product.setStock(product.getStock()-1);

                return productRepository.save(product);
    }
}