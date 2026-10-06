package com.tss.security_demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class RegisterRequestDto {

    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Enter valid email address")
    private String username;

    @NotBlank(message = "Password is required")
    @Length(min = 8, message = "Minimum 8 characters required")
    private String password;

}
