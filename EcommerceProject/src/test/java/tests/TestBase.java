package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



public class TestBase {

	public static  WebDriver driver ;

	@BeforeSuite
	@Parameters("browser")
	public void StartDriver(@Optional("chrome") String browser) {

		if (browser.equalsIgnoreCase("chrome"))

		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-search-engine-choice-screen");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			driver.get("https://magento.softwaretestingboard.com");
			driver.manage().window().maximize();
		}

		else if (browser.equalsIgnoreCase("firefox"))

		{
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-search-engine-choice-screen");
			driver = new FirefoxDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			driver.get("https://magento.softwaretestingboard.com");
			driver.manage().window().maximize();
		}

		else if (browser.equalsIgnoreCase("edge"))

		{
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-search-engine-choice-screen");
			driver = new EdgeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			driver.get("https://magento.softwaretestingboard.com");
			driver.manage().window().maximize();
		}
	}


	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
}
