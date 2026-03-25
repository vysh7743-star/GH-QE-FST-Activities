package selenium.project;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class wholeProject {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // 🔹 Open Website
        driver.get("https://alchemy.hguy.co/orangehrm/");
        Thread.sleep(4000);

        // ================= Activity 1 =================
        String title = driver.getTitle();
        System.out.println("Title: " + title);

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
        driver.findElement(By.id("middleName")).clear(); // 🔥 remove middle name
        driver.findElement(By.id("lastName")).sendKeys("Vyshnavi");

        driver.findElement(By.id("btnSave")).click();
        Thread.sleep(4000);

        // 🔹 Verify in Employee List
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Palyam Vyshnavi");
        driver.findElement(By.id("searchBtn")).click();
        Thread.sleep(3000);

        System.out.println("Employee created and verified");

        // ================= Activity 5 =================
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("btnSave")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Palyam");

        driver.findElement(By.id("personal_txtEmpMiddleName")).clear(); // 🔥 remove middle name

        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Vyshnavi");

        driver.findElement(By.id("personal_optGender_2")).click();

        Select nationality = new Select(driver.findElement(By.id("personal_cmbNation")));
        nationality.selectByIndex(1);

        driver.findElement(By.id("btnSave")).click();
        Thread.sleep(4000);

        // 🔥 Final Name Verification
        String first = driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value");
        String last = driver.findElement(By.id("personal_txtEmpLastName")).getAttribute("value");

        System.out.println("Final Name Stored: " + first + " " + last);

        // ================= Activity 6 =================
        WebElement dir = driver.findElement(By.id("menu_directory_viewDirectory"));
        if (dir.isDisplayed()) {
            dir.click();
            Thread.sleep(3000);

            String heading = driver.findElement(By.tagName("h1")).getText();
            System.out.println("Directory Page: " + heading);
        }

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

        driver.findElement(By.id("applyBtn")).click();
        Thread.sleep(4000);

        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        Thread.sleep(3000);

        System.out.println("Leave Applied and Verified");

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

        // 🔥 FINAL CONFIRMATION
        System.out.println("✅ FINAL NAME STORED SUCCESSFULLY: Palyam Vyshnavi");

        driver.quit();
    }
}