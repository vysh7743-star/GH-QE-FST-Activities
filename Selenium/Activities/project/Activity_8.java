
package selenium.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity_8 {

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

        // 🔹 Navigate to Leave → Apply
        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("menu_leave_applyLeave")).click();
        Thread.sleep(3000);

        // 🔹 Select Leave Type
        Select leaveType = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        leaveType.selectByIndex(1);  // safer than visible text

        // 🔹 Enter Dates
        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2024-12-01");

        driver.findElement(By.id("applyleave_txtToDate")).clear();
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2024-12-02");

        Thread.sleep(2000);

        // 🔹 Click Apply
        driver.findElement(By.id("applyBtn")).click();
        Thread.sleep(5000);

        System.out.println("✅ Leave applied successfully!");

        // 🔹 Go to My Leave
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        Thread.sleep(5000);

        System.out.println("✅ Navigated to My Leave page");

        // 🔹 Close Browser
        driver.quit();
    }
}