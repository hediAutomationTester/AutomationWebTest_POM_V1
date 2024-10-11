package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	
	WebDriver driver ;
	
	public RegistrationPage(WebDriver driver) 
	{
		this.driver =driver ;
	}
	
	By btn_createAccount = By.linkText("Create an Account");
	By txt_firstname = By.xpath("//form[@class='form create account form-create-account']//input[@id='firstname']");
	By txt_lastname = By.xpath("//form[@class='form create account form-create-account']//input[@id='lastname']");
	By txt_email = By.xpath("//form[@class='form create account form-create-account']//input[@id='email_address']");
	By txt_password = By.xpath("//form[@class='form create account form-create-account']//input[@id='password']");
	By txt_passwordConfirm = By.xpath("//form[@class='form create account form-create-account']//input[@name='password_confirmation']");
	By btn_Submit = By.xpath("//form[@class='form create account form-create-account']//button[@class='action submit primary']");
	By btn_changePassword = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[2]/a[2]");
	By txt_currentPassword = By.id("current-password");
	By txt_newPassword = By.id("password");
	By txt_passwordConfirmation = By.id("password-confirmation");
	By btn_save = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");
	By btn_myAccount = By.xpath("//span[@class='customer-name']//button[@class='action switch']");
	By btn_signout = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");

	public void createAccount() 
	{
		driver.findElement(btn_createAccount).click();
	}
	
	public void enterFirstname(String firstname) 
	{
		driver.findElement(txt_firstname).sendKeys(firstname);
	}
	
	public void enterLastname(String lastname) 
	{
		driver.findElement(txt_lastname).sendKeys(lastname);
	}
	
	public void enterEmail(String email) 
	{
		driver.findElement(txt_email).sendKeys(email);
	}

	public void enterpassword(String password)
	{
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void enterConfirmPassword(String password) 
	{
		driver.findElement(txt_passwordConfirm).sendKeys(password);
	}
	
	public void submit()
	{
		driver.findElement(btn_Submit).click();
	}
}

