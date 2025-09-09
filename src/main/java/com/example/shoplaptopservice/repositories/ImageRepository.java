package com.example.shoplaptopservice.repositories;

import com.example.shoplaptopservice.entities.Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Images, Integer> {
    List<Images> findByProductsProductId(Integer productId);
    List<Images> findByIsDeletedFalse();
}
