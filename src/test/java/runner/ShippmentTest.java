package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

/*
 * plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
 * "junit:target/cucumber-reports/Cucumber.xml", "html:target/cucumber-reports},
 */// html:target/cucumber", "json:target/cucumber-report.json

@CucumberOptions(
		features = "src/test/resources/features", 
		tags = {"@Shipment1,@Shipment2,@Shipment3,@Shipment4,@Shipment5"},
		glue = {"stepDefinitions" },		
		monochrome = false, 
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
				"junit:target/cucumber-reports/Cucumber.xml", "html:target/cucumber-reports" },
		strict = true)

public class ShippmentTest {

}
