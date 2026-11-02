package com.automation.tests;

import com.automation.models.UserResponse;
import com.automation.services.UserApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserApiTest {

    private UserApi userApi;

    @BeforeClass
    public void setUp() {
        userApi = new UserApi();
    }

    @Test
    public void verifyUserResponseStatusCode() {

        Response response = userApi.getUserResponse(1);

        Assert.assertEquals(
                response.getStatusCode(), 200,
                "Unexpected HTTP status code"
        );

        Assert.assertTrue(
                response.getTime() < 5000,
                "API response time exceeded 5 seconds"
        );
    }

    @Test
    public void verifyUserDetails() {

        UserResponse user = userApi.getUser(1);

        Assert.assertEquals(user.getId(), 1);
        Assert.assertEquals(user.getName(), "Leanne Graham");
        Assert.assertEquals(user.getUsername(), "Bret");
        Assert.assertEquals(user.getEmail(), "Sincere@april.biz");
    }

    @Test
    public void verifyNestedAddressDetails() {

        UserResponse user = userApi.getUser(1);

        Assert.assertNotNull(user.getAddress());
        Assert.assertEquals(
                user.getAddress().getCity(), "Gwenborough"
        );
        Assert.assertEquals(
                user.getAddress().getZipcode(), "92998-3874"
        );

        Assert.assertNotNull(user.getAddress().getGeo());
        Assert.assertEquals(
                user.getAddress().getGeo().getLat(), "-37.3159"
        );
        Assert.assertEquals(
                user.getAddress().getGeo().getLng(), "81.1496"
        );
    }

    @Test
    public void verifyCompanyDetails() {

        UserResponse user = userApi.getUser(1);

        Assert.assertNotNull(user.getCompany());
        Assert.assertEquals(
                user.getCompany().getName(), "Romaguera-Crona"
        );

        Assert.assertNotNull(
                user.getCompany().getCatchPhrase()
        );
        Assert.assertNotNull(user.getCompany().getBs());
    }
}
