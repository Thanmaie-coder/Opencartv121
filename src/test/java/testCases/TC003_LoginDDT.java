package testCases;
/*
 Data is valid-login success-test pass-logout
 Data is valid-login failed-test fail
 
 Data is invalid-login success-test fail-logout
 Data is invalid-login failed-test pass
 */

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Myaccountpage;
import testBase.Baseclass;
import utilities.DataProviders;

public class TC003_LoginDDT extends Baseclass{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="Datadriven") //getting data provider from different package
	
	public void verify_loginDDT(String email,String pwd,String exp) 
    {
		logger.info("****************Starting the test TC003_LoginDDT************");
		//Homepage
		
			try
			{
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	
	hp.clickLogin();
	
	 
	//Login page
	
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(email);
	lp.setPassword(pwd);
	lp.clickLogin();
	
	 //Myaccount page
	Myaccountpage map= new Myaccountpage(driver);
	boolean targetPage=map.isMyAccountPageExists();
	/*Data is valid-login success-test pass-logout
	               -login failed-test fail         */
	 
if(exp.equalsIgnoreCase("Valid"))
{
	if(targetPage==true)
	{
		map.clicklogout();
		Assert.assertTrue(true);
		
	}
	else
	{
		Assert.assertTrue(false);
	}
}
/*Data is invalid-login success-test fail-logout
                 -login failed-test pass
*/
if(exp.equalsIgnoreCase("InValid"))
{
	if(targetPage==true)
	{
		map.clicklogout();
		Assert.assertTrue(false);
		
	}
	else
	{
		Assert.assertTrue(true);
	}
}
			}catch(Exception e)
			{
				Assert.fail();
			}
	
	logger.info("******Finished TC003_LoginDDT************");
	
	
	
	
	
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
