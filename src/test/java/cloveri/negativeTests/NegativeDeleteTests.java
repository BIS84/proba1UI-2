package cloveri.negativeTests;

import io.restassured.RestAssured;
import cloveri.base.Steps;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class NegativeDeleteTests extends Steps {

    String id;

//    @Test
//    void deleteElementWithChildren() {
//
//        id = createElement("www.comp_post_request.com", 1, "Dep_1");
//        Integer element_int_id_1 = new Integer(id);
//        id = createElement("www.comp_post_request.com", 1, "Dep_1");
//        Integer element_int_id_2 = new Integer(id);
//        id = createElement("www.comp_post_request.com", element_int_id_2, "Dep_2");
//        Integer element_int_id_3 = new Integer(id);
//        id = createElement("www.comp_post_request.com", element_int_id_3, "Dep_3");
//        Integer element_int_id_4 = new Integer(id);
//        id = createElement("www.comp_post_request.com", element_int_id_4, "Dep_4");
//        Integer element_int_id_5 = new Integer(id);
//        id = createElement("www.comp_post_request.com", element_int_id_5, "Dep_5");
//        Integer element_int_id_6 = new Integer(id);
//        deleteElement(element_int_id_3.toString());
//        deleteElement(element_int_id_6.toString());
//        deleteElement(element_int_id_5.toString());
//        deleteElement(element_int_id_4.toString());
//        deleteElement(element_int_id_3.toString());
//        deleteElement(element_int_id_2.toString());
//        deleteElement(element_int_id_1.toString());
//        id = getStructure();
//
////        String s = id;
////        String s1 = element_int_id_3 + "\n" + element_int_id_2;
////        assert s.equals(s
//    }

    @AfterEach
    protected void tearDown() {
        cleanDB();
        cleanFileIdForDelete();
    }

}
