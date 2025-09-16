package com.example.shoplaptopservice.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandResponse {
    private Integer brandId;
    private String brandName;
    private Boolean brandStatus;
    private Boolean isDeleted;
}
