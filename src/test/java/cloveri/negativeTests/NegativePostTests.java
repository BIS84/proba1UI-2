package cloveri.negativeTests;

import cloveri.base.Steps;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class NegativePostTests extends Steps {

    String id;

    @Disabled
    @Test
    @Description("Создать второй элемент с родителем 'null'")
    void postWithParentNull() {
        createElement("www.comp_post_request.com", null, "Element with parent 'null'");
        createElement("www.comp_post_request.com", 1, "Element control");
        id = getStructure();

    }

    @Test
    @Description("Создать элемент с лишним полем")
    void postWithExtraField() {
        createElementWithExtraField("www.comp_post_request.com", 1, "Element with extra field", "children", "[]");
        createElement("www.comp_post_request.com", 1, "Element control");
        id = getStructure();
    }

    @Test
    @Description("Создать элемент с несуществующим родителем")
    void postWithNonExistentParent() {
        createElementWithNonExistentParent("www.comp_post_request.com", 2, "Element with non-existent parent");
        createElement("www.comp_post_request.com", 1, "Element control");
        id = getStructure();
    }

    @Test
    @Description("Создать элемент без ссылки")
    void postWithoutHref() {
        createElementWithoutHref(1, "Element without href");
        createElement("www.comp_post_request.com", 1, "Element control");
        id = getStructure();
    }

    @Test
    @Description("Создать элемент без 'label'")
    void postWithoutLabel() {
        createElementWithoutLabel("www.comp_post_request.com", 1);
        createElement("www.comp_post_request.com", 1, "Element control");
        id = getStructure();
    }

    @Test
    @Description("Создать элемент без 'parent_id'")
    void postWithoutParentId() {
        createElementWithoutParentId("www.comp_post_request.com", "Element without parent_id");
        createElement("www.comp_post_request.com", 1, "Element control");
        id = getStructure();
    }

    @Test
    @Description("Создать элемент без полей")
    void postWithoutFields() {
        createElementWithoutFields();
        createElement("www.comp_post_request.com", 1, "Element control");
        id = getStructure();
    }

    @Disabled
    @Test
    @Description("Создать элементы уровней 1 - 6")
    void postCreateElementsLevels_1_6() {
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_1_1 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_1_1, "Dep_2");
        Integer element_int_id_1_1_1 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_1_1_1, "Dep_3");
        Integer element_int_id_1_1_1_1 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_1_1_1_1, "Dep_4");
        Integer element_int_id_1_1_1_1_1 = new Integer(id);
        createElement("www.comp_post_request.com", element_int_id_1_1_1_1_1, "Dep_5");
        Integer element_int_id_1_1_1_1_1_1 = new Integer(id);
        createElement6("www.comp_post_request.com", element_int_id_1_1_1_1_1_1, "Dep_6");
        id = getStructure();

    }

    @AfterEach
    protected void tearDown() {
        cleanDB();
        cleanFileIdForDelete();
    }
}
