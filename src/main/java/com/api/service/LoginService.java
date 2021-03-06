package com.api.service;

import com.api.core.utils.TestDataGenerator;
import com.api.pojo.Response;
import org.springframework.stereotype.Component;

@Component
public class LoginService extends BaseService {
    public Response performLogin(String userName, String password) {
        return post(LOGIN_ENDPOINT, TestDataGenerator.prepareLoginData(userName, password), Response.class);
    }
}
