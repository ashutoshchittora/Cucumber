/*package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class StepDefinition {

	private static WebDriver driver;
	public String text;
	String url = "http://apps.qa2qe.cognizant.e-box.co.in/CustomerRegistration/Index"; 
	
	@Given("^I access Customer Registration using firefox$")
	public void setUp() throws Throwable {
		
		Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
		Path filePath = Paths.get(root.toString(),"src", "test", "resources","config", "geckodriver1.exe");		
		
		System.setProperty("webdriver.gecko.driver", filePath.toUri().toString().substring(8));
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");		
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		driver.get(url);
	}

	@When("^I enter \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" for \"([^\"]*)\"$")
	public void testCustomerRegistration(String custName, String age, String addrs, String phNo, String email, String status) throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"agent-form\"]/table/tbody/tr[1]/td[2]/input")).sendKeys(custName);
		driver.findElement(By.xpath("//*[@id=\"agent-form\"]/table/tbody/tr[2]/td[2]/input")).sendKeys(age);
		driver.findElement(By.xpath("//*[@id=\"agent-form\"]/table/tbody/tr[3]/td[2]/input")).sendKeys(addrs);
		driver.findElement(By.xpath("//*[@id=\"agent-form\"]/table/tbody/tr[4]/td[2]/input")).sendKeys(phNo);
		driver.findElement(By.xpath("//*[@id=\"agent-form\"]/table/tbody/tr[5]/td[2]/input")).sendKeys(email);
			    
	}

	@Then("^I click \"([^\"]*)\" and verify the \"([^\"]*)\" and \"([^\"]*)\" for \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void validateResult(String subBtn, String status, String msg, String custName, String age, String addrs, String phNo, String email) throws Throwable {

		if(subBtn.equalsIgnoreCase("submit")) {
			//submit click
			driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
			
		}else {
			// reset click
			driver.findElement(By.xpath("//*[@id=\"reset\"]")).click();	
		}

		switch (status) {
		case "Pass":
			assertTrue(driver.findElement(By.xpath("/html/body/h2")).getText().equalsIgnoreCase(msg));			
			break;
		
		case "Fail":
			if(!custName.isEmpty()) {
				assertTrue(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText().equalsIgnoreCase(msg));
			}else {
				//assertTrue(driver.findElement(By.xpath("//*[@id=\"message\"]")).getText().matches("Customer name|Age|Address|phoneNumber|Email|cannot be blank"));
				
				String expectedValue = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();
				//assertTrue(Stream.of("Customer name","Age","Address","phoneNumber","Email","cannot be blank").anyMatch(expectedValue::equalsIgnoreCase));
				//StringUtils.equalsAnyIgnoreCase(expectedValue, "Customer name","Age","Address","phoneNumber","Email","cannot be blank");
				List<String> inputMsg = Arrays.asList(msg.split(";"));
				List<String> outMsg = Arrays.asList(expectedValue.split("/n"));
				outMsg.stream().allMatch(inputMsg::contains);
			}
			break;
			
		case "Reset":
			assertTrue(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).getText().isEmpty());
			assertTrue(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).getText().isEmpty());
			assertTrue(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input")).getText().isEmpty());
			assertTrue(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input")).getText().isEmpty());
			assertTrue(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input")).getText().isEmpty());
			break;
					
			
		default:
			break;
		}
	    	    
	    driver.quit();	    
	}
	
}






*/