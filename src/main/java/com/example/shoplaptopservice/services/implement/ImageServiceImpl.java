package com.example.shoplaptopservice.services.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.shoplaptopservice.entities.Products;
import com.example.shoplaptopservice.repositories.ProductRepository;
import com.example.shoplaptopservice.utils.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.shoplaptopservice.entities.Images;
import com.example.shoplaptopservice.repositories.ImageRepository;
import com.example.shoplaptopservice.services.ImageService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Images> getAllImage(){
        return imageRepository.findByIsDeletedFalse();
    }

    @Override
    public Page<Images> getImagePaging(Pageable pageable) {
        return imageRepository.findAll(pageable);
    }

    @Override
    public Optional<Images> getImageById(Integer id) {
        return imageRepository.findById(id);
    }

    @Override
    public List<Images> getImagesByProductId(Integer productId) {
        return imageRepository.findByProductsProductId(productId);
    }

    @Override
    public Images createImage(Images image) {
        return imageRepository.save(image);
    }

    @Override
    public Images updateImage(Integer id, Images image) {
        Images existing = imageRepository.findById(id).orElseThrow();
        // cập nhật từng field
        existing.setImageUrl(image.getImageUrl());
        existing.setProducts(image.getProducts());
        return imageRepository.save(existing);
    }

    @Override
    public void softDeleteImage(Integer id) {
        Images image = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));
        image.setDeleted(true);
        imageRepository.save(image);
    }

    @Override
    public void hardDeleteImage(Integer id) {
        imageRepository.deleteById(id);
    }


    //upload 1 ảnh
    @Override
    public Images uploadImageForProduct(Integer productId, MultipartFile file) throws Exception {
        // 1. Lấy sản phẩm từ ID
        Products product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // 2. Upload ảnh lên Cloudinary
        String url = cloudinaryService.uploadFile(file);

        // 3. Lưu thông tin ảnh vào DB
        Images image = new Images();
        image.setImageUrl(url);
        image.setProducts(product);
        image.setDeleted(false);
        return imageRepository.save(image);
    }

    //upload nhìu ảnh
    @Override
    public List<Images> uploadMultipleImages(Integer productId, MultipartFile[] files) throws Exception {
        Products product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        List<Images> savedImages = new ArrayList<>();

        for (MultipartFile file : files) {
            String url = cloudinaryService.uploadFile(file);

            Images image = new Images();
            image.setImageUrl(url);
            image.setProducts(product);
            image.setDeleted(false);
            savedImages.add(imageRepository.save(image));
        }
        return savedImages;
    }
}
