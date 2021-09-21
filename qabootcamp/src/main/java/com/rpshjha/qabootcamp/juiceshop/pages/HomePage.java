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
 * Time: 12:25 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Account')]")
    private WebElement account;

    @FindBy(xpath = "//button[@role='menuitem']//span[contains(text(),' Login ')]")
    private WebElement btnLoginOnMenu;

    @FindBy(linkText = "Not yet a customer?")
    private WebElement btnNotYetACustomer;

    @FindBy(css = "button[role='menuitem']")
    private List<WebElement> menuItems;

    @FindBy(xpath = "//span[text()='Dismiss']")
    private WebElement popup;

    public void dismissPopup() {
        this.popup.click();
    }

    public HomePage navigateToRegistrationPage() {

        WebDriverWait wait = new WebDriverWait(this.driver, 10);

        this.account.click();
        this.btnLoginOnMenu.click();

        wait.until(ExpectedConditions.urlContains("login"));
        wait.until(ExpectedConditions.elementToBeClickable(this.btnNotYetACustomer)).click();
        wait.until(ExpectedConditions.urlContains("register"));
        return this;
    }

    public boolean verifyLoggedInUserEmail(String expectedEmail) {

        boolean status = false;
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(this.account)).click();

        for (WebElement element : this.menuItems) {
            if (element.getText().contains(expectedEmail)) {
                status = true;
                break;
            }
        }
        return status;
    }


}
