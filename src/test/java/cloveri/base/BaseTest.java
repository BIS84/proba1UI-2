package cloveri.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    static Properties properties;
    static String host;
    public static String elements;

    @BeforeAll
    static void beforeAll() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/application.properties"));
        host = properties.getProperty("host");
        elements = properties.getProperty("elements");

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = host;
    }
}
