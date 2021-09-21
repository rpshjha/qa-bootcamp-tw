package com.rpshjha.qabootcamp.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static com.rpshjha.qabootcamp.constants.FrameworkConstants.BASE_URL;
import static com.rpshjha.qabootcamp.constants.FrameworkConstants.DEFAULT_TIMEOUT;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 21/09/21
 * Time: 1:06 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class DriverFactory {

    private static Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    public WebDriver driver;

    public WebDriver initDriver() throws Exception {
        // Creating only one instance across all tests
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            driver.get(BASE_URL);
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
