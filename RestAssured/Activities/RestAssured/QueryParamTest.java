

package RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class QueryParamTest {

    // Base URL
    public static final String ROOT_URI = "http://ip-api.com/json";

    @Test
    public void getIPInformation() {

        given()
            .contentType(ContentType.JSON) // Header
            .queryParam("fields", "query,country,city,timezone") // Query Param
            .pathParam("ip", "125.219.5.94") // Path Param
        .when()
            .get(ROOT_URI + "/{ip}") // Request
        .then()
            .statusCode(200) // Validation
            .log().all(); // Print full response
    }
}