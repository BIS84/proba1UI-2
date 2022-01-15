package cloveri360.api.tests;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

class GetTests extends BaseTest {

    @Test
    void getAccountTest() {

        given()
                .header("Authorization", token)
                .log()
                .ifValidationFails()
                .expect()
//                .body("success", CoreMatchers.is(true)) // Перенесли в responseSpecification
                .body("data.url", CoreMatchers.equalTo(username))
                .when()
                .get("/account/" + username)// ("/account/{username}", username) так лучше, работает быстрее, чем конкатинация (сложение) строк
                .prettyPeek();
//                .then()
//                .statusCode(200);
    }
}