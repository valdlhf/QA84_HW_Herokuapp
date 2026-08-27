package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.draganddrop.DragAndDropPage;
import com.herokuapp.pages.home.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DragAndDropTest extends TestBase {
    DragAndDropPage dragAndDropPage;

    @BeforeEach
    public void precondition() {
        dragAndDropPage = new HomePage(driver)
                .getDragAndDropPage();
    }

    @Test
    public void dragAndDropTest() {
        dragAndDropPage
                .dragAtoB()
                .verifyColumns();
    }
}
