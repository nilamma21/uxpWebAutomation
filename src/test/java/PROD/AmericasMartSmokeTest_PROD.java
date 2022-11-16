package PROD;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
//import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
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

	@BeforeClass
	public void initialize() throws IOException, InterruptedException
	{
		//DOMConfigurator.configure("log4j.xml");
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);

		try {
		//Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(5000);
		lap.getIUnderstandBtn().click();
		Thread.sleep(5000);
		//utl.verifyCloseBtnPopup();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority=1)
	public void TS001_VerifyMarketPlannerLoginTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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
		Thread.sleep(10000);
		String searchterm = atlgs.getATLVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("exhibitordirectory")));
		System.out.println("Exhibitor Directory page is working properly.");
		driver.get(prop.getProperty("ammarturl"));
	}

	@Test(priority=7)
	public void TS007_VerifyAllSocialMediaLinksOnFooterTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-013: To verify the all social media links and it's redirection

		amfl = new AMFooterLinksNavigationPage(driver);
		utl = new Utility(driver); 
		fl = new UXPFooterLinksNavigationPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		utl.verifyCloseBtnPopup();
		//Scroll till footer links
		utl.scrollToElement(fl.getHighPointMarket());
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

	@Test(priority=5)
	public void TS005_VerifyAllLinksUnderAboutTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T005: To verify links for Market info tab at Header

		mi = new UXPMarketInfoPage(driver);
		amab = new AMAboutTabPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		utl.verifyCloseBtnPopup();
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
		utl.verifyCloseBtnPopup();
		//Click on Atlanta Market 
		hd.getAtlantaMarket().click();
		//Verify that Atlanta Market Home page should be displayed
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Market at AmericasMart"));
		driver.get(prop.getProperty("ammarturl"));
		utl.verifyCloseBtnPopup();
		//Click on Atlanta Apparel 
		hd.getAtlantaApparel().click();
		//Verify that Atlanta App Home page should be displayed
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Apparel at AmericasMart"));
		driver.get(prop.getProperty("ammarturl"));
		utl.verifyCloseBtnPopup();
		//Click on AmericasMart 
		hd.getAmericasMart().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Wholesale Gift, Home, Rug and Apparel Markets"));
		System.out.println("Americas Mart channel link is working properly.");
		driver.get(prop.getProperty("ammarturl"));
		utl.verifyCloseBtnPopup();
		//Click on High Point Market 
		hd.getHighPoint().click();
		Assert.assertTrue(driver.getTitle().contains("High Point"));
		driver.get(prop.getProperty("ammarturl"));
		utl.verifyCloseBtnPopup();
		//Click on Las Vegas Market 
		hd.getLasVegas().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas"));
		driver.get(prop.getProperty("ammarturl"));
		utl.verifyCloseBtnPopup();
		//Click on Las Vegas Apparel
		atlch.getLasVegasApp().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Apparel"));
		driver.get(prop.getProperty("ammarturl"));
	}


	@Test(priority=12)
	public void TS012_VerifyAllLinksUnderMarketsAndEventsTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T012: To verify links for Attend tab at Header

		mi = new UXPMarketInfoPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		atat = new ATLAttendPage(driver);
		amme = new AMMarketsAndEventsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		utl.verifyCloseBtnPopup();
		//Click Markets and Events tab at Header
		//Thread.sleep(3000);
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
		utl.verifyCloseBtnPopup();
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
		atlfl = new ATLFooterLinksNavigationPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//	utl.verifyCloseBtnPopup();

		
		utl.scrollToElement(fl.marketInfoAMC());
	
		//Click Market Info link and verify results
		fl.marketInfoAMC().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/about"));
		System.out.println("Market Info Page open successfully");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());
		
		//Click on Press Center
		fl.getpressCenterAMC().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/About/Press-Center"));
		System.out.println("Press center Page open successfully");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());
		
		// Click Download The App link and verify results
		fl.getDownloadTheApp().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "App");
		System.out.println("Download App Page open successfully");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());
		
		//Click on Our Brancd link
		fl.getOurBrandsATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/exhibitor/directory"));
		System.out.println("Our Brands Page open successfully");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());
		
		// Click Contact Us link and verify results
		fl.getContactUsATL().click();	
		Assert.assertEquals(mi.getverifyContactUsATL().getText(), "Contact Us");
		System.out.println("Contact us Page open successfully");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());
		
		// Click Careers link and verify results		
		fl.getCareersATL().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Careers");
		// driver.get(prop.getProperty("atlappurl"));
		System.out.println("Careers Page open successfully");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());
		
		// Click on Terms & condition link
		fl.getTermsAndConditions().click();
		// Switch to new tab
		String winHandleBefore7 = driver.getWindowHandle();
		for (String winHandle7 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle7);
		}
		Assert.assertEquals(fl.getVerifyTermsOfUse().getText(), "TERMS OF USE");
		System.out.println("Terms And Conditions Page open successfully");
		driver.close();
		driver.switchTo().window(winHandleBefore7);

		// Click Privacy Policy and verify results
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());
		// Click Privacy Policy link and verify results
		fl.getatlprivacypolicy().click();
		String winHandleBefore8 = driver.getWindowHandle();
		for (String winHandle8 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle8);
		}
		Assert.assertEquals(fl.getVerifyTermsOfUse().getText(), "IMC PRIVACY STATEMENT");
		System.out.println("Privacy Policy Page open successfully");
		driver.close();
		driver.switchTo().window(winHandleBefore8);
		// utl.scrollToElement(fl.marketInfoAMC());
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());
		
		// Click Americas Mart link and verify results
		/*fl.getAmericasMart_ATLApp().click();
		String winHandleBefore9 = driver.getWindowHandle();
		for (String winHandle9 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle9);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/"));
		System.out.println("AmericasMart Page open successfully");
		driver.close();
		driver.switchTo().window(winHandleBefore9);
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());*/
	
		// Click Atlanta Market link and verify results
		fl.getAtlantaMarket().click();
		// Switch to new tab
		String winHandleBefore1 = driver.getWindowHandle();
		for (String winHandle1 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle1);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		System.out.println("Atlanta Market Page open successfully");
		driver.close();
		driver.switchTo().window(winHandleBefore1);
		utl.scrollToElement(fl.marketInfoAMC());

		// Click Atlanta Apparel link and verify results
		fl.getAtlantaApparel().click();
		// Switch to new tab
		String winHandleBefore2 = driver.getWindowHandle();
		for (String winHandle2 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle2);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		System.out.println("Atlanta App Page open successfully");
		driver.close();
		driver.switchTo().window(winHandleBefore2);
		utl.scrollToElement(fl.marketInfoAMC());
		
		// Click on High Point Market link
		// Switch to new tab
		String winHandleBefore4 = driver.getWindowHandle();
		fl.getHighPointMarket().click();
		for (String winHandle4 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle4);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imchighpointmarket.com/"));
		System.out.println("High point Market Page open successfully");
		driver.close();
		driver.switchTo().window(winHandleBefore4);
		utl.scrollToElement(fl.marketInfoAMC());
		
		// Click on LVA Market link
		// Switch to new tab
		fl.getlvmlink_ATLM().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));
		System.out.println("Las Vegas App Page open successfully");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());
		
		// Click on LVM Market link
		// Switch to new tab
		String winHandleBefore11 = driver.getWindowHandle();
		fl.getlvmlink_ATL().click();
		for (String winHandle11 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle11);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/"));
		System.out.println("Las Vegas Market Page open successfully");
		driver.close();
		driver.switchTo().window(winHandleBefore11);
		utl.scrollToElement(fl.marketInfoAMC());		
		
		//Click International Market Centers link and verify results
		fl.getInternationalMarketCenters().click();
		//Switch to new tab
		String winHandleBefore3 = driver.getWindowHandle();
		for(String winHandle3 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle3);}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imcenters.com/"));
		driver.close();
		System.out.println("IMC Market Page open successfully");
		driver.switchTo().window(winHandleBefore3);
		utl.scrollToElement(fl.marketInfoAMC());		
		
		//Click Juniper Market Centers link and verify results
		fl.getJuniperMarket().click();
		//Switch to new tab
		String winHandleBefore12 = driver.getWindowHandle();
		for(String winHandle12 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle12);}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.junipermarket.com/"));
		driver.close();
		System.out.println("Juniper Market Page open successfully");
		driver.switchTo().window(winHandleBefore12);
		utl.scrollToElement(fl.marketInfoAMC());	
		
		
		
		
		
		
		
		
		
		//Scroll till footer links
	/*	utl.scrollToElement(fl.marketInfoAMC());

		//Click Market Info link and verify results
		fl.marketInfoAMC().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/about"));
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());

		//Click Atlanta Market link and verify results
		fl.getAtlantaMarket().click();

		//Switch to new tab
		String winHandleBefore3 = driver.getWindowHandle();

		for(String winHandle3 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle3);}

		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore3);
		utl.scrollToElement(fl.marketInfoAMC());

		//Click Atlanta Apparel link and verify results
		fl.getAtlantaApparel().click();

		//Switch to new tab
		String winHandleBefore4 = driver.getWindowHandle();

		for(String winHandle4 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle4);}

		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore4);
		utl.scrollToElement(fl.marketInfoAMC());

		//Click International Market Centers link and verify results
		fl.getInternationalMarketCenters().click();

		//Switch to new tab
		String winHandleBefore6 = driver.getWindowHandle();

		for(String winHandle6 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle6);}

		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imcenters.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore6);
		utl.scrollToElement(fl.marketInfoAMC());

		//Click on High Point Market link
		fl.getHighPointMarket().click();

		//Switch to new tab
		String winHandleBefore7 = driver.getWindowHandle();

		for(String winHandle7 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle7);}

		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imchighpointmarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore7);
		utl.scrollToElement(fl.marketInfoAMC());

		//Click Download The App link and verify results
		fl.getDownloadTheApp().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Market App");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());

		//Click Contact Us link and verify results
		fl.getContactUs().click();
		Assert.assertEquals(mi.getVerifyContactUs().getText(),"Contact Us");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());

		//Click Careers link and verify results
		fl.getCareers().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Careers");
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.marketInfoAMC());

		//Click on Terms & condition link
		fl.getTermsAndConditions().click();

		//Switch to new tab
		String winHandleBefore1 = driver.getWindowHandle();

		for(String winHandle1 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle1);}

		Assert.assertEquals(fl.getVerifyTermsOfUse().getText(),"TERMS OF USE");
		driver.close();
		driver.switchTo().window(winHandleBefore1);

		//Click Privacy Policy and verify results
		driver.get(prop.getProperty("ammarturl"));
		utl.scrollToElement(fl.getLVMPrivacyPolicyPLink());

		//Click Privacy Policy link and verify results
		fl.getLVMPrivacyPolicyPLink().click();

		String winHandleBefore2 = driver.getWindowHandle();

		for(String winHandle2 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle2);}

		Assert.assertEquals(fl.getVerifyTermsOfUse().getText(),"IMC PRIVACY STATEMENT");
		driver.close();
		driver.switchTo().window(winHandleBefore2);
		utl.scrollToElement(fl.marketInfoAMC());

		//Click Americas Mart link and verify results
		fl.getAmericasMart().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/"));
		driver.get(prop.getProperty("ammarturl"));
		
		*/
	}

	@Test(priority=9)
	public void TS009_VerifyGlobalSearchFunctionalityTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T63: To verify global search functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		gs = new UXPGlobalSearchPage(driver);
		atlgs = new ATLGlobalSearchPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		utl.verifyCloseBtnPopup();
		gs.getGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		gs.getSearchButton().click();
		//Thread.sleep(10000);
		String searchterm = atlgs.getATLVerifyGlobalSeacrh().getText();
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

		utl.verifyCloseBtnPopup();
		//Click on Open Year Round Tab 
		amoyr.getOpenYearRoundTab().click();

		//Click About Open Year Round Link
		amoyr.getAboutYearRound().click();
		//Verify that About Open Year Round page should be displayed
		String actualHeader="Open Year Round";
		Assert.assertTrue(amoyr.getAboutYearRoundPageHeader().getText().equals(actualHeader));

		//Verify how to register 
		amoyr.getOpenYearRoundTab().click();
		amoyr.gethowtoregister().click();
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("How to Register"));
		System.out.println("How to regiter opened");

		//Click on Open Year Round Tab 
		amoyr.getOpenYearRoundTab().click();
		//Click Showroom direct Link Link
		amoyr.getShoroomDirect().click();
		//Thread.sleep(5000);
		utl.scrollToElement(amoyr.getShowroomDirectPageHeader());
		//Verify that Showroom Direct page should be displayed
		String actualShowroomDirectHeader="Exhibitor Directory";
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
		atlps = new ATLProfileAndSettingsPage(driver);
		atlexh = new ATLExhibitPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Exhibit Tab 
		//Thread.sleep(3000);
		//utl.verifyCloseBtnPopup();
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
		amexh.getExpLogin().click();
		String winHandleBefore = driver.getWindowHandle();

		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);}

		Assert.assertTrue(driver.getCurrentUrl().contains("https://exhibitors.imcenters.com/"));
		System.out.println("Page opened successfully");
		driver.close();
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
		//Thread.sleep(5000);
		atlps.getATLWelcomeText().click();
		//Thread.sleep(5000);
		atlps.getATLProfileAndSettings().click();

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

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}



