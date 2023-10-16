package ProjActiviies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity5_Java {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        driver.manage().window().maximize();
        driver.findElement(By.id("menu-item-1507")).click();
        String AccTitle= driver.getTitle();
        System.out.println(AccTitle);
        Assert.assertEquals(AccTitle,"My Account – Alchemy LMS");
        driver.close();
    }
}
