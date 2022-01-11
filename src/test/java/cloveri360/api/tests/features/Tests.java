package cloveri360.api.tests.features;

import cloveri360.api.tests.base.BaseTest;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Tests extends BaseTest {



    @Test
    void getAccountTest() {
        given()
                .header("Authorization", token)
                .log()
                .ifValidationFails()
                .expect()
                .body("success", CoreMatchers.is(true))
                .body("data.url", CoreMatchers.equalTo(username))
                .when()
                .get("account/testprogmath")
                .prettyPeek()
                .then()
                .statusCode(200);
    }
}
