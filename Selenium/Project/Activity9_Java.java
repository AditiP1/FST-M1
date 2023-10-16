package ProjActiviies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity9_Java {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        driver.manage().window().maximize();
        driver.findElement(By.id("menu-item-1507")).click();
        driver.findElement(By.className("ld-login-text")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();

        driver.findElement(By.id("menu-item-1508")).click();
        driver.findElement(By.className("ld_course_grid_button")).click();
        driver.findElement(By.xpath("//div[3]/div[2]/div[1]/div[1]/a/div[2]")).click();
        String course=driver.getTitle();
        Assert.assertEquals(course, "Developing Strategy – Alchemy LMS");

        //WebElement status= driver.findElement(By.className("ld-status-complete"));
        WebElement status= driver.findElement(By.xpath("//div[2]/div[2]/div/div/div[1]/div/div[2]"));
        System.out.println("Here is the value " +status.getText());
        Assert.assertEquals(status.getText(),"COMPLETE");
        driver.close();

    }
}
