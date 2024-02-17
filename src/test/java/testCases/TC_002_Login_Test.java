package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObejects.Home_Page;
import pageObejects.Login_check;
import pageObejects.My_Account_Page;
import testBase.BaseClass;

public class TC_002_Login_Test extends BaseClass{
	
	
	@Test (groups= {"Sanity", "Master"})
	public void Login_Test() throws Exception{
		log.info("************* Starting Login test case******************************");
		
		log.debug("************ Application logs*****************************************************");
		
		try {
			//Here creating the object of Login_check and My_Account_page page factor classes
			Login_check lc=new Login_check(driver);
			My_Account_Page AP= new My_Account_Page(driver);
			Home_Page hp=new Home_Page(driver);
		
			log.info("--Clicking in the My account link in the home page");
			hp.My_account();
		
			log.info("Clicking on the Login_link");
			hp.Login_link_click();
			
			
			log.info("--Entering Email ID which is mentioned in the config.properties file--");
			lc.Enter_EmailID(p.getProperty("Email"));
			
			log.info("--Entering Password which is mentioned in the config.properties file--");
			lc.Enter_Password(p.getProperty("Password"));
			
			log.info("--Clicking on the login button--");
			lc.Click_login();
			
			//here we are checking after login is done My account link is displayed or not
			boolean Status=AP.My_Account_verify();
			if(Status==true) {
				log.info("--Login successfull done--");
				Assert.assertTrue(true);
			}else {
				log.error("--Login un-successuful--");
				Assert.fail();
			}	
			AP.Log_out();
		}catch (Exception e) {
			log.debug("-- Error occured while loging into the application");
			Assert.fail();
			
		}
		log.info("*************Login test case completed******************************");
	
	}
	
}
