package pageObejects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends BasePage {
	WebDriver driver;
	
	
	//This constructor calls the constructor of the "Base Page" with the help of super keyword and assigns the driver object to base page so, the driver can be used in all different pages of Page factory
	public Home_Page(WebDriver driver) {
		super(driver);
	}
	
	
	//We are finding the address of My account option
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement My_account;
	
	//We are finding the address of Register btn using page factory pattern
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Register_btn;
	
	//We are finding the Login in link inside home page
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement Login_link;
	
	//This method will click on the my account account option
	public void My_account() {
		My_account.click();
		
	}
	
	
	//This method will click on the Register button when called from the test method
	public void click_Register_btn() {
		Register_btn.click();
	}

	//When called this method will click on click on the log in link present under My account option in the home page
	public void Login_link_click() {
		Login_link.click();
	}
	
}
