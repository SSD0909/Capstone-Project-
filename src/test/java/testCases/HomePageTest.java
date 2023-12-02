package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.asserts.SoftAssert;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

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
import lib.SelectBrowser;
import pages.HomePage;
import pages.LoginRegisteredUser;
import pages.ProductAddToCart;
public class HomePageTest {
	WebDriver driver;
	HomePage home;
	 SoftAssert softassert= new SoftAssert();
	 private static ExtentHtmlReporter htmlReporter;
	    private static ExtentReports extent;
	    private static ExtentTest test;
	    @BeforeSuite
	    public void setUpReport()
	    {
	        //create the HtmlReporter in that path by the name of  SearchReport.html
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
	                + "/test-output/reports/HomePageTest.html");
	        extent = new ExtentReports();

	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Host Name", "DESKTOP-Learner_9ZH3Z139");
	        extent.setSystemInfo("Environment", "QA Automation");
	        extent.setSystemInfo("User Name", "Stephy Saji Daniel");
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("Automation Testing on Ecommerce WebApplication-User Registeration  Test reportt");
	        htmlReporter.config().setReportName("Ecommerce User Registeration Test details and Report");
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


      @Test(priority = 1, testName = "TC - 0012", enabled = true)
	    // 
	    public void HomePageProducts() throws IOException, InterruptedException {
	        try {
	        	
	        	test = extent.createTest("HomePageProducts_0012", "Test Passed");
	        	Actions actions= new Actions(driver);
	        	home = new HomePage(driver);
	        	
		    	Thread.sleep(3000);
		    	home.UserHomeClick();
		    	actions.sendKeys(Keys.PAGE_DOWN).build().perform();
				Thread.sleep(3000);
				
				home.featuredProductsClick();
				
				List<WebElement> links=home.links();
				int size=links.size();
		        for(int i=1; i <= 6; i++)
		        {
		        	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
		        	//JavascriptExecutor js = (JavascriptExecutor) driver;
		        	//js.executeScript("document.body.style.zoom = '.5'");
		            WebElement linkElement = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[3]/div/div/div/main/div[3]/div/div/div/div[1]/div/ul/li["+i+"]")));
		            System.out.println(linkElement.getText());  
		            RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/screenshots/TC0012A-image"+i+".jpg");
		            String expectedProductList=linkElement.getText();
		            
		            //The code below uses assertNotNull() to validate if the expected output is not null
		            softassert.assertNotNull(expectedProductList);

		        }
		    	
		    	
	        }
	        catch (Exception e)
			{
				e.printStackTrace();
			}
        }
      @Test(priority = 2, testName = "TC - 0013", enabled = true)
	    // test if it is used a valid email in order to create an account
	    public void HomePageMenu() throws IOException, InterruptedException {
	        try {
	        	test = extent.createTest("HomePageMenu_0013", "Test Passed");
	        	Actions actions= new Actions(driver);
	        	home = new HomePage(driver);
	        	
		    	Thread.sleep(3000);
		    	
		    	List<WebElement> menuDisplay =home.menuDisplay();
		    	 for(WebElement menu:menuDisplay)
			        {
			        	
			                System.out.println(menu.getAttribute("title"));
			                RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/screenshots/TC0013A-image1.jpg");
			                String expectedMenu=menu.getAttribute("title");
			                softassert.assertNotNull(expectedMenu);

			        }
      
		    	
		    	
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
	    	//Flush the data to report
	        extent.flush();
	    }
      @AfterTest
 	 public void afterTest() {
 	 	driver.quit();
 	 }
    
      }