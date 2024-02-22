package pageObejects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class My_Account_Page extends BasePage{
	

	
	public My_Account_Page(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	//Finding My Account label
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement My_Account_Lable;
	
	//Finding the address of Log out link which is present inside My Account page
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement Log_out;
	
	//Finding the search bar to enter the search text
	@FindBy(css="input[placeholder='Search']")
	WebElement searchbox;
	
	//Finding the search icon button
	@FindBy(css=".btn.btn-light.btn-lg")
	WebElement search_Button;
	
	//Getting the address of the searched item
	@FindBy(css="div[class='description'] h4 a")
	WebElement search_Result;
	
	@FindBy(css="div[id='content'] h2")
	WebElement search_Heading;
	
	@FindBy(css="div[id='content'] p")
	WebElement No_Item;
	
	//This method will verify My_Account is displayed or not
	public boolean My_Account_verify() {
		wait.until(ExpectedConditions.visibilityOf(My_Account_Lable));
		try {
			return(My_Account_Lable.isDisplayed());
		}catch(Exception e) {
			return false;}
		}
	
	//This method will click on the log out link
	public void Log_out() {
		Log_out.click();
	}
	
	public void search_Item(String item) {
		
		searchbox.sendKeys(item);
		
	}
	
	public WebElement search_Click() {
		
		search_Button.click();
		
		wait.until(ExpectedConditions.visibilityOf(search_Heading));
		
		try {
		if(search_Result.isDisplayed()) 
			return search_Result;
			
		}catch(Exception e) {
			return No_Item;
		}
	return No_Item;
	}
	
}

