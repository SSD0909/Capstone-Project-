package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {
	
	WebDriver driver;
	
	By tag=By.tagName("li");
	By menutag=By.tagName("a");
	
	@FindBy(linkText ="Home")
    WebElement UserHomeClick;
	
	@FindBy(xpath ="//*[@id=\"main\"]/div[3]/div/div/ul/li[1]/a")
	WebElement featuredProducts;
	
	@FindBy(css ="#tab-products-1 > div > ul")
	WebElement totalProductsDisplay;
	
	@FindBy(xpath ="//*[@id=\"masthead\"]/div[1]/div[2]/div[2]")
	WebElement topMenuDisplay ;
	
	 public HomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	 public void UserHomeClick()
	    {
	    	
	    	UserHomeClick.click();
	    } 
	 public void featuredProductsClick()
	    {
	    	
		 featuredProducts.click();
	    } 
	 public List<WebElement> links()
	    {
	    	
	    	return totalProductsDisplay.findElements(tag);
	    	
	    } 
	 public List<WebElement> menuDisplay ()
	    {
	    	
	    	return topMenuDisplay.findElements(menutag);
	    }
}
