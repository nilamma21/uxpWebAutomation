package PROD;
import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
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
import pageObjects.LasVegasApparel.LVAVisitTab;
import pageObjects.AtlantaApparel.ATLAppFooterLinksNavigationPage;
import pageObjects.LasVegasMarket.UXPExhibitorsAndProductsTabPage;
import pageObjects.LasVegasMarket.UXPFooterLinksNavigationPage;
import pageObjects.LasVegasMarket.UXPGlobalSearchPage;
import pageObjects.LasVegasMarket.UXPHeaderChannelLinksPage;
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
	UXPHeaderChannelLinksPage hd;
	UXPExhibitorsAndProductsTabPage exhp;
	UXPGlobalSearchPage gs;
	LVAVisitTab vt;
	UXPFooterLinksNavigationPage fl;
	
	@BeforeClass
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		//DOMConfigurator.configure("log4j.xml");
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Navigate to Las Vegas Apparel Site
		driver.get(prop.getProperty("lvmappurl"));
		lap.getIUnderstandBtn().click();
	}
	

	@Test(priority=1)
	public void TS001_LVMApp_VerifyAllHeaderChanelLinksTest() throws InterruptedException, IOException{
		//The purpose of this test case to verify:-
		//UXP-TS513: To verify all channels links in Header

		lvach = new LVAAllChannelsLinksPage(driver);
		hd = new UXPHeaderChannelLinksPage(driver);
		
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(8000);
		
		// New Code for Header Channel Links
		// Verify that Atlanta link is present
		Assert.assertTrue(hd.getAtlanta().getText().equalsIgnoreCase("ATLANTA"));
		Thread.sleep(2000);
		
		// Check Atlanta Apparel
		hd.getAtlanta().click();
		utl.windowHandle(hd.getAtlantaApparel(), "https://www.atlanta-apparel.com/");
		
		// Check Casual Market Atlanta
		hd.getAtlanta().click();
		utl.windowHandle(hd.getCasualMarketAtlantaURL(), "https://casualmarketatlanta.com/");

		// Check Atlanta Market
		hd.getAtlanta().click();
		utl.windowHandle(hd.getAtlantaMarket(), "https://www.atlantamarket.com/");
		
		// Check Formal Markets
		hd.getAtlanta().click();
		utl.windowHandle(hd.getFormalMarkets(), "Formal-Markets");
		
		// Check Cash & Carry Markets: Spring and Fall
		hd.getAtlanta().click();
		// Check markets for Spring or Fall
		try {
		utl.windowHandle(hd.getSpringCashAndCarry(), "Spring-Cash-and-Carry");
		
		}catch (Exception e) {
			utl.windowHandle(hd.getFllCashAndCarryMarketsSpringandFall(), "Fall-Cash-and-Carry");
		}

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
		utl.windowHandle(hd.getLasVegasDesignCenter(), "https://www.lasvegasmarket.com/Year-Round/LVDC");
		
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
		utl.windowHandle(hd.getSHOPPEOBJECT(), "https://shoppeobject.com/");
	}
	
	@Test(priority=2)
	public void TS002_LVMApp_VerifyGlobalSearchFunctionalityTest() throws InterruptedException {
		//The purpose of this test case to verify:-
		//UXP-T512: To verify global search functionality
		
		gs = new UXPGlobalSearchPage(driver);
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		
		try {
			gs.getGlobalSearchEnterText().isDisplayed();
			gs.getGlobalSearchEnterText().sendKeys((prop.getProperty("globalsearchinput3")));
			Thread.sleep(1000);
			gs.getSearchButtonNew().click();
			Thread.sleep(5000);
			String searchterm = gs.getVerifyGlobalSeacrhNew().getText();
			Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput3")));
			System.out.println("Global Search functionality is working properly.");
		} catch (Exception e) {

			gs.getGlobalSearchTextBoxNew().click();

			gs.getGlobalSearchEnterText().sendKeys((prop.getProperty("globalsearchinput3")));
			Thread.sleep(1000);
			gs.getSearchButtonNew().click();
			Thread.sleep(5000);
			String searchterm = gs.getVerifyGlobalSeacrhNew().getText();
			System.out.println(searchterm);
			Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput3")));
			System.out.println("Global Search functionality is working properly.");
		}
	}

	@Test(priority=3)
	public void TS003_LVMApp_VerifyExhibitorsDirectoryTab () throws InterruptedException {
		//The purpose of this test case to verify:-
		//UXP-T509: To verify Attend Tab
		lvaept = new LVAExhibitorAndProductTab(driver);
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(4000);
		
	//Verify Exhibitor Directory Page
		lvaept.getLVAExhibitorDirectoryTab().click();
		Thread.sleep(500);
		//Click on Exhibitor Directory
		lvaept.getLVAExhibitorDirectory().click();
		Thread.sleep(3000);
		//Verify Exhibitor Directory Page
		Assert.assertTrue(driver.getCurrentUrl().contains("exhibitors"));
		System.out.println("Exhibitor Directory Page is present");	

	//Verify Open Showrooms Page
		lvaept.getLVAExhibitorDirectoryTab().click();
		Thread.sleep(500);
		//Click on Open Show Room
		lvaept.getLVAOpenShowroom().click();
		Thread.sleep(3000);
		//Verify Open Show Room Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Showrooms"));
		System.out.println("Open Showroom Page is present");	
		
	//Verify Floor Plans Page
		lvaept.getLVAExhibitorDirectoryTab().click();
		Thread.sleep(500);
		//Click on Floor Plans
		lvaept.getLVAFloorPlans().click();
		Thread.sleep(3000);
		//Verify Floor Plans Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Map"));
		System.out.println("Floor Plans Page is present");	
		
	//Verify Trend Report Page
		lvaept.getLVAExhibitorDirectoryTab().click();
		Thread.sleep(500);
		//Click on Trend Report
		lvaept.getLVMTrendReport().click();
		Thread.sleep(3000);
		//Verify Trend Report Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Trends"));
		System.out.println("Trend Report Page is present");	
		
	/*
	//Verify List Of Brands Page
		lvaept.getLVAExhibitorDirectoryTab().click();
		//Click on List Of Brands
		System.out.println("Click on List Of Brands Tab");
		lvaept.getLVAListOfBrands().click();
		//Verify List Of Brands Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Brands"));
		System.out.println("Verify Complete List Of Brands Page");	
	*/
		
	}
	
	@Test(priority=4)
	public void TS004_LVMApp_VerifyAboutTab () throws InterruptedException {
		//The purpose of this test case to verify:-
		//UXP-T508: To verify About Tab
		lvaat = new LVAAboutTab(driver);
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
	
	//Press Center
		lvaat.getLVAAboutTab().click();
		//Click on Press Center
		System.out.println("Click on About Tab");
		lvaat.getLVAPressCenter().click();
		Thread.sleep(2000);
		//Verify Press Center Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Press-Center"));
		System.out.println("Verify Complete Press center Page");		
		Thread.sleep(3000);
	
	//Contact Us
		lvaat.getLVAAboutTab().click();
		//Click on Contact Us
		System.out.println("Click on About Tab");
		lvaat.getLVAContactUs().click();
		Thread.sleep(2000);
		//Verify Contact Us Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Contact-Us"));
		System.out.println("Verify Complete Contact Us Page");	
		
	//Dates and Hours
		lvaat.getLVAAboutTab().click();
		System.out.println("Click on About Tab");
		//Click on Dates & Hours
		lvaat.getLVADatesAndHours().click();
		System.out.println("Click on Dates and Hourss");
		Thread.sleep(2000);
		//Verify Dates and Hours Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Market-Dates-and-Hours"));
		System.out.println("Verify Complete Dates and Hours Page");
	}
	
	
	@Test(priority=5)
	public void TS005_LVMApp_VerifyVisitTab () throws InterruptedException {
		vt = new LVAVisitTab(driver);
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
	
	//Why Attend?
		vt.getLVAVisitTab().click();
		Thread.sleep(500);
		//Click on Click on Why Attend?
		vt.getLVAWhyAttend().click();
		Thread.sleep(3000);
		//Verify Attend Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Attend"));	
		System.out.println("Why Ateend Page is Present");
		
	//Register
		vt.getLVAVisitTab().click();
		Thread.sleep(500);
		//CLick on Registration Markets
		vt.getLVARigister().click();
		Thread.sleep(3000);
		//Verify reg Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Market-Dates-and-Hours"));
		System.out.println("Dining Page is Present");	
		
	//Travel
		vt.getLVAVisitTab().click();
		Thread.sleep(500);
		//CLick on Travel
		vt.getLVTravel().click();
		Thread.sleep(3000);
		//Verify Travel Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Travel"));	
		System.out.println("Travel Page is Present");
		
	//Events
		vt.getLVAVisitTab().click();
		Thread.sleep(500);
		//Click on Click on Events
		vt.getLVAEvents().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Events"));	
		System.out.println("Why Ateend Page is Present");
		
	//Dining
		vt.getLVAVisitTab().click();
		Thread.sleep(500);
		//CLick on Dining
		vt.getLVDining().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Dining"));	
		System.out.println("Dining Page is Present");
		
	//Services and Amenities
		vt.getLVAVisitTab().click();
		Thread.sleep(500);
		//CLick on Dining
		vt.getLVServicesAndAmenities().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Services-and-Amenities"));	
		System.out.println("Services and Amenities Page is Present");
		
	//Download the App
		vt.getLVAVisitTab().click();
		Thread.sleep(500);
		//CLick on Download app img
		vt.getLVDownloadApp().click(); 
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Plan-Your-Market"));	
		System.out.println("Download App Page is Present");
		
	}

	@Test(priority=6)
	public void TS006_LVMApp_VerifyExhibitTab () throws InterruptedException {
		//The purpose of this test case to verify:-
		//UXP-T506: To verify Exhibit Tab
		
		lvaet = new LVAExhibitTab(driver);
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		
	//Why Exhibit
		lvaet.getLVAExhibitTab().click();
		//click on Why Exhibit? link
		lvaet.getLVAWhyExhibit().click();
	
		//Verify Why Exhibit? Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Exhibit"));
		System.out.println("Why Exhibit? Page is Present");
		
	//Exhibitor Resources - Link issue
	
//		lvaet.getLVAExhibitTab().click(); //Click on Exhibitor Resources link
//		lvaet.getLVAExhibitorResources().click();
//		
//		//Verify Exhibitor Resources Page
//		Assert.assertTrue(driver.getCurrentUrl().contains("Exhibit"));
//		System.out.println("Exhibitor Resources Page is Present");
	 
	//Already on Exhibitor?
		lvaet.getLVAExhibitTab().click();
		String winHandleBefore = driver.getWindowHandle();
		//Click on Already on Exhibitor? link
		lvaet.getLVAAlreadyOnExhibitor().click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		//Verify Already on Exhibitor? Page
		Assert.assertTrue(driver.getCurrentUrl().contains("b2clogin.com"));
		System.out.println("Already on Exhibitor? Page is Present");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		
/*
	//Verify Exhibitor Portal Login
		lvaet.getLVAExhibitTab().click();
		//click on Exhibitor Portal Login
		lvaet.getLVAExhibitorPortalLogin().click();
		System.out.println("click on Exhibitor Portal Login");
		//Verify Exhibitor Portal Login Page
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://prodmvdp.b2clogin.com/"));
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		
	//Verify Market Toolkit
		lvaet.getLVAExhibitTab().click();
		//click on Market Toolkit
		lvaet.getLVAMarketToolkit().click();
		System.out.println("click on Market Toolkit");
		//Verify Market Toolkit Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Market-Toolkit"));
		
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
*/		
	}
	
	@Test(priority=7)
	public void TS007_LVMApp_VerifyFooterLinksTest () throws InterruptedException {
		//The purpose of this test case to verify:-
		//UXP-T510 : To verify Footer Links Navigation
	
		lvafl = new LVAFooterLinksNavigationPage(driver);
		utl=new Utility(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		fl = new UXPFooterLinksNavigationPage(driver);
		
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(8000);
		utl.scrollToBottom();
		
		// Market Information
		utl.windowHandle(fl.getmarketInfo(), "About");
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Click on Press Center
		utl.windowHandle(fl.getpressCenterAMC(), "Press-Center");
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Download the ANDMORE Markets App 
		utl.windowHandle(fl.getDownloadTheApp(), "Plan-Your-Market");
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Our Brands
		utl.windowHandle(fl.getOurBrandsATL(), "exhibitor-directory");
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Contact Us
		utl.windowHandle(fl.getContactUsATL(), "Contact-Us");
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Careers
		utl.windowHandle(fl.getCareersATL(), "andmore.com/our-team");
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
				
		//Americas Mart
		utl.windowHandle(fl.getAmericasMart_ATLAppFooter(), "americasmart.com");
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Atlanta Apparel
		utl.windowHandle(fl.getAtlantaApparel(), "atlanta-apparel.com");
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Atlanta Market
		utl.windowHandle(fl.getAtlantaMarket(), "atlantamarket.com");
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Casual Market Atlanta
		utl.windowHandle(fl.getCasualMarketAtlanta(), "casualmarketatlanta.com");
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Las Vegas Market
		utl.windowHandle(fl.getlvmlink_ATL(), "https://www.lasvegasmarket.com/");
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();

		//ANDMORE at High Point Market
		utl.windowHandle(fl.getHighPointMarket(), "andmorehighpointmarket.com");
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();

		//ANDMORE
		utl.windowHandle(fl.getandmore(), "https://www.andmore.com/");
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();

		//Terms & Conditions
		utl.windowHandle(fl.getTermsAndConditions(), "terms-of-use");
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(3000);
		utl.scrollToBottom();
		
		//Privacy Policy
		utl.windowHandle(fl.getatlprivacypolicy(), "privacy-policy");
	}
	
	@Test(priority=8)
	public void TS008_LVMApp_VerifySocialMediaLinksTest () throws InterruptedException {
		//The purpose of this test case to verify:-
		//UXP-T511: To verify the all social media links and it's redirection

		atlfo=new ATLAppFooterLinksNavigationPage(driver);
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
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
		driver.close();
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
	
	@Test(enabled=false)//priority=9
	public void TS009_LVMApp_MarketRecap() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T797: Market Recap page opens successfully.
		lap = new UXPLandingPage(driver);
		
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Thread.sleep(2000);
		utl.scrollToElement(lap.getMarketRecap());
		//Verify Market Recap link is working properly
		lap.getMarketRecap().click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/Attend/App"));
		System.out.println("Market Recap page is working properly.");
	}
	
	@Test(enabled=false)//priority=3
	public void TS010_ATLApp_VerifyExhibitorDirectoryTest() throws InterruptedException {
		
	}
	
	@Test(enabled=false)//(priority=11)
	public void TS011_LVM_PlanYourMarkett() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T786: To verify Plan Your Market
		lap = new UXPLandingPage(driver);
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Verify Plan your market link is working properly
		lap.getplanYourMarket().click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/Attend/App"));
		System.out.println("Plan Your Market page is working properly.");
	}
	
	@Test(enabled=false)
	public void TS005_LVMApp_VerifyAllLinksUnderAttendTabTest () throws InterruptedException {
		//The purpose of this test case to verify:-
		//UXP-T507: To verify Attend Tab
		lvaa = new LVAAttendPage(driver);
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);

		//Click on Attend Tab
		//utl.scrollToElement(lvaa.getLVAAttendTab());
		driver.get(prop.getProperty("lvmappurl"));
		Thread.sleep(3000);
		lvaa.getLVAAttendTab().click();
		Thread.sleep(1000);
		//CLick on Air Travel
		lvaa.getLVAirTravel().click();
		System.out.println("Click on Air Travel");
		Thread.sleep(1000);
		//Verify Hotels Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Travel"));
		System.out.println("Vefiry Events Page ");
		
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//utl.scrollToElement(lvaa.getLVAAttendTab());
		
		Thread.sleep(5000);
		//Click on Attend Tab
		lvaa.getLVAAttendTab().click();
		Thread.sleep(1000);
		//CLick on Parking
		lvaa.getLVParking().click();
		System.out.println("Click on Parking");
		Thread.sleep(1000);
		//Verify Faq Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Travel"));
		System.out.println("Vefiry Parking Page");

		//utl.scrollToElement(lvaa.getLVAAttendTab());
		driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Click on Attend Tab
		Thread.sleep(5000);
		lvaa.getLVAAttendTab().click();
		Thread.sleep(1000);
		//Click on Hotels
		lvaa.getLVHotels().click(); 
		System.out.println("Click on Hotels");
		Thread.sleep(1000);
		//Verify Hotels Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Travel"));
		System.out.println("Vefiry Hotels Page");
	}
	
	@Test(enabled=false)
	public void TS003_LVMApp_VerifyAllLinksUnderAboutTabTest () throws InterruptedException {
		
		//The purpose of this test case to verify:-
		//UXP-T508: To verify About Tab

		 lvaat = new LVAAboutTab(driver);
		 driver.get(prop.getProperty("lvmappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);

	//Verify Dates & Hours Page
		lvaat.getLVAAboutTab().click();
		System.out.println("Click on About Tab");
		//Click on Dates & Hours
		lvaat.getLVADatesAndHours().click();
		System.out.println("Click on Dates and Hourss");
		Thread.sleep(2000);
		//Verify Dates and Hours Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Market-Dates-and-Hours"));
		System.out.println("Verify Complete Dates and Hours Page");		
		Thread.sleep(3000);
	//Verify Press Center Page
		lvaat.getLVAAboutTab().click();
		//Click on Press Center
		System.out.println("Click on About Tab");
		lvaat.getLVAPressCenter().click();
		Thread.sleep(2000);
		//Verify Press Center Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Press-Center"));
		System.out.println("Verify Complete Press center Page");		
		Thread.sleep(3000);
	//Verify In The News Page
		lvaat.getLVAAboutTab().click();
		//Click on In the News
		System.out.println("Click on About Tab");
		lvaat.getLVAInTheNews().click();
		Thread.sleep(2000);
		//Verify In The News Page
		Assert.assertTrue(driver.getCurrentUrl().contains("In-The-News"));
		System.out.println("Verify Complete In The News Page");		
		Thread.sleep(5000);
	//Verify Contact Us Page
		lvaat.getLVAAboutTab().click();
		//Click on Contact Us
		System.out.println("Click on About Tab");
		lvaat.getLVAContactUs().click();
		Thread.sleep(2000);
		//Verify Contact Us Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Contact-Us"));
		System.out.println("Verify Complete Contact Us Page");		
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}