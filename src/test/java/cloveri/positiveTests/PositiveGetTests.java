package cloveri.positiveTests;

import cloveri.base.Steps;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class PositiveGetTests extends Steps {

    String id;
    String id1;
    String id2;

    @Test
    void getPositiveTestLevel_1() {

        id1 = createElement("www.comp_post_request.com", 1, "Dep_1");
        id2 = createElement("www.comp_post_request.com", 1, "Dep_1");
        id = getStructure();
        System.out.println("id = " + id);
        assert id.contains(id1);
        assert id.contains(id2);

    }

    @Test
    void getPositiveTestLevels_1_5() {

        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_1_1 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_1_1, "Dep_2");
        Integer element_int_id_1_1_1 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_1_1_1, "Dep_3");
        Integer element_int_id_1_1_1_1 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_1_1_1_1, "Dep_4");
        Integer element_int_id_1_1_1_1_1 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_1_1_1_1_1, "Dep_5");
        Integer element_int_id_end = new Integer(id);
        id = getStructure();
        assert id.contains(element_int_id_1_1.toString());
        assert id.contains(element_int_id_1_1_1.toString());
        assert id.contains(element_int_id_1_1_1_1.toString());
        assert id.contains(element_int_id_1_1_1_1_1.toString());
        assert id.contains(element_int_id_end.toString());

    }

    @AfterEach
    protected void tearDown() {
        cleanFileIdForDelete();
        getStructure();
        cleanDB();
    }

    @AfterAll
    protected static void cleanFile() {
        cleanFileIdForDelete();
    }

}