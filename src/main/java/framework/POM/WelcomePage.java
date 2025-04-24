package framework.POM;

import framework.MobileDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {
    private final MobileDriver mobileDriver;

    public static final String EMAIL_ID = "com.example.demo:id/email";
    public static final String PASSWORD_ID = "com.example.demo:id/password";
    public static final String SIGN_UP_BUTTON_ID = "com.example.demo:id/signUpButton";

    private final By emailLocator = By.id(EMAIL_ID);
    private final By passwordLocator = By.id(PASSWORD_ID);
    private final By signUpButtonLocator = By.id(SIGN_UP_BUTTON_ID);

    public WelcomePage(MobileDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        if (mobileDriver.getDriver() == null) {
            throw new RuntimeException("❌ Driver is null inside WelcomePage constructor");
        }
        System.out.println("✅ WelcomePage initialized");
    }

    public WebElement getEmailInput() {
        return waitForElement(emailLocator);
    }

    public WebElement getPasswordInput() {
        return waitForElement(passwordLocator);
    }

    public WebElement getSignUpButton() {
        return waitForElement(signUpButtonLocator);
    }

    public MainPage clickSignUpButton(MobileDriver driver) {
        getSignUpButton().click();
        return new MainPage(driver);
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