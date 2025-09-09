package com.example.shoplaptopservice.repositories;

import com.example.shoplaptopservice.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Categories, Integer> {
    List<Categories> findByCategoryNameContainingIgnoreCase(String keyword);
    List<Categories> findByCategoryStatusTrue();
}
