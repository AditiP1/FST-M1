package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/lms");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        String title = driver.getTitle();
        if (title.equalsIgnoreCase("Alchemy LMS – An LMS Application")) {
            // Close the browser
            driver.close();
        }
    }
}
