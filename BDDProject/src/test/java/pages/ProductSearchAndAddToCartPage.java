package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProductSearchAndAddToCartPage {
	
	WebDriver driver ;
	
	public ProductSearchAndAddToCartPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By txt_searchbox = By.xpath("//form[@id='search_mini_form']//input[@class='input-text']");
	By option_select = By.id("qs-option-3");
	By select_product = By.id("sorter");
	By btn_paging = By.xpath("//div[@class='columns']//div[3]//div[2]//ul[1]//li[2]//a[1]//span[2]");
	By btn_product = By.xpath("//main[@id='maincontent']//img[@alt='Lando Gym Jacket']");
	By btn_size  = By.id("option-label-size-143-item-169");
	By btn_color = By.id("option-label-color-93-item-50");
	By txt_quantity = By.xpath("//*[@id=\"qty\"]");
	By btn_addtocart = By.xpath("//div[@class='product-info-main']//button[@id='product-addtocart-button']");
	
	public void sreachForProduct(String productname) 
	{
		driver.findElement(txt_searchbox).sendKeys(productname);
	}
	
	public void keybordAction() 
	{
		driver.findElement(txt_searchbox).sendKeys(Keys.RETURN);
	}
	
	public void sortProductByName() 
	{
		driver.findElement(select_product).click();
		Select select = new Select(driver.findElement(select_product));
		select.selectByValue("name");
	}
	
	public void scrollToPaging()
	{
		Actions action = new Actions(driver);
		action.scrollByAmount(0,2000).build().perform();
		
	}
	
	public void clickNextPage() 
	{
		driver.findElement(btn_paging).click();
	}
	
	public void scrollToProduct() 
	{
		Actions action = new Actions(driver);
		action.scrollByAmount(0, 900).build().perform();
		driver.findElement(btn_product).click();
	}
}
