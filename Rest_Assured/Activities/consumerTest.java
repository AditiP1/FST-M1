package project;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(PactConsumerTestExt.class)
public class consumerTest {
    Map<String, String> headers = new HashMap<String, String>();
    //Set Source URI
    String createUser = "/api/users";

    @Pact(provider="UserProvider", consumer="UserConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) throws ParseException{
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        // Create request JSON
        DslPart bodyReqResUser = new PactDslJsonBody()
                .numberType("id", 324)
                .stringType("firstName", "Aditi")
                .stringType("lastName", "P")
                .stringType("email", "fdsf@gff.com");

        // Create rules for request and response
        return builder.given("A request to create a user")
                .uponReceiving("a request to create a user")
                .path(createUser)
                .method("POST")
                .headers(headers)
                .body(bodyReqResUser)
                .willRespondWith()
                .status(201)
                .body(bodyReqResUser)
                .toPact();
    }


    @Test
    @PactTestFor(providerName = "UserProvider", port = "8080")
    public void runTest() {
        // Mock url
        RestAssured.baseURI = "http://localhost:8080";
        // Create request specification
        RequestSpecification req = RestAssured.given().headers(headers).when();
        // Create request body
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 734);
        map.put("firstName", "Aditi");
        map.put("lastName", "P");
        map.put("email", "fdsf@gff.com");

        // Send POST request
        Response response = req.body(map).post(createUser);
        // Assertion
        assert (response.getStatusCode() == 201);
    }


}
