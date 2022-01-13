package cloveri360.api.tests;

import cloveri360.api.tests.BaseTest;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class GetTests extends BaseTest {



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
                .get("account/" + username)// ("account/{username}", username) так лучше, работает быстрее, чем конкатинация (сложение) строк
                .prettyPeek()
                .then()
                .statusCode(200);
    }
}