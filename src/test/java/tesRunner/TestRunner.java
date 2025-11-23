package tesRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {".//Feature//Logout.feature"},
		glue={"stepDefinition"},
		dryRun = false,
		monochrome = true,
		tags = "@Test",//scenarios under @sanity tag will be executed
		plugin = {"pretty","html:target/cucumber-reports.html"}
		
		
		)


public class TestRunner extends AbstractTestNGCucumberTests {

}
