package project;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GitHub_RestAssured_Project {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAILQ22K0vWu7CF15noJ8B58kqCJcXuGeYibMFQk1cDxnK";
    int sshKeyId;
    @BeforeClass
    public void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com/user/keys")
                .addHeader("Authorization", "token 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")
                .addHeader("Content-Type", "application/json")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(5000L))
                .expectBody("key", equalTo(sshKey))
                .expectBody("title", equalTo("TestAPIKey"))
                .build();
    }

    @Test(priority =1)
    public void postRequestTest(){
        Map<String, String> reqBody = new HashMap<String, String>();
        reqBody.put("title", "TestAPIKey");
        reqBody.put("key", sshKey);
        Response response = given().spec(requestSpec).body(reqBody).when().post();
        sshKeyId = response.then().extract().path("id");
        System.out.println(sshKeyId);
        response.then().statusCode(201).spec(responseSpec);
    }

    @Test(priority = 2)
    public void getRequestTest(){
        given().spec(requestSpec).pathParam("keyId", sshKeyId)
                .when().get("/{keyId}")
                .then().statusCode(200).spec(responseSpec);
    }

    @Test(priority = 3)
    public void deleteRequestTest(){
        given().spec(requestSpec).pathParam("keyId", sshKeyId)
                .when().delete("/{keyId}")
                .then().statusCode(anyOf(is(200), is(204))).time(lessThan(5000L));
    }
}
