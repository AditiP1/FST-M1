package project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity3 {
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void keepTest() {
        // Create new Note
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("editable_title")));
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("Title");
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Note");
        driver.findElement(AppiumBy.accessibilityId("Reminder")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = 'Later today']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = 'Pick a date & time']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("alertTitle")));
        driver.findElement(AppiumBy.id("time_spinner")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text = 'afternoon']")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = 'afternoon']")).click();
        driver.findElement(AppiumBy.id("save")).click();
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Open navigation drawer")));
        driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = 'Reminders']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("index_note_title")));
        // Find the result
        String title = driver.findElement(AppiumBy.id("index_note_title")).getText();
        System.out.println(title);
        // Assertion
        Assert.assertTrue(driver.findElement(AppiumBy.id("browse_note_interior_content")).isDisplayed());
        Assert.assertEquals(title,"Title");
        Assert.assertTrue(driver.findElement(AppiumBy.id("reminder_chip_icon")).isDisplayed());
        
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
