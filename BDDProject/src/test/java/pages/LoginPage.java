package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver ;

	public LoginPage(WebDriver driver) 
	{
		this.driver =driver ;
	}

	By btn_login = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");
	By txt_email = By.xpath("//form[@class='form form-login']//input[@id='email']");
	By txt_password = By.xpath("//form[@class='form form-login']//input[@id='pass']");
	By btn_signin = By.xpath("//form[@id='login-form']//button[@class='action login primary']");
	By btn_myAccount = By.xpath("//div[@class='panel header']//button[@type='button']");
	By option_myAccount = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a");
	By btn_signout = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");

	public void loginLink() 
	{
		driver.findElement(btn_login).click();
	}

	public void enterUsername(String username ) 
	{

		driver.findElement(txt_email).clear();
		driver.findElement(txt_email).sendKeys(username);

	}

	public void enterPassword(String password)
	{
		driver.findElement(txt_password).clear();
		driver.findElement(txt_password).sendKeys(password);

	}

	public void Login()
	{
		driver.findElement(btn_signin).click();
	}

	public void submitEmptyUsername(String username) 
	{
		driver.findElement(txt_email).clear();
		driver.findElement(txt_email).sendKeys(username);
	}

	public void submitEmptyPassword(String password)
	{
		driver.findElement(txt_password).clear();
		driver.findElement(txt_password).sendKeys(password);
	}


	public void Signout() 
	{
		driver.findElement(btn_myAccount).click();
		driver.findElement(btn_signout).click();
	}

}
