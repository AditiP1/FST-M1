package project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Activity1 {
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void tasksTest() {

        List<String> tasks = new ArrayList<>();
        tasks.add("Complete Activity with Google Tasks");
        tasks.add("Complete Activity with Google Keep");
        tasks.add("Complete the second Activity Google Keep");
        for (String task:tasks) {
            // Add task
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("tasks_fab")));
            driver.findElement(AppiumBy.id("tasks_fab")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("add_task_title")));
            driver.findElement(AppiumBy.id("add_task_title")).sendKeys(task);
            driver.findElement(AppiumBy.id("add_task_done")).click(); //save

            // Find the task name
            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("task_name")));
            String actualTaskName = driver.findElement(AppiumBy.id("task_name")).getText();

            // Assertion
            Assert.assertEquals(actualTaskName, task);
        }

    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
