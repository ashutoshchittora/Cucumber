/*package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class StepDefinitionUser {

	private static WebDriver driver;
	public String text;
	String url = "http://apps.qa2qe.cognizant.e-box.co.in/Handling_Reg_Expression/";
	
	@Given("^Application is launched by Firefox Browser$")
	public void application_is_launched_by_Firefox_Browser() throws Throwable {
		
		Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
		Path filePath = Paths.get(root.toString(),"src", "test", "resources","config", "geckodriver1.exe");		
		
		System.setProperty("webdriver.gecko.driver", filePath.toUri().toString().substring(8));
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");		
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		
	}

	@When("^I enter name in the textbox and click search$")
	public void i_enter_name_in_the_textbox_and_click_search(DataTable dataTable) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<String> list = dataTable.asList(String.class);
		for(String value : list) {
			driver.get(url);
			driver.findElement(By.xpath("//*[@id=\"userId\"]")).sendKeys(value);
			driver.findElement(By.xpath("//*[@id=\"track\"]")).click();
		}
	    
	}

	@Then("^user details like (.*),(.*),(.*),(.*) is shown$")
	public void user_details_like_is_shown(String name, String shipId, String phNo, String email) throws Throwable {

	    text = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
	    assertTrue(text.contains(name));
	    assertTrue(text.contains(shipId));
	    assertTrue(text.contains(phNo));
	    assertTrue(text.contains(email));
	    driver.quit();	    
	}
	
}
*/