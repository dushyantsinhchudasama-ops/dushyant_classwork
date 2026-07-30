package com.tss.__jpa.dto;

import lombok.Data;

@Data
public class AddressResponseDto {

    private Long addressId;
    private String state;
    private String city;
    private Integer pincode;

}
