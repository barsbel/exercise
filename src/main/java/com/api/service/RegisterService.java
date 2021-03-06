package com.api.service;

import com.api.core.utils.TestDataGenerator;
import com.api.pojo.Response;
import org.springframework.stereotype.Component;

@Component
public class RegisterService extends BaseService {
    public Response createUser(String userName, String password, String id) {
        return post(REGISTER_ENDPOINT, TestDataGenerator.prepareRegistrationData(userName, password, id), Response.class);
    }
}
