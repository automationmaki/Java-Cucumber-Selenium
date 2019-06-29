package stepFiles;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\udemy\\CucumberFramework\\drivers\\chromedriver.exe" );
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
    }
    @Given("^User navigates to stackoverflow website$")
    public void user_navigates_to_stackoverflow_website() throws Throwable {
        driver.get("https://stackoverflow.com/");
    }

    @And("^User clicks on the login button on homepage$")
    public void user_cliocks_on_the_login_button_on_homepage() throws Throwable {
        System.out.println("Method2");
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
    }

    @And("^User enters a valid username$")
    public void user_enters_a_valid_username() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("autotestudemy@mail.com");
    }

    @And("^User enters a valid password$")
    public void user_enters_a_valid_password() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Password321!");
    }

    @When("^User clicks on the login button$")
    public void user_clicks_on_the_login_button() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"submit-button\"]")).click();
    }

    @Then("^User should be taken to the successful login page$")
    public void user_should_be_taken_to_the_succesfful_login_page() throws Throwable {
        WebElement askQuestionButton = driver.findElement(By.xpath("//a[contains(text(), 'Ask Question')]"));
        Assert.assertEquals(true, askQuestionButton.isDisplayed());
    }

    @After
    public void tearDown(){
//        Thread.sleep(3000);
        this.driver.manage().deleteAllCookies();
        this.driver.quit();
        this.driver = null;
    }
}
