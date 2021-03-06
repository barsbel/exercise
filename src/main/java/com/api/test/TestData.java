package com.api.test;

import java.util.Random;

public class TestData {
    public static final String API_VERSION = "5.3.0";
    public static final int PARTNER_ID = 3197;
    public static final String USER_OBJECT_TYPE = "KalturaOTTUser";
    public static final String USER_FIRST_NAME = "ott_user_lWkiwzTJJGYI";
    public static final String USER_LAST_NAME = "1585130417330";
    public static final String USER_EMAIL = "QATest_1585130417313@mailinator.com";
    public static final String USER_ADDRESS = "ott_user_lWkiwzTJJGYI fake address";
    public static final String USER_CITY = "ott_user_lWkiwzTJJGYI fake city";
    public static final int COUNTRY_ID = 5;

    private TestData() {
    }

    public String generateUserName() {
        Random random = new Random();
        return "User" + random.nextInt(Integer.MAX_VALUE);
    }
}
