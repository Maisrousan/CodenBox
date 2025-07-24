package project10;


import java.io.DataInput;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mytestcases {

	WebDriver driver = new ChromeDriver();

	String URL = "https://codenboxautomationlab.com/practice/";

	Connection con ;
	Statement stmt ;
	ResultSet rs ;
	String TheFirstName ;
	String TheLastName ;
	String PhoneNumber ;
	String CustomerName ;
	Random rand = new Random();
	
	@BeforeTest

	public void MyTestSetUp() throws SQLException {

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "123456");
		
		
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(enabled = false)

	public void RadioButton() {

		WebElement ContainerRadioButton = driver.findElement(By.xpath("//div[@id='radio-btn-example']//fieldset"));
		ContainerRadioButton.findElements(By.tagName("input")).get(0).click();

	}

	@Test(enabled = false)

	public void DynamicDropdown() throws InterruptedException {

		String[] Countries = { "Jor", "Uni", "Ir", "Syr" };

		WebElement SelectCountry = driver.findElement(By.id("autocomplete"));
		SelectCountry.sendKeys(Countries[2]);
		Thread.sleep(1000);
		SelectCountry.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER));

	}

	@Test(enabled = false)
	public void StaticDropdown() {
		WebElement MySelectTag = driver.findElement(By.id("dropdown-class-example"));
		Select MySelect = new Select(MySelectTag);

		// MySelect.selectByContainsVisibleText("API");
		MySelect.selectByValue("option2");
		// MySelect.selectByIndex(1);

	}

	@Test(enabled = false)

	public void CheckBox() {

		WebElement CheckBoxContainer = driver.findElement(By.xpath("//div[@id='checkbox-example']//fieldset"));

		List<WebElement> AllCheckBoxes = CheckBoxContainer.findElements(By.tagName("input"));

		for (int i = 0; i < AllCheckBoxes.size(); i++) {

			AllCheckBoxes.get(i).click();

		}

	}

	@Test(enabled = false)

	public void SwitchWindow() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,700)");

		WebElement OpenWindow = driver.findElement(By.id("openwindow"));
		OpenWindow.click();

		System.out.println(driver.getTitle());

		Set<String> Handles = driver.getWindowHandles();

		List<String> AllTabs = new ArrayList<>(Handles);

		driver.switchTo().window(AllTabs.get(1));

		driver.findElement(By.xpath("//li[@id='menu-item-9680']//a")).click();
		driver.switchTo().window(AllTabs.get(0));
		System.out.println(driver.getTitle());

	}

	@Test(enabled = false)
	public void SwitchTab() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,700)");

		WebElement OpenTab = driver.findElement(By.id("opentab"));
		OpenTab.click();

		System.out.println(driver.getTitle());

		Set<String> Handles = driver.getWindowHandles();

		List<String> AllTabs = new ArrayList<>(Handles);

		driver.switchTo().window(AllTabs.get(1));

		Thread.sleep(2000);
		System.out.println(driver.getTitle());

	}

	@Test(enabled = false)
	public void SwitchToAlert() throws InterruptedException {

		WebElement NameInput = driver.findElement(By.id("name"));
		NameInput.sendKeys("Mais");
		WebElement AlertButton = driver.findElement(By.id("alertbtn"));
		AlertButton.click();

		boolean Actual = driver.switchTo().alert().getText().contains("Mais");

		Assert.assertTrue(Actual, "This test for alert");

		Thread.sleep(1000);
		driver.switchTo().alert().accept();

	}

	@Test(enabled = false)
	public void WebTable() {

		WebElement TheTable = driver.findElement(By.id("product"));
		List<WebElement> AllData = TheTable.findElements(By.tagName("td"));
		// List<WebElement> AllData = TheTable.findElements(By.tagName("th"));
		// List<WebElement> AllData = TheTable.findElements(By.tagName("tr"));

		for (int i = 5; i < AllData.size(); i = i + 3) {
			System.out.println(AllData.get(i).getText());

		}
	}

	@Test(enabled = false)

	public void ElementDisplayed() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1500)");

		WebElement InputField = driver.findElement(By.id("displayed-text"));
		WebElement HideButton = driver.findElement(By.id("hide-textbox"));
		HideButton.click();

		System.out.println(InputField.isDisplayed());

		WebElement ShowButton = driver.findElement(By.id("show-textbox"));

		ShowButton.click();

		System.out.println(InputField.isDisplayed());

	}

	@Test(enabled = false)
	public void EnabledDisabled() {

		WebElement DisablesButton = driver.findElement(By.id("disabled-button"));
		DisablesButton.click();

		WebElement InputField = driver.findElement(By.id("enabled-example-input"));
		System.out.println(InputField.isEnabled());

		WebElement EnabledButton = driver.findElement(By.id("enabled-button"));
		EnabledButton.click();
		System.out.println(InputField.isEnabled());

	}

	@Test(enabled = false)
	public void MouseHover() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1900)");

		WebElement MouseHoverButton = driver.findElement(By.id("mousehover"));

		Actions action = new Actions(driver);
		action.moveToElement(MouseHoverButton).build().perform();

//		WebElement Top = driver.findElement(By.linkText("Top"));
//		Top.click();
		WebElement Reload = driver.findElement(By.linkText("Reload"));
		Reload.click();
	}

	@Test
	public void Calendar() throws InterruptedException, SQLException {

		WebElement Calendar = driver.findElement(By.linkText("Booking Calendar"));

		Calendar.click();

		Set<String> Handles = driver.getWindowHandles();

		List<String> AllTabs = new ArrayList<>(Handles);

		driver.switchTo().window(AllTabs.get(1));

		WebElement Day26 = driver.findElement(By.linkText("26"));
		Day26.click();
		
		
		Thread.sleep(3000);
		
		int RandomId = rand.nextInt(103 , 400);
		
		String QueryToRead = "select * from customers where customerNumber = " + RandomId;
		stmt =  con.createStatement(); 
		rs = stmt.executeQuery(QueryToRead);
		
		while (rs.next()) {
			
			 TheFirstName = rs.getString("contactFirstName");
			 TheLastName = rs.getString("contactLastName");
			 PhoneNumber = rs.getString("phone");
			 CustomerName = rs.getString("customerName");
		}
		
//		System.out.println(TheFirstName);
//		System.out.println(TheLastName);
		
		int RandomNumber = rand.nextInt(4000);
		
		WebElement FirstNameInput = driver.findElement(By.id("name1"));
		FirstNameInput.sendKeys(TheFirstName);
		

		WebElement LastNameInput = driver.findElement(By.id("secondname1"));
		LastNameInput.sendKeys(TheLastName);
		
		
		WebElement EmailInput = driver.findElement(By.id("email1"));
		EmailInput.sendKeys(TheFirstName + TheLastName + RandomNumber+ "@gmail.com");
		
		WebElement PhoneInput = driver.findElement(By.id("phone1"));
		PhoneInput.sendKeys(PhoneNumber);
		
		WebElement Details = driver.findElement(By.id("details1"));
		Details.sendKeys(CustomerName);
		
		
	}

}
