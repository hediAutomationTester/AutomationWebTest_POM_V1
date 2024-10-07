package tests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import junit.framework.Assert;
import pages.ProductSearchPage;

public class ProductSearchTest extends TestBase {

	
	String productName = "Jack";
	String nbr= "2";
	String qty = "2";



	@Test(priority=1)
	@Severity(SeverityLevel.MINOR)
	void SearchProduct() throws InterruptedException
	{
		ProductSearchPage ps = new  ProductSearchPage(driver);
		Thread.sleep(3000);
		ps.SearchForProduct(productName);
	}

	@Test(priority=2)
	@Severity(SeverityLevel.MINOR)
	void SortProduct()
	{
		ProductSearchPage ps = new  ProductSearchPage(driver);
		ps.SortProduct();
	}

	@Test(priority = 3)
	@Severity(SeverityLevel.MINOR)
	void ChooseProduct()
	{
         ProductSearchPage ps = new  ProductSearchPage(driver);
         ps.ChooseProduct(qty);
      Assert.assertTrue(driver.findElement(By.className("swatch-attribute-selected-option")).isDisplayed());
	}
}