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
public class HomePage extends BasePage {

    private final By popUpDismiss = By.xpath("//span[text()='Dismiss']");
    private final By accountsMenu = By.xpath("//span[text()=' Account ']");
    private final By loginMenu = By.xpath("(//span[text()=' Login '])[2]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void dismissPopUp() {
        driver.findElement(popUpDismiss).click();
    }
    
    public void gotoLogin() {
        driver.findElement(accountsMenu).click();
        driver.findElement(loginMenu).click();
    }

    @Override
    public void waitForPageToLoad(int seconds) {
        wait(seconds, accountsMenu);
    }

}
