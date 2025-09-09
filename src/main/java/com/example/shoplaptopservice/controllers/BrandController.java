package com.example.shoplaptopservice.controllers;

import com.example.shoplaptopservice.entities.Brands;
import com.example.shoplaptopservice.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/all")
    public List<Brands> getAllBrand() {
        return brandService.getAllBrand();
    }

    @GetMapping("/page")
    public Page<Brands> getBrandPaging(@RequestParam int page, @RequestParam int size) {
        return brandService.getBrandPaging(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Optional<Brands> getBrandById(@PathVariable Integer id) {
        return brandService.getBrandById(id);
    }

    @PostMapping("/add")
    public String createBrand(@RequestBody Brands brand) {
        brandService.createBrand(brand);
        return "Brand created successfully!";
    }

    @PutMapping("/update/{id}")
    public String updateBrand(@PathVariable Integer id, @RequestBody Brands brand) {
        brandService.updateBrand(id, brand);
        return "Brand updated successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBrand(@PathVariable Integer id) {
        brandService.deleteBrand(id);
        return "Brand deleted successfully!";
    }

    @GetMapping("/search")
    public List<Brands> searchBrand(@RequestParam String keyword) {
        return brandService.searchBrandByBrandName(keyword);
    }

    @GetMapping("/active")
    public List<Brands> getActiveBrand() {
        return brandService.getBrandByStatusTrue();
    }
}
