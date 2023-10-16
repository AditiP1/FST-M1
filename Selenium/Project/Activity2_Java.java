package ProjActiviies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2_Java {
    public static void main(String[] args){

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        String heading= driver.findElement(By.className("uagb-ifb-title")).getText();
        System.out.println("The heading of the page is : " + heading);
        Assert.assertEquals("The heading is not matched ", "Learn from Industry Experts", heading);
        driver.close();
}
}

