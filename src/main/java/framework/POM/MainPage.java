package framework.POM;

import framework.MobileDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        try {
            mobileDriver.getDriver().getPageSource();
            System.out.println("📍 Waiting for: " + locator.toString());
            WebDriverWait wait = new WebDriverWait(mobileDriver.getDriver(), 10);
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to locate element: " + locator.toString(), e);
        }
    }
}
