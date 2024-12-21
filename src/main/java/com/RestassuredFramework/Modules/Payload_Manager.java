package com.RestassuredFramework.Modules;

import com.RestassuredFramework.Pojos.CreateUserResponseExample;
import com.RestassuredFramework.Pojos.CreateUsersExample;
import com.google.gson.Gson;

public class Payload_Manager {

    Gson gson=new Gson();

    public String createPayloadusers(){

        CreateUsersExample createUsers=new CreateUsersExample();


        createUsers.setName("Ramesh");
        createUsers.setGender("male");
        createUsers.setEmail("ramesh005@example.com");
        createUsers.setStatus("active");

        String jsonstringpayload= gson.toJson(createUsers);

        System.out.println(jsonstringpayload);
       return jsonstringpayload;
    }

    public CreateUserResponseExample createuserResponse(String responseString){

        CreateUserResponseExample createuserres=gson.fromJson(responseString, CreateUserResponseExample.class);
        return createuserres;
    }

    public CreateUsersExample getResponseFromJson(String getResponse){

        CreateUsersExample createuser=gson.fromJson(getResponse, CreateUsersExample.class);
        return createuser;
    }

    public String UpdateuserpayloadExample(){
        CreateUsersExample createUsers=new CreateUsersExample();

        createUsers.setName("RajRamesh");
        createUsers.setGender("male");
        createUsers.setEmail("rajramesh001@example.com");
        createUsers.setStatus("inactive");

        String updatejsonstringpayload= gson.toJson(createUsers);

        System.out.println(updatejsonstringpayload);
        return updatejsonstringpayload;
    }

}
