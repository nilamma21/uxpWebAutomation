package PROD;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
	ATLAttendPage atat;
	ATLNewsAndTrendsTabPage atlnt;
	SendEmail se;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		//		utl = new Utility(driver);
		//		lap = new UXPLandingPage(driver);

		/*//Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(5000);
		lap.getIUnderstandBtn().click();
		Thread.sleep(3000);*/
		//	lap.getCloseMarktAdBtn().click();
	}

	@Test(priority=1)
	public void TS001_VerifyMarketPlannerLoginTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-001: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(5000);
		//		lap.getIUnderstandBtn().click();
		//		Thread.sleep(3000);

		//Login to Market Planner
		utl.verifyMPLoginFunctionality();

		//Verify that Market Planner Home page should be displayed
		Assert.assertTrue(lap.getMPLinkText().isDisplayed());
		//Thread.sleep(6000);
		//lap.getCloseMarktAdBtn().click();
	}

	@Test(priority=2)
	public void TS002_VerifyMarketPlannerProfileAndSettingsOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-002: To verify Profile and Settings option in Market Planner

		lap = new UXPLandingPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click Profile and Settings tab under Market Planner and verify result
		Thread.sleep(5000);
		atlps.getATLWelcomeText().click();

		atlps.getATLProfileAndSettings().click();
		Thread.sleep(6000);
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlmrkturl")+"Profile"));
		System.out.println("Profile and Settings section options are displayed properly");
	}
	@Test(priority=3)
	public void TS003_VerifyGlobalSearchFunctionalityTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T003: To verify global search functionality

		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlgs.getATLGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		atlgs.getATLSearchButton().click();
		Thread.sleep(15000);
		String searchterm = atlgs.getATLVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput")));
		System.out.println("Global Search functionality is working properly.");
	}

	@Test(priority=4)
	public void TS004_VerifyMarketPlannerRegistrationsOptionTest() throws InterruptedException, IOException
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
		//lap.getCloseMarktAdBtn().click();
	}

	@Test(priority=5)
	public void TS005_VerifyExhibitorDirectoryTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T005: To verify Exhibitor Directory

		atlgs = new ATLGlobalSearchPage(driver);
		atled = new ATLExhibitorDirectoryPage(driver);
		atlexhp = new ATLExhibitorsAndProductsTabPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Verify exhibitor data is displayed or not as per search criteria

		atled.getATLExhibitorDirectory().click();
		Assert.assertEquals(atlexhp.getATLVerifyExhibitorDirectory().getText(), "Exhibitor Directory");
		System.out.println("Exhibitor Directory is opened properly.");

		atled.getATLExhDirtSearchBox().sendKeys((prop.getProperty("exhibitordirectory")));
		atled.getATLExhDirtSearchBtn().click();
		Thread.sleep(6000);
		String searchterm = atlgs.getATLVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("exhibitordirectory")));
		System.out.println("Exhibitor Directory page is working properly.");
	}

	@Test(priority=8)
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

	@Test(priority=7)
	public void TS007_VerifyAllLinksUnderExhibitorsAndProductsTabTest() throws InterruptedException, IOException
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
		Assert.assertEquals(atlexhp.getATLVerifyExhibitorDirectory().getText(), "Temporaries");
		System.out.println("Temporaries section is displayed properly");

		//Click Categories option under Exhibitors and Products
		atlexhp.getATLExhibitorsAndProducts().click();
		atlexhp.getATLCategories().click();
		Assert.assertEquals(atlexhp.getATLVerifyExhibitorDirectory().getText(), "Categories");
		System.out.println("Categories section is displayed properly");

		//Click on Juniper sub-menu
		atlexhp.getATLExhibitorsAndProducts().click();
		atlexhp.getATLJunpiperMrktUAT().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.junipermarket.com/"));
		System.out.println("Juniper Market page is displayed properly");
		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(6000);
	}

	@Test(priority=6)
	public void TS008_VerifAllLinksUnderExhibitTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-008: To verify the Exhibit menu overview and it's functionality

		lap = new UXPLandingPage(driver);
		atlexh = new ATLExhibitPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);						

		//Click on Exhibit tab
		atlexh.getATLExhibitTab().click();

		//Click on Exhibit at Atlanta Market sub-menu
		atlexh.getATLExhibitAtAtlanta().click();

		//Verify that Exhibit page should be displayed
		Assert.assertTrue(atlexh.getATLExhibitBrdcrumb().isDisplayed());

		//Click on Exhibit tab
		atlexh.getATLExhibitTab().click();

		//Click on 'Why Exhibit?' sub-menu
		atlexh.getATLWhyExhibitMenu().click();

		//Verify that 'Exhibit' page should be displayed
		Assert.assertTrue(atlexh.getATLExhibitBrdcrumb().isDisplayed());

		//Click on Exhibit tab
		atlexh.getATLExhibitTab().click();

		//Click on 'Apply to Exhibit' sub-menu
		atlexh.getATLApplyToExhibit().click();

		//Verify that 'Apply to exhibit' page should be displayed
		Assert.assertEquals(atlexh.getATLApplyToExhibitBrdcrmb().getText(), "Apply to Exhibit");

		//Click on Exhibit tab
		atlexh.getATLExhibitTab().click();

		//Click on 'Exhibitor Registration' link
		atlexh.getATLExhibitorRegtnMenu().click();

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

		//Click on Exhibit tab
		atlexh.getATLExhibitTab().click();

		//Click on Juniper Commerce sub-menu
		atlexh.getATLJuniperMenu().click();

		Thread.sleep(10000);
		//Verify that 'Juniper' page should be displayed
		Assert.assertTrue(driver.getTitle().contains("Experience the Future of B2B Wholesale Commerce | JuniperCommerce"));

		driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(8000);
	}

	@Test(priority=9)
	public void TS009_VerifyAllChannelsLinksTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-TS009: To verify all channels links in Header

		atlch = new ATLAllChannelsLinksPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click Atlanta Market channel link and verify result
		atlch.getAtlantaMarket().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Market at AmericasMart"));
		System.out.println("Atlanta Market channel link is working properly.");
		driver.get(prop.getProperty("atlmrkturl"));

		//Click Atlanta Apparel channel link and verify result
		atlch.getAtlantaApparel().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Apparel at AmericasMart"));
		System.out.println("Atlanta Apparel channel link is working properly.");
		driver.get(prop.getProperty("atlmrkturl"));

		//Click Americas Mart channel link and verify result
		atlch.getAmericasMart().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Wholesale Gift, Home, Rug and Apparel Markets"));
		System.out.println("Americas Mart channel link is working properly.");
		driver.get(prop.getProperty("atlmrkturl"));

		//Click IMC High Point Market channel link and verify result
		atlch.getHighPoint().click();
		Assert.assertTrue(driver.getTitle().contains("High Point"));
		System.out.println("High Point Market channel link is working properly.");
		driver.get(prop.getProperty("atlmrkturl"));

		//Click Las Vegas Market channel link and verify result
		atlch.getLasVegas().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas"));
		System.out.println("Las Vegas Market channel link is working properly.");
		driver.get(prop.getProperty("atlmrkturl"));

		//Click Las Vegas Market channel link and verify result
		atlch.getLasVegasApp().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Apparel"));
		System.out.println("Las Vegas Apparel channel link is working properly.");
		driver.get(prop.getProperty("atlmrkturl"));
	}

	@Test(priority=10)
	public void TS010_VerifyAllSocialMediaLinksOnFooterTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T010: To verify the all social media links and it's redirection

		atlfl = new ATLFooterLinksNavigationPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Scroll till footer links
		utl.scrollToElement(atlfl.getHighPointMarket());

		//In app footer click on 'Facebook' icon and verify results
		atlfl.getFacebookIcon().click();

		Thread.sleep(10000);
		//Verify that 'ATL Facebook' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/AmericasmartAtl"));

		driver.get(prop.getProperty("atlmrkturl"));

		/*		//Click on Instagram icon
		fl.getInstagramIcon().click();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		//Verify that 'ATL Instagram' page should be displayed
		Assert.assertTrue(driver.getCurrentatlmrkturl().contains("https://www.instagram.com/americasmartatl/"));

		driver.get(prop.getProperty("atlmrkturl"));
		 */

		//Click on You Tube icon
		atlfl.getYouTubeIcon().click();

		Thread.sleep(10000);
		//Verify that 'ATL You Tube' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com"));

		driver.get(prop.getProperty("atlmrkturl"));

		/*//Click on Twitter icon
		fl.getTwitterIcon().click();

		Thread.sleep(10000);
		//Verify that 'ATL Twitter' page should be displayed
		Assert.assertTrue(driver.getCurrentatlmrkturl().contains("https://www.twitter.com/americasmartatl")); 

		driver.get(prop.getProperty("atlmrkturl"));
		 */
	}

	@Test(priority= 11)
	public void TS011_VerifyFooterLinksTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T69: To verify Footer Links Navigation

		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		fl = new UXPFooterLinksNavigationPage(driver);
		atlfl  = new ATLFooterLinksNavigationPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Scroll till footer links
		utl.scrollToElement(fl.getHighPointMarket());

		//Click on About Atlanta Market link
		fl.getAbtAtlMktLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/Market-Info/About-Us"));
		System.out.println("About Atlanta Market page opened properly");
		driver.get(prop.getProperty("atlmrkturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Americas Mart link and verify results
		fl.getAtlantaMarket().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/"));
		System.out.println("Americas Mart page opened properly");
		driver.get(prop.getProperty("atlmrkturl"));
		utl.scrollToElement(fl.getHighPointMarket());	

		//Click Atlanta Apparel link and verify results
		fl.getAtlantaApparel().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		System.out.println("Atlanta Apparel page opened properly");
		driver.get(prop.getProperty("atlmrkturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click IMC Highpoint link and verify results
		fl.getAmericasMart().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("http://www.imchighpointmarket.com/"));
		System.out.println("IMC High Point page opened properly");
		driver.get(prop.getProperty("atlmrkturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Las Vegas market link and verify results
		fl.getInternationalMarketCenters().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/"));
		System.out.println("Las Vegas Market page opened properly");
		driver.get(prop.getProperty("atlmrkturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click on Las Vegas Apparel footer link
		fl.getLVAPPLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));
		System.out.println("Las Vegas Apparel page opened properly");
		driver.get(prop.getProperty("atlmrkturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click International Market Centers link and verify results
		atlfl.getATLIMCLinkProd().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imcenters.com/"));
		System.out.println("International Market Centers page opened properly");
		driver.get(prop.getProperty("atlmrkturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Download The App link and verify results
		fl.getDownloadTheApp().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"App");
		System.out.println("Download the app page opened properly");
		driver.get(prop.getProperty("atlmrkturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Careers link and verify results
		atlfl.getCareers().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Careers");
		System.out.println("Careers page opened properly");
		driver.get(prop.getProperty("atlmrkturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Media and Press Releases link and verify results
		atlfl.getMediaPressReleases().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Press Releases");
		System.out.println("Media and Pres Releases page opened properly");
		driver.get(prop.getProperty("atlmrkturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Contact Us link and verify results
		atlfl.getContactUs().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Contact Us");
		System.out.println("Contact Us page opened properly");
		driver.get(prop.getProperty("atlmrkturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Terms of Use link and verify results
		atlfl.getVerifyPrivacyPolicy().click();
		Assert.assertEquals(fl.getVerifyTermsOfUse().getText(),"IMC PRIVACY STATEMENT");
		System.out.println("Privacy Policy page opened properly");
		driver.get(prop.getProperty("atlmrkturl"));
	}

	@Test(priority=12)
	public void TS012_VerifyAllLinksUnderAttendTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T012: To verify links for Attend tab at Header

		mi = new UXPMarketInfoPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		atat = new ATLAttendPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click Attend tab at Header
		atat.getATLAttendTab().click();

		//Click Why Attend tab under Attend section
		atat.getATLWhyAttend().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Why Attend?");
		System.out.println("Why Attend section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Registration tab under Attend section
		atat.getATLRegistration().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Registration");
		System.out.println("Registration section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Admission Policies under Attend section
		atat.getATLAdmissionPolicies().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Admission Policies");
		System.out.println("Admission Policies section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Download the App under Attend section
		atat.getATLDownloadApp().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "App");
		System.out.println("Download the App section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Travel under Attend section
		atat.getATLTravel().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Hotels & Travel");
		System.out.println("Travel section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Dining Guide under Attend section
		atat.getATLDiningGuide().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Dining Guide");
		System.out.println("Dining Guide section is displayed properly");
		atat.getATLAttendTab().click();

		//Click on Events under Attend section
		atat.getATLEventsSubmenu().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Events");
		atat.getATLAttendTab().click();

		//Click Services and Amenities under Attend section
		atat.getATLServicesAndAmenities().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Services & Amenities");
		System.out.println("Services & Amenities section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Together Safely under Attend section
		atat.getATLTogetherSafely().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imcenters.com/"));
		System.out.println("Together Safely section is displayed properly");
		driver.get(prop.getProperty("atlmrkturl"));
	}

	@Test(priority=13)
	public void TS013_VerifyAllNewsAndTrendsMenuTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T013: To verify the all News & Trends tap Menu and it's redirection

		atlnt = new ATLNewsAndTrendsTabPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//atlnt.getATLNewsAndTrends().click();

		//Click News and Trends tab and verify result
		atlnt.getATLNewsAndTrendsTap().click();
		Assert.assertTrue(atlnt.getVerifyNewsSection().isDisplayed());
		System.out.println("News section is displayed properly.");

		//Click on News And Trends sub-menu and Verify Page
		atlnt.getATLNewsAndTrendsSubmenu().click();
		Assert.assertTrue(atlnt.getATLNewsAndTrendsPageHeader().getText().contains("News & Trends"));

		//Click on News And Trends Tab
		atlnt.getATLNewsAndTrends().click();
		atlnt.getATLatlMarketSnapshot().click();
		//Click on MarketSnapshot and Verify Page
		Assert.assertTrue(atlnt.getATLMarketSnapshotPageHeader().getText().contains("Market Snapshot"));
		System.out.println("Market Snapshot page");

		//Click on News And Trends Tab
		atlnt.getATLNewsAndTrends().click();
		atlnt.getATLWebinarAndEducation().click();
		//Click on Webinar And Education and Verify Page
		Assert.assertTrue(atlnt.getATLWebinarAndEducationPageHeader().getText().contains("Webinars & Education"));
		System.out.println("Webinars & Education page");

		//Click on News And Trends Tab
		atlnt.getATLNewsAndTrends().click();
		atlnt.getATLatlAheadCurve().click();
		Assert.assertTrue(atlnt.getATLAheadCurvePageHeader().getText().contains("Ahead of the Curve"));
		System.out.println("Ahead of the Curve page");

		//Click on News And Trends Tab
		atlnt.getATLNewsAndTrends().click();
		atlnt.getATLShopTheShow().click();
		//Click on Shop the and Verify Page
		Assert.assertTrue(atlnt.getATLShopTheShowPageHeader().getText().contains("Shop the "));
		System.out.println("Shop the show page header");

		//Click on News And Trends Tab
		atlnt.getATLNewsAndTrends().click();
		atlnt.getATLPressReleases().click();
		//Click on Press Releases and Verify Page
		Assert.assertTrue(atlnt.getATLPressReleasesPageHeader().getText().contains("Press Releases"));
		System.out.println("Press Releases page");

		//Click on News And Trends Tab
		atlnt.getATLNewsAndTrends().click();
		atlnt.getATLPublicationsLibrary().click();
		//Click on Publications Library and Verify Page
		Assert.assertTrue(atlnt.getATLPublicationsLibraryPageHeader().getText().contains("Publications Library"));
		System.out.println("Publications Library page");

		//Click on News And Trends Tab
		atlnt.getATLNewsAndTrends().click();
		atlnt.getATLInTheNews().click();
		//Click on In the News and Verify Page
		Assert.assertTrue(atlnt.getATLInTheNewsPageHeader().getText().contains("In the News"));
		System.out.println("In The News page");

		//Click on News And Trends Tap
		atlnt.getATLNewsAndTrends().click();
		atlnt.getATLAtlantaNext().click();
		//Click on Atlanta Next and Verify Page
		Assert.assertTrue(atlnt.getATLAtlantaNextHeader().getText().contains("Atlanta Next"));
		System.out.println("In Atlanta Next page");

		//Click on News And Trends Tab
		atlnt.getATLNewsAndTrends().click();
		//Click on Portman Peachtree and Verify Page
		atlnt.getATLPortmanPeachtree().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Blog");
		System.out.println("In Portman Peachtreet page");
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
		driver.quit();
	}

}



