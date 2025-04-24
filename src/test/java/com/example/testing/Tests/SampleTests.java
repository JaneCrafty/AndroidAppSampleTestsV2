package com.example.testing.Tests;

import com.example.testing.Watcher;
import framework.POM.MainPage;
import framework.POM.WelcomePage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static framework.Helpers.StringHelper.GetRandomEmail;
import static framework.Helpers.StringHelper.GetRandomPassword;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@ExtendWith(Watcher.class)
public class SampleTests extends Watcher {

    @Test
    public void successfulRegistrationTest(){
        String email = GetRandomEmail();
        String password = GetRandomPassword();

        WelcomePage welcomePage = new WelcomePage(getMobileDriver());
        welcomePage.getEmailInput().sendKeys(email);
        welcomePage.getPasswordInput().sendKeys(password);
        MainPage mainPage = welcomePage.clickSignUpButton(getMobileDriver());

        Assertions.assertTrue(mainPage.getTitle().isDisplayed());
        Assertions.assertTrue(mainPage.getTitle().getText().contains("demo android project"));
        Assertions.assertTrue(mainPage.getEmailField().isDisplayed());
        Assertions.assertTrue(mainPage.getEmailField().getText().contains(email));
        Assertions.assertTrue(mainPage.getPassField().isDisplayed());
        Assertions.assertTrue(mainPage.getPassField().getText().contains(password));
        Assertions.assertTrue(mainPage.getLogoutButton().isDisplayed());
        Assertions.assertTrue(mainPage.getCloseButton().isDisplayed());
    }

    @Test
    public void logOutTest() {
        WelcomePage welcomePage = new WelcomePage(getMobileDriver());
        welcomePage.getEmailInput().sendKeys(GetRandomEmail());
        welcomePage.getPasswordInput().sendKeys(GetRandomPassword());
        MainPage mainPage = welcomePage.clickSignUpButton(getMobileDriver());
        mainPage.getTitle().isDisplayed();
        mainPage.getLogoutButton().click();
        Assertions.assertTrue(welcomePage.getEmailInput().isDisplayed());
    }

    @Test
    public void closeAppWithCloseButtonTest() {
        WelcomePage welcomePage = new WelcomePage(getMobileDriver());
        welcomePage.getEmailInput().sendKeys(GetRandomEmail());
        welcomePage.getPasswordInput().sendKeys(GetRandomPassword());
        MainPage mainPage = welcomePage.clickSignUpButton(getMobileDriver());
        mainPage.getCloseButton().click();

        String currentActivity = getMobileDriver().getCurrentActivity();
        Assertions.assertNotEquals(".MainActivity", currentActivity);    }
}