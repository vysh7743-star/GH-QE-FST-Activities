package RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IPTest {

    // Base URL with path parameter
    String ROOT_URI = "http://ip-api.com/json/{ipAddress}";

    @Test
    public void getIPInformation() {

        Response response =
                given()
                    .contentType(ContentType.JSON) // Set headers
                .when()
                    .pathParam("ipAddress", "107.218.134.107") // Set path parameter
                    .get(ROOT_URI); // Send GET request

        // Print response
        System.out.println(response.getBody().asPrettyString());
    }
}