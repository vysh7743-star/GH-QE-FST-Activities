package steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity5 extends BaseClass {

    @Given("the user navigates to the login page for Activity5")
    public void openPageActivity5() {
        driver.get("https://training-support.net/webelements/login-form");
        Assertions.assertEquals("Selenium: Login Form", driver.getTitle());
    }

    @When("the user enters username {string} and password {string} for Activity5")
    public void enterCredentialsActivity5(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @And("clicks the submit button for Activity5")
    public void clickSubmitActivity5() {
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }

    @Then("the user should see the message {string} for Activity5")
    public void confirmMessageActivity5(String expectedMessage) {
        WebElement message;
        // Invalid credentials message appears in h2#subheading
        if (expectedMessage.equalsIgnoreCase("Invalid credentials")) {
            message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2#subheading"))
            );
        } else {
            message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.mt-5"))
            );
        }
        Assertions.assertEquals(expectedMessage, message.getText());
    }
}
