package framework.POM;

import framework.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class WelcomePage {
    private MobileDriver mobileDriver;

    @AndroidFindBy(id = "com.example.demo:id/email")
    private AndroidElement _emailInput;

    @AndroidFindBy(id = "com.example.demo:id/password")
    private AndroidElement _passwordInput;

    @AndroidFindBy(id = "com.example.demo:id/signUpButton")
    private AndroidElement _signUpButton;

    public WelcomePage(MobileDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        if (mobileDriver.getDriver() == null) {
            throw new RuntimeException("❌ Driver is null inside WelcomePage constructor");
        }
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver(), Duration.ofSeconds(10)), this);
        System.out.println("✅ WelcomePage initialized. SignUpButton: " + (_signUpButton != null));
        System.out.println("📄 Page Source:\n" + mobileDriver.getDriver().getPageSource());

    }

    public AndroidElement getEmailInput() {
        System.out.println("🧪 getEmailInput() called, value: " + _emailInput);
        return _emailInput; }
    public AndroidElement getPasswordInput() { return _passwordInput; }
    public AndroidElement getSignUpButton() { return _signUpButton; }

    public MainPage clickSignUpButton(MobileDriver driver) {
        _signUpButton.click();
        return new MainPage(driver);
    }

}
