package com.capgemini.controller;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.capgemini.dto.Category;
import com.capgemini.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("/find-all")
    public List<Category> findAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/find-id/{id}")
    public Category findCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/delete-id/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
