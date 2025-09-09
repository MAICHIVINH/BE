package com.example.shoplaptopservice.services.implement;

import com.example.shoplaptopservice.entities.Products;
import com.example.shoplaptopservice.repositories.ProductRepository;
import com.example.shoplaptopservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Products> getAllProduct() {
        return productRepository.findByProductStatusTrue();
    }

    @Override
    public Page<Products> getProductPaging(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Products> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Products createProduct(Products product) {
        return productRepository.save(product);
    }

    @Override
    public Products updateProduct(Integer id, Products product) {
        Products existing = productRepository.findById(id).orElseThrow();
        //Cập nhật từng field
        existing.setProductName(product.getProductName());
        existing.setProductPrice(product.getProductPrice());
        existing.setProductDetail(product.getProductDetail());
        existing.setProductDescription(product.getProductDescription());
        existing.setProductQuantity(product.getProductQuantity());
        existing.setBrands(product.getBrands());
        existing.setCategories(product.getCategories());
        existing.setProductStatus(product.getProductStatus());
        existing.setDeleted(product.getDeleted());
        return productRepository.save(existing);
    }

    @Override
    public void deleteProduct(Integer id) {
        Products product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        product.setProductStatus(false); // chuyển trạng thái thành false
        productRepository.save(product);
    }

    @Override
    public void restoreProduct(Integer id) {
        Products product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        product.setProductStatus(true);
        productRepository.save(product);
    }

    @Override
    public List<Products> searchProductByProductName(String keyword) {
        return productRepository.findByProductNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<Products> getProductByStatusTrue() {
        return productRepository.findByProductStatusTrue();
    }
}
