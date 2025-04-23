package framework.POM;

import framework.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
    @AndroidFindBy(id = "email")
    private AndroidElement _emailInput;

    @AndroidFindBy(id = "password")
    private AndroidElement _passwordInput;

    @AndroidFindBy(id = "signUpButton")
    private AndroidElement _signUpButton;

    public WelcomePage(MobileDriver mobileDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }

    public AndroidElement getEmailInput() { return _emailInput; }
    public AndroidElement getPasswordInput() { return _passwordInput; }
    public AndroidElement getSignUpButton() { return _signUpButton; }

    public MainPage clickSignUpButton(MobileDriver mobileDriver) {
        _signUpButton.click();
        return new MainPage(mobileDriver);
    }

}
