package Tests;

import baseTests.Steps;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import io.qameta.allure.Description;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CreateElementsTests extends Steps {

    @RegisterExtension
    static ScreenShooterExtension screenshotEmFailed = new ScreenShooterExtension(false).to("target/screenshots");

    @Description("Create Departments Levels 1 - 5")
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    void createDepartmentsLevels_1_5(String browser) {

        String id;
        id = createDepartmentLevels_1_5();
        deleteElement(id);
    }

    @Description("Create Departments Level 1")
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    void createDepartmentsLevel_1(String browser) {
        String id;
        id = createDepartmentLevel_N(1);
        shouldInput(id, "Управление 1");
        deleteElement(id);
    }

    @Description("Create Departments Level 5")
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    void createDepartmentsLevel_5(String browser) {
        String id;
        id = createDepartmentLevel_N(5);
        shouldInput(id, "Управление 1");
        deleteElement(id);
    }

    @Description("Create Departments Level 3")
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    void createDepartmentsLevel_2(String browser) {
        String id;
        id = createDepartmentLevel_N(3);
        shouldInput(id, "Управление 1");
        deleteElement(id);
    }

/*    @Description("Этот тест должен упасть")
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})@Test
    void createDepartmentLevel_1(String browser) {
        String is;
        id = createDepartmentLevels_1_5();
        createDepartmentLevel_N(1);
        createDepartmentLevel_N(6);
        createDepartmentLevel_N(11);
//        wait_2_sec();
//        shouldInput(id, "Управление 1");
        shouldInputFailed(id, "Управление 1");
    }*/

    @Description("Проверка авторизации")
    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    void authorization(String browser) {

        shouldInputId_1("1", "Company");
    }

}

