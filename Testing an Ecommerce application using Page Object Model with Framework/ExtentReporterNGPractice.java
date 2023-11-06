package dakshbadhwaracademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNGPractice {


	public static ExtentReports getReportObject()
	{
		//ExtentReports, ExtentSparkReporter
		String path= System.getProperty("user.dir")+ "\\reports\\index.html";
		ExtentSparkReporter reporter=  new ExtentSparkReporter(path);
	    reporter.config().setReportName("Web Automation Results");
	    reporter.config().setDocumentTitle("Test Results");
	    ExtentReports extent=new ExtentReports();
	    extent.attachReporter(reporter); // reporter tells all the details (Meta data)
	    extent.setSystemInfo("Tester", "Rahul Shetty");	//extend  obj creates report based on the meta data
	//using extent we will create entry(extent.createTest(path)) for each and every test in the report.
	   return extent; 
	 }
//static----->do access method without delclaring object and calling 
}
