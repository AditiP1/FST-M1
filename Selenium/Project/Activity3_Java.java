package ProjActiviies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3_Java {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        driver.manage().window().maximize();
        String text1= driver.findElement(By.xpath("//div[1]/div[2]/div/div/div/div/div[2]/h3")).getText();
        System.out.println("The  title of the first info box is : "+text1);
        Assert.assertEquals(text1,"Actionable Training");
        driver.close();

    }
}
