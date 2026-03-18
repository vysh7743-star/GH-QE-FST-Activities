
package RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Activity2 {

    // Base URL
    static String BASE_URI = "https://petstore.swagger.io/v2";

    // Common test data
    static int userId = 9901;
    static String username = "justinc";

    // ✅ STEP 1: CREATE USER
    @Test(priority = 1)
    public void addNewUser() {

        String requestBody = "{\n" +
                "\"id\": 9901,\n" +
                "\"username\": \"justinc\",\n" +
                "\"firstName\": \"Justin\",\n" +
                "\"lastName\": \"Case\",\n" +
                "\"email\": \"justincase@mail.com\",\n" +
                "\"password\": \"password123\",\n" +
                "\"phone\": \"9812763450\",\n" +
                "\"userStatus\": 0\n" +
                "}";

        Response response =
                given()
                    .baseUri(BASE_URI)
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                .when()
                    .post("/user");

        // 🔥 PRINT RESPONSE
        System.out.println("===== ADD USER RESPONSE =====");
        response.then().log().all();

        // ✅ ASSERT
        response.then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("message", equalTo(String.valueOf(userId)));
    }

    // ✅ STEP 2: GET USER
    @Test(priority = 2, dependsOnMethods = "addNewUser")
    public void getUserInfo() {

        Response response =
                given()
                    .baseUri(BASE_URI)
                    .pathParam("username", username)
                .when()
                    .get("/user/{username}");

        // 🔥 PRINT RESPONSE
        System.out.println("===== GET USER RESPONSE =====");
        response.then().log().all();

        // ✅ ASSERT
        response.then()
                .statusCode(200)
                .body("id", equalTo(userId))
                .body("username", equalTo(username))
                .body("firstName", equalTo("Justin"))
                .body("lastName", equalTo("Case"))
                .body("email", equalTo("justincase@mail.com"))
                .body("password", equalTo("password123"))
                .body("phone", equalTo("9812763450"));
    }

    // ✅ STEP 3: DELETE USER
    @Test(priority = 3, dependsOnMethods = "getUserInfo")
    public void deleteUser() {

        Response response =
                given()
                    .baseUri(BASE_URI)
                    .pathParam("username", username)
                .when()
                    .delete("/user/{username}");

        // 🔥 PRINT RESPONSE
        System.out.println("===== DELETE USER RESPONSE =====");
        response.then().log().all();

        // ✅ ASSERT
        response.then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("message", equalTo(username));
    }
}

