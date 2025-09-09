package com.example.shoplaptopservice.services.implement;

import com.example.shoplaptopservice.entities.Categories;
import com.example.shoplaptopservice.repositories.CategoryRepository;
import com.example.shoplaptopservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Categories> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Categories> getCategoryPaging(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Optional<Categories> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Categories createCategory(Categories category) {
        return categoryRepository.save(category);
    }

    @Override
    public Categories updateCategory(Integer id, Categories category) {
        Categories existing = categoryRepository.findById(id).orElseThrow();
        // cập nhật từng field
        existing.setCategoryName(category.getCategoryName());
        existing.setCategoryStatus(category.getCategoryStatus());
        return categoryRepository.save(existing);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Categories> searchCategoryByCategoryName(String keyword) {
        return categoryRepository.findByCategoryNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<Categories> getCategoryByStatusTrue() {
        return categoryRepository.findByCategoryStatusTrue();
    }
}
