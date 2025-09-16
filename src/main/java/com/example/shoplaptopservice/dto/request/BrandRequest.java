package com.example.shoplaptopservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandRequest {

    @NotBlank(message = "Brand name is required")
    private String brandName;

    @NotNull(message = "Brand status is required")
    private Boolean brandStatus;
}
