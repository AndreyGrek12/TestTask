package requests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class DiskRequests extends BaseRequest{
    public static void createFolder(String folderName) {
        given()
                .spec(baseRequest)
                .queryParam("path", "/" + folderName)
        .when()
                .put()
        .then()
                .assertThat()
                .statusCode(201)
                .body("method", equalTo("GET"))
                .body("href", notNullValue())
                .body("templated", equalTo(false));
    }

    public static void copyFile(String folderName) {
        given()
                .spec(baseRequest)
                .queryParam("from", "/Файл для копирования.docx")
                .queryParam("path", "/" + folderName + "/Файл для копирования.docx")
        .when()
                .post("/copy")
        .then()
                .assertThat()
                .statusCode(201)
                .body("method", equalTo("GET"))
                .body("href", notNullValue())
                .body("templated", equalTo(false));
    }

    public static void renameFile(String folderName) {
        given()
                .spec(baseRequest)
                .queryParam("from", "/" + folderName + "/Файл для копирования.docx")
                .queryParam("path", "/" + folderName + "/Новое имя.docx")
        .when()
                .post("/move")
        .then()
                .assertThat()
                .statusCode(201)
                .body("method", equalTo("GET"))
                .body("href", notNullValue())
                .body("templated", equalTo(false));
    }

    public static void deleteFolder(String filePath) {
        given()
                .spec(baseRequest)
                .queryParam("path", filePath)
        .when()
                .delete()
        .then()
                .assertThat()
                .statusCode(202)
                .body("method", equalTo("GET"))
                .body("href", notNullValue())
                .body("templated", equalTo(false));
    }
}
