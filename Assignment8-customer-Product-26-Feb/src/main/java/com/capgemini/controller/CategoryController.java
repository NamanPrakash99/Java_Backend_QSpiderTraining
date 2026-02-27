package com.capgemini.controller;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.capgemini.dto.Category;
import com.capgemini.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryjpa;

    public CategoryController(CategoryService categoryjpa) {
        this.categoryjpa = categoryjpa;
    }

    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category) {
        return categoryjpa.createCategory(category);
    }

    @GetMapping("/find-all")
    public List<Category> findAllCategories() {
        return categoryjpa.getAllCategories();
    }

    @GetMapping("/find-id/{id}")
    public Category findCategoryById(@PathVariable Long id) {
        return categoryjpa.getCategoryById(id);
    }

    @DeleteMapping("/delete-id/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryjpa.deleteCategory(id);
    }
     @GetMapping("/page/{page}/{size}")
	    public List<Category> getCategoryPage(@PathVariable int page, @PathVariable int size) {
	        return categoryjpa.getCategoryPage(page, size);
	    }
}
