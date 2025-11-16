/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.apitests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

/**
 *
 * @author mxolisi
 */
public class ApiTests {

    @Test
    public void GetBooksDetails() {
        // Specify the base URL to the RESTful web service 
//        RestAssured.baseURI = "https://demoqa.com/BookStore/v1";
        // Get the RequestSpecification of the request to be sent to the server. 
        RequestSpecification requestSpicification = RestAssured.given();
        requestSpicification.body("");
        requestSpicification.header("Content-Type", "application/json");
        Response response = requestSpicification.get("https://demoqa.com/BookStore/v1/Books");
        // specify the method type (GET) and the parameters if any. 
        //In this case the request does not take any parameters 
//        Response response = requestSpicification.request(Method.GET, "/Books");
        // Print the status and message body of the response received from the server 
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Status code => " + response.getStatusCode());
        System.out.println("Response=>" + response.asString());
//        System.out.println("Response=>" + response.prettyPrint());

    }

}
