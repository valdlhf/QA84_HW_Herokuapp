package com.herokuapp.pages.home;

import com.herokuapp.core.BasePage;
import com.herokuapp.pages.alerts.AlertsPage;
import com.herokuapp.pages.brokenimages.BrokenImagesPage;
import com.herokuapp.pages.dropdown.DropDownPage;
import com.herokuapp.pages.frames.FramesPage;
import com.herokuapp.pages.windows.WindowsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //  <a href="/javascript_alerts">JavaScript Alerts</a>
    @FindBy(css = "a[href$='/javascript_alerts']")
    WebElement alertsLink;
    public AlertsPage getAlertsPage(){
        clickWithJS(alertsLink);
        return new AlertsPage(driver);
    }

    @FindBy(css = "a[href$='/windows']")
    WebElement windows;
    public WindowsPage getWindowsPage(){
        clickWithJS(windows);
        return new WindowsPage(driver);
    }

    @FindBy(css="a[href='/frames']")
    WebElement frames;
    public FramesPage getFramesPage() {
        clickWithJS(frames);
        return new FramesPage(driver);
    }

    // drop down
    @FindBy(css = "a[href='/dropdown']")
    WebElement dropdown;
    public DropDownPage getDropDownPage(){
        clickWithJS(dropdown);
        return new DropDownPage(driver);
    }

    //broken images
    @FindBy(css = "a[href='/broken_images']")
    WebElement brokenImages;
    public BrokenImagesPage getBrokenImagesPage() {
        clickWithJS(brokenImages);
        return new BrokenImagesPage(driver);
    }



//
//    //drag and drop
//    @FindBy(css = "a[href='/drag_and_drop']")
//    WebElement draganddrop;
//    public DropDownPage getDropDownPage(){
//        clickWithJS(draganddrop);
//        return new DropDownPage(driver);
//    }
}
