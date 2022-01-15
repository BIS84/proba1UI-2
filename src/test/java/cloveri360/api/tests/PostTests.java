package cloveri360.api.tests;

import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;

import static io.restassured.RestAssured.given;

class PostTests extends BaseTest {

    @DisplayName("createDepartmentLevel_2")
    @ParameterizedTest
    @ValueSource(strings = {"bmp","jpg", "png", "tif"})
    void createDepartmentLevel_2Test(String word) {

        imageDeleteHash = given()
                .header("Authorization", token) // перенесли в requestSpecification (см. BaseTest)
                .body(new File(xpathImageHD + word)) // в теле передаем файл. По сети передается в виде потока
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");

    }

    @AfterEach
    void tearDown() { // название метода стандартное
        given()
                .header("Authorization", token)
                .when()
                .delete("/image/{imageHash}", imageDeleteHash)
                .then()
                .statusCode(200);
    }
}
