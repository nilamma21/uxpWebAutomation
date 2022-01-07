package lasvegasmarket;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.LasVegasMarket.UXPExhibitPage;
import pageObjects.LasVegasMarket.UXPLandingPage;
import pageObjects.LasVegasMarket.UXPLoginPage;
import resources.GenerateData;
import resources.SendEmail;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class LagVegasMarketSmokeTest extends base {
	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	UXPLandingPage lap;
	UXPLoginPage lp;
	UXPExhibitPage exh;
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
	
	@Test(priority=02)
	public void TS002_VerifExhibitTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-002: To verify the Exhibit menu overview and it's functionality
		
		lap = new UXPLandingPage(driver);
		exh = new UXPExhibitPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Click on Exhibit tab
		exh.getExhibitTab().click();
		
		//Click on 'Why Exhibit?' sub-menu
		exh.getWhyExhibitMenu().click();
		
		Thread.sleep(6000);
		//Verify that 'Exhibit' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Exhibit | Las Vegas Market"));
		
		//Click on Exhibit tab
		exh.getExhibitTab().click();
				
		//Click on 'Exhibit Opportunities' sub-menu
		exh.getExhibitOpptMenu().click();
		
		Thread.sleep(6000);
		//Verify that 'Exhibit Opportunities' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Exhibit Opportunities | Las Vegas Market"));
		
		//Click on Exhibit tab
		exh.getExhibitTab().click();
				
		//Click on 'Advertising & Sponsorships' link
		exh.getAdvertisingnSponsershipsMenu().click();
		
		Thread.sleep(6000);
		//Verify that 'Advertising & Sponsorships' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Marketing and Sponsorship Opportunities | Las Vegas Market"));
		
		//Click on Exhibit tab
		exh.getExhibitTab().click();
		
		//Click on 'Tips for Exhibitors' sub-menu
		exh.getTipsForExhibitorsMenu().click();
		
		Thread.sleep(6000);
		//Verify that 'Tips for Exhibitors' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Tips for Exhibitors | Las Vegas Market"));
		
		//Click on Exhibit tab
		exh.getExhibitTab().click();
		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
				
		//Click on 'Exhibitor Registration' link
		exh.getExhibitorRegtnMenu().click();
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		Thread.sleep(6000);
		//Verify that 'LVM Registration' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Market Summer 2021 - Inquiry Request"));
		
		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
		//Click on Exhibitor Portal Login' sub-menu
		exh.getExhibitorPortalLoginMenu().click();
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		Thread.sleep(15000);
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Sign In to IMC"));
		
		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
				
		//Click on Juniper sub-menu
		exh.getJuniperMenu().click();
		
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		Thread.sleep(6000);
		//Verify that 'Juniper' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Experience the Future of B2B Wholesale Commerce | JuniperCommerce"));

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
		//Click on Exhibit tab
		exh.getExhibitTab().click();
	}
	
/*	@AfterSuite
	public void sendEmail()
	{
		se = new SendEmail();
		se.sendEmailWithAttachment();
	}*/
	
}
