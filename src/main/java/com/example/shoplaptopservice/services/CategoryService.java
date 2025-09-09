package com.example.shoplaptopservice.services;

import com.example.shoplaptopservice.entities.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Categories> getAllCategory();

    Page<Categories> getCategoryPaging(Pageable pageable);

    Optional<Categories> getCategoryById(Integer id);

    Categories createCategory(Categories category);

    Categories updateCategory(Integer id, Categories category);

    void deleteCategory(Integer id);

    List<Categories> searchCategoryByCategoryName(String keyword);

    List<Categories> getCategoryByStatusTrue();
}
