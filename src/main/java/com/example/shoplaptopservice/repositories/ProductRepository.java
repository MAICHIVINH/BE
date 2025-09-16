package com.example.shoplaptopservice.repositories;

import com.example.shoplaptopservice.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Integer> {
    List<Products> findByProductNameContainingIgnoreCase(String keyword);
    List<Products> findByProductStatusTrue();
    List<Products> findByIsDeletedTrue();
    List<Products> findByProductStatusTrueAndIsDeletedFalse();

}
