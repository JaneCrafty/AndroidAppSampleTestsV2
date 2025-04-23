package framework.POM;

import framework.MobileDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @AndroidFindBy(id = "title")
    private AndroidElement _title;

    @AndroidFindBy(id = "emailField")
    private AndroidElement _emailField;

    @AndroidFindBy(id = "passField")
    private AndroidElement _passField;

    @AndroidFindBy(id = "logoutButton")
    private AndroidElement _logoutButton;

    @AndroidFindBy(id = "closeButton")
    private AndroidElement _closeButton;

    public MainPage (MobileDriver mobileDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver.getDriver()), this);
    }

    public AndroidElement getTitle() {
        return _title;
    }

    public AndroidElement getEmailField() {
        return _emailField;
    }

    public AndroidElement getPassField() {
        return _passField;
    }

    public AndroidElement getLogoutButton() {
        return _logoutButton;
    }

    public AndroidElement getCloseButton() {
        return _closeButton;
    }


}
