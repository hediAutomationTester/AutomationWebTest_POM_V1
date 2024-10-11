package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import junit.framework.Assert;
import pages.LoginPage;

public class LoginTest extends TestBase{

	LoginPage lp ;
	String email = "test.myppa9995@gmail.com";
	String validpwd = "123456Ab.";
	String invalidEmail1 = "123abc@";
	String invalidEmail2 = "123abc.com";
	String invalidEmail3 = "123abc";
	String invalidPwd1 = "abcdefgh";
	String invalidPwd2 = "123456789";
	String invalidPwd3 = "123Ab.";
	String newpwd  ="123456aB.";


	@Test(priority=1)
	@Description("Verify login fonctionality with invalid email / valid password")
	@Severity(SeverityLevel.CRITICAL)
	void  InvalidEmailLogin() throws InterruptedException
	{
		lp=new LoginPage(driver);
		lp.login(invalidEmail1,validpwd);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("send2")));
		
		lp.login(invalidEmail2,validpwd);
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("send2")));
		
		lp.login(invalidEmail3,validpwd);
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("send2")));
	}

	@Test(priority=2)
	@Description("Verify login fonctionality with valid email / invalid password")
	void  InvalidPasswordLogin()
	{
		lp=new LoginPage(driver);
		lp.login(email,invalidPwd1);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div")));

		lp.login(email,invalidPwd2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div")));
		
		lp.login(email,invalidPwd3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div")));
	}

	@Test(priority=3)
	@Description("Verify login fontionnality with empty input credentials")
	void EmptyCredentialsLogin()
	{
		lp= new LoginPage(driver);
		lp.login("","");
		Assert.assertTrue(driver.findElement(By.id("email-error")).isDisplayed());
	}

	@Test(priority=4)
	@Description("Verify login fonctionality with valid email / valid password")
	@Severity(SeverityLevel.BLOCKER)
	void ValidCredentialsLogin()
	{
		lp = new LoginPage(driver);
		lp.login(email,newpwd);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logged-in")));
	}

	@Test(priority=5)
	void SignOut()
	{
		lp = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='panel header']//button[@type='button']")));
		lp.Signout();
	}

}

