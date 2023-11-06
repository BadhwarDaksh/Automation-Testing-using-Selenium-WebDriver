package dakshbadhwaracademy.tests;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeStandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName= "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
        ChromeOptions ops= new ChromeOptions();
        ops.addArguments("--remote-allow-all-origins=*");
        WebDriver driver= new ChromeDriver(ops);
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
        driver.findElement(By.id("login")).click();
        WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
        WebElement prod=products.stream().filter(product->
       product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
        
        prod.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        Thread.sleep(700);
        driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
        List<WebElement> cartProducts= driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
        Boolean match=cartProducts.stream().anyMatch(cartProduct->
        cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);
        driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
        Actions a= new Actions(driver);
        a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
        Thread.sleep(500);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
        driver.findElement(By.cssSelector(".btnn")).click();
       String confirmMessage= driver.findElement(By.cssSelector(".hero-primary")).getText();
       Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
       System.out.println(confirmMessage);
       driver.close();
        
	}

}
