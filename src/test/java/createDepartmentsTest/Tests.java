package createDepartmentsTest;

import BaseTests.BaseTests;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class Tests extends BaseTests {

    @RegisterExtension
    static ScreenShooterExtension screenshotEmFailed = new ScreenShooterExtension(false).to("target/allure-results/screenshots");

    @Description("Create Departments Levels 1 - 5")
    @Test
    void createDepartmentsLevels_1_5() {
        openPage();
        changeZoom();
        createDepartmentLevels_1_5();
        wait_2_sec();
        shouldInput();
    }

    @Description("Create Departments Level 1")
    @Test
    void createDepartmentsLevel_1() {
        openPage();
        changeZoom();
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("0");
        wait_2_sec();
        shouldInput();
    }

    @Description("Create Departments Level 5")
    @Test
    void createDepartmentsLevel_5() {
        openPage();
        changeZoom();
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("4");
        wait_2_sec();
        shouldInput();
    }

    @Description("Create Departments Level 2")
    @Test
    void createDepartmentsLevel_2() {
        openPage();
        changeZoom();
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("1");
        wait_2_sec();
        shouldInput();
    }

    @Description("The Test Should Fail ")
    @Test
    void createDepartmentLevel_1() {
        openPage();
        changeZoom();
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("1");
        createDepartmentLevel_N("6");
        createDepartmentLevel_N("11");
        wait_2_sec();
//        shouldInput();
        shouldInputFailed();
    }
}

