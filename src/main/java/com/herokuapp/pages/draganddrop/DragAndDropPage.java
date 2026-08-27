package com.herokuapp.pages.draganddrop;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "column-a")
    WebElement columnA;

    @FindBy(id = "column-b")
    WebElement columnB;

    public DragAndDropPage dragAtoB() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(columnA, columnB).perform();
        return this;
    }

    public DragAndDropPage verifyColumns() {
        Assertions.assertEquals("B", columnA.findElement(
                org.openqa.selenium.By.tagName("header")).getText());

        Assertions.assertEquals("A", columnB.findElement(
                org.openqa.selenium.By.tagName("header")).getText());

        return this;
    }
}
