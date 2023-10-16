package ProjActiviies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity7_Java {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        driver.manage().window().maximize();
        driver.findElement(By.id("menu-item-1508")).click();


        List<WebElement> elementlist=driver.findElements(By.xpath("//article/div[2]/h3"));
        for(WebElement cell : elementlist) {
            System.out.println(cell.getText());
        }
        driver.close();
    }
}
