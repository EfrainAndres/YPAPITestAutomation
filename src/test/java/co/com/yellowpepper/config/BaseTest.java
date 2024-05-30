package co.com.yellowpepper.config;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
    public static RequestSpecification request;

    static {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        request = RestAssured.given().header("Content-Type", "application/json");
    }
}
