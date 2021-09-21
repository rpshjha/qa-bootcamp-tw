package com.rpshjha.qabootcamp.juiceshop.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 21/09/21
 * Time: 12:58 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class LoginPage extends PageObjManager {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input#email")
    private WebElement inputEmail;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "loginButton")
    private WebElement btnLogin;

    public void loginUser(String email, String password) {

        this.inputEmail.sendKeys(email);
        this.inputPassword.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(this.btnLogin)).click();

        wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").toString().equals("complete"));
        wait.until(ExpectedConditions.urlContains("search"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignore) {
        }
    }
}
