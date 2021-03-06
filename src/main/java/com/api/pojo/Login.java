package com.api.pojo;

import lombok.Builder;

@Builder
public class Login {
    private final String apiVersion;
    private final int partnerId;
    private final String username;
    private final String password;
    private final ExtraParams extraParams;
}
