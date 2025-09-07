/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package tests.mercurytours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

/**
 *
 * @author Veco Mxolisi
 */
public class MercurytoursTest extends BaseTest {

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    @Test
    public void hello() {
        WebDriver driver = null;
        try {
            driver = initialiseBrowser(Browser.CHROME);
            driver.get("https://demo.guru99.com/");
            driver.findElement(By.name("emailid")).sendKeys("test@mail.com");

        } finally {
            driver.quit();
        }
    }

    @Test
    public void failureTest() {
        Assert.assertEquals("Hello", "Hello", "testing greetings message");
    }
}
