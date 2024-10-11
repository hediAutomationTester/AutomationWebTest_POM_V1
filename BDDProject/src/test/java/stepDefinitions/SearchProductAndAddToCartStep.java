package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commun.BasePage;
import commun.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.ProductSearchAndAddToCartPage;

public class SearchProductAndAddToCartStep extends BasePage{
	
	WebDriver driver = Hooks.driver ;
	ProductSearchAndAddToCartPage prodsearch = new ProductSearchAndAddToCartPage(driver);
	
	
	@When("user enters {string} in the search box")
	public void searchProduct(String productname) 
	{
		prodsearch.sreachForProduct(productname);
	}
	
	@And("hits keybord Enter key")
	public void hits_keybord_Enter_key() 
	{
		prodsearch.keybordAction();
	}
	
	@And("clicks on sort product by product name")
	public void clicks_on_sort_product_by_product_name() 
	{
		prodsearch.sortProductByName();
	}
	
	@And("scrolls page to paging toolbar")
	public void scrolls_page_to_paging_toolbar()
	{
		prodsearch.scrollToPaging();
	}
	
	@And("clicks next")
	public void clicks_next() 
	{
		prodsearch.clickNextPage();
	}
	
	@And("scrolls page to product")
	public void scrolls_page_to_Lando_Gym_Jacket_product()  
	{
		prodsearch.scrollToProduct();
	}
}
