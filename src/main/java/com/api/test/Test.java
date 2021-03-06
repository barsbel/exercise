package com.api.test;

import com.api.core.config.TestSpringConfig;
import com.api.core.utils.CommonUtils;
import com.api.pojo.Response;
import com.api.service.LoginService;
import com.api.service.RegisterService;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;

import java.time.Instant;
import java.util.Random;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

@ContextConfiguration(classes = TestSpringConfig.class)
public class Test {
    private final Random random = new Random();
    //        @Autowired
    protected LoginService loginService;
    //        @Autowired
    protected RegisterService registerService;

    @BeforeClass
    public void initServices() {
        loginService = new LoginService();
        registerService = new RegisterService();
    }

    @BeforeClass
    public void prepareTestData() {
        userName = "User" + random.nextInt(Integer.MAX_VALUE);
        password = "Password" + random.nextInt(Integer.MAX_VALUE);
        id = String.valueOf(random.nextLong());
    }

    private String userName;
    private String password;
    private String id;

    @org.testng.annotations.Test(priority = 1)
    public void verifyUserRegistration() {
        Response response = registerService.createUser(userName, password, id);
        assertEquals(response.getResult().getUsername(), userName, "Username is not correct.");
        assertNotNull(response.getResult().getId(), "Id is not correct.");
        assertNotNull(response.getResult().getCountryId(), "CountryId is not correct.");
    }

    @org.testng.annotations.Test(priority = 2)
    public void verifyLogin() {
        Response response = loginService.performLogin(userName, password);
        long userLastLoginDateTimeStamp = Instant.ofEpochMilli(response.getResult().getUser().getLastLoginDate()).toEpochMilli();
        assertTrue(CommonUtils.verifyTimestampCreationIsLessThanNow(userLastLoginDateTimeStamp, Instant.now().toEpochMilli()),
                "User LastLoginDateTime is not correct.");
    }

    @org.testng.annotations.Test(priority = 3)
    public void verifyErrorMessage() {
        Response response = registerService.createUser(userName, password, id);
        assertEquals(response.getResult().getError().getMessage(),
                "User exists", "Message is not correct.");
    }
}
