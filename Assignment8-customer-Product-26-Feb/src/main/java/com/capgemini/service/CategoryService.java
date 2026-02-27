package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capgemini.dto.Category;
import com.capgemini.exception.CategoryNotFound;
import com.capgemini.repo.CategoryRepository;

@Component
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // constructor Injection
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Create Category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Get All Categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Get Category By Id
    public Category getCategoryById(Long id) {

        Optional<Category> option = categoryRepository.findById(id);

        if(option.isPresent()) {
            return option.get();
        } else {
            throw new CategoryNotFound();
        }
    }

    // Update Category
    public Category updateCategory(Long id, Category category) {

        Optional<Category> option = categoryRepository.findById(id);

        if(option.isPresent()) {

            Category existingCategory = option.get();
            existingCategory.setCategoryName(category.getCategoryName());
            existingCategory.setDescription(category.getDescription());

            return categoryRepository.save(existingCategory);

        } else {
            throw new CategoryNotFound();
        }
    }

    // Delete Category
    public void deleteCategory(Long id) {

        Category category = getCategoryById(id);
        categoryRepository.delete(category);
    }

    
    // Pagination and sorting in w.r.t to id in descending
    public List<Category> getCategoryPage(int page, int size) {
         Page<Category> p=categoryRepository.findAll(PageRequest.of(page, size,Sort.by("categoryId").descending()));
         return p.getContent();
    }
}