package com.project.IndiaCenter.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingDTO {

    @NotNull(message = "Facility ID cannot be null")
    private Long facilityId;

    @NotNull(message = "User name cannot be null")
    private String userName;

    @NotNull(message = "End time cannot be null")
    @Future(message = "End time must be in the future")
    private LocalDateTime startTime;

    @NotNull(message = "End time cannot be null")
    @Future(message = "End time must be in the future")
    private LocalDateTime endTime;

}
