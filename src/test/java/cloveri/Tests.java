package cloveri;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Tests {
    static Properties properties;
    static String host;
    static String elements;

    @BeforeAll
    static void beforeAll() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/application.properties"));
        host = properties.getProperty("host");
        elements = properties.getProperty("elements");

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void getPositiveTest() {

        given()
//                .header("Autorization", "demo@cloveri.com", "jAamqBf2uPoS")
                .log()
                .ifValidationFails()
                .when()
                .get(elements)
                .prettyPeek()
                .then()
                .statusCode(200);
    }


}