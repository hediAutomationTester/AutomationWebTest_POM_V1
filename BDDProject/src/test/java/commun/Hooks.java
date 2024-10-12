package commun;


import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BasePage{

	@Before
	public static void setUpDriver() 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen");
		options.addArguments("--disable-notifications");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		driver= new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
	}
	
	@After
	public static void quitDriver() 
	{
		driver.quit();
	}
}
