package cloveri360.api.tests.base;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    private static Properties properties;
    private static String host;
    private static String activeEmails;
    private static String errorText;
    protected static String username;
    protected static String token;

    @BeforeAll
    static void beforeAll() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/application.properties"));
        host = properties.getProperty("host", "https://api.imgur.com/3/");
        username = properties.getProperty("username");
        token = properties.getProperty("auth.token");
        activeEmails = properties.getProperty("active.emails");
        errorText = properties.getProperty("errorText");

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.BODY ); // Первый способ логирования
        RestAssured.baseURI = host;
    }
}
