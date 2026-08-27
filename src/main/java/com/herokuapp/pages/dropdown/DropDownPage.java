package com.herokuapp.pages.dropdown;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePage {
    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dropdown")
    WebElement dropdown;
    public DropDownPage selectOption(String option) {
        new Select(dropdown).selectByVisibleText(option);
        return this;
    }

    public DropDownPage verifyOption(String expectedOption) {
        String actualOption = new Select(dropdown)
                .getFirstSelectedOption()
                .getText();
        Assertions.assertEquals(expectedOption, actualOption);
        return this;
    }
}
