package com.rpshjha.qabootcamp.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

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

    private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static void initDriver(String browserName) throws Exception {

        switch (browserName) {

            case BrowserType.CHROME:
                WebDriverManager.chromedriver().setup();
                WEB_DRIVER_THREAD_LOCAL.set(new ChromeDriver());
                break;
            case BrowserType.FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                WEB_DRIVER_THREAD_LOCAL.set(new FirefoxDriver());
                break;
            default:
                System.err.println("Invalid Browser Type ..!!");
                break;
        }

        WEB_DRIVER_THREAD_LOCAL.get().manage().window().maximize();
        WEB_DRIVER_THREAD_LOCAL.get().manage().timeouts().pageLoadTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        WEB_DRIVER_THREAD_LOCAL.get().get(BASE_URL);
    }

    public static WebDriver getDriver() {
        return WEB_DRIVER_THREAD_LOCAL.get();
    }

    public static void quitDriver() {
        if (WEB_DRIVER_THREAD_LOCAL.get() != null) {
            WEB_DRIVER_THREAD_LOCAL.get().quit();
            WEB_DRIVER_THREAD_LOCAL.remove();
        }
    }
}
