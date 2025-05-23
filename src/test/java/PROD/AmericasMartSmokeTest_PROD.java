package PROD;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.AmericasMart.AMAboutTabPage;
import pageObjects.AmericasMart.AMExhibitTabPage;
import pageObjects.AmericasMart.AMExhibitorDirectoryTab;
import pageObjects.AmericasMart.AMFooterLinksNavigationPage;
import pageObjects.AmericasMart.AMHeaderLinksPage;
import pageObjects.AmericasMart.AMMarketsAndEventsPage;
import pageObjects.AmericasMart.AMMarketsAndEventsTab;
import pageObjects.AmericasMart.AMOpenYearRoundPage;
import pageObjects.AmericasMart.AMVisitTab;
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
import pageObjects.LasVegasMarket.UXPExhibitorDirectoryPage;
import pageObjects.LasVegasMarket.UXPExhibitorsAndProductsTabPage;
import pageObjects.LasVegasMarket.UXPExploreMarketPage;
import pageObjects.LasVegasMarket.UXPFooterLinksNavigationPage;
import pageObjects.LasVegasMarket.UXPGlobalSearchPage;
import pageObjects.LasVegasMarket.UXPHeaderChannelLinksPage;
import pageObjects.LasVegasMarket.UXPLandingPage;
import pageObjects.LasVegasMarket.UXPLoginPage;
import pageObjects.LasVegasMarket.UXPMarketInfoPage;
import resources.GenerateData;
import resources.SendEmail;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class AmericasMartSmokeTest_PROD extends base {
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
	ATLAttendPage atat;
	ATLNewsAndTrendsTabPage atlnt;
	AMHeaderLinksPage amhe;
	UXPExhibitorDirectoryPage ed;
	UXPGlobalSearchPage gs;
	AMFooterLinksNavigationPage amfl;
	AMAboutTabPage amab;
	UXPHeaderChannelLinksPage hd;
	UXPExploreMarketPage expmrkt;
	AMMarketsAndEventsPage amme;
	AMExhibitTabPage amexh;
	AMOpenYearRoundPage amoyr;
	SendEmail se;
	AMExhibitorDirectoryTab edt;
	AMMarketsAndEventsTab met;
	AMVisitTab vt;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);

		//Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(5000);
		lap.getIUnderstandBtn().click();
		utl.waitForPageToLoad();
		Thread.sleep(8000);
		//utl.verifyCloseBtnPopup();
	}


	@Test(priority=1)
	public void TS001_AMC_VerifyAllHeaderChanelLinksTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		hd = new UXPHeaderChannelLinksPage(driver);
		atlch = new ATLAllChannelsLinksPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.verifyCloseBtnPopup();
		utl.waitForPageToLoad();

	//Verify that Atlanta link is present
		Assert.assertTrue(hd.getAtlanta().getText().equalsIgnoreCase("ATLANTA"));
		
		//Check Atlanta Apparel
		hd.getAtlanta().click();
		utl.windowHandle(hd.getAtlantaApparel(), "https://www.atlanta-apparel.com/");
		
		// Check Casual Market Atlanta
		hd.getAtlanta().click();
		utl.windowHandle(hd.getCasualMarketAtlantaURL(), "https://casualmarketatlanta.com/");

		// Check Atlanta Market
		hd.getAtlanta().click();
		utl.windowHandle(hd.getAtlantaMarket(), "https://www.atlantamarket.com/");
		
		// Spring/Fall Cash and Carry
		hd.getAtlanta().click();
		try {
		utl.windowHandle(hd.getSpringCashAndCarry(), "Spring-Cash-and-Carry");
		
		}catch (Exception e) {
			utl.windowHandle(hd.getFllCashAndCarryMarketsSpringandFall(), "Fall-Cash-and-Carry");
		}
		
		//Check ADAC
		hd.getAtlanta().click();
		utl.windowHandle(hd.getADAC(), "https://adacatlanta.com/");
		
		//Check AmericasMart
		hd.getAtlanta().click();
		utl.windowHandle(hd.getAmericasMart(), "https://www.americasmart.com/");
		
		//Check Atlanta Convention Center
		hd.getAtlanta().click();
		utl.windowHandle(hd.getAtlantaConventionCenter(), "https://www.atlconventioncenter.com/");
		
	//Verify that Las Vegas link is present
		Assert.assertTrue(hd.getLasVegas().getText().equalsIgnoreCase("LAS VEGAS"));
		
		//Check Las Vegas Market
		hd.getLasVegas().click();
		utl.windowHandle(hd.getLasVegasMarket(), "https://www.lasvegasmarket.com/");

		//Check Las Vegas Apparel
		hd.getLasVegas().click();
		utl.windowHandle(hd.getLasVegasApparel(), "https://www.lasvegas-apparel.com/");
		
		//Check Las Vegas Design Center (LVDC)
		hd.getLasVegas().click();
		utl.windowHandle(hd.getLasVegasDesignCenter(), "https://www.lasvegasmarket.com/Year-Round/LVDC");
		
		//Check EXPO at World Market Center Las Vegas
		hd.getLasVegas().click();
		utl.windowHandle(hd.getEXPOatWorldMarketCenterLasVegas(), "https://www.expowmclv.com/");
		
	//Verify that High Point link is present
		Assert.assertTrue(hd.getHighPoint().getText().equalsIgnoreCase("HIGH POINT"));
		
		//Check ANDMORE at High Point Market
		hd.getHighPoint().click();
		utl.windowHandle(hd.getANDMOREatHighPointMarket(), "https://www.andmorehighpointmarket.com/");
		
	//Verify that New York link is present
		Assert.assertTrue(hd.getNewYork().getText().equalsIgnoreCase("NEW YORK"));
		
		//Check SHOPPE OBJECT
		hd.getNewYork().click();
		utl.windowHandle(hd.getSHOPPEOBJECT(), "https://shoppeobject.com/");
	}
	
	
	@Test(priority=2)
	public void TS002_AMC_VerifyGlobalSearchFunctionalityTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T63: To verify global search functionality
		
		gs = new UXPGlobalSearchPage(driver);
		driver.get(prop.getProperty("ammarturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		
		try {
			gs.getGlobalSearchEnterText().isDisplayed();
			gs.getGlobalSearchEnterText().sendKeys((prop.getProperty("globalsearchinput2")));
			Thread.sleep(1000);
			gs.getSearchButtonNew().click();
			Thread.sleep(5000);
			String searchterm = gs.getVerifyGlobalSeacrhNew().getText();
			Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput2")));
			System.out.println("Global Search functionality is working properly.");
		} catch (Exception e) {
			gs.getGlobalSearchTextBoxNew().click();
			gs.getGlobalSearchEnterText().sendKeys((prop.getProperty("globalsearchinput2")));
			Thread.sleep(1000);
			gs.getSearchButtonNew().click();
			Thread.sleep(5000);
			String searchterm = gs.getVerifyGlobalSeacrhNew().getText();
			System.out.println(searchterm);
			Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput2")));
			System.out.println("Global Search functionality is working properly.");
		}
		
	}
	
	@Test(priority=3)
	public void TS003_AMC_VerifyExhibitorDirectoryTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T121: To verify Exhibitor Directory
		edt = new AMExhibitorDirectoryTab(driver);

		driver.get(prop.getProperty("ammarturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(8000);
		
	//Search Exhibitor
		edt.getEDExhibitorDirectoryTab().click();
		Thread.sleep(500);
		//Click Search Exhibitor option under Exhibitor Directory tab
		edt.getEDSearchExhibitor().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("exhibitor-directory"));
		System.out.println("Search Exhibitor section is displayed properly");
		
	//A-Z Brand Listing
		edt.getEDExhibitorDirectoryTab().click();
		Thread.sleep(500);
		//Click A-Z Brand Listing option under Exhibitor Directory tab
		edt.getEDAZBrandListing().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Directory"));
		System.out.println("A-Z Brand Listing section is displayed properly");
		
	//Floor Plans
		edt.getEDExhibitorDirectoryTab().click();
		Thread.sleep(500);
		//Click Floor Plans option under Exhibitor Directory tab
		edt.getEDFloorPlans().click();
		Thread.sleep(4000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Market-Map"));
		System.out.println("Floor Plans section is displayed properly");
		
	//Categories
		edt.getEDExhibitorDirectoryTab().click();
		Thread.sleep(500);
		//Click Categories option under Exhibitor Directory tab
		edt.getEDCategories().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Categories"));
		System.out.println("Categories section is displayed properly");
		
	}
	
	@Test(priority=4)
	public void TS004_AMC_VerifyMarketsAndEventsTab() throws InterruptedException, IOException
	{
	//Markets and Events
		met = new AMMarketsAndEventsTab(driver);
		driver.get(prop.getProperty("ammarturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		
	//Market Dates And Hours
		met.getamcExhibitTab().click();
		Thread.sleep(500);
		//Click Market Dates And Hours link
		met.getamcMarketDatesAndEvents().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Market-Dates-and-Hours"));
		System.out.println("Market Dates And Hours is working properly");
		
	//Shop Year Round
		met.getamcExhibitTab().click();
		Thread.sleep(500);
		//Click Shop Year Round link
		met.getamcVisit().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Year-Round"));
		System.out.println("Shop Year Round is working properly");
	}
	
	@Test(priority=5)
	public void TS005_AMC_VerifyVisitTab() throws InterruptedException, IOException
	{
	//Visit
		vt = new AMVisitTab(driver);
		driver.get(prop.getProperty("ammarturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		
	//Search Exhibitor
		vt.getamcMarketsAndEventsTab().click();
		Thread.sleep(500);
		//Click Search Exhibitor link
		vt.getamcESearchExhibitor().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("exhibitor-directory"));
		System.out.println("Search Exhibitor is working properly");
		
	//A-Z Brand Listing
		vt.getamcMarketsAndEventsTab().click();
		Thread.sleep(500);
		//Click A-Z Brand Listing link
		vt.getamcEAZBrandListing().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Directory"));
		System.out.println("A-Z Brand Listing is working properly");
		
	//Floor Plans
		vt.getamcMarketsAndEventsTab().click();
		Thread.sleep(500);
		//Click Floor Plans link
		vt.getamcEFloorPlans().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Market-Map"));
		System.out.println("Floor Plans is working properly");
		
	//Travel - Link issue
//		vt.getamcMarketsAndEventsTab().click();
//		Thread.sleep(500);
//		//Click Travel link
//		vt.getamcETrave().click();
//		Thread.sleep(3000);
//		Assert.assertTrue(driver.getCurrentUrl().contains("Travel"));
//		System.out.println("Travel is working properly");
	}
	
	@Test(priority=6)
	public void TS006_AMC_VerifyAllLinksUnderExhibitTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T107: To verify the Exhibit tab overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		mi = new UXPMarketInfoPage(driver);
		amab = new AMAboutTabPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		amexh=new AMExhibitTabPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);
		atlexh = new ATLExhibitPage(driver);

		driver.get(prop.getProperty("ammarturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//utl.verifyCloseBtnPopup();
		utl.waitForPageToLoad();
		Thread.sleep(8000);
		
	//Exhibit at Americas Mart
		amexh.getamcExhibitTab().click();
		Thread.sleep(500);
		//Click Exhibit at Americas Mart Link
		amexh.getExhibitAtAmc().click();
		Thread.sleep(3000);
		//Verify that Exhibit at AmC page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("Exhibit"));
		
	//Exhibitor Resources - Link issue
//		amexh.getamcExhibitTab().click();
//		Thread.sleep(500);
//		//Click Exhibitor Resources Link
//		amexh.getamcExhibitorResources().click();
//		Thread.sleep(3000);
//		//Verify that Exhibit at AmC page should be displayed
//		Assert.assertTrue(driver.getCurrentUrl().contains("Exhibitor-Resources"));		
		
	//Already an Exhibitor? - link issue
//		amexh.getamcExhibitTab().click();
//		Thread.sleep(500);
//		String winHandleBefore = driver.getWindowHandle();
//		//Click Already an Exhibitor? Link
//		amexh.getamcAlreadyanExhibitor().click();
//		for(String winHandle : driver.getWindowHandles()){
//			driver.switchTo().window(winHandle);}
//		Thread.sleep(6000);
//		//Verify that Exhibit at AmC page should be displayed
//		Assert.assertTrue(driver.getCurrentUrl().contains("b2clogin.com"));		
//		driver.close();
//		driver.switchTo().window(winHandleBefore);
/*
	//Leasing & Exhibit Options
		amexh.getamcExhibitTab().click();
		Thread.sleep(2000);
		//Click Exhibit and Leasing Options Link
		amexh.getLeasingandExhibitOptions().click();
		Thread.sleep(3000);
		//Verify that leasing and exhibit options page should be displayed
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("ammarturl")+"Exhibit/Opportunities");
		utl.verifyCloseBtnPopup();

	//Advertising
		amexh.getamcExhibitTab().click();
		Thread.sleep(2000);
		//Click Advertising Link
		amexh.getAdvertising().click();
		Thread.sleep(3000);
		//Verify that Advertising page should be displayed
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(),"Advertising");
		
	//Exhibitor Portal Login
		amexh.getamcExhibitTab().click();	
		Thread.sleep(500);
		String winHandleBefore = driver.getWindowHandle();
		amexh.getExpLogin().click();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);}
		Thread.sleep(10000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://prodmvdp.b2clogin.com/"));
		System.out.println("Page opened successfully");
		driver.close();
		driver.switchTo().window(winHandleBefore);

	//Exhibitor Portal Guide
		//amexh.getamcExhibitTab().click();	
		String winHandleBefore1 = driver.getWindowHandle();
		amexh.getExpGuide().click();
		Thread.sleep(2000);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);}
		Assert.assertTrue(driver.getCurrentUrl().contains("support.andmore.com"));
		System.out.println("Page opened successfully");
		driver.close();
		driver.switchTo().window(winHandleBefore1);
		
	//Exhibitor FAQs
		//Click Advertising Link
		amexh.getExpFAQs().click();
		Thread.sleep(3000);
		//Verify that FAQs page should be displayed
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Exhibitor FAQs");
*/		
	}

	
	@Test(priority=7)
	public void TS007_AMC_VerifyAllLinksUnderAboutTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T005: To verify links for Market info tab at Header

		mi = new UXPMarketInfoPage(driver);
		amab = new AMAboutTabPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		
		driver.get(prop.getProperty("ammarturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.verifyCloseBtnPopup();
		Thread.sleep(8000);
		
	//About Americas Mart
		amab.getAboutTab().click();
		Thread.sleep(500);
		//Click About Americas Mart option under About tab
		amab.getAboutAmericasMart().click();
		Thread.sleep(3000);
		Assert.assertEquals(mi.getVerifyContactUs().getText(), "About");
		System.out.println("About Americas Mart section is displayed properly");
		
	//Atlanta Convention Center
		amab.getAboutTab().click();
		Thread.sleep(500);
		String winHandleBefore = driver.getWindowHandle();
		amab.getAtlantaConventionCenter().click();
		Thread.sleep(3000);
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);}
		//Click Atlanta Convention Center option under About tab
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlconventioncenter.com/"));
		System.out.println("Atlanta Convention Center section is displayed properly");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		
/*		
	//Click About tab at Header
		amab.getAboutTab().click();
		Assert.assertTrue(amab.getSecondrynavigation().isDisplayed());
		Thread.sleep(2000);
	
	//Press Center
		amab.getAboutTab().click();
		Thread.sleep(2000);
		//Click Press Center option under About tab
		mi.getMarketDatesAndHrs().click();
		Thread.sleep(4000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Press Releases");
		System.out.println("Press Center section is displayed properly");
		
	//Industry partners
		amab.getAboutTab().click();
		Thread.sleep(2000);
		//Click Industry Partners option under Market Info
		amab.getIndustryPartners().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Industry Partners");
		System.out.println("Industry Partners section is displayed properly");
	
	//History
		amab.getAboutTab().click();
		Thread.sleep(2000);
		//Click History option under About tab
		amab.getHistory().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("History"));
		System.out.println("History section is displayed properly");
		
	//Contact Us
		amab.getAboutTab().click();
		Thread.sleep(2000);
		//Click Contact Us option under Market Info
		amab.getContactUs().click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("ammarturl")+"About/Contact-Us");
		utl.verifyCloseBtnPopup();
		
	//Careers
		amab.getAboutTab().click();
		Thread.sleep(2000);
		//Click Careers option under About tab
		amab.getCareers().click();
		Thread.sleep(4000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Careers");
		System.out.println("Careers section is displayed properly");
*/
		
		//Due to re-branding changes
/*		//Click Atlanta Next option under About tab
		mi.getFAQs().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Atlanta Next");
		System.out.println("Atlanta Next section is displayed properly");
		mi.getMarketInfoHeader().click();
*/
	
	}
	
	@Test(priority=8)
	public void TS008_AMC_VerifyFooterLinksTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T69: To verify Footer Links Navigation

		utl = new Utility(driver);
		mi = new UXPMarketInfoPage(driver);
		fl = new UXPFooterLinksNavigationPage(driver);
		
		driver.get(prop.getProperty("ammarturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		utl.waitForPageToLoad();
		Thread.sleep(8000);
		utl.scrollToBottom();
		
		// Market Information
		utl.windowHandle(fl.getmarketInfo(), "americasmart.com/About");
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Press Center
		utl.windowHandle(fl.getpressCenterAMC(), "/About/Press");
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Download the ANDMORE Markets App 
		utl.windowHandle(fl.getDownloadTheApp(), "Plan-Your-Market");
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Our Brands
		utl.windowHandle(fl.getOurBrandsATL(), "exhibitor-directory");
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Contact Us
		utl.windowHandle(fl.getContactUsATL(), "Contact-Us");
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Careers
		utl.windowHandle(fl.getCareersATL(), "andmore.com/our-team");
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Atlanta Apparel
		utl.windowHandle(fl.getAtlantaApparel(), "atlanta-apparel.com");
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Atlanta Market
		utl.windowHandle(fl.getAtlantaMarket(), "atlantamarket.com");
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Casual Market Atlanta
		utl.windowHandle(fl.getCasualMarketAtlanta(), "casualmarketatlanta.com");
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Las Vegas Apparel
		utl.windowHandle(fl.getlvapplink_ATL(), "lasvegas-apparel.com");
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Las Vegas Market
		utl.windowHandle(fl.getlvmlink_ATL(), "https://www.lasvegasmarket.com/");
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//ANDMORE at High Point Market
		utl.windowHandle(fl.getHighPointMarket(), "andmorehighpointmarket.com");
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//ANDMORE
		utl.windowHandle(fl.getandmore(), "https://www.andmore.com/");
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Terms & Conditions
		utl.windowHandle(fl.getTermsAndConditions(), "terms-of-use");
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Privacy Policy
		utl.windowHandle(fl.getatlprivacypolicy(), "privacy-policy");

	}
	
	@Test(priority=9)
	public void TS009_AMC_VerifyAllSocialMediaLinksOnFooterTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-013: To verify the all social media links and it's redirection

		amfl = new AMFooterLinksNavigationPage(driver);
		utl = new Utility(driver); 
		fl = new UXPFooterLinksNavigationPage(driver);
		
		driver.get(prop.getProperty("ammarturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(8000);
		
		//Scroll till footer links
		utl.scrollToElement(fl.getmarketInfo());
		//Thread.sleep(5000);

		//In app footer click on 'Facebook' icon and verify results
		amfl.getFacebookIcon().click();

		//Verify that 'AMC Facebook' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/AmericasmartAtl"));
		System.out.println("Facebook opened successfully");
		driver.get(prop.getProperty("ammarturl"));
		utl.verifyCloseBtnPopup();

		//In app footer click on 'Twitter' icon and verify results
		/*amfl.getTwitterIcon().click();

		//Verify that 'AMC Twitter' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://twitter.com/americasmartatl"));
		System.out.println("Twitter opened successfully");
		driver.get(prop.getProperty("ammarturl"));


		//Click on Instagram icon
		amfl.getInstagramIcon().click();

		//Verify that 'AMC Instagram' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.instagram.com/americasmartatl/"));
		System.out.println("Instagram opened successfully");
		driver.get(prop.getProperty("ammarturl"));

		Thread.sleep(8000);
		//Click on Youtube icon
		amfl.getYoutubeIcon().click();

		//Verify that 'AMC Instagram' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com/user/AmericasMart"));
		System.out.println("Instagram opened successfully");
		driver.get(prop.getProperty("ammarturl"));*/
	}

	
	@Test(enabled=false)
	public void TS003_AMC_VerifyAllLinksUnderMarketsAndEventsTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T012: To verify links for Attend tab at Header
		mi = new UXPMarketInfoPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		atat = new ATLAttendPage(driver);
		amme = new AMMarketsAndEventsPage(driver);

		driver.get(prop.getProperty("ammarturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.verifyCloseBtnPopup();
		Thread.sleep(8000);
		
		/*
		 * atat.getATLAttendTab().click(); Thread.sleep(500); //Click Attend our next
		 * market tab under Markets and Events section String winHandleBefore =
		 * driver.getWindowHandle(); amme.getattendournextmarket().click(); for(String
		 * winHandle : driver.getWindowHandles()){ driver.switchTo().window(winHandle);}
		 * Assert.assertTrue(driver.getCurrentUrl().contains(
		 * "https://compass.onpeak.com/"));
		 * System.out.println("Attend our next market section is displayed properly");
		 * driver.close(); driver.switchTo().window(winHandleBefore);
		 * 
		 * driver.get(prop.getProperty("ammarturl"));
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 * utl.verifyCloseBtnPopup();
		 */
		
	//Market Dates and Hours link
		amme.getMarketsAndEventsTab().click();
		Thread.sleep(2000);
		//Click Market Dates and Hours tab under Markets and Events section
		amme.getMarketDatesAndHour().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Market Dates and Hours");
		System.out.println("Market Dates and Hours section is displayed properly");
		Thread.sleep(500);

	//Spring-Market link
		amme.getMarketsAndEventsTab().click();
		Thread.sleep(2000);
		//Click Spring Market tab under Markets and Events section
		amme.getAMCSpringMarket().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("ammarturl")+ "Markets/Spring-Market"));
		System.out.println("Spring Market section is displayed properly");
		Thread.sleep(500);
		
	//Spring Cash & Carry link
		amme.getMarketsAndEventsTab().click();
		Thread.sleep(2000);
		//Click Spring Cash & Carry under Markets and Events section
		amme.getAMCSpringCashnCarry().click();
		Thread.sleep(5000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Spring Cash & Carry");
		System.out.println("Spring Cash & Carry section is displayed properly");
		Thread.sleep(500);
		
	//Casual Market link
		amme.getMarketsAndEventsTab().click();
		Thread.sleep(2000);
		//Click Casual Market under Markets and Events section
		String winHandleBefore = driver.getWindowHandle(); 
		amme.getCasualMarket().click();
		for(String winHandle : driver.getWindowHandles())
		{ 
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://casualmarketatlanta.com/"));
		System.out.println("Casual Market link is displayed properly");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(2000);
		
	//Fall Market link
		//amme.getMarketsAndEventsTab().click();
		//Click Fall Market under Markets and Events section
		amme.getAMCFallMarket().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Fall Market");
		System.out.println("Fall Market section is displayed properly");
		
	//Fall Cash and Carry link
		amme.getMarketsAndEventsTab().click();
		Thread.sleep(2000);
		//Click Fall Cash & Carry under Markets and Events section
		amme.getFallCashCarry().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("ammarturl")+"Markets/Fall-Cash-and-Carry"));
		System.out.println("Fall Cash & Carry section is displayed properly");
		
	//Year Round Events
		amme.getMarketsAndEventsTab().click();
		Thread.sleep(2000);
		//Click Open Year Round under Markets and Events section
		amme.getYearRoundEvents().click();
		Thread.sleep(4000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Calendar of Events");
		System.out.println("Open Year Round section is displayed properly");
		
	//Atlanta Market AndMore image link
		amme.getMarketsAndEventsTab().click();
		Thread.sleep(2000);
		//Click Atlanta Market logo under Markets and Events section
		amme.getAtlantaMarket().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		System.out.println("Atlanta Market website is displayed properly.");
		driver.get(prop.getProperty("ammarturl"));
		utl.verifyCloseBtnPopup();
		
	//Atlanta Apparel AndMore image link
		amme.getMarketsAndEventsTab().click();
		Thread.sleep(2000);
		//Click Atlanta Apparel under Markets and Events section
		amme.getAtlantaApparel().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		System.out.println("Atlanta Apparel website is displayed properly.");
		driver.get(prop.getProperty("ammarturl"));
	}
	
	//Due to re-branding changes
	@Test(enabled=false)//priority=1
	public void TS010_AMC_VerifyMarketPlannerLoginTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		/*//Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("ammarturl"));
		//Thread.sleep(5000);
		lap.getIUnderstandBtn().click();
		//Thread.sleep(5000);
		utl.verifyCloseBtnPopup();*/

		//Login to Market Planner
		utl.verifyMPLoginFunctionality();
		utl.verifyCloseBtnPopup();
		//Verify that Market Planner Home page should be displayed
		Assert.assertTrue(lap.getMPLinkText().isDisplayed());
	}

	//Due to re-branding changes
	@Test(enabled=false)//priority=2
	public void TS011_AMC_VerifyMarketPlannerProfileAndSettingsOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-002: To verify Profile and Settings option in Market Planner

		lap = new UXPLandingPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click Profile and Settings tab under Market Planner and verify result
		//Thread.sleep(5000);
		atlps.getATLWelcomeText().click();
		//Thread.sleep(5000);
		atlps.getATLProfileAndSettings().click();

		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("ammarturl")+"Profile"));
		System.out.println("Profile and Settings section options are displayed properly");
	}
	
	//Due to re-branding changes
	@Test(enabled=false)//priority=3
	public void TS012_AMC_VerifyMarketPlannerExhibitorPortalOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-003: To verify Exhibitor Portal option in Market Planner

		lap = new UXPLandingPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);
		atlexh = new ATLExhibitPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);

		atlps.getATLWelcomeText().click();
		Thread.sleep(5000);
		atlps.getAMCExhibitorPortalOptn().click();

		//Verify that 'EXP Home' page should be displayed
		Assert.assertTrue(atlps.getAMCExhibitorPortalHome().isDisplayed());

		driver.get(prop.getProperty("ammarturl"));

		/*//Sign out from Market Planner
		atlps.getATLWelcomeText().click();
		lap.getMPSignOutBtn().click();
		Thread.sleep(10000);*/
	}

	/*	@AfterSuite
	public void sendEmail()
	{
		se = new SendEmail();
		se.sendEmailWithAttachment();
	}*/
	

	@Test(enabled=false)
	public void TS007_AMC_VerifyAllLinksUnderOpenYearRoundTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T104: To verify the Open year round links and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		mi = new UXPMarketInfoPage(driver);
		amab = new AMAboutTabPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		amoyr=new AMOpenYearRoundPage(driver);

		driver.get(prop.getProperty("ammarturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(8000);
		utl.verifyCloseBtnPopup();
		
		//Click on Open Year Round Tab 
		amoyr.getOpenYearRoundTab().click();
		Thread.sleep(2000);
		//Click About Open Year Round Link
		amoyr.getAboutYearRound().click();
		Thread.sleep(5000);
		//Verify that About Open Year Round page should be displayed
		//String actualHeader="Open Year Round";
		Assert.assertTrue(driver.getCurrentUrl().contains("Year-Round"));

		//Verify how to register 
/*		amoyr.getOpenYearRoundTab().click();
		amoyr.gethowtoregister().click();
		Thread.sleep(3000);
		Assert.assertTrue(exhp.getVerifyBreadcrumb().getText().contains("How to Register"));
		System.out.println("How to regiter opened");
*/
		//Click on Open Year Round Tab 
		amoyr.getOpenYearRoundTab().click();
		Thread.sleep(2000);
		//Click Open Year Round Showrooms Link
		amoyr.getOpenYearRoundShowrooms().click();
		Thread.sleep(3000);
		utl.scrollToElement(amoyr.getOpenYearRoundShowroomsPageHeader());
		//Verify that Open Year Round Showrooms page should be displayed
		String actualShowroomDirectHeader="Open Year Round Showrooms at AmericasMart";
		Assert.assertTrue(amoyr.getOpenYearRoundShowroomsPageHeader().getText().equalsIgnoreCase(actualShowroomDirectHeader));
		
		utl.scrollToTop();
		//Click on Open Year Round Tab 
		amoyr.getOpenYearRoundTab().click();
		Thread.sleep(2000);
		//Click Exhibitor Directory Link
		amoyr.getExhibitorDirectory().click();
		Thread.sleep(3000);
		utl.scrollToElement(amoyr.getExhibitorDirectoryPageHeader());
		//Verify that Exhibitor Directory page should be displayed
		String actualExhibitorDirectoryHeader="Exhibitor Directory";
		Assert.assertTrue(amoyr.getExhibitorDirectoryPageHeader().getText().equals(actualExhibitorDirectoryHeader));

		utl.scrollToTop();
		//Click on Open Year Round Tab 
		amoyr.getOpenYearRoundTab().click();
		Thread.sleep(2000);
		//Click Floor Plans Link
		amoyr.getFloorPlans().click();
		Thread.sleep(3000);
		//Verify that Floor Plans page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("/Market-Map"));

		utl.scrollToTop();
		amoyr.getOpenYearRoundTab().click();
		Thread.sleep(2000);
		//Click Campus Overview Link
		amoyr.getCampOverview().click();
		Thread.sleep(3000);
		//Verify that Campus Overview page should be displayed	
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Campus Overview");

		utl.scrollToTop();
		amoyr.getOpenYearRoundTab().click();
		System.out.println("open Year Round DropDown");
		Thread.sleep(2000);
		amoyr.getVisit().click();
		System.out.println("Visit Link");
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(),"Visit");

		utl.scrollToTop();
		amoyr.getOpenYearRoundTab().click();
		Thread.sleep(3000);
		amoyr.getParknTranspSubmenu().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Parking & Transportation");

		amoyr.getOpenYearRoundTab().click();
		Thread.sleep(2000);
		amoyr.getHotelsSubmenu().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("ammarturl")+"Markets/Hotels"));

		amoyr.getOpenYearRoundTab().click();
		Thread.sleep(2000);
		amoyr.getHowToReg().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "How to Register");

		amoyr.getOpenYearRoundTab().click();
		Thread.sleep(2000);
		amoyr.getCalendarEvents().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(),"Calendar of Events");

		amoyr.getOpenYearRoundTab().click();
		Thread.sleep(2000);
		amoyr.getDesigners().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(),"For Designers");
	}
	

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}