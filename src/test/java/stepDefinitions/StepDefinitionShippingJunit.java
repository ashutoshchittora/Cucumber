/*package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
public class StepDefinitionShippingJunit {
	
	public static WebDriver driver;
	public String text;

	@Given("^Application is launched using Firefox Browser$")
	public void setUp() throws Throwable {

		Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
		Path filePath = Paths.get(root.toString(),"src", "test", "resources","config", "geckodriver1.exe");
		
		String url = "http://apps.qa2qe.cognizant.e-box.co.in/shippingDetails/";
		System.setProperty("webdriver.gecko.driver", filePath.toUri().toString().substring(8));
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,Paths.get(root.toString()).toString());
		
		System.out.println(System.getProperty("user.dir"));
		System.out.println("FileSystems.getDefault().getPath(geckodriver1.exe).toUri().toString() -->"+FileSystems.getDefault().getPath("geckodriver1.exe").toUri().getPath().toString());
		System.out.println("FileSystems.getDefault().getPath(geckodriver1.exe).toUri().toURL().toExternalForm().toString() -->"+FileSystems.getDefault().getPath("geckodriver1.exe").toUri().toURL().toExternalForm().toString());
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
	}

	@When("^(.*) is present and (.*) is clickable$")
	public void testShippingDetails(String shipDet, String linkText) throws Throwable {
	   
		List<WebElement> webElementList = driver.findElements(By.tagName("h2"));
		boolean flag = false;
		for(int i=0;i<=webElementList.size();i++) {
			if(webElementList.get(i).getText().equalsIgnoreCase(shipDet)) {
				flag= true;
				break;
			}			
		}		
			assertTrue(flag);
			if(driver.findElement(By.linkText(linkText)).isEnabled()) {
				driver.findElement(By.linkText(linkText)).click();
				
			}else {
				assert false;
			}
			
	}

	@Then("^(.*) is present$")
	public void validateResult(String mayaText) throws Throwable {
	  
		assertTrue(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td[1]")).getText().equalsIgnoreCase(mayaText));
		driver.close();
	}

	@After
	public void tearDown()
	{
		driver.close();
	}

}*/