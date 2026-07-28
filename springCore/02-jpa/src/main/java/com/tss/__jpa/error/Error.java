package com.tss.__jpa.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Error {

    private LocalDateTime timestamp;
    private Integer status;
    private String message;
    private String path;
}
