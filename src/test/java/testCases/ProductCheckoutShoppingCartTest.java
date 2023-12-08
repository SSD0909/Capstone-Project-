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
import pages.LoginRegisteredUser;
import pages.ProductAddToCart;
import pages.ProductCheckoutShoppingCart;



public class ProductCheckoutShoppingCartTest {
	
	WebDriver driver;
	 LoginRegisteredUser userLogin;
	 ProductAddToCart productcart;
	 ProductCheckoutShoppingCart checkoutproduct;
	 
	 private static ExtentHtmlReporter htmlReporter;
	    private static ExtentReports extent;
	    private static ExtentTest test;
	    @BeforeSuite
	    public void setUpReport()
	    {
	        //create the HtmlReporter in that path by the name of  SearchReport.html
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
	                + "/test-output/reports/ProductCheckoutShoppingCartTest.html");
	        extent = new ExtentReports();

	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Host Name", "DESKTOP-Learner_9ZH3Z139");
	        extent.setSystemInfo("Environment", "QA Automation");
	        extent.setSystemInfo("User Name", "Stephy Saji Daniel");
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("Automation Testing on Ecommerce WebApplication-Product Checkout from Shopping Cart Report");
	        htmlReporter.config().setReportName("Ecommerce Checkout from Shopping Cart Test and Report");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.DARK);
	    }
	 //Actions actions;
	 @BeforeTest(enabled = true)
	    public void launchBrowser() throws InterruptedException {
	        driver = SelectBrowser.StartBrowser("Chrome");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        Thread.sleep(5000);
	        driver.get("http://demo.perscholastraining.com/");
	        Reporter.log("The browser is open the testing Application");
	        
	    }
	 
			 
			 
				       
					        @Test(priority = 1, testName = "TC - 0010", enabled = true)
						    // test if it is used a valid email in order to create an account
						    public void VerifyProductCartPage() throws IOException, InterruptedException {
						        try {
						        	
						        	test = extent.createTest("VerifyProductCartPage-0010", "Test Passed");
						        	Actions actions= new Actions(driver);
						        	productcart = new ProductAddToCart(driver);
							    	userLogin = new LoginRegisteredUser(driver);
							    	checkoutproduct = new ProductCheckoutShoppingCart(driver);
							    	Thread.sleep(3000);
							    	userLogin.MyAccountBtnClick();
							    	System.out.println("The My Account button is clicked");
							       
							    	userLogin.EnterUserEmail("Stu4@gmail.com");
							        System.out.println("UserName Entered");
							       
							        userLogin.EnterPass("Psssw0rd@#$123452345sfsff");
							        System.out.println("Password Entered");
							        Thread.sleep(5000);
							       actions.sendKeys(Keys.PAGE_DOWN).build().perform();
							       Thread.sleep(3000);
							       userLogin.LoginUserClick();
							       
							        System.out.println("Logged in Successfully");
									driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
							        
							        System.out.println(userLogin.UserNameDisplay());
							        String expectedDisplay="Hello "+ userLogin.UserNameDisplay();
							        System.out.println(expectedDisplay);

							        String actualDisplay ="Hello testcase0004";
							        Assert.assertEquals( expectedDisplay,actualDisplay);
							        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						        	
						        	
							    	Thread.sleep(3000);
							    	productcart.UserHomeClick();
						        	actions.sendKeys(Keys.PAGE_DOWN).build().perform();
						        	Thread.sleep(3000);
						        	productcart.secondproductClick();
						        	
							    	 actions.sendKeys(Keys.PAGE_DOWN).build().perform();
							    	 Thread.sleep(3000);
							    	 productcart.secondproductAddClick();
							    	 
							    	 String secondproductAddedMessage=productcart.secondproductAddedDisplay();
							        	String actualMessageDisplay ="View cart\n"
							        			+ "“Tablet Red EliteBook Revolve 810 G2” has been added to your cart.";
								    	System.out.println(productcart.secondproductAddedDisplay());
								    	 Assert.assertEquals( secondproductAddedMessage,actualMessageDisplay);
								    	 
								    	 boolean viewcartBtnEnabled=productcart.viewcartBtnEnabled();
								    	 Assert.assertEquals( viewcartBtnEnabled,true);
								    	 productcart.viewCartClick();
								    	 
								    	 
								        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
								        Thread.sleep(3000);
										checkoutproduct.checkoutClick();
										RunReports.takeScreenShot(driver, System.getProperty("user.dir")
								        		+ "/test-output/TC-0010A-image2.jpg");
										Thread.sleep(3000);
										RunReports.takeScreenShot(driver, System.getProperty("user.dir")
								        		+ "/test-output/TC-0010A-image1.jpg");
										
										/*String checkoutExpected=checkoutproduct.checkoutTitle();
										String actualDisplaycheckout="Checkout";
										Assert.assertEquals( checkoutExpected,actualDisplaycheckout);*/
										
										String expectedurl = driver.getCurrentUrl();
										Thread.sleep(3000);
								        System.out.println(expectedurl);
								        
								        String urlactual = "http://demo.perscholastraining.com/checkout/";
								        Assert.assertEquals(expectedurl, urlactual);
																
										actions.sendKeys(Keys.PAGE_DOWN).build().perform();
										
										boolean creditcardDisplay=	checkoutproduct.creditcardDisplay();
										Assert.assertEquals(creditcardDisplay, true);
											
							    	 
						    	}
						        catch (Exception e)
						    	{
						    		e.printStackTrace();
						    	}

						    }
					        @Test(priority = 2, testName = "TC - 00011", enabled = true)
						    // test if it is used a valid email in order to create an account
						    public void CheckoutProductInCart() throws IOException, InterruptedException {
						        try {
						        	test = extent.createTest("CheckoutProductInCart-0011", "Test Passed");
						        	Actions actions= new Actions(driver);
						        	checkoutproduct = new ProductCheckoutShoppingCart(driver);
							    	Thread.sleep(3000);
														        	
									driver.findElement(By.id("billing_first_name")).clear();
									driver.findElement(By.id("billing_last_name")).clear();
									driver.findElement(By.id("billing_address_1")).clear();
									driver.findElement(By.id("billing_city")).clear();
									//driver.findElement(By.cssSelector("#billing_state")).clear();
									driver.findElement(By.id("billing_postcode")).clear();
									driver.findElement(By.id("billing_phone")).clear();
									driver.findElement(By.id("billing_email")).clear();
									Thread.sleep(3000);
									checkoutproduct.EnterFirstName("Sam");
									System.out.println("FirstName Entered");												
									checkoutproduct.EnterLastName("Sammy");
									System.out.println("LastName Entered");						        	
									checkoutproduct.EnterAddress("123 SamStreet");
									System.out.println("Address Entered");											
									checkoutproduct.EnterCity("Leander");
									System.out.println("City Entered");
									Thread.sleep(3000);
									//checkoutproduct.EnterState("Texas");
									Select state = new Select(driver.findElement(By.id("billing_state")));
									state.selectByVisibleText("Texas");
									System.out.println("State Selected");			
									checkoutproduct.EnterPostCode("78641");
									System.out.println("PinCode Entered");																
									checkoutproduct.EnterPhone("5125370303");
									System.out.println("Phone Entered");									
									checkoutproduct.EnterEmail("Stu4@gmail.com");
									System.out.println("Email Entered");
									 RunReports.takeScreenShot(driver, System.getProperty("user.dir") 
											 + "/test-output/screenshots/TC-0011A-image1.jpg");
									driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));				
									checkoutproduct.iframe();
									actions.sendKeys(Keys.PAGE_DOWN).build().perform();
									driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
									checkoutproduct.EntercardNumber("4242424242424242");
									System.out.println("Card number Entered");									
									driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
									checkoutproduct.EntercardExpiry("05/26");
									System.out.println("Card Expiry Entered");									
									driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
									checkoutproduct.EntercardCVC("325");
									System.out.println("Card CVC Entered");
									RunReports.takeScreenShot(driver, System.getProperty("user.dir") 
											+ "/test-output/screenshots/TC-0011B-image1.jpg");
									driver.switchTo().defaultContent();
									Thread.sleep(3000);
									checkoutproduct.Clickterms();
									System.out.println("Terms Accepted");									 
									driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
									RunReports.takeScreenShot(driver, System.getProperty("user.dir")
											+ "/test-output/screenshots/TC-0011C-image1.jpg");
									checkoutproduct.placeOrder();
									Thread.sleep(5000);
									
									
									//checking if the order displayed or not																	
									boolean orderdisplay=driver.findElement(By.cssSelector("h1.entry-title")).isDisplayed();
									Assert.assertEquals(orderdisplay,true);
									RunReports.takeScreenShot(driver, System.getProperty("user.dir")
											+ "/test-output/screenshots/TC-0011D-image1.jpg");
									String orderdisplayname=driver.findElement(By.cssSelector("h1.entry-title")).getText();
									System.out.println(orderdisplayname);																
									Thread.sleep(3000);
									String expectedurl = driver.getCurrentUrl();
									//System.out.println(expectedurl);
									//customized css selector to capture the h1 text for the current url
									WebElement orderReceived = driver.findElement(By.cssSelector("header.entry-header h1.entry-title"));
									String expectedDisplay = orderReceived.getText(); 
									String actualOrder="Order received";
									System.out.println(expectedDisplay);
									Assert.assertEquals(expectedDisplay,actualOrder);
									RunReports.takeScreenShot(driver, System.getProperty("user.dir")
											+ "/test-output/screenshots/TC-0011E-image1.jpg");
									
																	        	
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
