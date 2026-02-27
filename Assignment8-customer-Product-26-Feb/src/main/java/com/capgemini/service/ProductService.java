package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capgemini.dto.Category;
import com.capgemini.dto.Product;
import com.capgemini.exception.ProductNotFound;
import com.capgemini.exception.CategoryNotFound;
import com.capgemini.repo.CategoryRepository;
import com.capgemini.repo.ProductRepository;

@Component
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository,CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product createProduct(Product product, Long categoryId) {

        Optional<Category> option = categoryRepository.findById(categoryId);

        if(option.isPresent()) {
            product.setCategory(option.get());
            return productRepository.save(product);
        } else {
            throw new CategoryNotFound();
        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {

        Optional<Product> option = productRepository.findById(id);

        if(option.isPresent()) {
            return option.get();
        } else {
            throw new ProductNotFound();
        }
    }

    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategory_CategoryId(categoryId);
    }

    public List<Product> searchByName(String name) {
        return productRepository.findByProductNameContainingIgnoreCase(name);
    }

    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}