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
	
}

