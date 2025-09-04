/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author mxolisi
 */
public class BaseTest {

    public final ChromeOptions chromeOptions;

    public BaseTest() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
    }
}
