/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;

/**
 *
 * @author mxolisi
 */
public class BaseTest {

    protected ExtentReports extentReports;

    public final String url = "http://localhost:3000/#/";
    private final ChromeOptions chromeOptions;
    private final FirefoxOptions firefoxOptions;
    public String reportFolderName;
    public String reportFolderFullName;
    public String screenshotFolder;

    public enum Browser {
        CHROME, FIREFOX
    };

    public BaseTest() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");

        firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--no-sandbox");

        extentReports = new ExtentReports();
        createReportFolder();
        ExtentSparkReporter spark = new ExtentSparkReporter(reportFolderFullName);
        extentReports.attachReporter(spark);
    }

    public WebDriver initialiseBrowser(Browser browser, String targetURL) {
        WebDriver driver;

        if (browser == Browser.CHROME) {
            driver = new ChromeDriver(chromeOptions);
        } else {
            driver = new FirefoxDriver(firefoxOptions);
        }
        driver.get(targetURL);
        driver.manage().window().maximize();
        return driver;
    }

    public void createReportFolder() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        reportFolderName = now.format(formatter);
        reportFolderFullName = "report/" + reportFolderName;
        screenshotFolder = reportFolderFullName + "/screenshot";
        File folder = new File(screenshotFolder);
        folder.mkdir();
    }

    @AfterSuite(alwaysRun = true)
    public void flushReport() {
        extentReports.flush();
    }

//    @AfterMethod(alwaysRun = true)
//    public void flushAfterMethod() {
//        extent.flush();
//    }
}
