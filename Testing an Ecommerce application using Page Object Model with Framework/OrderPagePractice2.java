package dakshbadhwaracademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dakshbadhwaracademy.AbstractComponents.AbstractComponentsPractice;

public class OrderPagePractice2 extends AbstractComponentsPractice {
	 WebDriver driver;
     public OrderPagePractice2(WebDriver driver) {
		// TODO Auto-generated constructor stub
    super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
     }
     
     
     
     @FindBy(xpath="//tr/td[2]")
     List<WebElement> productNames;
     
    public Boolean VerifyOrderDisplay(String productName)
    {
    Boolean match= productNames.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));	
    return match;
    }
}