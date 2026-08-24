package com.herokuapp.pages.windows;

import com.herokuapp.core.BasePage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class WindowsPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(WindowsPage.class);

    public WindowsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css="a[href='/windows/new']")
    WebElement newWindow;
    public WindowsPage getNewWindow(){
        clickWithJS(newWindow);
        return this;
    }


    public WindowsPage switchToNewWindow(int index) {
       List<String> tabs = new ArrayList<>(driver.getWindowHandles());
       driver.switchTo().window(tabs.get(index));
        return this;
    }
}
