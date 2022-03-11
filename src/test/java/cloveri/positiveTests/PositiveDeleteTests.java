package cloveri.positiveTests;

import cloveri.base.Steps;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositiveDeleteTests extends Steps {

    String idStr;
    String id;

    @BeforeEach
    void cleanFile() {
        cleanFileIdForDelete();
    }

    @Test
    void deleteOneElement() {
        createElement("www.comp_post_request.com", 1, "Dep_1");
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        deleteElement(id);
        id = getStructure();

    }

    @Test
    void deleteSeveralElements() {

        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_2 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_2, "Dep_2");
        Integer element_int_id_3 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_3, "Dep_3");
        Integer element_int_id_4 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_4, "Dep_4");
        Integer element_int_id_5 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_5, "Dep_5");
        Integer element_int_id_6 = new Integer(id);
        deleteElement(element_int_id_6.toString());
        deleteElement(element_int_id_5.toString());
        deleteElement(element_int_id_4.toString());
        id = getStructure();

    }

    @AfterEach
    protected void tearDown() {
        cleanDB();
        cleanFileIdForDelete();
    }

}
