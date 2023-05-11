package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SimpleGetTest {
    private static final Logger LOGGER = LogManager.getLogger(SimpleGetTest.class);

    @Test
    public void getAllUsers(){
        LOGGER.info("--------API Test: Get All Users-----------");

        //Specify the base URL or endpoint of the REST API
        RestAssured.baseURI = "https://reqres.in/api/users";

        //Get the RequestSpecification of the request that you want to send to the server.
        //The server is specified by the BaseURI that we have specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();

        //Make a request to the server by specifying the method Type and the method URL.
        //This will return the Response from the server.  Store the response in a variable.
        Response response = httpRequest.request(Method.GET);
        LOGGER.debug(response.prettyPrint());

        //Assert that the correct status is returned.
        Assert.assertEquals(response.getStatusCode(), 200);

        //Get the JsonPath object instance from the response.
        JsonPath jsonPath = response.jsonPath();
        List<String> emailsList = jsonPath.get("data.email");

        //Validate that a specific user email does exist in the response body.
        String expectedEmailId = "george.bluth@reqres.in";
        boolean emailExists = emailsList.contains(expectedEmailId);
        Assert.assertTrue(emailExists, expectedEmailId + " does not exist");

        LOGGER.info("---------End Test: Get All Users-----------");
    }
}
