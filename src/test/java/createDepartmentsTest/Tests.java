package createDepartmentsTest;

import BaseTests.BaseTests;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import io.qameta.allure.Description;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static common.Values.ORGANIZATION_STRUCTURE_LINK_TEXT;

public class Tests extends BaseTests {

    @RegisterExtension
    static ScreenShooterExtension screenshotEmFailed = new ScreenShooterExtension(false).to("target/screenshots");

    @Description("Create Departments Levels 1 - 5")
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox", "opera", "edge"})
    void createDepartmentsLevels_1_5(String browser) {
        login(browser);
        createDepartmentLevels_1_5();
//        wait_2_sec();
        shouldInput();
    }

    @Description("Create Departments Level 1")
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox", "opera", "edge"})
    void createDepartmentsLevel_1(String browser) {
        login(browser);
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("0");
//        wait_2_sec();
        shouldInput();
    }

    @Description("Create Departments Level 5")
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox", "opera", "edge"})
    void createDepartmentsLevel_5(String browser) {
        login(browser);
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("4");
//        wait_2_sec();
        shouldInput();
    }

    @Description("Create Departments Level 2")
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox", "opera", "edge"})
    void createDepartmentsLevel_2(String browser) {
        login(browser);
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("1");
//        wait_2_sec();
        shouldInput();
    }

/*    @Description("Этот тест должен упасть")
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox", "opera", "edge"})@Test
    void createDepartmentLevel_1(String browser) {
        login(browser);
        createDepartmentLevels_1_5();
        createDepartmentLevel_N("1");
        createDepartmentLevel_N("6");
        createDepartmentLevel_N("11");
//        wait_2_sec();
//        shouldInput();
        shouldInputFailed();
    }*/

    @Description("Проверка авторизации")
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox", "opera", "edge"})
    void authorization(String browser) {
        login(browser);
        $(By.linkText(ORGANIZATION_STRUCTURE_LINK_TEXT))
                .should(Condition.text(ORGANIZATION_STRUCTURE_LINK_TEXT));
    }
}

