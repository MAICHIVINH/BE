package com.example.shoplaptopservice.repositories;

import com.example.shoplaptopservice.entities.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brands, Integer> {
    List<Brands> findByBrandNameContainingIgnoreCase(String keyword);
    List<Brands> findByBrandStatusTrue();
}
