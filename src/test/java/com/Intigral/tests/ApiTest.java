package com.Intigral.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.restful-api.dev";
    }

    @Test
    public void validateAddNewDevice() {
        String requestBody = "{\n" +
                "   \"name\": \"Apple Max Pro 1TB\",\n" +
                "   \"data\": {\n" +
                "      \"year\": 2023,\n" +
                "      \"price\": 7999.99,\n" +
                "      \"CPU model\": \"Apple ARM A7\",\n" +
                "      \"Hard disk size\": \"1 TB\"\n" +
                "   }\n" +
                "}";

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/objects");

        // Print response details for debugging
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        // Assert the status code is 201 Created
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 201 but found " + response.getStatusCode());

        // Extract response data
        String id = response.jsonPath().getString("id");
        String name = response.jsonPath().getString("name");
        String createdAt = response.jsonPath().getString("createdAt");
        int year = response.jsonPath().getInt("data.year");
        double price = response.jsonPath().getDouble("data.price");
        String cpuModel = response.jsonPath().getString("data['CPU model']");
        String hardDiskSize = response.jsonPath().getString("data['Hard disk size']");

        // Validate the added device details
        Assert.assertNotNull(id, "ID should not be null");
        Assert.assertEquals(name, "Apple Max Pro 1TB");
        Assert.assertNotNull(createdAt, "CreatedAt should not be null");
        Assert.assertEquals(year, 2023);
        Assert.assertEquals(price, 7999.99);
        Assert.assertEquals(cpuModel, "Apple ARM A7");
        Assert.assertEquals(hardDiskSize, "1 TB");
    }
}

