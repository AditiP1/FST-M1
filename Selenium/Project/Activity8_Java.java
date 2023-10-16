package ProjActiviies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_Java {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        driver.manage().window().maximize();
        driver.findElement(By.id("menu-item-1506")).click();
        driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Durga Kundu");
        driver.findElement(By.id("wpforms-8-field_1")).sendKeys("DurgaKundu123@gmail.com");
        driver.findElement(By.id("wpforms-8-field_3")).sendKeys("Durga Kundu Test");
        driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Test automation run for activity 8_java");
        driver.findElement(By.id("wpforms-submit-8")).click();
        System.out.println(driver.findElement(By.id("wpforms-confirmation-8")).getText());
        driver.close();

    }
}
