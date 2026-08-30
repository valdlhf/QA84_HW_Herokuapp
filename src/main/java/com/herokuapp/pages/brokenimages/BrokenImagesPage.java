package com.herokuapp.pages.brokenimages;

import com.herokuapp.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenImagesPage extends BasePage {

    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img")
    List<WebElement> images;

    public BrokenImagesPage checkBrokenImages() {

        System.out.println("Total images on the page = " + images.size());

        for (int i = 0; i < images.size(); i++) {

            WebElement image = images.get(i);
            String imageUrl = image.getAttribute("src");

            System.out.println("Image " + (i + 1) + " -> " + imageUrl);

            try {
                boolean imageDisplayed = (Boolean) js.executeScript(
                        "return (typeof arguments[0].naturalWidth != undefined " +
                                "&& arguments[0].naturalWidth > 0);",
                        image
                );

                if (imageDisplayed) {
                    softly.assertThat(imageDisplayed);
                } else {
                    softly.fail("Broken image -> " + imageUrl);
                }

            } catch (Exception e) {
                softly.fail("Error occurred -> " + imageUrl);
            }
        }

        softly.assertAll();
        return this;
    }
}
