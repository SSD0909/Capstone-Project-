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

import lib.SelectBrowser;
import pages.LoginRegisteredUser;
import pages.ProductAddToCart;
public class ProductAddtoCartTest {
	WebDriver driver;
	 LoginRegisteredUser userLogin;
	 ProductAddToCart productcart;
	 SoftAssert softassert= new SoftAssert();
	  private static ExtentHtmlReporter htmlReporter;
	    private static ExtentReports extent;
	    private static ExtentTest test;
	    @BeforeSuite
	    public void setUpReport()
	    {
	        //create the HtmlReporter in that path by the name of  ProductAddtoCartTest.html
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
	                + "/test-output/reports/ProductAddtoCartTest.html");
	        extent = new ExtentReports();

	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Host Name", "DESKTOP-Learner_9ZH3Z139");
	        extent.setSystemInfo("Environment", "QA Automation");
	        extent.setSystemInfo("User Name", "Stephy Saji Daniel");
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("Automation Testing on"
	        		+ " Ecommerce WebApplication-Product Add to Cart Test report");
	        htmlReporter.config().setReportName("Ecommerce Product Add to Cart Test details and Report");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.DARK);
	    }
	 //Actions actions;
	 @BeforeTest(enabled = true)
	    public void launchBrowser() throws InterruptedException {
	        driver = SelectBrowser.StartBrowser("Chrome");
	        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        //Thread.sleep(5000);
	        driver.get("http://demo.perscholastraining.com/");
	        Reporter.log("The browser is open the testing Application");
	        
	    }
	 @Test(priority = 4, testName = "TC - 0008", enabled = true)
	    // test if products added to cart is displayed in view cart page
	    public void ViewCartPage() throws IOException, InterruptedException {
	        try {
	        	test = extent.createTest("ViewCartPage_0008", "Test Passed");
	        	Actions actions= new Actions(driver);
	        	productcart = new ProductAddToCart(driver);
		    	//Thread.sleep(3000);
	        	productcart.viewCartClick();
	        	
	        	//Product Quantity List
				List<WebElement> productquantity = productcart.productquantity();
				System.out.println("The quantity of each product is");
				int size=productquantity.size();
				for(int i=1; i < size; i++)
		        {					        	
		            WebElement linkElement = driver.findElement
(By.xpath("/html/body/div[1]/div/div[3]/div/div/div/main/article/div/div/form/table/tbody/tr["+i+"]/td[5]/div/input"));
		            System.out.println(linkElement.getAttribute("value"));     
		            RunReports.takeScreenShot(driver, System.getProperty("user.dir")
		            		+ "/test-output/screenshots/TC0008C-image"+i+".jpg");
		            String expectedQuantity=linkElement.getAttribute("value");
		            
		            //The code below uses assertNotNull() to validate if the expected output is not null
		            softassert.assertNotNull(expectedQuantity);
		        }
	        			        	
	        	//Pdts image displayed
	        	List<WebElement> listOfProductsImages=productcart.listOfProductsImages();
	        	System.out.println("The total product images displayed is:");
	        	System.out.println(listOfProductsImages.size()-1);
	        		int actualImagecount=2;
	        	RunReports.takeScreenShot(driver, System.getProperty("user.dir") 
	        			+ "/test-output/screenshots/TC0008A-image1.jpg");
	        	int expectedValue=listOfProductsImages.size()-1;
		          Assert.assertEquals(expectedValue, actualImagecount);
		          
		          
		          
		          
		          
		          			        	
	        	//Product names displayed
				List<WebElement> listOfProductName = productcart.listOfProductName();
				System.out.println("The Total products added int cart are");
				System.out.println(listOfProductName.size()-1);
				 System.out.println("The added product names are");
				 
				for (WebElement webElement : listOfProductName) {
		            String name = webElement.getText();
		             System.out.println(name);
		             String expectedName=name;
		             RunReports.takeScreenShot(driver, System.getProperty("user.dir") 
		            		 + "/test-output/screenshots/TC0008B-image1.jpg");
			            String actualName1="White Solo 2 Wireless";
			            String actualName2="Tablet Red EliteBook Revolve 810 G2";
			            if (actualName1==expectedName) {
			            Assert.assertEquals(expectedName,actualName1 );}
			            else if(actualName2==expectedName) {
			            	Assert.assertEquals(expectedName,actualName2 );
			            }
		        }
				//Thread.sleep(3000);
				
				
				
				
				
				
		        
		        
		        
		        
					//Product Price 
				List<WebElement> productprice = productcart.productprice();
				System.out.println("Product price for individual product are:");
				for (WebElement webElement : productprice) {
		            String price = webElement.getText();
		            RunReports.takeScreenShot(driver, System.getProperty("user.dir")
		            		+ "/test-output/screenshots/TC0008D-image1.jpg");
		            System.out.println(price);
		            softassert.assertNotNull(price);
		        }
				
				
	         //product subtotal
				List<WebElement> productTotalPrice = productcart.productTotalPrice();
				System.out.println("SubTotal of each product added are:");
				for (WebElement webElement : productTotalPrice) {
		            String subTotal = webElement.getText();
		            RunReports.takeScreenShot(driver, System.getProperty("user.dir") 
		            		+ "/test-output/screenshots/TC0008E-image1.jpg");
		            System.out.println(subTotal);
		            softassert.assertNotNull(subTotal);
		        }
				if(listOfProductsImages.isEmpty())
		        {
					softassert.assertTrue(listOfProductsImages.isEmpty(), "");
					softassert.assertTrue(listOfProductName.isEmpty(), "");
					softassert.assertTrue(productprice.isEmpty(), "");
					softassert.assertTrue(productTotalPrice.isEmpty(), "");
		        }
		        else
		        {
		            Assert.assertFalse(listOfProductsImages.size() == 0, "Matched"); 
		            // Here, the condition is false. So, the test case will be passed by assertion.
		            Assert.assertFalse(listOfProductName.size() == 0, "Matched"); 
		            // Here, the condition is false. So, the test case will be passed by assertion.
		            Assert.assertFalse(productprice.size() == 0, "Matched"); 
		            // Here, the condition is false. So, the test case will be passed by assertion.
		            Assert.assertFalse(productTotalPrice.size() == 0, "Matched");
		        }
	        	
	        	
	    	}
	        catch (Exception e)
			{
				e.printStackTrace();
			}
     }
	
	        @Test(priority = 1, testName = "TC - 0005", enabled = true)
		    // test if it is used a valid email in order to create an account
		    public void ProductPrice() throws IOException, InterruptedException {
		        try {
		        		test = extent.createTest("ProductPrice_0005", "Test Passed");
		        	Actions actions= new Actions(driver);
		        	userLogin = new LoginRegisteredUser(driver);
		        	//Thread.sleep(3000);
			    	userLogin.MyAccountBtnClick();
			    	System.out.println("The My Account button is clicked");
			       	userLogin.EnterUserEmail("Stu4@gmail.com");
			        System.out.println("UserName Entered");
			        userLogin.EnterPass("Psssw0rd@#$123452345sfsff");
			        System.out.println("Password Entered");
			       //actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			       //Thread.sleep(3000);
			       userLogin.LoginUserClick();
			        //Thread.sleep(3000);
			        System.out.println("Logged in Successfully");
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			       System.out.println(userLogin.UserNameDisplay());
			        String expectedDisplay="Hello "+ userLogin.UserNameDisplay();
			        System.out.println(expectedDisplay);
			        RunReports.takeScreenShot(driver, System.getProperty("user.dir") 
			        		+ "/test-output/screenshots/TC-0005A-image1.jpg");
			        String actualDisplay ="Hello testcase0004";
			        Assert.assertEquals( expectedDisplay,actualDisplay);
			        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			         	productcart = new ProductAddToCart(driver);
		    	//Thread.sleep(3000);
		    	productcart.UserHomeClick();
		    	  	
		    	System.out.println("User is in HomePage");
		    	
		    	
		    	//products price displayed
		    	boolean productPriceDisplay=productcart.ProductPriceDisplay();
		    	 RunReports.takeScreenShot(driver, System.getProperty("user.dir") 
		    			 + "/test-output/screenshots/TC0005B-image1.jpg");
		    	System.out.println(productcart.ProductPriceDisplay());
		    	 Assert.assertEquals( productPriceDisplay,true);
		    	 //click on a product
		    	// actions.sendKeys(Keys.PAGE_UP).build().perform();
		    	 
		    	 
		    	 
		    	 
		    	 
		    	//productcart.UserHomeClick();
		    	//Thread.sleep(3000);
		    	//actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		    	//Thread.sleep(3000);
		    	 productcart.productClick();
		    	  	     	String actualpdtDisplay ="White Solo 2 Wireless";
			    	String expectedProductName=productcart.ProductName();
			    	 RunReports.takeScreenShot(driver, System.getProperty("user.dir")
			    			 + "/test-output/screenshots/TC0005C-image1.jpg");
			    	System.out.println(productcart.ProductName());
			    	 Assert.assertEquals( expectedProductName,actualpdtDisplay);
		    	
		    	}
		        catch (Exception e)
				{
					e.printStackTrace();
				}
	        }
		        @Test(priority = 2, testName = "TC - 0006", enabled = true)
			    // 
			    public void ProductQuantityChange() throws IOException, InterruptedException {
			        try {
			        	test = extent.createTest("ProductQuantityChange_0006", "Test Passed");
			        	productcart = new ProductAddToCart(driver);
				    	//Thread.sleep(3000);
			        	//Actions actions= new Actions(driver);
			        	//actions.sendKeys(Keys.PAGE_DOWN).build().perform();
			        	//Thread.sleep(3000);
			        	productcart.productQuantityIncrease();
			        	WebElement quantityvalue = driver.findElement(By.name("quantity"));
			            System.out.println(quantityvalue.getAttribute("value")); 
			            RunReports.takeScreenShot(driver, System.getProperty("user.dir") 
			            		+ "/test-output/screenshots/TC0006A-image1.jpg");
			        	String expectedQuantity=quantityvalue.getAttribute("value");
			        	String actualQuantity="2";
			        	Assert.assertEquals( expectedQuantity,actualQuantity);
			        	System.out.println("The Product Quantity is increased");
			        	productcart.productAddtoCartClick();
			        	System.out.println("The product is added to cart");
			        				    	}
			        catch (Exception e)
					{
						e.printStackTrace();
					}
		        }
			        @Test(priority = 3, testName = "TC - 0007", enabled = true)
				    				    public void VerifyProductCartPage() throws IOException, InterruptedException {
				        try {
				        	test = extent.createTest("VerifyProductCartPage_0007", "Test Passed");
				        	//Actions actions= new Actions(driver);
				        	productcart = new ProductAddToCart(driver);
					    	productcart.UserHomeClick();
					    	//Thread.sleep(3000);
					    	//actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					    	 //Thread.sleep(3000);
					    	 productcart.secondproductClick();
					    	String productBrandNameDisplayed=productcart.productBrandNameDisplay();
				        	String actualDisplay ="Tablet Red EliteBook Revolve 810 G2";
					    	System.out.println(productcart.productBrandNameDisplay());
					    	RunReports.takeScreenShot(driver, System.getProperty("user.dir") 
					    			+ "/test-output/screenshots/TC0007A-image1.jpg");
					    	 Assert.assertEquals( productBrandNameDisplayed,actualDisplay);
					    	 
					    	 
					    	 
					    	 
					    	// Thread.sleep(3000);
					    	//actions.sendKeys(Keys.PAGE_DOWN).build().perform();
					    	//Thread.sleep(3000);
					    	 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
					    	 productcart.secondproductAddClick();
					    	 //Thread.sleep(3000);
					    	 String secondproductAddedMessage=productcart.secondproductAddedDisplay();
					    	 RunReports.takeScreenShot(driver, System.getProperty("user.dir")
					    			 + "/test-output/screenshots/TC0007B-image1.jpg");
					        	String actualMessageDisplay ="View cart\n"
					        			+ "“Tablet Red EliteBook Revolve 810 G2” has been added to your cart.";
						    	System.out.println(productcart.secondproductAddedDisplay());
						    	 Assert.assertEquals( secondproductAddedMessage,actualMessageDisplay);
						    	 boolean viewcartBtnEnabled=productcart.viewcartBtnEnabled();
						    	 Assert.assertEquals( viewcartBtnEnabled,true);
					    	 				    	}
				        catch (Exception e)
				    	{
				    		e.printStackTrace();
				    	}

				    }
				        
				        
					        
					        @Test(priority = 6, testName = "TC - 0009", enabled = true)
						    // test if it is used a valid email in order to create an account
						    public void RemoveProduct() throws IOException, InterruptedException {
						        try {
						        	test = extent.createTest("RemoveProduct_0009", "Test Passed");
						        	Actions actions= new Actions(driver);
						        	productcart = new ProductAddToCart(driver);
							    	Thread.sleep(3000);
						        	for(int i=0;i<2;i++) {
						        	productcart.removeProductClick();
						        	Thread.sleep(3000);
						        	}
						        	productcart.emptyCartDisplay();
						        	RunReports.takeScreenShot(driver, System.getProperty("user.dir") 
						        			+ "/test-output/screenshots/TC0009-image1.jpg");
						        	String emptyCartDisplay=productcart.emptyCartDisplay();
						        	String actualDisplay ="Your cart is currently empty.";
							    	System.out.println(productcart.emptyCartDisplay());
							    	 Assert.assertEquals( emptyCartDisplay,actualDisplay);
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
