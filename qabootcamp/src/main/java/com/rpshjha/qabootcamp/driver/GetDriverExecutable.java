package com.rpshjha.qabootcamp.driver;

import org.openqa.selenium.remote.BrowserType;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 22/09/21
 * Time: 9:09 AM
 * To change this template use File | Settings | File and Code Templates.
 */
public class GetDriverExecutable {

    public static String getPath(String browserType) {

        String driverPath = "";
        String os = "";

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            os = "mac";
        } else if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            os = "windows";
        } else if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            os = "linux";
        }

        switch (browserType) {
            case BrowserType.CHROME:
                driverPath = "driver/" + os + "/chrome/chromedriver";
                break;
            case BrowserType.FIREFOX:
                driverPath = "driver/" + os + "/firefox/geckodriver";
                break;
            case BrowserType.EDGE:
                driverPath = "driver/" + os + "/edge/msedgedriver";
                break;
            default:
                System.err.println("Invalid Browser Type ..!!");
        }
        return driverPath;
    }

}
