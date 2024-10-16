package UAT;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
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
public class AmericasMartSmokeTest_UAT extends base {
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
		driver.get(prop.getProperty("ammarturl"));;
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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Login to Market Planner
		utl.verifyMPLoginFunctionality();

		//Verify that Market Planner Home page should be displayed
		Assert.assertTrue(lap.getMPLinkText().isDisplayed());
	}

	@Test(priority=2)
	public void TS002_VerifyExhibitorDirectoryTest() throws InterruptedException, IOException
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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

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
	}

	@Test(priority=3)
	public void TS003_VerifyAllSocialMediaLinksOnFooterTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-013: To verify the all social media links and it's redirection

		amfl = new AMFooterLinksNavigationPage(driver);
		utl = new Utility(driver); 
		fl = new UXPFooterLinksNavigationPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

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

	@Test(priority=4)
	public void TS005_VerifyAllLinksUnderAboutTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T005: To verify links for Market info tab at Header

		mi = new UXPMarketInfoPage(driver);
		amab = new AMAboutTabPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

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

		//Click Blog option under About tab

		mi.getRegistrationDetails().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Blog");
		System.out.println("Blog section is displayed properly");
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

	@Test(priority=5)
	public void TS005_VerifyAllHeaderChanelLinksTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		//cl = new AMCAllChannelsLinksPage(driver);
		hd=new UXPHeaderChannelLinksPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click on Atlanta Market 
		hd.getAtlantaMarket().click();
		System.out.println("Atlanta Market Home Page");
		//Verify that Atlanta Market Home page should be displayed
		//Assert.assertTrue(hd.getAtlantaMarketLogo().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://uat-atlmkt.imcmvdp.com/"));
		System.out.println("Atlanta Market Home Page URL");

		driver.navigate().back();

		//Click on Atlanta Market 
		hd.getAtlantaApparel().click();
		System.out.println("Atlanta Apparel Home Page");
		//Verify that Atlanta App Home page should be displayed
		//Assert.assertTrue(cl.getAtlantaAppLogo().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://uat-atlapp.imcmvdp.com/"));
		System.out.println("Atlanta App URL");

		driver.navigate().back();

		//Click on Atlanta Market 
		hd.getAmericasMart().click();
		System.out.println("AmericasMart Home Page");
		//Verify that AmericasMart Home page should be displayed
		//Assert.assertTrue(cl.getAmericasMartLogo().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://uat-amc.imcmvdp.com/"));

		//Click on Atlanta Market 
		hd.getHighPoint().click();
		System.out.println("HighPoint Market Home Page");
		//Verify that High point Market Home page should be displayed
		//Assert.assertTrue(hd.getHighPointLogo().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("http://www.imchighpointmarket.com/"));
		System.out.println("High Point Market Home Page URL");

		driver.navigate().back();

		//Click on Atlanta Market 
		hd.getLasVegas().click();
		System.out.println("Las Vegas Market Home Page");
		//Verify that Las Vegas Home page should be displayed
		//Assert.assertTrue(hd.getLasVegasLogo().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://uat-lvm.imcmvdp.com/"));
		System.out.println("Las Vegas Market Home Page URL");

		driver.navigate().back();
	}

	@Test(priority=6)
	public void TS006_VerifyAllLinksUnderMarketsAndEventsTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T012: To verify links for Attend tab at Header

		mi = new UXPMarketInfoPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		atat = new ATLAttendPage(driver);
		amme = new AMMarketsAndEventsPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click Markets and Events tab at Header
		atat.getATLAttendTab().click();

		//Click Market Dates and Hours tab under Markets and Events section

		atat.getATLWhyAttend().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Market Dates and Hours");
		System.out.println("Market Dates and Hours section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Spring Market tab under Markets and Events section

		atat.getATLRegistration().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Spring Market");
		System.out.println("Spring Market section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Spring Cash & Carry under Markets and Events section

		atat.getATLAdmissionPolicies().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Spring Cash & Carry");
		System.out.println("Spring Cash & Carry section is displayed properly");
		atat.getATLAttendTab().click();

		//Click Fall Design Week under Markets and Events section

		atat.getATLDownloadApp().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Fall Design Week");
		System.out.println("Fall Design Week section is displayed properly");
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

		atat.getATLTravel().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		System.out.println("Atlanta Market website is displayed properly.");
		driver.get(prop.getProperty("ammarturl"));
		atat.getATLAttendTab().click();

		//Click Atlanta Apparel under Markets and Events section

		amme.getAtlantaApparel().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		System.out.println("Atlanta Apparel website is displayed properly.");
		driver.get(prop.getProperty("ammarturl"));
		amhe.getClosePrompt().click();
	}

	@Test(priority=7)
	public void TS007_VerifyFooterLinksTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T69: To verify Footer Links Navigation

		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		fl = new UXPFooterLinksNavigationPage(driver);
		amfl = new AMFooterLinksNavigationPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

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
		System.out.println("Las Vegas Market Centers page opened properly");
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

	@Test(priority=8)
	public void TS008_VerifyGlobalSearchFunctionalityTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T63: To verify global search functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		gs = new UXPGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		gs.getGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		gs.getSearchButton().click();
		String searchterm = gs.getVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput")));
		System.out.println("Global Search functionality is working properly.");
	}

	@Test(priority=9)
	public void TS009_VerifyAllLinksUnderOpenYearRoundTest() throws InterruptedException, IOException
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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click on Open Year Round Tab 
		amoyr.getOpenYearRoundTab().click();
		System.out.println("open Year Round DropDown");
		//Click About Open Year Round Link
		amoyr.getAboutYearRound().click();
		System.out.println("Click About Open Year Round Link");
		//Verify that About Open Year Round page should be displayed
		String actualHeader="Open Year Round";
		Assert.assertTrue(amoyr.getAboutYearRoundPageHeader().getText().equals(actualHeader));
		System.out.println("Header test");

		//Click on Open Year Round Tab 
		amoyr.getOpenYearRoundTab().click();
		System.out.println("open Year Round DropDown");
		amoyr.getOpenYearRoundShowrooms().click();
		System.out.println("Showroom direct Link");
		//Click Showroom direct Link Link
		utl.scrollToElement(amoyr.getExhibitorDirectoryPageHeader());
		//Verify that Showroom Direct page should be displayed
		String actualShowroomDirectHeader="Open Year Round Directory";
		Assert.assertTrue(amoyr.getExhibitorDirectoryPageHeader().getText().equals(actualShowroomDirectHeader));
		System.out.println("Header test");

		//Click on Open Year Round Tab 
		amoyr.getOpenYearRoundTab().click();
		System.out.println("open Year Round DropDown");
		amoyr.getFloorPlans().click();
		System.out.println("Floor Plans Link");
		//Click Floor Plans Link
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-amc.imcmvdp.com/Market-Map"));
		//Verify that Floor Plans page should be displayed
		
		amoyr.getOpenYearRoundTab().click();
		System.out.println("open Year Round DropDown");
		amoyr.getCampOverview().click();
		System.out.println("CampOvevirw Link");
		//Click Campview Link
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-amc.imcmvdp.com/Year-Round/Campus-Overview"));
		//Verify that Campview page should be displayed	
		amoyr.getOpenYearRoundTab().click();
		System.out.println("open Year Round DropDown");
		amoyr.getVisit().click();
		System.out.println("View Link");
		//Click Campview Link
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-amc.imcmvdp.com/Year-Round/Visit"));
		
		amoyr.getOpenYearRoundTab().click();
		System.out.println("open Year Round DropDown");
		amoyr.getHowToReg().click();
		System.out.println("How to Reg Link");
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-amc.imcmvdp.com/Year-Round/How-to-Register"));
		
		amoyr.getOpenYearRoundTab().click();
		System.out.println("open Year Round DropDown");
		amoyr.getCalendarEvents().click();
		System.out.println("Calendar Events Link");
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-amc.imcmvdp.com/Year-Round/Calendar-of-Events"));
		
		amoyr.getOpenYearRoundTab().click();
		System.out.println("open Year Round DropDown");
		amoyr.getCalendarEvents().click();
		System.out.println("Calendar Events Link");
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-amc.imcmvdp.com/Year-Round/Calendar-of-Events"));
		
		amoyr.getOpenYearRoundTab().click();
		System.out.println("open Year Round DropDown");
		amoyr.getDesigners().click();
		System.out.println("Designers Link");
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-amc.imcmvdp.com/Year-Round/For-Designers"));
	}

	@Test(priority=10)
	public void TS010_VerifyAllLinksUnderExhibitTest() throws InterruptedException, IOException
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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click on Exhibit Tab 
		amexh.getamcExhibitTab().click();
		System.out.println("Exhibit DropDown");
		//Click Exhibit at Americas Mart Link
		amexh.getExhibitAtAmc().click();
		System.out.println("Click Exhibit At AMCM Link");
		//Verify that Exhibit at AmC page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-amc.imcmvdp.com/Exhibit"));

		amexh.getamcExhibitTab().click();
		System.out.println("Exhibit DropDown");
		//Click Exhibit and Leasing Options Link
		amexh.getLeasingandExhibitOptions().click();
		System.out.println("Click Leasing and Exhibit options Link");
		//Verify that leasing and exhibit options page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-amc.imcmvdp.com/Exhibit/Opportunities"));

		amexh.getamcExhibitTab().click();
		System.out.println("Exhibit DropDown");
		//Click Advertising Link
		amexh.getAdvertising().click();
		System.out.println("Click Advertising Link");
		//Verify that Advertising page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-amc.imcmvdp.com/Exhibit/Advertising"));

		amexh.getamcExhibitTab().click();		
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		amexh.getExpLogin().click();
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}

		System.out.println("Switch window");
		//Verify that 'EXP Login' page should be displayed
		Thread.sleep(5000);
		Assert.assertTrue(amexh.getExpPortalHeader().getText().contains("Sign in with your existing account"));

		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		//Click Advertising Link
		amexh.getExpFAQs().click();
		System.out.println("Click FAQs Link");
		//Verify that FAQs page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://uat-amc.imcmvdp.com/Exhibit/FAQs"));


	}



	/*@AfterSuite
	public void sendEmail()
	{
		se = new SendEmail();
		se.sendEmailWithAttachment();
	}*/

}