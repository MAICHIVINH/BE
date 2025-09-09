package com.example.shoplaptopservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "brands")
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "brand_status")
    private Boolean brandStatus;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Boolean getBrandStatus() {
        return brandStatus;
    }

    public void setBrandStatus(Boolean brandStatus) {
        this.brandStatus = brandStatus;
    }
}
