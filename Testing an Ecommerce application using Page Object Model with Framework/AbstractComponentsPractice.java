package dakshbadhwaracademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dakshbadhwaracademy.pageobjects.CartPagePractice;
import dakshbadhwaracademy.pageobjects.OrderPagePractice2;

public class AbstractComponentsPractice {
    WebDriver driver;
	public AbstractComponentsPractice(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	@FindBy(css="button[routerlink*='cart']")
    WebElement cartHeader;
	@FindBy(css="button[routerlink*='myorders']")
    WebElement orderHeader;
	public void waitForElementToAppear(By findBy) throws InterruptedException 
	
	{    Thread.sleep(500);
		 WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(10));
	        w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	
		{    Thread.sleep(500);
			 WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(10));
			 w.until(ExpectedConditions.invisibilityOf(ele));
		}
	
	public void waitForWebElementToAppear(WebElement findBy) throws InterruptedException
	{     Thread.sleep(500);
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
   //driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
	public CartPagePractice goToCartPage() throws InterruptedException
	      {   Thread.sleep(800);
	    	  cartHeader.click(); 
	    	  return new CartPagePractice(driver);
	    	  
	      }
	public OrderPagePractice2  goToOrdersPage() 
	{
		
		orderHeader.click();
		
		//OrderPagePractice2 orderPage= new OrderPagePractice2(driver);
		//return orderPage;
		
		return new  OrderPagePractice2(driver);
	}
	
	
	
}
