package com.automation.services;

import com.automation.base.ApiClient;
import com.automation.models.UserResponse;
import io.restassured.response.Response;

public class UserApi extends ApiClient {

    public Response getUserResponse(int userId) {
        return request()
                .pathParam("userId", userId)
                .when()
                .get("/users/{userId}");
    }

    public UserResponse getUser(int userId) {
        return getUserResponse(userId)
                .then()
                .statusCode(200)
                .extract()
                .as(UserResponse.class);
    }
}
