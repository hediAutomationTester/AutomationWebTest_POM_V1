package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commun.BasePage;
import commun.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps extends BasePage {

	
	WebDriver driver = Hooks.driver;
	LoginPage lp = new LoginPage(driver);
	
	@Given("user is on login page")
	public void user_login() {
		LoginPage lp = new LoginPage(driver);
		lp.loginLink();
	}

	@When("^user enters username and password$")
	public void enterCredentials(DataTable dataTable)
	{
		List<Map<String, String>> userdata = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> mapdata : userdata) {
			lp.enterUsername(mapdata.get("username"));
			lp.enterPassword(mapdata.get("password"));
		}
	}

	@When("user enters {string} and {string} for credentials")
	public void user_enters_empty_credentials(String username, String password) 
	{
		lp.submitEmptyUsername(username);
		lp.submitEmptyPassword(password);
		lp.Login();
	}


	@Then("user is navigated to home page")
	public void succesLogin() 
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logged-in")));
	}

	@Then("an email error message should be displayed")
	public void an_email_error_message_should_be_displayed()
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='form form-login']//div[@id='email-error']")));
	}

	@Then("a password error message should be displayed")
	public void a_password__error_message_should_be_displayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='message-error error message']")));
	}

	@Then("required fields error message should be displayed")
	public void required_fields_error_message_should_be_displayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass-error")));
	}
}
