package BaseTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static common.Values.BASE_URL;

public class BaseTests {

    @Step("Открыть ЛК")
    public void openPage() {
        open(BASE_URL);
    }

    @Step("Изменить размер")
    public void changeZoom() {
        Selenide.zoom(1);
    }

//    @Step("Создать департамент")
    public void createDepartment(String number) {
//        Selenide.zoom(100);
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

    @Step("Подождать 5 сек")
    public void wait_5_sec() {
        sleep(5000);
    }

    @Step("Проверить значение поля 'input'")
    public void shouldInput() {
        $(By.xpath("//*[@data-id=" + 3 + "]/div/div/div/input")).should(Condition.value("Управление 1"));
    }

    @Step("Проверить неверное значение поля 'input'")
    public void shouldInputFailed() {
        $(By.xpath("//*[@data-id=" + 3 + "]/div/div/div/input")).should(Condition.value("Управление 2"));
    }
}

