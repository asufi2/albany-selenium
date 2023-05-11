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

public class SimplePostTest {
    private static final Logger LOGGER = LogManager.getLogger(SimplePostTest.class);

    @Test
    public void createNewUser() {
        LOGGER.info("---------------API Test: Create a new user-------------------");

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

        //I am using the POST Method
        Response response = httpRequest.request(Method.POST);
        LOGGER.debug(response.prettyPrint());

        //I'm expecting a successful status code of 201
        Assert.assertEquals(response.getStatusCode(), 201);

        //Were pulling the json response & converting to a String - then using assert to validate actual matches the expected
        JsonPath jsonPath = response.jsonPath();
        String actualName = jsonPath.getString("name");
        Assert.assertEquals(actualName, name);

        LOGGER.info("---------------End Test: Create a new user-------------------");
    }
}

/**This is what it should look like when it performs as expected
 * 14:15:51.877 [main] INFO  api_test.SimplePostTest - ---------------API Test: Create a new user-------------------
 * {
 *     "name": "Georgann King MD",
 *     "job": "Investor IT Representative",
 *     "id": "792",
 *     "createdAt": "2023-05-10T18:16:01.419Z"
 * }
 * 14:15:55.269 [main] INFO  api_test.SimplePostTest - ---------------End Test: Create a new user-------------------
 */
