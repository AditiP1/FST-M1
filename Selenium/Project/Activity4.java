package project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://alchemy.hguy.co/lms");
        // Print the title of the second most popular course
        String secondPopularCourseTitle = driver.findElement(By.xpath("//div/h3[@class = 'entry-title'and text()= 'Email Marketing Strategies']")).getText();
        System.out.println("second most popular course title: " + secondPopularCourseTitle);
        if (secondPopularCourseTitle.equalsIgnoreCase("Email Marketing Strategies")) {
            // Close the browser
            driver.close();
        }
    }
}
