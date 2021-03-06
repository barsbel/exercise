package com.api.pojo;

import lombok.Builder;

@Builder
public class Registration {
    private final String apiVersion;
    private final int partnerId;
    private final User user;
    private final String password;
}
