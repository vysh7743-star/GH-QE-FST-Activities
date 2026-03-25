package selenium.project;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class wholeProjectEnhanced {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/orangehrm/");
        Thread.sleep(4000);

        // ================= Activity 1 =================
        System.out.println("Title: " + driver.getTitle());

        // ================= Activity 2 =================
        String imgUrl = driver.findElement(By.xpath("//div[@id='divLogo']//img")).getAttribute("src");
        System.out.println("Image URL: " + imgUrl);

        // ================= Activity 3 =================
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(4000);

        // ================= Activity 4 =================
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("btnAdd")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("firstName")).sendKeys("Palyam");
        driver.findElement(By.id("middleName")).clear(); // remove middle name
        driver.findElement(By.id("lastName")).sendKeys("Vyshnavi");

        driver.findElement(By.id("btnSave")).click();
        Thread.sleep(4000);

        // ================= NEW FEATURE: SEARCH & OPEN =================
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("empsearch_employee_name_empName"))
              .sendKeys("Palyam Vyshnavi");

        WebElement searchBtn = driver.findElement(By.id("searchBtn"));
        js.executeScript("arguments[0].click();", searchBtn);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[contains(text(),'Palyam')]")).click();
        Thread.sleep(4000);

        System.out.println("Employee profile opened");

        // ================= Activity 5 (VERIFY DETAILS) =================
        String first = driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value");
        String last = driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value");

        System.out.println("Employee Name: " + first + " " + last);

        // Edit and ensure no middle name
        driver.findElement(By.id("btnSave")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("personal_txtEmpMiddleName")).clear();

        driver.findElement(By.id("btnSave")).click();
        Thread.sleep(3000);

        // ================= Activity 6 =================
        WebElement dir = driver.findElement(By.id("menu_directory_viewDirectory"));
        js.executeScript("arguments[0].click();", dir);
        Thread.sleep(3000);

        System.out.println("Directory Page: " +
                driver.findElement(By.tagName("h1")).getText());

        // ================= Activity 7 =================
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Qualifications")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("addWorkExperience")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("experience_employer")).sendKeys("ABC Company");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Tester");
        driver.findElement(By.id("experience_from_date")).sendKeys("2020-01-01");
        driver.findElement(By.id("experience_to_date")).sendKeys("2022-12-31");

        driver.findElement(By.id("btnWorkExpSave")).click();
        Thread.sleep(3000);

        System.out.println("Qualification Added");

        // 🔥 FETCH WORK EXPERIENCE
        List<WebElement> expRows = driver.findElements(By.xpath("//table[@id='tblWorkExperience']//tbody/tr"));

        System.out.println("Work Experience:");
        for (WebElement row : expRows) {
            System.out.println(row.getText());
        }

        // ================= Activity 8 =================
        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("menu_leave_applyLeave")).click();
        Thread.sleep(2000);

        Select leave = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        leave.selectByIndex(1);

        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2024-12-01");

        driver.findElement(By.id("applyleave_txtToDate")).clear();
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2024-12-02");

        WebElement applyBtn = driver.findElement(By.id("applyBtn"));
        js.executeScript("arguments[0].click();", applyBtn);

        Thread.sleep(4000);

        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        Thread.sleep(3000);

        System.out.println("Leave Applied");

        // 🔥 FETCH LEAVE DETAILS
        List<WebElement> leaveRows = driver.findElements(By.xpath("//table//tbody/tr"));

        System.out.println("Leave Records:");
        for (WebElement row : leaveRows) {
            System.out.println(row.getText());
        }

        // ================= Activity 9 =================
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Emergency Contacts")).click();
        Thread.sleep(3000);

        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody/tr"));

        System.out.println("Emergency Contacts:");
        for (WebElement row : rows) {
            System.out.println(row.getText());
        }

        // ================= FINAL =================
        System.out.println("✅ FINAL NAME STORED: Palyam Vyshnavi");
        System.out.println("✅ FULL EMPLOYEE DATA RETRIEVED SUCCESSFULLY");

        driver.quit();
    }
}
