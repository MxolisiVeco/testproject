/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.juiceshop;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import juiceshop.pages.HomePage;
import juiceshop.pages.LoginPage;
import juiceshop.pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

/**
 *
 * @author mxolisi
 */
public class AccountsTest extends BaseTest {

    @Test
    public void createAccountTest() throws IOException {
        WebDriver driver = null;
        HomePage homePage = null;
        RegisterPage registerPage = null;
        LoginPage loginPage = null;
        ExtentTest extentTest = extentReports.createTest("Create account test");

        try {
            driver = initialiseBrowser(BaseTest.Browser.CHROME, url);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(0));
            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            extentTest.pass("Launched Browser");
            homePage = new HomePage(driver);
            homePage.waitForPageToLoad(10);
            homePage.dismissPopUp();
            extentTest.pass("Clossed Browser");
            homePage.gotoLogin();
            extentTest.pass("Navigated to login");

            loginPage = new LoginPage(driver);
            loginPage.waitForPageToLoad(10);
            loginPage.clickNotYetACustomer();
            extentTest.pass("Clicked Not Yet a customer Browser");

            registerPage = new RegisterPage(driver);
            registerPage.waitForPageToLoad(10);
            String random = Math.random() * 1000 + "".replaceAll(".", "");
            String actualMessage = registerPage.captureForm(random + "test@mail.com", "P_qwtey_12_763_w730", "P_qwtey_12_763_w730", "Your ZIP/postal code when you were a teenager?", "2001");
            String expectedMessage = "Registration succesfull";
            Assert.assertEquals(actualMessage, expectedMessage);
            extentTest.pass("Verified registration");

        } catch (Exception | AssertionError e) {
            extentTest.fail(e, MediaEntityBuilder.createScreenCaptureFromPath("screenshot/" + homePage.captureScreenShot(screenshotFolder)).build());
            throw e;
        } finally {
//            System.out.println(registerPage.getDriver().getPageSource());
            driver.quit();
        }
    }

    @Test
    public void tableTest() {
        WebDriver driver = initialiseBrowser(BaseTest.Browser.CHROME, "https://demo.guru99.com/test/web-table-element.php");

        try {
            WebElement table = driver.findElement(By.xpath("//table[@class='dataTable']"));
            List<WebElement> trs = table.findElements(By.tagName("tr"));
            WebElement headerTr = trs.get(0);
            List<WebElement> ths = headerTr.findElements(By.tagName("th"));

            for (WebElement th : ths) {
                System.out.print(th.getText() + "\t\t");
            }

            for (WebElement tr : trs) {
                List<WebElement> tds = tr.findElements(By.tagName("td"));

                for (WebElement td : tds) {
                    System.out.print(td.getText() + "\t\t");
                }

                System.out.println("");
            }
        } finally {
            driver.quit();
        }
    }

    @Test
    public void tableTest2() {
        WebDriver driver = initialiseBrowser(BaseTest.Browser.CHROME, "https://demo.guru99.com/test/web-table-element.php");

        try {
            String xpathExpression = "//table[@class='dataTable']//th | //table[@class='dataTable']//td";
            List<WebElement> tableHeadersAndTableData = driver.findElements(By.xpath(xpathExpression));

            for (WebElement data : tableHeadersAndTableData) {
                System.out.println(data.getText());

            }
        } finally {
            driver.quit();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod");
    }
}
