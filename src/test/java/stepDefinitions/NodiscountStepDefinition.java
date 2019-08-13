/*package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class NodiscountStepDefinition {

	private static WebDriver driver;
	public String text;
	String url = "http://apps.qa2qe.cognizant.e-box.co.in/CompanyOffersDiscount/";

	@Given("^Datax NoDiscount application is launched using firefox$")
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

	@When("^i enter (\\d+) , (\\d+) for no discount and click submit$")
	public void testNodiscount(int wt, int dist) throws Throwable {
	    
	    driver.findElement(By.xpath("//*[@id=\"weight\"]")).clear();
	    driver.findElement(By.xpath("//*[@id=\"distance\"]")).clear();
	    
	    driver.findElement(By.xpath("//*[@id=\"weight\"]")).sendKeys(String.valueOf(wt));
	    driver.findElement(By.xpath("//*[@id=\"distance\"]")).sendKeys(String.valueOf(dist));
	    
	    driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	    
	}

	@Then("^i should get no discount (.*)$")
	public void validateResult(String msg) throws Throwable {
	    text = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
	    assertTrue(text.equalsIgnoreCase(msg));
	    driver.quit();	    
	}
	
}
*/