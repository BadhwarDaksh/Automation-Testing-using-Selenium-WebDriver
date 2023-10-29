import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TT {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/DakshProjects/chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);

		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		// dropdown with select tag
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown); // argument where select dropdown is present
		dropdown.selectByIndex(2);
		// System.out.println(dropdown.getFirstSelectedOption().getText());
		driver.findElement(By.cssSelector(".paxinfo")).click();
		Thread.sleep(500);

		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
        //Dynamic Dropdown
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='DEL']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BOM']"))
				.click();
        //Suggestive dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> country = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));

		WebElement countrySelect = country.stream().filter(c -> c.getText().equalsIgnoreCase("India")).findFirst()
				.orElse(null);
		// Capture webelementIndia
		countrySelect.click();
		driver.findElement(By.cssSelector("#ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		// System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		// number of checkboxes
		// System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		//Thread.sleep(5000);
		//driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))

		{

			System.out.println("its disabled");

			Assert.assertTrue(true);

		}

		else

		{

			Assert.assertTrue(false);

		}
	
       driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
       Assert.assertTrue(true);
       System.out.println("done");
}
}
