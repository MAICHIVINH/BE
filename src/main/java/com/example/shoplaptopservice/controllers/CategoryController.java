package com.example.shoplaptopservice.controllers;

import com.example.shoplaptopservice.entities.Categories;
import com.example.shoplaptopservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Categories> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/page")
    public Page<Categories> getCategoryPaging(@RequestParam int page, @RequestParam int size) {
        return categoryService.getCategoryPaging(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Optional<Categories> getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/add")
    public String createCategory(@RequestBody Categories category) {
        categoryService.createCategory(category);
        return "Category created successfully!";
    }

    @PutMapping("/update/{id}")
    public String updateCategory(@PathVariable Integer id, @RequestBody Categories category) {
        categoryService.updateCategory(id, category);
        return "Category updated successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return "Category deleted successfully!";
    }

    @GetMapping("/search")
    public List<Categories> searchCategory(@RequestParam String keyword) {
        return categoryService.searchCategoryByCategoryName(keyword);
    }

    @GetMapping("/active")
    public List<Categories> getActiveCategory() {
        return categoryService.getCategoryByStatusTrue();
    }
}
