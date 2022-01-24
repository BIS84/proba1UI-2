package createDepartmentTests;

import BaseTests.BaseTests;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static common.Values.BASE_URL;

import static com.codeborne.selenide.Selenide.screenshot;

public class Tests extends BaseTests {

    @RegisterExtension
    static ScreenShooterExtension screenshotEmAll = new ScreenShooterExtension(true).to("target/screenshots");

    @Nested
//    @TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Если в классе нужны скриншоты не по общим правилам. Иначе см. BaseTests @BeforeALL static void setupAllureReports()
    public class CreateDepartmentsTests {

        @Order(1)
        @DisplayName("Create Departments 2.1 - 5.1")
        @ParameterizedTest
        @ValueSource(strings = {"2.1", "3.1", "4.1", "5.1"})
        void createDepartmentsLevels_2_5(String word) {
            createDepartment(word);
    //        String pngFileName = screenshot("my_file_name_" + word); // Если хотим сделать скриншот на каком-то определенном шаге
        }

        @Order(2)
        @Nested
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        public class CreateDepartmentsLevel_2 {

            @DisplayName("Create Departments Level 2")
            @ParameterizedTest
            @ValueSource(strings = {"2.2", "2.3", "2.4", "2.5", "2.6", "2.7", "2.8", "2.9", "2.10"})
            void createDepartmentsLevel_2(String word) {
                createDepartment(word);
            }

            @DisplayName("Create Departments Level 5")
            @ParameterizedTest
            @ValueSource(strings = {"5.2", "5.3", "5.4", "5.5", "5.6", "5.7", "5.8", "5.9", "5.10"})
            void createDepartmentsLevel_5(String word) {
                createDepartment(word);
            }

            @DisplayName("Create Departments Level 3")
            @ParameterizedTest
            @ValueSource(strings = {"3.2", "3.3", "3.4", "3.5", "3.6", "3.7", "3.8", "3.9", "3.10"})
            void createDepartmentsLevel_3(String word) {
                createDepartment(word);
            }

            @Nested
            @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
            class NegativeTests {
                @Order(1)
                @DisplayName("Negative Tests")
                @ParameterizedTest
                @ValueSource(strings = {"g", "zxc567RHMdzxc567RHMdzxc567RHMdzxc567RHMdzxc567RHMdzxc567RHMdzxc567RHMdzxc567RHMdf", "h.", "h,", "h>", "h<", "h=", "h;", "h:", "h'", "h(", "h)", "h[", "h]", "h/", "h\"", "h|", "h*", "h&", "h?", "h#", "h@", "h!", "h$", "h%", "h^", "h♣", "h☺"})
                void negativeTests(String word) {
                    System.out.println(word);
                    open(BASE_URL);
                    $(By.name("q")).setValue(word).pressEnter();
                }

                @Order(2)
                @DisplayName("Security Tests")
                @ParameterizedTest
                @ValueSource(strings = {"'", "'OR'1'='1'", "'or'1'='1'-'", "'or'1'='1'({'", "' or '1'='1'/*'", "<script>alert(\"xss!\")</script>", "<script>document.getElementByID(\"...\").disabled=true</script>", "<input onclick=\"javascript:alert('xss');\">", "<b onmouseover=\"alert('xss!')\">Hello</b>", "</body> или </body></body>", "<textarea />", "<form action=\"http://live.hh.ru\"><input type=\"submit\"></form>", "<!--", "\"${code}\";", "'';!--\"<CSS_Check>=&{()"})
                void securityTests(String word) {
                    System.out.println(word);
                    open(BASE_URL);
                    $(By.name("q")).setValue(word).pressEnter();
                }
            }
        }
    }
}
