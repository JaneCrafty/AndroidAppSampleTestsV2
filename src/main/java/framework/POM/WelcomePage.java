package framework.POM;

import framework.MobileDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

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
        WebDriverWait wait = new WebDriverWait(mobileDriver.getDriver(), 15);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}

//package framework.POM;
//
//import framework.MobileDriver;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.pagefactory.AndroidFindBy;
//import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import org.openqa.selenium.support.PageFactory;
//
//import java.time.Duration;
//
//public class WelcomePage {
//    private MobileDriver mobileDriver;
//
//    @AndroidFindBy(id = "com.example.demo:id/email")
//    private AndroidElement _emailInput;
//
//    @AndroidFindBy(id = "com.example.demo:id/password")
//    private AndroidElement _passwordInput;
//
//    @AndroidFindBy(id = "com.example.demo:id/signUpButton")
//    private AndroidElement _signUpButton;
//
//    public WelcomePage(MobileDriver mobileDriver) {
//        this.mobileDriver = mobileDriver;
//        if (mobileDriver.getDriver() == null) {
//            throw new RuntimeException("❌ Driver is null inside WelcomePage constructor");
//        }
//        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver(), Duration.ofSeconds(10)), this);
//        System.out.println("✅ WelcomePage initialized. SignUpButton: " + (_signUpButton != null));
//        System.out.println("📄 Page Source:\n" + mobileDriver.getDriver().getPageSource());
//
//    }
//
//    public AndroidElement getEmailInput() {
//        System.out.println("🧪 getEmailInput() called, value: " + _emailInput);
//        return _emailInput; }
//    public AndroidElement getPasswordInput() { return _passwordInput; }
//    public AndroidElement getSignUpButton() { return _signUpButton; }
//
//    public MainPage clickSignUpButton(MobileDriver driver) {
//        _signUpButton.click();
//        return new MainPage(driver);
//    }
//
//}
