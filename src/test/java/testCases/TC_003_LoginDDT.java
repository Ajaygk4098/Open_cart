package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObejects.Home_Page;
import pageObejects.Login_check;
import pageObejects.My_Account_Page;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void Verify_login(String email, String psw, String exp) {
		
		log.info("************* Starting Login test case with different data******************************");
		
		log.debug("************ Application logs*****************************************************");
		
		try {
			//Here creating the object of Login_check and My_Account_page page factor classes
			Login_check lc=new Login_check(driver);
			My_Account_Page AP= new My_Account_Page(driver);
			Home_Page hp=new Home_Page(driver);
		
			log.info("--Clicking in the My account link in the home page");
			hp.My_account();
		
			log.info("--Clicking on the Login_link");
			hp.Login_link_click();
			
			
			log.info("--Entering Email ID which is mentioned in the Excel file--");
			lc.Enter_EmailID(email);
			
			log.info("--Entering Password which is mentioned in the Excel file--");
			lc.Enter_Password(psw);
			
			log.info("--Clicking on the login button--");
			lc.Click_login();
			
			//here we are checking after login is done My account link is displayed or not
			boolean status=AP.My_Account_verify();
			if(exp.equalsIgnoreCase("Valid")){ 
				if(status==true) {
					log.info("--Login successfull done--");
					AP.Log_out();
					Assert.assertTrue(true);
				}else { 
					log.error("--Login un-successuful--");
					Assert.assertFalse(true);
				}
			}
			if(exp.equalsIgnoreCase("Invalid")){
				if(status==true) {
					log.info("--Login successfull with invalid data hence test failed--");
					Assert.assertFalse(true);
					AP.Log_out();
				}else {
					log.info("--Login not successful with invalid data hence test passed");
					Assert.assertTrue(true);
				}
			}	
			
		}catch (Exception e) {
			log.debug("-- Error occured while loging into the application");
			
		}
		log.info("*************Completed data driven test for multiple data inputs******************************");
	}

}
