package cloveri.negativeTests;

import cloveri.base.Steps;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class NegativePutTests extends Steps {

    String id;

    @Test
    @Description("Добавить наследников в поле 'children'")
    void putChangeChildren() {
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_2 = new Integer(id);
        id = createElement("www.comp_post_request.com", 1, "Dep_2");
        Integer element_int_id_3 = new Integer(id);
        changeChildren(element_int_id_3, element_int_id_2);
        getStructure();
    }

    @Test
    @Description("Изменить потомка и проверить, что он не продублировался в поле 'children' у родителя")
    void putChangeChild() {
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_2 = new Integer(id);
        id = createElement("www.comp_post_request.com", element_int_id_2, "Dep_2");
        Integer element_int_id_3 = new Integer(id);
        putElement("www.put_request.com", element_int_id_2, "Department_2", element_int_id_3);
        checkFieldChildren(element_int_id_3);
        getStructure();
    }

    @Test
    @Description("Изменить родителя у элемента с 'id' = 1")
    void putChangeElementWithId_1_Parent() {
        String id1 = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_2 = new Integer(id1);
        String id2 = createElement("www.comp_post_request.com", element_int_id_2, "Dep_1");
        Integer element_int_id_3 = new Integer(id2);
        changeElementWithId_1_Parent("www.put_request.com", element_int_id_3, "Company", 1);
        getStructure();
    }

    @Test
    @Description("Изменить родителя у элемента на несуществующего")
    void putChangeElementParentNoExist() {
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_2 = new Integer(id);
        changeElementParentNoExist("www.put_request.com", 2, "Dep_2", element_int_id_2);
        getStructure();
    }

    @Test
    @Description("Изменить элемент без поля 'href'")
    void putChangeElementNoFieldHref() {
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_2 = new Integer(id);
        changeElementNoFieldHref(1, "Dep_2", element_int_id_2);
        id = createElement("www.post_request.com", 1, "Dep_2");
        getStructure();
    }

    @Test
    @Description("Изменить элемент без поля 'parent'")
    void putChangeElementNoFieldParent() {
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_2 = new Integer(id);
        changeElementNoFieldParent("www.put_post_request.com", "Dep_1", element_int_id_2);
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        getStructure();
    }

    @Test
    @Description("Изменить элемент без поля 'label'")
    void putChangeElementNoFieldLabel() {
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_2 = new Integer(id);
        changeElementNoFieldLabel("www.put_request.com", 1, element_int_id_2);
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        getStructure();
    }

    @Test
    @Description("Изменить элемент, пустой запрос")
    void putChangeElementNoFields() {
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_2 = new Integer(id);
        changeElementNoFields(element_int_id_2);
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        getStructure();
    }

    @Test
    @Description("Изменить родителя на null")
    void putChangeParentIdToNull() {
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        Integer element_int_id_2 = new Integer(id);
        changeParentIdToNull("www.comp_post_request.com", "Dep_1", element_int_id_2);
        id = createElement("www.comp_post_request.com", 1, "Dep_1");
        getStructure();
    }

    @AfterEach
    protected void tearDown() {
        cleanDB();
        cleanFileIdForDelete();
    }
}
