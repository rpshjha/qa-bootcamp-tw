package com.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.example.mocks.WiremockHelper;
import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BaseTest {

    static WiremockHelper wireMockServer = null;
    static RequestSpecification requestSpecification;
    static Faker faker;
    static ExtentReports extentReports;

    @BeforeAll
    public static void createRequestSpecification() {
        wireMockServer = new WiremockHelper(38081);
        faker = new Faker(new Locale("en-US"));
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://juice-shop.herokuapp.com/")
                .build();

        extentReports = getExtentReport();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("generating report at location " + System.getProperty("user.dir"));
        extentReports.flush();
    }

    public static ExtentReports getExtentReport() {
        String timestamp = new SimpleDateFormat("MMMdd").format(Calendar.getInstance().getTime());
        String filename = System.getProperty("user.dir") + File.separator + "test_report_" + timestamp + ".html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(filename);
        sparkReporter.config().setDocumentTitle("TW bootcamp");
        sparkReporter.config().setReportName("TW bootcamp");
        sparkReporter.config().setTheme(Theme.STANDARD);
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));

        return extent;
    }


}
