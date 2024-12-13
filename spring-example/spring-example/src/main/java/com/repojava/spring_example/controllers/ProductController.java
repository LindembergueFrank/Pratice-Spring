package com.repojava.spring_example.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.repojava.spring_example.models.ProductModel;
import com.repojava.spring_example.repositories.ProductRepository;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/home")
    public String home() {
        return "Hello World!";
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        List<ProductModel> products = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable(value = "id") UUID id) {
        Optional<ProductModel> productModel = productRepository.findById(id);
        if (productModel.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(productModel.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    /*@PostMapping("")
    public ResponseEntity<ProductModel> addProduct(@RequestBody ProductModel productModel) {

    }*/
}
