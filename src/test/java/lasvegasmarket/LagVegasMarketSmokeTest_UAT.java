package lasvegasmarket;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
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
public class LagVegasMarketSmokeTest_UAT extends base {
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

	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		driver.get(prop.getProperty("url"));
		Thread.sleep(15000);
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
	public void TS002_VerifAllLinksUnderExhibitTabTest() throws InterruptedException, IOException
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

		//Verify that 'Exhibit' page should be displayed
		Assert.assertTrue(exh.getExhibitBrdcrumb().isDisplayed());

		//Click on Exhibit tab
		exh.getExhibitTab().click();

		//Click on 'Exhibit Opportunities' sub-menu
		exh.getExhibitOpptMenu().click();

		//Verify that 'Exhibit Opportunities' page should be displayed
		Assert.assertTrue(exh.getExhibitOpprBrdcrumb().isDisplayed());

		//Click on Exhibit tab
		exh.getExhibitTab().click();

		//Click on 'Advertising & Sponsorships' link
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
		driver.switchTo().window(winHandleBefore);
		
		//Click on Juniper sub-menu
		exh.getJuniperMenu().click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		Thread.sleep(10000);
		//Verify that 'Juniper' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Experience the Future of B2B Wholesale Commerce | JuniperCommerce"));

		// Close the new window, if that window no more required
		driver.close();
		
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		//Click on Exhibit tab
		exh.getExhibitTab().click();
	}

	@Test(priority=03)
	public void TS003_VerifyMarketPlannerProfileAndSettingsOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-003: To verify Profile and Settings option in Market Planner

		ps = new UXPProfileAndSettingsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click Profile and Settings tab under Market Planner and verify result

		ps.getWelcomeText().click();
		ps.getProfileAndSettings().click();
		Assert.assertEquals(ps.getVerifyProfile().getText(), "My profile");
		System.out.println("Profile and Settings section options are displayed properly");

	}

	@Test(priority=04)
	public void TS004_VerifyAllLinksUnderExhibitorsAndProductsTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-004: To verify the Exhibitors & Products menu overview and it's functionality

		exhp = new UXPExhibitorsAndProductsTabPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click ExhibitorsAndProductsTab at Header

		exhp.getExhibitorsAndProducts().click();
		Assert.assertTrue(exhp.getVerifyExhibitorsAndProductsSection().isDisplayed());
		System.out.println("Exhibitors and Products section options are displayed properly");

		//Click Exhibitor Directory option under Exhibitors and Products

		exhp.getExhibitorDirectory().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Exhibitor & Product Directory");
		System.out.println("Exhibitory Directory section is displayed properly");
		exhp.getExhibitorsAndProducts().click();

		//Click Floor Plans option under Exhibitors and Products

		exhp.getFloorPlans().click();
		Assert.assertTrue(exhp.getVerifyFloorPlans().isDisplayed());
		System.out.println("Floor Plans section is displayed properly");
		exhp.getExhibitorsAndProducts().click();

		//Click Show Specials option under Exhibitors and Products

		exhp.getShowSpecials().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Show Specials");
		System.out.println("Show Specials section is displayed properly");
		exhp.getExhibitorsAndProducts().click();

		//Click Temporaries option under Exhibitors and Products

		exhp.getTemporaries().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Temporaries");
		System.out.println("Temporaries section is displayed properly");
		exhp.getExhibitorsAndProducts().click();

		//Click New Introductions option under Exhibitors and Products

		exhp.getNewProductIntroductions().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "New Introductions");
		System.out.println("New Introductions section is displayed properly");
		exhp.getExhibitorsAndProducts().click();

		//Click Categories option under Exhibitors and Products

		exhp.getCategories().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Categories");
		System.out.println("Categories section is displayed properly");

	}

	@Test(priority=05)
	public void TS005_VerifyAllLinksUnderMarketInfoTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T005: To verify links for Market info tab at Header

		mi = new UXPMarketInfoPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click Market Info tab at Header

		mi.getMarketInfoHeader().click();
		Assert.assertTrue(mi.getVerifyMarketInfoSection().isDisplayed());
		System.out.println("Market Info section options are displayed properly");

		//Click About Las Vegas Market option under Market Info

		mi.getAboutLasVegasMarket().click();
		Assert.assertTrue(mi.getVerifyAboutLasVegasMarket().isDisplayed());
		System.out.println("About Las Vegas Market section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Market Dates and Hours option under Market Info

		mi.getMarketDatesAndHrs().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Market Dates and Hours");
		System.out.println("Market Dates and Hours section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Registration Details option under Market Info

		mi.getRegistrationDetails().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Registration Details");
		System.out.println("Registration Details section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Admission Policies option under Market Info

		mi.getAdmissionPolicies().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Admission Policies");
		System.out.println("Admission Policies section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Industry Partners option under Market Info

		mi.getIndustryPartners().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Industry Partners");
		System.out.println("Industry Partners section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click FAQs option under Market Info

		mi.getFAQs().click();
		Assert.assertEquals(mi.getVerifyFAQs().getText(), "Frequently Asked Questions");
		System.out.println("Frequently Asked Questions section is displayed properly");
		driver.get(prop.getProperty("url"));
		mi.getMarketInfoHeader().click();

		//Click Contact s option under Market Info

		mi.getContactUs().click();
		Assert.assertEquals(mi.getVerifyContactUs().getText(), "Contact Us");
		System.out.println("Contact Us section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Market Recap option under Market Info

		mi.getMarketRecap().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Market Recap");
		System.out.println("Market Recap section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Press Center option under Market Info

		mi.getMediaAndPress().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Press Center");
		System.out.println("Press Center section is displayed properly");
	}

	@Test(priority=06)
	public void TS006_VerifyAllLinksUnderExploreMarketTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T006: To verify links for Explore Market tab at Header

		expmrkt = new UXPExploreMarketPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();

		//Click on Explore Las Vegas Market sub-menu
		expmrkt.getExploreLVMMenu().click();

		Thread.sleep(10000);
		//Verify that 'Explore LVM' page should be displayed
		Assert.assertEquals(mi.getVerifyContactUs().getText(), "Explore Market");
		System.out.println("Explore Market page is displayed properly");

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();

		//Click on Webinars & Events sub-menu
		expmrkt.getWebinarsnEventsMenu().click();

		Thread.sleep(10000);
		//Verify that 'Events and Webinars' page should be displayed
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Events and Seminars");
		System.out.println("Events and Seminars page is displayed properly");

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();

		//Click on Show Specials sub-menu
		expmrkt.getShowSpecialsMenu().click();
		
		//Verify that 'Show Specials' page should be displayed
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Show Specials");
		System.out.println("Show Specials page is displayed properly");

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();

		//Click on Virtual Resources sub-menu
		expmrkt.getVirtualResourcesMenu().click();

		//Verify that 'Virtual Resources' page should be displayed
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Virtual Resources");
		System.out.println("Virtual Resources page is displayed properly");

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();

		//Click on Key Destinations sub-menu
		expmrkt.getKeyDestinationsMenu().click();

		//Verify that 'Key Destinations' page should be displayed
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Key Destinations");
		System.out.println("Key Destinations page is displayed properly");

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		
		//Click on News & Trends sub-menu
		expmrkt.getNewsnTrendsMenu().click();
		
		//Verify that 'News & Trends' page should be displayed
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "News and Trends");
		System.out.println("News and Trends page is displayed properly");

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		
		//Click on Market Recap sub-menu
		expmrkt.getMarketRecapMenu().click();
		
		//Verify that 'Market Recap' page should be displayed
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Market Recap");
		System.out.println("Market Recap page is displayed properly");
		
		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		
		//Click on Things To Do sub-menu
		expmrkt.getThingsToDoMenu().click();

		//Verify that 'Things To Do' page should be displayed
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Things To Do in Las Vegas");
		System.out.println("Things To Do in Las Vegas page is displayed properly");
		
		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		
		//Click on Social Media sub-menu
		expmrkt.getSocialMediaMenu().click();
		
		//Verify that 'Social Media' page should be displayed
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Social Media");
		System.out.println("Social Media page is displayed properly");
	}

	@Test(priority=07)
	public void TS007_VerifyGlobalSearchFunctionalityTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T63: To verify global search functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		ps = new UXPProfileAndSettingsPage(driver);
		gs = new UXPGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		gs.getGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		gs.getSearchButton().click();
		String searchterm = gs.getVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput")));
		System.out.println("Global Search functionality is working properly.");
}
	
	
	@Test(priority= 8)
	public void TS008_VerifyFooterLinksTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T69: To verify Footer Links Navigation

		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		fl = new UXPFooterLinksNavigationPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Scroll till footer links
		
		utl.scrollToElement(fl.getHighPointMarket());
		
		//Click High Point Market link and verify results

		fl.getHighPointMarket().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("http://www.imchighpointmarket.com/"));
		System.out.println("High Point Market page opened properly");
		driver.get(prop.getProperty("url"));
		utl.scrollToElement(fl.getHighPointMarket());
		
		
		//Click Atlanta Market link and verify results

		fl.getAtlantaMarket().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		System.out.println("Atlanta Market page opened properly");
		driver.get(prop.getProperty("url"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Atlanta Apparel link and verify results

		fl.getAtlantaApparel().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		System.out.println("Atlanta Apparel page opened properly");
		driver.get(prop.getProperty("url"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Americas Mart link and verify results

		fl.getAmericasMart().click();
		fl.getClosePopUpAmericasmart().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/"));
		System.out.println("Americas Mart page opened properly");
		driver.get(prop.getProperty("url"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click International Market Centers link and verify results

		fl.getInternationalMarketCenters().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imcenters.com/"));
		System.out.println("International Market Centers page opened properly");
		driver.get(prop.getProperty("url"));
		utl.scrollToElement(fl.getHighPointMarket());
		
		//Click Download The App link and verify results

		fl.getDownloadTheApp().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Market App");
		System.out.println("International Market Centers page opened properly");
		driver.get(prop.getProperty("url"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Download The App link and verify results

		fl.getDownloadTheApp().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Market App");
		System.out.println("Download App page opened properly");
		driver.get(prop.getProperty("url"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Contact Us link and verify results

		fl.getContactUs().click();
		Assert.assertEquals(mi.getVerifyContactUs().getText(),"Contact Us");
		System.out.println("Contact Us page opened properly");
		driver.get(prop.getProperty("url"));
		utl.scrollToElement(fl.getHighPointMarket());
		
		//Click Careers link and verify results

		fl.getCareers().click();
		
		//Switch to new My Imports tab
	
		String winHandleBefore = driver.getWindowHandle();
		
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);}
			
		Assert.assertEquals(fl.getVerifyCareers().getText(),"Careers");
		System.out.println("Careers page opened properly");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		
		//Click Terms of Use link and verify results
		
		//driver.get(prop.getProperty("url"));

		fl.getTermsAndConditions().click();
				
		//Switch to new My Imports tab
		//Set<String> win1 = driver.getWindowHandles();
		//Iterator<String>it1 = windows1.iterator();
		//String parentId1 = it1.next();
		//String childId1 = it1.next();
		//driver.switchTo().window(childId);
		
		String winHandleBefore1 = driver.getWindowHandle();
		
		for(String winHandle1 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle1);}
			
		Assert.assertEquals(fl.getVerifyTermsOfUse().getText(),"TERMS OF USE");
		System.out.println("Terms of Use page opened properly");
		driver.close();
		driver.switchTo().window(winHandleBefore1);
		//Click Terms of Use link and verify results
		
		//driver.get(prop.getProperty("url"));

		fl.getPrivacyPolicy().click();
				
		//Switch to new My Imports tab
		/*Set<String> win2 = driver.getWindowHandles();
		Iterator<String>it2 = windows1.iterator();
		String parentId2 = it2.next();
		String childId2 = it2.next();
		driver.switchTo().window(childId2);*/
		
		String winHandleBefore2 = driver.getWindowHandle();
		
		for(String winHandle2 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle2);}
	
		Assert.assertEquals(fl.getVerifyTermsOfUse().getText(),"WEB PRIVACY STATEMENT");
		System.out.println("Privacy Policy page opened properly");
		driver.close();
		driver.switchTo().window(winHandleBefore2);
	
	}
	
	@Test(priority=9)
	public void TS009_VerifyExhibitorDirectoryTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T64: To verify Exhibitor Directory

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		ps = new UXPProfileAndSettingsPage(driver);
		gs = new UXPGlobalSearchPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		ed = new UXPExhibitorDirectoryPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Verify exhibitor data is displayed or not as per search criteria
		
		ed.getExhibitorDirectory().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Exhibitor & Product Directory");
		System.out.println("Exhibitor Directory is opened properly.");
		gs.getGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitordirectory")));
		gs.getSearchButton().click();
		String searchterm = gs.getVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("exhibitordirectory")));
		System.out.println("Exhibitor Directory page is working properly.");
}
	
	@Test(priority=10)
	public void TS010_VerifyAllLinksUnderAttendTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T005: To verify links for Market info tab at Header

		mi = new UXPMarketInfoPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		at = new UXPAttendPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click Attend tab at Header

		at.getAttend().click();
		Assert.assertTrue(at.getVerifyAttendSection().isDisplayed());
		System.out.println("Attend section options are displayed properly");

		//Click Why Attend tab under Attend section

		at.getWhyAttend().click();
		Assert.assertEquals(mi.getVerifyContactUs().getText(), "Attend");
		System.out.println("Why Attend section is displayed properly");
		at.getAttend().click();

		//Click Registration tab under Attend section

		at.getRegistration().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Market Dates and Hours");
		System.out.println("Registration section is displayed properly");
		at.getAttend().click();

		//Click International tab under Attend section
		
		at.getInternational().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "International");
		System.out.println("International section is displayed properly");
		at.getAttend().click();

		//Click Hotels tab at Header

		at.getHotels().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Hotels");
		System.out.println("Hotels section is displayed properly");
		at.getAttend().click();


		//Click Travel tab at Header

		at.getTravel().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Travel");
		System.out.println("Travel section is displayed properly");
		at.getAttend().click();

		//Click Market Planner tab at Header

		at.getMarketPlanner().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Market Planner");
		System.out.println("Market Planner section is displayed properly");
		at.getAttend().click();

		//Click Dining tab at Header

		at.getDining().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Dining");
		System.out.println("Dining section is displayed properly");
		at.getAttend().click();

		//Click Amenities and Services tab at Header

		at.getAmenities().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Amenities and Services");
		System.out.println("Amenities and Services section is displayed properly");
		at.getAttend().click();

		//Click Accessibility and ADA Information tab at Header

		at.getAccessibility().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Accessibility and ADA Information");
		System.out.println("Accessibility and ADA Information section is displayed properly");
		at.getAttend().click();
		
		//Click Download the App tab at Header

		at.getDownloadApp().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Market App");
		System.out.println("Market App section is displayed properly");
		
	}
	

	@Test(priority=11)
	public void TS011_VerifyAllLinksUnderYearRoundTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T005: To verify links for Market info tab at Header

		mi = new UXPMarketInfoPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		yr = new UXPYearRoundPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click Year Round tab at Header

		yr.getYearRoundTab().click();
		Assert.assertTrue(yr.getVerifyYearRoundSection().isDisplayed());
		System.out.println("Year round section options are displayed properly");

		//Click Why Year Round tab under Year Round section

		yr.getYearRound().click();
		Assert.assertEquals(mi.getVerifyContactUs().getText(), "Year Round");
		System.out.println("Year Round section is displayed properly");
		yr.getYearRoundTab().click();

		//Click LVDC tab under Year Round section

		yr.getLasVegasDesignCenter().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "LVDC");
		System.out.println("LVDC section is displayed properly");
		yr.getYearRoundTab().click();

		//Click The Expo tab under Year Round section

		yr.getExpo().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "The Expo");
		System.out.println("The Expo section is displayed properly");
		yr.getYearRoundTab().click();

		//Click Off-Market Events tab under Year Round section

		yr.getMarketEvents().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Off-Market Events");
		System.out.println("Off-Market Events section is displayed properly");
		yr.getYearRoundTab().click();

		//Click Venue Rental tab under Year Round section

		yr.getVenueRental().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Venue Rental");
		System.out.println("Venue Rental section is displayed properly");
		yr.getYearRoundTab().click();

		//Click LVDC tab under Year Round section

		yr.getShopzio().click();
		Assert.assertTrue(yr.getVerifyShopzio().isDisplayed());
		System.out.println("Shopzio Exhibitors section is displayed properly");
		
	}
	
	@Test(priority=12)
	public void TS012_VerifyHeaderChannelLinksTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-: To verify header channel links

		hd = new UXPHeaderChannelLinksPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click Atlanta Market channel link and verify result

		hd.getAtlantaMarket().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Market at AmericasMart"));
		System.out.println("Atlanta Market channel link is working properly.");
		driver.get(prop.getProperty("url"));
		
		//Click Atlanta Apparel channel link and verify result

		hd.getAtlantaApparel().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Apparel at AmericasMart"));
		System.out.println("Atlanta Apparel channel link is working properly.");
		driver.get(prop.getProperty("url"));
				
		//Click Americas Mart channel link and verify result

		hd.getAmericasMart().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Wholesale Gift, Home, Rug and Apparel Markets"));
		System.out.println("Americas Mart channel link is working properly.");
		driver.get(prop.getProperty("url"));
				
		/*//Click IMC High Point Market channel link and verify result

		hd.getAtlantaMarket().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Market at AmericasMart"));
		System.out.println("Atlanta Market channel link is working properly.");
		driver.get(prop.getProperty("url"));*/
				
		//Click Lav Vegas Market channel link and verify result

		hd.getLasVegas().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas"));
		System.out.println("Las Vegas Market channel link is working properly.");
		
	}
	
	/*@AfterSuite
	public void sendEmail()
	{
		se = new SendEmail();
		se.sendEmailWithAttachment();
	}*/

		}
		
	
	
