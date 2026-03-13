package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AmazonIphoneSearch{

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open Amazon
        driver.get("https://www.amazon.in");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for search box
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))
        );

        // Enter product
        searchBox.sendKeys("iphone 17 pro");

        // Click search button
        driver.findElement(By.id("nav-search-submit-button")).click();

        // Wait for results
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@data-component-type='s-search-result']")));

        // Get all products
        List<WebElement> products = driver.findElements(
                By.xpath("//div[@data-component-type='s-search-result']"));

        // Select 3rd product
        WebElement thirdProduct = products.get(2);

        // Scroll to 3rd product
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", thirdProduct);

        Thread.sleep(2000);

        // Get price
        String price = thirdProduct.findElement(
                By.xpath(".//span[@class='a-price-whole']")).getText();

        // Get delivery text
        String delivery = thirdProduct.getText();

        // Print output
        System.out.println("Third iPhone Price: " + price);
        System.out.println("Delivery Info: " + delivery);

        // Close browser
        //driver.quit();
    }
}