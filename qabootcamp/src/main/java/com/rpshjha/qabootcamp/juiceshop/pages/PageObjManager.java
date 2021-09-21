package com.rpshjha.qabootcamp.juiceshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.rpshjha.qabootcamp.constants.FrameworkConstants.DEFAULT_TIMEOUT;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 21/09/21
 * Time: 2:35 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class PageObjManager {

    private WebDriver driver;
    protected WebDriverWait wait;

    public PageObjManager(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, DEFAULT_TIMEOUT);
    }

    private HomePage homePage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public RegistrationPage getRegistrationPage() {
        if (registrationPage == null) {
            registrationPage = new RegistrationPage(driver);
        }
        return registrationPage;
    }
}
