package testCases;

import java.io.IOException;
import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import lib.RunReports;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.Select;

import lib.SelectBrowser;
import pages.SearchProductsHomePage;

public class SearchProductsHomePageTest {
	
	 WebDriver driver;
	 SearchProductsHomePage searchProduct;

	 private static ExtentHtmlReporter htmlReporter;
	    private static ExtentReports extent;
	    private static ExtentTest test;
	    @BeforeSuite
	    public void setUpReport()
	    {
	        //create the HtmlReporter in that path by the name of  SearchReport.html
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
	                + "/test-output/SearchProductsHomePageTest.html");
	        extent = new ExtentReports();

	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Host Name", "DESKTOP-Learner_9ZH3Z139");
	        extent.setSystemInfo("Environment", "QA Automation");
	        extent.setSystemInfo("User Name", "Stephy Saji Daniel");
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("Automation Testing on Ecommerce WebApplication-Search Products on HomePage Test Report");
	        htmlReporter.config().setReportName("Ecommerce Search Products on HomePage Test and Report");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.DARK);
	    }
	 
	 @BeforeTest(enabled = true)
	    public void launchBrowser() throws InterruptedException {
	        driver = SelectBrowser.StartBrowser("Chrome");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        Thread.sleep(5000);
	        driver.get("http://demo.perscholastraining.com/");
	        Reporter.log("The browser is open the testing Application");
	    }
	 @Test(priority = 1, testName = "TC - 0014", enabled = true)
	    // test if it is used a valid email in order to create an account
	    public void Search() throws IOException, InterruptedException {
	        try {
	        	//Actions actions= new Actions(driver);
	        	test = extent.createTest("Search-0014", "Test Passed");
	        	searchProduct= new SearchProductsHomePage(driver);
	        	Thread.sleep(3000);
	        	searchProduct.search("Smartphone 6S 64GB LTE");
	        	 RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC-0014A-image1.jpg");
	        	Thread.sleep(3000);
	        	searchProduct.searchButtonClick();
	        	
	        	String expectedDisplay=searchProduct.pdtDisplayed();
	        	String actualDisplay="Smartphone 6S 64GB LTE";
	        	 RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC-0014B-image1.jpg");
	        	Assert.assertEquals( expectedDisplay,actualDisplay);
	        	        	        	
	        }
	        catch (Exception e)
			{
				e.printStackTrace();
			}
	 }
	 
	 @Test(priority = 2, testName = "TC - 0015", enabled = true)
	    // test if it is used a valid email in order to create an account
	    public void SearchNull() throws IOException, InterruptedException {
	        try {
	        	test = extent.createTest("SearchNull-0015", "Test Passed");
	        	searchProduct= new SearchProductsHomePage(driver);
	        	
	        	searchProduct.homeClick();
	        	Thread.sleep(3000);
	        	searchProduct.searchButtonClick();
	        	String expectedDisplay=searchProduct.nullpdtDisplayed();
	        	String actualDisplay="Recommended Products";
	        	RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/TC-0015A-image1.jpg");
	        	Assert.assertEquals( expectedDisplay,actualDisplay);
	        }
	        catch (Exception e)
			{
				e.printStackTrace();
			}
	 
	        }
	 @AfterMethod
	    public void getResult(ITestResult result) {

	        if (result.getStatus() == ITestResult.FAILURE) {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));

	           test.fail(result.getThrowable());
	        } else if (result.getStatus() == ITestResult.SUCCESS) {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
	        } else {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	    }

	    @AfterSuite
	    public void tearDown()
	    {
	        extent.flush();
	    }
	 @AfterTest
	 public void afterTest() {
	 	driver.quit();
	 }

	 
}
