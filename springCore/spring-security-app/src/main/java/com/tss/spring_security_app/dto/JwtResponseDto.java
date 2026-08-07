package com.tss.spring_security_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponseDto {

    private String accessToken;

    private String tokenType = "Bearer";

    public JwtResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }
}