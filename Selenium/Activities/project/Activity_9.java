
package selenium.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity_9 {

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

        // 🔹 Go to My Info
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Thread.sleep(5000);

        // 🔹 Click Emergency Contacts
        driver.findElement(By.linkText("Emergency Contacts")).click();
        Thread.sleep(5000);

        // 🔹 Get all rows from table
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='emgcontact_list']//tbody/tr"));

        System.out.println("----- Emergency Contacts -----");

        // 🔹 Loop through rows and print data
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));

            for (WebElement col : cols) {
                System.out.print(col.getText() + " | ");
            }
            System.out.println();
        }

        System.out.println("✅ Retrieved all emergency contacts successfully!");

        // 🔹 Close Browser
        driver.quit();
    }
}