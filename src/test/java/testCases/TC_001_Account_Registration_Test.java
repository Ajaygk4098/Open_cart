package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObejects.Account_RegistrationPage;
import pageObejects.Home_Page;
import testBase.BaseClass;

public class TC_001_Account_Registration_Test extends BaseClass{
	
	@Test (groups= {"Regression", "Master"})
	public void Verify_account_Registration() throws Exception {
		
		
		log.info("************* Starting Account registration test case******************************");
		
		log.debug("************ Application logs*****************************************************");
		try {
			Home_Page hp= new Home_Page(driver);
		
			log.info("--Clicking on Account My Account option--");
			hp.My_account();
		
			log.info("--Clicking on Register option--");
			hp.click_Register_btn();
		
			Account_RegistrationPage Ap=new Account_RegistrationPage(driver);
			log.info("--Entering user First name--");
			Ap.EnterFirstName(randomString());
		
			log.info("--Entering user Second name--");
			Ap.EnterLastName(randomString());
			
			log.info("--Entering user Email--");
			Ap.EnterEmail(randomString()+"@gmail.com");
			
			log.info("--Generating password and Entering password--");
			String password=randomAlphanumeric();
			Ap.Setpassword(password);
			
			log.info("--Setting the Agreement terms toggle to YES--");
			Ap.agreeTerms();
			
			log.info("--Clicking continue button after entering the user details--");
			Ap.click_Register_btn();
			
			log.info("--Verifying the confirmation message after account is created--");
			String msg="Your Account Has Been Created!";
			Assert.assertEquals(Ap.check_confirmation(), msg);
		}
		catch(Exception e) {
			log.debug("-----adding debuger logs too");
			log.error("-- Account registration failed");
			Assert.fail();
		}
		log.info("*************Account registration test case completed******************************");
	}
	
	
	
	
}
