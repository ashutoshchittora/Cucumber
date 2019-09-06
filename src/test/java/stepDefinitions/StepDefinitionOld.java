package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

public class StepDefinitionOld {

	private static WebDriver driver;
	public String text;
	String url = "http://apps.qa2qe.cognizant.e-box.co.in/AddressBook/";

	@Before
	public void setUp() {
		Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
		Path filePath = Paths.get(root.toString(), "src", "test", "resources", "config", "geckodriver1.exe");

		System.setProperty("webdriver.gecko.driver", filePath.toUri().toString().substring(8));
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("^I open the Address book$")
	public void setUp1() {

		driver.get(url);
	}

	@When("^I enter details to add users$")
	public void testAddressBook(DataTable dataTable) throws Throwable {

		List<DataTableRow> listDt = dataTable.getGherkinRows();

		for (DataTableRow value : listDt) {
			int counter = 0;
			List<String> listOfCells = value.getCells();
			driver.findElement(By.xpath("//*[@id=\"nickname\"]")).sendKeys(listOfCells.get(counter));
			driver.findElement(By.xpath("//*[@id=\"contact\"]")).sendKeys(listOfCells.get(counter++));
			driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys(listOfCells.get(counter++));
			driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys(listOfCells.get(counter++));
			driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys(listOfCells.get(counter++));
			driver.findElement(By.xpath("//*[@id=\"type\"]")).sendKeys(listOfCells.get(counter++));
			driver.findElement(By.xpath("//*[@id=\"add\"]")).click();
		}

	}

	@Then("^I can see user is added$")
	public void validateResult(DataTable dataTable) throws Throwable {

		// String [] matchWord = dataTable.asList(String.class).toArray(new String[0]);
		dataTable.asList(String.class);

		WebElement table = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div/table"));
		assertTrue(table.findElements(By.tagName("tr")).stream().anyMatch(row -> row.getText().contains("Ramya")));
		assertTrue(table.findElements(By.tagName("tr")).stream().anyMatch(row -> row.getText().contains("Pooja")));
		assertTrue(table.findElements(By.tagName("tr")).stream().anyMatch(row -> row.getText().contains("Lavanya")));

	}

	@When("^I Click on Delete button$")
	public void click_on_Delete_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"radio0\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"delete\"]")).click();
	}

	@When("^I Click on Edit button$")
	public void i_Click_on_Edit_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"radio0\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"edit\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"nickname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"contact\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"company\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"city\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"country\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"type\"]")).clear();

	}

	@When("^I update the details$")
	public void i_update_the_details(DataTable datatable) throws Throwable {
		int counter = 0;
		List<String> updateValue = datatable.asList(String.class);
		driver.findElement(By.xpath("//*[@id=\"nickname\"]")).sendKeys(updateValue.get(counter));
		driver.findElement(By.xpath("//*[@id=\"contact\"]")).sendKeys(updateValue.get(counter++));
		driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys(updateValue.get(counter++));
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys(updateValue.get(counter++));
		driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys(updateValue.get(counter++));
		driver.findElement(By.xpath("//*[@id=\"type\"]")).sendKeys(updateValue.get(counter++));
		driver.findElement(By.xpath("//*[@id=\"add\"]")).click();

	}

	@Then("^I can see user is edited$")
	public void i_can_see_user_is_edited(DataTable datatable) throws Throwable {

		datatable.asList(String.class);
		WebElement table = driver.findElement(By.xpath("//*[@id=\"result\"]/table/tbody/tr[2]"));

		table.findElements(By.tagName("td"));
		
		assertTrue(table.findElements(By.tagName("td")).stream().anyMatch(row -> row.getText().contains("Poj1")));
		assertTrue(table.findElements(By.tagName("td")).stream().anyMatch(row -> row.getText().contains("Pooja")));
		assertTrue(table.findElements(By.tagName("td")).stream().anyMatch(row -> row.getText().contains("Wipro1")));
		assertTrue(table.findElements(By.tagName("td")).stream().anyMatch(row -> row.getText().contains("Chennai1")));
		assertTrue(table.findElements(By.tagName("td")).stream().anyMatch(row -> row.getText().contains("India1")));
		
	}

	@Then("^I can see user is deleted$")
	public void validateDeleteResult(DataTable dataTable) throws Throwable {

		dataTable.asList(String.class);

		WebElement table = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div/table"));
		assertTrue(table.findElements(By.tagName("tr")).stream().anyMatch(row -> row.getText().contains("Ramya")));
		assertFalse(table.findElements(By.tagName("tr")).stream().anyMatch(row -> row.getText().contains("Pooja")));
		assertTrue(table.findElements(By.tagName("tr")).stream().anyMatch(row -> row.getText().contains("Lavanya")));

	}

}
