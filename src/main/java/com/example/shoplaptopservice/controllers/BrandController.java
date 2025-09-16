package com.example.shoplaptopservice.controllers;

import com.example.shoplaptopservice.dto.request.BrandRequest;
import com.example.shoplaptopservice.dto.response.BrandResponse;
import com.example.shoplaptopservice.entities.Brands;
import com.example.shoplaptopservice.services.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @GetMapping("/all")
    public List<BrandResponse> getAllBrand() {
        return brandService.getAllBrand();
    }

    @GetMapping("/deleted")
    public List<BrandResponse> getDeletedBrands() {
        return brandService.getDeletedBrands();
    }

    @GetMapping("/page")
    public Page<BrandResponse> getBrandPaging(@RequestParam int page, @RequestParam int size) {
        return brandService.getBrandPaging(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public BrandResponse getBrandById(@PathVariable Integer id) {
        return brandService.getBrandById(id);
    }

    @PostMapping("/add")
    public BrandResponse createBrand(@RequestBody BrandRequest brandRequest) {
        return brandService.createBrand(brandRequest);
    }

    @PutMapping("/update/{id}")
    public BrandResponse updateBrand(@PathVariable Integer id, @RequestBody BrandRequest brandRequest) {
        return brandService.updateBrand(id, brandRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBrand(@PathVariable Integer id) {
        brandService.deleteBrand(id);
        return "Brand deleted successfully!";
    }

    @DeleteMapping("/delete-hard/{id}")
    public String deleteBrandForever(@PathVariable Integer id) {
        brandService.deleteBrandForever(id);
        return "Brand permanently deleted!";
    }

    @GetMapping("/search")
    public List<BrandResponse> searchBrand(@RequestParam String keyword) {
        return brandService.searchBrandByBrandName(keyword);
    }

    @GetMapping("/active")
    public List<BrandResponse> getActiveBrand() {
        return brandService.getBrandByStatusTrue();
    }
}
