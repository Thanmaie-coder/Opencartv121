package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.Baseclass;

public class TC001_AccountRegistrationTest  extends Baseclass{


	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		try {
		logger.info("******Starting TC001_AccountRegistrationTest****** ");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link..");
		RegisterPage rp=new RegisterPage(driver);
		
		logger.info("Providing customer details");
		rp.setFirstname(randomString().toUpperCase());
		rp.setLastname(randomString().toUpperCase());
		rp.setEmail(randomString()+"@gmail.com"); //randomly generated the email
		rp.setTelephone(randomNumber());
		
		String password=randomAlphanumeric();
		rp.setPassword(password);
		rp.setConfirmPassword(password);
		rp.clickPrivacypolicy();
		rp.clickContinue();
		
		logger.info("Validating expected message");
		String confirmmsg=rp.getConfirmationMsg();
		if(confirmmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
			
		}
		else
		{
			logger.error("Test failed");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confirmmsg,"Your Account Has Been Created" );
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("***** Finished TC001_AccountRegistrationTest");
	}
	
		
	
}
