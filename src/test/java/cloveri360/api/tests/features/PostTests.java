package cloveri360.api.tests.features;

import cloveri360.api.tests.base.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PostTests extends BaseTest {

    String imageDeleteHash;

    @DisplayName("Проверка, что картинка HD загружается")
    @ParameterizedTest
    @ValueSource(strings = {"bmp", "jpg", "png", "tif"})
    void uploadImageFileTestHdBmp(String word) {

        imageDeleteHash = given()
                .body(new File("src/test/resources/images/HD/HD." + word))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @AfterEach
    void tearDown() {

        given()
                .when()
                .delete("image/{imageHash}", imageDeleteHash)
                .then()
                .statusCode(200);
    }
}
