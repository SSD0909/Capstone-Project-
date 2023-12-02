package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class ProductCheckoutShoppingCart {

	WebDriver driver;
	
	

    By MyAccountButton = By.linkText("My Account");
    By UserNameDisplay=By.xpath("//*[@id=\"post-3854\"]/div/div/div/p[1]/strong[1]");
    //By checkoutTitle=By.className("//*[@id=\"post-8\"]/header/h1");
    By creditcardDisplay=By.xpath("//*[@id=\"payment\"]/ul/li/label");
    By billingheader=By.xpath("//*[@id=\"customer_details\"]/div[1]/div/h3");
    By switchToframe=By.tagName("iframe");
    
    
    
    
    
    @FindBy(id ="username")
    WebElement EnterUserEmail;
    
    @FindBy (id = "password")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginUser;
    
    @FindBy(linkText="Proceed to checkout")
    WebElement checkout;
    
    @FindBy(css="#billing_first_name")
    WebElement firstName;
    
    
    @FindBy(css="#billing_last_name")
    WebElement lastName;
    
    @FindBy(css="#billing_address_1")
    WebElement address;
    
    @FindBy(css="#billing_city")
    WebElement city;
    
    @FindBy(id="billing_state")
    Select state;
    
    @FindBy(id="billing_postcode")
    WebElement postalCode;
    
    @FindBy(css="#billing_phone")
    WebElement phone ;
    
    @FindBy(id="billing_email")
    WebElement email ;
   
    
    @FindBy (className="__PrivateStripeElement")
    WebElement stripeIFrameElementContainer;
    
    @FindBy(css="#Field-numberInput")
    WebElement cardNumber ;
    
    @FindBy(css="#Field-expiryInput")
    WebElement cardExpiry ;
    
    @FindBy(css="#Field-cvcInput")
    WebElement cardCVC ;
    
    @FindBy(name="terms")
    WebElement terms ;
    
    @FindBy(name="woocommerce_checkout_place_order")
    WebElement placeOrder;
    
    @FindBy(xpath="//*[@id=\"post-8\"]/div/div/div/p")
    WebElement orderReceived;
    
    
    
    
    public ProductCheckoutShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void MyAccountBtnClick()
    {
        driver.findElement(MyAccountButton).click();
    }
    public void EnterUserEmail(String arg)
    {
    	EnterUserEmail.sendKeys(arg);
    }
   
    public void EnterPass(String arg)
    {
    	password.sendKeys(arg);
    }
    public void LoginUserClick()
    {
    	
    	loginUser.click();
    }

     public String UserNameDisplay()
    {
        return driver.findElement(UserNameDisplay).getText();
    }
     public void checkoutClick()
     {
     	
    	 checkout.click();
     }
    // public String checkoutTitle()
     //{
     //    return driver.findElement(checkoutTitle).getText();
   //  }
     public boolean creditcardDisplay()
     {
         return driver.findElement(creditcardDisplay).isDisplayed();
     }
     public String BillingHeader()
     {
         return driver.findElement(billingheader).getText();
     }
     public void EnterFirstName(String arg)
     {
    	 //firstName.clear();
    	 firstName.sendKeys(arg);
     }
     public void EnterLastName(String arg)
     {
    	 //lastName.clear();
    	 lastName.sendKeys(arg);
     }
     public void EnterAddress(String arg)
     {
    	 //address.clear();
    	 address.sendKeys(arg);
     }
     public void EnterCity(String arg)
     {
    	 //city.clear();
    	 city.sendKeys(arg);
     }
     public void EnterState(String arg)
     {
    	 state.selectByVisibleText(arg);
     }
     public void EnterPostCode(String arg)
     {
    	// postalCode.clear();
    	 postalCode.sendKeys(arg);
     }
     public void EnterPhone(String arg)
     {
    	 //phone.clear();
    	 phone.sendKeys(arg);
     }
     public void EnterEmail(String arg)
     {
    	 //phone.clear();
    	 email.sendKeys(arg);
     }
     
         
     public void iframe() {
    	 
    	 driver.switchTo().frame(stripeIFrameElementContainer.findElement(switchToframe));
    	 
     }
     public void EntercardNumber(String arg)
     {
    	 
    	 cardNumber.sendKeys(arg);
     }
     public void EntercardExpiry(String arg)
     {
    	 cardExpiry.sendKeys(arg);
     }
     public void EntercardCVC(String arg)
     {
    	 cardCVC.sendKeys(arg);
     }
     public void Clickterms()
     {
    	 terms.click();
     }
     public void placeOrder()
     {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 js.executeScript("arguments[0].click();", placeOrder);
     }
     
     public String orderReceived()
     {
    	 return orderReceived.getText();
     }
}
