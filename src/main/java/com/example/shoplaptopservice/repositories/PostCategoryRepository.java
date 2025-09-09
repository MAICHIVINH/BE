package com.example.shoplaptopservice.repositories;

import com.example.shoplaptopservice.entities.PostCategories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCategoryRepository extends JpaRepository<PostCategories, Integer> {
//    List<PostCategories> findByIsDeletedFalse();
    List<PostCategories> findByPostCategoryNameContainingIgnoreCase(String keyword);
    List<PostCategories> findByPostCategoryStatusTrue();
}
