package com.example.shoplaptopservice.services;

import com.example.shoplaptopservice.entities.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Products> getAllProduct();

    Page<Products> getProductPaging(Pageable pageable);

    Optional<Products> getProductById(Integer id);

    Products createProduct(Products product);

    Products updateProduct(Integer id, Products product);

    void deleteProduct(Integer id);

    void restoreProduct(Integer id);

    List<Products> searchProductByProductName(String keyword);

    List<Products> getProductByStatusTrue();
}
