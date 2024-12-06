package commun;


import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
		Map<String, Object> networkPrefs = new HashMap<>();
		networkPrefs.put("urls", Arrays.asList("*://*.googleads.g.doubleclick.net/*", "*://*.googlesyndication.com/*"));
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-logging"));
		options.setExperimentalOption("prefs", networkPrefs);
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
