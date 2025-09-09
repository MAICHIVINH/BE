package com.example.shoplaptopservice.controllers;

import com.example.shoplaptopservice.entities.Images;
import com.example.shoplaptopservice.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("/all")
    public List<Images> getAllImage() {
        return imageService.getAllImage();
    }

    @GetMapping("/page")
    public Page<Images> getImagePaging(@RequestParam int page, @RequestParam int size) {
        return imageService.getImagePaging(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Optional<Images> getImageById(@PathVariable Integer id) {
        return imageService.getImageById(id);
    }
    @GetMapping("/product/{productId}")
    public List<Images> getImagesByProductId(@PathVariable Integer productId) {
        return imageService.getImagesByProductId(productId);
    }

    @PostMapping("/add")
    public String createImage(@RequestBody Images image) {
        imageService.createImage(image);
        return "Image created successfully!";
    }

    @PutMapping("/update/{id}")
    public String updateImage(@PathVariable Integer id, @RequestBody Images image) {
        imageService.updateImage(id, image);
        return "Image updated successfully!";
    }

//    @DeleteMapping("/delete/{id}")
//    public String deleteImage(@PathVariable Integer id) {
//        imageService.deleteImage(id);
//        return "Image deleted successfully!";
//    }

    @PutMapping("/soft-delete/{id}")
    public ResponseEntity<String> softDelete(@PathVariable Integer id) {
        try {
            imageService.softDeleteImage(id);
            return ResponseEntity.ok("Image deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Image delete failed: " + e.getMessage());
        }
    }

    @DeleteMapping("/hard-delete/{id}")
    public ResponseEntity<String> hardDelete(@PathVariable Integer id) {
        try {
            imageService.hardDeleteImage(id);
            return ResponseEntity.ok("Image deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Image delete failed: " + e.getMessage());
        }
    }

    //upload 1 ảnh
    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(
            @RequestParam("productId") Integer productId,
            @RequestParam("file") MultipartFile file) {
        try {
            Images savedImage = imageService.uploadImageForProduct(productId, file);
            return ResponseEntity.ok(savedImage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Upload failed: " + e.getMessage());
        }
    }

    //upload nhìu ảnh
    @PostMapping("/upload-multiple")
    public ResponseEntity<?> uploadMultipleImages(
            @RequestParam("productId") Integer productId,
            @RequestParam("files") MultipartFile[] files) {
        try {
            List<Images> savedImages = imageService.uploadMultipleImages(productId, files);
            return ResponseEntity.ok(savedImages);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Upload failed: " + e.getMessage());
        }
    }
}
