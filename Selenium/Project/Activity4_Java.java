package ProjActiviies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_Java {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        driver.manage().window().maximize();
        WebElement MostPopular2= driver.findElement(By.xpath("//div[2]/article/div[2]/h3"));
        Assert.assertEquals(MostPopular2.getText(),"Email Marketing Strategies");
        driver.close();
    }
}
