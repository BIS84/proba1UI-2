package createDepartmentsTest;

import BaseTests.BaseTests;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;
import static common.Values.BASE_URL;

public class Tests extends BaseTests {



    @DisplayName("Create Departments Levels 1 - 5")
    @Test
    void createDepartmentsLevels_1_5() {
        open(BASE_URL);
        createDepartmentLevels_1_5();
        sleep(5000);
        $(By.xpath("//*[@data-id=" + 3 + "]/div/div/div/input")).should(Condition.value("Управление 1"));

    }

    @DisplayName("Create Departments Level 1")
    @Test
    void createDepartmentsLevel_1() {
        open(BASE_URL);
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("0");
        sleep(5000);
        $(By.xpath("//*[@data-id=" + 3 + "]/div/div/div/input")).should(Condition.value("Управление 1"));

    }

    @DisplayName("Create Departments Level 5")
    @Test
    void createDepartmentsLevel_5() {
        open(BASE_URL);
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("4");
        sleep(5000);
        $(By.xpath("//*[@data-id=" + 3 + "]/div/div/div/input")).should(Condition.value("Управление 1"));

    }

    @DisplayName("Create Departments Level 2")
    @Test
    void createDepartmentsLevel_2() {
        open(BASE_URL);
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("1");
        sleep(5000);
        $(By.xpath("//*[@data-id=" + 3 + "]/div/div/div/input")).should(Condition.value("Управление 1"));

    }

    @DisplayName("The Test Should Fail ")
    @Test
    void createDepartmentLevel_1() {
        open(BASE_URL);
        $(By.xpath("//*[@data-id=" + 0 + "]/div/button")).click();
        $(By.linkText("элемент структуры")).click();
        $(By.xpath("//*[@data-id=" + 1 + "]/div/button")).click();
        $(By.linkText("элемент структуры")).click();
        $(By.xpath("//*[@data-id=" + 2 + "]/div/button")).click();
        $(By.linkText("элемент структуры")).click();
        $(By.xpath("//*[@data-id=" + 3 + "]/div/div/div/input"))
                .should(Condition.value("Управление 2"));
        }
}

