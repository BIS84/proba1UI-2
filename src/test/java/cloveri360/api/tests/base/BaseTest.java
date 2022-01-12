package cloveri360.api.tests.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.hamcrest.number.OrderingComparison.lessThan;

public abstract class BaseTest {

    private static Properties properties;
    private static String host;
    private static String activeEmails;
    private static String errorText;
    protected static String username;
    protected static String token;

    protected static ResponseSpecification responseSpecification;
    protected static RequestSpecification requestSpecification;

    @BeforeAll
    static void beforeAll() throws IOException {

        responseSpecification = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(10000L))
//                .expectBody("status", equalTo(200))
                .build();

        properties = new Properties(); // создаем проперти
        properties.load(new FileInputStream("src/test/resources/application.properties")); // загружаем файл. Напрямую не можем, поэтому через стрим. Возможно будет достаточно только "application.properties"
        host = properties.getProperty("host", "https://api.imgur.com/3/"); // здесь "https://api.imgur.com/3/" не нужно, т.к. есть в проперти. Но если нет, то можно так.
        username = properties.getProperty("username");
        token = properties.getProperty("auth.token");
        activeEmails = properties.getProperty("active.emails");
        errorText = properties.getProperty("errorText");

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.BODY ); // Первый способ логирования
        RestAssured.baseURI = host; // baseURI это свойство. Позволяет не писать везде host+ Т.е. вместо (host + "username") пишем ("username")

        requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization", token)
                .log(LogDetail.URI)
                .log(LogDetail.METHOD)
                .build();

        RestAssured.responseSpecification = responseSpecification;
        RestAssured.requestSpecification = requestSpecification;
    }
}