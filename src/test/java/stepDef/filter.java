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
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class filter {
    WebDriver driver;
    String baseUrl= "https://saucedemo.com/";
    @Given("dashboard saucedemo")
    public void dashboardSaucedemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String dashboard = driver.findElement(By.xpath("//div[contains(@class,'header_secondary_container')]//span[@class='title'")).getText();
        Assert.assertEquals(dashboard,"Products");
    }

    @When("select filter Z to A")
    public void selectFilterZToA() {
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Name (Z to A)");
    }

    @And("click name Z to A")
    public void clickNameZToA() {
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (low to high)");
    }

    @Then("user get product Z to A")
    public void userGetProductZToA() {
        driver.findElement(By.xpath("//div[contains(text(),'inventory')]"));
        String dashboard = driver.findElement(By.xpath("//div[contains(@class,'header_secondary_container')]//span[@class='title'")).getText();
        Assert.assertEquals(dashboard,"Products");
    }
}
