package com.rpshjha.qabootcamp;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.rpshjha.qabootcamp.helper.TestHelper.getRandomEmail;
import static com.rpshjha.qabootcamp.helper.TestHelper.getRandomPassword;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 21/09/21
 * Time: 12:16 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class JuiceShopTests extends BaseTest {


    @Test
    void registerUserAndLogin() {

        String tempEmail = getRandomEmail();

        pageObjManager.getHomePage().navigateToRegistrationPage();

        pageObjManager.getRegistrationPage().registerUser(tempEmail, getRandomPassword());

        pageObjManager.getLoginPage().loginUser(tempEmail, getRandomPassword());

        Assert.assertTrue(pageObjManager.getHomePage().verifyLoggedInUserEmail(tempEmail), "verifying if user login is successful");
    }

}
