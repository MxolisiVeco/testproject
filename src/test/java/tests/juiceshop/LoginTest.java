/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.juiceshop;

import dataproviders.TestDataProvider;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.Test;

/**
 *
 * @author Veco Mxolisi
 */
public class LoginTest {
    
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "loginDataProvider")
    public void loginTest(CSVRecord csvRecord) {
        System.out.println("id : " + csvRecord.get("id"));
        System.out.println("testName : " + csvRecord.get("testName"));
        System.out.println("username : " + csvRecord.get("username"));
        System.out.println("password : " + csvRecord.get("password"));
    }
}
