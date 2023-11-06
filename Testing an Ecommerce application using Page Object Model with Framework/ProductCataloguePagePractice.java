package dakshbadhwaracademy.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dakshbadhwaracademy.AbstractComponents.AbstractComponentsPractice;

public class ProductCataloguePagePractice extends AbstractComponentsPractice  {
	 WebDriver driver;
     public ProductCataloguePagePractice(WebDriver driver) {
		// TODO Auto-generated constructor stub
    super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
     }
     //WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));
    // w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
    // List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
     //WebElement prod=products.stream().filter(product->
   // product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
     
     //prod.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();
     //w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#toast-container"))));
     //w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
     //Thread.sleep(700);
    // driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
    
     
     
     
     @FindBy(css=".mb-3") 
     List<WebElement> products;
     @FindBy(css=".ng-animating")
     WebElement spinner;
     @FindBy(id="toast-container")
     WebElement toastMessage;
     
     
     
     By  addToCart=By.xpath("//div[@class='card-body']/button[2]");
     By productsBy=By.cssSelector(".mb-3");
     
     public List<WebElement> getProductList() throws InterruptedException 
     {
    	 waitForElementToAppear(productsBy);
    	 return products;
     }
     
     public WebElement  getProductByName(String productName) throws InterruptedException
    {
    	 WebElement prod= getProductList().stream().filter(product->
        product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod; 
    	 }
     
      public void addProductToCart(String productName) throws InterruptedException
      {   Thread.sleep(700);
    	  getProductByName(productName).findElement(addToCart).click();
    	  waitForWebElementToAppear(toastMessage); 
    	  waitForElementToDisappear(spinner);
    	  
    	  
      }
     
}