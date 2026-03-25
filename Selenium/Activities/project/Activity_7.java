package selenium.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_7 {

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

        // 🔹 Click My Info
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Thread.sleep(5000);

        // 🔹 Click Qualifications tab (left menu)
        driver.findElement(By.linkText("Qualifications")).click();
        Thread.sleep(5000);

        // 🔹 Click Add Work Experience
        driver.findElement(By.id("addWorkExperience")).click();
        Thread.sleep(3000);

        // 🔹 Fill Work Experience Details
        driver.findElement(By.id("experience_employer")).sendKeys("Infosys Company");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Software Tester");
        driver.findElement(By.id("experience_from_date")).sendKeys("2020-01-01");
        driver.findElement(By.id("experience_to_date")).sendKeys("2022-12-31");
        driver.findElement(By.id("experience_comments")).sendKeys("Worked on automation testing");

        Thread.sleep(2000);

        // 🔹 Save
        driver.findElement(By.id("btnWorkExpSave")).click();

        Thread.sleep(3000);

        System.out.println("✅ Work Experience added successfully!");

        // 🔹 Close browser
        driver.quit();
    }
}
