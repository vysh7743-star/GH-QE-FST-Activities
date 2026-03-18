
package RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Activity1 {

    int petId = 77232;

    // ✅ Add New Pet (POST)
    @Test(priority = 1)
    public void addNewPet() {

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", petId);
        reqBody.put("name", "Riley");
        reqBody.put("status", "available");

        Response response =
                given()
                    .baseUri("https://petstore.swagger.io/v2")
                    .header("Content-Type", "application/json")
                    .body(reqBody)
                .when()
                    .post("/pet");

        // ✅ PRINT RESPONSE
        System.out.println("Add Pet Response:");
        System.out.println(response.getBody().asPrettyString());

        // ✅ ASSERTIONS
        response.then()
                .statusCode(200)
                .body("id", equalTo(petId))
                .body("name", equalTo("Riley"))
                .body("status", equalTo("available"));
    }

    //  Get Pet Info (GET)
    @Test(priority = 2)
    public void getPetInfo() {

        Response response =
                given()
                    .baseUri("https://petstore.swagger.io/v2")
                    .header("Content-Type", "application/json")
                    .pathParam("petId", petId)
                .when()
                    .get("/pet/{petId}");

        //  PRINT RESPONSE
        System.out.println("Get Pet Response:");
        System.out.println(response.getBody().asPrettyString());

        // ASSERTIONS
        response.then()
                .statusCode(200)
                .body("id", equalTo(petId))
                .body("name", equalTo("Riley"))
                .body("status", equalTo("available"));
    }

    // Delete Pet (DELETE)
    @Test(priority = 3)
    public void deletePet() {

        Response response =
                given()
                    .baseUri("https://petstore.swagger.io/v2")
                    .header("Content-Type", "application/json")
                    .pathParam("petId", petId)
                .when()
                    .delete("/pet/{petId}");

        //  PRINT RESPONSE
        System.out.println("Delete Pet Response:");
        System.out.println(response.getBody().asPrettyString());

        // ASSERTIONS
        response.then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("message", equalTo(String.valueOf(petId)));
    }
}