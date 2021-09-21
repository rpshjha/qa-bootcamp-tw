package com.rpshjha.qabootcamp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@SpringBootTest
class QabootcampApplicationTests {


    private WebDriver webDriver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:3000/#/");
    }

    @Test
    void contextLoads() {
    }

    @AfterTest
    public void tear() {
        webDriver.quit();
    }

}
