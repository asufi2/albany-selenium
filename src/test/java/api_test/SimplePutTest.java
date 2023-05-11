package api_test;


import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

//Put calls means we need to pass the entire body as displayed on regres.in
public class SimplePutTest {

    private static final Logger LOGGER = LogManager.getLogger(SimplePostTest.class);

    @Test
    public void createNewUser() {
        LOGGER.info("---------------API Test: Update User Fields using Put Call-------------------");

        RestAssured.baseURI = "https://reqres.in/api/users";

        RequestSpecification httpRequest = RestAssured.given();

        //Faker library will allow us to create full name & job title, fake values are generated, so we can post them
        Faker faker = new Faker();
        String name = faker.name().fullName();
        LOGGER.debug("New User Full Name: " + name);

        String jobTitle = faker.job().title();
        LOGGER.debug("New User Full Name: " + jobTitle);

        JSONObject reqBody = new JSONObject();
        reqBody.put("name",name);
        reqBody.put("job",jobTitle);

        //I got the header values by using postman
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(reqBody.toJSONString());

        //I am using the PUT Method
        String id = "2";
        Response response = httpRequest.request(Method.PUT, id);
        LOGGER.debug(response.prettyPrint());

        //I'm expecting a successful status code of 200 - look at the put call to get the expected response code
        Assert.assertEquals(response.getStatusCode(), 200);

        //Were pulling the json response & converting to a String - then using assert to validate actual matches the expected
        JsonPath jsonPath = response.jsonPath();
        String actualName = jsonPath.getString("name");
        Assert.assertEquals(actualName, name);

        LOGGER.info("---------------End Test: Update User Fields using Put Call-------------------");
    }

}


/**
 * This is what it should look like
 * 14:31:57.936 [main] INFO  api_test.SimplePostTest - ---------------API Test: Update User Fields using Put Call-------------------
 * {
 *     "name": "Catherina Vandervort",
 *     "job": "Hospitality Officer",
 *     "updatedAt": "2023-05-10T18:32:07.363Z"
 * }
 * 14:32:01.249 [main] INFO  api_test.SimplePostTest - ---------------End Test: Update User Fields using Put Call-------------------
 */