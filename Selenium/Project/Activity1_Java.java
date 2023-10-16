package ProjActiviies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1_Java {
    public static void main(String[] args){

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        String title= driver.getTitle();
        System.out.println("The title of the page is : " + title);
        Assert.assertEquals("The title is not matched ", "Alchemy LMS – An LMS Application", title);
        driver.quit();
    }
}
