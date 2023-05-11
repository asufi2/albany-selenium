package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetTestWithPathVariable {
    private static final Logger LOGGER = LogManager.getLogger(GetTestWithPathVariable.class);

    @Test
    public void getSingleUser(){
        LOGGER.info("--------API Test: Get Single User with Path Variable-----------");

        //Specify the base URL or endpoint of the REST API
        RestAssured.baseURI = "https://reqres.in/api/users";

        //Get the RequestSpecification of the request that you want to send to the server.
        //The server is specified by the BaseURI that we have specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();

        //Make a request to the server by specifying the method Type and the method URL.
        //This will return the Response from the server.  Store the response in a variable.
        //We created a string with the id 2, which means it pulls the 2nd id from the list.
        String id = "2";
        Response response = httpRequest.request(Method.GET, id);
        LOGGER.debug(response.prettyPrint());

        //Assert that the correct Api status is returned.
        Assert.assertEquals(response.getStatusCode(), 200);

        //Get the JsonPath object instance from the response.
        JsonPath jsonPath = response.jsonPath();
        String actualEmailId = jsonPath.getString("data.email");

        //Validate that a specific user email does exist in the response body.
        String expectedEmailId = "janet.weaver@reqres.in";
        Assert.assertEquals(actualEmailId, expectedEmailId);

        LOGGER.info("---------End Test: Get Single User with Path Variable-----------");
    }

    //Negative Testing
    @Test
    public void attemtpToGetUserWithInvalidId() {
        LOGGER.info("--------API Test: Attempt to retrieve user with Invalid id-----------");

        //Specify the base URL or endpoint of the REST API
        RestAssured.baseURI = "https://reqres.in/api/users";

        //Get the RequestSpecification of the request that you want to send to the server.
        //The server is specified by the BaseURI that we have specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();

        //Make a request to the server by specifying the method Type and the method URL.
        //This will return the Response from the server.  Store the response in a variable.
        String id = "23";
        Response response = httpRequest.request(Method.GET, id);
        LOGGER.debug(response.prettyPrint());

        //Assert that the correct API status is returned.
        Assert.assertEquals(response.getStatusCode(), 404);

        //Get the JsonPath object instance from the response.
        //Verify you get {} when searching for ID 23, which should not exist aka negative testing
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.get().toString(), "{}");

        LOGGER.info("---------End Test: Attempt to retrieve user with Invalid id-----------");
    }
}


