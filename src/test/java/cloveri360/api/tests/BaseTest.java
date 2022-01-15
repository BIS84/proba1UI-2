package cloveri360.api.tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.hamcrest.Matchers.lessThan;

public abstract class BaseTest { // делаем класс абстрактным. Нельзя создать такой объект, но тестовые классы будут его наследовать, что бы избежать повторения кода. Все, что повторяется в дочерних классах, переносим в класс родитель.

    protected static Properties properties; // protected - видна из разных пакетов. Если пакет один, то не надо указывать, по умолчанию так и будет
    protected static String host;
    protected static String activeEmails;
    protected static String errorText;
    protected static String username;
    protected static String token;
    protected static String xpathImageHD;
    protected static String imageDeleteHash;

    protected static ResponseSpecification responseSpecification;
//    protected static RequestSpecification requestSpecification;

    @BeforeAll
    public static void beforeAll() throws IOException {

        responseSpecification = new ResponseSpecBuilder() // Builder - вспомогательный класс, который содержит огромное количество методов. В том числе, проверка того, что содержит Response
                .expectResponseTime(lessThan(10000l)) // Проверка, что время ожидания не более, чем
                .expectStatusCode(200)
                .expectBody("success", Matchers.is(true))
                .build(); // Этим билд всегда заканчивается. Команда записать все это в объект.
//        RestAssured.responseSpecification = responseSpecification;


        properties = new Properties(); // создаем проперти
        properties.load(new FileInputStream("src/test/resources/application.properties")); // загружаем файл. Напрямую не можем, поэтому через стрим. Возможно будет достаточно только "application.properties"
        host = properties.getProperty("host", "https://api.imgur.com/3"); // здесь "https://api.imgur.com/3/" не нужно, т.к. есть в проперти. Но если нет, то можно так.
        username = properties.getProperty("username");
        token = properties.getProperty("auth.token");
        activeEmails = properties.getProperty("active.emails");
        errorText = properties.getProperty("errorText");
        xpathImageHD = properties.getProperty("xpathImageHD");


        RestAssured.baseURI = host; // baseURI это свойство. Позволяет не писать везде host+ Т.е. вместо (host + "username") пишем ("username")
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(); // Первый способ логирования

/*        requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization", token) // авторизацию во всех запросах вынесли сюда
                .build();*/

        RestAssured.responseSpecification = responseSpecification;
//        RestAssured.requestSpecification = requestSpecification;

    }
}