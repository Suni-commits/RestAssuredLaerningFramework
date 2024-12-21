package com.RestassuredFramework.Tests.Integration.Crud;

import com.RestassuredFramework.Base.BaseTest;
import com.RestassuredFramework.EndPoints.APIConstants;
import com.RestassuredFramework.Pojos.CreateUserResponseExample;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class IntegrationFlow extends BaseTest {

    @Test(priority=1)
    public void test_VerifyCreateUser(ITestContext context){
        // Set the base path for the create user API
        requestSpecification.basePath(APIConstants.Create_Update_url);

        // Make the POST request to create a new user
        Response response = RestAssured.given(requestSpecification)
                .when()
                .body(payload_manager.createPayloadusers())
                .post();

        // Log the response and validate the status code
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);

        // Extract the user ID from the response (assuming 'id' is the field in the response)
        CreateUserResponseExample createUserResponse = payload_manager.createuserResponse(response.asString());
        Integer userId = createUserResponse.getId();  // Assuming getId() is the method that fetches the user ID

        // Store the userId in the context for later use
        context.getSuite().setAttribute("userId", userId);
    }

    @Test(priority=2)
    public void test_VerifyGetUser(ITestContext context){
        // Retrieve the userId from the context
        Integer id = (Integer) context.getSuite().getAttribute("userId");

        // Build the base path for the GET request
        String basePathGet = APIConstants.Create_Update_url + "/" + id;
        System.out.println("GET Request Path: " + basePathGet);

        // Set the base path for the request
        requestSpecification.basePath(basePathGet);

        // Make the GET request to retrieve the user
        response = RestAssured.given(requestSpecification)
                .when()
                .get();

        // Log the response and extract status code
        validatableResponse = response.then().log().all();
        validatableResponse.extract().statusCode();
    }

    @Test(priority=3)
    public void test_VerifyUpdateUser(ITestContext context){
        // Retrieve the userId from the context
        Integer id = (Integer) context.getSuite().getAttribute("userId");

        // Build the base path for the PUT request
        String basePathPutPatch = APIConstants.Create_Update_url + "/" + id;
        System.out.println("PUT Request Path: " + basePathPutPatch);

        // Set the base path for the request
        requestSpecification.basePath(basePathPutPatch);

        // Make the PUT request to update the user
        response = RestAssured.given(requestSpecification)
                .body(payload_manager.UpdateuserpayloadExample())
                .when()
                .put();

        // Log the response and validate status code
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }

    @Test(priority=4)
    public void test_VerifyDeleteUser(ITestContext context){
        // Retrieve the userId from the context
        Integer id = (Integer) context.getSuite().getAttribute("userId");

        // Build the base path for the DELETE request
        String basePathDelete = APIConstants.Create_Update_url + "/" + id;
        System.out.println("DELETE Request Path: " + basePathDelete);

        // Set the base path for the request
        requestSpecification.basePath(basePathDelete);

        // Make the DELETE request to delete the user
        response = RestAssured.given(requestSpecification)
                .when()
                .delete();

        // Log the response and extract status code
        validatableResponse = response.then().log().all();
        validatableResponse.extract().statusCode();
    }
}
