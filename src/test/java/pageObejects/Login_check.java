package pageObejects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_check extends BasePage{

	public Login_check(WebDriver driver) {
		
		super(driver);
	}
	
	//Finds the Email ID field in login customer section
	@FindBy(css="#input-email")
	WebElement Email_Field;
	
	//Finds the Password field in login customer section
	@FindBy(css="#input-password")
	WebElement Password_Field;
	
	//Finds the login button in login customer section
	@FindBy(css="button[type='submit']")
	WebElement login_Btn;

	
	public void Enter_EmailID(String emailID) {
		Email_Field.sendKeys(emailID);
	}
	
	public void Enter_Password(String psw) {
		Password_Field.sendKeys(psw);
	}
	
	public void Click_login() {
		login_Btn.click();
	}
}
