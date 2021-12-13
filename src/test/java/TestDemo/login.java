package TestDemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
  WebDriver driver;

  @Given("^User navigates to Facebook$")
  public void user_navigates_to_Facebook() {
    //        System.setProperty("webdriver.gecko.driver", "C:/Program
    // Files/geckodriver/geckodriver.exe");
    driver = new ChromeDriver();
    driver.navigate().to("https://www.facebook.com/");
    // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @When("^I enter username as \"([^\"]*)\"$")
  public void i_enter_username_as(String userName) {
    driver.findElement(By.id("email")).sendKeys(userName);
  }

  @When("^I enter password as \"([^\"]*)\"$")
  public void i_enter_password_as(String pass) {
    driver.findElement(By.id("pass")).sendKeys(pass);
  }

  @When("^I click Login button$")
  public void i_click_Login_button() {
    // Write code here that turns the phrase above into concrete actions
    driver.findElement(By.xpath("//button[@type='submit']")).click();
  }

  @Then("^Login should fail$")
  public void login_should_fail() {
    System.out.println("Login failed");
    driver.quit();
  }

  @Then("^Relogin option should be available$")
  public void relogin_option_should_be_available() {
    if (driver
        .getCurrentUrl()
        .equalsIgnoreCase("https://www.facebook.com/login.php?login_attempt=1&lwv=110")) {
      System.out.println("Test Pass");
    } else {
      System.out.println("Test Failed");
    }
    // driver.quit();
  }
}
