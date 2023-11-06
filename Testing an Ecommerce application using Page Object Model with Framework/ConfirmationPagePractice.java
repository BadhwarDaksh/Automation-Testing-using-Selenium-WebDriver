package dakshbadhwaracademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import dakshbadhwaracademy.AbstractComponents.AbstractComponentsPractice;

public class ConfirmationPagePractice extends AbstractComponentsPractice {
	 WebDriver driver;
     public ConfirmationPagePractice(WebDriver driver) {
		// TODO Auto-generated constructor stub
    super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
     }
    // String confirmMessage= driver.findElement(By.cssSelector(".hero-primary")).getText();
    // Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    // System.out.println(confirmMessage);
    // driver.close();
     
     @FindBy (css=".hero-primary")
     WebElement ConfirmMessage;
      
     public String getConfirmationMessaage()
     {
    	  return ConfirmMessage.getText();
    	 
     }
     
     
     
     
     
}