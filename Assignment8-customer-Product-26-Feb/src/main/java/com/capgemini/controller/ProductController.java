package com.capgemini.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.capgemini.dto.Product;
import com.capgemini.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save/{categoryId}")
    public Product saveProduct(@RequestBody Product product, @PathVariable Long categoryId) {
        return productService.createProduct(product, categoryId);
    }

    @GetMapping("/find-all")
    public List<Product> findAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/find-id/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> findProductsByCategory(@PathVariable Long categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @GetMapping("/search/{name}")
    public List<Product> searchProduct(@PathVariable String name) {
        return productService.searchByName(name);
    }

    @DeleteMapping("/delete-id/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}