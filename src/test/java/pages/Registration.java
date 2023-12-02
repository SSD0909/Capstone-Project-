package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Registration {

	 WebDriver driver;
	
	
	 // @FindBy(linkText = "My Account");
	    //WebElement MyAccountButton;

	    By MyAccountButton = By.linkText("My Account");
	    By myAccountTitle=By.className("entry-title");
	    By weakpasswordMessageDisplay=By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[4]/span/div");
	    By registerationBtnEnable=By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[5]/button");
	    By regError=By.className("woocommerce-error");
	    
	    @FindBy(id ="reg_username")
	    WebElement regUser;
	  
	    @FindBy (id = "reg_email")
	    WebElement regEmail;

	    @FindBy(xpath = "//*[@id=\"reg_password\"]")
	    WebElement regPass;

	    @FindBy(name = "register")
	    WebElement regSubmit;
	    
	    @FindBy(xpath ="//*[@id=\"menu-item-4100\"]/a")
	    WebElement myAccountBtn;
	 
	    public Registration(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void MyAccountBtnClick()
	    {
	        driver.findElement(MyAccountButton).click();
	    }
	    public void myAccountBtn()
	    {
	        myAccountBtn.click();
	    }
	    public void EnterUserNameReg(String arg)
	    {
	    	regUser.sendKeys(arg);
	    }
	    public void EnterEMailReg(String arg)
	    {
	    	regEmail.sendKeys(arg);
	    }
	    public void EnterPassReg(String arg)
	    {
	    	regPass.sendKeys(arg);
	    }
	    public void RegBtnClick()
	    {
	    	
	    	regSubmit.click();
	    }

	    public String myAccountDisplayed()
	    {
	        return  driver.findElement(myAccountTitle).getText();
	    }

	    public String weakpasswordMessageDisplay()
	    {
	        return driver.findElement(weakpasswordMessageDisplay).getText();
	    }
	    public boolean registerationBtnEnable()
	    {
	        return driver.findElement(registerationBtnEnable).isEnabled();
	    }
	    
	    public String regError()
	    {
	    	return driver.findElement(regError).getText();
	    }
	

	
}
