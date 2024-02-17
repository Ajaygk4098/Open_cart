package pageObejects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Account_RegistrationPage extends BasePage {
	
	//WebDriver driver;
	WebDriverWait wait;
	
	public Account_RegistrationPage(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(css="#input-firstname")
	WebElement First_name;
	
	@FindBy(css="#input-lastname")
	WebElement Last_name;
	
	@FindBy(css="#input-email")
	WebElement Email;
	
	@FindBy(css="#input-password")
	WebElement Password;
	
	@FindBy(css="button[type='submit']")
	WebElement Register_Btn;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmation_msg;
	
	@FindBy(css="input[value='1'][name='agree']")
	WebElement Agree_Terms;
	
	public void EnterFirstName(String FirstName) {
		First_name.sendKeys(FirstName);
	}
	
	public void EnterLastName(String LastName) {
		Last_name.sendKeys(LastName);
	}
	
	
	public void EnterEmail(String Mail_ID) {
		Email.sendKeys(Mail_ID);
	}
	
	public void Setpassword(String psw) {
		Password.sendKeys(psw);
	}
	
	public void click_Register_btn() {
		//Register_Btn.click();
		Register_Btn.submit();
	}	
	public void agreeTerms() {
		Actions act=new Actions(driver);
		act.moveToElement(Agree_Terms);
		act.click(Agree_Terms).perform();
		
				
		//		Agree_Terms.sendKeys(Keys.ENTER);
	}
	public String check_confirmation() throws Exception {
		String msg;
		
		/*wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(confirmation_msg));*/
		Thread.sleep(3000);
		try {
			msg=confirmation_msg.getText();
			return msg;
		}catch(Exception e) {
			return msg="";
		}
	}
}
