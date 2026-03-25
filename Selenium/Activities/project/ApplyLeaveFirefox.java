package selenium.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class ApplyLeaveFirefox {

    public static void main(String[] args) {
        // 1️⃣ Set path to geckodriver (update path if needed)
        System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");

        // 2️⃣ Launch Firefox browser
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // 3️⃣ Open OrangeHRM login page
            driver.get("https://alchemy.hguy.co/orangehrm/");

            // 4️⃣ Login
            driver.findElement(By.id("txtUsername")).sendKeys("orange"); // replace with your username
            driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123"); // replace with your password
            driver.findElement(By.id("btnLogin")).click();

            // 5️⃣ Navigate to Leave → Apply Leave
            driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
            driver.findElement(By.id("menu_leave_applyLeave")).click();

            // 6️⃣ Fill leave form
            Select leaveType = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
            leaveType.selectByVisibleText("Annual Leave");

            driver.findElement(By.id("applyleave_txtFromDate")).clear();
            driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2026-03-20"); // From date

            driver.findElement(By.id("applyleave_txtToDate")).clear();
            driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2026-03-22"); // To date

            driver.findElement(By.id("applyBtn")).click(); // Apply leave

            // 7️⃣ Navigate to My Leave to check status
            driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
            WebElement leaveStatus = driver.findElement(By.xpath("//table[@id='resultTable']//td[6]"));
            System.out.println("Leave Status: " + leaveStatus.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 8️⃣ Close browser
            driver.quit();
        }
    }
}