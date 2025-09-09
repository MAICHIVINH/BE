package com.example.shoplaptopservice.services.implement;

import com.example.shoplaptopservice.entities.Brands;
import com.example.shoplaptopservice.repositories.BrandRepository;
import com.example.shoplaptopservice.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brands> getAllBrand() {
        return brandRepository.findAll();
    }

    @Override
    public Page<Brands> getBrandPaging(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

    @Override
    public Optional<Brands> getBrandById(Integer id) {
        return brandRepository.findById(id);
    }

    @Override
    public Brands createBrand(Brands brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brands updateBrand(Integer id, Brands brand) {
        Brands existing = brandRepository.findById(id).orElseThrow();
        // cập nhật từng field
        existing.setBrandName(brand.getBrandName());
        existing.setBrandStatus(brand.getBrandStatus());
        return brandRepository.save(existing);
    }

    @Override
    public void deleteBrand(Integer id) {
        brandRepository.deleteById(id);
    }

    @Override
    public List<Brands> searchBrandByBrandName(String keyword) {
        return brandRepository.findByBrandNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<Brands> getBrandByStatusTrue() {
        return brandRepository.findByBrandStatusTrue();
    }
}
