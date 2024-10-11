package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commun.BasePage;
import commun.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AutoSuggestSearchAndAddToCartPage;

public class AutoSuggestSearcAndAddToCartStep extends BasePage {

	WebDriver driver = Hooks.driver;
	AutoSuggestSearchAndAddToCartPage ps = new AutoSuggestSearchAndAddToCartPage(driver);


	@Given("user is on home page")
	public void user_is_on_home_page() 
	{
		Assert.assertTrue(driver.findElement(By.xpath("//form[@id='search_mini_form']//input[@class='input-text']")).isDisplayed());
	}

	@When("user enters a part of productname {string} in the search box")
	public void user_enters_a_part_of_the_product_name_in_the_search_box(String productname) {
		ps.autosuggestProductSearch(productname);
	}
	
	
	@And("choose the second suggested option")
	public void choose_the_second_suggested_option() 
	{
		ps.selectProduct();
	}
	
	@And("clicks on sort product by price")
	public void clicks_on_sort_product_by_price() 
	{
		ps.sortByPrice();
	}
	
	@And("scrolls page to Lando Gym Jacket product")
	public void scrollPage() 
	{
		ps.chooseProduct();
	}
	
	@And("choose the size the color and the desired quantity {string}")
	public void choose_the_size_the_color_the_desired_quantity(String qty) 
	{
		ps.chooseProductOptions(qty);
	}
	
	@And("clicks add to cart button")
	public void clicks_add_to_cart_button() 
	{
		ps.addToCart();
	}
	
	@Then("the product is added to cart")
	public void the_product_is_added_to_cart() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.counter-number"))).getText().contentEquals("2");
	}
}
