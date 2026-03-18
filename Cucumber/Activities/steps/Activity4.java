package steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity4 extends BaseClass {

    // Unique Given step
    @Given("the user navigates to the login page for Activity4")
    public void openPageActivity4() {
        driver.get("https://training-support.net/webelements/login-form");
        Assertions.assertEquals("Selenium: Login Form", driver.getTitle());
    }

    // Unique When step for default credentials
    @When("the user enters default credentials for Activity4")
    public void enterDefaultCredentials() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
    }

    // Parameterized step for any credentials
    @When("the user enters username {string} and password {string} for Activity4")
    public void enterCredentialsFromInputs(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @And("clicks the submit button for Activity4")
    public void clickSubmitActivity4() {
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }

    // Verification for default message
    @Then("the user should see the default success message for Activity4")
    public void confirmDefaultMessage() {
        WebElement message = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.mt-5"))
        );
        Assertions.assertEquals("Welcome Back, Admin!", message.getText());
    }

    // Verification for parameterized message
    @Then("the user should see the message {string} for Activity4")
    public void confirmMessageAsInput(String expectedMessage) {
        WebElement message = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.mt-5"))
        );
        Assertions.assertEquals(expectedMessage, message.getText());
    }
}