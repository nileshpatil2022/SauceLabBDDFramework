package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {".//Feature//CompleteOrder.feature"},
		glue={"stepDefinition"},
		dryRun = false,
		monochrome = true,
		tags = "@Functional",//scenarios under @sanity tag will be executed
		plugin = {"pretty","html:target/cucumber-reports.html"}
		
		//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)


public class TestRunner extends AbstractTestNGCucumberTests {

}
