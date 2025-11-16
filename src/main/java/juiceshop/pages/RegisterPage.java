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
public class RegisterPage extends BasePage {

    private final By alreadyAcustomerLink = By.linkText("Already a customer?");
    private final By emailInput = By.id("emailControl");
    private final By passwordInput = By.id("passwordControl");
    private final By repeatPasswordInput = By.id("repeatPasswordControl");
    private final By securityQuestionsDropDown = By.xpath("//mat-label[text()=' Security Question ']");
    private final By securityQuestionsAnswerInput = By.id("securityAnswerControl");
    private final By registerBtn = By.xpath("//span[text()=' Register ']");
    private final By registrationMessage = By.xpath("//div[@matsnackbarlabel='']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageToLoad(int seconds) {
        wait(seconds, alreadyAcustomerLink);
    }

    public void selectSecurityQuestion(String securityQuestion) {
        click(securityQuestionsDropDown);
        By by = By.xpath("//*[text()=' " + securityQuestion + " ']");
        wait(2, by).click();
//        driver.findElement(by).click();
    }

    public String captureForm(String email, String password, String repeatPassword, String securityQuestion, String securityAnswer) {
        sendKeys(emailInput, email);
        sendKeys(passwordInput, password);
        sendKeys(repeatPasswordInput, repeatPassword);
        selectSecurityQuestion(securityQuestion);
        sendKeys(securityQuestionsAnswerInput, securityAnswer);
        click(registerBtn);
        return getRegistrationMessage();
    }

    public String getRegistrationMessage() {
       return driver.findElement(registrationMessage).getText().trim();
    }


}
