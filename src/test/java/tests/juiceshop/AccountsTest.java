/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.juiceshop;

import juiceshop.pages.HomePage;
import juiceshop.pages.LoginPage;
import juiceshop.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import tests.BaseTest;

/**
 *
 * @author mxolisi
 */
public class AccountsTest extends BaseTest {

    @Test
    public void createAccountTest() {
        WebDriver driver = null;

        try {
            driver = initialiseBrowser(BaseTest.Browser.CHROME);
            driver.get(url);
            HomePage homePage = new HomePage(driver);
            homePage.dismissPopUp();
            homePage.gotoLogin();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.waitForPageToLoad(10);
            loginPage.clickNotYetACustomer();

            RegisterPage registerPage = new RegisterPage(driver);
            registerPage.waitForPageToLoad(10);
            registerPage.captureForm("test@mail.com", "1234567890", "1234567890", "Your ZIP/postal code when you were a teenager?", "2001");

        } finally {
            driver.quit();
        }

    }
}
