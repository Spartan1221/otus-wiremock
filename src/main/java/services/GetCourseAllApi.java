package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GetCourseAllApi extends BaseApi{

    private String path = "/cource/get/all";
    private RequestSpecification spec;

    public GetCourseAllApi() {
        this.spec = given()
                .baseUri(WIREMOCK_URL)
                .contentType(ContentType.JSON);
    }
    public Response get() {
        return getRequest(spec, path);
    }
}
