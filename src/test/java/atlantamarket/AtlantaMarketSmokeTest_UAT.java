package atlantamarket;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AtlantaMarket.ATLExhibitorDirectoryPage;
import pageObjects.AtlantaMarket.ATLExhibitorsAndProductsTabPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLMarketInfoPage;
import pageObjects.AtlantaMarket.ATLProfileAndSettingsPage;
import pageObjects.AtlantaMarket.ATLRegistrationsPage;
import pageObjects.LasVegasMarket.UXPLandingPage;
import pageObjects.LasVegasMarket.UXPLoginPage;
import pageObjects.LasVegasMarket.UXPMarketInfoPage;
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
	ATLGlobalSearchPage atlgs;
	ATLExhibitorsAndProductsTabPage atlexhp;
	ATLExhibitorDirectoryPage atled;
	ATLRegistrationsPage atlregp;
	ATLMarketInfoPage atlmi;
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
		Thread.sleep(6000);
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
	@Test(priority=03)
	public void TS003_VerifyGlobalSearchFunctionalityTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T003: To verify global search functionality

		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();
		String searchterm = atlgs.getATLVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput")));
		System.out.println("Global Search functionality is working properly.");
	}
	
	@Test(priority=04)
	public void TS004_VerifyMarketPlannerRegistrationsOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-005: To verify Registrations option in Top Header

		lap = new UXPLandingPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);
		atlregp = new ATLRegistrationsPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Welcome text
		atlps.getATLWelcomeText().click();
		
		//Click Registrations option in Top Header
		atlregp.getATLRegistrationsOptn().click();
		
		//Verify that user should redirect to the 'Registration Info' page.
		Assert.assertTrue(atlregp.getATLRegistrationsInfoTab().isDisplayed());
	}

	@Test(priority=5)
	public void TS005_VerifyExhibitorDirectoryTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T004: To verify Exhibitor Directory

		atlgs = new ATLGlobalSearchPage(driver);
		atled = new ATLExhibitorDirectoryPage(driver);
		atlexhp = new ATLExhibitorsAndProductsTabPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Verify exhibitor data is displayed or not as per search criteria

		atled.getATLExhibitorDirectory().click();
		Assert.assertEquals(atlexhp.getVerifyExhibitorDirectory().getText(), "Exhibitor Directory");
		System.out.println("Exhibitor Directory is opened properly.");
		
		atled.getATLExhDirtSearchBox().sendKeys((prop.getProperty("exhibitordirectory")));
		atled.getATLExhDirtSearchBtn().click();
		String searchterm = atlgs.getATLVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("exhibitordirectory")));
		System.out.println("Exhibitor Directory page is working properly.");
	}
	
	@Test(priority=06)
	public void TS006_VerifyAllLinksUnderMarketInfoTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T006: To verify links for Market info tab at Header

		atlmi = new ATLMarketInfoPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click Market Info tab at Header
		atlmi.getATLMarketInfoHeader().click();
		
		//Click on About sub-menu
		atlmi.getATLAboutSubMenu().click();
		
		//Verify that About Us page should be displayed
		Assert.assertTrue(atlmi.getATLAboutUsPageHeader().isDisplayed());
		
		//Click Market Info tab at Header
		atlmi.getATLMarketInfoHeader().click();
				
		//Click on Dates & Hours sub-menu
		atlmi.getATLDatesAndHrsSubMenu().click();
		
		//Verify that Dates & Hours page should be displayed
		Assert.assertTrue(atlmi.getATLMrketDatesHrsPageHeader().isDisplayed());
		
		//Click Market Info tab at Header
		atlmi.getATLMarketInfoHeader().click();
		
		//Click on Registration sub-menu
		atlmi.getATLRegistrationsSubMenu().click();
		
		//Verify that Registration  page should be displayed
		Assert.assertTrue(atlmi.getATLRegstnPageHeader().isDisplayed());
		
		//Click Market Info tab at Header
		atlmi.getATLMarketInfoHeader().click();
		
		//Click on Press Center sub-menu
		atlmi.getATLPressCenterSubMenu().click();
		
		//Verify that Press Releases page should be displayed
		Assert.assertTrue(atlmi.getATLPressCenterPageHeader().isDisplayed());
		
		//Click Market Info tab at Header
		atlmi.getATLMarketInfoHeader().click();
		
		//Click on Atlanta Next sub-menu
		atlmi.getAtlantaNextSubMenu().click();
		
		//Verify that Atlanta Next page should be displayed
		Assert.assertTrue(atlmi.getATLAtlantaNextPageHeader().isDisplayed());
		
		//Click Market Info tab at Header
		atlmi.getATLMarketInfoHeader().click();
		
		//Click on Video Gallery sub-menu
		atlmi.getATLVideoGallerySubMenu().click();
		
		//Verify that Video Gallery page should be displayed
		Assert.assertTrue(atlmi.getATLVideoGalleryPageHeader().isDisplayed());
		
		//Click Market Info tab at Header
		atlmi.getATLMarketInfoHeader().click();
		
		//Click on Industry Partners sub-menu
		atlmi.getATLIndustryPartSubMenu().click();
		
		//Verify that Video Gallery page should be displayed
		Assert.assertTrue(atlmi.getATLIndusPartPageHeader().isDisplayed());		
	}
	
	/*@AfterSuite
	public void sendEmail()
	{
		se = new SendEmail();
		se.sendEmailWithAttachment();
	}*/

}



