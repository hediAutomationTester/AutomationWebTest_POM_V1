package testng.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\eclipse-workspace\\AutomationWebTest_POM_V1\\BDDProject\\src\\test\\resources\\Features",
glue = { "commun", "pages", "stepDefinitions",
		"testng.runner" }, plugin = { "pretty", "html:target/HtmlReports/index.html",
				"json:target/JsonReports/report.json",
				"junit:target/JUnitReports/report.xml" }, monochrome = true, tags="Register")

public class RunCucumberTest {

}