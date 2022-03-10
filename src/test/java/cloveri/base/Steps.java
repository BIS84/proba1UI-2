package cloveri.base;

import io.qameta.allure.Step;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class Steps extends BaseTest {

    /**  Позитивные шаги **/

    @Step ("Получить информацию о структуре")
    protected String getStructure() {
        String id = given()
                .log()
                .ifValidationFails()
                .expect()
                .statusCode(200)
                .when()
                .get(elements)
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("id");
//        id = delChars(id);
//        id = sortRevers(id);
//        writerFileIdForDelete(id);
        id = rewriterCsvFile(id);

        return id;

    }

    @Step ("Создать элемент")
    protected String createElement(String href, Integer parent_id, String label) {

        String id = given()
                .header("Content-Type", "application/json")
                .log()
                .ifValidationFails()
                .body("{\"element\":\r\n" +
                        "    {   \"href\": \"" + href + "\",\r\n" +
                        "        \"parent_id\": \"" + parent_id.toString() + "\",\r\n" +
                        "        \"label\": \"" + label + "\"\r\n" +
                        "            \r\n" +
                        "    }    \r\n" +
                        "}  ")
                .expect()
                .statusCode(200)
                .body("href", equalTo(href))
                .body("parent_id", equalTo(parent_id.toString()))
                .body("label", equalTo(label))
                .when()
                .post(elements)
                .prettyPeek()
                .jsonPath()
                .get("id");

        return id;

    }

    @Step("Изменить элемент")
    protected void putElement(String href, Integer parent_id, String label, Integer numberOfElement) {
       String str = "Элемент с id'" + numberOfElement.toString() + "' успешно изменен";
        given()
                .header("Content-Type", "application/json")
                .log()
                .ifValidationFails()
                .body("{\"element\":\r\n" +
                        "    {   \"href\": \"" + href + "\",\r\n" +
                        "        \"parent_id\": \"" + parent_id + "\",\r\n" +
                        "        \"label\": \"" + label + "\"\r\n" +
                        "            \r\n" +
                        "    }    \r\n" +
                        "}  ")
                .expect()
                .statusCode(200)
                .body("[0]", equalTo(str))
                .when()
                .put(elements + "{numberOfElement}/", numberOfElement.toString())
                .prettyPeek()
                .jsonPath();
    }

    @Step("Удалить элемент")
    protected void deleteElement( String numberOfElement) {

        deleteElem(numberOfElement);
    }


    //----------------------//
    /** Негативные шаги **/

    @Step ("Создать элемент. В запросе есть поле 'children'")
    protected void createElementChildren(String href, Integer parent_id, String label) {

        String id = given()
                .header("Content-Type", "application/json")
                .log()
                .ifValidationFails()
                .body("{\"element\":\r\n" +
                        "    {   \"href\": \"" + href + "\",\r\n" +
                        "        \"parent_id\": \"" + parent_id.toString() + "\",\r\n" +
                        "        \"label\": \"" + label + "\",\r\n" +
                        "        \"children\": [0]\r\n" +
                        "            \r\n" +
                        "    }    \r\n" +
                        "}  ")
                .expect()
                .statusCode(200)
                .when()
                .post(elements)
                .prettyPeek()
                .jsonPath()
                .get("id");

    }

    @Step("Изменить элемент. В запросе есть поле 'children'")
    protected void putElementChildren(String href, Integer parent_id, String label, String children, Integer numberOfElement) {
        String id = given()
                .header("Content-Type", "application/json")
                .log()
                .ifValidationFails()
                .body("{\"element\":\r\n" +
                        "    {   \"href\": \"" + href + "\",\r\n" +
                        "        \"parent_id\": \"" + parent_id + "\",\r\n" +
                        "        \"label\": \"" + label + "\",\r\n" +
                        "        \"children\": [\"" + children + "]\"\r\n" +
                        "            \r\n" +
                        "    }    \r\n" +
                        "}  ")
                .expect()
                .statusCode(200)
                .when()
                .put(elements + "{numberOfElement}/", numberOfElement.toString())
                .prettyPeek()
                .jsonPath()
                .get("id");
    }

    /** Функции **/
    // Удаление лишних символов из строки с id для удаления
    protected String delChars (String s) {
        String id;
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 4; i < s.length() - 1; i++) {

                if(s.charAt(i) !=44 && s.charAt(i) !=32) { // удаление запятых (44) и пробелов (32)
                    sb.append(s.charAt(i));
                }
                else { if(s.charAt(i) ==44) { // перевод строки вместо запятой
                    Character b = 10;
                    sb.append(b);
                }
                }
            }
            id = sb.toString();
        } catch (Exception e) {
            id = "";
            System.err.println("Нет элементов для удаления");
        }
        return id;
    }

    // Сортировка по убыванию
    public static String sortRevers(String str) {
        String id = "";
        String[] subStr;
        String delimeter = "\n"; // Разделитель
        subStr = str.split(delimeter); // Разделения строки str с помощью метода split()
        Arrays.sort(subStr, Collections.reverseOrder());
        for (String browser : subStr) {
            id = id + browser + "\n";
        }
        return id;
    }

    // Очистка .csv файла
    protected static void cleanFileIdForDelete() {

        try {
            FileWriter fstream1 = new FileWriter("src/test/resources/idForDelete.csv");// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            out1.close(); // закрываем
        } catch (Exception e) {
            System.err.println("Error in file cleaning: " + e.getMessage());
        }
    }

    // Перезапись .csv файла
    protected void writerFileIdForDelete(String id) {

        try {
            FileWriter fstream1 = new FileWriter("src/test/resources/idForDelete.csv");// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(id); // перезаписываем файл
            out1.close(); // закрываем
        } catch (Exception e) {
            System.err.println("Error in file cleaning: " + e.getMessage());
        }
    }

    public void cleanDB() {
        try {
            File file = new File("src/test/resources/idForDelete.csv");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                deleteElem(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String rewriterCsvFile(String id) {
        id = delChars(id);
        id = sortRevers(id);
        writerFileIdForDelete(id);
        return id;
    }

    protected void deleteElem(String idOfElement) {
        try {
            given()
                    .log()
                    .ifValidationFails()
                    .when()
                    .delete(elements + "{numberOfElement}/", idOfElement)
                    .prettyPeek()
                    .then()
                    .statusCode(200);
        } catch (Exception e) {
            System.out.println("При удалении элемента с id: " + idOfElement + " что-то пошло не так");
        }
    }

}

