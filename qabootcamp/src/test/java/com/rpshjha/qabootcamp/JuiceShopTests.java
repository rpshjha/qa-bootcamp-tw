package com.rpshjha.qabootcamp;

import com.rpshjha.qabootcamp.juiceshop.pages.HomePage;
import com.rpshjha.qabootcamp.juiceshop.pages.LoginPage;
import com.rpshjha.qabootcamp.juiceshop.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 21/09/21
 * Time: 12:16 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class JuiceShopTests extends BaseTest {

    public String getRandomEmail() {
        return "dummy" + System.currentTimeMillis() + "@yopmail.com";
    }

    String password = "Admin@123";

    @Test
    void registerUserAndLogin() {

        String tempEmail = getRandomEmail();
        System.out.println("email id to be registered is " + tempEmail);

        HomePage homePage = new HomePage(driver);

        homePage.dismissPopup();
        homePage.navigateToRegistrationPage();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerUser(tempEmail, password);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(tempEmail, password);

        Assert.assertTrue(homePage.verifyLoggedInUserEmail(tempEmail), "verifying if user login is successful");
    }

}
