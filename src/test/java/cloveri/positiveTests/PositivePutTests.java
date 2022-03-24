package cloveri.positiveTests;

import cloveri.base.Steps;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PositivePutTests extends Steps {

    String id;

    @Test
    @Description("Изменить 'href' и 'label' у элемента")
    void putElement() {
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_2 = new Integer(id);
        putElement("www.put_request.com", 1, "Department_1", element_int_id_2);
        getStructure();
    }

    @Test
    @Description("Изменить родителя у элемента")
    void putElements() {
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_2 = new Integer(id);
        id = createElement("www.comp_post_request.com", 1, "Dep_2");
        Integer element_int_id_3 = new Integer(id);
        putElement("www.put_request.com", 1, "Department_1", element_int_id_2);
        putElement("www.put_request.com", element_int_id_2, "Department_2", element_int_id_3);
        getStructure();
    }

    @Disabled
    @Test
    @Description("Изменить 'href' у элемента с 'id' = 1")
    void putChangeElementWithId_1_Href() {
        changeElementWithId_1_Href("www.new_href.com");
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        getStructure();
    }

    @Disabled
    @Test
    @Description("Изменить 'label' у элемента с 'id' = 1")
    void putChangeElementWithId_1_Label() {
        changeElementWithId_1_Label("NewCompany");
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        getStructure();
    }

    @AfterEach
    protected void tearDown() {
        cleanDB();
        cleanFileIdForDelete();
    }

}
