package com.herokuapp.tests;

import com.herokuapp.core.TestBase;
import com.herokuapp.pages.brokenimages.BrokenImagesPage;
import com.herokuapp.pages.home.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrokenImagesTest extends TestBase {

    BrokenImagesPage brokenImagesPage;

    @BeforeEach
    public void precondition() {
        brokenImagesPage = new HomePage(driver).getBrokenImagesPage();
    }

    @Test
    public void checkBrokenImagesTest() {
        brokenImagesPage.checkBrokenImages();
    }
}