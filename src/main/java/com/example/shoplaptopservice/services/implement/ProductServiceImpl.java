package com.example.shoplaptopservice.services.implement;

import com.example.shoplaptopservice.entities.Brands;
import com.example.shoplaptopservice.entities.Categories;
import com.example.shoplaptopservice.entities.Images;
import com.example.shoplaptopservice.entities.Products;
import com.example.shoplaptopservice.repositories.BrandRepository;
import com.example.shoplaptopservice.repositories.CategoryRepository;
import com.example.shoplaptopservice.repositories.ImageRepository;
import com.example.shoplaptopservice.repositories.ProductRepository;
import com.example.shoplaptopservice.services.ProductService;
import com.example.shoplaptopservice.utils.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CloudinaryService cloudinaryService;


    @Override
    public List<Products> getAllProduct() {
        return productRepository.findByProductStatusTrueAndIsDeletedFalse();
    }

    @Override
    public List<Products> getDeletedProducts() {
        return productRepository.findByIsDeletedTrue();
    }

//    @Override
//    public List<Products> getProductByStatusTrue() {
//        return productRepository.findByProductStatusTrueAndIsDeletedFalse();
//    }

    @Override
    public Page<Products> getProductPaging(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Products> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Products createProduct(Products product, MultipartFile mainImage, List<MultipartFile> subImages) {
        if (product.getBrands() == null || product.getBrands().getBrandId() == null) {
            throw new RuntimeException("Brand is required!");
        }
        Brands brand = brandRepository.findById(product.getBrands().getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found!"));

        if (product.getCategories() == null || product.getCategories().getCategoryId() == null) {
            throw new RuntimeException("Category is required!");
        }
        Categories category = categoryRepository.findById(product.getCategories().getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found!"));

        product.setBrands(brand);
        product.setCategories(category);
        product.setDeleted(false);

        //lưu product trước
        Products savedProduct = productRepository.save(product);
        //lưu ảnh chính
        if (mainImage != null && !mainImage.isEmpty()) {
            try {
                String url = cloudinaryService.uploadFile(mainImage);
                Images img = new Images();
                img.setImageUrl(url);
                img.setMain(true);
                img.setDeleted(false);
                img.setProducts(savedProduct);
                imageRepository.save(img);
            } catch (IOException e) {
                throw new RuntimeException("Upload main image failed: " + e.getMessage(), e);
            }
        }
        //lưu ảnh phụ
        if (subImages != null && !subImages.isEmpty()) {
            for (MultipartFile file : subImages) {
                if (file != null && !file.isEmpty()) {
                    try {
                        String url = cloudinaryService.uploadFile(file);
                        Images img = new Images();
                        img.setImageUrl(url);
                        img.setMain(false);
                        img.setDeleted(false);
                        img.setProducts(savedProduct);
                        imageRepository.save(img);
                    } catch (IOException e) {
                        throw new RuntimeException("Upload sub image failed: " + e.getMessage(), e);
                    }
                }
            }
        }

        return savedProduct;
    }

    @Override
    public Products updateProduct(Integer id, Products product, MultipartFile mainImage, List<MultipartFile> subImages) {
        Products existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // cập nhật field cơ bản
        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductPrice(product.getProductPrice());
        existingProduct.setProductDetail(product.getProductDetail());
        existingProduct.setProductDescription(product.getProductDescription());
        existingProduct.setProductQuantity(product.getProductQuantity());
        existingProduct.setProductStatus(product.getProductStatus());

        // kiểm tra brand
        if (product.getBrands() != null && product.getBrands().getBrandId() != null) {
            Brands brand = brandRepository.findById(product.getBrands().getBrandId())
                    .orElseThrow(() -> new RuntimeException("Brand not found"));
            existingProduct.setBrands(brand);
        }

        // kiểm tra category
        if (product.getCategories() != null && product.getCategories().getCategoryId() != null) {
            Categories category = categoryRepository.findById(product.getCategories().getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            existingProduct.setCategories(category);
        }

        // Xử lý ảnh chính (mainImage)
        if (mainImage != null && !mainImage.isEmpty()) {
            // Chỉ xóa ảnh chính cũ khi có ảnh chính mới
            List<Images> oldMainImages = imageRepository.findByProductsAndIsMain(existingProduct, true);
            for (Images img : oldMainImages) {
                img.setDeleted(true);
                imageRepository.save(img);
            }

            try {
                String url = cloudinaryService.uploadFile(mainImage);
                Images newMain = new Images();
                newMain.setImageUrl(url);
                newMain.setMain(true);
                newMain.setDeleted(false);
                newMain.setProducts(existingProduct);
                imageRepository.save(newMain);
            } catch (IOException e) {
                throw new RuntimeException("Upload new main image failed: " + e.getMessage(), e);
            }
        }

        // Xử lý ảnh phụ (subImages)
        if (subImages != null) {
            boolean hasNewSubs = subImages.stream().anyMatch(file -> file != null && !file.isEmpty());
            if (hasNewSubs) {
                // Chỉ xóa ảnh phụ cũ khi thực sự có ảnh phụ mới
                List<Images> oldSubs = imageRepository.findByProductsAndIsMain(existingProduct, false);
                for (Images img : oldSubs) {
                    img.setDeleted(true);
                    imageRepository.save(img);
                }

                for (MultipartFile file : subImages) {
                    if (file != null && !file.isEmpty()) {
                        try {
                            String url = cloudinaryService.uploadFile(file);
                            Images newSub = new Images();
                            newSub.setImageUrl(url);
                            newSub.setMain(false);
                            newSub.setDeleted(false);
                            newSub.setProducts(existingProduct);
                            imageRepository.save(newSub);
                        } catch (IOException e) {
                            throw new RuntimeException("Upload sub image failed: " + e.getMessage(), e);
                        }
                    }
                }
            }
            // Nếu subImages != null nhưng toàn bộ file rỗng → giữ nguyên ảnh phụ cũ
        }

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Integer id) {
        Products product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        // Xóa mềm
        product.setDeleted(true);
        product.setProductStatus(false);
        productRepository.save(product);
    }

    public void deleteProductForever(Integer id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id); // xóa cứng khỏi DB
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
