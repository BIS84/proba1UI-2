package createDepartmentsTest;

import BaseTests.BaseTests;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import io.qameta.allure.Description;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static common.Values.ORGANIZATION_STRUCTURE_LINK_TEXT;

public class Tests extends BaseTests {

//    @RegisterExtension
//    static ScreenShooterExtension screenshotEmFailed = new ScreenShooterExtension(false).to("target/screenshots");

    @Description("Create Departments Levels 1 - 5")
    @Test
    void createDepartmentsLevels_1_5() {

        createDepartmentLevels_1_5();
        wait_2_sec();
        shouldInput();
    }

    @Description("Create Departments Level 1")
    @Test
    void createDepartmentsLevel_1() {

        createDepartmentLevels_1_5();
        createDepartmentLevel_N("0");
        wait_2_sec();
        shouldInput();
    }

    @Description("Create Departments Level 5")
    @Test
    void createDepartmentsLevel_5() {

        createDepartmentLevels_1_5();
        createDepartmentLevel_N("4");
        wait_2_sec();
        shouldInput();
    }

    @Description("Create Departments Level 2")
    @Test
    void createDepartmentsLevel_2() {


        createDepartmentLevels_1_5();
        createDepartmentLevel_N("1");
        wait_2_sec();
        shouldInput();
    }

    @Description("Этот тест должен упасть")
    @Test
    void createDepartmentLevel_1() {


        createDepartmentLevels_1_5();
        createDepartmentLevel_N("1");
        createDepartmentLevel_N("6");
        createDepartmentLevel_N("11");
        wait_2_sec();
//        shouldInput();
        shouldInputFailed();
    }

    @Description("Проверка авторизации")
    @Test
    void authorization() {
        $(By.linkText(ORGANIZATION_STRUCTURE_LINK_TEXT))
                .should(Condition.text(ORGANIZATION_STRUCTURE_LINK_TEXT));
    }
}

