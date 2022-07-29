package requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

abstract class BaseRequest {

    static {
        RestAssured.baseURI = "https://cloud-api.yandex.net/v1/disk/resources";
    }

    static RequestSpecification baseRequest =
            given()
                    .contentType(ContentType.JSON)
                    .header("Authorization", "OAuth AQAAAABjaOHaAADLW0d9OV12g018tQ0TYruN544");
}
