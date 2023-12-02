package testCases;
import lib.RunReports;
import lib.SelectBrowser;


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

import pages.Registration;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class RegistrationTest {

	
	
	 WebDriver driver;
	 Registration userRegistration;
	 
	 private static ExtentHtmlReporter htmlReporter;
	    private static ExtentReports extent;
	    private static ExtentTest test;
	    @BeforeSuite
	    public void setUpReport()
	    {
	        //create the HtmlReporter in that path by the name of  SearchReport.html
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
	                + "/test-output/reports/RegistrationPageTest.html");
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
	        driver.get("https://demo.perscholastraining.com/");
	        Reporter.log("The browser is open the testing Application");
	    }
	     
	    @Test(priority = 1, testName = "TC - 0002", enabled = true)
	    // test if it is used a valid email in order to create an account
	    public void createAccountWeakPassword() throws IOException, InterruptedException {
	    	try {
	    		test = extent.createTest("createAccountWeakPassword_0002", "Test Passed");
		    	Actions actions= new Actions(driver);
	    	userRegistration = new Registration(driver);
	    	Thread.sleep(3000);
	    	userRegistration.MyAccountBtnClick();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	        //ecomLogInPage = new EcomLogInPage(driver);
	        userRegistration.EnterUserNameReg("stephy1");
	        System.out.println("UserName Entered");
	        userRegistration.EnterEMailReg("stephy1@gmail.com");
	        System.out.println("Email Address Entered");
	        userRegistration.EnterPassReg("P@ssper");
	        System.out.println("Password Entered");
			Thread.sleep(5000);
			 RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/screenshots/TC0002A-image1.jpg");
			actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			 
			 
	        String weakpasswordMessageDisplay = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[4]/span/div")).getText();
	        Thread.sleep(4000);
	        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/screenshots/TC0002B-image2.jpg");
	        System.out.println(weakpasswordMessageDisplay);
	        String weakpass = "Weak - Please enter a stronger password.";
	        
	        Assert.assertEquals(weakpass, weakpasswordMessageDisplay);
	       Thread.sleep(4000);
	       // boolean registerationBtnEnable=userRegistration.registerationBtnEnable();
	       // Assert.assertEquals(registerationBtnEnable,false);
	        
	    	 }
	        catch (Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    }

	    @Test(priority = 3, testName = "TC - 0001", enabled = true)
	    // test if it is used a valid email in order to create an account
	    public void createAccounWithValidPass() throws IOException, InterruptedException {
	        try {
	        	
	        	test = extent.createTest("createAccounWithValidPass_0001", "Test Passed");
	        	Actions actions= new Actions(driver);
	    	userRegistration = new Registration(driver);
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    	//Thread.sleep(3000);
	    //	userRegistration.MyAccountBtnClick();
	   // 	System.out.println("The My Account button is clicked");
	    
	    	driver.findElement(By.id("reg_password")).clear();
		       driver.findElement(By.id("reg_email")).clear();
		       driver.findElement(By.id("reg_username")).clear();
	        userRegistration.EnterUserNameReg("Student17");
	        System.out.println("UserName Entered");
	        userRegistration.EnterEMailReg("Student17@gmail.com");
	        System.out.println("Email Address Entered");
	        userRegistration.EnterPassReg("Psssw0rd@#$123452345sfsff");
	        System.out.println("Password Entered");
	        
	      actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	      
	       Thread.sleep(3000);
	       RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/screenshots/TC0001A-image1.jpg");
	        userRegistration.RegBtnClick();
	        Thread.sleep(3000);
	        
	        
	       /* System.out.println(userRegistration.myAccountDisplayed());*/
	        String expectedurl = driver.getCurrentUrl();
	        System.out.println(expectedurl);

	        String urlactual = "https://demo.perscholastraining.com/my-account-2/";
	        Assert.assertEquals(expectedurl, urlactual);}
	        catch (Exception e)
	    	{
	    		e.printStackTrace();
	    	}

	    }

	    @Test(priority = 3, testName = "TC - 0003" , enabled = true)
	    // test if it is used a valid email in order to create an account
	    public void createAccounWithExistingUserName() throws IOException, InterruptedException {
	        try {
	        	test = extent.createTest("createAccounWithExistingUserName_0003","Test Passed");
	    	Actions actions= new Actions(driver);
	    	userRegistration = new Registration(driver);
	    	//actions.sendKeys(Keys.PAGE_UP).build().perform();
	    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    	//userRegistration.MyAccountBtnClick();
	    	//System.out.println("The My Account button is clicked");
	        Thread.sleep(3000);
	       driver.findElement(By.id("reg_password")).clear();
	       driver.findElement(By.id("reg_email")).clear();
	       driver.findElement(By.id("reg_username")).clear();
	        userRegistration.EnterUserNameReg("Alexa");
	        userRegistration.EnterEMailReg("Alexa@gmail.com");
	        userRegistration.EnterPassReg("Perscholas0909");
	        //Thread.sleep(5000);
	       //actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	       userRegistration.RegBtnClick();
	        System.out.println("User Registration button clicked");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	        RunReports.takeScreenShot(driver, System.getProperty("user.dir") + "/test-output/screenshots/TC0003A-image1.jpg");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	        String expected = userRegistration.regError();
	        System.out.println(userRegistration.regError());
	        
	        System.out.println(expected);

	        String actual = "Error: An account is already registered with that username. Please choose another.";
	        Assert.assertEquals(expected, actual);
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
