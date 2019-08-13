package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/User.feature", 
		glue = {"stepDefinitions" }, 
		monochrome = false, 
		plugin = { "html:target/cucumber","json:target/cucumber-report.json" }, 
		strict = true)

public class UserJunit {

}