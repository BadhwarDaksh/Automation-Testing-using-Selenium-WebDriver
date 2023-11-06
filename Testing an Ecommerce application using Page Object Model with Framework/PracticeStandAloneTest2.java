package dakshbadhwaracademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dakshbadhwaracademy.TestComponents.BaseTestPractice;
import dakshbadhwaracademy.pageobjects.CartPagePractice;
import dakshbadhwaracademy.pageobjects.CheckoutPagePractice;
import dakshbadhwaracademy.pageobjects.ConfirmationPagePractice;
import dakshbadhwaracademy.pageobjects.LandingPagePractice;
import dakshbadhwaracademy.pageobjects.OrderPagePractice2;
import dakshbadhwaracademy.pageobjects.ProductCataloguePagePractice;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeStandAloneTest2 extends BaseTestPractice {
	String productName= "ZARA COAT 3";
    @Test (dataProvider="getData",groups= {"Purchase"} )
	public  void submitOrder(HashMap<String,String>input) throws IOException, InterruptedException 
    {
		ProductCataloguePagePractice   productCatalogue= landingPage.loginApplication(input.get("email"), input.get("password"));
        List<WebElement> products= productCatalogue.getProductList();
        productCatalogue.addProductToCart(input.get("productName")) ;
        CartPagePractice cartPage=productCatalogue.goToCartPage();
        Boolean match= cartPage.VerifyProductDisplay(input.get("productName"));
        Assert.assertTrue(match);
        CheckoutPagePractice checkout=cartPage.goToCheckout();
        checkout.SelectCountry("India");
        ConfirmationPagePractice confirmationPage=checkout.submitOrder();
        String mssg=confirmationPage.getConfirmationMessaage();
        Assert.assertTrue(mssg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
       
        
	}

  @Test(dependsOnMethods= {"submitOrder"})
  public void OrderHistoryTest() throws InterruptedException
  { 
	ProductCataloguePagePractice   productCatalogue= landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
	OrderPagePractice2 orderPage= productCatalogue.goToOrdersPage();
	Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
	
  }

@DataProvider
public Object[][] getData() throws IOException
{
	List <HashMap<String,String>>data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\dakshbadhwaracademy\\data\\PurchaseOrder.json");
	return new Object[][]{ {data.get(0)},{data.get(1)}};
}
}
