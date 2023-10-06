package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/lms");
        // Get the heading of the page
        String heading = driver.findElement(By.xpath("//div/h1[@class = 'uagb-ifb-title']")).getText();
        System.out.println("Heading is: "+heading);
        if (heading.equalsIgnoreCase("Learn from Industry Experts")) {
            // Close the browser
            driver.close();
        }
    }
}
