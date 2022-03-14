package americasmart;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AmericasMart.AMAboutTabPage;
import pageObjects.AmericasMart.AMExhibitTabPage;
import pageObjects.AmericasMart.AMFooterLinksNavigationPage;
import pageObjects.AmericasMart.AMHeaderLinksPage;
import pageObjects.AmericasMart.AMMarketsAndEventsPage;
import pageObjects.AmericasMart.AMOpenYearRoundPage;
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

	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		amab = new AMAboutTabPage(driver);

		//Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(8000);
		lap.getIUnderstandBtn().click();
		Thread.sleep(10000);
	}

	@Test(priority=1)
	public void TS001_VerifyMarketPlannerLoginTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Login to Market Planner
		utl.verifyMPLoginFunctionality();

		//Verify that Market Planner Home page should be displayed
		Assert.assertTrue(lap.getMPLinkText().isDisplayed());
	}

	@Test(priority=11)
	public void TS011_VerifyExhibitorDirectoryTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T121: To verify Exhibitor Directory

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		ed = new UXPExhibitorDirectoryPage(driver);
		gs = new UXPGlobalSearchPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Verify exhibitor directory page is successfully opened

		ed.getExhibitorDirectory().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Exhibitor Directory");

		//Scroll till exhibitor directory

		utl.scrollToElement(exhp.getVerifyExhibitorDirectory());

		//Verify exhibitor data is displayed or not as per search criteria

		System.out.println("Exhibitor Directory is opened properly.");
		gs.getGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitordirectory")));
		gs.getSearchButton().click();

		utl.scrollToElement(mi.getVerifyContactUs());
		amhe.getExhbAndProdsTab().click();
		gs.getSearchButton().click();
		utl.scrollToElement(mi.getVerifyContactUs());
		String searchterm = gs.getVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("exhibitordirectory")));
		System.out.println("Exhibitor Directory page is working properly.");
		driver.get(prop.getProperty("ammarturl"));
	}

	@Test(priority=12)
	public void TS012_VerifyAllSocialMediaLinksOnFooterTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-013: To verify the all social media links and it's redirection

		amfl = new AMFooterLinksNavigationPage(driver);
		utl = new Utility(driver); 
		fl = new UXPFooterLinksNavigationPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Scroll till footer links
		utl.scrollToElement(fl.getHighPointMarket());
		Thread.sleep(5000);

		//In app footer click on 'Facebook' icon and verify results
		amfl.getFacebookIcon().click();

		//Verify that 'AMC Facebook' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/AmericasmartAtl"));
		System.out.println("Facebook opened successfully");
		driver.get(prop.getProperty("ammarturl"));

		/*	//In app footer click on 'Twitter' icon and verify results
		amfl.getTwitterIcon().click();

		//Verify that 'AMC Twitter' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://twitter.com/americasmartatl"));
		System.out.println("Twitter opened successfully");
		driver.get(prop.getProperty("ammarturl"));


		//Click on Instagram icon
		amfl.getInstagramIcon().click();

		//Verify that 'AMC Instagram' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.instagram.com/americasmartatl/"));
		System.out.println("Instagram opened successfully");
		driver.get(prop.getProperty("ammarturl"));*/


		//Click on Youtube icon
		amfl.getYoutubeIcon().click();

		//Verify that 'AMC Instagram' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com/user/AmericasMart"));
		System.out.println("Instagram opened successfully");
		driver.get(prop.getProperty("ammarturl"));
	}

	@Test(priority=5)
	public void TS005_VerifyAllLinksUnderAboutTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T005: To verify links for Market info tab at Header

		mi = new UXPMarketInfoPage(driver);
		amab = new AMAboutTabPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click About tab at Header
		mi.getMarketInfoHeader().click();
		Assert.assertTrue(mi.getVerifyMarketInfoSection().isDisplayed());
		System.out.println("About section options are displayed properly");

		//Click About Americas Mart option under About tab
		mi.getAboutLasVegasMarket().click();
		Assert.assertEquals(mi.getVerifyContactUs().getText(), "About");
		System.out.println("About Americas Mart section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Press Center option under About tab
		mi.getMarketDatesAndHrs().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Press Releases");
		System.out.println("Press Center section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Atlanta Next option under About tab
		mi.getFAQs().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Atlanta Next");
		System.out.println("Atlanta Next section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click History option under About tab
		mi.getContactUs().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "History");
		System.out.println("History section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Careers option under About tab

		amab.getCareers().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Careers");
		System.out.println("Careers section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Contact Us option under Market Info

		amab.getContactUs().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Contact Us");
		System.out.println("Contact Us section is displayed properly");
		mi.getMarketInfoHeader().click();

		//Click Industry Partners option under Market Info

		amab.getIndustryPartners().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Industry Partners");
		System.out.println("Industry Partners section is displayed properly");
	}

	@Test(priority=6)
	public void TS006_VerifyAllHeaderChanelLinksTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		hd = new UXPHeaderChannelLinksPage(driver);
		atlch = new ATLAllChannelsLinksPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Atlanta Market 
		hd.getAtlantaMarket().click();
		//Verify that Atlanta Market Home page should be displayed
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Market at AmericasMart"));
		driver.get(prop.getProperty("ammarturl"));

		//Click on Atlanta Apparel 
		hd.getAtlantaApparel().click();
		//Verify that Atlanta App Home page should be displayed
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Apparel at AmericasMart"));
		driver.get(prop.getProperty("ammarturl"));

		//Click on AmericasMart 
		hd.getAmericasMart().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Wholesale Gift, Home, Rug and Apparel Markets"));
		System.out.println("Americas Mart channel link is working properly.");
		driver.get(prop.getProperty("ammarturl"));

		//Click on High Point Market 
		hd.getHighPoint().click();
		Assert.assertTrue(driver.getTitle().contains("High Point"));
		driver.get(prop.getProperty("ammarturl"));

		//Click on Las Vegas Market 
		hd.getLasVegas().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas"));
		driver.get(prop.getProperty("ammarturl"));

		//Click on Las Vegas Apparel
		atlch.getLasVegasApp().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Apparel"));
		driver.get(prop.getProperty("ammarturl"));
	}


	@Test(priority=7)
	public void TS007_VerifyAllLinksUnderMarketsAndEventsTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T012: To verify links for Attend tab at Header

		mi = new UXPMarketInfoPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		atat = new ATLAttendPage(driver);
		amme = new AMMarketsAndEventsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click Markets and Events tab at Header
		atat.getATLAttendTab().click();

		//Click Market Dates and Hours tab under Markets and Events section

		atat.getATLWhyAttend().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Market Dates and Hours");
		System.out.println("Market Dates and Hours section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Spring Market tab under Markets and Events section

		amme.getAMCSpringMarket().click();
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("ammarturl")+ "Markets/Spring-Market"));
		//Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Spring Market");
		System.out.println("Spring Market section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Spring Cash & Carry under Markets and Events section

		amme.getAMCSpringCashnCarry().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Spring Cash & Carry");
		System.out.println("Spring Cash & Carry section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Fall Market under Markets and Events section

		amme.getAMCFallMarket().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Fall Market");
		System.out.println("Fall Market section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Fall Cash & Carry under Markets and Events section

		amme.getFallCashCarry().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Fall Cash & Carry");
		System.out.println("Fall Cash & Carry section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Open Year Round under Markets and Events section

		amme.getYearRoundEvents().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Calendar of Events");
		System.out.println("Open Year Round section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Atlanta Market logo under Markets and Events section

		amme.getAtlantaMarket().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		System.out.println("Atlanta Market website is displayed properly.");
		driver.get(prop.getProperty("ammarturl"));
		atat.getATLAttendTab().click();

		//Click Atlanta Apparel under Markets and Events section

		amme.getAtlantaApparel().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		System.out.println("Atlanta Apparel website is displayed properly.");
		driver.get(prop.getProperty("ammarturl"));
	}

	@Test(priority=8)
	public void TS008_VerifyFooterLinksTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T69: To verify Footer Links Navigation

		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		fl = new UXPFooterLinksNavigationPage(driver);
		amfl = new AMFooterLinksNavigationPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Scroll till footer links

		utl.scrollToElement(fl.getHighPointMarket());

		//Click Americas Mart link and verify results

		fl.getHighPointMarket().click();
		Assert.assertEquals(mi.getVerifyContactUs().getText(), "About");
		System.out.println("About Americas Mart page opened properly");
		utl.scrollToElement(fl.getHighPointMarket());


		//Click Atlanta Apparel link and verify results

		fl.getAtlantaMarket().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		System.out.println("Atlanta Apparel page opened properly");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Atlanta Market and verify results

		fl.getAtlantaApparel().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		System.out.println("Atlanta Market page opened properly");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click IMC Highpoint market link and verify results

		fl.getAmericasMart().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("http://www.imchighpointmarket.com/"));
		System.out.println("IMC Highpoint page opened properly");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Las Vegas Market link and verify results
		fl.getInternationalMarketCenters().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/"));
		System.out.println("Las Vegas Market page opened properly");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Las Vegas Apparel link and verify results
		amfl.getLasVegasApparelLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));
		System.out.println("Las Vegas Apparel page opened properly");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click International Market Centers link and verify results
		amfl.getinternationalmarketcenters().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imcenters.com/"));
		System.out.println("International Market Centers page opened properly");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Download The App link and verify results

		fl.getDownloadTheApp().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"App");
		System.out.println("Download the app page opened properly");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.getHighPointMarket());


		//Click Media and Press Releases link and verify results

		fl.getContactUs().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Press Releases");
		System.out.println("Media and Press Releases page opened properly");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Careers Releases link and verify results

		fl.getCareers().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Careers");
		System.out.println("Careers page opened properly");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Contact Us link and verify results

		fl.getTermsAndConditions().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Contact Us");
		System.out.println("Contact Us page opened properly");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.getHighPointMarket());

		//Click Privacy Policy and verify results

		fl.getPrivacyPolicy().click();
		Assert.assertEquals(fl.getVerifyTermsOfUse().getText(),"IMC PRIVACY STATEMENT");
		System.out.println("Privacy Policy page opened properly");
		driver.get(prop.getProperty("ammarturl"));
	}

	@Test(priority=9)
	public void TS009_VerifyGlobalSearchFunctionalityTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T63: To verify global search functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		gs = new UXPGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		gs.getGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		gs.getSearchButton().click();
		String searchterm = gs.getVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput")));
		System.out.println("Global Search functionality is working properly.");
	}

	@Test(priority=10)
	public void TS010_VerifyAllLinksUnderOpenYearRoundTest() throws InterruptedException, IOException
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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Open Year Round Tab 
		amoyr.getOpenYearRoundTab().click();

		//Click About Open Year Round Link
		amoyr.getAboutYearRound().click();
		//Verify that About Open Year Round page should be displayed
		String actualHeader="Open Year Round";
		Assert.assertTrue(amoyr.getAboutYearRoundPageHeader().getText().equals(actualHeader));

		//Click on Open Year Round Tab 
		amoyr.getOpenYearRoundTab().click();
		//Click Showroom direct Link Link
		amoyr.getShoroomDirect().click();
		utl.scrollToElement(amoyr.getShowroomDirectPageHeader());
		//Verify that Showroom Direct page should be displayed
		String actualShowroomDirectHeader="Open Year Round Directory";
		Assert.assertTrue(amoyr.getShowroomDirectPageHeader().getText().equals(actualShowroomDirectHeader));

		//Click on Open Year Round Tab 
		amoyr.getOpenYearRoundTab().click();
		//Click Floor Plans Link
		amoyr.getFloorPlans().click();
		//Verify that Floor Plans page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("/Market-Map"));

		amoyr.getOpenYearRoundTab().click();
		//Click Campus Overview Link
		amoyr.getCampOverview().click();
		//Verify that Campus Overview page should be displayed	
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Campus Overview");

		amoyr.getOpenYearRoundTab().click();
		System.out.println("open Year Round DropDown");
		amoyr.getVisit().click();
		System.out.println("Visit Link");
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Visit");

		amoyr.getOpenYearRoundTab().click();
		amoyr.getParknTranspSubmenu().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Parking & Transportation");

		amoyr.getOpenYearRoundTab().click();
		amoyr.getHotelsSubmenu().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Hotels");

		amoyr.getOpenYearRoundTab().click();
		amoyr.getHowToReg().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "How to Register");

		amoyr.getOpenYearRoundTab().click();
		amoyr.getCalendarEvents().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Calendar of Events");

		amoyr.getOpenYearRoundTab().click();
		amoyr.getDesigners().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"For Designers");
	}

	@Test(priority=4)
	public void TS004_VerifyAllLinksUnderExhibitTest() throws InterruptedException, IOException
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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Exhibit Tab 
		amexh.getamcExhibitTab().click();
		//Click Exhibit at Americas Mart Link
		amexh.getExhibitAtAmc().click();
		//Verify that Exhibit at AmC page should be displayed
		Assert.assertEquals(amexh.getAMCExhibitBrdcrumb().getText(), "Exhibit");

		amexh.getamcExhibitTab().click();
		//Click Exhibit and Leasing Options Link
		amexh.getLeasingandExhibitOptions().click();
		//Verify that leasing and exhibit options page should be displayed
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Leasing & Exhibit Options");

		amexh.getamcExhibitTab().click();
		//Click Advertising Link
		amexh.getAdvertising().click();
		//Verify that Advertising page should be displayed
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Advertising");

		amexh.getamcExhibitTab().click();		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		amexh.getExpLogin().click();
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}

		Thread.sleep(5000);
		//Verify that 'EXP Home' page should be displayed
		Assert.assertTrue(atlps.getAMCExhibitorPortalHome().isDisplayed());

		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		//Click Advertising Link
		amexh.getExpFAQs().click();
		//Verify that FAQs page should be displayed
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Exhibitor FAQs");
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
		atlps.getATLWelcomeText().click();
		atlps.getATLProfileAndSettings().click();
		Thread.sleep(6000);
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("ammarturl")+"Profile"));
		System.out.println("Profile and Settings section options are displayed properly");
	}

	@Test(priority=3)
	public void TS003_VerifyMarketPlannerExhibitorPortalOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-003: To verify Exhibitor Portal option in Market Planner

		lap = new UXPLandingPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);
		atlexh = new ATLExhibitPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		atlps.getATLWelcomeText().click();
		atlps.getAMCExhibitorPortalOptn().click();
		
		//Verify that 'EXP Home' page should be displayed
		Assert.assertTrue(atlps.getAMCExhibitorPortalHome().isDisplayed());
	
		driver.get(prop.getProperty("ammarturl"));
		
		/*//Sign out from Market Planner
		atlps.getATLWelcomeText().click();
		lap.getMPSignOutBtn().click();
		Thread.sleep(10000);*/
	}


	/*@AfterSuite
	public void sendEmail()
	{
		se = new SendEmail();
		se.sendEmailWithAttachment();
	}*/

}



