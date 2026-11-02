package com.automation.base;

import com.automation.config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiClient {


    protected final RequestSpecification requestSpec;

    public ApiClient() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.get("baseURI"))
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    protected RequestSpecification request() {
        return RestAssured.given().spec(requestSpec);
    }
}
