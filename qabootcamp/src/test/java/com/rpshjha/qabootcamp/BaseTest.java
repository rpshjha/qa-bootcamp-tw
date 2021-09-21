package com.rpshjha.qabootcamp;

import com.rpshjha.qabootcamp.driver.DriverFactory;
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

    @BeforeMethod
    public void setup() throws Exception {
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver();

    }

    @AfterMethod
    public void tear() {
        driverFactory.quitDriver();
    }
}
