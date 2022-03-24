package baseTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import java.io.IOException;

import static baseTests.Steps.changeZoom;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;
import static common.Values.*;

public class BaseTests {


//    @BeforeAll
//    @BeforeEach
//    public void cleanDbBeforeAll() {
//        login(browser);
//        cleanDbBeforeStart();
//        closeWebDriver();
//
//    }

    @BeforeEach
    public void loginBeforeEach() {
        login(browser);
        sleep(2000);
        cleanDbBeforeStart();

    }

    public void login(String browser) {
        Configuration.browser =  browser;
        open(BASE_URL);
        $(By.xpath(LOGIN_XPATH)).setValue(LOGIN);
        $(By.xpath(PASSWORD_XPATH)).setValue(PASSWORD);
        $(By.xpath(LOGIN_BUTTON)).click();
        $(By.linkText(ORGANIZATION_STRUCTURE_LINK_TEXT)).click();
        changeZoom();
    }

    public void createDepartment(String number) {

        $(By.xpath("//*[@data-id=\"" + number + "\"]/div/div[3]/button")).click();
        $(By.linkText("элемент структуры")).click();
    }

    public void createDepartmentFirstInLevel(String number) {

        $(By.xpath("//*[@data-id=\"" + number + "\"]/div/div[2]/button")).click();
        $(By.linkText("элемент структуры")).click();
    }

    public void deleteElementBase(String data_id) {
        try {
            $(By.xpath("//*[@data-id=\"" + data_id + "\"]/div/div[1]/div[1]/div/div/button")).click();
            $(By.linkText("удалить элемент")).click();
            $(By.cssSelector(".button-delete:nth-child(1)")).click();
        } catch (Exception e) {
            System.out.println("Элемент уже удален");
        }


    }

    public void cleanDb() {

        $(By.xpath("//*[@data-id=\"1\"]")).click();
        int strSize2;
        strSize2 = $$(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"]")).size();
        System.out.println("strSize = " + strSize2);
        String[] strArr = new String[strSize2];

        if(strSize2 > 1) {
            for (int i = 0; i < strSize2; i++) {
                int k = i + 1;
                strArr[i] = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][" + k + "]")).attr("data-id");
                System.out.println("strArr[i]" + strArr[i]);
            }
//            String str1 = strArr[3];
//            String str2 = strArr[4];
//            strArr[3] = str2;
//            strArr[4] = str1;
            for (int i = strSize2 - 1; i >= 0; i--) {
                String j = strArr[i];
                if(j != "1") {
                    try {
                        System.out.println(j);
                        deleteElementBase(j);
                    } catch (Exception e) {
                        System.out.println("Элемент уже удален");
                    }

                }
            }
        }

//        int strSize;
//        strSize = $$(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"]")).size();
//        System.out.println("strSizeEnd = " + strSize);
//        String[] strArr = new String[strSize];
//        String str1 = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selected selectable\"]")).attr("data-id");

//        if(strSize > 1) {
//            if(strSize > 2) {
//                for (int i = 0; i < strSize; i++) {
//                    int k = i + 1;
//                    strArr[i] = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][" + k + "]")).attr("data-id");
//                    System.out.println(strArr[i]);
//                }
//                for (int i = strSize - 1; i >= 1; i--) {
//                    String j = strArr[i];
//                    if(j != "1") {
//                        try {
//                            System.out.println(j);
//                            deleteElementBase(j);
//                        } catch (Exception e) {
//                            System.out.println("Элемент уже удален");
//                        }
//                    }
//                }
//            }
//
//            deleteElementBase(str1);
//
//        }
    }

    public void cleanDbBeforeStart() {

        int strSize2;
        strSize2 = $$(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"]")).size();
        System.out.println("strSize = " + strSize2);
        String[] strArr = new String[strSize2];

        if(strSize2 > 1) {
            for (int i = 0; i < strSize2; i++) {
                int k = i + 1;
                strArr[i] = $(By.xpath("//*[@class=\"react-flow__node react-flow__node-special selectable\"][" + k + "]")).attr("data-id");
                System.out.println("strArr[i]" + strArr[i]);
            }
            for (int i = strSize2 - 1; i >= 1; i--) {
                String j = strArr[i];
                if(j != "1") {
                    try {
                        System.out.println(j);
                        deleteElementBase(j);
                    } catch (Exception e) {
                        System.out.println("Элемент уже удален");
                    }

                }
            }
        }
    }

    @AfterEach
    public void tearDown() {
        cleanDb();
        closeWebDriver();
    }

}
