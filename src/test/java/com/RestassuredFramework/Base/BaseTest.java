package com.RestassuredFramework.Base;

import com.RestassuredFramework.Asserts.AssertActions;
import com.RestassuredFramework.EndPoints.APIConstants;
import com.RestassuredFramework.Modules.Payload_Manager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BaseTest {

    public RequestSpecification requestSpecification;
    public Response response;
    public AssertActions assertActions;
    public Payload_Manager payload_manager;
    public JsonPath jsonpath;
    public ValidatableResponse validatableResponse;

    @BeforeTest
    public void setUp(){

        payload_manager=new Payload_Manager();
        assertActions=new AssertActions();

        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.Base_Url)
                .header("Authorization", "Bearer " + APIConstants.Bearer_token)  // Adding Bearer token
                .header("Accept", "application/json")  // Ensuring Accept header is set
                .contentType(ContentType.JSON)  // Ensuring Content-Type header is set
                .log().all();

        assertThat(requestSpecification).isNotNull();
        System.out.println("Bearer Token: " + APIConstants.Bearer_token);
    }

}
