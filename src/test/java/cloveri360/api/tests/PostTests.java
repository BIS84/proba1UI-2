package cloveri360.api.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PostTests extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"png", "jpg"})
    void createDepartmentLevel_2Test(String word) {

        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File(xpathImageHD + word)) // в теле передаем файл. По сети передается в виде потока
                .expect()
                .statusCode(200)
                .when()
                .post("image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");

    }

    @Test
    void createDepartmentLevel_3Test() {

        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File(xpathImageHD + "bmp")) //
                .expect()
                .statusCode(201)
                .when()
                .post("image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");

    }

    @AfterEach
    void tearDown() { // название метода стандартное
        given()
                .header("Authorization", token)
                .when()
                .delete("image/{imageHash}", imageDeleteHash)
                .then()
                .statusCode(200);
    }
}