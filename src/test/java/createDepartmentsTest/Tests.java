package createDepartmentsTest;

import BaseTests.BaseTests;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static common.Values.BASE_URL;
import static common.Values.STRUCTURE_PAGE;

public class Tests extends BaseTests {

    @RegisterExtension
    static ScreenShooterExtension screenshotEmFailed = new ScreenShooterExtension(false).to("target/allure-results/screenshots");

    @Description("Create Departments Levels 1 - 5")
    @Test
    void createDepartmentsLevels_1_5() {
        $(By.linkText("Организационная структура")).click();
        createDepartmentLevels_1_5();
        wait_2_sec();
        shouldInput();
    }

    @Description("Create Departments Level 1")
    @Test
    void createDepartmentsLevel_1() {
        $(By.linkText("Организационная структура")).click();
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("0");
        wait_2_sec();
        shouldInput();
    }

    @Description("Create Departments Level 5")
    @Test
    void createDepartmentsLevel_5() {
        $(By.linkText("Организационная структура")).click();
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("4");
        wait_2_sec();
        shouldInput();
    }

    @Description("Create Departments Level 2")
    @Test
    void createDepartmentsLevel_2() {
        $(By.linkText("Организационная структура")).click();
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("1");
        wait_2_sec();
        shouldInput();
    }

    @Description("Этот тест должен упасть")
    @Test
    void createDepartmentLevel_1() {
        open(BASE_URL);
        $(By.xpath("/html/body/div/div/div/div[1]/form/div[1]/input")).setValue("demo@cloveri.com");
        $(By.xpath("/html/body/div/div/div/div[1]/form/div[3]/input")).setValue("jAamqBf2uPoS");
        $(By.xpath("/html/body/div/div/div/div[1]/form/div[5]/button")).click();
        $(By.linkText("Организационная структура")).click();
        changeZoom();
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("1");
        createDepartmentLevel_N("6");
        createDepartmentLevel_N("11");
        wait_2_sec();
//        shouldInput();
        shouldInputFailed();
    }

    @Test
    void authorization() {
        $(By.linkText("Организационная структура")).click();
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("1");
        createDepartmentLevel_N("6");
        createDepartmentLevel_N("11");
        wait_2_sec();
        shouldInput();
    }
}

