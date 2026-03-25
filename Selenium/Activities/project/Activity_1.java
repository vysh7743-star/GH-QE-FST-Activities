package selenium.project;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_1 {

    public static void main(String[] args) {

        // Launch Firefox (Selenium Manager will handle driver automatically)
        WebDriver driver = new FirefoxDriver();

        driver.get("https://alchemy.hguy.co/orangehrm/");

        String title = driver.getTitle();
        System.out.println("Website Title: " + title);

        if (title.equals("OrangeHRM")) {
            System.out.println("Title matched!");
        } else {
            System.out.println("Title NOT matched!");
        }

        driver.quit();
    }
}