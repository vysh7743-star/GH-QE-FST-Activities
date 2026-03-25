package selenium.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity_5 {

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

        // 🔹 Click Edit (Enable editing)
        driver.findElement(By.id("btnSave")).click();
        Thread.sleep(3000);

        // 🔹 Edit Name
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Vyshnavi");

        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Palyam");

        // 🔹 Select Gender (Female)
        driver.findElement(By.id("personal_optGender_2")).click();

        // 🔹 Select Nationality
        Select nationality = new Select(driver.findElement(By.id("personal_cmbNation")));
        nationality.selectByVisibleText("Indian");

        // 🔹 Enter DOB
        driver.findElement(By.id("personal_DOB")).clear();
        driver.findElement(By.id("personal_DOB")).sendKeys("2003-07-24");

        Thread.sleep(2000);

        // 🔹 Click Save
        driver.findElement(By.id("btnSave")).click();

        Thread.sleep(3000);

        System.out.println("✅ User information updated successfully!");

        // 🔹 Close Browser
        driver.quit();
    }
}