package com.api.test;

import com.api.core.config.TestSpringConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest(classes = TestSpringConfig.class)
public class BaseTest extends AbstractTestNGSpringContextTests {
}
