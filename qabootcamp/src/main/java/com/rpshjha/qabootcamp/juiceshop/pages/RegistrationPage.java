package com.rpshjha.qabootcamp.juiceshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 21/09/21
 * Time: 1:26 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input#emailControl")
    private WebElement inputEmail;

    @FindBy(css = "input#passwordControl")
    private WebElement inputPassword;

    @FindBy(css = "input#repeatPasswordControl")
    private WebElement inputRepeatPassword;

    @FindBy(css = "mat-select[role='combobox']")
    private WebElement dropdwnSecurityQues;

    @FindBy(css = "div[role='listbox']")
    private List<WebElement> securityQuestions;

    @FindBy(css = "input#securityAnswerControl")
    private WebElement securityAnswer;

    @FindBy(css = "button#registerButton")
    private WebElement btnRegister;

    @FindBy(xpath = "//span[text()='Registration completed successfully. You can now log in.']")
    private WebElement sucessRegMsg;


    public void registerUser(String email, String password) {

        WebDriverWait wait = new WebDriverWait(this.driver, 10);

        this.inputEmail.sendKeys(email);
        this.inputPassword.sendKeys(password);
        this.inputRepeatPassword.sendKeys(password);

        this.dropdwnSecurityQues.click();
        this.securityQuestions.stream().findFirst().get().click();
        this.securityAnswer.sendKeys("dummy answer");

        wait.until(ExpectedConditions.elementToBeClickable(this.btnRegister)).click();
        wait.until(ExpectedConditions.urlContains("login"));
    }

    public boolean isUserRegSucessful() {
        return sucessRegMsg.isDisplayed();
    }
}
