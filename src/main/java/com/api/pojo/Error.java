package com.api.pojo;

import lombok.Data;

@Data
public class Error {
    private String code;
    private String message;
    private String objectType;
}
