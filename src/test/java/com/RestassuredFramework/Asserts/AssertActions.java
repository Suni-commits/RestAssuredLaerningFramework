package com.RestassuredFramework.Asserts;

import io.restassured.response.Response;
import org.testng.Assert;

public class AssertActions {

    public void verifyResponse(String actual,String expected,String description){
        Assert.assertEquals(actual,expected,description);
    }

    public void verifyResponse(String actual,Integer expected,String description){
        Assert.assertEquals(actual,expected,description);
    }
    public void verifyStatusCode(Response response,Integer expected){
        Assert.assertEquals(response,expected);
    }

}
