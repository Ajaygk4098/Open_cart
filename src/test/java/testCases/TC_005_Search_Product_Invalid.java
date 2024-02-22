package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObejects.Home_Page;
import pageObejects.Login_check;
import pageObejects.My_Account_Page;
import testBase.BaseClass;

public class TC_005_Search_Product_Invalid extends BaseClass{
	
	@Test(groups="Regression")
	public void search_Invalid_product() {
		log.info("************* Starting search for a non existing product test case******************************");
	
		try {
			My_Account_Page AP= new My_Account_Page(driver);
			Login_check lc=new Login_check(driver);
			Home_Page hp= new Home_Page(driver);
			
			log.info("--Clicking on My Account link to login to the application");
			hp.My_account();
			
			log.info("Clicking on the Login_link");
			hp.Login_link_click();
			
			lc.Enter_EmailID(p.getProperty("Email"));
			lc.Enter_Password(p.getProperty("Password"));
			lc.Click_login();
			
			boolean status=AP.My_Account_verify();
			if(status==true) {
				log.info("Entering the item name in the search box");
				AP.search_Item(p.getProperty("product_name"));
				
				log.info("searching for a product and checking if proper message is shown to the user");
				WebElement item=AP.search_Click();
				String name= item.getText();
				if(name.equals(p.getProperty("product_name"))) {
					Assert.assertEquals(true, true);
					log.info("--Item we are searching for is found--");
				}else if(name.equalsIgnoreCase(p.getProperty("NoProductFound_Msg"))) {
					Assert.assertEquals(true, true);
					log.info("--Item we are searching for is not found--");
				}else {
					Assert.assertEquals(false, true);
					log.info("--Wrong item is searched--");
				}
			}
			}catch(Exception e) {
				Assert.fail();
				log.debug("--Error occured while searching for the product--");
		}
		
		log.info("*************Search product test case is completed******************************");
			}
			
		
	
}
	


