package com.rpshjha.qabootcamp;

import com.rpshjha.qabootcamp.driver.DriverFactory;
import com.rpshjha.qabootcamp.juiceshop.pages.PageObjManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.rpshjha.qabootcamp.driver.DriverFactory.getDriver;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 21/09/21
 * Time: 12:16 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class BaseTest {

    protected PageObjManager pageObjManager;

    @BeforeMethod
    public void setup() throws Exception {

        DriverFactory.initDriver(BrowserType.CHROME);
        pageObjManager = new PageObjManager(getDriver());
    }

    @AfterMethod
    public void tear() {
        DriverFactory.quitDriver();
    }
}
