package selenium.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_4 {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Open URL
        driver.get("https://alchemy.hguy.co/orangehrm/");

        // 🔹 Wait for page to load
        Thread.sleep(5000);

        // 🔹 Login
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        Thread.sleep(5000);

        // 🔹 Click PIM
        driver.findElement(By.id("menu_pim_viewPimModule")).click();

        Thread.sleep(3000);

        // 🔹 Click Add Employee
        driver.findElement(By.id("btnAdd")).click();

        Thread.sleep(3000);

        // 🔹 Enter Employee Details
        driver.findElement(By.id("firstName")).sendKeys("palyam");
        driver.findElement(By.id("lastName")).sendKeys("vyshnavi");

        Thread.sleep(2000);

        // 🔹 Save
        driver.findElement(By.id("btnSave")).click();

        Thread.sleep(5000);

        // 🔥 VERIFY SUCCESS (Profile page shows name)
        String name = driver.findElement(By.xpath("//h1")).getText();
        System.out.println("Employee Name: " + name);

        if (name.contains("vyshnavi")) {
            System.out.println("✅ Employee added successfully!");
        } else {
            System.out.println("❌ Employee NOT added!");
        }

        driver.quit();
    }
}