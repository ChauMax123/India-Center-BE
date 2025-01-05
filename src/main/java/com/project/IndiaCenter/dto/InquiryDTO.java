package com.project.IndiaCenter.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InquiryDTO {


    @NotNull(message = "User name cannot be null")
    private String from_name;

    @NotNull(message = "Message cannot be null")
    @Size(min = 10, max = 500, message = "Message must be between 10 and 500 characters")
    private String message;

    private String phone;
    private String from_email;
    private String subject;

}
