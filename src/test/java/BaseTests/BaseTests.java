package BaseTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import static common.Values.BASE_URL;

public class BaseTests {

/*    @BeforeAll
    static void setupAllureReports() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // либо для тонкой настройки:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }*/

    @BeforeAll
    public static void setupBrowser() {

        System.setProperty("selenide.browser", "firefox");
    }

    @Step("Создаем подразделение {word}")
    public void createDepartment(String word) throws IOException {
        System.out.println("Department " + word);
        open(BASE_URL);
        $(By.name("q")).setValue("Department " + word).pressEnter();
    }
}
