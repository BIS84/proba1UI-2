package BaseTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static common.Values.*;

public class BaseTests {

    @BeforeEach
    public void login() {
        open(BASE_URL);
        $(By.xpath(LOGIN_XPATH)).setValue(LOGIN);
        $(By.xpath(PASSWORD_XPATH)).setValue(PASSWORD);
        $(By.xpath(LOGIN_BUTTON)).click();
        $(By.linkText(ORGANIZATION_STRUCTURE_LINK_TEXT)).click();
        changeZoom();
    }

    @Step("Открыть ЛК")
    public void openPage() {

        open(BASE_URL + STRUCTURE_PAGE);
    }

    @Step("Изменить размер")
    public static void changeZoom() {
        Selenide.zoom(0.5);
    }

    public void createDepartment(String number) {

        $(By.xpath("//*[@data-id=" + number + "]/div/button")).click();
        $(By.linkText("элемент структуры")).click();
    }

    @Step("Создать департаменты уровней 1 - 5")
    public void createDepartmentLevels_1_5() {
        createDepartment("0");
        createDepartment("1");
        createDepartment("2");
        createDepartment("3");
        createDepartment("4");
    }

    @Step("Создать департаменты уровня N")
    public void createDepartmentLevel_N(String level) {
        createDepartment(level);
        createDepartment(level);
        createDepartment(level);
        createDepartment(level);
        createDepartment(level);
    }

    @Step("Подождать 2 сек")
    public void wait_2_sec() {
        sleep(2000);
    }

    @Step("Проверить значение поля 'input'")
    public void shouldInput() {
        $(By.xpath("//*[@data-id=" + 3 + "]/div/div/div/input")).should(Condition.value("Управление 1"));
    }

    @Step("Проверить неверное значение поля 'input'")
    public void shouldInputFailed() {
        $(By.xpath("//*[@data-id=" + 3 + "]/div/div/div/input")).should(Condition.value("Управление 2"));
    }

    @AfterEach
    public void teardown() {
        closeWebDriver();
    }
}

