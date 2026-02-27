package com.capgemini.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.capgemini.dto.Product;
import com.capgemini.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productjpa;

    public ProductController(ProductService productjpa) {
        this.productjpa = productjpa;
    }

    @PostMapping("/save/{categoryId}")
    public Product saveProduct(@RequestBody Product product, @PathVariable Long categoryId) {
        return productjpa.createProduct(product, categoryId);
    }

    @GetMapping("/find-all")
    public List<Product> findAllProducts() {
        return productjpa.getAllProducts();
    }

    @GetMapping("/find-id/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productjpa.getProductById(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> findProductsByCategory(@PathVariable Long categoryId) {
        return productjpa.getProductsByCategory(categoryId);
    }

    @GetMapping("/search/{name}")
    public List<Product> searchProduct(@PathVariable String name) {
        return productjpa.searchByName(name);
    }

    @DeleteMapping("/delete-id/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productjpa.deleteProduct(id);
    }
}