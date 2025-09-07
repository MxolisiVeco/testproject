/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juiceshop.pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author mxolisi
 */
public class LoginPage extends BasePage {

    private final By notYetACustomer = By.linkText("Not yet a customer?");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageToLoad(int seconds) {
        wait(seconds, notYetACustomer);
    }

    public void clickNotYetACustomer() {
        driver.findElement(notYetACustomer).click();
    }
}
