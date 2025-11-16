/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author mxolisi
 */
public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void waitForPageToLoad(int seconds);

    public WebElement wait(int seconds, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void sendKeys(By by, String keys) {
        driver.findElement(by).sendKeys(keys);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String captureScreenShot(String screenshotFolder) throws IOException {
        String screenshotName = UUID.randomUUID() + ".png";
        String screenshotFullPath = screenshotFolder + "/" + screenshotName;
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(screenshotFullPath));
        return screenshotName;
    }

}
