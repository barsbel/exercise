package com.api.core.utils;

import com.api.pojo.Login;
import com.api.pojo.Registration;
import com.api.pojo.User;

import static com.api.test.TestData.*;

public class TestDataGenerator {
    private TestDataGenerator() {
    }

    public static Registration prepareRegistrationData(String username, String password, String externalId) {
        User user = User.builder()
                .objectType(USER_OBJECT_TYPE)
                .username(username)
                .firstName(USER_FIRST_NAME)
                .lastName(USER_LAST_NAME)
                .email(USER_EMAIL)
                .address(USER_ADDRESS)
                .city(USER_CITY)
                .countryId(COUNTRY_ID).externalId(externalId)
                .build();

        return Registration.builder()
                .apiVersion(API_VERSION)
                .partnerId(PARTNER_ID)
                .user(user)
                .password(password)
                .build();
    }

    public static Login prepareLoginData(String username, String password) {
        return Login.builder()
                .apiVersion(API_VERSION)
                .partnerId(PARTNER_ID)
                .username(username)
                .password(password)
                .build();
    }
}
