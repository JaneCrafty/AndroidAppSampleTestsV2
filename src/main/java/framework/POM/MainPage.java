package framework.POM;

import framework.MobileDriver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class MainPage {
    private final MobileDriver mobileDriver;

    private final By titleLocator = By.id("com.example.demo:id/title");
    private final By emailFieldLocator = By.id("com.example.demo:id/emailField");
    private final By passFieldLocator = By.id("com.example.demo:id/passField");
    private final By logoutButtonLocator = By.id("com.example.demo:id/logoutButton");
    private final By closeButtonLocator = By.id("com.example.demo:id/closeButton");

    public MainPage(MobileDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        if (mobileDriver.getDriver() == null) {
            throw new RuntimeException("❌ Driver is null inside MainPage constructor");
        }
        System.out.println("✅ MainPage initialized");
    }

    public WebElement getTitle() {
        return waitForElement(titleLocator);
    }

    public WebElement getEmailField() {
        System.out.println("driver class: " + mobileDriver.getDriver().getClass().getName());
        return waitForElement(emailFieldLocator);
    }

    public WebElement getPassField() {
        return waitForElement(passFieldLocator);
    }

    public WebElement getLogoutButton() {
        return waitForElement(logoutButtonLocator);
    }

    public WebElement getCloseButton() {
        return waitForElement(closeButtonLocator);
    }

    private WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(mobileDriver.getDriver(), 15);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}

//package framework.POM;
//
//import framework.MobileDriver;
//import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.pagefactory.AndroidFindBy;
//import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import org.openqa.selenium.support.PageFactory;
//
//import java.time.Duration;
//
//public class MainPage {
//
//    @AndroidFindBy(id = "com.example.demo:id/email")
//    private AndroidElement _title;
//
//    @AndroidFindBy(id = "com.example.demo:id/emailField")
//    private AndroidElement _emailField;
//
//    @AndroidFindBy(id = "com.example.demo:id/passField")
//    private AndroidElement _passField;
//
//    @AndroidFindBy(id = "com.example.demo:id/logoutButton")
//    private AndroidElement _logoutButton;
//
//    @AndroidFindBy(id = "com.example.demo:id/closeButton")
//    private AndroidElement _closeButton;
//
//    public MainPage (MobileDriver mobileDriver) {
//        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver(), Duration.ofSeconds(10)), this);    }
//
//    public AndroidElement getTitle() {
//        return _title;
//    }
//
//    public AndroidElement getEmailField() {
//        return _emailField;
//    }
//
//    public AndroidElement getPassField() {
//        return _passField;
//    }
//
//    public AndroidElement getLogoutButton() {
//        return _logoutButton;
//    }
//
//    public AndroidElement getCloseButton() {
//        return _closeButton;
//    }
//
//
//}
