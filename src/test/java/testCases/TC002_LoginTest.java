package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Myaccountpage;
import testBase.Baseclass;

public class TC002_LoginTest extends Baseclass {
@Test(groups={"Sanity","Master"})
	public void verify_login() 
     {
		logger.info("********* Starting TC002_LoginTest*********** ");
		
		//Homepage
		try {
			
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	logger.info("Clicked on MyAccount Link");
	hp.clickLogin();
	logger.info("Clicked on Login Link");
	 
	//Login page
	
	LoginPage lp=new LoginPage(driver);
	logger.info("Providing login details");
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	lp.clickLogin();
	
	 //Myaccount page
	Myaccountpage map= new Myaccountpage(driver);
	logger.info("Validating expected message");
	 boolean targetPage=map.isMyAccountPageExists();

	Assert.assertTrue(targetPage); // Assert.assertEquals(targetPage, true,"Login Failed");
		}
		catch(Exception e) {
			Assert.fail();
		}
	logger.info("*************Finished TC002_LoginTest***********");
	 
	}
	
}
