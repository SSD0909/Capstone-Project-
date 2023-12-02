package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductAddToCart {

	WebDriver driver;
	
	By MyAccountButton = By.linkText("My Account");
	By productdisplay=By.linkText("White Solo 2 Wireless");
	By productPrice=By.xpath("//*[@id=\"tab-products-1\"]/div/ul/li[3]/div/div/div[3]/div[1]/span/span/span");
	By itemaddedDisplay=By.className("woocommerce-message");
	By secondproductBrand=By.xpath("//*[@id=\"product-2717\"]/div[1]/div[2]/h1");
	//By secondproductaddDisplay=By.xpath("//*[@id=\"main\"]/div[1]/div/a");
	By secondproductaddDisplay=By.className("woocommerce-message");
	//By viewcartDisplay=By.xpath("//*[@id=\"main\"]/div[1]/div/a");
	By listOfProductsImages=By.className("product-thumbnail");
	By listOfProductName=By.className("product-name");
	By productquantity=By.className("product-quantity");
	By productprice=By.className("product-price");
	By productTotalPrice=By.className("product-subtotal");		
	By emptyCartDisplay=By.xpath("//*[@id=\"post-7\"]/div/div/div/div[2]");		
			
	@FindBy(id ="username")
    WebElement EnterUserEmail;
    
    @FindBy (id = "password")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginUser;
    
	@FindBy(linkText ="Home")
    WebElement UserHomeClick;
	
	@FindBy(xpath ="//*[@id=\"tab-products-1\"]/div/ul/li[3]/div/div/div[1]/a/div/img")
    WebElement product;
	
	@FindBy(xpath ="//*[@id=\"tab-products-1\"]/div/ul/li[2]/div/div/div[1]/a/div/img")
    WebElement secondproduct;
	/*@FindBy(linkText ="Tablet Red EliteBook  Revolve 810 G2")
    WebElement secondproduct;*/
	
	
	@FindBy(xpath ="//*[@id=\"product-2717\"]/div[1]/div[2]/form/button")
    WebElement productBtn2;
	
	@FindBy(name="quantity")
	WebElement quantity;
	
	@FindBy(name="add-to-cart")
	WebElement addToCart;
	
	@FindBy(xpath="//*[@id=\"main\"]/div[1]/div/a")
	WebElement cart;
	
	@FindBy(xpath="//*[@id=\"post-7\"]/div/div/form/table/tbody/tr[1]/td[1]/a")
	WebElement deleteproduct;
	
	
	
	public ProductAddToCart(WebDriver driver) {
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
	    public void UserHomeClick()
	    {
	    	
	    	UserHomeClick.click();
	    } 
	    public void productClick()
	    {
	    	
	    	product.click();
	    } 
	    public String ProductName()
	    {
	    	
	    	 return driver.findElement(productdisplay).getText();
	    }
	    
	    
	    public boolean ProductPriceDisplay()
	    {
	    	
	    	 return driver.findElement(productPrice).isDisplayed();
	    }
	    public void productQuantityIncrease()
	    {
	    	
	    	quantity.clear();
	    	//quantity.sendKeys(Keys.ARROW_UP);
	    	quantity.sendKeys("2");
	    } 
	    public void productAddtoCartClick()
	    {
	    	
	    	addToCart.click();
	    }  
	    
	    public String AddedItemMessage()
	    {
	    	
	    	 return driver.findElement(itemaddedDisplay).getText();
	    }
	    
	    public void secondproductClick()
	    {
	    	
	    	secondproduct.click();
	    } 
	    public String productBrandNameDisplay()
	    {
	    	
	    	 return driver.findElement(secondproductBrand).getText();
	    }
	    public void secondproductAddClick()
	    {
	    	
	    	addToCart.click();
	    }  
	    public String secondproductAddedDisplay()
	    {
	    	
	    	 return driver.findElement(secondproductaddDisplay).getText();
	    }
	    
	    public boolean viewcartBtnEnabled()
	    {
	    	return driver.findElement(secondproductaddDisplay).isEnabled();
	    }
	    public void viewCartClick()
	    {
	    	
	    	cart.click();
	    } 
	    
	    
	  //Products image displayed
	    public List<WebElement>  listOfProductsImages()
	    {
	    	  	return driver.findElements(listOfProductsImages);
					
	    } 
	  //Product names displayed
	    public List<WebElement>  listOfProductName()
	    {
	    	  	return driver.findElements(listOfProductName);
					
	    }
		public List<WebElement> productquantity()
		{
			return driver.findElements(productquantity);
		}
		//Product Price List
		public List<WebElement> productprice()
		{
			return driver.findElements(productprice);
		}
		//product total price
		public List<WebElement> productTotalPrice()
		{
			return driver.findElements(productTotalPrice);
		}
		//Remove the products in cart
		 public void removeProductClick()
		    {
		    	
			 deleteproduct.click();
		    } 
		 
		 public String emptyCartDisplay()
		    {
		    	
		    	 return driver.findElement(emptyCartDisplay).getText();
		    }
		    
}
