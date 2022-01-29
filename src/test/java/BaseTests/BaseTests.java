package BaseTests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BaseTests {

    @Step
    public void createDepartment(String number) {
//        Selenide.zoom(100);
        $(By.xpath("//*[@data-id=" + number + "]/div/button")).click();
        $(By.linkText("элемент структуры")).click();
    }

    public void createDepartmentLevels_1_5() {
        createDepartment("0");
        createDepartment("1");
        createDepartment("2");
        createDepartment("3");
        createDepartment("4");
    }

    public void createDepartmentLevel_N(String level) {
        createDepartment(level);
        createDepartment(level);
        createDepartment(level);
        createDepartment(level);
        createDepartment(level);
    }
}

