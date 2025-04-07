package PROD;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
import pageObjects.AtlantaMarket.ATLVisitTab;
import pageObjects.AtlantaMarket.DiscoverTab;
import pageObjects.AtlantaMarket.YearAround;
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

@Listeners({ TestListeners.class })
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
	UXPHeaderChannelLinksPage hd;
	ATLVisitTab atlvt;
	DiscoverTab atldt;
	YearAround atlya;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);

		// Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		lap.getIUnderstandBtn().click();
		utl.waitForPageToLoad();
		Thread.sleep(3000);
		// utl.verifyCloseBtnPopup();
	}

	@Test(priority = 1)
	public void TS001_ATL_VerifyGlobalSearchFunctionalityTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T003: To verify global search functionality
		atlgs = new ATLGlobalSearchPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		atlgs.getATLGlobalSearchTextBox().click();
		Thread.sleep(500);
		atlgs.getGlobalSearchEnterText().sendKeys((prop.getProperty("exhibitordirectory2")));

		atlgs.getATLSearchButton().click();
		Thread.sleep(5000);

		String searchterm = atlgs.getATLVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("exhibitordirectory2")));
		System.out.println("Global Search functionality is working properly.");
	}

	@Test(priority = 2)
	public void TS002_ATL_VerifyAllChannelsLinksTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-TS009: To verify all channels links in Header

		atlch = new ATLAllChannelsLinksPage(driver);
		hd = new UXPHeaderChannelLinksPage(driver);

		driver.get(prop.getProperty("atlmrkturl"));
		// utl.verifyCloseBtnPopup();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);

		// New Code for Header Channel Links
		// Verify that Atlanta link is present
		Assert.assertTrue(hd.getAtlanta().getText().equalsIgnoreCase("ATLANTA"));
		Thread.sleep(2000);
		// Check Atlanta Apparel
		hd.getAtlanta().click();
		Assert.assertTrue(hd.getAtlantaApparel().getText().equalsIgnoreCase("Atlanta Apparel"));
		hd.getAtlantaApparel().click();
		Assert.assertTrue(driver.getTitle().contains("Atlanta Apparel"));
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(2000);

		// Check Casual Market Atlanta
		hd.getAtlanta().click();
		Assert.assertTrue(hd.getCasualMarketAtlantaURL().getText().equalsIgnoreCase("Casual Market Atlanta"));
		// String casualURl=hd.getCasualMarketAtlantaURL().getAttribute("href");
		hd.getCasualMarketAtlantaURL().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("casualmarketatlanta.com"));

		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(5000);

		// Check Atlanta Market
		hd.getAtlanta().click();
		Assert.assertTrue(hd.getAtlantaMarket().getText().equalsIgnoreCase("Atlanta Market"));
		hd.getAtlantaMarket().click();
		Assert.assertTrue(driver.getTitle().contains("Atlanta Market"));
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(2000);

		// Check Formal Markets
		hd.getAtlanta().click();
		Thread.sleep(500);
		Assert.assertTrue(hd.getFormalMarkets().getText().equalsIgnoreCase("Formal Markets"));
		hd.getFormalMarkets().click();
		Assert.assertTrue(driver.getTitle().contains("Formal Markets"));
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(2000);

		// Check Cash & Carry Markets: Spring and Fall
		hd.getAtlanta().click();
		// Check markets for Spring or Fall
		try {
			// For Spring Cash and Carry
			Assert.assertTrue(
					hd.getCashAndCarryMarketsSpringandFall().getText().equalsIgnoreCase("Spring Cash & Carry"));
			hd.getCashAndCarryMarketsSpringandFall().click();
			Assert.assertTrue(driver.getTitle().contains("Spring Cash & Carry"));
			driver.get(prop.getProperty("atlmrkturl"));
			Thread.sleep(2000);
		} catch (Exception e) {
			// For Fall Cash and Carry
			Assert.assertTrue(
					hd.getFllCashAndCarryMarketsSpringandFall().getText().equalsIgnoreCase("Fall Cash & Carry"));
			hd.getFllCashAndCarryMarketsSpringandFall().click();
			Assert.assertTrue(driver.getTitle().contains("Fall Cash & Carry"));
			driver.get(prop.getProperty("atlmrkturl"));
			Thread.sleep(2000);
		}
		/*
		 * hd.getAtlanta().click();
		 * Assert.assertTrue(hd.getMidSeasonBuyingEventFallMarket().getText().
		 * equalsIgnoreCase("Mid-Season Buying Event: Fall Market"));
		 * hd.getMidSeasonBuyingEventFallMarket().click();
		 * Assert.assertTrue(driver.getCurrentUrl().contains("Markets"));
		 * driver.get(prop.getProperty("atlmrkturl")); Thread.sleep(2000);
		 */

		/*
		 * //Check Cash & Carry Markets: Spring and Fall hd.getAtlanta().click();
		 * Assert.assertTrue(hd.getCashAndCarryMarketsSpringandFall().getText().
		 * equalsIgnoreCase("Cash & Carry Markets: Spring and Fall"));
		 * hd.getCashAndCarryMarketsSpringandFall().click();
		 * Assert.assertTrue(driver.getTitle().contains("Spring Cash & Carry"));
		 * driver.get(prop.getProperty("atlmrkturl")); Thread.sleep(2000);
		 */

		// Check ADAC
		hd.getAtlanta().click();
		Assert.assertTrue(hd.getADAC().getText().equalsIgnoreCase("ADAC"));
		hd.getADAC().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("ADAC"));
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(2000);
		
		// Check AmericasMart
		hd.getAtlanta().click();
		Assert.assertTrue(hd.getAmericasMart().getText().equalsIgnoreCase("AmericasMart"));
		hd.getAmericasMart().click();
		Assert.assertTrue(driver.getTitle().contains("Wholesale Gift, Home, Rug and Apparel Markets"));
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(2000);
		
		// Check Atlanta Convention Center
		hd.getAtlanta().click();
		Assert.assertTrue(hd.getAtlantaConventionCenter().getText().equalsIgnoreCase("Atlanta Convention Center"));
		hd.getAtlantaConventionCenter().click();
		Assert.assertTrue(driver.getTitle().contains("Atlanta Convention Center"));
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(2000);
		
		// Verify that Las Vegas link is present
		Assert.assertTrue(hd.getLasVegas().getText().equalsIgnoreCase("LAS VEGAS"));
		
		// Check Las Vegas Market
		hd.getLasVegas().click();
		Assert.assertTrue(hd.getLasVegasMarket().getText().equalsIgnoreCase("Las Vegas Market"));
		hd.getLasVegasMarket().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Market"));
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(2000);
		/*
		 * //Check Formal Markets hd.getLasVegas().click();
		 * Assert.assertTrue(hd.getFormalMarkets().getText().
		 * equalsIgnoreCase("Formal Markets")); hd.getFormalMarkets().click();
		 * Assert.assertTrue(driver.getTitle().contains("Formal Markets"));
		 * driver.get(prop.getProperty("atlmrkturl")); Thread.sleep(2000);
		 */
		// Check Las Vegas Apparel
		hd.getLasVegas().click();
		Assert.assertTrue(hd.getLasVegasApparel().getText().equalsIgnoreCase("Las Vegas Apparel"));
		hd.getLasVegasApparel().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Apparel"));
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(3000);

		// Check Las Vegas Design Center (LVDC)
		hd.getLasVegas().click();
		Assert.assertTrue(hd.getLasVegasDesignCenter().getText().equalsIgnoreCase("Las Vegas Design Center (LVDC)"));
		hd.getLasVegasDesignCenter().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Design Center"));
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(2000);

		// Check EXPO at World Market Center Las Vegas
		hd.getLasVegas().click();
		Assert.assertTrue(hd.getEXPOatWorldMarketCenterLasVegas().getText()
				.equalsIgnoreCase("EXPO at World Market Center Las Vegas"));
		hd.getEXPOatWorldMarketCenterLasVegas().click();
		Thread.sleep(1000);
		System.out.println("Title of page: " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("The Expo At World Market Center"));
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(2000);

		// Verify that High Point link is present
		Assert.assertTrue(hd.getHighPoint().getText().equalsIgnoreCase("HIGH POINT"));

		// Check ANDMORE at High Point Market
		hd.getHighPoint().click();
		Assert.assertTrue(hd.getANDMOREatHighPointMarket().getText().equalsIgnoreCase("ANDMORE at High Point Market"));
		hd.getANDMOREatHighPointMarket().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getTitle().contains("High Point"));
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(2000);

		// Check SHOPPE OBJECT High Point
		hd.getHighPoint().click();
		Assert.assertTrue(hd.getSHOPPEOBJECTHighPoint().getText().equalsIgnoreCase("SHOPPE OBJECT High Point"));
		hd.getSHOPPEOBJECTHighPoint().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("shoppeobject.com"));
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(2000);

		// Verify that New York link is present
		Assert.assertTrue(hd.getNewYork().getText().equalsIgnoreCase("NEW YORK"));

		// Check SHOPPE OBJECT
		hd.getNewYork().click();
		Assert.assertTrue(hd.getSHOPPEOBJECT().getText().equalsIgnoreCase("SHOPPE OBJECT"));
		hd.getSHOPPEOBJECT().click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getCurrentUrl().contains("shoppeobject.com"));
		// driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void TS003_ATL_VerifyAllLinksUnderExhibitorDirectoryTab() throws InterruptedException, IOException {
		atled = new ATLExhibitorDirectoryPage(driver);
		atlexh = new ATLExhibitPage(driver);

		driver.get(prop.getProperty("atlmrkturl"));
		// utl.verifyCloseBtnPopup();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);

	// Search Exhibitors
		// Click on Exhibitor Directory tab
		atled.getExhibitorDitectoryTab().click();
		// Click on Search Exhibitors sub-menu
		atled.getSearchExhibitors().click();
		Thread.sleep(1000);
		// Verify that Search Exhibitors page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Exhibitor Directory"));

	// A-Z Brand Listing
		// Click on Exhibitor Directory tab
		atled.getExhibitorDitectoryTab().click();
		// Click on A-Z Brand Listing sub-menu
		atled.getAZBrandListing().click();
		Thread.sleep(1000);
		// Verify that A-Z Brand Listing page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Directory"));

	// Floor Plans
		// Click on Exhibitor Directory tab
		atled.getExhibitorDitectoryTab().click();
		// Click on Floor Plans sub-menu
		atled.getFloorPlans().click();
		Thread.sleep(6000);
		// Verify that Floor Plans page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Floor Plans"));

	// Categories
		// Click on Exhibitor Directory tab
		atled.getExhibitorDitectoryTab().click();
		// Click on Categories sub-menu
		atled.getCategories().click();
		Thread.sleep(3000);
		// Verify that Categories page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Categories"));

	}

	@Test(priority = 4)
	public void TS004_ATL_VerifyAllLinksUnderVisitTab() throws InterruptedException, IOException {
		atlexh = new ATLExhibitPage(driver);
		atlvt = new ATLVisitTab(driver);

		driver.get(prop.getProperty("atlmrkturl"));
		// utl.verifyCloseBtnPopup();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);

	// Register
		// Click on Exhibitor Directory tab
		atlvt.getVisitTab().click();
		// Click on Register link
		atlvt.getRegister().click();
		Thread.sleep(2000);
		// Verify that Exhibitor Directory page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Register"));

	// Market Dates & Hours
		// Click on Exhibitor Directory tab
		atlvt.getVisitTab().click();
		// Click on Market Dates & Hours link
		atlvt.getMarketDatesAndHours().click();
		Thread.sleep(2000);
		// Verify that Market Dates & Hours page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Market Dates & Hours"));

	// About Market
		// Click on Exhibitor Directory tab
		atlvt.getVisitTab().click();
		// Click on About Market link
		atlvt.getAboutMarket().click();
		Thread.sleep(2000);
		// Verify that About Market page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("About Us"));

	// Market 101
		// Click on Exhibitor Directory tab
		atlvt.getVisitTab().click();
		// Click on Market 101 link
		atlvt.getMarket101().click();
		Thread.sleep(2000);
		// Verify that Market 101 page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("Market-101"));

	// Market Plan
		// Click on Exhibitor Directory tab
		atlvt.getVisitTab().click();
		// Click on Market Plan link
		atlvt.getMarketPlan().click();
		Thread.sleep(2000);
		// Verify that Market Plan page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Plan Your Market"));

	// Travel
		// Click on Exhibitor Directory tab
		atlvt.getVisitTab().click();
		// Click on Travel link
		atlvt.getTravel().click();
		Thread.sleep(2000);
		// Verify that Travel page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Travel"));

	// Dining
		// Click on Exhibitor Directory tab
		atlvt.getVisitTab().click();
		// Click on Dining link
		atlvt.getDining().click();
		Thread.sleep(2000);
		// Verify that Dining page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Dining Guide"));

	// Services & Amenities
		// Click on Exhibitor Directory tab
		atlvt.getVisitTab().click();
		// Click on Services & Amenities link
		atlvt.getServicesAndAmenities().click();
		Thread.sleep(2000);
		// Verify that Services & Amenities page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Services & Amenities"));

	//Events
		// Click on Exhibitor Directory tab
		atlvt.getVisitTab().click();
		// Click on Services & Amenities link
		atlvt.getEvents().click();
		Thread.sleep(2000);
		// Verify that Services & Amenities page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Events"));
	}

	@Test(priority = 5)
	public void TS005_ATL_VerifyAllLinksUnderDiscoverTab() throws InterruptedException, IOException {

		atldt = new DiscoverTab(driver);
		atlexh = new ATLExhibitPage(driver);

		driver.get(prop.getProperty("atlmrkturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);

	//Exhibitor Directory
		// Click on Discover tab
		atldt.getDiscoverTab().click();
		// Click on Exhibitor Directory link
		atldt.getExhibitorDirectory().click();
		// Verify that Exhibitor Directory page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Exhibitor Directory"));
		
		
	//A-Z brand listing
		//Click on Discover tab 
		atldt.getDiscoverTab().click();
		//Click on A-Z brand listing link 
		atldt.getAZbrandlisting().click(); 
		//Verify that A-Z brand listing page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("exhibitor"));
		 
	//Floor Plans
		// Click on Discover tab
		atldt.getDiscoverTab().click();
		// Click on Floor Plans link
		atldt.getFloorPlans().click();
		Thread.sleep(3000);
		// Verify that Floor Plans page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Floor Plans"));

	//Explore Atlanta Market
		// Click on Discover tab
		atldt.getDiscoverTab().click();
		// Click on Explore Atlanta Market link
		atldt.getExploreAtlantaMarket().click();
		// Verify that Explore Atlanta Market page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Categories"));

	//Tools & Inspiration
		// Click on Discover tab
		atldt.getDiscoverTab().click();
		// Click on Tools & Inspiration link
		atldt.getToolsAndInspiration().click();
		Thread.sleep(3000);
		// Verify that Tools & Inspiration page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("News-and-Trends"));
		Thread.sleep(1000);

	//Plan Your market
		// Click on Discover tab
		atldt.getDiscoverTab().click();
		// Click on Plan Your market link
		atldt.getPlanYourMarket().click();
		// Verify that Plan Your market page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Plan Your Market"));

	//What's New
		// Click on Discover tab
		atldt.getDiscoverTab().click();
		// Click on What's New link
		atldt.getWhatsNew().click();
		Thread.sleep(3000);
		// Verify that What's New page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("Whats-New"));

	//Events
		// Click on Discover tab
		atldt.getDiscoverTab().click();
		// Click on Events link
		atldt.getEvents().click();
		// Verify that Events page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Events"));

	}

	@Test(priority = 6)
	public void TS006_ATL_VerifAllLinksUnderExhibitTabTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-008: To verify the Exhibit menu overview and it's functionality

		lap = new UXPLandingPage(driver);
		atlexh = new ATLExhibitPage(driver);

		driver.get(prop.getProperty("atlmrkturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);

	// Exhibit at Atlanta Market Link
		// Click on Exhibit tab
		atlexh.getATLExhibitTab().click();
		Thread.sleep(1000);
		// Click on Exhibit at Atlanta Market sub-menu
		atlexh.getATLExhibitAtAtlanta().click();
		Thread.sleep(2000);
		// Verify that Exhibit page should be displayed
		Assert.assertTrue(atlexh.getATLExhibitBrdcrumb().isDisplayed());

	// Exhibitor Resources
		// Click on Exhibit tab
		atlexh.getATLExhibitTab().click();
		// Click on Exhibitor Resources sub-menu
		atlexh.getATLExhibitorResources().click();
		Thread.sleep(4000);
		// Verify that Exhibitor Resources page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Exhibitor Resources"));

	// Already an Exhibitor?
		// Click on Exhibit tab
		atlexh.getATLExhibitTab().click();
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		// Click on Exhibitor Portal Login' sub-menu
		atlexh.getAlreadyAnExhibitor().click();
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		// Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(atlexh.getATLEXPLoginPageTitle().isDisplayed());
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		/*
		 * //Click on Exhibit tab atlexh.getATLExhibitTab().click(); Thread.sleep(1000);
		 * //Click on 'Why Exhibit?' sub-menu atlexh.getATLWhyExhibitMenu().click();
		 * Thread.sleep(3000); //Verify that 'Exhibit' page should be displayed
		 * Assert.assertTrue(atlexh.getATLExhibitBrdcrumb().isDisplayed());
		 * 
		 * //Click on Exhibit tab atlexh.getATLExhibitTab().click(); Thread.sleep(1000);
		 * //Click on 'Apply to Exhibit' sub-menu atlexh.getATLApplyToExhibit().click();
		 * Thread.sleep(3000); //Verify that 'Apply to exhibit' page should be displayed
		 * Assert.assertEquals(atlexh.getATLApplyToExhibitBrdcrmb().getText(),
		 * "Apply to Exhibit");
		 * 
		 * //Click on Exhibit tab atlexh.getATLExhibitTab().click(); Thread.sleep(1000);
		 * //Click on 'Exhibitor Registration' link
		 * atlexh.getATLExhibitorRegtnMenu().click(); Thread.sleep(2000); //Verify that
		 * Exhibitor Registration page should be displayed
		 * Assert.assertTrue(atlexh.getATLExhRegstnBrdcrmb().getText().
		 * contains("Exhibitor Registration"));
		 */

		/*
		 * //Click on Exhibit tab atlexh.getATLExhibitTab().click();
		 * 
		 * //Click on Juniper Commerce sub-menu // Juniper menu is removed from design
		 * atlexh.getATLJuniperMenu().click();
		 * 
		 * Thread.sleep(6000); //Verify that 'Juniper' page should be displayed
		 * Assert.assertTrue(driver.getCurrentUrl().contains(
		 * "https://www.junipercommerce.com/"));
		 */
	}

	@Test(priority = 7)
	public void TS007_ATL_VerifyAllLinksUnderYearRoundTab() throws InterruptedException, IOException {

		atlya = new YearAround(driver);
		atlexh = new ATLExhibitPage(driver);

		driver.get(prop.getProperty("atlmrkturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);

	//Markets
		// Click on Source Year Round Tab
		atlya.getYearRoundTab().click();
		// Click on Year Round Link
		atlya.getMarketsLink().click();
		Thread.sleep(3000);
		// Verify that Year Round page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("Market"));
		
	//Year Round
		// Click on Source Year Round Tab
		atlya.getYearRoundTab().click();
		// Click on Year Round Link
		String winHandleBefore = driver.getWindowHandle();
		atlya.getYearRoundLink().click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(3000);
		// Verify that Year Round page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("Year-Round"));
		driver.close();
		driver.switchTo().window(winHandleBefore);

	//Exhibitor Directory
		// Click on Source Year Round Tab
		atlya.getYearRoundTab().click();
		// Click on Exhibitor Directory Link
		atlya.getExhibitorDirectoryLink().click();
		Thread.sleep(3000);
		// Verify that Exhibitor Directory page should be displayed
		Assert.assertTrue(atlexh.getATLExhResourcesBrdcrmb().getText().contains("Exhibitor Directory"));

		
	//A-Z Brand Listing
		//Click on Source Year Round Tab
		atlya.getYearRoundTab().click();
		//Click on A-Z Brand Listing Link
		atlya.getAZBrandListingLink().click();
		Thread.sleep(3000);
		//Verify that A-Z Brand Listing page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("exhibitor"));
		 
	//Floor Plans
		// Click on Source Year Round Tab
		atlya.getYearRoundTab().click();
		// Click on Floor Plans Link
		atlya.getFloorPlansLink().click();
		Thread.sleep(3000);
		// Verify that Floor Plans page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("Market-Map"));

	//Contact Us
		// Click on Source Year Round Tab
		atlya.getYearRoundTab().click();
		// Click on Contact Us Link
		String winHandleBefore2 = driver.getWindowHandle();
		atlya.getContactUsLink().click();
		for (String winHandle2 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle2);
		}
		Thread.sleep(3000);
		// Verify that Contact Us page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("Contact-Us"));
		driver.close();
		driver.switchTo().window(winHandleBefore2);

	}

	@Test(priority = 8)
	public void TS008_ATL_VerifyAllSocialMediaLinksOnFooterTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T010: To verify the all social media links and it's redirection

		atlfl = new ATLFooterLinksNavigationPage(driver);
		fl = new UXPFooterLinksNavigationPage(driver);
		driver.get(prop.getProperty("atlmrkturl"));
		utl.verifyCloseBtnPopup();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		// Scroll till footer links
		utl.scrollToElement(fl.getmarketInfo());

		// In app footer click on 'Facebook' icon and verify results
		atlfl.getFacebookIcon().click();

		Thread.sleep(8000);
		// Verify that 'ATL Facebook' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/AmericasmartAtl"));

		driver.get(prop.getProperty("atlmrkturl"));
		utl.verifyCloseBtnPopup();

		// Click on Instagram icon
		/*
		 * fl.getInstagramiconATLM().click();
		 * 
		 * // Switch to new window opened for(String winHandle :
		 * driver.getWindowHandles()){ driver.switchTo().window(winHandle); }
		 * Thread.sleep(10000); //Verify that 'ATL Instagram' page should be displayed
		 * Assert.assertTrue(driver.getCurrentUrl().contains(
		 * "https://www.instagram.com/americasmartatl/"));
		 * 
		 * driver.get(prop.getProperty("atlmrkturl"));
		 * 
		 * 
		 * //Click on You Tube icon atlfl.getYouTubeIcon().click();
		 * 
		 * Thread.sleep(10000); //Verify that 'ATL You Tube' page should be displayed
		 * Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com"))
		 * ;
		 * 
		 * driver.get(prop.getProperty("atlmrkturl"));
		 * 
		 * //Click on Twitter icon fl.gettwittericonATLM().click();
		 * 
		 * Thread.sleep(10000); //Verify that 'ATL Twitter' page should be displayed
		 * Assert.assertTrue(driver.getCurrentUrl().contains(
		 * "https://www.twitter.com/americasmartatl"));
		 * driver.get(prop.getProperty("atlmrkturl"));
		 */

	}

	@Test(priority = 9)
	public void TS009_ATL_VerifyFooterLinksTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T69: To verify Footer Links Navigation
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		fl = new UXPFooterLinksNavigationPage(driver);
		atlfo = new ATLAppFooterLinksNavigationPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("atlmrkturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		
	//Market Information
		utl.scrollToElement(fl.getmarketInfo());
		// Click Market Info link and verify results
		fl.getmarketInfo().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/market-info"));
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(2000);
		
	//Press Center
		// utl.verifyCloseBtnPopup();
		utl.scrollToBottom();
		// Click on Press Center
		fl.getpressCenter().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/Market-Info/Press-Center"));
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(5000);
		
	//Download the ANDMORE Markets App
		// utl.verifyCloseBtnPopup();
		utl.scrollToBottom();
		// Click Download The App link and verify results
		fl.getDownloadTheApp().click();
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Plan Your Market");
		driver.get(prop.getProperty("atlmrkturl"));
		// utl.verifyCloseBtnPopup();
		Thread.sleep(3000);
		utl.scrollToBottom();

	//Our Brands
		// Click on Our Brands link
		fl.getOurBrandsATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/exhibitor/directory"));
		driver.get(prop.getProperty("atlmrkturl"));
		// utl.verifyCloseBtnPopup();
		Thread.sleep(5000);
		// utl.scrollToElement(fl.getContactUsATL());
		utl.scrollToBottom();
		Thread.sleep(500);
		
	//Contact Us
		// Click Contact Us link and verify results
		String winHandleBefore1 = driver.getWindowHandle();
		fl.getContactUsATL().click();
		for (String winHandle1 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle1);
		}
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Contact-Us"));
		driver.close();
		driver.switchTo().window(winHandleBefore1);
		
	//Careers
		utl.scrollElementIntoMiddle(fl.getCareersATL());
		fl.getCareersATL().click();
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("www.andmore.com/our-team"));
		driver.navigate().back();
		Thread.sleep(5000);
		
	//Exhibitor Login
		utl.scrollToBottom();
		fl.getExhibitorLogin().click();
		Thread.sleep(5000);
		Assert.assertTrue(fl.getEXPloginVerify().getText().contains("Exhibitor Portal Login"));
		System.out.println("Exhibitor Portal Login Page Opens Successifully");
		driver.navigate().back();
		Thread.sleep(5000);
		
	//AmericasMart
		// Click Americas Mart link and verify results
		utl.scrollElementIntoMiddle(fl.getAmericasMart_ATLAppFooter());
		String winHandleBefore2 = driver.getWindowHandle();
		fl.getAmericasMart_ATLAppFooter().click();
		for (String winHandle2 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle2);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore2);

	//Atlanta Apparel
		// Click Atlanta Apparel link and verify results
		utl.scrollElementIntoMiddle(fl.getAtlantaApparel());
		// Switch to new tab
		String winHandleBefore3 = driver.getWindowHandle();
		fl.getAtlantaApparel().click();
		for (String winHandle3 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle3);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore3);
		
	//Casual Market Atlanta
		// Switch to new tab
		utl.scrollElementIntoMiddle(fl.getCasualMarketAtlanta());
		String winHandleBefore4 = driver.getWindowHandle();
		fl.getCasualMarketAtlanta().click();
		for (String winHandle4 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle4);
		}
		Thread.sleep(7000);
		Assert.assertTrue(driver.getCurrentUrl().contains("casualmarketatlanta.com"));
		driver.close();
		driver.switchTo().window(winHandleBefore4);

	//ANDMORE at High Point Market
		// Switch to new tab
		utl.scrollElementIntoMiddle(fl.getHighPointMarket());
		String winHandleBefore5 = driver.getWindowHandle();
		fl.getHighPointMarket().click();
		for (String winHandle5 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle5);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmorehighpointmarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore5);
		// utl.scrollToElement(fl.getmarketInfo());

	//Las Vegas Apparel
		utl.scrollElementIntoMiddle(fl.getlvapplinkNew());
		Thread.sleep(3000);
		String winHandleBefore6 = driver.getWindowHandle();
		fl.getlvapplinkNew().click();
		for (String winHandle6 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle6);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore6);
		// Click on LVM Market link
		
	//Las Vegas Market
		// Switch to new tab
		utl.scrollElementIntoMiddle(fl.getlvmlink_ATL());
		String winHandleBefore7 = driver.getWindowHandle();
		fl.getlvmlink_ATL().click();
		for (String winHandle7 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle7);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore7);
		// utl.scrollToElement(fl.getmarketInfo());

	//ANDMORE
		// Click ANDMORE link and verify results
		utl.scrollElementIntoMiddle(fl.getandmore());
		// Switch to new tab
		String winHandleBefore8 = driver.getWindowHandle();
		fl.getandmore().click();
		for (String winHandle8 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle8);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore8);
		
	//Terms & Conditions
		// Click on Terms & condition link
		utl.scrollToBottom();
		Thread.sleep(200);
		String winHandleBefore9 = driver.getWindowHandle();
		fl.getTermsAndConditions().click();
		for (String winHandle9 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle9);
		}
		// Assert.assertEquals(fl.getVerifyTermsOfUse().getText(), "TERMS OF USE");
		Assert.assertTrue(driver.getCurrentUrl().contains("terms-of-use"));
		driver.close();
		driver.switchTo().window(winHandleBefore9);
		
	//Privacy Policy
		// Click Privacy Policy link and verify results
		utl.scrollToBottom();
		String winHandleBefore10 = driver.getWindowHandle();
		fl.getatlprivacypolicy().click();
		for (String winHandle10 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle10);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("privacy-policy"));
		driver.close();
		driver.switchTo().window(winHandleBefore10);
		
		// Due to re-branding changes
		/*
		 * //Click International Market Centers link and verify results
		 * fl.getInternationalMarketCenters().click(); //Switch to new tab String
		 * winHandleBefore3 = driver.getWindowHandle(); for(String winHandle3 :
		 * driver.getWindowHandles()){ driver.switchTo().window(winHandle3);}
		 * Assert.assertTrue(driver.getCurrentUrl().contains(
		 * "https://www.imcenters.com/")); driver.close();
		 * driver.switchTo().window(winHandleBefore3);
		 * utl.scrollToElement(fl.getmarketInfo());
		 * 
		 * //Click Juniper Market Centers link and verify results
		 * fl.getJuniperMarket().click(); //Switch to new tab String winHandleBefore12 =
		 * driver.getWindowHandle(); for(String winHandle12 :
		 * driver.getWindowHandles()){ driver.switchTo().window(winHandle12);}
		 * Assert.assertTrue(driver.getCurrentUrl().contains(
		 * "https://www.junipermarket.com/")); driver.close();
		 * driver.switchTo().window(winHandleBefore12);
		 * utl.scrollToElement(fl.getmarketInfo());
		 */
		// Changes due to re-branding | | New addeds
		
	}

	/*
	 * @Test(priority=2) public void TS002_ATL_VerifyExhibitorDirectoryTest() throws
	 * InterruptedException, IOException { //The purpose of this test case to
	 * verify:- //UXP-T005: To verify Exhibitor Directory
	 * 
	 * atlgs = new ATLGlobalSearchPage(driver); atled = new
	 * ATLExhibitorDirectoryPage(driver); atlexhp = new
	 * ATLExhibitorsAndProductsTabPage(driver);
	 * 
	 * driver.get(prop.getProperty("atlmrkturl"));
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //Verify
	 * exhibitor data is displayed or not as per search criteria
	 * 
	 * atled.getATLExhibitorDirectory().click();
	 * Assert.assertEquals(atlexhp.getATLVerifyExhibitorDirectory().getText(),
	 * "Exhibitor Directory");
	 * System.out.println("Exhibitor Directory is opened properly.");
	 * 
	 * atled.getATLExhDirtSearchBox().sendKeys((prop.getProperty(
	 * "exhibitordirectory"))); atled.getATLExhDirtSearchBtn().click();
	 * //Thread.sleep(1000); String searchterm =
	 * atlgs.getATLVerifyGlobalSeacrh().getText();
	 * Assert.assertTrue(searchterm.contains(prop.getProperty("exhibitordirectory"))
	 * ); System.out.println("Exhibitor Directory page is working properly."); }
	 */

	/*
	 * @Test(priority=4) public void
	 * TS004_ATL_VerifyAllLinksUnderExhibitorsAndProductsTabTest() throws
	 * InterruptedException, IOException { //The purpose of this test case to
	 * verify:- //UXP-007: To verify the Exhibitors & Products menu overview and
	 * it's functionality
	 * 
	 * atlexhp = new ATLExhibitorsAndProductsTabPage(driver);
	 * 
	 * driver.get(prop.getProperty("atlmrkturl"));
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 * Thread.sleep(4000);
	 * 
	 * //Verify Exhibitors And Products section is displayed //Click
	 * ExhibitorsAndProductsTab at Header
	 * atlexhp.getATLExhibitorsAndProducts().click();
	 * Assert.assertTrue(atlexhp.getATLVerifyExhibitorsAndProductsSection().
	 * isDisplayed()); System.out.
	 * println("Exhibitors and Products section options are displayed properly");
	 * 
	 * //Verify Exhibitor Directory page //Click Exhibitor Directory option under
	 * Exhibitors and Products atlexhp.getATLExhibitorDirectory().click();
	 * Thread.sleep(5000);
	 * Assert.assertEquals(atlexhp.getATLVerifyExhibitorDirectory().getText(),
	 * "Exhibitor Directory");
	 * System.out.println("Exhibitory Directory section is displayed properly");
	 * 
	 * Thread.sleep(1000); //Verify Floor Plans link //Click Floor Plans option
	 * under Exhibitors and Products atlexhp.getATLExhibitorsAndProducts().click();
	 * atlexhp.getATLFloorPlans().click();
	 * Assert.assertTrue(atlexhp.getATLVerifyFloorPlans().isDisplayed());
	 * System.out.println("Floor Plans section is displayed properly");
	 * 
	 * Thread.sleep(1000); //Verify Show Specials link //Click Show Specials option
	 * atlexhp.getATLExhibitorsAndProducts().click(); Thread.sleep(500);
	 * atlexhp.getATLShowSpecialsPROD().click(); Thread.sleep(1000);
	 * Assert.assertEquals(atlexhp.getATLVerifyExhibitorDirectory().getText(),
	 * "Show Specials");
	 * 
	 * //Verify Temporaries link //Click Temporaries option under Exhibitors and
	 * Products atlexhp.getATLExhibitorsAndProducts().click(); Thread.sleep(500);
	 * atlexhp.getATLTemporaries().click(); Thread.sleep(1000);
	 * Assert.assertEquals(atlexhp.getATLTemporaries().getText(), "Temporaries");
	 * System.out.println("Temporaries section is displayed properly");
	 * 
	 * //Verify Categories link //Click Categories option under Exhibitors and
	 * Products atlexhp.getATLExhibitorsAndProducts().click(); Thread.sleep(500);
	 * atlexhp.getATLCategories().click(); Thread.sleep(1000);
	 * Assert.assertEquals(atlexhp.getATLCategories().getText(), "Categories");
	 * System.out.println("Categories section is displayed properly");
	 * 
	 * }
	 */

	/*
	 * @Test(priority=3) public void
	 * TS003_ATL_VerifyAllLinksUnderMarketInfoTabTest() throws InterruptedException,
	 * IOException { //The purpose of this test case to verify:- //UXP-T006: To
	 * verify links for Market info tab at Header
	 * 
	 * atlmi = new ATLMarketInfoPage(driver);
	 * driver.get(prop.getProperty("atlmrkturl"));
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	 * 
	 * //Verify About Page //Click Market Info tab at Header
	 * atlmi.getATLMarketInfoHeader().click(); //Click on About sub-menu
	 * atlmi.getATLAboutSubMenu().click(); Thread.sleep(1000); //Verify that About
	 * Us page should be displayed
	 * Assert.assertTrue(atlmi.getATLAboutUsPageHeader().isDisplayed());
	 * System.out.println("About page is present");
	 * 
	 * //Verify Floor Plans Page //Click Market Info tab at Header
	 * atlmi.getATLMarketInfoHeader().click(); //Click on Floor Plans sub-menu
	 * atlmi.getATLFloorPlan().click(); Thread.sleep(3000); //Verify that Market
	 * Info page should be displayed
	 * Assert.assertTrue(driver.getCurrentUrl().contains("Market-Map"));
	 * System.out.println("Floor Plans page is present");
	 * 
	 * //Verify Getting to Market Page //Click Market Info tab at Header
	 * atlmi.getATLMarketInfoHeader().click(); //Click on Getting to Market sub-menu
	 * atlmi.getATLGettingToMarket().click(); Thread.sleep(1000); //Verify that
	 * Getting to Market page should be displayed
	 * Assert.assertTrue(atlmi.getATLGettingToMarketHeader().isDisplayed());
	 * System.out.println("Getting to Market page is present");
	 * 
	 * //Verify Industry Partners Page //Click Market Info tab at Header
	 * atlmi.getATLMarketInfoHeader().click(); //Click on Industry Partners sub-menu
	 * atlmi.getATLIndustryPartners().click(); Thread.sleep(4000); //Verify that
	 * Industry Partners page should be displayed
	 * Assert.assertTrue(driver.getTitle().contains("Industry Partners"));
	 * System.out.println("Industry Partners page is present");
	 * 
	 * //Verify Dates & Hours Page //Click Market Info tab at Header
	 * atlmi.getATLMarketInfoHeader().click(); //Click on Dates & Hours sub-menu
	 * atlmi.getATLDatesAndHrsSubMenu().click(); Thread.sleep(1000); //Verify that
	 * Dates & Hours page should be displayed
	 * Assert.assertTrue(atlmi.getATLMrketDatesHrsPageHeader().isDisplayed());
	 * System.out.println("Dates & Hours page is present");
	 * 
	 * Thread.sleep(1000); //Verify Market 101 Page //Click Market Info tab at
	 * Header atlmi.getATLMarketInfoHeader().click(); //Click on Market101 sub-menu
	 * atlmi.getATLMarket101().click(); Thread.sleep(5000); //Verify that Market101
	 * page should be displayed
	 * Assert.assertTrue(driver.getCurrentUrl().contains("Market-101"));
	 * System.out.println("Market 101 page is present");
	 * 
	 * Thread.sleep(1000); //Verify Registration Page //Click Market Info tab at
	 * Header atlmi.getATLMarketInfoHeader().click(); //Click on Registration
	 * sub-menu atlmi.getATLRegistrationsSubMenu().click(); Thread.sleep(3000);
	 * //Verify that Registration page should be displayed
	 * Assert.assertTrue(driver.getCurrentUrl().contains("Register"));
	 * System.out.println("Registration page is present");
	 * 
	 * Thread.sleep(1000); //Verify What's New Page //Click Market Info tab at
	 * Header atlmi.getATLMarketInfoHeader().click(); Thread.sleep(1000); //Click on
	 * What's New sub-menu atlmi.getATLWhatsNew().click(); Thread.sleep(1000);
	 * //Verify that What's New page should be displayed
	 * Assert.assertTrue(driver.getCurrentUrl().contains("Whats-New"));
	 * System.out.println("What's New page is present");
	 * 
	 * Thread.sleep(1000); //Verify Press Center Page //Click Market Info tab at
	 * Header atlmi.getATLMarketInfoHeader().click(); //Click on Press Center
	 * sub-menu atlmi.getATLPressCenterSubMenu().click(); Thread.sleep(1000);
	 * //Verify that Press Releases page should be displayed
	 * Assert.assertTrue(atlmi.getATLPressCenterPageHeader().isDisplayed());
	 * System.out.println("Press Center page is present");
	 * 
	 * Thread.sleep(1000); //Verify Video Gallery Page //Click Market Info tab at
	 * Header atlmi.getATLMarketInfoHeader().click(); //Click on Video Gallery
	 * sub-menu String winHandleBefore7 = driver.getWindowHandle();
	 * atlmi.getATLVideoGallerySubMenu().click(); for (String winHandle7 :
	 * driver.getWindowHandles()) { driver.switchTo().window(winHandle7); } //Verify
	 * that Video Gallery page should be displayed
	 * Assert.assertTrue(driver.getCurrentUrl().contains("youtube.com"));
	 * driver.close(); driver.switchTo().window(winHandleBefore7);
	 * System.out.println("Video gallery is redirecting to the youtube channel");
	 * Thread.sleep(1000);
	 * 
	 * //Verify Safety & Security Page //Click Market Info tab at Header
	 * //atlmi.getATLMarketInfoHeader().click(); //Click on What's New sub-menu
	 * atlmi.getATLSafetyandSecurity().click(); //Verify that Safety & Security page
	 * should be displayed
	 * Assert.assertTrue(driver.getCurrentUrl().contains("Safety-and-Security"));
	 * System.out.println("Safety & Security page is present");
	 * 
	 * Thread.sleep(1000); //Verify Plan your Market Page //Click Market Info tab at
	 * Header atlmi.getATLMarketInfoHeader().click(); //Click on Plan Your Market
	 * sub-menu atlmi.getATLPlanYourMarket().click(); Thread.sleep(3000); //Verify
	 * that Plan Your Market page should be displayed
	 * Assert.assertTrue(driver.getCurrentUrl().contains("Plan-Your-Market"));
	 * System.out.println("Plan Your Market page is present");
	 * 
	 * }
	 */

	/*
	 * @Test(priority=5) public void TS005_ATL_VerifyAllNewsAndTrendsMenuTest()
	 * throws InterruptedException, IOException { //The purpose of this test case to
	 * verify:- //UXP-T013: To verify the all News & Trends tap Menu and it's
	 * redirection
	 * 
	 * atlnt = new ATLNewsAndTrendsTabPage(driver); exhp = new
	 * UXPExhibitorsAndProductsTabPage(driver);
	 * 
	 * driver.get(prop.getProperty("atlmrkturl"));
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 * 
	 * //utl.verifyCloseBtnPopup(); //atlnt.getATLNewsAndTrends().click();
	 * Thread.sleep(5000); //Click News and Trends tab and verify result
	 * atlnt.getATLNewsAndTrendsTap().click(); Thread.sleep(3000);
	 * Assert.assertTrue(atlnt.getVerifyNewsSection().isDisplayed());
	 * System.out.println("News and Attend section is displayed properly");
	 * 
	 * //News & Trends //atlnt.getATLNewsAndTrendsTap().click(); //Click on News And
	 * Trends sub-menu and Verify Page atlnt.getATLNewsAndTrendsSubmenu().click();
	 * Thread.sleep(1000);
	 * Assert.assertTrue(driver.getCurrentUrl().contains("News-and-Trends"));
	 * System.out.println("News & Trends page link working as expected");
	 * Thread.sleep(2000);
	 * 
	 * //Market Snapshot utl.scrollToTop(); Thread.sleep(1000); //Click on News And
	 * Trends Tab atlnt.getATLNewsAndTrendsTap().click(); Thread.sleep(500);
	 * atlnt.getATLatlMarketSnapshot().click(); Thread.sleep(2000); //Click on
	 * MarketSnapshot and Verify Page
	 * Assert.assertTrue(driver.getCurrentUrl().contains("Market-Snapshot"));
	 * System.out.println("Market Snapshot page link working as expected");
	 * 
	 * //The ( A ) List utl.scrollToTop(); //Click on News And Trends Tab
	 * atlnt.getATLNewsAndTrendsTap().click(); Thread.sleep(500);
	 * atlnt.getTheAList().click(); //Verify Page opens successfully
	 * Assert.assertTrue(driver.getCurrentUrl().contains("The-A-List"));
	 * System.out.println("The ( A ) List page link working as expected");
	 * 
	 * //Market Pros utl.scrollToTop(); //Click on News And Trends Tab
	 * atlnt.getATLNewsAndTrendsTap().click(); Thread.sleep(500);
	 * atlnt.getMarketPros().click(); Thread.sleep(1000); //Verify Page opens
	 * successfully
	 * Assert.assertTrue(driver.getCurrentUrl().contains("Market-Pros"));
	 * System.out.println("Market Pros page link working as expected");
	 * Thread.sleep(1000);
	 * 
	 * //Ahead of the Curve utl.scrollToTop(); //Click on News And Trends Tab
	 * atlnt.getATLNewsAndTrendsTap().click(); Thread.sleep(500);
	 * atlnt.getATLatlAheadCurve().click(); Thread.sleep(1000);
	 * //Assert.assertTrue(atlnt.getATLAheadCurvePageHeader().getText().
	 * contains("Ahead of the Curve"));
	 * Assert.assertTrue(driver.getCurrentUrl().contains("Ahead-of-the-Curve"));
	 * System.out.println("Ahead of the Curve page link working as expected");
	 * Thread.sleep(1000);
	 * 
	 * //Press Releases utl.scrollToTop(); //Click on News And Trends Tab
	 * atlnt.getATLNewsAndTrendsTap().click(); Thread.sleep(500);
	 * atlnt.getATLPressReleases().click(); Thread.sleep(1000); //Click on Press
	 * Releases and Verify Page
	 * Assert.assertTrue(driver.getCurrentUrl().contains("Press-Center"));
	 * System.out.println("Press Releases page link working as expected");
	 * Thread.sleep(1000);
	 * 
	 * //Publications Library utl.scrollToTop(); //Click on News And Trends Tab
	 * atlnt.getATLNewsAndTrendsTap().click(); Thread.sleep(500);
	 * atlnt.getATLPublicationsLibrary().click(); Thread.sleep(1000); //Click on
	 * Publications Library and Verify Page
	 * Assert.assertTrue(driver.getCurrentUrl().contains("publications"));
	 * System.out.println("Publications Library page link working as expected");
	 * 
	 * //In the News utl.scrollToTop(); //Click on News And Trends Tab
	 * atlnt.getATLNewsAndTrendsTap().click(); Thread.sleep(500);
	 * atlnt.getATLInTheNewsPageHeader().click(); Thread.sleep(1000); //Click on In
	 * the News and Verify Page
	 * Assert.assertTrue(driver.getCurrentUrl().contains("In-the-News"));
	 * System.out.println("In The News page link working as expected");
	 * 
	 * //Blog Posts utl.scrollToTop(); //Click on News And Trends Tab
	 * atlnt.getATLNewsAndTrendsTap().click(); Thread.sleep(500);
	 * atlnt.getBlogPost().click(); Thread.sleep(1000); //Verify Page opens
	 * successfully Assert.assertTrue(driver.getCurrentUrl().contains("Blog"));
	 * System.out.println("Blog Posts link working as expected"); }
	 */

	/*
	 * @Test(priority=8) public void TS008_ATL_VerifyAllLinksUnderAttendTabTest()
	 * throws InterruptedException, IOException { //The purpose of this test case to
	 * verify:- //UXP-T012: To verify links for Attend tab at Header
	 * 
	 * mi = new UXPMarketInfoPage(driver); exhp = new
	 * UXPExhibitorsAndProductsTabPage(driver); atat = new ATLAttendPage(driver);
	 * 
	 * driver.get(prop.getProperty("atlmrkturl"));
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 * 
	 * //Click Attend tab at Header atat.getATLAttendTab().click();
	 * 
	 * //Click Why Attend tab under Attend section atat.getATLWhyAttend().click();
	 * Thread.sleep(2000); Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(),
	 * "Why Attend?");
	 * System.out.println("Why Attend section is displayed properly");
	 * Thread.sleep(2000); atat.getATLAttendTab().click();
	 * 
	 * //Click Registration tab under Attend section
	 * atat.getATLRegistration().click(); Thread.sleep(4000);
	 * Assert.assertTrue(driver.getCurrentUrl().contains("Register"));
	 * System.out.println("Registration section is displayed properly");
	 * Thread.sleep(2000); atat.getATLAttendTab().click();
	 * 
	 * Thread.sleep(2000); //Click Admission Policies under Attend section
	 * atat.getATLAdmissionPolicies().click(); Thread.sleep(5000);
	 * Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(),
	 * "Admission Policies");
	 * System.out.println("Admission Policies section is displayed properly");
	 * Thread.sleep(2000); atat.getATLAttendTab().click();
	 * 
	 * 
	 * //Click on Plan Your Market sub-menu atat.getATLPlanYourMarket().click();
	 * Thread.sleep(3000); //Verify that Plan Your Market page should be displayed
	 * Assert.assertTrue(driver.getTitle().contains("Plan Your Market"));
	 * System.out.println("Plan Your Market page is present"); Thread.sleep(2000);
	 * atat.getATLAttendTab().click(); Thread.sleep(200); //Click Travel under
	 * Attend section atat.getATLTravel().click(); Thread.sleep(3000);
	 * Assert.assertTrue(driver.getCurrentUrl().contains("Travel"));
	 * System.out.println("Travel section is displayed properly");
	 * Thread.sleep(2000); atat.getATLAttendTab().click(); Thread.sleep(2000);
	 * //Click Dining Guide under Attend section atat.getATLDiningGuide().click();
	 * Thread.sleep(3000); Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(),
	 * "Dining Guide");
	 * System.out.println("Dining Guide section is displayed properly");
	 * Thread.sleep(2000); atat.getATLAttendTab().click();
	 * 
	 * //Click on Events under Attend section atat.getATLEventsSubmenu().click();
	 * Thread.sleep(3000); Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(),
	 * "Events"); Thread.sleep(2000); atat.getATLAttendTab().click();
	 * 
	 * //Click Services and Amenities under Attend section
	 * atat.getATLServicesAndAmenities().click(); Thread.sleep(5000);
	 * Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(),
	 * "Services & Amenities");
	 * System.out.println("Services & Amenities section is displayed properly");
	 * atat.getATLAttendTab().click();
	 * 
	 * driver.get(prop.getProperty("atlmrkturl")); //utl.verifyCloseBtnPopup(); }
	 */

	@Test(enabled = false) // priority=1
	public void TS011_ATL_MarketRecap() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T798: Market Recap page opens successfully.
		lap = new UXPLandingPage(driver);

		// driver.get(prop.getProperty("atlmrkturl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Verify Market Recap link is working properly
		lap.getMarketRecap().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/Attend/App"));
		System.out.println("Market Recap page is working properly.");
	}

	@Test(enabled = false) // priority=2
	public void TS012_ATL_PlanYourMarkett() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-T783: To verify Exhibitor Directory
		lap = new UXPLandingPage(driver);
		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Verify Plan your market link is working properly
		lap.getplanYourMarket().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/Attend/App"));
		System.out.println("Plan Your Market page is working properly.");
	}

	// Due to re-branding changes
	@Test(enabled = false) // priority=1
	public void TS013_ATL_VerifyMarketPlannerLoginTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-001: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		utl = new Utility(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Login to Market Planner
		utl.verifyMPLoginFunctionality();

		// Verify that Market Planner Home page should be displayed
		Assert.assertTrue(lap.getMPLinkText().isDisplayed());
		// Thread.sleep(6000);
		utl.verifyCloseBtnPopup();
	}

	// Due to re-branding changes
	@Test(enabled = false) // priority=2
	public void TS014_ATL_VerifyMarketPlannerProfileAndSettingsOptionTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-002: To verify Profile and Settings option in Market Planner

		lap = new UXPLandingPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click Profile and Settings tab under Market Planner and verify result
		// Thread.sleep(5000);
		atlps.getATLWelcomeText().click();

		atlps.getATLProfileAndSettings().click();
		// Thread.sleep(6000);
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl") + "Profile"));
		System.out.println("Profile and Settings section options are displayed properly");
	}

	// Due to re-branding changes
	@Test(enabled = false) // priority=4
	public void TS015_ATL_VerifyMarketPlannerRegistrationsOptionTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-004: To verify Registrations option in Top Header

		lap = new UXPLandingPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);
		atlregp = new ATLRegistrationsPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on Welcome text
		atlps.getATLWelcomeText().click();

		// Click Registrations option in Top Header
		atlregp.getATLRegistrationsOptn().click();

		// Verify that user should redirect to the 'Registration Info' page.
		Assert.assertTrue(atlregp.getATLRegistrationsInfoTab().isDisplayed());

		// Sign out from Market Planner
		atlps.getATLWelcomeText().click();
		lap.getMPSignOutBtn().click();
		// Thread.sleep(10000);
		utl.verifyCloseBtnPopup();
	}

	/*
	 * @AfterSuite public void sendEmail() { se = new SendEmail();
	 * se.sendEmailWithAttachment(); }
	 */

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}