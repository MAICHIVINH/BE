package com.example.shoplaptopservice.services;

import com.example.shoplaptopservice.entities.Brands;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    List<Brands> getAllBrand();

    Page<Brands> getBrandPaging(Pageable pageable);

    Optional<Brands> getBrandById(Integer id);

    Brands createBrand(Brands brand);

    Brands updateBrand(Integer id, Brands brand);

    void deleteBrand(Integer id);

    List<Brands> searchBrandByBrandName(String keyword);

    List<Brands> getBrandByStatusTrue();
}
