package com.example.shoplaptopservice.controllers;

import com.example.shoplaptopservice.entities.Products;
import com.example.shoplaptopservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Products> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/page")
    public Page<Products> getProductPaging(@RequestParam int page, @RequestParam int size) {
        return productService.getProductPaging(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Optional<Products> getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    public String createProduct(@RequestBody Products product) {
        productService.createProduct(product);
        return "Product created successfully!";
    }

    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable Integer id, @RequestBody Products product) {
        productService.updateProduct(id, product);
        return "Product updated successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "Product has been deactivated successfully!";
    }

    @PutMapping("/restore/{id}")
    public String restoreProduct(@PathVariable Integer id) {
        productService.restoreProduct(id);
        return "Product restored successfully!";
    }

    @GetMapping("/search")
    public List<Products> searchProduct(@RequestParam String keyword) {
        return productService.searchProductByProductName(keyword);
    }

    @GetMapping("/active")
    public List<Products> getActiveProduct() {
        return productService.getProductByStatusTrue();
    }
}
