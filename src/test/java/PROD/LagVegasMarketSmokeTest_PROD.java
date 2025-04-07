package PROD;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
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

@Listeners({TestListeners.class})
public class LagVegasMarketSmokeTest_PROD extends base {
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

	@BeforeClass
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);

		driver.manage().window().maximize();
		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		lap.getIUnderstandBtn().click();
		Thread.sleep(3000);
		utl.verifyCloseBtnPopup();
		
/*		driver.get(prop.getProperty("lvmurl"));
		lap.getIUnderstandBtn().click();
		Thread.sleep(3000);
		utl.verifyCloseBtnPopup();*/
	}

	
	@Test(priority=1)
	public void TS001_LVM_VerifyHeaderChannelLinksTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-: To verify header channel links
		hd = new UXPHeaderChannelLinksPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Old Code
/*		
		//Click Atlanta Market channel link and verify result
		Thread.sleep(5000);
		hd.getAtlantaMarket().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Market at AmericasMart"));
		System.out.println("Atlanta Market channel link is working properly.");
		driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();

		//Click Atlanta Apparel channel link and verify result

		hd.getAtlantaApparel().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Apparel at AmericasMart"));
		System.out.println("Atlanta Apparel channel link is working properly.");
		driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();

		//Click Americas Mart channel link and verify result

		hd.getAmericasMart().click();
		Thread.sleep(000);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Wholesale Gift, Home, Rug and Apparel Markets"));
		System.out.println("Americas Mart channel link is working properly.");
		driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();

		//Click IMC High Point Market channel link and verify result

		hd.getHighPoint().click();
		Thread.sleep(7000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmorehighpointmarket.com/"));
		System.out.println("IMC High Point channel link is working properly.");
		driver.get(prop.getProperty("lvmurl"));

		//Click Lav Vegas Market channel link and verify result

		hd.getLasVegas().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas"));
		System.out.println("Las Vegas Market channel link is working properly.");
*/
		
		//New Code for Header Channel Links

		//Verify that Atlanta link is present
		Assert.assertTrue(hd.getAtlanta().getText().equalsIgnoreCase("ATLANTA"));
		
		//Check Atlanta Apparel
		hd.getAtlanta().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getAtlantaApparel().getText().equalsIgnoreCase("Atlanta Apparel"));
		hd.getAtlantaApparel().click();
		Assert.assertTrue(driver.getTitle().contains("Atlanta Apparel"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);

		//Check Casual Market Atlanta
		//Check Casual Market Atlanta
//		hd.getAtlanta().click();
//		Thread.sleep(2000);
//		Assert.assertTrue(hd.getCasualMarketAtlanta().getText().equalsIgnoreCase("Fall Casual Market Atlanta"));
//		String casualURl=hd.getCasualMarketAtlantaURL().getAttribute("href");
//		hd.getCasualMarketAtlanta().click();
//		Thread.sleep(3000);
//		Assert.assertTrue(driver.getCurrentUrl().contains(casualURl));
//		
//		driver.get(prop.getProperty("lvmappurl"));
//		Thread.sleep(2000);
		
		//Check Atlanta Market
		hd.getAtlanta().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getAtlantaMarket().getText().equalsIgnoreCase("Atlanta Market"));
		hd.getAtlantaMarket().click();
		Assert.assertTrue(driver.getTitle().contains("Atlanta Market"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
	/*	//Check Formal Markets
		hd.getAtlanta().click();
		Thread.sleep(500);
		Assert.assertTrue(hd.getFormalMarkets().getText().equalsIgnoreCase("Formal Markets"));
		hd.getFormalMarkets().click();
		Assert.assertTrue(driver.getTitle().contains("Formal Markets"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);*/
		
		//Check Mid-Season Buying Event: Fall Market
//		hd.getAtlanta().click();
//		Thread.sleep(2000);
//		Assert.assertTrue(hd.getMidSeasonBuyingEventFallMarket().getText().equalsIgnoreCase("Mid-Season Buying Event: Fall Market"));
//		hd.getMidSeasonBuyingEventFallMarket().click();
//		Assert.assertTrue(driver.getTitle().contains("Fall Market at AmericasMart"));
//		driver.get(prop.getProperty("lvmurl"));
//		Thread.sleep(2000);
		
		hd.getAtlanta().click();
		Thread.sleep(2000);
		try {
		Assert.assertTrue(hd.getCashAndCarryMarketsSpringandFall().getText().equalsIgnoreCase("Spring Cash & Carry"));
		hd.getCashAndCarryMarketsSpringandFall().click();
		Assert.assertTrue(driver.getTitle().contains("Spring Cash & Carry"));
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(2000);
		}catch (Exception e) {
			Assert.assertTrue(hd.getFllCashAndCarryMarketsSpringandFall().getText().equalsIgnoreCase("Fall Cash & Carry"));
			hd.getFllCashAndCarryMarketsSpringandFall().click();
			Assert.assertTrue(driver.getTitle().contains("Fall Cash & Carry"));
			driver.get(prop.getProperty("lvmappurl"));
			Thread.sleep(2000);
		}
		
		//Check ADAC
		hd.getAtlanta().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getADAC().getText().equalsIgnoreCase("ADAC"));
		hd.getADAC().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("ADAC"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Check AmericasMart
		hd.getAtlanta().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getAmericasMart().getText().equalsIgnoreCase("AmericasMart"));
		hd.getAmericasMart().click();
		Assert.assertTrue(driver.getTitle().contains("Wholesale Gift, Home, Rug and Apparel Markets"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Check Atlanta Convention Center
		hd.getAtlanta().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getAtlantaConventionCenter().getText().equalsIgnoreCase("Atlanta Convention Center"));
		hd.getAtlantaConventionCenter().click();
		Assert.assertTrue(driver.getTitle().contains("Atlanta Convention Center"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Verify that Las Vegas link is present
		Assert.assertTrue(hd.getLasVegas().getText().equalsIgnoreCase("LAS VEGAS"));
		
		//Check Las Vegas Market
		hd.getLasVegas().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getLasVegasMarket().getText().equalsIgnoreCase("Las Vegas Market"));
		hd.getLasVegasMarket().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Market"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Check Formal Markets
//		hd.getLasVegas().click();
//		Thread.sleep(2000);
//		Assert.assertTrue(hd.getFormalMarkets().getText().equalsIgnoreCase("Formal Markets"));
//		hd.getFormalMarkets().click();
//		Assert.assertTrue(driver.getTitle().contains("Formal Markets"));
//		driver.get(prop.getProperty("lvmurl"));
//		Thread.sleep(2000);
		
		//Check Las Vegas Apparel
		hd.getLasVegas().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getLasVegasApparel().getText().equalsIgnoreCase("Las Vegas Apparel"));
		hd.getLasVegasApparel().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Apparel"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Check Las Vegas Design Center (LVDC)
		hd.getLasVegas().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getLasVegasDesignCenter().getText().equalsIgnoreCase("Las Vegas Design Center (LVDC)"));
		hd.getLasVegasDesignCenter().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("LVDC"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
	
		//Check EXPO at World Market Center Las Vegas
		hd.getLasVegas().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getEXPOatWorldMarketCenterLasVegas().getText().equalsIgnoreCase("EXPO at World Market Center Las Vegas"));
		hd.getEXPOatWorldMarketCenterLasVegas().click();
		Assert.assertTrue(driver.getTitle().contains("The Expo At World Market Center"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Verify that High Point link is present
		Assert.assertTrue(hd.getHighPoint().getText().equalsIgnoreCase("HIGH POINT"));
		
		//Check ANDMORE at High Point Market
		hd.getHighPoint().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getANDMOREatHighPointMarket().getText().equalsIgnoreCase("ANDMORE at High Point Market"));
		hd.getANDMOREatHighPointMarket().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("andmorehighpointmarket.com"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Check SHOPPE OBJECT High Point
		hd.getHighPoint().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getSHOPPEOBJECTHighPoint().getText().equalsIgnoreCase("SHOPPE OBJECT High Point"));
		hd.getSHOPPEOBJECTHighPoint().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("shoppeobject.com"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Verify that New York link is present
		Assert.assertTrue(hd.getNewYork().getText().equalsIgnoreCase("NEW YORK"));
		
		//Check SHOPPE OBJECT
		hd.getNewYork().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getSHOPPEOBJECT().getText().equalsIgnoreCase("SHOPPE OBJECT"));
		hd.getSHOPPEOBJECT().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("shoppeobject.com"));
		//driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(2000);
		
	}
	
	@Test(priority=02)
	public void TS002_LVM_VerifAllLinksUnderExhibitTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-002: To verify the Exhibit menu overview and it's functionality

		lap = new UXPLandingPage(driver);
		exh = new UXPExhibitPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);

		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));			
		Thread.sleep(3000);

		//Click on Exhibit tab
		exh.getExhibitTab().click();

		//Click on 'Why Exhibit?' sub-menu
		exh.getWhyExhibitMenu().click();

		//Verify that 'Exhibit' page should be displayed
		Assert.assertTrue(exh.getExhibitBrdcrumb().isDisplayed());
		System.out.println("Why Exhibit page is opened properly.");
/*
		//Click on Exhibit tab
		exh.getExhibitTab().click();

		//Click on 'Exhibit Opportunities' sub-menu
		exh.getExhibitOpptMenu().click();

		//Verify that 'Exhibit Opportunities' page should be displayed
		Assert.assertTrue(exh.getExhibitOpprBrdcrumb().isDisplayed());
		System.out.println("Exhibit Opportinities page is opened properly.");

		//Click on Exhibit tab
		exh.getExhibitTab().click();
*/
		//Click on Exhibit tab
		exh.getExhibitTab().click();

		//Click on 'Apply to exhibit' sub-menu
		exh.getapplytoexhibit().click();

		//Verify that 'Apply to exhibit' page should be displayed
		Assert.assertTrue(exh.getExhibitOpprBrdcrumb().isDisplayed());
		System.out.println("Apply to Exhibit  page is opened properly.");

		
		/*//Click on 'Advertising & Sponsorships' link
		exh.getAdvertisingnSponsershipsMenu().click();

		//Verify that 'Advertising & Sponsorships' page should be displayed
		Assert.assertTrue(exh.getAdvSpnsershpBrdcrumbUAT().isDisplayed());

		//Click on Exhibit tab
		exh.getExhibitTab().click();

		//Click on 'Tips for Exhibitors' sub-menu
		exh.getTipsForExhibitorsMenu().click();

		//Verify that 'Tips for Exhibitors' page should be displayed
		Assert.assertTrue(exh.getExhibitorTipsTitle().isDisplayed());

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

		Thread.sleep(10000);
		//Verify that 'LVM Registration' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Inquiry Request"));

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

		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(exh.getEXPLoginPageTitle().isDisplayed());

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);*/

		//Click on Exhibit tab
		exh.getExhibitTab().click();
				
		//Click Exhibitor Resources link
		exh.getexhibitorresourcesprod().click();
		Thread.sleep(5000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Exhibitor Resouces");
		Assert.assertTrue(exh.getExhibitOpprBrdcrumb().isDisplayed());
		System.out.println("Exhibitor Resources page is opened properly.");
		exh.getExhibitTab().click();

		//Click on Juniper sub-menu
	/*	exh.getJuniperMenu().click();

		// Switch to new window opened
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		//Thread.sleep(10000);
		//Verify that 'Juniper' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Experience the Future of B2B Wholesale Commerce | JuniperCommerce"));
		//Assert.assertTrue(exh.getExhibitOpprBrdcrumb().isDisplayed());
		System.out.println("Juniper page is opened properly.");


		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		//Click on Exhibit tab
		exh.getExhibitTab().click();*/
	}
	
	@Test(priority=04)
	public void TS004_LVM_VerifyAllLinksUnderExhibitorsAndProductsTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-004: To verify the Exhibitors & Products menu overview and it's functionality

		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(4000);

		//Click ExhibitorsAndProductsTab at Header
		exhp.getExhibitorsAndProducts().click();
		Thread.sleep(3000);
		Assert.assertTrue(exhp.getVerifyExhibitorsAndProductsSection().isDisplayed());
		Thread.sleep(1000);

		//Click Exhibitor Directory option under Exhibitors and Products
		exhp.getExhibitorDirectory().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyPgBreadcrumb().getText(), "Exhibitor & Product Directory");
		exhp.getExhibitorsAndProducts().click();

		//Click Floor Plans option under Exhibitors and Products
		exhp.getFloorPlans().click();
		Thread.sleep(3000);
		Assert.assertTrue(exhp.getVerifyFloorPlans().isDisplayed());
		exhp.getExhibitorsAndProducts().click();

		//Click Show Specials option under Exhibitors and Products
		exhp.getShowSpecials().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyPgBreadcrumb().getText(), "Show Specials");
		exhp.getExhibitorsAndProducts().click();

		//Click Temporaries option under Exhibitors and Products
		exhp.getTemporaries().click();
		Thread.sleep(5000);
		Assert.assertEquals(exhp.getVerifyPgBreadcrumb().getText(), "Temporaries");

		/*//Click New Introductions option under Exhibitors and Products
		//Removed this menu from page
		 * exhp.getExhibitorsAndProducts().click();
		exhp.getNewProductIntroductions().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "New Introductions");
		System.out.println("New Introductions section is displayed properly");*/
		exhp.getExhibitorsAndProducts().click();

		//Click Categories option under Exhibitors and Products
		exhp.getCategories().click();
		Thread.sleep(4000);
		Assert.assertEquals(exhp.getVerifyPgBreadcrumb().getText(), "Categories");
		//exhp.getExhibitorsAndProducts().click();

		//Click Juniper Market option under Exhibitors and Products
		/*exhp.getJuniperMarketProd().click();
		Thread.sleep(8000);
		String winHandleBefore8 = driver.getWindowHandle();
		for (String winHandle8 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle8);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.junipermarket.com"));
		driver.switchTo().window(winHandleBefore8);
		driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();*/
	}

	@Test(priority=05)
	public void TS005_LVM_VerifyAllLinksUnderMarketInfoTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T005: To verify links for Market info tab at Header

		mi = new UXPMarketInfoPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		//Click Market Info tab at Header
		mi.getMarketInfoHeader().click();
		Thread.sleep(3000);
		Assert.assertTrue(mi.getAboutLasVegasMarket().getText().contains("Las Vegas"));
		System.out.println("Market Info section options are displayed properly");

		//Click About Las Vegas Market option under Market Info
		mi.getAboutLasVegasMarket().click();
		Thread.sleep(3000);
		//Assert.assertTrue(mi.getVerifyAboutLasVegasMarket().isDisplayed());
		Assert.assertTrue(driver.getTitle().contains("Market Info"));
		System.out.println("About Las Vegas Market section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Market Dates and Hours option under Market Info
		mi.getMarketDatesAndHrs().click();
		Thread.sleep(3000);
		utl.scrollToElement(exhp.getVerifyBreadcrumb());
		Assert.assertTrue(exhp.getVerifyBreadcrumb().getText().contains("Market Dates and Hours"));
		System.out.println("Market Dates and Hours section is displayed properly");
		utl.scrollToTop();
		mi.getMarketInfoHeader().click();

		//Click Registration Details option under Market Info
		mi.getRegistrationDetails().click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.lasvegasmarket.com/Market-Info/Registration-Details");
		System.out.println("Registration Details section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Admission Policies option under Market Info
		mi.getAdmissionPolicies().click();
		Thread.sleep(5000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Admission Policies");
		System.out.println("Admission Policies section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Industry Partners option under Market Info
		mi.getIndustryPartners().click();
		Thread.sleep(5000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Industry Partners");
		System.out.println("Industry Partners section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click FAQs option under Market Info
		mi.getFAQs().click();
		Thread.sleep(5000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "FAQs");
		System.out.println("Frequently Asked Questions section is displayed properly");
		//driver.get(prop.getProperty("lvmurl"));
		mi.getMarketInfoHeader().click();

		//Click Contact s option under Market Info
		mi.getContactUs().click();
		Thread.sleep(5000);
		Assert.assertEquals(mi.getVerifyContactUs().getText(), "Contact Us");
		System.out.println("Contact Us section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Market Recap option under Market Info
		mi.getMarketRecap().click();
		Thread.sleep(5000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Market Recap");
		System.out.println("Market Recap section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Press Center option under Market Info
		mi.getMediaAndPress().click();
		Thread.sleep(5000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Press Center");
		System.out.println("Press Center section is displayed properly");
	}
	
	@Test(priority=06)
	public void TS006_LVM_VerifyAllLinksUnderAttendTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T005: To verify links for Market info tab at Header

		mi = new UXPMarketInfoPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		at = new UXPAttendPage(driver);
		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click Attend tab at Header

		at.getAttend().click();
		Thread.sleep(3000);
		Assert.assertTrue(at.getVerifyAttendSection().isDisplayed());
		System.out.println("Attend section options are displayed properly");

		//Click Why Attend tab under Attend section

		at.getWhyAttend().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/Attend"));
		System.out.println("Why Attend section is displayed properly");
		driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		//Thread.sleep(6000);
		at.getAttend().click();

		//Click Registration tab under Attend section

		at.getRegistration().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/Market-Info/Registration-Details"));
		System.out.println("Registration section is displayed properly");
		at.getAttend().click();

		//Click International tab under Attend section

		at.getInternational().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/Attend/International"));
		System.out.println("International section is displayed properly");
		at.getAttend().click();

		//Click Hotels tab at Header

		at.getHotels().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Hotels");
		System.out.println("Hotels section is displayed properly");
		at.getAttend().click();


		//Click Travel tab at Header

		at.getTravel().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Travel");
		System.out.println("Travel section is displayed properly");
		
		//Due to re-branding changes
/*		at.getAttend().click();

		//Click Market Planner tab at Header

		at.getMarketPlanner().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Market Planner");
		System.out.println("Market Planner section is displayed properly");
*/
		at.getAttend().click();

		//Click Dining tab at Header

		at.getDining().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Dining");
		System.out.println("Dining section is displayed properly");
		at.getAttend().click();

		//Click Amenities and Services tab at Header

		at.getAmenities().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Amenities and Services");
		System.out.println("Amenities and Services section is displayed properly");
		at.getAttend().click();

		//Click Accessibility and ADA Information tab at Header

		at.getAccessibility().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Accessibility and ADA Information");
		System.out.println("Accessibility and ADA Information section is displayed properly");
		at.getAttend().click();
/*
		//Click Download the App tab at Header
		at.getDownloadApp().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Market App");
		System.out.println("Market App section is displayed properly");
*/
		
		//Click on Plan Your Market sub-menu
		at.getLVMPlanYourMarket().click();
	    Thread.sleep(3000);
	    //Verify that Plan Your Market page should be displayed
	    Assert.assertTrue(driver.getTitle().contains("Plan Your Market"));
	    System.out.println("Plan Your Market page is present");
		
	}

	@Test(priority=7)
	public void TS007_LVM_VerifyAllLinksUnderExploreMarketTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T006: To verify links for Explore Market tab at Header

		expmrkt = new UXPExploreMarketPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(7000);
		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		//Click on Explore Las Vegas Market sub-menu
		expmrkt.getExploreLVMMenu().click();
		//Verify that 'Explore LVM' page should be displayed
		Assert.assertEquals(mi.getVerifyContactUs().getText(), "Explore Market");

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		//Click on 'Events and Seminars' sub-menu
		expmrkt.getWebinarsnEventsMenu().click();
		Thread.sleep(5000);
		//Verify that 'Events and Seminars' page should be displayed
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Events and Seminars");

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		//Click on Show Specials sub-menu
		expmrkt.getShowSpecialsMenu().click();
		Thread.sleep(3000);
		//Verify that 'Show Specials' page should be displayed
		Assert.assertEquals(exhp.getVerifyPgBreadcrumb().getText(), "Show Specials");

		/* This menu is removed from Explore market
		 * //Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		//Click on Virtual Resources sub-menu
		expmrkt.getVirtualResourcesMenu().click();
		//Verify that 'Virtual Resources' page should be displayed
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Virtual Resources");
		 */
		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		//Click on Key Destinations sub-menu
		expmrkt.getKeyDestinationsMenu().click();
		Thread.sleep(3000);
		//Verify that 'Key Destinations' page should be displayed
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Key Destinations");

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		//Click on News & Trends sub-menu
		expmrkt.getNewsnTrendsMenu().click();
		Thread.sleep(3000);
		//Verify that 'News & Trends' page should be displayed
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "News & Trends");

		/*		//Below menus are removed from Explore market
		 * 		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		//Click on Market Recap sub-menu
		expmrkt.getMarketRecapMenu().click();
		//Verify that 'Market Recap' page should be displayed
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Market Recap");

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		//Click on Things To Do sub-menu
		expmrkt.getThingsToDoMenu().click();
		//Verify that 'Things To Do' page should be displayed
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Things To Do in Las Vegas");

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		//Click on Social Media sub-menu
		expmrkt.getSocialMediaMenu().click();
		//Verify that 'Social Media' page should be displayed
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Social Media");*/
	}
	
	@Test(priority=8)
	public void TS008_LVM_VerifyExhibitorDirectoryTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T64: To verify Exhibitor Directory

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		ps = new UXPProfileAndSettingsPage(driver);
		gs = new UXPGlobalSearchPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		ed = new UXPExhibitorDirectoryPage(driver);
		
		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Verify exhibitor data is displayed or not as per search criteria

		ed.getExhibitorDirectory().click();
		Assert.assertEquals(exhp.getVerifyPgBreadcrumb().getText(), "Exhibitor & Product Directory");
		System.out.println("Exhibitor Directory is opened properly.");
		gs.getGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitordirectory")));
		gs.getSearchButton().click();
		Thread.sleep(4000);
		String searchterm = gs.getVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("exhibitordirectory")));
		System.out.println("Exhibitor Directory page is working properly.");
	}

	@Test(priority=9)
	public void TS009_LVM_VerifyGlobalSearchFunctionalityTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T63: To verify global search functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		ps = new UXPProfileAndSettingsPage(driver);
		gs = new UXPGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		gs.getGlobalSearchTextBox().click();
		gs.getGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitordirectory")));
		gs.getSearchButton().click();
		Thread.sleep(3000);
		String searchterm = gs.getVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("exhibitordirectory")));
		System.out.println("Global Search functionality is working properly.");
	}


	@Test(priority= 10) // previous priority= 8
	public void TS010_LVM_VerifyFooterLinksTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T69: To verify Footer Links Navigation

		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		fl = new UXPFooterLinksNavigationPage(driver);
		
		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(1000);
		//Scroll till footer links
		//utl.scrollToElement(fl.getmarketInfo());

		//Click Market Info link and verify results
		fl.getmarketInfo().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/market-info"));
		driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());

		// Click on Press Center
		fl.getpressCenter().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/Market-Info/Press-Center"));
		driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());

		// Click Download The App link and verify results
		fl.getDownloadTheApp().click();
		Thread.sleep(3000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Plan Your Market");
		driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());

		// Click on Our Brands link
		fl.getOurBrandsATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/exhibitor/directory"));
		driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());

		// Click Contact Us link and verify results
		fl.getContactUs().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/contact-us"));
		driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());

		// Click Careers link and verify results
		fl.getCareersATL().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("www.andmore.com/our-team"));
		driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());

		// Click on Terms & conditions link
		
		// Switch to new tab
		String winHandleBefore7 = driver.getWindowHandle();
		fl.getTermsAndConditions().click();
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
		utl.scrollToElement(fl.getmarketInfo());*/
		// Click Privacy Policy link and verify results
		
		String winHandleBefore8 = driver.getWindowHandle();
		fl.getLVMPrivacyPolicyPLink().click();
		for (String winHandle8 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle8);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("privacy-policy"));
		driver.close();
		driver.switchTo().window(winHandleBefore8);
		/*driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());*/

		// Click Americas Mart link and verify results
		
		String winHandleBefore9 = driver.getWindowHandle();
		fl.getAmericasMart_ATLApp().click();
		for (String winHandle9 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle9);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore9);
		/*driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());*/

		// Click Atlanta Apparel link and verify results
	
		// Switch to new tab
		String winHandleBefore2 = driver.getWindowHandle();
		fl.getAtlantaApparel().click();
		for (String winHandle2 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle2);
		}
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore2);
		/*driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());
		 */
		// Click Atlanta Market link and verify results
		
		// Switch to new tab
		String winHandleBefore3 = driver.getWindowHandle();
		fl.getAtlantaMarket().click();
		for (String winHandle3 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle3);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore3);
		/*driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
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
		/*driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());*/

		// Click on LVA Market link
		// Switch to new tab
		
		String winHandleBefore5 = driver.getWindowHandle();
		fl.getlvapplink_ATL().click();
		for (String winHandle4 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle4);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore5);
	
		/*driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());*/

		// Click International Market Centers link and verify results
		//fl.getInternationalMarketCenters().click();//Change for re-branding
		
		// Switch to new tab
		String winHandleBefore11 = driver.getWindowHandle();
		fl.getandmore().click();
		for (String winHandle11 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle11);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore11);
		/*driver.get(prop.getProperty("lvmurl"));
		utl.verifyCloseBtnPopup();
		utl.scrollToElement(fl.getmarketInfo());*/

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
		utl.scrollToElement(fl.getmarketInfo());*/

	}

	@Test(priority=11)
	public void TS011_LVM_VerifyAllSocialMediaLinksOnFooterTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-013: To verify the all social media links and it's redirection

		fl = new UXPFooterLinksNavigationPage(driver);
		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		//Scroll till footer links
		//utl.scrollElementIntoMiddle(fl.getmarketInfo());
		Thread.sleep(1000);
		//In app footer click on 'Facebook' icon and verify results
		fl.getFacebookIcon().click();
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Thread.sleep(10000);
		//Verify that 'LVM Facebook' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/lvmarket"));
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		//Click on Instagram icon
		/*fl.getInstagramIcon().click();
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		//Verify that 'LVM Instagram' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.instagram.com/lasvegasmarket/"));
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		//Click on You Tube icon
		fl.getYouTubeIcon().click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		//Verify that 'LVM You Tube' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com"));

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

				//Click on Pinterest icon
		fl.getPinterestIcon().click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		//Verify that 'LVM You Tube' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.pinterest.com/lasvegasmarket/"));

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		//Click on Twitter icon
		fl.getTwitterIcon().click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		//Verify that 'LVM Twitter' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.twitter.com/lasvegasmarket/"));

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		//Click on LinkedIn icon
		fl.getLinkedInIcon().click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		//Verify that 'LVM Twitter' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.linkedin.com/"));

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);*/
	}



	@Test(priority=12)
	public void TS012_LVM_VerifyAllLinksUnderYearRoundTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T005: To verify links for Market info tab at Header

		mi = new UXPMarketInfoPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		yr = new UXPYearRoundPage(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(3000);
		//utl.scrollToElement(yr.getYearRoundTab());
		
		//Click Year Round tab at Header
		yr.getYearRoundTab().click();
		Assert.assertTrue(yr.getVerifyYearRoundSection().isDisplayed());
		System.out.println("Year round section options are displayed properly");

		//Click Why Year Round tab under Year Round section
		yr.getYearRound().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("lvmurl")+"Year-Round"));
		System.out.println("Year Round section is displayed properly");
		yr.getYearRoundTab().click();

		//Click LVDC tab under Year Round section
		yr.getLasVegasDesignCenter().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("lvmurl")+"Year-Round/LVDC"));
		System.out.println("LVDC section is displayed properly");
		yr.getYearRoundTab().click();

		//Click The Expo tab under Year Round section
		String winHandleBefore = driver.getWindowHandle();
		yr.getExpo().click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.expowmclv.com/"));
		System.out.println("The Expo section is displayed properly");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		//yr.getYearRoundTab().click();

		//Click Off-Market Events tab under Year Round section
		yr.getMarketEvents().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("lvmurl")+"Year-Round/Off-Market-Events"));
		System.out.println("Off-Market Events section is displayed properly");
		yr.getYearRoundTab().click();

		//Click Venue Rental tab under Year Round section
		String winHandleBefore2 = driver.getWindowHandle();
		yr.getVenueRental().click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("www.wmclv.com"));
		System.out.println("Venue Rental section is redirected to WMCLV URL properly");
		driver.close();
		driver.switchTo().window(winHandleBefore2);
		
		//yr.getYearRoundTab().click();
		/*//Click LVDC tab under Year Round section
		//Junipermarket link is removed
		yr.getShopzio().click();
		Assert.assertTrue(yr.getVerifyShopzio().isDisplayed());
		System.out.println("Shopzio Exhibitors section is displayed properly");	*/
	}
	
	@Test(enabled=false)//priority=3
	public void TS003_LVM_MarketRecap() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T797: Market Recap page opens successfully.
		lap = new UXPLandingPage(driver);
		
		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Verify Market Recap link is working properly
		lap.getMarketRecap().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/Attend/App"));
		System.out.println("Market Recap page is working properly.");
	}

	@Test (enabled=false)//priority=3
	public void TS013_LVM_PlanYourMarkett() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T782: To verify Exhibitor Directory
		lap = new UXPLandingPage(driver);
		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Verify Plan your market link is working properly
		lap.getplanYourMarket().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/Attend/App"));
		System.out.println("Plan Your Market page is working properly.");
	}

	//Due to re-branding changes
	@Test(enabled=false)//priority=01
	public void TS014_LVM_VerifyMarketPlannerLoginTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-001: To verify the Market Planner overview and it's functionality
		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//		driver.get(prop.getProperty("lvmurl"));
		//		utl.verifyCloseBtnPopup();

		//Login to Market Planner
		utl.verifyMPLoginFunctionality();

		//Verify that Market Planner Home page should be displayed
		Assert.assertTrue(lap.getMPLinkText().isDisplayed());
		Thread.sleep(1000);
	}
	
	//Due to re-branding changes
	@Test(enabled=false)//priority=03
	public void TS015_LVM_VerifyMarketPlannerProfileAndSettingsOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-003: To verify Profile and Settings option in Market Planner

		ps = new UXPProfileAndSettingsPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click Profile and Settings tab under Market Planner and verify result
		ps.getWelcomeText().click();
		ps.getProfileAndSettings().click();
		Thread.sleep(3000);
		Assert.assertEquals(ps.getVerifyProfile().getText(), "My profile");
		System.out.println("Profile and Settings section options are displayed properly");

	}
	
	/*@AfterSuite
	public void sendEmail()
	{
		se = new SendEmail();
		se.sendEmailWithAttachment();
	}*/

	@AfterClass
	public void tearDown()
	{
	  driver.quit();
	}

}