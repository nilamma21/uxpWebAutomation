package PROD;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AtlantaApparel.ATLAppFooterLinksNavigationPage;
import pageObjects.AtlantaMarket.ATLAllChannelsLinksPage;
import pageObjects.AtlantaMarket.ATLAttendPage;
import pageObjects.AtlantaMarket.ATLExhibitPage;
import pageObjects.AtlantaMarket.ATLExhibitorDirectoryPage;
import pageObjects.AtlantaMarket.ATLExhibitorsAndProductsTabPage;
import pageObjects.AtlantaMarket.ATLFooterLinksNavigationPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLMarketInfoPage;
import pageObjects.AtlantaMarket.ATLNewsAndTrendsTabPage;
import pageObjects.AtlantaMarket.ATLProfileAndSettingsPage;
import pageObjects.AtlantaMarket.ATLRegistrationsPage;
import pageObjects.LasVegasMarket.UXPAttendPage;
import pageObjects.LasVegasMarket.UXPExhibitPage;
import pageObjects.LasVegasMarket.UXPExhibitorsAndProductsTabPage;
import pageObjects.LasVegasMarket.UXPFooterLinksNavigationPage;
import pageObjects.LasVegasMarket.UXPHeaderChannelLinksPage;
import pageObjects.LasVegasMarket.UXPLandingPage;
import pageObjects.LasVegasMarket.UXPLoginPage;
import pageObjects.LasVegasMarket.UXPMarketInfoPage;
import resources.GenerateData;
import resources.SendEmail;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class AtlantaMarketSmokeTest_PROD extends base {
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
	ATLExhibitPage atlexh;
	ATLAllChannelsLinksPage atlch;
	ATLFooterLinksNavigationPage atlfl;
	UXPExhibitorsAndProductsTabPage exhp;
	UXPMarketInfoPage mi;
	UXPFooterLinksNavigationPage fl;
	ATLAppFooterLinksNavigationPage atlfo;
	ATLAttendPage atat;
	ATLNewsAndTrendsTabPage atlnt;
	SendEmail se;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);

		//Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(5000);
		lap.getIUnderstandBtn().click();
		Thread.sleep(3000);
		utl.verifyCloseBtnPopup();
	}
	//Due to re-branding changes
	@Test(enabled=false)//priority=1
	public void TS001_ATL_VerifyMarketPlannerLoginTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-001: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Login to Market Planner
		utl.verifyMPLoginFunctionality();
		
		//Verify that Market Planner Home page should be displayed
		Assert.assertTrue(lap.getMPLinkText().isDisplayed());
		//Thread.sleep(6000);
		utl.verifyCloseBtnPopup();
	}
	//Due to re-branding changes
	@Test(enabled=false)//priority=2
	public void TS002_ATL_VerifyMarketPlannerProfileAndSettingsOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-002: To verify Profile and Settings option in Market Planner

		lap = new UXPLandingPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click Profile and Settings tab under Market Planner and verify result
		//Thread.sleep(5000);
		atlps.getATLWelcomeText().click();

		atlps.getATLProfileAndSettings().click();
		//Thread.sleep(6000);
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl")+"Profile"));
		System.out.println("Profile and Settings section options are displayed properly");
	}
	@Test(priority=3)
	public void TS003_ATL_VerifyGlobalSearchFunctionalityTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T003: To verify global search functionality

		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(10000);
		String searchterm = atlgs.getATLVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput")));
		System.out.println("Global Search functionality is working properly.");
	}
	//Due to re-branding changes
	@Test(enabled=false)//priority=4
	public void TS004_ATL_VerifyMarketPlannerRegistrationsOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-004: To verify Registrations option in Top Header

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

		//Sign out from Market Planner
		atlps.getATLWelcomeText().click();
		lap.getMPSignOutBtn().click();
		//Thread.sleep(10000);
		utl.verifyCloseBtnPopup();
	}

	@Test(priority=5)
	public void TS005_ATL_VerifyExhibitorDirectoryTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T005: To verify Exhibitor Directory

		atlgs = new ATLGlobalSearchPage(driver);
		atled = new ATLExhibitorDirectoryPage(driver);
		atlexhp = new ATLExhibitorsAndProductsTabPage(driver);

		driver.get(prop.getProperty("atlmrkturl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Verify exhibitor data is displayed or not as per search criteria

		atled.getATLExhibitorDirectory().click();
		Assert.assertEquals(atlexhp.getATLVerifyExhibitorDirectory().getText(), "Exhibitor Directory");
		System.out.println("Exhibitor Directory is opened properly.");

		atled.getATLExhDirtSearchBox().sendKeys((prop.getProperty("exhibitordirectory")));
		atled.getATLExhDirtSearchBtn().click();
		//Thread.sleep(1000);
		String searchterm = atlgs.getATLVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("exhibitordirectory")));
		System.out.println("Exhibitor Directory page is working properly.");
	}

	@Test(priority=6)
	public void TS006_ATL_VerifyAllLinksUnderMarketInfoTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T006: To verify links for Market info tab at Header

		atlmi = new ATLMarketInfoPage(driver);
		driver.get(prop.getProperty("atlmrkturl"));
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

		//Due to re-branding changes
/*		//Click Market Info tab at Header
		atlmi.getATLMarketInfoHeader().click();

		//Click on Atlanta Next sub-menu
		atlmi.getAtlantaNextSubMenu().click();

		//Verify that Atlanta Next page should be displayed
		Assert.assertTrue(atlmi.getATLAtlantaNextPageHeader().isDisplayed());
*/

		//Click Market Info tab at Header
		atlmi.getATLMarketInfoHeader().click();

		//Click on Video Gallery sub-menu
		atlmi.getATLVideoGallerySubMenu().click();

		//Verify that Video Gallery page should be displayed
		Assert.assertTrue(atlmi.getATLVideoGalleryPageHeader().isDisplayed());
		
		//Due to re-branding changes
/*		//Click Market Info tab at Header
		atlmi.getATLMarketInfoHeader().click();

		//Click on Industry Partners sub-menu
		atlmi.getATLIndustryPartSubMenu().click();

		//Verify that Video Gallery page should be displayed
		Assert.assertTrue(atlmi.getATLIndusPartPageHeader().isDisplayed());	
*/	
	}

	@Test(priority=7)
	public void TS007_ATL_VerifyAllLinksUnderExhibitorsAndProductsTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-007: To verify the Exhibitors & Products menu overview and it's functionality

		atlexhp = new ATLExhibitorsAndProductsTabPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click ExhibitorsAndProductsTab at Header
		atlexhp.getATLExhibitorsAndProducts().click();
		Assert.assertTrue(atlexhp.getATLVerifyExhibitorsAndProductsSection().isDisplayed());
		System.out.println("Exhibitors and Products section options are displayed properly");

		//Click Exhibitor Directory option under Exhibitors and Products
		atlexhp.getATLExhibitorDirectory().click();
		Thread.sleep(5000);
		Assert.assertEquals(atlexhp.getATLVerifyExhibitorDirectory().getText(), "Exhibitor Directory");
		System.out.println("Exhibitory Directory section is displayed properly");

		//Click Floor Plans option under Exhibitors and Products
		atlexhp.getATLExhibitorsAndProducts().click();
		atlexhp.getATLFloorPlans().click();
		Assert.assertTrue(atlexhp.getATLVerifyFloorPlans().isDisplayed());
		System.out.println("Floor Plans section is displayed properly");

		//Click Show Specials option
		atlexhp.getATLExhibitorsAndProducts().click();
		atlexhp.getATLShowSpecialsPROD().click();
		Assert.assertEquals(atlexhp.getATLVerifyExhibitorDirectory().getText(), "Show Specials");

		//Click Temporaries option under Exhibitors and Products
		atlexhp.getATLExhibitorsAndProducts().click();
		atlexhp.getATLTemporaries().click();
		Assert.assertEquals(atlexhp.getATLTemporaries().getText(), "Temporaries");
		System.out.println("Temporaries section is displayed properly");

		//Click Categories option under Exhibitors and Products
		atlexhp.getATLExhibitorsAndProducts().click();
		atlexhp.getATLCategories().click();
		Assert.assertEquals(atlexhp.getATLCategories().getText(), "Categories");
		System.out.println("Categories section is displayed properly");

		//Click on Juniper sub-menu
		/*atlexhp.getATLExhibitorsAndProducts().click();
		atlexhp.getATLJunpiperMrktUAT().click();
		Thread.sleep(6000);
		String winHandleBefore8 = driver.getWindowHandle();
		for (String winHandle8 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle8);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.junipermarket.com"));
		driver.switchTo().window(winHandleBefore8);
		driver.get(prop.getProperty("atlmrkturl"));
		utl.verifyCloseBtnPopup();
		//Thread.sleep(6000);*/
	}

	@Test(priority=13)
	public void TS008_ATL_VerifAllLinksUnderExhibitTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-008: To verify the Exhibit menu overview and it's functionality

		lap = new UXPLandingPage(driver);
		atlexh = new ATLExhibitPage(driver);
		
		driver.get(prop.getProperty("atlmrkturl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);					

		Thread.sleep(2000);
		
		//Click on Exhibit tab
		atlexh.getATLExhibitTab().click();
		//Click on Exhibit at Atlanta Market sub-menu
		atlexh.getATLExhibitAtAtlanta().click();
		Thread.sleep(2000);
		//Verify that Exhibit page should be displayed
		Assert.assertTrue(atlexh.getATLExhibitBrdcrumb().isDisplayed());

		//Click on Exhibit tab
		atlexh.getATLExhibitTab().click();
		//Click on 'Why Exhibit?' sub-menu
		atlexh.getATLWhyExhibitMenu().click();
		Thread.sleep(2000);
		//Verify that 'Exhibit' page should be displayed
		Assert.assertTrue(atlexh.getATLExhibitBrdcrumb().isDisplayed());

		//Click on Exhibit tab
		atlexh.getATLExhibitTab().click();
		//Click on 'Apply to Exhibit' sub-menu
		atlexh.getATLApplyToExhibit().click();
		Thread.sleep(2000);
		//Verify that 'Apply to exhibit' page should be displayed
		Assert.assertEquals(atlexh.getATLApplyToExhibitBrdcrmb().getText(), "Apply to Exhibit");

		//Click on Exhibit tab
		atlexh.getATLExhibitTab().click();
		//Click on 'Exhibitor Registration' link
		atlexh.getATLExhibitorRegtnMenu().click();
		Thread.sleep(2000);
		//Verify that Exhibitor Registration page should be displayed
		Assert.assertTrue(atlexh.getATLExhRegstnBrdcrmb().getText().contains("Exhibitor Registration"));

		//Click on Exhibit tab
		atlexh.getATLExhibitTab().click();
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		//Click on Exhibitor Portal Login' sub-menu
		atlexh.getATLExhibitorPortalLoginMenu().click();
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(atlexh.getATLEXPLoginPageTitle().isDisplayed());
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		//Click on Exhibitor Resources sub-menu
		atlexh.getATLExhibitorResources().click();
		//Verify that Exhibitor Resources page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Exhibitor Resources"));

		/*//Click on Exhibit tab
		atlexh.getATLExhibitTab().click();

		//Click on Juniper Commerce sub-menu
		// Juniper menu is removed from design
		atlexh.getATLJuniperMenu().click();

		Thread.sleep(6000);
		//Verify that 'Juniper' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.junipercommerce.com/"));
*/
		
	}

	@Test(priority=9)
	public void TS009_ATL_VerifyAllChannelsLinksTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-TS009: To verify all channels links in Header

		atlch = new ATLAllChannelsLinksPage(driver);
		
		driver.get(prop.getProperty("atlmrkturl"));
		utl.verifyCloseBtnPopup();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);

		//Click Atlanta Market channel link and verify result
		atlch.getAtlantaMarket().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Market at AmericasMart"));
		System.out.println("Atlanta Market channel link is working properly.");
		driver.get(prop.getProperty("atlmrkturl"));
		utl.verifyCloseBtnPopup();

		//Click Atlanta Apparel channel link and verify result
		atlch.getAtlantaApparel().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Apparel at AmericasMart"));
		System.out.println("Atlanta Apparel channel link is working properly.");
		driver.get(prop.getProperty("atlmrkturl"));
		utl.verifyCloseBtnPopup();

		//Click Americas Mart channel link and verify result
		atlch.getAmericasMart().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Wholesale Gift, Home, Rug and Apparel Markets"));
		System.out.println("Americas Mart channel link is working properly.");
		driver.get(prop.getProperty("atlmrkturl"));
		utl.verifyCloseBtnPopup();

		//Click IMC High Point Market channel link and verify result
		atlch.getHighPoint().click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmorehighpointmarket.com/"));
		System.out.println("High Point Market channel link is working properly.");
		driver.get(prop.getProperty("atlmrkturl"));
		utl.verifyCloseBtnPopup();

		//Click Las Vegas Market channel link and verify result
		atlch.getLasVegas().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas"));
		System.out.println("Las Vegas Market channel link is working properly.");
		driver.get(prop.getProperty("atlmrkturl"));
		utl.verifyCloseBtnPopup();

		//Click Las Vegas Market channel link and verify result
		atlch.getLasVegasApp().click();
		Thread.sleep(6000);
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Apparel"));
		System.out.println("Las Vegas Apparel channel link is working properly.");
		
	}

	@Test(priority=10)
	public void TS010_ATL_VerifyAllSocialMediaLinksOnFooterTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T010: To verify the all social media links and it's redirection

		atlfl = new ATLFooterLinksNavigationPage(driver);
		fl = new UXPFooterLinksNavigationPage(driver);
		driver.get(prop.getProperty("atlmrkturl"));
		utl.verifyCloseBtnPopup();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Scroll till footer links
		utl.scrollToElement(fl.getmarketInfo());

		//In app footer click on 'Facebook' icon and verify results
		atlfl.getFacebookIcon().click();

		Thread.sleep(8000);
		//Verify that 'ATL Facebook' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/AmericasmartAtl"));

		driver.get(prop.getProperty("atlmrkturl"));
		utl.verifyCloseBtnPopup();

				//Click on Instagram icon
	/*	fl.getInstagramiconATLM().click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		//Verify that 'ATL Instagram' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.instagram.com/americasmartatl/"));

		driver.get(prop.getProperty("atlmrkturl"));
		 

		//Click on You Tube icon
		atlfl.getYouTubeIcon().click();

		Thread.sleep(10000);
		//Verify that 'ATL You Tube' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com"));

		driver.get(prop.getProperty("atlmrkturl"));

		//Click on Twitter icon
		fl.gettwittericonATLM().click();

		Thread.sleep(10000);
		//Verify that 'ATL Twitter' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.twitter.com/americasmartatl")); 
		driver.get(prop.getProperty("atlmrkturl"));*/
		 
	}

	@Test(priority= 14)
	public void TS011_ATL_VerifyFooterLinksTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T69: To verify Footer Links Navigation
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		fl = new UXPFooterLinksNavigationPage(driver);
		atlfo=new ATLAppFooterLinksNavigationPage(driver);
		utl=new Utility(driver);
		
		driver.get(prop.getProperty("atlmrkturl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Scroll till footer links
		utl.scrollToElement(fl.getmarketInfo());

		//Click Market Info link and verify results
		fl.getmarketInfo().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/market-info"));
		driver.get(prop.getProperty("atlmrkturl"));
		//utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());
		
		//Click on Press Center
		fl.getpressCenter().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/Market-Info/Press-Center"));
		driver.get(prop.getProperty("atlmrkturl"));
		//utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());
		
		// Click Download The App link and verify results
		fl.getDownloadTheApp().click();
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "App");
		driver.get(prop.getProperty("atlmrkturl"));
		//utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());
		
		//Click on Our Brands link
		fl.getOurBrandsATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/exhibitor/directory"));
		driver.get(prop.getProperty("atlmrkturl"));
		//utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());
		
		// Click Contact Us link and verify results
		
		String winHandleBefore5 = driver.getWindowHandle();
		fl.getContactUsATL().click();
		for (String winHandle5 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle5);
		}
		Assert.assertEquals(mi.getverifyContactUsATL().getText(), "Contact Us");
		driver.close();
		driver.switchTo().window(winHandleBefore5);
		//utl.scrollToElement(fl.getmarketInfo());
		
		// Click Careers link and verify results
		
		String winHandleBefore6 = driver.getWindowHandle();
		fl.getCareersATL().click();
		for (String winHandle6 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle6);
		}
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Careers");
		driver.close();
		driver.switchTo().window(winHandleBefore6);
		//utl.scrollToElement(fl.getmarketInfo());
		
		// Click on Terms & condition link
		
		// Switch to new tab
		String winHandleBefore7 = driver.getWindowHandle();
		fl.getTermsAndConditions().click();
		for (String winHandle7 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle7);
		}
		 //Due to re-Branding changes
		//Assert.assertEquals(fl.getVerifyTermsOfUse().getText(), "TERMS OF USE");
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore7);

		// Click Privacy Policy and verify results
		//driver.get(prop.getProperty("atlmrkturl"));
		//utl.verifyCloseBtnPopup();
		//utl.scrollToElement(fl.getmarketInfo());
		// Click Privacy Policy link and verify results
		
		String winHandleBefore8 = driver.getWindowHandle();
		fl.getatlprivacypolicy().click();
		for (String winHandle8 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle8);
		}
		//Assert.assertEquals(fl.getVerifyTermsOfUse().getText(), "IMC PRIVACY STATEMENT");
		Assert.assertTrue(driver.getCurrentUrl().contains("privacy-policy"));
		driver.close();
		driver.switchTo().window(winHandleBefore8);
		// utl.scrollToElement(fl.getmarketInfo());
		//driver.get(prop.getProperty("atlmrkturl"));
		//utl.verifyCloseBtnPopup();
		//utl.scrollToElement(fl.getmarketInfo());
		
		// Click Americas Mart link and verify results
		
		String winHandleBefore9 = driver.getWindowHandle();
		fl.getAmericasMart_ATLAppFooter().click();
		for (String winHandle9 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle9);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore9);
		/*driver.get(prop.getProperty("atlmrkturl"));
		//utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());
		Thread.sleep(5000);*/
		// Click Atlanta Apparel link and verify results
		
		// Switch to new tab
		String winHandleBefore2 = driver.getWindowHandle();
		fl.getAtlantaApparel().click();
		for (String winHandle2 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle2);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore2);
		/*driver.get(prop.getProperty("atlmrkturl"));
		utl.scrollToElement(fl.getmarketInfo());*/
		
		// Click on High Point Market link
		// Switch to new tab
		
		String winHandleBefore4 = driver.getWindowHandle();
		fl.getHighPointMarket().click();
		for (String winHandle4 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle4);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmorehighpointmarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore4);
		//utl.scrollToElement(fl.getmarketInfo());
		
		// Click on LVA Market link
		// Switch to new tab
		
		Thread.sleep(3000);
		String winHandleBefore11 = driver.getWindowHandle();
		fl.getlvmlink_ATL_Footerr().click();
		for (String winHandle4 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle4);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore11);
		// Click on LVM Market link
		// Switch to new tab
		String winHandleBefore12 = driver.getWindowHandle();
		fl.getlvmlink_ATL().click();
		for (String winHandle11 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle11);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore12);
		//utl.scrollToElement(fl.getmarketInfo());		
		
		//Due to re-branding changes
/*		//Click International Market Centers link and verify results
		fl.getInternationalMarketCenters().click();
		//Switch to new tab
		String winHandleBefore3 = driver.getWindowHandle();
		for(String winHandle3 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle3);}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imcenters.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore3);
		utl.scrollToElement(fl.getmarketInfo());		
		
		//Click Juniper Market Centers link and verify results
		fl.getJuniperMarket().click();
		//Switch to new tab
		String winHandleBefore12 = driver.getWindowHandle();
		for(String winHandle12 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle12);}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.junipermarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore12);
		utl.scrollToElement(fl.getmarketInfo());	
*/
		//Changes due to re-branding |  | New addeds
		//Click ANDMORE link and verify results
		
		//Switch to new tab
		String winHandleBefore3 = driver.getWindowHandle();
		fl.getandmore().click();
		for(String winHandle3 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle3);}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore3);
				
	}

	@Test(priority=12)
	public void TS012_ATL_VerifyAllLinksUnderAttendTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T012: To verify links for Attend tab at Header

		mi = new UXPMarketInfoPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		atat = new ATLAttendPage(driver);
		
		driver.get(prop.getProperty("atlmrkturl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click Attend tab at Header
		atat.getATLAttendTab().click();

		//Click Why Attend tab under Attend section
		atat.getATLWhyAttend().click();
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Why Attend?");
		System.out.println("Why Attend section is displayed properly");
		Thread.sleep(2000);
		atat.getATLAttendTab().click();
		
		//Click Registration tab under Attend section
		atat.getATLRegistration().click();
		Thread.sleep(2000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Registration");
		System.out.println("Registration section is displayed properly");
		Thread.sleep(2000);
		atat.getATLAttendTab().click();

		//Click Admission Policies under Attend section
		atat.getATLAdmissionPolicies().click();
		Thread.sleep(2000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Admission Policies");
		System.out.println("Admission Policies section is displayed properly");
		Thread.sleep(2000);
		atat.getATLAttendTab().click();

		//Click Download the App under Attend section
		atat.getATLDownloadApp().click();
		Thread.sleep(2000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "App");
		System.out.println("Download the App section is displayed properly");
		Thread.sleep(2000);
		atat.getATLAttendTab().click();

		//Click Travel under Attend section
		atat.getATLTravel().click();
		Thread.sleep(2000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Hotels & Travel");
		System.out.println("Travel section is displayed properly");
		Thread.sleep(2000);
		atat.getATLAttendTab().click();

		//Click Dining Guide under Attend section
		atat.getATLDiningGuide().click();
		Thread.sleep(2000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Dining Guide");
		System.out.println("Dining Guide section is displayed properly");
		Thread.sleep(2000);
		atat.getATLAttendTab().click();

		//Click on Events under Attend section
		atat.getATLEventsSubmenu().click();
		Thread.sleep(2000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Events");
		Thread.sleep(2000);
		atat.getATLAttendTab().click();

		//Click Services and Amenities under Attend section
		atat.getATLServicesAndAmenities().click();
		Thread.sleep(2000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Services & Amenities");
		System.out.println("Services & Amenities section is displayed properly");
		atat.getATLAttendTab().click();

		/*//Click Together Safely under Attend section
		//This logo is removed from design
		atat.getATLTogetherSafely().click();
		Thread.sleep(6000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imcenters.com/"));
		System.out.println("Together Safely section is displayed properly");*/
		driver.get(prop.getProperty("atlmrkturl"));
		//utl.verifyCloseBtnPopup();
	}

	@Test(priority=8)
	public void TS013_ATL_VerifyAllNewsAndTrendsMenuTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T013: To verify the all News & Trends tap Menu and it's redirection

		atlnt = new ATLNewsAndTrendsTabPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("atlmrkturl"));
		utl.verifyCloseBtnPopup();
		//atlnt.getATLNewsAndTrends().click();
Thread.sleep(5000);
		//Click News and Trends tab and verify result
		atlnt.getATLNewsAndTrendsTap().click();
		Assert.assertTrue(atlnt.getVerifyNewsSection().isDisplayed());
		System.out.println("News section is displayed properly.");

		//Click on News And Trends sub-menu and Verify Page
		atlnt.getATLNewsAndTrendsSubmenu().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("News-and-Trends"));

		//Click on News And Trends Tab
		//atlnt.getATLNewsAndTrends().click();
		atlnt.getATLNewsAndTrendsTap().click();
		atlnt.getATLatlMarketSnapshot().click();
		//Click on MarketSnapshot and Verify Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Market-Snapshot"));
		System.out.println("Market Snapshot page");

		//Click on News And Trends Tab
		/*atlnt.getATLNewsAndTrends().click();
		atlnt.getATLWebinarAndEducation().click();
		//Click on Webinar And Education and Verify Page
		Assert.assertTrue(atlnt.getATLWebinarAndEducationPageHeader().getText().contains("Webinars & Education"));
		System.out.println("Webinars & Education page");*/

		//Click on News And Trends Tab
		//atlnt.getATLNewsAndTrends().click();
		atlnt.getATLNewsAndTrendsTap().click();
		atlnt.getATLatlAheadCurve().click();
		//Assert.assertTrue(atlnt.getATLAheadCurvePageHeader().getText().contains("Ahead of the Curve"));
		Assert.assertTrue(driver.getCurrentUrl().contains("Ahead-of-the-Curve"));
		System.out.println("Ahead of the Curve page");

		//Click on News And Trends Tab
		/*atlnt.getATLNewsAndTrends().click();
		atlnt.getATLShopTheShow().click();
		//Click on Shop the and Verify Page
		Assert.assertTrue(atlnt.getATLShopTheShowPageHeader().getText().contains("Shop the "));
		System.out.println("Shop the show page header");*/

		//Click on News And Trends Tab
		//atlnt.getATLNewsAndTrends().click();
		atlnt.getATLNewsAndTrendsTap().click();
		atlnt.getATLPressReleases().click();
		//Click on Press Releases and Verify Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Press-Center"));
		System.out.println("Press Releases page");

		//Click on News And Trends Tab
		//atlnt.getATLNewsAndTrends().click();
		atlnt.getATLNewsAndTrendsTap().click();
		atlnt.getATLPublicationsLibrary().click();
		//Click on Publications Library and Verify Page
		Assert.assertTrue(driver.getCurrentUrl().contains("publications"));
		System.out.println("Publications Library page");

		//Click on News And Trends Tab
		//atlnt.getATLNewsAndTrends().click();
		atlnt.getATLNewsAndTrendsTap().click();
		atlnt.getATLInTheNews().click();
		//Click on In the News and Verify Page
		Assert.assertTrue(driver.getCurrentUrl().contains("In-the-News"));
		System.out.println("In The News page");

		//Click on News And Trends Tap
		/*atlnt.getATLNewsAndTrends().click();
		atlnt.getATLAtlantaNext().click();
		//Click on Atlanta Next and Verify Page
		Assert.assertTrue(atlnt.getATLAtlantaNextHeader().getText().contains("Atlanta Next"));
		System.out.println("In Atlanta Next page");*/
		
		//Due to re-branding changes
/*		//Click on News And Trends Tab
		atlnt.getATLNewsAndTrends().click();
		//Click on Portman Peachtree and Verify Page
		try {
			atlnt.getATLPortmanPeachtree().click();
			Thread.sleep(3000);
			Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Blog");
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
*/		
	}
	
	@Test(enabled=false)//priority=2
	public void TS014_ATL_PlanYourMarkett() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T783: To verify Exhibitor Directory
		lap = new UXPLandingPage(driver);
		
		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Verify Plan your market link is working properly
		lap.getplanYourMarket().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/Attend/App"));
		System.out.println("Plan Your Market page is working properly.");
	}
	
	@Test(priority=2)
	public void TS015_ATL_MarketRecap() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T798: Market Recap page opens successfully.
		lap = new UXPLandingPage(driver);
		
		driver.get(prop.getProperty("atlmrkturl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Verify Market Recap link is working properly
		lap.getMarketRecap().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/Attend/App"));
		System.out.println("Market Recap page is working properly.");
	}


	/*	@AfterSuite
	public void sendEmail()
	{
		se = new SendEmail();
		se.sendEmailWithAttachment();
	}*/

	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}

}