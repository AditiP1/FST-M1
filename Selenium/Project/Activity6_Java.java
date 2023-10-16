package ProjActiviies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity6_Java {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        driver.manage().window().maximize();
        driver.findElement(By.id("menu-item-1507")).click();
        String AccTitle= driver.getTitle();
        System.out.println(AccTitle);
        Assert.assertEquals(AccTitle,"My Account – Alchemy LMS");
        driver.findElement(By.className("ld-login-text")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/ul[2]/li[2]/a/span")).getText(),"root");
        driver.close();
    }
}
