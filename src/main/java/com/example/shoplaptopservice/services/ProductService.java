package com.example.shoplaptopservice.services;

import com.example.shoplaptopservice.entities.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Products> getAllProduct();

    Page<Products> getProductPaging(Pageable pageable);

    Optional<Products> getProductById(Integer id);

    Products createProduct(Products product, MultipartFile mainImage, List<MultipartFile> subImages);

    Products updateProduct(Integer id, Products product, MultipartFile mainImage, List<MultipartFile> subImages);

    void deleteProduct(Integer id);

    void deleteProductForever(Integer id);

    void restoreProduct(Integer id);

    List<Products> searchProductByProductName(String keyword);

    List<Products> getProductByStatusTrue();

    List<Products> getDeletedProducts();
}
