package atlantamarket;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AtlantaMarket.ATLProfileAndSettingsPage;
import pageObjects.LasVegasMarket.UXPLandingPage;
import pageObjects.LasVegasMarket.UXPLoginPage;
import pageObjects.LasVegasMarket.UXPProfileAndSettingsPage;
import resources.GenerateData;
import resources.SendEmail;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class AtlantaMarketSmokeTest_UAT extends base {
	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	UXPLandingPage lap;
	UXPLoginPage lp;
	ATLProfileAndSettingsPage atlps;
	SendEmail se;

	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);
		
		//Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(8000);
		lap.getIUnderstandBtn().click();
		Thread.sleep(10000);
	}

	@Test(priority=01)
	public void TS001_VerifyMarketPlannerLoginTest() throws InterruptedException, IOException
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
	
	@Test(priority=02)
	public void TS002_VerifyMarketPlannerProfileAndSettingsOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-002: To verify Profile and Settings option in Market Planner
		
		lap = new UXPLandingPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click Profile and Settings tab under Market Planner and verify result
		atlps.getATLWelcomeText().click();
		atlps.getATLProfileAndSettings().click();
		Thread.sleep(6000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-atlmkt.imcmvdp.com/Profile"));
		System.out.println("Profile and Settings section options are displayed properly");

	}

	
	/*@AfterSuite
	public void sendEmail()
	{
		se = new SendEmail();
		se.sendEmailWithAttachment();
	}*/

}



