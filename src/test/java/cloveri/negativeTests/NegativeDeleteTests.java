package cloveri.negativeTests;

import io.restassured.RestAssured;
import cloveri.base.Steps;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class NegativeDeleteTests extends Steps {

    String id;

    @Test
    void deleteElementWithId_1() {
        createElement("www.comp_post_request.com", 1, "Dep_1");
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        deleteElement_1();
        id = getStructure();

    }

    @AfterEach
    protected void tearDown() {
        cleanDB();
        cleanFileIdForDelete();
    }

}
