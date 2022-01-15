package cloveri360.api.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class DeleteImageTests extends BaseTest {

    @BeforeEach
    void setUp() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File(xpathImageHD + "png"))
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void deleteExistentImageTest() {
        given()
                .header("Authorization", token)
                .when()
                .delete("/image/{imageHash}", imageDeleteHash)
                .prettyPeek()
                .then()
                .statusCode(200);
    }
}
