package dakshbadhwaracademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dakshbadhwaracademy.AbstractComponents.AbstractComponentsPractice;

public class LandingPagePractice extends AbstractComponentsPractice {
   WebDriver driver;
  public LandingPagePractice(WebDriver driver) 
   {
		// TODO Auto-generated constructor stub
    super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
     }
    
     @FindBy(id="userEmail")
     WebElement userEmail;
     @FindBy(id="userPassword")
     WebElement passwordEle;
     @FindBy (id="login")
     WebElement submit;
     @FindBy(css="[class*=flyInOut]")
     WebElement errorMessage;

	public ProductCataloguePagePractice loginApplication(String email, String password) throws InterruptedException
     {
    	 userEmail.sendKeys(email);
    	 passwordEle.sendKeys(password);
    	 Thread.sleep(500);
    	 submit.click();
    	 return new ProductCataloguePagePractice(driver);
     }
	public String getErrorMessage() throws InterruptedException
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
