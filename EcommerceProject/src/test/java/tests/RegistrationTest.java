package tests;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.RegistrationPage;

public class RegistrationTest extends TestBase{

	RegistrationPage rp ;
	String firstname = "MICHEL";
	String lastname = "ZOULA";
	String email = "test.myppa9997@gmail.com";
	String pwd = "123456Ab.";
	String newpwd = "123456aB.";



	@Test(priority=1)
	@Description("Verify user can register")
	@Severity(SeverityLevel.BLOCKER)

	void Registration() throws InterruptedException
	{
		rp = new RegistrationPage(driver);
		rp.createAccount(firstname,lastname,email,pwd);
		AssertJUnit.assertEquals("My Account", driver.findElement(By.className("base")).getText());
	}

	@Test(priority=2)

	void ChangePassword () 
	{
		rp = new RegistrationPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='customer-name']/descendant::button[@class='action switch']")));
		rp.changePassword(pwd,newpwd);
	}
}