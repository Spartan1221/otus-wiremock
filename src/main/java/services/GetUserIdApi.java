package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GetUserIdApi extends BaseApi{

    private String path = "/user/get/{id}";
    private RequestSpecification spec;

    public GetUserIdApi() {
        this.spec = given()
                .baseUri(WIREMOCK_URL)
                .contentType(ContentType.JSON);
    }
    public Response get(String userId) {
        return getRequest(spec, path.replace("{id}", userId));
    }
}
