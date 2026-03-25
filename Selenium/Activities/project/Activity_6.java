package selenium.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_6 {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // 🔹 Open Website
        driver.get("https://alchemy.hguy.co/orangehrm/");
        Thread.sleep(5000);

        // 🔹 Login
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(5000);

        // 🔹 Locate Directory Menu
        WebElement directoryMenu = driver.findElement(By.id("menu_directory_viewDirectory"));

        // 🔹 Verify visible & clickable
        if (directoryMenu.isDisplayed() && directoryMenu.isEnabled()) {
            System.out.println("✅ Directory menu is visible and clickable");

            // Click Directory
            directoryMenu.click();
        } else {
            System.out.println("❌ Directory menu NOT accessible");
        }

        Thread.sleep(5000);

        // 🔹 Verify page heading
        String heading = driver.findElement(By.xpath("//h1")).getText();
        System.out.println("Page Heading: " + heading);

        if (heading.equals("Search Directory")) {
            System.out.println("Successfully navigated to Directory page");
        } else {
            System.out.println("Navigation failed");
        }

        // 🔹 Close Browser
        driver.quit();
    }
}