package com.example.shoplaptopservice.services.implement;

import com.example.shoplaptopservice.dto.request.BrandRequest;
import com.example.shoplaptopservice.dto.response.BrandResponse;
import com.example.shoplaptopservice.entities.Brands;
import com.example.shoplaptopservice.repositories.BrandRepository;
import com.example.shoplaptopservice.services.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    private BrandResponse mapToResponse(Brands brand) {
        return BrandResponse.builder()
                .brandId(brand.getBrandId())
                .brandName(brand.getBrandName())
                .brandStatus(brand.getBrandStatus())
                .isDeleted(brand.getDeleted())
                .build();
    }

    @Override
    public List<BrandResponse> getAllBrand() {
        return brandRepository.findByBrandStatusTrueAndDeletedFalse()
                .stream().map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Page<BrandResponse> getBrandPaging(Pageable pageable) {
        return brandRepository.findAll(pageable).map(this::mapToResponse);
    }

    @Override
    public BrandResponse getBrandById(Integer id) {
        Brands brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));
        return mapToResponse(brand);
    }

    @Override
    public BrandResponse createBrand(BrandRequest brandRequest) {
        Brands brand = Brands.builder()
                .brandName(brandRequest.getBrandName())
                .brandStatus(brandRequest.getBrandStatus())
                .deleted(false)
                .build();

        return mapToResponse(brandRepository.save(brand));
    }

    @Override
    public BrandResponse updateBrand(Integer id, BrandRequest brandRequest) {
        Brands existing = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));

        existing.setBrandName(brandRequest.getBrandName());
        existing.setBrandStatus(brandRequest.getBrandStatus());

        return mapToResponse(brandRepository.save(existing));
    }

    @Override
    public void deleteBrand(Integer id) {
        Brands brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));
        brand.setDeleted(true);
        brand.setBrandStatus(false);
        brandRepository.save(brand);
    }

    @Override
    public void deleteBrandForever(Integer id) {
        if (!brandRepository.existsById(id)) {
            throw new RuntimeException("Brand not found with id: " + id);
        }
        brandRepository.deleteById(id);
    }

    @Override
    public List<BrandResponse> getDeletedBrands() {
        return brandRepository.findByDeletedTrue()
                .stream().map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<BrandResponse> searchBrandByBrandName(String keyword) {
        return brandRepository.findByBrandNameContainingIgnoreCase(keyword)
                .stream().map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<BrandResponse> getBrandByStatusTrue() {
        return brandRepository.findByBrandStatusTrue()
                .stream().map(this::mapToResponse)
                .collect(Collectors.toList());
    }
}
