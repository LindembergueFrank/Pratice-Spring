package com.repojava.spring_example.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.repojava.DTO.ProductRecordDto;
import com.repojava.spring_example.models.ProductModel;
import com.repojava.spring_example.repositories.ProductRepository;

import jakarta.validation.Valid;
import lombok.experimental.var;

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
    public ResponseEntity<ProductModel> getProductById(@PathVariable UUID id) {
        Optional<ProductModel> productModel = productRepository.findById(id);
       
        if (productModel.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(productModel.get());
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var productModel = new ProductModel();
        
        BeanUtils.copyProperties(productRecordDto, productModel);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable (value = "id")
    UUID id, @RequestBody @Valid ProductRecordDto productRecordDto) {
            Optional<ProductModel> product = productRepository.findById(id);
            
            if (!product.isEmpty()) {
                var productModel = product.get();
                BeanUtils.copyProperties(productRecordDto, productModel);
                return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
            }
            
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
        }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable (value = "id") UUID id) {
        Optional<ProductModel> product = productRepository.findById(id);
        
        if (!product.isEmpty()) {
            productRepository.delete(product.get());
            return ResponseEntity.status(HttpStatus.OK).body("Product deleted sucessfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
    }
}
