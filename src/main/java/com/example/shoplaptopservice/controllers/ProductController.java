package com.example.shoplaptopservice.controllers;

import com.example.shoplaptopservice.entities.Products;
import com.example.shoplaptopservice.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/deleted")
    public List<Products> getDeletedProducts() {
        return productService.getDeletedProducts();
    }


    @GetMapping("/page")
    public Page<Products> getProductPaging(@RequestParam int page, @RequestParam int size) {
        return productService.getProductPaging(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Optional<Products> getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping(
            value = "/add",
            consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }
    )
    public ResponseEntity<?> createProduct(
            @RequestPart("product") String productJson,
            @RequestPart("mainImage") MultipartFile mainImage,
            @RequestPart(value = "subImages", required = false) List<MultipartFile> subImages
    ) throws JsonProcessingException {
        // Chuyển JSON thành object
        ObjectMapper mapper = new ObjectMapper();
        Products product = mapper.readValue(productJson, Products.class);

        // Gọi service
        Products saved = productService.createProduct(product, mainImage, subImages);
        return ResponseEntity.ok(saved);
    }


    @PutMapping(
            value = "/update/{id}",
            consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }
    )
    public ResponseEntity<?> updateProduct(
            @PathVariable Integer id,
            @RequestPart("product") String productJson,
            @RequestPart(value = "mainImage", required = false) MultipartFile mainImage,
            @RequestPart(value = "subImages", required = false) List<MultipartFile> subImages
    ) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Products product = mapper.readValue(productJson, Products.class);

        Products updated = productService.updateProduct(id, product, mainImage, subImages);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "Product has been deactivated successfully!";
    }

    @DeleteMapping("/delete-hard/{id}")
    public String deleteProductForever(@PathVariable Integer id) {
        productService.deleteProductForever(id);
        return "Product has been permanently deleted!";
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
