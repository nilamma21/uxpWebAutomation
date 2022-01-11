package lasvegasmarket;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.LasVegasMarket.UXPExhibitPage;
import pageObjects.LasVegasMarket.UXPExhibitorsAndProductsTabPage;
import pageObjects.LasVegasMarket.UXPExploreMarketPage;
import pageObjects.LasVegasMarket.UXPGlobalSearchPage;
import pageObjects.LasVegasMarket.UXPLandingPage;
import pageObjects.LasVegasMarket.UXPLoginPage;
import pageObjects.LasVegasMarket.UXPMarketInfoPage;
import pageObjects.LasVegasMarket.UXPProfileAndSettingsPage;
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
	UXPExhibitorsAndProductsTabPage exhp;
	UXPProfileAndSettingsPage ps;
	UXPMarketInfoPage mi;
	UXPExploreMarketPage expmrkt;
	UXPGlobalSearchPage gs;
	SendEmail se;

	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		driver.get(prop.getProperty("url"));
		//Thread.sleep(15000);
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

		Thread.sleep(10000);
		//Verify that 'Exhibit' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Exhibit | Las Vegas Market"));

		//Click on Exhibit tab
		exh.getExhibitTab().click();

		//Click on 'Exhibit Opportunities' sub-menu
		exh.getExhibitOpptMenu().click();

		Thread.sleep(10000);
		//Verify that 'Exhibit Opportunities' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Exhibit Opportunities | Las Vegas Market"));

		//Click on Exhibit tab
		exh.getExhibitTab().click();

		//Click on 'Advertising & Sponsorships' link
		exh.getAdvertisingnSponsershipsMenu().click();

		Thread.sleep(10000);
		//Verify that 'Advertising & Sponsorships' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Marketing and Sponsorship Opportunities | Las Vegas Market"));

		//Click on Exhibit tab
		exh.getExhibitTab().click();

		//Click on 'Tips for Exhibitors' sub-menu
		exh.getTipsForExhibitorsMenu().click();

		Thread.sleep(10000);
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

		Thread.sleep(10000);
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
		Assert.assertTrue(driver.getTitle().contains("Explore | Las Vegas Market"));

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();

		//Click on Webinars & Events sub-menu
		expmrkt.getWebinarsnEventsMenu().click();

		Thread.sleep(10000);
		//Verify that 'Events and Webinars' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Events and Webinars | Las Vegas Market"));

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();

		//Click on Show Specials sub-menu
		expmrkt.getShowSpecialsMenu().click();

		Thread.sleep(10000);
		//Verify that 'Show Specials' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Show Specials | Las Vegas Market"));

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();

		//Click on Virtual Resources sub-menu
		expmrkt.getVirtualResourcesMenu().click();

		Thread.sleep(10000);
		//Verify that 'Virtual Resources' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Virtual Tools | Las Vegas Market"));

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();

		//Click on Key Destinations sub-menu
		expmrkt.getKeyDestinationsMenu().click();

		Thread.sleep(6000);
		//Verify that 'Key Destinations' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Key Destinations | Las Vegas Market"));

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		
		//Click on News & Trends sub-menu
		expmrkt.getNewsnTrendsMenu().click();
		
		Thread.sleep(6000);
		//Verify that 'News & Trends' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("News and Trends | Las Vegas Market"));

		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		
		//Click on Market Recap sub-menu
		expmrkt.getMarketRecapMenu().click();
		
		Thread.sleep(6000);
		//Verify that 'Market Recap' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Market Recap | Las Vegas Market"));
		
		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		
		//Click on Things To Do sub-menu
		expmrkt.getThingsToDoMenu().click();

		Thread.sleep(6000);
		//Verify that 'Things To Do' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Things To Do | Las Vegas Market"));
		
		//Click on Explore Market tab
		expmrkt.getExploreMarketTab().click();
		
		//Click on Social Media sub-menu
		expmrkt.getSocialMediaMenu().click();
		
		Thread.sleep(6000);
		//Verify that 'Social Media' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Social Media | Las Vegas Market"));
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
	/*@AfterSuite
	public void sendEmail()
	{
		se = new SendEmail();
		se.sendEmailWithAttachment();
	}*/

}
