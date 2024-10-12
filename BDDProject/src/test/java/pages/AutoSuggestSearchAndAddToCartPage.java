package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AutoSuggestSearchAndAddToCartPage {

	WebDriver driver;

	public AutoSuggestSearchAndAddToCartPage(WebDriver driver) {
		this.driver = driver;
	}

	By txt_searchbox = By.xpath("//form[@id='search_mini_form']/descendant::input[@class='input-text']");
	By option_select = By.id("qs-option-2");
	By select_product = By.id("sorter");
	By btn_product = By.xpath("//*[@id='maincontent']/descendant::img[@alt='Lando Gym Jacket']");
	By btn_size = By.id("option-label-size-143-item-169");
	By btn_color = By.id("option-label-color-93-item-50");
	By txt_quantity = By.xpath("//*[@id=\"qty\"]");
	By btn_addtocart = By.xpath("//div[@class='product-info-main']/descendant::button[@id='product-addtocart-button']");

	public void autosuggestProductSearch(String productname) {
		driver.findElement(txt_searchbox).sendKeys(productname);
	}

	public void selectProduct() {
		driver.findElement(option_select).click();
	}

	public void sortByPrice() {
		driver.findElement(select_product).click();
		Select select = new Select(driver.findElement(select_product));
		select.selectByValue("price");
	}

	public void chooseProduct() {
		Actions action = new Actions(driver);
		action.scrollToElement(driver.findElement(btn_product)).perform();
		driver.findElement(btn_product).click();
	}

	public void chooseProductOptions(String qty) {
		driver.findElement(btn_size).click();
		driver.findElement(btn_color).click();
		driver.findElement(txt_quantity).clear();
		driver.findElement(txt_quantity).sendKeys(qty);
	}

	public void addToCart() {
		driver.findElement(btn_addtocart).click();
	}
}
