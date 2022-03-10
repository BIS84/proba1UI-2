package cloveri.positiveTests;

import cloveri.base.Steps;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PositivePostTests extends Steps {

    String id;

    @Test
    @Description("Создать элемент")
    void postPositiveTest() {
        createElement("www.comp_post_request.com", 1, "Dep_1");
        id = getStructure();

    }

    @Test
    @Description("Создать элементы уровней 1 - 5")
    void postCreateElementsLevels_1_5() {
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_1_1 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_1_1, "Dep_2");
        Integer element_int_id_1_1_1 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_1_1_1, "Dep_3");
        Integer element_int_id_1_1_1_1 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_1_1_1_1, "Dep_4");
        Integer element_int_id_1_1_1_1_1 = new Integer(id);
        createElement("www.comp_post_request.com", element_int_id_1_1_1_1_1, "Dep_5");
        id = getStructure();

    }

    @Test
    @Description("Создать элементы уровня 1")
    void postCreateElementsLevel_1() {
        createElement("www.comp_post_request.com", 1, "Dep_1");
        createElement("www.comp_post_request.com", 1, "Dep_2");
        createElement("www.comp_post_request.com", 1, "Dep_3");
        createElement("www.comp_post_request.com", 1, "Dep_4");
        createElement("www.comp_post_request.com", 1, "Dep_5");
        createElement("www.comp_post_request.com", 1, "Dep_6");
        createElement("www.comp_post_request.com", 1, "Dep_7");
        createElement("www.comp_post_request.com", 1, "Dep_8");
        createElement("www.comp_post_request.com", 1, "Dep_9");
        createElement("www.comp_post_request.com", 1, "Dep_10");
        id = getStructure();

    }

    @Test
    @Description("Создать элементы уровня 5")
    void postCreateElementsLevel_5() {
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_1_1 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_1_1, "Dep_2");
        Integer element_int_id_1_1_1 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_1_1_1, "Dep_3");
        Integer element_int_id_1_1_1_1 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_1_1_1_1, "Dep_4");
        Integer element_int_id_1_1_1_1_1 = new Integer(id);
        createElement("www.comp_post_request.com", element_int_id_1_1_1_1_1, "Dep_5.1");
        createElement("www.comp_post_request.com", element_int_id_1_1_1_1_1, "Dep_5.2");
        createElement("www.comp_post_request.com", element_int_id_1_1_1_1_1, "Dep_5.3");
        createElement("www.comp_post_request.com", element_int_id_1_1_1_1_1, "Dep_5.4");
        createElement("www.comp_post_request.com", element_int_id_1_1_1_1_1, "Dep_5.5");
        createElement("www.comp_post_request.com", element_int_id_1_1_1_1_1, "Dep_5.6");
        createElement("www.comp_post_request.com", element_int_id_1_1_1_1_1, "Dep_5.7");
        createElement("www.comp_post_request.com", element_int_id_1_1_1_1_1, "Dep_5.8");
        createElement("www.comp_post_request.com", element_int_id_1_1_1_1_1, "Dep_5.9");
        createElement("www.comp_post_request.com", element_int_id_1_1_1_1_1, "Dep_5.10");
        id = getStructure();

    }

    @Test
    @Description("Создать элементы уровня 3")
    void postCreateElementsLevel_3() {
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_1_1 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_1_1, "Dep_2");
        Integer element_int_id_1_1_1 = new Integer(id);
        createElement("www.comp_post_request.com", element_int_id_1_1_1, "Dep_3.1");
        createElement("www.comp_post_request.com", element_int_id_1_1_1, "Dep_3.2");
        createElement("www.comp_post_request.com", element_int_id_1_1_1, "Dep_3.3");
        createElement("www.comp_post_request.com", element_int_id_1_1_1, "Dep_3.4");
        createElement("www.comp_post_request.com", element_int_id_1_1_1, "Dep_3.5");
        createElement("www.comp_post_request.com", element_int_id_1_1_1, "Dep_3.6");
        createElement("www.comp_post_request.com", element_int_id_1_1_1, "Dep_3.7");
        createElement("www.comp_post_request.com", element_int_id_1_1_1, "Dep_3.8");
        createElement("www.comp_post_request.com", element_int_id_1_1_1, "Dep_3.9");
        createElement("www.comp_post_request.com", element_int_id_1_1_1, "Dep_3.10");
        id = getStructure();

    }

    @AfterEach
    protected void tearDown() {
        cleanDB();
    }

    @AfterAll
    protected static void cleanFile() {
        cleanFileIdForDelete();
    }

}
