package lasvegasmarket;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pgeObjects.UXPLandingPage;
import pgeObjects.UXPLoginPage;
import resources.GenerateData;
import resources.SendEmail;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class MarketPlannerPageTest extends base {
	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	UXPLandingPage lap;
	UXPLoginPage lp;
	SendEmail se;
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
	}

	@Test(priority=01)
	public void TS001_VerifyMarketPlannerTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-001: To verify the Market Planner overview and it's functionality
		
		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Login to Market Planner
		utl.verifyMPLoginFunctionality();
		
		//Verify that Market Planner Home page should be displayed
		Assert.assertTrue(lap.getMPLinkText().isDisplayed());
	}
	
/*	@AfterSuite
	public void sendEmail()
	{
		se = new SendEmail();
		se.sendEmailWithAttachment();
	}*/
	
}
