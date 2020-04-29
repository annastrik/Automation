package org.tophap;

import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import org.junit.jupiter.api.Test;
import org.tophap.runner.MultipleTest;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileDataVisibilityTest extends MultipleTest {

    @Test
    void checkProfileData() {

        // Open sign in form from the Home page and login
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getDriver(), loginPage.EMAIL, loginPage.PASSWORD);

        // Close email confirmation failure PopUp window
        homePage.emailConfirmationFailureMsgClose(getDriver());

        // Go to My Account page
        loginPage.openUserProfile(getDriver());

        // Verify that all profile info fields are not empty
        ProfilePage profilePage = new ProfilePage(getDriver());
        assertFalse(profilePage.getName().isEmpty());
        assertFalse(profilePage.getUserName().isEmpty());
        assertFalse(profilePage.getPhoneNumber().isEmpty());
        assertFalse(profilePage.getEmail().isEmpty());

        // Verify that all profile info fields are displayed
        assertTrue(profilePage.nameField.isDisplayed());
        assertTrue(profilePage.usernameField.isDisplayed());
        assertTrue(profilePage.phoneNumberField.isDisplayed());
        assertTrue(profilePage.emailField.isDisplayed());
        assertTrue(profilePage.avatar.isDisplayed());
    }
}