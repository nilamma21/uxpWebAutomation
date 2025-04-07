package PROD;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.LasVegasMarket.UXPAttendPage;
import pageObjects.LasVegasMarket.UXPExhibitPage;
import pageObjects.LasVegasMarket.UXPExhibitorDirectoryPage;
import pageObjects.LasVegasMarket.UXPExhibitorsAndProductsTabPage;
import pageObjects.LasVegasMarket.UXPExploreMarketPage;
import pageObjects.LasVegasMarket.UXPFooterLinksNavigationPage;
import pageObjects.LasVegasMarket.UXPGlobalSearchPage;
import pageObjects.LasVegasMarket.UXPHeaderChannelLinksPage;
import pageObjects.LasVegasMarket.UXPLandingPage;
import pageObjects.LasVegasMarket.UXPLoginPage;
import pageObjects.LasVegasMarket.UXPMarketInfoPage;
import pageObjects.LasVegasMarket.UXPProfileAndSettingsPage;
import pageObjects.LasVegasMarket.UXPYearRoundPage;
import resources.GenerateData;
import resources.SendEmail;
import resources.Utility;
import resources.base;

@Listeners({ TestListeners.class })
public class LVMSmoke_PROD extends base {

	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	UXPLandingPage lap;
	UXPLoginPage lp;
	UXPExhibitPage exh;
	UXPExhibitorsAndProductsTabPage exhp;
	UXPProfileAndSettingsPage ps;
	UXPMarketInfoPage mi;
	UXPExploreMarketPage expmrkt;
	UXPGlobalSearchPage gs;
	UXPFooterLinksNavigationPage fl;
	UXPExhibitorDirectoryPage ed;
	UXPAttendPage at;
	UXPYearRoundPage yr;
	UXPHeaderChannelLinksPage hd;
	SendEmail se;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver(); // requires for Parallel text execution
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);
		
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(10000);
		lap.getIUnderstandBtn().click();
		utl.waitForPageToLoad();
		/*
		 * Thread.sleep(2000); utl.verifyCloseBtnPopup();
		 */

		/*
		 * driver.get(prop.getProperty("lvmurl")); lap.getIUnderstandBtn().click();
		 * Thread.sleep(3000); utl.verifyCloseBtnPopup();
		 */
	}

	@Test(priority = 1)
	public void TS001_LVM_VerifyHeaderChannelLinksTest() throws InterruptedException, IOException {

		// The purpose of this test case to verify:-
		// UXP-: To verify header channel links
		hd = new UXPHeaderChannelLinksPage(driver);
		exh = new UXPExhibitPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(7000);
		// Verify that Atlanta link is present
		Assert.assertTrue(hd.getAtlanta().getText().equalsIgnoreCase("ATLANTA"));
		Thread.sleep(1000);
		// Check Atlanta Apparel
		hd.getAtlanta().click();
		Thread.sleep(1000);
		Assert.assertTrue(hd.getAtlantaApparel().getText().contains("Atlanta Apparel"));
		hd.getAtlantaApparel().click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getTitle().contains("Atlanta Apparel"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);

		// Check Casual Market Atlanta //Check Casual Market Atlanta
		hd.getAtlanta().click();
		try {
			//For Spring Cash and Carry
		Assert.assertTrue(hd.getCashAndCarryMarketsSpringandFall().getText().equalsIgnoreCase("Spring Cash & Carry"));
		hd.getCashAndCarryMarketsSpringandFall().click();
		Assert.assertTrue(driver.getTitle().contains("Spring Cash & Carry"));
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(2000);
		}catch (Exception e) {
			//For Fall Cash and Carry
			Assert.assertTrue(hd.getFllCashAndCarryMarketsSpringandFall().getText().equalsIgnoreCase("Fall Cash & Carry"));
			hd.getFllCashAndCarryMarketsSpringandFall().click();
			Assert.assertTrue(driver.getTitle().contains("Fall Cash & Carry"));
			driver.get(prop.getProperty("lvmappurl"));
			Thread.sleep(2000);
		}

		// Check Atlanta Market
		hd.getAtlanta().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getAtlantaMarket().getText().equalsIgnoreCase("Atlanta Market"));
		hd.getAtlantaMarket().click();
		Assert.assertTrue(driver.getTitle().contains("Atlanta Market"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);

		// Check Formal Markets
		hd.getAtlanta().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getFormalMarkets().getText().equalsIgnoreCase("Formal Markets"));
		hd.getFormalMarkets().click();
		Assert.assertTrue(driver.getTitle().contains("Formal Markets"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);

		// Check Mid-Season Buying Event: Fall Market hd.getAtlanta().click();
		/*
		 * Thread.sleep(2000);
		 * Assert.assertTrue(hd.getMidSeasonBuyingEventFallMarket().getText().
		 * equalsIgnoreCase("Mid-Season Buying Event: Fall Market"));
		 * hd.getMidSeasonBuyingEventFallMarket().click();
		 * Assert.assertTrue(driver.getTitle().contains("Fall Market at AmericasMart"));
		 * driver.get(prop.getProperty("lvmurl")); Thread.sleep(2000);
		 */
		hd.getAtlanta().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getCasualMarketAtlantaURL().getText().equalsIgnoreCase("Casual Market Atlanta"));
		hd.getCasualMarketAtlantaURL().click();
		Assert.assertTrue(driver.getTitle().contains("Casual Market Atlanta"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);

		/*
		 * hd.getAtlanta().click(); Thread.sleep(2000); try {
		 * Assert.assertTrue(hd.getCashAndCarryMarketsSpringandFall().getText().
		 * equalsIgnoreCase("Cash & Carry Markets: Spring and Fall"));
		 * hd.getCashAndCarryMarketsSpringandFall().click();
		 * Assert.assertTrue(driver.getTitle().contains("Spring Cash & Carry"));
		 * driver.get(prop.getProperty("lvmurl")); Thread.sleep(2000); }catch (Exception
		 * e) { Assert.assertTrue(hd.getFllCashAndCarryMarketsSpringandFall().getText().
		 * equalsIgnoreCase("Fall Cash & Carry"));
		 * hd.getFllCashAndCarryMarketsSpringandFall().click();
		 * Assert.assertTrue(driver.getTitle().contains("Fall Cash & Carry"));
		 * driver.get(prop.getProperty("lvmurl")); Thread.sleep(2000); }
		 */

		// Check ADAC
		hd.getAtlanta().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getADAC().getText().equalsIgnoreCase("ADAC"));
		hd.getADAC().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("ADAC"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);

		// Check AmericasMart
		hd.getAtlanta().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getAmericasMart().getText().equalsIgnoreCase("AmericasMart"));
		hd.getAmericasMart().click();
		Assert.assertTrue(driver.getTitle().contains("Wholesale Gift, Home, Rug and Apparel Markets"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);

		// Check Atlanta Convention Center
		hd.getAtlanta().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getAtlantaConventionCenter().getText().equalsIgnoreCase("Atlanta Convention Center"));
		hd.getAtlantaConventionCenter().click();
		Assert.assertTrue(driver.getTitle().contains("Atlanta Convention Center"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		// Check Formal Markets
		hd.getAtlanta().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getFormalMarkets().getText().equalsIgnoreCase("Formal Markets"));
		hd.getFormalMarkets().click();
		Assert.assertTrue(driver.getTitle().contains("Formal Markets"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);

		// Verify that Las Vegas link is present
		Assert.assertTrue(hd.getLasVegas().getText().equalsIgnoreCase("LAS VEGAS"));

		// Check Las Vegas Market
		hd.getLasVegas().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getLasVegasMarket().getText().equalsIgnoreCase("Las Vegas Market"));
		hd.getLasVegasMarket().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Market"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);

		// Check Las Vegas Apparel
		hd.getLasVegas().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getLasVegasApparel().getText().equalsIgnoreCase("Las Vegas Apparel"));
		hd.getLasVegasApparel().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Apparel"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(3000);

		// Check Las Vegas Design Center (LVDC)
		hd.getLasVegas().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getLasVegasDesignCenter().getText().equalsIgnoreCase("Las Vegas Design Center (LVDC)"));
		hd.getLasVegasDesignCenter().click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Year-Round/LVDC"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(3000);

		// Check EXPO at World Market Center Las Vegas
		hd.getLasVegas().click();
		Assert.assertTrue(hd.getEXPOatWorldMarketCenterLasVegas().getText().equalsIgnoreCase("EXPO at World Market Center Las Vegas"));
		hd.getEXPOatWorldMarketCenterLasVegas().click();
		Thread.sleep(1000);
		System.out.println("Title of page: "+driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("The Expo At World Market Center"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);

		// Verify that High Point link is present
		Assert.assertTrue(hd.getHighPoint().getText().equalsIgnoreCase("HIGH POINT"));

		// Check ANDMORE at High Point Market
		hd.getHighPoint().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getANDMOREatHighPointMarket().getText().equalsIgnoreCase("ANDMORE at High Point Market"));
		hd.getANDMOREatHighPointMarket().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("andmorehighpointmarket.com"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);

		// Check SHOPPE OBJECT High Point
		hd.getHighPoint().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getSHOPPEOBJECTHighPoint().getText().equalsIgnoreCase("SHOPPE OBJECT High Point"));
		hd.getSHOPPEOBJECTHighPoint().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("shoppeobject.com"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);

		// Verify that New York link is present
		Assert.assertTrue(hd.getNewYork().getText().equalsIgnoreCase("NEW YORK"));

		// Check SHOPPE OBJECT
		hd.getNewYork().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getSHOPPEOBJECT().getText().equalsIgnoreCase("SHOPPE OBJECT"));
		hd.getSHOPPEOBJECT().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("shoppeobject.com"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		
		//Click on Register Btn
		utl.clickAndAssertUrl(hd.getRigisterBtn());
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		System.out.println("Register Btn Verifed");
		
		//Click on Sign in Btn
		
		hd.getSignInBtn().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("Sign In"));
		System.out.println("Sign In Btn Verifed");
	}

	@Test(priority = 02)
	public void TS002_LVM_VerifAllLinksUnderExhibitorDirectoryTabTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-002: To verify the Exhibit menu overview and it's functionality

		ed = new UXPExhibitorDirectoryPage(driver);

		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		
	//Search Exhibitors
		ed.getExhibitorDirectory().click();
		utl.clickAndAssertUrl(ed.getEDSearchExhibitors());
		
	//A-Z Brand Listing
		ed.getExhibitorDirectory().click();
		utl.clickAndAssertUrl(ed.getEDAZBrandListing());
		
	//Floor Plans
		ed.getExhibitorDirectory().click();
		utl.clickAndAssertUrl(ed.getEDFloorPlans());
		
	//Popular Filters
		ed.getExhibitorDirectory().click();
		utl.clickAndAssertUrl(ed.getEDPopularFilters());
		
	}

	@Test(priority = 03)
	public void TS003_LVM_VerifAllLinksUnderVisitTabTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-002: To verify the Exhibit menu overview and it's functionality

		lap = new UXPLandingPage(driver);
		exh = new UXPExhibitPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();

		Thread.sleep(5000);
	//Register
		exh.getvisitTabNew().click();
		utl.clickAndAssertUrl(exh.getRegisterUnderVisitTab());
		
	//Market Dates & Hours
		exh.getvisitTabNew().click();
		utl.clickAndAssertUrl(exh.getMarketDatesHoursUnderVisitTab());
		
	//About Market
		exh.getvisitTabNew().click();
		utl.clickAndAssertUrl(exh.getVisitAboutUnderVisitTab());
		
	//Plan Your Market
		exh.getvisitTabNew().click();
		utl.clickAndAssertUrl(exh.getMarketPlanUnderVisitTab());
		
	//Travel
		exh.getvisitTabNew().click();
		utl.clickAndAssertUrl(exh.getTravelUnderVisitTab());
		
	//Dining
		exh.getvisitTabNew().click();
		utl.clickAndAssertUrl(exh.getDiningUnderVisitTab());
		
	//Services & Amenities
		exh.getvisitTabNew().click();
		utl.clickAndAssertUrl(exh.getServicesAmenitiesUnderVisitTab());
		
	//FAQs
		exh.getvisitTabNew().click();
		utl.clickAndAssertUrl(exh.getFAQsUnderVisitTab());
		
	//Events
		exh.getvisitTabNew().click();
		utl.clickAndAssertUrl(exh.getEventUnderVisitTab());

	}

	@Test(priority = 04)
	public void TS004_LVM_VerifAllLinksUnderDiscoverTabTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-002: To verify the Exhibit menu overview and it's functionality

		lap = new UXPLandingPage(driver);
		exh = new UXPExhibitPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();

		
	//Exhibitor Directory
		Thread.sleep(5000);
		exh.getdiscoverTabNew().click();
		utl.clickAndAssertUrl(exh.getExhibitorDirectoryUnderDiscoverTab());
		
	//A to Z brand list
		exh.getdiscoverTabNew().click();
		Thread.sleep(2000);
		utl.clickAndAssertUrl(exh.getatoZBrandList());
		
	//Floor plans
		exh.getdiscoverTabNew().click();
		Thread.sleep(2000);
		utl.clickAndAssertUrl(exh.getfloorPlans());
		
	//Explore Las Vegas Market
		exh.getdiscoverTabNew().click();
		Thread.sleep(2000);
		utl.clickAndAssertUrl(exh.getExploreLasVegasMarketUnderDiscoverTab());
		
	//Tools and Inspiration
		exh.getdiscoverTabNew().click();
		Thread.sleep(2000);
		utl.clickAndAssertUrl(exh.getToolsAndInspirationUnderDiscoverTab());
		
	//Plan Your market
		exh.getdiscoverTabNew().click();
		utl.clickAndAssertUrl(exh.getPlanYourMarketUnderDiscoverTab());
		
	//What's New
		exh.getdiscoverTabNew().click();
		Thread.sleep(2000);
		utl.clickAndAssertUrl(exh.getWhatsNewUnderDiscoverTab());
		
	//Events
		exh.getdiscoverTabNew().click();
		Thread.sleep(2000);
		utl.clickAndAssertUrl(exh.getEventsUnderDiscoverTab());

	}

	@Test(priority = 05)
	public void TS005_LVM_VerifAllLinksUnderExhibitTabTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-002: To verify the Exhibit menu overview and it's functionality

		lap = new UXPLandingPage(driver);
		exh = new UXPExhibitPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);

		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		
	//Exhibit at Las Vegas Market
		exh.getexhibittabNew().click();
		String urlString = exh.getexhibitAtLVM().getAttribute("href");
		// Click on Exhibitor Dire
		exh.getexhibitAtLVM().click();
		Assert.assertTrue(driver.getCurrentUrl().contains(urlString));
		Thread.sleep(5000);

	//Exhibitor Resources
		exh.getexhibittabNew().click();
		utl.clickAndAssertUrl(exh.getexhibitAtResources());
		Thread.sleep(5000);

	//Marketing Toolkit
		exh.getexhibittabNew().click();
		// Click on Marketing Tool Kits
		utl.clickAndAssertUrl(exh.getmarketingToolKit());
		Thread.sleep(5000);

	//Advertising & Sponsorship Opportunities
		exh.getexhibittabNew().click();
		utl.clickAndAssertUrl(exh.getadvertisingAndSponsAndOpprtu());
		Thread.sleep(5000);
		
	//Already an Exhibitor? Sign In
		exh.getexhibittabNew().click();
		Thread.sleep(1000);
		String winHandleBefore = driver.getWindowHandle();
		exh.getalreadyAnExhibitor().click();
		Thread.sleep(5000);
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("Sign In to ANDMORE"));
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
	}

	@Test(priority = 06)
	public void TS006_LVM_VerifAllLinksUnderSourceYearRoundTabTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-002: To verify the Source Year Round menu overview and it's functionality

		lap = new UXPLandingPage(driver);
		exh = new UXPExhibitPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		utl = new Utility(driver);

		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		
	//Year Round
		exh.getsourceYearRoundTabNew().click();
		utl.clickAndAssertUrl(exh.getYearRoundUndersourceYearRoundTab());
		
	//Exhibitor Directory
		exh.getsourceYearRoundTabNew().click();
		utl.clickAndAssertUrl(exh.getexhibitorDirectoryUnderSourceYearTab());
		
	//A-Z Brand Listing
		exh.getsourceYearRoundTabNew().click();
		utl.clickAndAssertUrl(exh.getatoZBrandListUnderSourceYearTab());
		
	//Floor Plans
		exh.getsourceYearRoundTabNew().click();
		utl.clickAndAssertUrl(exh.getfloorPlansUnderSourceYearTab());
		
	//Contact Us
		exh.getsourceYearRoundTabNew().click();
		utl.clickAndAssertUrl(exh.getContactUsUnderSourceYearTab());
	}

	@Test(priority = 07)
	public void TS007_LVM_VerifyAllSocialMediaLinksOnFooterTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-013: To verify the all social media links and it's redirection

		fl = new UXPFooterLinksNavigationPage(driver);
		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		// Scroll till footer links
		// utl.scrollElementIntoMiddle(fl.getlvmfooterLinkAbout());
		utl.scrollToBottom();
		Thread.sleep(1000);
		// In app footer click on 'Facebook' icon and verify results
		fl.getFacebookIcon().click();
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		// Thread.sleep(10000);
		// Verify that 'LVM Facebook' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/lvmarket"));
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		// Click on Instagram icon
		/*
		 * fl.getInstagramIcon().click(); // Switch to new window opened for(String
		 * winHandle : driver.getWindowHandles()){ driver.switchTo().window(winHandle);
		 * } Thread.sleep(10000); //Verify that 'LVM Instagram' page should be displayed
		 * Assert.assertTrue(driver.getCurrentUrl().contains(
		 * "https://www.instagram.com/lasvegasmarket/")); // Close the new window, if
		 * that window no more required driver.close(); // Switch back to original
		 * browser (first window) driver.switchTo().window(winHandleBefore);
		 * 
		 * //Click on You Tube icon fl.getYouTubeIcon().click();
		 * 
		 * // Switch to new window opened for(String winHandle :
		 * driver.getWindowHandles()){ driver.switchTo().window(winHandle); }
		 * Thread.sleep(10000); //Verify that 'LVM You Tube' page should be displayed
		 * Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com"))
		 * ;
		 * 
		 * // Close the new window, if that window no more required driver.close();
		 * 
		 * // Switch back to original browser (first window)
		 * driver.switchTo().window(winHandleBefore);
		 * 
		 * //Click on Pinterest icon fl.getPinterestIcon().click();
		 * 
		 * // Switch to new window opened for(String winHandle :
		 * driver.getWindowHandles()){ driver.switchTo().window(winHandle); }
		 * Thread.sleep(10000); //Verify that 'LVM You Tube' page should be displayed
		 * Assert.assertTrue(driver.getCurrentUrl().contains(
		 * "https://www.pinterest.com/lasvegasmarket/"));
		 * 
		 * // Close the new window, if that window no more required driver.close();
		 * 
		 * // Switch back to original browser (first window)
		 * driver.switchTo().window(winHandleBefore);
		 * 
		 * //Click on Twitter icon fl.getTwitterIcon().click();
		 * 
		 * // Switch to new window opened for(String winHandle :
		 * driver.getWindowHandles()){ driver.switchTo().window(winHandle); }
		 * Thread.sleep(10000); //Verify that 'LVM Twitter' page should be displayed
		 * Assert.assertTrue(driver.getCurrentUrl().contains(
		 * "https://www.twitter.com/lasvegasmarket/"));
		 * 
		 * // Close the new window, if that window no more required driver.close();
		 * 
		 * // Switch back to original browser (first window)
		 * driver.switchTo().window(winHandleBefore);
		 * 
		 * //Click on LinkedIn icon fl.getLinkedInIcon().click();
		 * 
		 * // Switch to new window opened for(String winHandle :
		 * driver.getWindowHandles()){ driver.switchTo().window(winHandle); }
		 * Thread.sleep(10000); //Verify that 'LVM Twitter' page should be displayed
		 * Assert.assertTrue(driver.getCurrentUrl().contains("https://www.linkedin.com/"
		 * ));
		 * 
		 * // Close the new window, if that window no more required driver.close();
		 * 
		 * // Switch back to original browser (first window)
		 * driver.switchTo().window(winHandleBefore);
		 */
	}

	@Test(priority=8)
	public void TS008_LVM_VerifyGlobalSearchFunctionalityTest() throws InterruptedException, IOException
	{
		// The purpose of this test case to verify:-
		// UXP-T63: To verify global search functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		ps = new UXPProfileAndSettingsPage(driver);
		gs = new UXPGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		gs.getGlobalSearchTextBoxNew().click();
		Thread.sleep(5000);
		try {
			gs.getGlobalSearchEnterText().isDisplayed();
			gs.getGlobalSearchEnterText().sendKeys((prop.getProperty("exhibitordirectory")));
			Thread.sleep(1000);
			gs.getSearchButtonNew().click();
			Thread.sleep(5000);
			String searchterm = gs.getVerifyGlobalSeacrhNew().getText();
			Assert.assertTrue(searchterm.contains(prop.getProperty("exhibitordirectory")));
			System.out.println("Global Search functionality is working properly.");
		} catch (Exception e) {

			gs.getGlobalSearchTextBoxNew().click();

			gs.getGlobalSearchEnterText().sendKeys((prop.getProperty("exhibitordirectory")));
			Thread.sleep(1000);
			gs.getSearchButtonNew().click();
			Thread.sleep(5000);
			String searchterm = gs.getVerifyGlobalSeacrhNew().getText();
			System.out.println(searchterm);
			Assert.assertTrue(searchterm.contains(prop.getProperty("exhibitordirectory")));
			System.out.println("Global Search functionality is working properly.");
		}
	}
	
	
	@Test(priority= 9) // previous priority= 8
	public void TS009_LVM_VerifyFooterLinksTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T69: To verify Footer Links Navigation
		
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		fl = new UXPFooterLinksNavigationPage(driver);
		
		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(7000);
		//Scroll till footer links
	      utl.scrollToElement(fl.getlvmfooterLinkAbout());
		  utl.clickAndAssertUrl(fl.getlvmfooterLinkAbout()); //Click about link
		  driver.get(prop.getProperty("lvmurl")); //utl.verifyCloseBtnPopup();
		  Thread.sleep(3000);
		  utl.scrollToElement(fl.getlvmfooterLinkAbout());
		  
		  // Click on Press Center 
		  utl.scrollToElement(fl.getlvmfooterLinkAbout());
		  utl.clickAndAssertUrl(fl.getlvmfooterLinkPressCenter()); //Click Press link
		  driver.get(prop.getProperty("lvmurl")); //utl.verifyCloseBtnPopup();
		  Thread.sleep(3000);
		  utl.scrollToElement(fl.getlvmfooterLinkAbout());
		  
		  // Click on Our Brands 
		  utl.scrollToElement(fl.getlvmfooterLinkAbout());
		  utl.clickAndAssertUrl(fl.getlvmfooterLinkOurBrands()); //Click our brands
		  driver.get(prop.getProperty("lvmurl")); 
		  Thread.sleep(3000);
		  //utl.verifyCloseBtnPopup();
		  utl.scrollToElement(fl.getlvmfooterLinkAbout());
		  
		  // Click on Our Brands 
		  utl.scrollToElement(fl.getlvmfooterLinkAbout());
		  utl.clickAndAssertUrl(fl.getDownloadTheApp()); //Click Download The App link
		  driver.get(prop.getProperty("lvmurl"));
		  Thread.sleep(3000);
		  //utl.verifyCloseBtnPopup(); 
		  utl.scrollToElement(fl.getContactUs());
		  
		 
		// Click Contact Us link and verify results
		fl.getContactUs().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/contact-us"));
		driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		Thread.sleep(3000);
		utl.scrollToElement(fl.getlvmfooterLinkAbout());

		// Click Careers link and verify results.
		String winHandleBefore14 = driver.getWindowHandle();
		fl.getCareersATL().click();
		Thread.sleep(1000);
		for (String winHandle14 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle14);
		}
		Thread.sleep(6000);
		Assert.assertTrue(driver.getCurrentUrl().contains("www.andmore.com/our-team"));
		driver.close();
		driver.switchTo().window(winHandleBefore14);
		
		
		// Click on Terms & conditions link
		
		// Switch to new tab
		String winHandleBefore7 = driver.getWindowHandle();
		fl.getTermsAndConditions().click();
		Thread.sleep(1000);
		for (String winHandle7 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle7);
		}
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("terms-of-use"));
		driver.close();
		driver.switchTo().window(winHandleBefore7);
		
		// Click Privacy Policy and verify results
		/*driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getlvmfooterLinkAbout());*/
		// Click Privacy Policy link and verify results
		
		String winHandleBefore8 = driver.getWindowHandle();
		fl.getlvmfooterLinkPrivacyPolicy().click();
		Thread.sleep(1000);
		for (String winHandle8 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle8);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("privacy-policy"));
		driver.close();
		driver.switchTo().window(winHandleBefore8);
		/*driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getlvmfooterLinkAbout());*/

		// Click Americas Mart link and verify results
		
		String winHandleBefore9 = driver.getWindowHandle();
		fl.getAmericasMart_ATLApp().click();
		Thread.sleep(1000);
		for (String winHandle9 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle9);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore9);
		/*driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getlvmfooterLinkAbout());*/

		// Click Atlanta Apparel link and verify results
	
		// Switch to new tab
		String winHandleBefore2 = driver.getWindowHandle();
		fl.getAtlantaApparel().click();
		Thread.sleep(1000);
		for (String winHandle2 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle2);
		}
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore2);
		/*driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getlvmfooterLinkAbout());
		 */
		// Click Atlanta Market link and verify results
		
		// Switch to new tab
		String winHandleBefore3 = driver.getWindowHandle();
		fl.getAtlantaMarket().click();
		Thread.sleep(1000);
		for (String winHandle3 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle3);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore3);
		/*driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getlvmfooterLinkAbout());*/

		// Click on High Point Market link
		// Switch to new tab
		String winHandleBefore4 = driver.getWindowHandle();
		fl.getHighPointMarket().click();
		Thread.sleep(1000);
		for (String winHandle4 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle4);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmorehighpointmarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore4);
		/*driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getlvmfooterLinkAbout());*/

		// Click on LVA Market link
		// Switch to new tab
		driver.navigate().refresh();
		Thread.sleep(5000);
		utl.scrollToBottom();
		String winHandleBefore5 = driver.getWindowHandle();
		fl.getlvapplink_ATL().click();
		Thread.sleep(1000);
		for (String winHandle4 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle4);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore5);
	
		/*driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getlvmfooterLinkAbout());*/

		// Click International Market Centers link and verify results
		//fl.getInternationalMarketCenters().click();//Change for re-branding
		
		// Switch to new tab
		String winHandleBefore11 = driver.getWindowHandle();
		fl.getandmore().click();
		Thread.sleep(1000);
		for (String winHandle11 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle11);
		}
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore11);
		/*driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getlvmfooterLinkAbout());*/

		// Click Juniper Market Centers link and verify results
		/*fl.getJuniperMarket().click();
		// Switch to new tab
		String winHandleBefore12 = driver.getWindowHandle();
		for (String winHandle12 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle12);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.junipermarket.com/"));
		//driver.close();
		driver.switchTo().window(winHandleBefore12);
		driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getlvmfooterLinkAbout());*/

	}
	@Test(priority = 10)
	public void TS010_LVM_VerifRegisterButtonTest() throws InterruptedException, IOException {
		// The purpose of this test case to verify:-
		// UXP-002: To verify the Source Year Round menu overview and it's functionality

		lap = new UXPLandingPage(driver);
		exh = new UXPExhibitPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		utl = new Utility(driver);
		hd = new UXPHeaderChannelLinksPage(driver);

		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		//click on Register Btn
		utl.clickAndAssertUrl(hd.getRigisterBtn());
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}
