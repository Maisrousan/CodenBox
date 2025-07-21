package project10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mytestcases {

	WebDriver driver = new 	ChromeDriver();
	
	String URL = "https://codenboxautomationlab.com/practice/";
	
	@BeforeTest
	
	public void MyTestSetUp () {
		
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	}
		
		
	


		@Test (enabled=false)
		
		public void RadioButton () {
			
			WebElement ContainerRadioButton = driver.findElement(By.xpath("//div[@id='radio-btn-example']//fieldset"));
			ContainerRadioButton.findElements(By.tagName("input")).get(0).click();
			
			
		}		
		
		
		
		@Test (enabled=false)
		
		public void DynamicDropdown() throws InterruptedException {
			
			
			String [] Countries = { "Jor" , "Uni" , "Ir" ,"Syr"  };
			
			WebElement  SelectCountry = driver.findElement(By.id("autocomplete"));
			SelectCountry.sendKeys(Countries[2]);
			Thread.sleep(1000);
			SelectCountry.sendKeys(Keys.chord(Keys.ARROW_DOWN , Keys.ARROW_DOWN , Keys.ENTER));
			
			
			
			
		}
		
		@Test (enabled=false) 
		public void StaticDropdown () {
			WebElement MySelectTag = driver.findElement(By.id("dropdown-class-example"));
			Select MySelect = new Select(MySelectTag) ;
			
			
			//MySelect.selectByContainsVisibleText("API");
			MySelect.selectByValue("option2");
			//MySelect.selectByIndex(1);
			
			
			
			
			
		}
		
		
		
		@Test (enabled=false)
		
		public void CheckBox () {
			
			WebElement CheckBoxContainer = driver.findElement(By.xpath("//div[@id='checkbox-example']//fieldset"));
			
	
			
			List<WebElement> AllCheckBoxes = CheckBoxContainer.findElements(By.tagName("input"));
			
			for (int i=0 ; i<AllCheckBoxes.size() ; i++) {
				
				
				AllCheckBoxes.get(i).click();
				
			}
			
		}
	
		
		
		@Test (enabled=false)
		
		public void SwitchWindow () {
			
			
			JavascriptExecutor js = (JavascriptExecutor) driver ;
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
		
		
		@Test (enabled = false)
		public void SwitchTab () throws InterruptedException {
			
			JavascriptExecutor js = (JavascriptExecutor) driver ;
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
		
		
		
		
		@Test (enabled = false)
		public void SwitchToAlert () throws InterruptedException {
			
			WebElement NameInput = driver.findElement(By.id("name"));
			NameInput.sendKeys("Mais");
			WebElement AlertButton = driver.findElement(By.id("alertbtn"));
			AlertButton.click();
			
			
			boolean Actual = driver.switchTo().alert().getText().contains("Mais");
			
			Assert.assertTrue(Actual, "This test for alert");
			
			
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			
			
		}
		
		
}


	
	
	
	
	
	
	
	

