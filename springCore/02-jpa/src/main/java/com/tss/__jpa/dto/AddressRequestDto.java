package com.tss.__jpa.dto;

import lombok.Data;

@Data
public class AddressRequestDto {

    private String state;
    private String city;
    private Integer pincode;
}
