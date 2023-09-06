package PROD;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.LasVegasApparel.LVAAboutTab;
import pageObjects.LasVegasApparel.LVAAllChannelsLinksPage;
import pageObjects.LasVegasApparel.LVAAttendPage;
import pageObjects.LasVegasApparel.LVAExhibitTab;
import pageObjects.LasVegasApparel.LVAExhibitorAndProductTab;
import pageObjects.LasVegasApparel.LVAFooterLinksNavigationPage;
import pageObjects.LasVegasApparel.LVAGlobalSearchPage;
import pageObjects.AtlantaApparel.ATLAppFooterLinksNavigationPage;
import pageObjects.LasVegasMarket.UXPLandingPage;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class LasVegasAppSmokeTest_PROD extends base {
	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	UXPLandingPage lap;
	LVAFooterLinksNavigationPage lvafl;
	LVAAllChannelsLinksPage lvach;
	LVAGlobalSearchPage lvags;
	ATLAppFooterLinksNavigationPage atlfo;
	LVAAttendPage lvaa;
	LVAAboutTab lvaat;
	LVAExhibitorAndProductTab lvaept;
	LVAExhibitTab lvaet;
	
	@BeforeClass
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		//DOMConfigurator.configure("log4j.xml");
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Navigate to Las Vegas Apparel Site
		driver.get(prop.getProperty("lvmappurl"));
		lap.getIUnderstandBtn().click();
	}
	

	@Test(priority=12)
	public void TS001_VerifyAllHeaderChanelLinksTest() throws InterruptedException, IOException{
		//The purpose of this test case to verify:-
		//UXP-TS513: To verify all channels links in Header

		lvach = new LVAAllChannelsLinksPage(driver);
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(8000);

		//Click Atlanta Market channel link and verify result
		lvach.getAtlantaMarket().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Market at AmericasMart"));
		System.out.println("Atlanta Market channel link is working properly.");
		driver.get(prop.getProperty("lvmappurl"));
		utl.verifyCloseBtnPopup();

		//Click Atlanta Apparel channel link and verify result
		lvach.getAtlantaApparel().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Atlanta Apparel at AmericasMart"));
		System.out.println("Atlanta Apparel channel link is working properly.");
		driver.get(prop.getProperty("lvmappurl"));
		utl.verifyCloseBtnPopup();

		//Click Americas Mart channel link and verify result
		lvach.getAmericasMart().click();
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Wholesale Gift, Home, Rug and Apparel Markets"));
		System.out.println("Americas Mart channel link is working properly.");
		driver.get(prop.getProperty("lvmappurl"));
		utl.verifyCloseBtnPopup();
		
		//Click Casual Market channel link and verify result
		lvach.getcasualMarket().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://casualmarketatlanta.com/"));
		System.out.println("Americas Mart channel link is working properly.");
		driver.get(prop.getProperty("lvmappurl"));
		utl.verifyCloseBtnPopup();

		//Click IMC High Point Market channel link and verify result
		lvach.getHighPoint().click();
		Thread.sleep(4000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmorehighpointmarket.com/"));
		System.out.println("High Point Market channel link is working properly.");
		driver.get(prop.getProperty("lvmappurl"));
		utl.verifyCloseBtnPopup();

		//Click Las Vegas Market channel link and verify result
		lvach.getLasVegas().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas"));
		System.out.println("Las Vegas Market channel link is working properly.");
		driver.get(prop.getProperty("lvmappurl"));
		utl.verifyCloseBtnPopup();

		//Click Las Vegas Market channel link and verify result
		lvach.getLasVegasApp().click();
		Thread.sleep(6000);
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Apparel"));
		System.out.println("Las Vegas Apparel channel link is working properly.");
		driver.get(prop.getProperty("lvmappurl"));
		
		//Click Formal Markets channel link and verify result
		lvach.getformalMarkets().click();
		Thread.sleep(6000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/Markets/Formal-Markets"));
		System.out.println("Formal-Markets channel link is working properly.");
		

	}
	
	@Test(priority=2)
	public void TS002_LVMApp_VerifyGlobalSearchFunctionalityTest() throws InterruptedException {
		//The purpose of this test case to verify:-
		//UXP-T512: To verify global search functionality
		
		lvags = new LVAGlobalSearchPage(driver);
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		lvags.getGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		lvags.getSearchButton().click();
		
		utl.scrollToElement(lvags.getVerifyGlobalSeacrh());
		String searchterm = lvags.getVerifyGlobalSeacrh().getText();
		
		Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput")));
		System.out.println("Global Search functionality is working properly.");
		
	}
	
	@Test(enabled=false)//priority=3
	public void TS003_ATLApp_VerifyExhibitorDirectoryTest() throws InterruptedException {
		

	}
	
	@Test(enabled=false)//(priority=11)
	public void TS010_LVM_PlanYourMarkett() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T786: To verify Plan Your Market
		lap = new UXPLandingPage(driver);
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Verify Plan your market link is working properly
		lap.getplanYourMarket().click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/Attend/App"));
		System.out.println("Plan Your Market page is working properly.");
		
	}
	
	@Test(priority=11)
	public void TS015_LVMApp_MarketRecap() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T797: Market Recap page opens successfully.
		lap = new UXPLandingPage(driver);
		
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Verify Market Recap link is working properly
		lap.getMarketRecap().click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/Attend/App"));
		System.out.println("Market Recap page is working properly.");
	}
	
	
	@Test(priority=5)
	public void TS004_LVMApp_VerifyAllLinksUnderAboutTabTest () throws InterruptedException {
		
		//The purpose of this test case to verify:-
		//UXP-T508: To verify About Tab

		 lvaat = new LVAAboutTab(driver);
		 driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);

	//Verify Dates & Hours Page
		lvaat.getLVAAboutTab().click();
		System.out.println("Click on About Tab");
		//Click on Dates & Hours
		lvaat.getLVADatesAndHours().click();
		System.out.println("Click on Dates and Hourss");
		//Verify Dates and Hours Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Market-Dates-and-Hours"));
		System.out.println("Verify Complete Dates and Hours Page");		
		
	//Verify Press Center Page
		lvaat.getLVAAboutTab().click();
		//Click on Press Center
		System.out.println("Click on About Tab");
		lvaat.getLVAPressCenter().click();
		//Verify Press Center Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Press-Center"));
		System.out.println("Verify Complete Press center Page");		
		
	//Verify In The News Page
		lvaat.getLVAAboutTab().click();
		//Click on In the News
		System.out.println("Click on About Tab");
		lvaat.getLVAInTheNews().click();
		//Verify In The News Page
		Assert.assertTrue(driver.getCurrentUrl().contains("In-The-News"));
		System.out.println("Verify Complete In The News Page");		
		
	//Verify Contact Us Page
		lvaat.getLVAAboutTab().click();
		//Click on Contact Us
		System.out.println("Click on About Tab");
		lvaat.getLVAContactUs().click();
		//Verify Contact Us Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Contact-Us"));
		System.out.println("Verify Complete Contact Us Page");		
		
	}
	
	@Test(priority=6)
	public void TS005_LVMApp_VerifyAllLinksUnderExhibitorsAndProductsTabTest () throws InterruptedException {
		//The purpose of this test case to verify:-
		//UXP-T509: To verify Attend Tab
		
		lvaept = new LVAExhibitorAndProductTab(driver);
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);
/*
	//Verify Exhibitor Directory Page
		lvaept.getLVAExhibitorAndProductTab().click();
		//Click on Exhibitor Directory
		System.out.println("Click on Exhibitor Directory Tab");
		lvaept.getLVAExhibitorDirectory().click();
		//Verify Exhibitor Directory Page
		Assert.assertTrue(driver.getCurrentUrl().contains("exhibitor-directory"));
		System.out.println("Verify Complete Exhibitor Directory Page");	

	//Verify List Of Brands Page
		lvaept.getLVAExhibitorAndProductTab().click();
		//Click on List Of Brands
		System.out.println("Click on List Of Brands Tab");
		lvaept.getLVAListOfBrands().click();
		//Verify List Of Brands Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Brands"));
		System.out.println("Verify Complete List Of Brands Page");	
*/
	//Verify Open Show Room Page
		lvaept.getLVAExhibitorAndProductTab().click();
		//Click on Open Show Room
		System.out.println("Click on OpenShowroom Tab");
		lvaept.getLVAOpenShowroom().click();
		//Verify Open Show Room Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Showrooms"));
		System.out.println("Verify Complete Open Showroom Page");	
		
	//Verify Floor Plans Page
		lvaept.getLVAExhibitorAndProductTab().click();
		//Click on Floor Plans
		System.out.println("Click on Floor Plans Tab");
		lvaept.getLVAFloorPlans().click();
		//Verify Floor Plans Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Market-Map"));
		System.out.println("Verify Complete Floor Plans Page");	
		
	}
	
	@Test(priority=7)
	public void TS006_LVMApp_VerifyAllLinksUnderAttendTabTest () throws InterruptedException {
		//The purpose of this test case to verify:-
		//UXP-T507: To verify Attend Tab
		lvaa = new LVAAttendPage(driver);
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		Thread.sleep(3000);
		//Click on Attend Tab
		lvaa.getLVAAttendTab().click();
		System.out.println("Click on Attend Tab");
		Thread.sleep(3000);
		//Click on Click on Why Attend?
		lvaa.getLVAWhyAttend().click();
		System.out.println("Click on Why Attend?");
		//Verify Attend Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/Attend"));	
		System.out.println("Vefiry Why Ateend Page");

		//Click on Attend Tab
		lvaa.getLVAAttendTab().click();
		//Click on Click on Events
		lvaa.getLVAEvents().click();
		System.out.println("Click on Events");
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/Attend/Events"));	
		System.out.println("Vefiry Why Ateend Page");
		
		//Click on Attend Tab
		lvaa.getLVAAttendTab().click();
		//CLick on Registration Markets
		lvaa.getLVADining().click();
		System.out.println("Click on Dining");
		//Verify reg Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/Attend/Dining"));
		System.out.println("Vefiry Dining Page");		
		
		
		lvaa.getLVAAttendTab().click();
		//CLick on Download app img
		lvaa.getLVDownloadApp().click(); 
		System.out.println("Click on Donwload App");
		//Thread.sleep(3000);
		//Verify Hotels Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/Attend/App"));	
		System.out.println("Vefiry Download App Page ");
		
		//Click on Attend Tab
		lvaa.getLVAAttendTab().click();
		//CLick on Travel
		lvaa.getLVTravel().click(); 
		System.out.println("Click on Travel");
		//Verify Travel Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/Attend/Travel"));	
		System.out.println("Vefiry Travel Page ");
		
		//Click on Attend Tab
		lvaa.getLVAAttendTab().click();
		//CLick on Air Travel
		lvaa.getLVAirTravel().click();
		System.out.println("Click on Air Travel");
		//Verify Hotels Page
		Assert.assertTrue(driver.getCurrentUrl().contains("#flights"));	
		System.out.println("Vefiry Events Page ");
		
		utl.scrollToElement(lvaa.getLVAAttendTab());
		//Click on Attend Tab
		lvaa.getLVAAttendTab().click();
		//CLick on Parking
		lvaa.getLVParking().click();
		System.out.println("Click on Parking");
		//Verify Faq Page
		Assert.assertTrue(driver.getCurrentUrl().contains("#parking"));
		System.out.println("Vefiry Parking Page");

		utl.scrollToElement(lvaa.getLVAAttendTab());
		//Click on Attend Tab
		lvaa.getLVAAttendTab().click();
		//Click on Hotels
		lvaa.getLVHotels().click(); 
		System.out.println("Click on Hotels");
		//Verify Hotels Page
		Assert.assertTrue(driver.getCurrentUrl().contains("#hotels"));
		System.out.println("Vefiry Hotels Page");
		
	}
	
	@Test(priority=8)
	public void TS007_LVMApp_VerifyAllLinksUnderExhibitTabTest () throws InterruptedException {
		//The purpose of this test case to verify:-
		//UXP-T506: To verify Exhibit Tab
		
		lvaet = new LVAExhibitTab(driver);
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
	//Verify Exhibitor Portal Login
		lvaet.getLVAExhibitTab().click();
		//click on Exhibitor Portal Login
		lvaet.getLVAExhibitorPortalLogin().click();
		System.out.println("click on Exhibitor Portal Login");
		//Verify Exhibitor Portal Login Page
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://prodmvdp.b2clogin.com/"));
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	//Verify Exhibitor Portal Guide
		lvaet.getLVAExhibitTab().click();
		String winHandleBefore = driver.getWindowHandle();
		//click on Exhibitor Portal Guide
		lvaet.getLVAExhibitorPortalGuide().click();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		System.out.println("click on Exhibitor Portal Guide");
		//Verify Exhibitor Portal Guide Page
		Thread.sleep(4000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://support.andmore.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore);
		
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
	//Verify Market Toolkit
		lvaet.getLVAExhibitTab().click();
		//click on Market Toolkit
		lvaet.getLVAMarketToolkit().click();
		System.out.println("click on Market Toolkit");
		//Verify Market Toolkit Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Market-Toolkit"));
		
	//Verify Why Exhibit?
		lvaet.getLVAExhibitTab().click();
		//click on Why Exhibit?
		lvaet.getLVAWhyExhibit().click();
		System.out.println("click on Why Exhibit?");
		//Verify Why Exhibit? Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Exhibit"));
		
	//Verify Advertising & Sponsorship
		lvaet.getLVAExhibitTab().click();
		//click on Advertising & Sponsorship
		lvaet.getLVAAdvertisingAndSponsorship().click();
		System.out.println("click on Advertising & Sponsorship");
		//Verify Advertising & Sponsorship Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Advertising"));
		
	//Verify Leasing Inquiry
		lvaet.getLVAExhibitTab().click();
		//click on Leasing Inquiry
		lvaet.getLVALeasingInquiry().click();
		System.out.println("click on Leasing Inquiry");
		//Verify Leasing Inquiry Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Inquiry"));
		
	}
	
	@Test(priority=9)
	public void TS008_LVMApp_VerifyFooterLinksTest () throws InterruptedException {
		//The purpose of this test case to verify:-
		//UXP-T510 : To verify Footer Links Navigation
	
		lvafl = new LVAFooterLinksNavigationPage(driver);
		utl=new Utility(driver);
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

/*		//Scroll till footer links
		utl.scrollToElement(fl.getmarketInfoATL());
		
		//Click Market Info link and verify results
		fl.getmarketInfoATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/Markets"));
		driver.get(prop.getProperty("atlappurl"));
		utl.scrollToElement(fl.marketInfoAMC());
*/
		utl.scrollToElement(lvafl.getourBrandsLVA());
		//Click on Our Brand link
		lvafl.getourBrandsLVA().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/exhibitor/directory"));
		driver.get(prop.getProperty("lvmappurl"));
		utl.scrollToElement(lvafl.marketInfoAMC());
				
		// Click Download The App link and verify results
		lvafl.getDownloadTheApp().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/Attend/App"));
		driver.get(prop.getProperty("lvmappurl"));
		utl.scrollToElement(lvafl.marketInfoAMC());
		
		// Click Contact Us link and verify results
		lvafl.getContactUsLVA().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("about/contact-us"));
		driver.get(prop.getProperty("lvmappurl"));
		utl.scrollToElement(lvafl.marketInfoAMC());
		
		// Click Careers link and verify results
		String winHandleBefore = driver.getWindowHandle();
		lvafl.getCareersATL().click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/careers"));
		driver.close();
		driver.switchTo().window(winHandleBefore);
		utl.scrollToElement(lvafl.marketInfoAMC());
				
		// Click on Terms & condition link
		
		// Switch to new tab
		String winHandleBefore2 = driver.getWindowHandle();
		lvafl.getTermsAndConditions().click();
		for (String winHandle2 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle2);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/terms-of-use"));
		driver.close();
		driver.switchTo().window(winHandleBefore2);
		// Click Privacy Policy and verify results
		/*driver.get(prop.getProperty("lvmappurl"));
		utl.scrollToElement(lvafl.marketInfoAMC());*/
		
		// Click Privacy Policy link and verify results
		
		String winHandleBefore3 = driver.getWindowHandle();
		lvafl.getatlprivacypolicy().click();
		for (String winHandle3 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle3);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/privacy-policy"));
		driver.close();
		driver.switchTo().window(winHandleBefore3);
		// utl.scrollToElement(fl.getmarketInfoATL());
		/*driver.get(prop.getProperty("lvmappurl"));
		utl.scrollToElement(lvafl.marketInfoAMC());*/

		// Click Americas Mart link and verify results
		
		String winHandleBefore4 = driver.getWindowHandle();
		lvafl.getAmericasMart_ATLApp().click();
		for (String winHandle4 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle4);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore4);
		/*driver.get(prop.getProperty("lvmappurl"));
		utl.scrollToElement(lvafl.marketInfoAMC());*/
		
		// Click Atlanta Apparel link and verify results
		
		// Switch to new tab
		String winHandleBefore5 = driver.getWindowHandle();
		lvafl.getAtlantaApparel().click();
		for (String winHandle5 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle5);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		driver.get(prop.getProperty("lvmappurl"));
		driver.close();
		driver.switchTo().window(winHandleBefore5);
		//utl.scrollToElement(lvafl.marketInfoAMC());
				
		// Click Atlanta Market link and verify results
		
		// Switch to new tab
		String winHandleBefore6 = driver.getWindowHandle();
		lvafl.getAtlantaMarket().click();
		for (String winHandle6 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle6);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore6);
	//	utl.scrollToElement(lvafl.marketInfoAMC());
		
		// Click on Casual Market link
				// Switch to new tab
		String winHandleBefore7 = driver.getWindowHandle();
		lvafl.getCasualMarket().click();
		for (String winHandle7 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle7);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://casualmarketatlanta.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore7);
		//utl.scrollToElement(lvafl.marketInfoAMC());

		// Click on High Point Market link
		// Switch to new tab
		String winHandleBefore8 = driver.getWindowHandle();
		lvafl.getHighPointMarket().click();
		for (String winHandle8 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle8);
		}
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmorehighpointmarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore8);
		//utl.scrollToElement(lvafl.marketInfoAMC());
				
				
		// Click on LVM Market link
		// Switch to new tab
		String winHandleBefore9 = driver.getWindowHandle();
		lvafl.getlvmlink_ATL().click();
		for (String winHandle9 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle9);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore9);
		//utl.scrollToElement(lvafl.marketInfoAMC());		
				
		// Click on ANDMORE link
		// Switch to new tab
		
		//Switch to new tab
		String winHandleBefore10 = driver.getWindowHandle();
		lvafl.getandmore().click();
		for(String winHandle10 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle10);}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore10);
		//utl.scrollToElement(lvafl.marketInfoAMC());	
	}
	
	@Test(priority=10)
	public void TS009_LVMApp_VerifySocialMediaLinksTest () throws InterruptedException {
		//The purpose of this test case to verify:-
		//UXP-T511: To verify the all social media links and it's redirection

		atlfo=new ATLAppFooterLinksNavigationPage(driver);
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Scroll till footer links
		utl.scrollToElement(atlfo.getfacebookfootericon());
		
		//Click on Facebook Icon
		atlfo.getfacebookfootericon().click();
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Thread.sleep(10000);
		//Verify that 'Las Vegas Facebook' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/apparelmarkets/"));
		
		// Close the new window, if that window no more required
		driver.close();
		
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
/*		
		//Click on Instagram Icon
		atlfo.getinstagramfootericon().click();
		String winHandleBefore2 = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		//Verify that 'Las Vegas Instagram' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.instagram.com/apparelmarkets/"));

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore2);
*/		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}