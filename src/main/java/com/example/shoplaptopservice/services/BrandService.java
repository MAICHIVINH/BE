package com.example.shoplaptopservice.services;

import com.example.shoplaptopservice.dto.request.BrandRequest;
import com.example.shoplaptopservice.dto.response.BrandResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    List<BrandResponse> getAllBrand();

    Page<BrandResponse> getBrandPaging(Pageable pageable);

    BrandResponse getBrandById(Integer id);

    BrandResponse createBrand(BrandRequest brandRequest);

    BrandResponse updateBrand(Integer id, BrandRequest brandRequest);

    void deleteBrand(Integer id);

    void deleteBrandForever(Integer id);

    List<BrandResponse> searchBrandByBrandName(String keyword);

    List<BrandResponse> getBrandByStatusTrue();

    List<BrandResponse> getDeletedBrands();
}
