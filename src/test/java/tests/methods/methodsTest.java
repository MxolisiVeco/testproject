/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.methods;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author mxolisi
 */
public class methodsTest {

    public methodsTest() {
        System.out.println("0. Constructor");
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("1. BeforeSuite");
    }

    @BeforeClass(alwaysRun = true)
    public void BeforeClass() {
        System.out.println("2. BeforeClass");
    }

    @BeforeTest(alwaysRun = true)
    public void BeforeTest() {
        System.out.println("3. BeforeTest");
    }

    @BeforeMethod(alwaysRun = true)
    public void BeforeMethod() {
        System.out.println("4. BeforeMethod");
    }

    @Test(alwaysRun = true)
    public void test1() {
        System.out.println("5. Test1");
    }

    @Test(alwaysRun = true)
    public void test2() {
        System.out.println("5. Test2");
    }

    @AfterMethod(alwaysRun = true)
    public void AfterMethod() {
        System.out.println("6. AfterMethod");
    }

    @AfterTest(alwaysRun = true)
    public void AfterTest() {
        System.out.println("7. AfterTest");
    }

    @AfterClass(alwaysRun = true)
    public void AfterClass() {
        System.out.println("8. AfterClass");
    }

    @AfterSuite(alwaysRun = true)
    public void AfterSuite() {
        System.out.println("9. AfterSuite");
    }

}
