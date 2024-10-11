package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import junit.framework.Assert;
import pages.LoginPage;
import pages.ProductSearchPage;

public class ProductSearchTest extends TestBase {

	ProductSearchPage ps;
	LoginPage lp;
	String productName = "Jacket";
	String nbr= "2";
	String email = "test.myppa9995@gmail.com";
	String newpwd = "123456aB.";
	String qty = "2";




	@Test(priority=1)
	@Severity(SeverityLevel.MINOR)
	void SearchProduct()
	{
		ps = new ProductSearchPage(driver);
		ps.SearchForProduct(productName);
	}

	@Test(priority=2)
	@Severity(SeverityLevel.MINOR)
	void SortProduct()
	{
		ps=new ProductSearchPage(driver);
		ps.SortProduct();
	}

	@Test(priority=3)
	@Severity(SeverityLevel.MINOR)
	void ChooseProduct()
	{
		ps =new ProductSearchPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1100)");
		ps.ChooseProduct(qty);
		Assert.assertTrue(driver.findElement(By.className("swatch-attribute-selected-option")).isDisplayed());
	}
}
