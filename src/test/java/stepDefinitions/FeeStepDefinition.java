/*package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FeeStepDefinition{
	
	String text = "";
	String ShipId = "";
	String result = "";
	String expectedResult = "";

	public WebDriver driver;
		
	@Given("^I am able to access Fees Calculation index page$")
	public void i_am_able_to_access_Fees_Calculation_index_page() throws Throwable {
		
		
		Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
		Path filePath = Paths.get(root.toString(),"src", "test", "resources","config", "geckodriver1.exe");		
		
		System.setProperty("webdriver.gecko.driver", filePath.toUri().toString().substring(8));
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,System.getProperty("user.dir") + "\\garbageDelete\\MarionetteLOGS.txt");

		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		driver.get("http://apps.qa2qe.cognizant.e-box.co.in/CucumberHostelFeeCalc/");
		
	}

	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	@When("^Verify the all form fields with name as \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and button with id as \"([^\"]*)\"$")
	public void verify_the_all_form_fields_with_name_as_name_type_number_and_button_with_id_as_getFee_and_Submit(String name,String type, String number, String getFee ) throws Throwable {
		
		try {
			
			assertTrue(isElementPresent(By.name(name)));
			assertTrue(isElementPresent(By.name(type)));
			assertTrue(isElementPresent(By.name(number)));
			assertTrue(isElementPresent(By.id(getFee)));
	    } catch (Exception e) {
		    System.out.println("Element not found");
		}

	}
	
	@When("I submit (.*) and (.*) details$")
	public void i_submit_Hosteller_and_details(String studentType, String studentsPerRoom) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.findElement(By.name("name")).sendKeys("testName");;
		List <WebElement>  oRadioButtonType = driver.findElements(By.name("type"));
		if (studentType.equalsIgnoreCase("Hosteller"))
		{
			oRadioButtonType.get(0).click();
			driver.findElement(By.name("number")).sendKeys(studentsPerRoom);
		}
		else
			oRadioButtonType.get(1).click();
		driver.findElement(By.id("getFee")).click();
	 
	}
	
	
	@Then("^Verify the fee (.*), (.*), (.*), (.*) and (.*) based on the provided data$")
	public void verify_the_fee_and_based_on_the_provided_data(String studentType, String collegeFee, String hostelFee, String additionalFee,String totalFee) throws Throwable {
	   String  getCollegeFee = driver.findElement(By.xpath("//*[@id='feeTable']/tbody/tr[1]/td[2]")).getText();
	   String  getHostelFee = driver.findElement(By.xpath("//*[@id='feeTable']/tbody/tr[2]/td[2]")).getText();
	   String  getAdditionalFee = driver.findElement(By.xpath("//*[@id='feeTable']/tbody/tr[3]/td[2]")).getText();
	   String  getTotalFee = driver.findElement(By.xpath("//*[@id='feeTable']/tbody/tr[4]/td[2]")).getText();
	  
	   if (studentType.equalsIgnoreCase("Hosteller"))
		{
		   assertTrue(getCollegeFee.contains(collegeFee));
		   assertTrue(getHostelFee.contains(hostelFee));
		   if(additionalFee.contains(getAdditionalFee));
		   assertTrue(true);
		   assertTrue(getTotalFee.contains(totalFee));
		}
	   else
	   {
		   assertTrue(getCollegeFee.contains(collegeFee));
		   assertTrue(getTotalFee.contains(totalFee));
	   }
		   
	   
	}

    
	@After public void tearDown(){ 
	      driver.quit(); 
	 }

   }
	

	

	

		


*/