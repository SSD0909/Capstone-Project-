package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginRegisteredUser {

	
	
	 WebDriver driver;
		
	

	    By MyAccountButton = By.linkText("My Account");
	    By UserNameDisplay=By.xpath("//*[@id=\"post-3854\"]/div/div/div/p[1]/strong[1]");
	    
	  
	    @FindBy(id ="username")
	    WebElement EnterUserEmail;
	    
	    @FindBy (id = "password")
	    WebElement password;

	    

	    @FindBy(name = "login")
	    WebElement loginUser;
         
	 
	    public LoginRegisteredUser(WebDriver driver) {
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
	    
	
}


