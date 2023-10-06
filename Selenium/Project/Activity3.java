package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/lms");
        // Print the title of the first info box
        System.out.println("First info box title: " + driver.findElement(By.xpath("//div/h3[@class = 'uagb-ifb-title']")).getText());

        String infoBoxTitle = driver.findElement(By.xpath("//div/h3[@class = 'uagb-ifb-title']")).getText();
        if (infoBoxTitle.equalsIgnoreCase("Actionable Training")) {
            // Close the browser
            driver.close();
        }
    }
}
