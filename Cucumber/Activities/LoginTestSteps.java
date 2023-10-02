package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTestSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on the Login page$")
    public void userIsOnLoginPage() throws Throwable {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        //Open the browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @When("^User enters username and password$")
    public void userEntersUsernameAndPassword() throws Throwable {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//div/button[@type= 'submit']")).click();
    }


    @When("User enters {string} and {string}")
    public void user_enters_and(String username, String password) throws Throwable {
        //Enter username from Feature file
        driver.findElement(By.id("username")).sendKeys(username);
        //Enter password from Feature file
        driver.findElement(By.id("password")).sendKeys(password);
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("^Read the page title and confirmation message$")
    public void ReadThePageTitleAndConfirmationMessage() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Page title: "+driver.getTitle());
        System.out.println("Login Message is: " + loginMessage);
    }

    @And("Close browser")
    public void closeBrowser() throws Throwable {
        driver.close();
    }

}
