/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package tests.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

/**
 *
 * @author Veco Mxolisi
 */
public class GoogleTest {
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        WebDriver driver = null;

        try {
            driver = new EdgeDriver();
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Hello World");
            searchBox.sendKeys(Keys.ENTER);
        } finally {
            driver.quit();
        }
    }

}
