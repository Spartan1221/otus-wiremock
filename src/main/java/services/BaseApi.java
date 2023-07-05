package services;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseApi {

    public static final String WIREMOCK_URL = System.getProperty("baseUrl", "http://192.168.0.101:8089");


    protected ValidatableResponse post(RequestSpecification spec, Object body, String path) {
        return given(spec)
                .log().all()
                .body(body)
                .when()
                .post(path)
                .then()
                .log().all();
    }
    protected ValidatableResponse delete(RequestSpecification spec, String path) {
        return given(spec)
                .log().all()
                .when()
                .delete(path)
                .then()
                .log().all();
    }

    protected ValidatableResponse postError(RequestSpecification spec, String path) {
        return given(spec)
                .log().all()
                .when()
                .post(path)
                .then()
                .log().all();
    }

    protected Response getRequest(RequestSpecification spec, String path) {
        return given(spec)
                .log().all()
                .when()
                .get(path)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
