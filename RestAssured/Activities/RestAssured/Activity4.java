

package RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Activity4 {

    RequestSpecification requestSpec;
    static long petId; // ✅ store reference ID

    @BeforeClass
    public void setUp() {
        requestSpec = new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .setBaseUri("https://petstore.swagger.io/v2")
                .build();
    }

    // =========================
    // POST - Create Pet
    // =========================
    @Test(priority = 1)
    public void addPet() {

        System.out.println("POST: Creating pet...");

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("name", "Riley");
        reqBody.put("photoUrls", new String[]{"url1"}); // ✅ fixed
        reqBody.put("status", "available"); // ✅ FIXED (was "string")

        String response =
        given().spec(requestSpec)
                .body(reqBody)
        .when()
                .post("/pet")
        .then()
                .statusCode(200)
                .log().all()
                .extract().asString();

        // ✅ Extract ID correctly
        petId = io.restassured.path.json.JsonPath.from(response).getLong("id");

        System.out.println("Created Pet ID: " + petId);
    }

    // =========================
    // GET - Fetch Pet
    // =========================
    @Test(priority = 2)
    public void getPet() {

        System.out.println("\nGET: Fetching pet...");

        given().spec(requestSpec)
                .pathParam("petId", petId)
        .when()
                .get("/pet/{petId}")
        .then()
                .statusCode(200)
                .body("id", equalTo((int) petId))
                .body("name", equalTo("Riley"))
                .body("status", equalTo("available")) // ✅ now matches
                .log().all();
    }

    // =========================
    // PUT - Update Pet
    // =========================
    @Test(priority = 3)
    public void updatePet() {

        System.out.println("\nPUT: Updating pet...");

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", petId);
        reqBody.put("name", "Riley");
        reqBody.put("photoUrls", new String[]{"url1"});
        reqBody.put("status", "sold");

        given().spec(requestSpec)
                .body(reqBody)
        .when()
                .put("/pet")
        .then()
                .statusCode(200)
                .body("status", equalTo("sold"))
                .log().all();
    }

    // =========================
    // DELETE - Delete Pet
    // =========================
    @Test(priority = 4)
    public void deletePet() {

        System.out.println("\nDELETE: Deleting pet...");

        given().spec(requestSpec)
                .pathParam("petId", petId)
        .when()
                .delete("/pet/{petId}")
        .then()
                .statusCode(200);
    }

    // =========================
    // FINAL GET + PRINT ID
    // =========================
    @Test(priority = 5)
    public void verifyDeletion() {

        System.out.println("\nGET: Verifying deletion...");

        given().spec(requestSpec)
                .pathParam("petId", petId)
        .when()
                .get("/pet/{petId}")
        .then()
                .statusCode(404);

        // ✅ FINAL OUTPUT
        System.out.println("\nFINAL REFERENCE PET ID: " + petId);
    }
}