package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObejects.Home_Page;
import pageObejects.Login_check;
import pageObejects.My_Account_Page;
import testBase.BaseClass;

public class TC_004_Search_Product extends BaseClass{
	
	
	@Test(groups="Master")
	public void search_product() {
		
		log.info("************* Starting search product test case******************************");
		
		try {
			log.debug("************ Application logs*****************************************************");
			My_Account_Page AP= new My_Account_Page(driver);
			Login_check lc=new Login_check(driver);
			Home_Page hp=new Home_Page(driver);
		
			log.info("--Clicking in the My account link in the home page");
			hp.My_account();
		
			log.info("Clicking on the Login_link");
			hp.Login_link_click();
			
			lc.Enter_EmailID(p.getProperty("Email"));
			lc.Enter_Password(p.getProperty("Password"));
			lc.Click_login();
			
			boolean Status=AP.My_Account_verify();
			if(Status==true) {
				log.info("--Adding the product name in the search box--");
				AP.search_Item(p.getProperty("product_name"));
		
				log.info("--verifying if the item is displayed and matched with the product name entered in the config file");
				WebElement item=AP.search_Click();
				String name= item.getAttribute("title");
				if(name.equals(p.getProperty("product_name"))) {
					Assert.assertEquals(true, true);
				}else
					Assert.assertEquals(false, true);
				}	
			}catch(Exception e) {
				Assert.fail();
			log.debug("--Error occured while searching for the product--");
		}
		
		log.info("*************Search product test case is completed******************************");
	}
}
