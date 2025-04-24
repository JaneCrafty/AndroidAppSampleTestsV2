package com.example.testing.Tests;

import com.example.testing.Watcher;
import framework.POM.MainPage;
import framework.POM.WelcomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static framework.Helpers.StringHelper.GetRandomEmail;
import static framework.Helpers.StringHelper.GetRandomPassword;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SampleTests extends Watcher {

    @Test
    public void successfulRegistrationTest() {
        String email = GetRandomEmail();
        String password = GetRandomPassword();

        WelcomePage welcomePage  = new WelcomePage(getMobileDriver());
        getMobileDriver().getDriverWait().until(ExpectedConditions.visibilityOf(welcomePage.getSignUpButton()));
        welcomePage.getEmailInput().sendKeys(email);
        welcomePage.getPasswordInput().sendKeys(password);
        MainPage mainPage = welcomePage.clickSignUpButton(getMobileDriver());

        Assertions.assertTrue(mainPage.getTitle().isDisplayed());
        Assertions.assertTrue(mainPage.getTitle().getText().contains(("demo android project")));
        Assertions.assertTrue(mainPage.getEmailField().isDisplayed());
        Assertions.assertTrue(mainPage.getEmailField().getText().contains(email));
        Assertions.assertTrue(mainPage.getPassField().isDisplayed());
        Assertions.assertTrue(mainPage.getPassField().getText().contains(password));
        Assertions.assertTrue(mainPage.getLogoutButton().isDisplayed());
        Assertions.assertTrue(mainPage.getCloseButton().isDisplayed());
    }

    @Test
    public void registrationWithEmptyFieldsShouldNotProceedTest() {
        WelcomePage welcomePage  = new WelcomePage(getMobileDriver());
        getMobileDriver().getDriverWait().until(ExpectedConditions.visibilityOf(welcomePage.getSignUpButton()));
        welcomePage.getEmailInput().clear();
        welcomePage.getPasswordInput().clear();
        welcomePage.clickSignUpButton(getMobileDriver());

        Assertions.assertTrue(welcomePage.getEmailInput().isDisplayed());
    }

    @Test
    public void closeAppWithCloseButtonTest() {
        WelcomePage welcomePage  = new WelcomePage(getMobileDriver());
        getMobileDriver().getDriverWait().until(ExpectedConditions.visibilityOf(welcomePage.getSignUpButton()));
        welcomePage.getEmailInput().sendKeys(GetRandomEmail());
        welcomePage.getPasswordInput().sendKeys(GetRandomPassword());
        MainPage mainPage = welcomePage.clickSignUpButton(getMobileDriver());
        mainPage.getCloseButton().click();

        getMobileDriver().getDriverWait().until(ExpectedConditions.invisibilityOf(mainPage.getEmailField()));
        Assertions.assertNull(getMobileDriver().getSessionId());
    }
}
