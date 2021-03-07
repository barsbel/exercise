package com.api.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_OK;

@Component
public class BaseService {
    private static final String BASE_URL = "https://api.frs1.ott.kaltura.com/api_v3/service/ottuser/action";

    public final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .setAccept(ContentType.JSON)
            .setContentType(JSON)
            .build();

    public final ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(SC_OK)
            .build();

    protected <T> T post(String endpoint, Object requestBody, Class<T> responseClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String body;
        try {
            body = objectMapper.writeValueAsString(requestBody);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Unable to process a Json");
        }
        return given()
                .spec(requestSpec)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .spec(responseSpec)
                .log().all()
                .extract()
                .as(responseClass);
    }
}
