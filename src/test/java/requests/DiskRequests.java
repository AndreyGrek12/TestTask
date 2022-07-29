package requests;

import static io.restassured.RestAssured.*;

public class DiskRequests extends BaseRequest{
    public static void createFolder() {
        given()
                .spec(baseRequest)
                .queryParam("path", "/Новая папка")
        .when()
                .put()
        .then()
                .assertThat()
                .statusCode(201);
    }

    public static void copyFile () {
        given()
                .spec(baseRequest)
                .queryParam("from", "/Файл для копирования.docx")
                .queryParam("path", "/Новая папка/Файл для копирования.docx")
        .when()
                .post("/copy")
        .then()
                .assertThat()
                .statusCode(201);
    }

    public static void renameFile() {
        given()
                .spec(baseRequest)
                .queryParam("from", "/Новая папка/Файл для копирования.docx")
                .queryParam("path", "/Новая папка/Новое имя.docx")
        .when()
                .post("/move")
        .then()
                .assertThat()
                .statusCode(201);
    }

    public static void deleteFolder(String filePath, int statusCode) {
        given()
                .spec(baseRequest)
                .queryParam("path", filePath)
        .when()
                .delete()
        .then()
                .assertThat()
                .statusCode(statusCode);
    }
}
