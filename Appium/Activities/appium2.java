package Appium;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("emulator-5554");

        options.setCapability("browserName", "Chrome");
        options.setCapability("chromedriverAutodownload", true);
        options.setNoReset(true);

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void chromeTest() throws InterruptedException {

        // Open website
        driver.get("https://training-support.net");

        // Wait for page load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // :white_check_mark: Get visible "Training" element (skip hidden ones)
        WebElement training = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("(//*[contains(text(),'Training')])[last()]")
        ));

        // :white_check_mark: Scroll to element
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", training);

        // Small wait (important for mobile)
        Thread.sleep(2000);

        // :white_check_mark: Click using JavaScript (fix interactable issue)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", training);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}