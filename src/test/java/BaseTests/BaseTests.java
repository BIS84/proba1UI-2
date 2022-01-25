package BaseTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static common.Metods.getBytes;
import static common.Values.BASE_URL;

public class BaseTests {

    @BeforeAll
    static void setupAllureReports() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // либо для тонкой настройки:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @Step("Создаем подразделение {word}")
    public void createDepartment(String word) throws IOException {
        System.out.println("Department " + word);
        open(BASE_URL);
        $(By.name("q")).setValue("Department " + word).pressEnter();
        getBytes("1643091514646.0.png");
    }
}
