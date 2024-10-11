package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductorderPage {

	WebDriver driver ;
	public ProductorderPage(WebDriver driver)
	{
		this.driver = driver ;
	}

	By cart_link = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
	By checkout_btn = By.id("top-cart-btn-checkout");
	By signin_Btn = By.xpath("//*[@id=\"checkout\"]/div[1]/button");
	By email_Txt = By.xpath("//form[@data-role='login']//input[@id='login-email']");
	By password_Txt = By.xpath("//form[@data-role='login']//input[@id='login-password']");
	By signin_btn = By.xpath("//form[@data-role='login']//button[@type='submit']");
	By email_txt = By.xpath("//form[@class='form form-login']//input[1]");
	By password_txt = By.xpath("//form[@class='form form-login']//input[2]");
	By login_btn = By.xpath("//form[@data-role='login']//button[@class='action action-login secondary']");
	By company_txt = By.xpath("//form[@id='co-shipping-form']//input[3]");
	By street_txt = By.xpath("//form[@id='co-shipping-form']//input[4]");
	By street2_txt = By.xpath("//form[@id='co-shipping-form']//input[5]");
	By street3_txt = By.xpath("//form[@id='co-shipping-form']//input[6]");
	By city_txt = By.xpath("//form[@id='co-shipping-form']//input[7]");
	By province_select = By.xpath("//form[@id='co-shipping-form']//select[@name='region_id']");
	By zip_txt = By.xpath("//form[@id='co-shipping-form']//input[9]");
	By country_select = By.xpath("//form[@id='co-shipping-form']//select[@name='country_id']");
	By phone_txt = By.xpath("//form[@id='co-shipping-form']//input[10]");
	By shipMethod_btn = By.xpath("//div[@id='checkout-shipping-method-load']//input[@value='tablerate_bestway']");
	By next_btn = By.xpath("//form[@id='co-shipping-method-form']//button[@class='button action continue primary']");
	By btn_shiphere = By.xpath("//footer[@class='modal-footer']//button[@class='action primary action-save-address']");
	By btn_next = By.xpath("//form[@id='co-shipping-method-form']//button[@class='button action continue primary']");
	By placeorder_btn = By.xpath("//form[@id='co-payment-form']//button[@class='action primary checkout']");
	By checkbox_billing = By.xpath("//div[@class='payment-method-content']//input[@id='billing-address-same-as-shipping-checkmo']");
	
	public void addProductToCart ()
	{
		driver.findElement(cart_link).click();
	}
	
	public void checkoutBtn () 
	{
		driver.findElement(checkout_btn).click();
	}

	public void userSignin()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkout\"]/div[1]/button")));
		driver.findElement(signin_Btn).click();
	}

	public void enterEmail (String useremail)
	{
		driver.findElement(email_Txt).sendKeys(useremail);
	}

	public void enterPassword(String userpassword) 
	{

		driver.findElement(password_Txt).sendKeys(userpassword);
	}

	public void submitLogin() 
	{
		driver.findElement(signin_btn).click();
	}

	public void enterCompany(String company)
	{
		driver.findElement(company_txt).sendKeys(company);
	}

	public void enterStreet(String street)
	{
		driver.findElement(street_txt).sendKeys(street);

	}

	public void enterCity(String city) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(city_txt));
		driver.findElement(city_txt).sendKeys(city);
	}

	public void enterProvince()
	{
		Select select = new Select(driver.findElement(province_select));
		select.selectByIndex(2);
	}


	public void enterZipCode(String zip) 
	{
		driver.findElement(zip_txt).sendKeys(zip);

	}

	public void selectCountry() throws InterruptedException 
	{
		Select select2 = new Select(driver.findElement(country_select));
		select2.selectByIndex(2);
		Thread.sleep(3000);
	}

	public void enterPhone (String phone ) throws InterruptedException 
	{
		driver.findElement(phone_txt).sendKeys(phone);
		Thread.sleep(3000);
	}

	public void shipingMethod() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.elementToBeClickable(shipMethod_btn));
		driver.findElement(shipMethod_btn).click();
	}

	public void nextBtn() 
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(btn_next));
		driver.findElement(btn_next).click();
	}

	public void placeholderBtn() throws InterruptedException 
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.elementToBeClickable(placeorder_btn));
		driver.findElement(placeorder_btn).click();
	}

	public void purchaseValidation() 
	{
		driver.findElement(By.xpath("//span[@class='base']")).getText().equalsIgnoreCase("Thank you for your purchase!");
	}
}
