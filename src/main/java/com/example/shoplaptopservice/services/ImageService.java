package com.example.shoplaptopservice.services;

import com.example.shoplaptopservice.entities.Images;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ImageService {

    List<Images> getAllImage();

    Page<Images> getImagePaging(Pageable pageable);

    Optional<Images> getImageById(Integer id);

    List<Images> getImagesByProductId(Integer productId);

    Images createImage(Images image);

    Images updateImage(Integer id, Images image);

    // Xóa ngắn (đánh dấu isDeleted = true)
    void softDeleteImage(Integer id);

    // Xóa hẳn khỏi DB
    void hardDeleteImage(Integer id);


    //upload 1 ảnh
    Images uploadImageForProduct(Integer productId, MultipartFile file) throws Exception;

    //upload nhìu ảnh
    List<Images> uploadMultipleImages(Integer productId, MultipartFile[] files) throws Exception;
}
