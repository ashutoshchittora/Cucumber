package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import org.openqa.selenium.chrome.*;

public class StepDefinition1 {

	String text = "";
	String result = "";
	String expectedResult = "";

	public WebDriver driver;

	@Given("^I open the Shipment1 page$")
	public void i_open_the_Shipment1_page() throws Throwable {
		Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
//		Path filePath = Paths.get(root.toString(), "src", "test", "resources", "config", "geckodriver1.exe");		
		//System.setProperty("webdriver.gecko.driver", filePath.toUri().toString().substring(8));
		//System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,	System.getProperty("user.dir") + "\\garbageDelete\\MarionetteLOGS.txt");
		//driver = new FirefoxDriver();
		Path filePath = Paths.get(root.toString(), "src", "test", "resources", "config", "chromedriver276.exe");	
		System.setProperty("webdriver.chrome.driver", filePath.toUri().toString().substring(8));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://apps.qa2qe.cognizant.e-box.co.in/CucumberShipmentPagination/");

	}

	@When("^I click the First page$")
	public void i_click_the_page() throws Throwable {

		driver.findElement(By.xpath("/html/body/div/span[1]/a")).click();

	}

	@Then("^I can see the table of First page with data in it$")
	public void i_can_see_the_table_with_data_in_it(DataTable dt) throws Throwable {

		assertTrue(driver.findElement(By.xpath("/html/body/table")) != null);

		WebElement table = driver.findElement(By.xpath("/html/body/table/tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		List<WebElement> column = table.findElements(By.tagName("td"));
		List<Map<String, String>> webTableValue = new ArrayList<Map<String, String>>();

		for (WebElement element : rows) {
			Map<String, String> map = new HashMap();

			if (element.findElements(By.tagName("td")).size() > 0) {

				List<WebElement> tdList = element.findElements(By.tagName("td"));
				int counter = 0;
				for (WebElement elementTd : tdList) {

					switch (counter) {
					case 0:
						map.put("Name", elementTd.getText());
						counter++;
						break;

					case 1:
						map.put("Status", elementTd.getText());
						counter++;
						break;

					case 2:
						map.put("Weight", elementTd.getText());
						counter++;
						break;

					case 3:
						map.put("Arrival Port", elementTd.getText());
						counter++;
						break;

					case 4:
						map.put("Depature Port", elementTd.getText());
						counter++;
						break;

					}

				}
				webTableValue.add(map);
			}

		}

		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		for (int i = 0; i < list.size(); i++) {
			assertThat(list.get(i).entrySet(), equalTo(webTableValue.get(i).entrySet()));
			assertThat(list.get(i), is(webTableValue.get(i)));
		}

		driver.quit();
	}

}
