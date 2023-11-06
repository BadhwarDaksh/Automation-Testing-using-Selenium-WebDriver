package dakshbadhwaracademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dakshbadhwaracademy.pageobjects.LandingPagePractice;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestPractice
{   
	public WebDriver driver;
	public LandingPagePractice landingPage;
	public  WebDriver initializeDriver() throws IOException
	{   
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\dakshbadhwaracademy\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		   if (browserName.equalsIgnoreCase("Chrome"))
		   { //WebDriverManager.chromedriver().setup();
			 ChromeOptions ops= new ChromeOptions();
			 ops.addArguments("--remote-allow-all-origins=*");
			 WebDriverManager.chromedriver().setup();
			  driver= new ChromeDriver(ops);
			 
		   }
		   else if (browserName.equalsIgnoreCase("firefox"))
		   {
			   //firefox
		   }
		   else
		   {
			   //edge driver
		   }
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
		 driver.manage().window().maximize();
		 return driver; //with life
		 
	}
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	 {
		// read json to string
		String jsonContent = FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
	//String to HashMap using// Jackson// Datbind //
	    ObjectMapper mapper = new  ObjectMapper();
	    List<HashMap<String,String>> data= mapper.readValue(jsonContent, new TypeReference <List<HashMap<String, String>>>(){});
		return data;  
	  }
	
	 public String getScreenshot (String testCaseName, WebDriver driver) throws IOException
	   {
		  TakesScreenshot ts= (TakesScreenshot)driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  File file= new File(System.getProperty(("user.dir"))+"//reports//"+ testCaseName+ ".png");
		  FileUtils.copyFile(source,file);// creating file object as taking file object as argument
		  return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	   }
	   	
		
	
	@BeforeMethod (alwaysRun=true)
	
		public LandingPagePractice launchApplication() throws IOException, InterruptedException 
		{   driver= initializeDriver();
			 landingPage =new LandingPagePractice(driver);
	        landingPage.goTo();
	        
	        return landingPage;
		}
	@AfterMethod (alwaysRun=true)
	     public void tearDown() throws IOException
	       { //driver= initializeDriver();
	         driver.close();	
	           }

	
	
}
