package baseTests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static common.Values.BASE_URL;
import static common.Values.STRUCTURE_PAGE;

public class Steps extends BaseTests {

    @Step("Изменить размер")
    public static void changeZoom() {
        Selenide.zoom(0.5);
    }

    @Step("Создать департамент")
    public String createDepartmentOne(String number) {

        createDepartmentFirstInLevel(number);
        String id1 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][1]")).attr("data-id");
        System.out.println(id1);
        return id1;
    }

    @Step("Создать департаменты уровней 1 - 5")
    public String createDepartmentLevels_1_5() {
        createDepartmentFirstInLevel("1");
        String id1 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][1]")).attr("data-id");
        createDepartmentFirstInLevel(id1);
        String id2 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][2]")).attr("data-id");
        createDepartmentFirstInLevel(id2);
        String id3 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][3]")).attr("data-id");
        createDepartmentFirstInLevel(id3);
        String id4 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][4]")).attr("data-id");
        createDepartmentFirstInLevel(id4);
        String id5 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][4]")).attr("data-id");

        return id1;
    }

    @Step("Создать департаменты уровня N")
    public String createDepartmentLevel_N(Integer level) {
        createDepartmentFirstInLevel("1");
        String id1 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][1]")).attr("data-id");
        createDepartmentFirstInLevel(id1);
        String id2 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][2]")).attr("data-id");
        createDepartmentFirstInLevel(id2);
        String id3 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][3]")).attr("data-id");
        createDepartmentFirstInLevel(id3);
        String id4 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][4]")).attr("data-id");
        createDepartmentFirstInLevel(id4);
        String id5 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][5]")).attr("data-id");
        String n = null;
        if(level == 1) { n = id1; }
        if(level == 5) { n = id5; }
        if(level == 3) { n = id3; }
        createDepartment(n);
        sleep(200);
        String id6 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][5]")).attr("data-id");
        createDepartment(id6);
        sleep(200);
        String id7 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][6]")).attr("data-id");
        createDepartment(id7);
        sleep(200);
        String id8 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][7]")).attr("data-id");
        createDepartment(id8);
        sleep(200);
        String id9 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][8]")).attr("data-id");
        createDepartment(id9);
        sleep(200);
        String id10 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][9]")).attr("data-id");

        return id1;
    }

    @Step("Подождать 2 сек")
    public void wait_2_sec() {
        sleep(2000);
    }

    @Step("Проверить значение поля 'input'")
    public void shouldInput(String id, String text) {
        $(By.xpath("//*[@data-id=\"" + id + "\"]/div/div[1]/form/input")).should(Condition.value(text));
    }

    @Step("Проверить название компании")
    public void shouldInputId_1(String id, String text) {
        $(By.xpath("//*[@data-id=\"" + id + "\"]/div/div[1]/form/input")).should(Condition.value(text));
    }

    @Step("Удалить элемент структуры")
    public void deleteElement(String data_id) {
        try {
            $(By.xpath("//*[@data-id=\"" + 1 + "\"]")).click();
            $(By.xpath("//*[@data-id=\"" + data_id + "\"]/div/div[1]/form/div/div/button")).click();
            $(By.linkText("удалить элемент")).click();
            $(By.cssSelector(".button-delete:nth-child(1)")).click();
        }catch (Exception e) {
            System.out.println("Элемент уже удален");
        }
        sleep(200);
    }


}
