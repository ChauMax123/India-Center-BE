package com.project.IndiaCenter.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacilityDTO {

    private Long id;

    @NotBlank(message = "Facility name cannot be blank")
    private String name;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    private boolean available;

}
