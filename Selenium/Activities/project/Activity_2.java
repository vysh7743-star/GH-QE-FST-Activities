package selenium.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_2 {

    public static void main(String[] args) {

        // Launch Firefox (Selenium Manager handles driver)
        WebDriver driver = new FirefoxDriver();

        // Open the URL
        driver.get("https://alchemy.hguy.co/orangehrm/");

        // Locate the header image
        WebElement headerImage = driver.findElement(By.xpath("//div[@id='divLogo']//img"));

        // Get the image URL (src attribute)
        String imageUrl = headerImage.getAttribute("src");

        // Print URL
        System.out.println("Header Image URL: " + imageUrl);

        // Close browser
        driver.quit();
    }
}
