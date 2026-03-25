package selenium.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_3 {

    public static void main(String[] args) {

        // Launch Firefox (Selenium Manager handles driver)
        WebDriver driver = new FirefoxDriver();

        // Open the URL
        driver.get("https://alchemy.hguy.co/orangehrm/");

        // Enter Username
        driver.findElement(By.id("txtUsername")).sendKeys("orange");

        // Enter Password
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");

        // Click Login button
        driver.findElement(By.id("btnLogin")).click();

        // Verify login (checking Dashboard URL)
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("dashboard")) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Login Failed!");
        }

        // Close browser
        //driver.quit();
    }
}
