package com.rpshjha.qabootcamp;

import com.rpshjha.qabootcamp.driver.DriverFactory;
import com.rpshjha.qabootcamp.juiceshop.pages.PageObjManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 21/09/21
 * Time: 12:16 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class BaseTest {

    protected WebDriver driver;
    private DriverFactory driverFactory;
    protected PageObjManager pageObjManager;

    @BeforeMethod
    public void setup() throws Exception {
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver();

        pageObjManager = new PageObjManager(driver);
    }

    @AfterMethod
    public void tear() {
        driverFactory.quitDriver();
    }
}
