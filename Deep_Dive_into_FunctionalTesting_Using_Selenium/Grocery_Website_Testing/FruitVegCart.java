import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FruitVegCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/DakshProjects/chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" }; //array of strings
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		addItems(driver, itemsNeeded);
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0; //search  count
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));//products
		for (int i = 0; i < products.size(); i++) {
//Brocolli - 1 Kg
//Brocolli , 1 kg
			String[] name = products.get(i).getText().split("-");   //array//name has no role
			String formattedName = name[0].trim();
			///Brocolli (String)
//format it to get actual vegetable name
//convert array into array list for easy search
//  check whether name you extracted is present in arrayList or not-
			List itemsNeededList = Arrays.asList(itemsNeeded); //3 items list
			if (itemsNeededList.contains(formattedName)) {
				j++;
//click on Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();//locator is independent so get index
				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}

}
 