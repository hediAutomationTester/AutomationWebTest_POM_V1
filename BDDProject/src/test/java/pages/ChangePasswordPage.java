package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangePasswordPage {

	WebDriver driver;

	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	By btn_myAccount = By.xpath("//div[@class='panel header']//button[@type='button']");
	By option_myAccount = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a");
	By btn_changePassword = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[2]/a[2]");
	By txt_currentPassword = By.id("current-password");
	By txt_newPassword = By.id("password");
	By txt_passwordConfirmation = By.id("password-confirmation");
	By btn_save = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");

	public void myAccountSelect()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfElementLocated(btn_myAccount));
		driver.findElement(btn_myAccount).click();
		driver.findElement(option_myAccount).click();
	}

	public void changePasswordLink()
	{
		driver.findElement(btn_changePassword).click();
	}

	public void enterCurrentPassword(String password) 
	{
		driver.findElement(txt_currentPassword).clear();
		driver.findElement(txt_currentPassword).sendKeys(password);
	}

	public void enterNewPassword(String newpassword) 
	{
		driver.findElement(txt_newPassword).clear();
		driver.findElement(txt_newPassword).sendKeys(newpassword);
	}

	public void confirmNewPassword(String newpassword) 
	{
		driver.findElement(txt_passwordConfirmation).clear();
		driver.findElement(txt_passwordConfirmation).sendKeys(newpassword);
	}

	public void saveNewPassword()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(btn_save));
		driver.findElement(btn_save).click();
	}
}
