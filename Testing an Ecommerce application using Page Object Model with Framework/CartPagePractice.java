package dakshbadhwaracademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import dakshbadhwaracademy.AbstractComponents.AbstractComponentsPractice;

public class CartPagePractice extends AbstractComponentsPractice {
	 WebDriver driver;
     public CartPagePractice(WebDriver driver) {
		// TODO Auto-generated constructor stub
    super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
     }
   
    // List<WebElement> cartProducts= driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
   //  Boolean match=cartProducts.stream().anyMatch(cartProduct->
   //  cartProduct.getText().equalsIgnoreCase(productName));
     //Assert.assertTrue(match);
   //  driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
     
     
   @FindBy(xpath="//div[@class='cartSection']/h3")  
   List<WebElement> ProductTitles;
   
   @FindBy(xpath="//li[@class='totalRow']/button")  
   WebElement checkoutEle;
     
   public Boolean VerifyProductDisplay(String productName)
   {
	   Boolean match=ProductTitles.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
   
	  return (match); 
   }
   public CheckoutPagePractice  goToCheckout()
   {
	   checkoutEle.click();
	   return new CheckoutPagePractice(driver);
	   
   }
}