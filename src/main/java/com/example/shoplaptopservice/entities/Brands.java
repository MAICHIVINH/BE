package com.example.shoplaptopservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "brands")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brands {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    @Column(name = "brand_status", nullable = false)
    private Boolean brandStatus;

    @Column(name = "is_deleted", nullable = false)
    private Boolean deleted;
}
