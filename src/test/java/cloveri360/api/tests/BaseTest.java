package cloveri360.api.tests;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseTest { // делаем класс абстрактным. Нельзя создать такой объект, но тестовые классы будут его наследовать, что бы избежать повторения кода. Все, что повторяется в дочерних классах, переносим в класс родитель.

    protected static Properties properties; // protected - видна из разных пакетов. Если пакет один, то не надо указывать, по умолчанию так и будет
    protected static String host;
    protected static String activeEmails;
    protected static String errorText;
    protected static String username;
    protected static String token;
    protected static String xpathImageHD;
    protected static String imageDeleteHash;

    @BeforeAll
    static void beforeAll() throws IOException {
        properties = new Properties(); // создаем проперти
        properties.load(new FileInputStream("src/test/resources/application.properties")); // загружаем файл. Напрямую не можем, поэтому через стрим. Возможно будет достаточно только "application.properties"
        host = properties.getProperty("host", "https://api.imgur.com/3/"); // здесь "https://api.imgur.com/3/" не нужно, т.к. есть в проперти. Но если нет, то можно так.
        username = properties.getProperty("username");
        token = properties.getProperty("auth.token");
        activeEmails = properties.getProperty("active.emails");
        errorText = properties.getProperty("errorText");
        xpathImageHD = properties.getProperty("xpathImageHD");

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.BODY ); // Первый способ логирования
        RestAssured.baseURI = host; // baseURI это свойство. Позволяет не писать везде host+ Т.е. вместо (host + "username") пишем ("username")
    }
}