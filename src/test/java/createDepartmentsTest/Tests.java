package createDepartmentsTest;

import BaseTests.BaseTests;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static common.Values.BASE_URL;

public class Tests extends BaseTests {

    @DisplayName("Create Departments Levels 1 - 5")
    @Test
    void createDepartmentsLevels_1_5() {
        openPage();
        changeZoom();
        createDepartmentLevels_1_5();
        wait_5_sec();
        shouldInput();
    }

    @DisplayName("Create Departments Level 1")
    @Test
    void createDepartmentsLevel_1() {
        openPage();
        changeZoom();
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("0");
        wait_5_sec();
        shouldInput();
    }

    @DisplayName("Create Departments Level 5")
    @Test
    void createDepartmentsLevel_5() {
        openPage();
        changeZoom();
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("4");
        wait_5_sec();
        shouldInput();
    }

    @DisplayName("Create Departments Level 2")
    @Test
    void createDepartmentsLevel_2() {
        openPage();
        changeZoom();
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("1");
        wait_5_sec();
        shouldInput();
    }

    @DisplayName("The Test Should Fail ")
    @Test
    void createDepartmentLevel_1() {
        openPage();
        changeZoom();
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("1");
        createDepartmentLevel_N("6");
        createDepartmentLevel_N("11");

        wait_5_sec();
//        shouldInput();
        shouldInputFailed();
        }
}

