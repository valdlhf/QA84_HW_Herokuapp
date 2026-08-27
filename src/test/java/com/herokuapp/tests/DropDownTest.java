package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.dropdown.DropDownPage;
import com.herokuapp.pages.home.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DropDownTest extends TestBase {

    DropDownPage dropDownPage;

    @BeforeEach
    public void precondition(){
        dropDownPage = new HomePage(driver).getDropDownPage();
    }

    @Test
    public void selectOptionTest(){
        dropDownPage.selectOption("Option 1")
                .verifyOption("Option 1");
    }



}
