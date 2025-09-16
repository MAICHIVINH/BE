package com.example.shoplaptopservice.repositories;

import com.example.shoplaptopservice.entities.Images;
import com.example.shoplaptopservice.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Images, Integer> {
    List<Images> findByProductsProductId(Integer productId);
    List<Images> findByIsDeletedFalse();
    void deleteByProducts_ProductId(Integer productId);
//
//    void deleteByProductsAndMainImageTrue(Products product);
//
//    void deleteByProductsAndMainImageFalse(Products product);

    List<Images> findByProductsAndIsMain(Products product, boolean isMain);


}
