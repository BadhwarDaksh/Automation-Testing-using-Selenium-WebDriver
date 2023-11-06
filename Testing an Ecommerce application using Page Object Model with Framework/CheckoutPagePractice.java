package dakshbadhwaracademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;

import dakshbadhwaracademy.AbstractComponents.AbstractComponentsPractice;

public class CheckoutPagePractice extends AbstractComponentsPractice {
	 WebDriver driver;
     public CheckoutPagePractice(WebDriver driver) {
		// TODO Auto-generated constructor stub
    super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
     }
    // Actions a= new Actions(driver);
    // a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
    // Thread.sleep(500);
    // w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
    // driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
     //driver.findElement(By.cssSelector(".btnn")).click();  

     @FindBy(xpath="//input[@placeholder='Select Country']")
     WebElement country;
     @FindBy(xpath="//button[contains(@class,'ta-item')][2]")
     WebElement  selectCountry;
     @FindBy(css=".btnn")
     WebElement submit;
     By results= By.cssSelector(".ta-item");
     
     public void SelectCountry(String countryname) throws InterruptedException
     {
    	 Actions a= new Actions(driver);
         a.sendKeys(country,countryname).build().perform();
         Thread.sleep(500); 
         waitForElementToAppear(results);
         selectCountry.click();
         
     }
     public ConfirmationPagePractice submitOrder()
     {
    	 submit.click();
    	 return new ConfirmationPagePractice(driver);
    	 
     }
     }
     
