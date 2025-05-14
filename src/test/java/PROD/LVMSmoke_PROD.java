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
		utl.windowHandle(hd.getAtlantaApparel(), "https://www.atlanta-apparel.com/");
		
		// Check Spring/Fall Cash and Carry
		hd.getAtlanta().click();
		try {
		utl.windowHandle(hd.getCashAndCarryMarketsSpringandFall(), "Spring-Cash-and-Carry");
		}catch (Exception e) {
			utl.windowHandle(hd.getFllCashAndCarryMarketsSpringandFall(), "Fall-Cash-and-Carry");
		}
		
		// Check Atlanta Market
		hd.getAtlanta().click();
		utl.windowHandle(hd.getAtlantaMarket(), "https://www.atlantamarket.com/");
		
		// Check Formal Markets
		hd.getAtlanta().click();
		utl.windowHandle(hd.getFormalMarkets(), "Formal-Markets");
		
		// Check ADAC
		hd.getAtlanta().click();
		utl.windowHandle(hd.getCasualMarketAtlantaURL(), "https://casualmarketatlanta.com/");
		
		// Check ADAC
		hd.getAtlanta().click();
		utl.windowHandle(hd.getADAC(), "https://adacatlanta.com/");
		
		// Check AmericasMart
		hd.getAtlanta().click();
		utl.windowHandle(hd.getAmericasMart(), "https://www.americasmart.com/");
		
		// Check Atlanta Convention Center
		hd.getAtlanta().click();
		utl.windowHandle(hd.getAtlantaConventionCenter(), "https://www.atlconventioncenter.com/");
		
	// Verify that Las Vegas link is present
		Assert.assertTrue(hd.getLasVegas().getText().equalsIgnoreCase("LAS VEGAS"));
		
		// Check Las Vegas Market
		hd.getLasVegas().click();
		utl.windowHandle(hd.getLasVegasMarket(), "https://www.lasvegasmarket.com/");
		
		// Check Las Vegas Apparel
		hd.getLasVegas().click();
		utl.windowHandle(hd.getLasVegasApparel(), "https://www.lasvegas-apparel.com/");
		
		// Check Las Vegas Design Center (LVDC)
		hd.getLasVegas().click();
		utl.windowHandle(hd.getLasVegasDesignCenter(), "LVDC");
		
		// Check EXPO at World Market Center Las Vegas
		hd.getLasVegas().click();
		utl.windowHandle(hd.getEXPOatWorldMarketCenterLasVegas(), "https://www.expowmclv.com/");
		
	// Verify that High Point link is present
		Assert.assertTrue(hd.getHighPoint().getText().equalsIgnoreCase("HIGH POINT"));
		
		// Check ANDMORE at High Point Market
		hd.getHighPoint().click();
		utl.windowHandle(hd.getANDMOREatHighPointMarket(), "https://www.andmorehighpointmarket.com/");
		
		
	// Verify that New York link is present
		Assert.assertTrue(hd.getNewYork().getText().equalsIgnoreCase("NEW YORK"));

		// Check SHOPPE OBJECT
		hd.getNewYork().click();
		utl.windowHandle(hd.getSHOPPEOBJECT(), "shoppeobject.com");
		
		
	// Click on Register Btn
		utl.clickAndAssertUrl(hd.getRigisterBtn());
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		System.out.println("Register Btn Verifed");
		
	// Click on Sign in Btn
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
		Thread.sleep(8000);
		utl.scrollToBottom();
	
		// Market Information
		utl.windowHandle(fl.getmarketInfo(), "About");
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Press Center
		utl.windowHandle(fl.getpressCenterAMC(), "Press-Center");
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Download the ANDMORE Markets App 
		utl.windowHandle(fl.getDownloadTheApp(), "Plan-Your-Market");
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Our Brands
		utl.windowHandle(fl.getOurBrandsATL(), "exhibitor-directory");
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Contact Us
		utl.windowHandle(fl.getContactUsATL(), "Contact-Us");
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();

		//Careers
		utl.windowHandle(fl.getCareersATL(), "andmore.com/our-team");
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//AmericasMart
		utl.windowHandle(fl.getAmericasMart_ATLAppFooter(), "americasmart.com");
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Atlanta Apparel
		utl.windowHandle(fl.getAtlantaApparel(), "atlanta-apparel.com");
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Atlanta Market
		utl.windowHandle(fl.getAtlantaMarket(), "atlantamarket.com");
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Casual Market Atlanta
		utl.windowHandle(fl.getCasualMarketAtlanta(), "casualmarketatlanta.com");
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Las Vegas Apparel
		utl.windowHandle(fl.getlvapplink_ATL(), "lasvegas-apparel.com");
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//ANDMORE at High Point Market
		utl.windowHandle(fl.getHighPointMarket(), "andmorehighpointmarket.com");
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//ANDMORE
		utl.windowHandle(fl.getandmore(), "https://www.andmore.com/");
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Terms & Conditions
		utl.windowHandle(fl.getTermsAndConditions(), "terms-of-use");
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();

		//Privacy Policy
		utl.windowHandle(fl.getatlprivacypolicy(), "privacy-policy");

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
