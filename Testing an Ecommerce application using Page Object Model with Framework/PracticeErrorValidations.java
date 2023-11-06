package dakshbadhwaracademy.tests;

import java.io.IOException;
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
import org.testng.annotations.Test;

import dakshbadhwaracademy.TestComponents.BaseTestPractice;
import dakshbadhwaracademy.pageobjects.CartPagePractice;
import dakshbadhwaracademy.pageobjects.CheckoutPagePractice;
import dakshbadhwaracademy.pageobjects.ConfirmationPagePractice;
import dakshbadhwaracademy.pageobjects.LandingPagePractice;
import dakshbadhwaracademy.pageobjects.ProductCataloguePagePractice;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeErrorValidations extends BaseTestPractice {
 
    @Test (groups={"ErrorHandling"})
	public  void LoginErrorValidation() throws IOException, InterruptedException 
    {
		//String productName= "ZARA COAT 3";
    	 
        landingPage.loginApplication("anshika@gmail.com","\\@king");
       
        Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
        System.out.println("c");
        
	}
    @Test
    public void ProductErrorValidation() throws InterruptedException 
    {
    	 String productName= "ZARA COAT 3";
    	 ProductCataloguePagePractice   productCatalogue= landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
         List<WebElement> products= productCatalogue.getProductList();
         Thread.sleep(700);
         productCatalogue.addProductToCart(productName) ;
         CartPagePractice cartPage=productCatalogue.goToCartPage();
         Boolean match= cartPage.VerifyProductDisplay("Zara");
         Assert.assertFalse(match);
         System.out.println("d");
    }

	

}
