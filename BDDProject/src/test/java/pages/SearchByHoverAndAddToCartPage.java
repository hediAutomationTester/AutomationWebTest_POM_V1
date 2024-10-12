package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchByHoverAndAddToCartPage {

	
	WebDriver driver ;
	
	public SearchByHoverAndAddToCartPage(WebDriver driver)
	{
		this.driver=driver ;	}
	
	By btn_product = By.xpath("//main[@id='maincontent']//img[@alt='Lando Gym Jacket']");
	By btn_size  = By.id("option-label-size-143-item-169");
	By btn_color = By.id("option-label-color-93-item-50");
	By txt_quantity = By.xpath("//*[@id=\"qty\"]");
	By btn_addtocart = By.xpath("//div[@class='product-info-main']//button[@id='product-addtocart-button']");
	By hover_main =  By.xpath("//div[@id='store.menu']//a[@id='ui-id-5']");
	By hover_sub_tops = By.id("ui-id-17");
	By hover_sub_jackets = By.id("ui-id-19");
	
	public void hoverMainMenu() 
	{
		WebElement hovmain = driver.findElement(hover_main);
		
		Actions action = new Actions(driver);
		action.moveToElement(hovmain).perform();
	}
	
	public void hoverSubTop() 
	{
		WebElement hovtop = driver.findElement(hover_sub_tops);
		Actions action = new  Actions(driver);
		action.moveToElement(hovtop).perform();
	}
	
	public void hoverJackets() 
	{
		WebElement hovjacket = driver.findElement(hover_sub_jackets);
			Actions action = new  Actions(driver);
			action.moveToElement(hovjacket).click().perform();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
