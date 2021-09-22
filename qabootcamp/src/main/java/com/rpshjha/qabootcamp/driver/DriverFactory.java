package com.rpshjha.qabootcamp.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

import static com.rpshjha.qabootcamp.constants.FrameworkConstants.BASE_URL;
import static com.rpshjha.qabootcamp.constants.FrameworkConstants.DEFAULT_TIMEOUT;
import static com.rpshjha.qabootcamp.driver.GetDriverExecutable.getPath;

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
                System.setProperty("webdriver.chrome.driver", getPath(browserName));
                WEB_DRIVER_THREAD_LOCAL.set(new ChromeDriver());
                break;
            case BrowserType.FIREFOX:
                System.setProperty("webdriver.gecko.driver", getPath(browserName));
                WEB_DRIVER_THREAD_LOCAL.set(new FirefoxDriver());
                break;
            case BrowserType.EDGE:
                System.setProperty("webdriver.edge.driver", getPath(browserName));
                WEB_DRIVER_THREAD_LOCAL.set(new EdgeDriver());
                break;
            default:
                System.err.println("Invalid Browser Type ..!!");
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
