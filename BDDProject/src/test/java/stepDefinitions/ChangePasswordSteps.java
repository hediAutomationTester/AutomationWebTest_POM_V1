package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commun.BasePage;
import commun.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ChangePasswordPage;
import pages.LoginPage;

public class ChangePasswordSteps extends BasePage {

	WebDriver driver = Hooks.driver;
	LoginPage lp = new LoginPage(driver);
	ChangePasswordPage pwdchange = new ChangePasswordPage(driver);

	@When("user enters {string} and {string}")
	public void user_enters_email_and_password(String username, String password) {
		lp.submitEmptyUsername(username);
		lp.submitEmptyPassword(password);
	}

	@And("hits on login button")
	public void clickLogin(){
		lp.Login();
	}

	@And("select my account")
	public void select_my_account()
	{
		pwdchange.myAccountSelect();
	}

	@And("clicks on change password link")
	public void clicks_on_change_password_link() {
		pwdchange.changePasswordLink();
	}

	@And("enters current password {string}")
	public void enters_current_password(String password) 
	{
		pwdchange.enterCurrentPassword(password);
	}

	@And("enters new password {string}")
	public void enters_new_password(String newpassword) 
	{
		pwdchange.enterNewPassword(newpassword);
	}

	@And("enters new confirm password {string}")
	public void enters_new_confirm_password(String newpassword) 
	{
		pwdchange.confirmNewPassword(newpassword);
	}


	@And("clicks on save button")
	public void clicks_on_save_button()
	{
		pwdchange.saveNewPassword();
	}

	@Then("password is successfully changed")
	public void password_is_successfully_changed()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("\"//div[@class='message-success success message']//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")));
	}

	@Then("an error message is displayed")
	public void an_error_message_is_displayed() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='password-confirmation-error']")));
	}
}
