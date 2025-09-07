/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 *
 * @author mxolisi
 */
public class BaseTest {

    public final String url = "http://localhost:3000/#/";
    private final ChromeOptions chromeOptions;
    private final FirefoxOptions firefoxOptions;

    public enum Browser {
        CHROME, FIREFOX
    };

    public BaseTest() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");

        firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--no-sandbox");
    }

    public WebDriver initialiseBrowser(Browser browser) {
        WebDriver driver;

        if (browser == Browser.CHROME) {
            driver = new ChromeDriver(chromeOptions);
        } else {
            driver = new FirefoxDriver(firefoxOptions);
        }

        driver.manage().window().maximize();
        return driver;
    }
}
