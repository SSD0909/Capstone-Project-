package testCases;

import java.io.IOException;
import java.time.Duration;

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
import lib.SelectBrowser;
import pages.LoginRegisteredUser;
import pages.Registration;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
public class LoginRegisteredUserTest {

	 WebDriver driver;
	 LoginRegisteredUser userLogin;
	 //Actions actions;
	 private static ExtentHtmlReporter htmlReporter;
	    private static ExtentReports extent;
	    private static ExtentTest test;
	    @BeforeSuite
	    public void setUpReport()
	    {
	        //create the HtmlReporter in that path by the name of  SearchReport.html
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
	                + "/test-output/reports/LoginRegisteredUserTest.html");
	        extent = new ExtentReports();

	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Host Name", "DESKTOP-0ME5BL0");
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("User Name", "Haseeb");
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("AutomationTesting ProductDetails report");
	        htmlReporter.config().setReportName("Ecom product details and Report");
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
	 
	 @Test(priority = 1, testName = "TC - 0004", enabled = true)
	    // test if it is used a valid email in order to create an account
	    public void LoginRegisteredUser() throws IOException, InterruptedException {
	        try {
	        	test = extent.createTest("LoginRegisteredUser_0004", "Test Passed");
	        	Actions actions= new Actions(driver);
	    	userLogin = new LoginRegisteredUser(driver);
	    	Thread.sleep(3000);
	    	userLogin.MyAccountBtnClick();
	    	System.out.println("The My Account button is clicked");
	       
	    	userLogin.EnterUserEmail("Stu4@gmail.com");
	        System.out.println("UserName Entered");
	       
	        userLogin.EnterPass("Psssw0rd@#$123452345sfsff");
	        System.out.println("Password Entered");
	        Thread.sleep(3000);
	       actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	       Thread.sleep(3000);
	       userLogin.LoginUserClick();
	        
	        System.out.println("Logged in Successfully");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	        
			
	        System.out.println(userLogin.UserNameDisplay());
	        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/screenshots/TC0004-image1.jpg");
	        String expectedDisplay="Hello "+ userLogin.UserNameDisplay();
	        System.out.println(expectedDisplay);

	        String actualDisplay ="Hello testcase0004";
	        Assert.assertEquals( expectedDisplay,actualDisplay);}
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
