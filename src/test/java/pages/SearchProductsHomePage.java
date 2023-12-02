package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductsHomePage {
	
	WebDriver driver;
	
	
	
	@FindBy(id ="search")
	WebElement search;
	
	@FindBy(css ="#menu-item-5470 > a")
	WebElement home;
	
	
	@FindBy(xpath ="//*[@id=\"masthead\"]/div[1]/div[1]/form/div/div[3]/button/i")
	WebElement searchButton;
	
	@FindBy(xpath ="//*[@id=\"product-2926\"]/div[1]/div[2]/h1")
	WebElement pdtDisplayed;
	
	@FindBy(xpath ="//*[@id=\"main\"]/div[1]/div/div/div/section/header/h2")
	WebElement nullDisplay;
	
	 public SearchProductsHomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	 public void search(String args)
	    {
	    	
		 search.clear();
		 search.sendKeys(args);
		 
	    } 
	 public void searchButtonClick()
	    {
		 searchButton.click();
		
		 
	    } 
	 public void homeClick()
	    {
		 home.click();
		
		 
	    } 
	 
	 public String pdtDisplayed()
	    {
	    	
		 return pdtDisplayed.getText();
		 
	    } 
	 
	 public String nullpdtDisplayed()
	    {
	    	
		 return nullDisplay.getText();
		 
	    } 
}
