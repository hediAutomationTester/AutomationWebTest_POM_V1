package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import junit.framework.Assert;
import pages.ProductOrderPage;

public class ProductOrderTest extends TestBase{

	ProductOrderPage po ;


	@Test(priority=1)
	@Severity(SeverityLevel.BLOCKER)
	public void Login() throws InterruptedException
	{
		po= new  ProductOrderPage(driver);
		po.Login("test.myppa9995@gmail.com", "123456aB.");
		Thread.sleep(10000);
	}


	@Test(priority=2)
	public void EditShipping() throws InterruptedException
	{
		po = new ProductOrderPage(driver);
		Thread.sleep(3000);
		try {
			WebElement element =driver.findElement(By.xpath("//div[@class='page-wrapper']/descendant::button[@class='action action-show-popup']"));
			if (element.isDisplayed()) {
				po.newAdress();
				po.CheckCart("coding","Republic","21","Street","Texas","Paris");
				po.Zip("43567");
				po.CountrySelect();
				po.shiphere("12345678");

			} else {

				po.CheckCart("coding","Republic","21","Street","Texas","Paris");
				po.Zip("43567");
				po.CountrySelect();
				po.ContinueShipping("12345678");

			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("newAdress link is not found"  + e);

		}	
	}

	@Test(priority=3)
	public void FinishShipping() throws InterruptedException
	{
		po= new ProductOrderPage(driver);
		po.placeOlderShipping();
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='base']")).getText(), "Thank you for your purchase!");
	}
}