package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl= "https://saucedemo.com/inventory.html";
    @Given("Halaman login saucedemo")
    public void halamanLoginSaucedemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(@class,'login_logo')]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
    }

    @When("Input username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("User in on dashboard")
    public void userInOnDashboard() {
        driver.findElement(By.xpath("//div[contains(text(),'inventory')]"));
        String username = driver.findElement(By.xpath("//div[contains(@class,'header_secondary_container')]//span[@class='title']")).getText();
        Assert.assertEquals(username, "standard_user");
    }

    @And("input empty password")
    public void inputEmptyPassword() {
        driver.findElement(By.id("password")).sendKeys("");
    }

    @Then("User get error message empty password")
    public void userGetErrorMessageEmptyPassword() {
        String ErrorLogin = driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
        Assert.assertEquals(ErrorLogin,"Epic sadface: Password is required");
    }
}
