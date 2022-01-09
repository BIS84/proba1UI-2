package Base;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static common.Values.BASE_URL;

public class Base {
    public void createDepartment(String word) {
        System.out.println("Department " + word);
        open(BASE_URL);
        $(By.name("q")).setValue("Department " + word).pressEnter();
    }
}
