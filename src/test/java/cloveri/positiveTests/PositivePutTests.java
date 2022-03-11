package cloveri.positiveTests;

import cloveri.base.Steps;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class PositivePutTests extends Steps {

    String id;

    @Test
    @Description("Изменить элемент")
    void putElement() {
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_1_1 = new Integer(id);
        putElement("www.comp_put_request.com", 1, "Department_1", element_int_id_1_1);
    }

    @Test
    @Description("Изменить элемент")
    void putElements() {
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_1_1 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_1_1, "Dep_2");
        Integer element_int_id_1_1_1 = new Integer(id);
        putElement("www.comp_put_request.com", 1, "Department_1", element_int_id_1_1);
        putElement("www.comp_put_request.com", 1, "Department_2", element_int_id_1_1_1);
        getStructure();
    }

    @AfterEach
    protected void tearDown() {
        cleanDB();
        cleanFileIdForDelete();
    }

}
