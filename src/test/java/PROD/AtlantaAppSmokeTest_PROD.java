package PROD;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.ExhibitorPortal.EXPLoginPage;
import pageObjects.AmericasMart.AMAboutTabPage;
import pageObjects.AmericasMart.AMExhibitTabPage;
import pageObjects.AmericasMart.AMFooterLinksNavigationPage;
import pageObjects.AmericasMart.AMHeaderLinksPage;
import pageObjects.AmericasMart.AMMarketsAndEventsPage;
import pageObjects.AmericasMart.AMOpenYearRoundPage;
import pageObjects.AtlantaApparel.ATLAppAttendTabPage;
import pageObjects.AtlantaApparel.ATLAppDiscoverTab;
import pageObjects.AtlantaApparel.ATLAppExhibitTabPage;
import pageObjects.AtlantaApparel.ATLAppExhibitorDirectoryTab;
import pageObjects.AtlantaApparel.ATLAppExhibitorsAndProductTabPage;
import pageObjects.AtlantaApparel.ATLAppFashionGalleryTabPage;
import pageObjects.AtlantaApparel.ATLAppFooterLinksNavigationPage;
import pageObjects.AtlantaApparel.ATLAppGlobalSearchPage;
import pageObjects.AtlantaApparel.ATLAppMarketsAndEventsTab;
import pageObjects.AtlantaApparel.ATLAppMarketsTabPage;
import pageObjects.AtlantaApparel.ATLAppVisitTabPage;
import pageObjects.AtlantaApparel.ATLAppYearRoundTabPage;
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
public class AtlantaAppSmokeTest_PROD extends base {
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
	ATLAppMarketsTabPage atlm;
	ATLAppExhibitorsAndProductTabPage atlappexh;
	UXPAttendPage atlva;
	ATLAppAttendTabPage atlatt;
	ATLAppFashionGalleryTabPage atlf;
	ATLAppExhibitTabPage atlExhi;
	UXPYearRoundPage atly;
	ATLAppYearRoundTabPage atlyr;
	ATLAppFooterLinksNavigationPage atlfo;
	ATLAppGlobalSearchPage gbs;
	UXPProfileAndSettingsPage ps;
	EXPLoginPage el;
	SendEmail se;
	ATLAppVisitTabPage vtp;
	ATLAppExhibitorDirectoryTab edp;
	ATLAppMarketsAndEventsTab mae;
	ATLAppDiscoverTab dt;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		//DOMConfigurator.configure("log4j.xml");
		
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);

		//Navigate to Atlanta Apparel site
		//driver.manage().window().maximize();
		driver.get(prop.getProperty("atlappurl"));
		Thread.sleep(3000);
		//Thread.sleep(8000);
		lap.getIUnderstandBtn().click();
		utl.waitForPageToLoad();
		//Thread.sleep(5000);
	}
	
	@Test(priority=1)
	public void TS001_ATLApp_VerifyGlobalSearchFunctionalityTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T04: To verify global search functionality

		utl=new Utility(driver);
		gs = new UXPGlobalSearchPage(driver);

		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		try {
			gs.getGlobalSearchEnterText().isDisplayed();
			gs.getGlobalSearchEnterText().sendKeys((prop.getProperty("globalsearchinput2")));
			Thread.sleep(1000);
			gs.getSearchButtonNew().click();
			Thread.sleep(5000);
			String searchterm = gs.getVerifyGlobalSeacrhNewSecond().getText();
			Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput2")));
			System.out.println("Global Search functionality is working properly.");
		} catch (Exception e) {

			gs.getGlobalSearchTextBoxNew().click();

			gs.getGlobalSearchEnterText().sendKeys((prop.getProperty("globalsearchinput2")));
			Thread.sleep(1000);
			gs.getSearchButtonNew().click();
			Thread.sleep(5000);
			String searchterm = gs.getVerifyGlobalSeacrhNewSecond().getText();
			System.out.println(searchterm);
			Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput2")));
			System.out.println("Global Search functionality is working properly.");
		}
		
	}
	
	
	@Test(priority=2)
	public void TS002_ATLApp_VerifyExhibitorDirectory() throws InterruptedException, IOException
	{
	//Exhibitor Directory 
		utl = new Utility(driver);
		edp = new ATLAppExhibitorDirectoryTab(driver);
		
		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		
	//Exhibitors and Products
		edp.getATLAppExhibitorDirectoryTab().click();
		Thread.sleep(500);
		//Click on Exhibitors And Products link
		edp.getEDTExhibitorsAndProducts().click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("exhibitor-directory"));	
		System.out.println("Exhibitors and Products Page is present");
		
	//Floor Plans
		edp.getATLAppExhibitorDirectoryTab().click();
		Thread.sleep(500);
		//Click on Floor Plans link
		edp.getEDTFloorPlans().click();
		Thread.sleep(2000);
		//Verify Floor Plan Page
		//Assert.assertTrue(atlexhp.getATLVerifyFloorPlans().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains("Market-Map"));
		System.out.println("Floor Plan Page is present");
		
	//List of Brands
		edp.getATLAppExhibitorDirectoryTab().click();
		Thread.sleep(500);
		//Click on List of Brands link
		edp.getEDTListOfBrands().click();
		Thread.sleep(2000);
		//Verify List of Brands Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Directory"));
		System.out.println("List of Brands Page is present");
		
	//Categories
		edp.getATLAppExhibitorDirectoryTab().click();
		Thread.sleep(500);
		//Click on categories
		edp.getEDTCategories().click();
		Thread.sleep(2000);
		//Thread.sleep(3000);
		//Verify All Brands Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Categories"));
		System.out.println("Categories Page is present");
		
	}
	
	@Test(priority=3)
	public void TS003_ATLApp_VerifyMarketsAndEvents() throws InterruptedException, IOException
	{
	//Markets and Events
		utl = new Utility(driver);
		mae = new ATLAppMarketsAndEventsTab(driver);
		
		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(7000);
		
	//Complete show dates
		//Click on Markets And Events Tab
		mae.getATLAppMarketsAndEventsTab().click();
		Thread.sleep(500);
		//Click on Complete show dates link
		mae.getMAECompleteShowdates().click(); 
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Complete-Show-Dates"));	
		System.out.println("Complete show dates Page is displayed properly");
		
	//Events and amenities
		//Click on Markets And Events Tab
		mae.getATLAppMarketsAndEventsTab().click();
		Thread.sleep(500);
		//Click on Events and amenities link
		mae.getMAEEventsAndAmenities().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Events"));	
		System.out.println("Events and amenities Page is displayed properly");
		
	//Year around at AmericasMart
		//Click on Markets And Events Tab
		mae.getATLAppMarketsAndEventsTab().click();
		Thread.sleep(500);
		String winHandleBefore = driver.getWindowHandle();
		//Click on Year around at AmericasMart link
		mae.getMAEYearAroundAtAmericasMart().click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("americasmart.com"));
		System.out.println("Year around at AmericasMart Page is displayed properly");
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}
	
	@Test(priority=4)
	public void TS004_ATLApp_VerifyVisitTab() throws InterruptedException, IOException
	{
	//Visit Tab Page
		utl = new Utility(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		atlm = new ATLAppMarketsTabPage(driver);	
		atlatt = new ATLAppAttendTabPage(driver);
		vtp = new ATLAppVisitTabPage(driver);
		
		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		
	//Registration
		//Click on Visit Tab
		vtp.getATLAppVisitTab().click();
		Thread.sleep(500);
		//Click on Registration link
		vtp.getVisitTabRegistration().click();
		Thread.sleep(3000);
		//Click on Registration link
		Assert.assertTrue(driver.getCurrentUrl().contains("Registration"));	
		System.out.println("Registration page is displayed properly");		
		
	//Complete Show Dates
		//Click on Visit Tab
		vtp.getATLAppVisitTab().click();
		Thread.sleep(500);
		//Click on Show Dates link
		vtp.getVisitTabCompleteShowDates().click();
		Thread.sleep(3000);
		//Click on Registration link
		Assert.assertTrue(driver.getCurrentUrl().contains("Complete-Show-Dates"));	
		System.out.println("Registration page is displayed properly");		
	
	//Travel
		//Click on Visit Tab
		vtp.getATLAppVisitTab().click();
		Thread.sleep(500);
		//Click on Travel Link
		vtp.getVisitTabTravel().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Travel"));	
		System.out.println("Travel Page is displayed properly");	
		
	//Events and Amenities
		//Click on Visit Tab
		vtp.getATLAppVisitTab().click();
		Thread.sleep(500);
		//Click on Events & Amenities link
		vtp.getVisitTabEventsAndAmenities().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Events"));	
		System.out.println("Events & Amenities Page is displayed properly");	
		
	//Dining
		//Click on Visit Tab
		vtp.getATLAppVisitTab().click();
		Thread.sleep(500);
		//Click on Dining link
		vtp.getVisitTabDining().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Dining"));	
		System.out.println("Dining Page is displayed properly");
		
		
	//Download the App
		//Click on Visit Tab
		vtp.getATLAppVisitTab().click();
		Thread.sleep(500);
		//Click on Download the App link
		vtp.getVisitTabDownloadTheApp().click();
		Thread.sleep(4000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Plan-Your-Market"));	
		System.out.println("Download the App Page is displayed properly");
		
	//Services at Market
		//Click on Visit Tab
		vtp.getATLAppVisitTab().click();
		Thread.sleep(500);
		//Click on Services at Market link
		vtp.getVisitTabServicesAtMarket().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Services-and-Amenities"));
		System.out.println("Services at Maket page is displayed properly");
		
	//FAQs
		//Click on Visit Tab
		vtp.getATLAppVisitTab().click();
		Thread.sleep(500);
		//Click on FAQ's link
		vtp.getVisitTabFAQs().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("FAQs"));	
		System.out.println("FAQ page is displayed properly");
		
	}
		
	@Test(priority=5)
	public void TS005_ATLApp_VerifyDiscoverTab() throws InterruptedException, IOException
	{
	//Discover
		utl=new Utility(driver);
		dt = new ATLAppDiscoverTab(driver);
		
		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		
	//Exhibitors and Products
		dt.getATLAppDiscoverTab().click();
		Thread.sleep(500);
		//Click on Exhibitors And Products link
		dt.getDTExhibitorsAndProducts().click();
		Thread.sleep(3000);
		//Verify Exhibitors and Products Page
		Assert.assertTrue(driver.getCurrentUrl().contains("exhibitor-directory"));
		System.out.println("Exhibitors and Products Page is present");
		
	//Floor Plans
		dt.getATLAppDiscoverTab().click();
		Thread.sleep(500);
		//Click on Floor Plans link
		dt.getDTFloorPlans().click();
		Thread.sleep(3000);
		//Verify Floor Plan Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Market-Map"));
		System.out.println("Floor Plan Page is present");
		
	//List of Brands
		dt.getATLAppDiscoverTab().click();
		Thread.sleep(500);
		//Click on List of Brands link
		dt.getDTListOfBrands().click();
		Thread.sleep(3000);
		//Verify List of Brands Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Directory"));
		System.out.println("List of Brands Page is present");
		
	//Tools and Inspirations
		dt.getATLAppDiscoverTab().click();
		Thread.sleep(500);
		//Click on Tools and Inspirationss link
		dt.getDTToolsAndInspirations().click();
		Thread.sleep(3000);
		//Verify Tools and Inspirations Page
		Assert.assertTrue(driver.getCurrentUrl().contains("The-Best-Of"));	
		System.out.println("Tools and Inspirations Page is displayed properly");
		
	//Plan your Market
		//Click on Visit Tab
		dt.getATLAppDiscoverTab().click();
		Thread.sleep(1000);
		//Click on Download the App link
		dt.getDTPlanYourMarket().click();
		Thread.sleep(4000);
		//Verify Plan your Market Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Plan-Your-Market"));	
		System.out.println("Plan your Market Page is displayed properly");
		
	//Explore Atlanta
		dt.getATLAppDiscoverTab().click();
		Thread.sleep(500);
		//Click on Explore Atlanta link
		dt.getDTExploreAtlanta().click();
		Thread.sleep(3000);
		//Verify Explore Atlanta Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Explore-Atlanta"));	
		System.out.println("Explore Atlant Page is displayed properly");
	}
	
	@Test(priority=6)
	public void TS006_ATLApp_VerifyExhibitTab() throws InterruptedException, IOException
	{
	//Exhibit Tab
		utl=new Utility(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		atlexh=new ATLExhibitPage(driver);
		
		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(4000);
		
	//Exhibit at Atlanta Apparel
		//Click on Exhibit Tab
		atlexh.getATLExhibitTab().click();
		Thread.sleep(1000);
		//Click on Exhibit at Atlanta Apparel link
		atlexh.getExhibitAtAtlantaApparel().click();
		Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyBreadcrumb().getText().contains("Atlanta Apparel"));
		System.out.println("Exhibit at Atlanta Apparel page opens successfully");
		
	//Exhibit in Social Occasion
		//Click on Exhibit Tab
		atlexh.getATLExhibitTab().click();
		Thread.sleep(1000);
		//Click on Exhibit in Social Occasion link
		atlexh.getExhibitInSocialOccasion().click();
		Thread.sleep(4000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Social-Occasion"));
		System.out.println("Exhibit in Social Occasion page opens successfully");
		
	//Exhibitor Resources
		atlexh.getATLExhibitTab().click();
		Thread.sleep(1000);
		//Click on Exhibitor Resources link
		atlexh.getATLExhibitorResources().click();
		Thread.sleep(5000);
		Assert.assertTrue(exhp.getVerifyBreadcrumb().getText().contains("Resources"));	
		System.out.println("Exhibitor Resources page opens successfully");
		
	//Already an Exhibitor
		atlexh.getATLExhibitTab().click();
		Thread.sleep(500);
		String winHandleBefore = driver.getWindowHandle();
		//Click on Exhibitor Portal Login' sub-menu
		atlexh.getATLExhibitorPortalLoginMenu().click();
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://prodmvdp.b2clogin.com/"));
		System.out.println("Exhibitor Portal Login link opens successfully");
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
	
	}
	

	@Test(priority=7)
	public void TS007_ATLApp_VerifyFooterLinksTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-Ts012: To verify Footer Links Navigation

		utl=new Utility(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		fl = new UXPFooterLinksNavigationPage(driver);
		atlfo=new ATLAppFooterLinksNavigationPage(driver);
		utl=new Utility(driver);

		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		//Thread.sleep(2000);
		//Scroll till footer links
		
	//Market Information
		utl.scrollToElement(fl.getmarketInfoATL());
		Thread.sleep(2000);
		//Click Market Info link and verify results
		fl.getmarketInfoATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/Markets"));
		driver.get(prop.getProperty("atlappurl"));
		//Thread.sleep(2000);
		utl.scrollToElement(fl.getmarketInfoATL());
		
	//Press Center
		//Thread.sleep(2000);
		//Click on Press Center
		fl.getpressCenterATL().click();
		//Thread.sleep(2000);
		Assert.assertTrue(exhp.getVerifyBreadcrumb().getText().contains("Press Center"));
		driver.get(prop.getProperty("atlappurl"));
		//Thread.sleep(2000);
		utl.scrollToElement(fl.getmarketInfoATL());
		
	//Download the ANDMORE markets App
		//Thread.sleep(2000);
		// Click Download The App link and verify results
		fl.getDownloadTheApp().click();
		//Thread.sleep(2000);
		Assert.assertEquals(exhp.getVerifyBreadcrumb().getText(), "Plan Your Market");
		driver.get(prop.getProperty("atlappurl"));
		utl.scrollToElement(fl.getmarketInfoATL());
		
	//Our Brands
		//Thread.sleep(2000);
		//Click on Our Brand link
		fl.getOurBrandsATL().click();
		//Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/exhibitor/directory"));
		driver.get(prop.getProperty("atlappurl"));
		//Thread.sleep(2000);
		utl.scrollToElement(fl.getmarketInfoATL());
		
	//Contact Us
		// Click Contact Us link and verify results
		//Thread.sleep(500);
		String winHandleBefore1 = driver.getWindowHandle();
		fl.getContactUsATL().click();
		for (String winHandle1 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle1);
		}
		//Assert.assertEquals(mi.getverifyContactUsATL().getText(), "Contact Us");
		Assert.assertTrue(driver.getCurrentUrl().contains("/About/Contact-Us"));
		driver.close();
		driver.switchTo().window(winHandleBefore1);
		
	//Careers
		utl.scrollElementIntoMiddle(fl.getCareersATL());
		fl.getCareersATL().click();
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("www.andmore.com/our-team"));
		driver.navigate().back();
		Thread.sleep(5000);
		
	//Exhibitor Login
		utl.scrollToBottom();
		fl.getExhibitorLogin().click();
		Thread.sleep(5000);
		Assert.assertTrue(fl.getEXPloginVerify().getText().contains("Exhibitor Portal Login"));
		System.out.println("Exhibitor Portal Login Page Opens Successifully");
		driver.navigate().back();
		Thread.sleep(5000);
		
	
	//AmericasMart
		// Click Americas Mart link and verify results
		utl.scrollElementIntoMiddle(fl.getAmericasMart_ATLAppFooter());
		String winHandleBefore2 = driver.getWindowHandle();
		fl.getAmericasMart_ATLAppFooter().click();
		for (String winHandle2 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle2);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore2);
		Thread.sleep(500);
		
	//Atlanta Market
		// Switch to new tab
		String winHandleBefore3 = driver.getWindowHandle();
		fl.getAtlantaMarket().click();
		for (String winHandle3 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle3);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore3);
		//utl.scrollToElement(fl.getmarketInfoATL());

	//Casual Market Atlanta
		// Switch to new tab
		utl.scrollElementIntoMiddle(fl.getCasualMarketAtlanta());
		String winHandleBefore4 = driver.getWindowHandle();
		fl.getCasualMarketAtlanta().click();
		for (String winHandle4 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle4);
		}
		Thread.sleep(7000);
		Assert.assertTrue(driver.getCurrentUrl().contains("casualmarketatlanta.com"));
		driver.close();
		driver.switchTo().window(winHandleBefore4);
		
	//High Point Market
		String winHandleBefore5 = driver.getWindowHandle();
		fl.getHighPointMarket().click();
		for (String winHandle5 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle5);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmorehighpointmarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore5);
		//utl.scrollToElement(fl.getmarketInfoATL());
		
	//Las Vegas Apparel
		utl.scrollElementIntoMiddle(fl.getlvapplinkNew());
		Thread.sleep(3000);
		String winHandleBefore6 = driver.getWindowHandle();
		fl.getlvapplinkNew().click();
		for (String winHandle6 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle6);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore6);

	//Las Vegas Market
		utl.scrollElementIntoMiddle(fl.getlvmlink_ATL());
		String winHandleBefore7 = driver.getWindowHandle();
		fl.getlvmlink_ATL().click();
		for (String winHandle7 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle7);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore7);
	
	//ANDMORE
		// Click ANDMORE link and verify results
		utl.scrollElementIntoMiddle(fl.getandmore());
		// Switch to new tab
		String winHandleBefore8 = driver.getWindowHandle();
		fl.getandmore().click();
		for (String winHandle8 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle8);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore8);
		
	//Terms & Conditions
		// Click on Terms & condition link
		utl.scrollToBottom();
		Thread.sleep(200);
		String winHandleBefore9 = driver.getWindowHandle();
		fl.getTermsAndConditions().click();
		for (String winHandle9 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle9);
		}
		// Assert.assertEquals(fl.getVerifyTermsOfUse().getText(), "TERMS OF USE");
		Assert.assertTrue(driver.getCurrentUrl().contains("terms-of-use"));
		driver.close();
		driver.switchTo().window(winHandleBefore9);
		
	//Privacy Policy
		// Click Privacy Policy link and verify results
		utl.scrollToBottom();
		String winHandleBefore10 = driver.getWindowHandle();
		fl.getatlprivacypolicy().click();
		for (String winHandle10 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle10);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("privacy-policy"));
		driver.close();
		driver.switchTo().window(winHandleBefore10);
			
		// Click on LVA Market link
		// Switch to new tab
		/*fl.getlvapplink_ATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));*/
		
		//Due to re-branding changes
/*		//Click International Market Centers link and verify results
		fl.getInternationalMarketCenters().click();
		//Switch to new tab
		String winHandleBefore3 = driver.getWindowHandle();
		for(String winHandle3 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle3);}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imcenters.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore3);
		utl.scrollToElement(fl.getmarketInfoATL());		
*/		
		//Click Juniper Market Centers link and verify results
		/*fl.getJuniperMarket().click();
		//Switch to new tab
		String winHandleBefore12 = driver.getWindowHandle();
		for(String winHandle12 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle12);}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.junipermarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore12);
		utl.scrollToElement(fl.getmarketInfoATL());	*/	
	
		//driver.get(prop.getProperty("atlappurl"));
		
	}
	
	@Test(priority=8)
	public void TS008_ATLApp_VerifySocialMediaLinksTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T013: To verify the all social media links and it's redirection
		atlfo=new ATLAppFooterLinksNavigationPage(driver);
		utl=new Utility(driver);

		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		utl.waitForPageToLoad();
		Thread.sleep(5000);
		
		//Scroll till footer links
		utl.scrollToElement(atlfo.getfacebookfootericon());
		
		//Click on Facebook Icon
		String winHandleBefore = driver.getWindowHandle();
		atlfo.getfacebookfootericon().click();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(2000);
		//Verify that 'Atlapp Facebook' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/apparelmarkets/"));
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		/*//Click on twitter Icon
		atlfo.gettwittericonfooter().click();
		String winHandleBefore1 = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		//Verify that 'Atlapp Facebook' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://twitter.com/atlantaapparel"));

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore1);
		
		//Click on Instagram Icon
		atlfo.getinstagramfootericon().click();
		String winHandleBefore2 = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		//Verify that 'Atlapp Facebook' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.instagram.com/apparelmarkets/"));

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore2);

		//Click on Youtube Icon
		atlfo.getyoutubefootericon().click();
		String winHandleBefore3 = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		//Verify that 'Atlapp Facebook' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com/user/AtlantaApparel"));

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore3);

		//Click on SnapChat Icon
		atlfo.getsnapchatfooter().click();
		String winHandleBefore4 = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		//Verify that 'Atlapp Snapchat' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.snapchat.com/add/atlantaapparel"));

		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore4);*/
		//driver.get(prop.getProperty("atlappurl"));
	}

/*
	@Test(enabled=false)//priority=2
	public void TS011_ATLApp_MarketRecap() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T798: Market Recap page opens successfully.
		utl=new Utility(driver);
		lap = new UXPLandingPage(driver);
		
		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Verify Market Recap link is working properly
		lap.getMarketRecap().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/Attend/App"));
		System.out.println("Market Recap page is working properly.");
		//driver.get(prop.getProperty("atlappurl"));
	}
*/	
	
	@Test(enabled=false)
	public void TS00001_ATLApp_VerifyAllLinksUnderYearRoundTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T011: To Year Round Tab

		utl=new Utility(driver);
		atlm=new ATLAppMarketsTabPage(driver);
		atly=new UXPYearRoundPage(driver);
		atlyr=new ATLAppYearRoundTabPage(driver);
		
		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		
	//Verify Americas mart link
		//Click on Year Round Tab
		atly.getYearRoundTab().click();
		//System.out.println("Click on Year Round Tab");
		//CLick AmericasMart Link 
		Thread.sleep(1000);
		//atly.getYearRound().click();//changed to AmericasMart
		atly.getAmericasMart().click();
		//Click on Year Round Tab
		atly.getYearRoundTab().click();
		String winHandleBefore5 = driver.getWindowHandle();
		for (String winHandle5 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle5);
		}
		//Thread.sleep(5000);
		//Assert.assertTrue(driver.getCurrentUrl().contains("Open Year Round at AmericasMart"));
		Assert.assertTrue(atlm.getATLAppHeaders().getText().contains("Open Year Round"));
		driver.close();
		driver.switchTo().window(winHandleBefore5);
		
	//Verify Shop The Mart link
		/*driver.get(prop.getProperty("atlappurl"));
		atly.getYearRoundTab().click();*/
		atly.getYearRoundTab().click();
		//CLick Shop The Mart Link 
		atly.getShopTheMart().click();
		System.out.println("CLick Shop The Mart Link ");
		//Verify Shop The Mart Link 
		//Thread.sleep(4000);
		Assert.assertTrue(driver.getTitle().contains("Shop the Mart"));	
		System.out.println("Verify Shop The Mart page ");

		//driver.get(prop.getProperty("atlappurl"));	
	}
	
	
	@Test(enabled=false)
	public void TS002_ATLApp_VerifyAllLinksUnderAttendTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T08: To verify Attend Tab

		utl=new Utility(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		atlm=new ATLAppMarketsTabPage(driver);
		atat=new ATLAttendPage(driver);		
		atlatt=new ATLAppAttendTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		
		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		
	//Verify Attending our markets link
		//Click on Attend Tab
		atat.getATLAttendTab().click();
		Thread.sleep(1000);
		//Click on Attending our markets link
		atlatt.getATLAttendingMarkets().click();
		Thread.sleep(3000);
		Assert.assertTrue(mi.getVerifyContactUs().getText().contains("Attend"));	
		System.out.println("Vefiry Adding our Markets Page");

	//Verify Buyer's Guide link
		//Click on Attend Tab
		atat.getATLAttendTab().click();
		Thread.sleep(1000);
		//Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		//Click on Buyer's Guide link
		atlatt.getATLBuyrsGuide().click();
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("flipbook"));
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		System.out.println("Buyer's Guide link redirects successufully");		
		Thread.sleep(500);
		
	//Verify Registration link
		//Click on Attend Tab
		atat.getATLRegistration().click(); 
		Thread.sleep(1000);
		//Click on Registration link
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Registration"));	
		System.out.println("Registration page is displayed properly");		
		
	//Verify Services at Market link
		//Click on Attend Tab
		atat.getATLAttendTab().click();
		Thread.sleep(1000);
		//Click on Services at Market link
		atlatt.getATlAppServices().click();
		Thread.sleep(5000);
		Assert.assertTrue(exhp.getverifyBreadcrumb_ATLAPP().getText().contains("Services & Amenities"));
		System.out.println("Services at Maket page is displayed properly");
		
	//Verify FAQ's link
		//Click on Attend Tab
		atat.getATLAttendTab().click();
		Thread.sleep(1000);
		//Click on FAQ's link
		atlatt.getATLFAQs().click();
		Thread.sleep(3000);
		Assert.assertTrue(exhp.getverifyBreadcrumb_ATLAPP().getText().contains("FAQs"));	
		System.out.println("FAQ page is displayed properly");	

	//Verify Hotel link
		//Click on Attend Tab
		atat.getATLAttendTab().click();
		Thread.sleep(1000);
		//Click on Hotel link
		atlatt.getATLHotels().click();
		Thread.sleep(3000);
		Assert.assertTrue(atlatt.getATLVerifyHotels().getText().contains("Hotels"));	
		System.out.println("Hotel page is displayed properly");	
	
	//Verify Travel Link
		//Click on Attend Tab
		atat.getATLAttendTab().click();
		Thread.sleep(1000);
		//Click on Travel Link
		atlatt.getATLTravel().click();
		Thread.sleep(3000);
		Assert.assertTrue(exhp.getverifyBreadcrumb_ATLAPP().getText().contains("Travel"));	
		System.out.println("Travel Page is displayed properly");	

	//Verify Explore Atlanta link
		//Click on Attend Tab
		atat.getATLAttendTab().click();
		Thread.sleep(1000);
		//Click on Explore Atlanta link
		atlatt.getExploreAtlanta().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Explore-Atlanta"));	
		System.out.println("Explore Atlanta Page is displayed properly");	

	//Verify Safety & Security link
		//Click on Attend Tab
		atat.getATLAttendTab().click();
		Thread.sleep(1000);
		//Click on Safety & Security link
		atlatt.getSafetyAndSecurity().click();
		Thread.sleep(3000);
		Assert.assertTrue(exhp.getverifyBreadcrumb_ATLAPP().getText().contains("Safety & Security"));	
		System.out.println("Safety & Security Page is displayed properly");	

	//Verify Events & Amenities link
		//Click on Attend Tab
		atat.getATLAttendTab().click();
		Thread.sleep(1000);
		//Click on Events & Amenities link
		atlatt.getATLEvents().click(); 
		Thread.sleep(3000);
		Assert.assertTrue(exhp.getverifyBreadcrumb_ATLAPP().getText().contains("Events"));	
		System.out.println("Events & Amenities Page is displayed properly");	

	//Verify Dining link
		//Click on Attend Tab
		atat.getATLAttendTab().click();
		Thread.sleep(1000);
		//Click on Dining link
		atlatt.getATLDining().click();
		Thread.sleep(3000);
		Assert.assertTrue(exhp.getverifyBreadcrumb_ATLAPP().getText().contains("Dining"));	
		System.out.println("Dining Page is displayed properly");

	//Verify Download the App link
		//Click on Attend Tab
		atat.getATLAttendTab().click();
		Thread.sleep(1000);
		//Click on Download the App link
		atlatt.getDownloadTheApp().click();
		Thread.sleep(4000);
		Assert.assertTrue(exhp.getverifyBreadcrumb_ATLAPP().getText().contains("Plan Your Market"));	
		System.out.println("Download the App Page is displayed properly");

	}



	@Test(enabled=false)
	public void TS004_ATLApp_VerifyExhibitorDirectoryTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T05: To verify Exhibitor Directory

		utl=new Utility(driver);
		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		ed = new UXPExhibitorDirectoryPage(driver);
		gs = new UXPGlobalSearchPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		atled = new ATLExhibitorDirectoryPage (driver);

		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		//Verify exhibitor directory page is successfully opened
		atled.getATLExhibitorDirectory().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Atlanta Apparel Exhibitor Directory");
		gs.getSearchButton().click();

		//Scroll till exhibitor directory
		utl.scrollToElement(exhp.getVerifyExhibitorDirectory());

		//Verify exhibitor data is displayed or not as per search criteria
		System.out.println("Exhibitor Directory is opened properly.");
		gs.getGlobalSearchTextBoxTwo().sendKeys((prop.getProperty("globalsearchinput2")));
		gs.getSearchButtonED().click();

		/*utl.scrollToElement(mi.getVerifyContactUs());
		amhe.getExhbAndProdsTab().click();
		gs.getSearchButton().click();*/
		Thread.sleep(10000);
		utl.scrollToElement(mi.getVerifyContactUs());
		Thread.sleep(3000);
		
		try {
			String searchterm = gs.getVerifyGlobalSeacrh().getText();
			//Thread.sleep(8000);
			if (searchterm.contains(prop.getProperty("globalsearchinput2"))) {
				Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput2")));
			}
		} catch (Exception e) {
			String searchterm = gs.getVerifyGlobalSeacrhSecond().getText();
			//Thread.sleep(8000);
			Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput2")));
		}
		
		System.out.println("Exhibitor Directory page is working properly.");
		
	}

	@Test(enabled=false)
	public void TS005_ATLApp_VerifyAllLinksUnderMarketsTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T06: To verify Markets Tab

		utl=new Utility(driver);
		mi = new UXPMarketInfoPage(driver);
		atlm=new ATLAppMarketsTabPage(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(prop.getProperty("atlappurl"));
		Thread.sleep(5000);

	//Complete Show Dates link
		//Click on Markets Tab
		mi.getMarketInfoHeader().click();
		Thread.sleep(1000);
		//Click on Complete show dates
		atlm.getATLCompleteShowDates().click();
		//Verify About Page
		Thread.sleep(2000);
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Complete Show Dates"));	
		System.out.println("Verify Complete show dates Page");		

	//Press Releases link
		//Click on Markets Tab
		mi.getMarketInfoHeader().click();
		Thread.sleep(1000);
		//Click on press releases
		atlm.getATLPressReleases().click();
		//Verify Press Releases Page
		Thread.sleep(4000);
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Press Center"));	
		System.out.println("Verify Press Realeses Page");		

	//In The News link
		//Click on Markets Tab
		mi.getMarketInfoHeader().click();
		Thread.sleep(1000);
		//Click on Click on In the News
		atlm.getATLInTheNews().click();
		//Verify In the News Page
		Thread.sleep(2000);
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("In The News"));	
		System.out.println("Verify In the News Page");		

	//Atlanta Apparel Image Link
		mi.getMarketInfoHeader().click();
		Thread.sleep(1000);
		//Click on Atlanta App Image
		atlm.getATLAppImage().click();
		//Verify Atlanta Apparel Page
		Thread.sleep(2000);
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Atlanta Apparel"));	
		System.out.println("Verify Atlanta Apparel Image Link");

	//Atlanta Apparel Link
		mi.getMarketInfoHeader().click();
		Thread.sleep(1000);
		//Click on Atlanta App Link
		atlm.getATLAppLink().click();
		//Verify Atlanta Apparel Page
		Thread.sleep(2000);
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Atlanta Apparel"));
		System.out.println("Verify Atlanta Apparel Link");

	//Formal Markets Image
		mi.getMarketInfoHeader().click();
		Thread.sleep(1000);
		//Click on Formal Markets Image
		atlm.getATLFormalMarketsImg().click();
		//Verify Atlanta Apparel Page
		Thread.sleep(2000);
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Formal Markets"));
		System.out.println("Verify Formal Markets Image Link");

	//Formal Markets link
		mi.getMarketInfoHeader().click();
		Thread.sleep(1000);
		//Click on Formal Markets Link
		atlm.getATLFormalMarketLink().click();
		//Verify Atlanta Apparel Page
		Thread.sleep(2000);
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Formal Markets"));
		System.out.println("Verify Formal Markets Link");
		
	//Las Vegas Apparel Image
		mi.getMarketInfoHeader().click();
		Thread.sleep(1000);
		//Click on Atlanta App Image
		atlm.getATLLasVegasAppImg().click();
		//Verify Atlanta Apparel Page
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));	
		System.out.println("Verify Las Vegas App Img Link");
		driver.navigate().back();
		
		Thread.sleep(4000);
	//Las Vegas Apparel link
		mi.getMarketInfoHeader().click();
		Thread.sleep(1000);
		//Click on Atlanta link
		atlm.getATLLasVegasAppLink().click();
		//Verify Atlanta Apparel Page
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));	
		System.out.println("Verify Las Vegas App Link");
		driver.navigate().back();
		
		//Due to re-branding changes
/*		//Click on Markets Tab
		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//CLick on About
		mi.getAboutLasVegasMarket().click();
		
		//System.out.println("CLick on About");
		//Verify About Page
		Assert.assertTrue(mi.getVerifyContactUs().getText().contains("Markets"));	
		System.out.println("Verify About Page");
*/
		//Due to re-branding changes
/*		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Atlanta App Image
		atlm.getATLVowLink().click();
		System.out.println("Click on Vow Link");
		//Verify Atlanta Apparel Page
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("VOW"));	
		System.out.println("Verify Vow Page Link Page");

		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Atlanta App Image
		atlm.getATLWorldOfPromImg().click();
		System.out.println("Click on World Of Prom Image");
		//Verify Atlanta Apparel Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/Markets/World-of-Prom"));	
		System.out.println("Verify World Of Prom Page");
		//driver.get(prop.getProperty("atlappurl"));
*/
		/*Thread.sleep(2000);
		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Atlanta App Link
		atlm.getATLLasVegasAppLink().click();
		System.out.println("Click on Las vegas app Link");
		//Verify Atlanta Apparel Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));	
		System.out.println("Verify Las Vegas App Link Page");
		driver.get(prop.getProperty("atlappurl"));
*/
	}

	@Test(enabled=false)
	public void TS006_ATLApp_VerifyAllLinksUnderExhibitorsAndBrandsTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T07: To verify Exhibitors And Brands Tab

		utl=new Utility(driver);
		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		ed = new UXPExhibitorDirectoryPage(driver);
		gs = new UXPGlobalSearchPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		atled = new ATLExhibitorDirectoryPage (driver);
		atlm=new ATLAppMarketsTabPage(driver);
		atlappexh=new ATLAppExhibitorsAndProductTabPage(driver);
		atlexhp=new ATLExhibitorsAndProductsTabPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	//Click on Exhibitors And Brands Tab
		driver.get(prop.getProperty("atlappurl"));
		Thread.sleep(5000);
		exhp.getExhibitorsAndBrands().click();
		System.out.println("Click on Exhibitors And Brands Tab");
		Thread.sleep(1000);
	//Click on Exhibitors And Products Tab
		exhp.getExhibitorsAndProducts().click();
		Thread.sleep(1000);
		System.out.println("Click on Exhibitors And Products Tab");
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Atlanta Apparel Exhibitor Directory"));	
		System.out.println("Verify Exhibitor, Lines & Product Directory Page");
		
	//Click on Floor Plans
		exhp.getExhibitorsAndBrands().click();
		Thread.sleep(1000);
		atlappexh.getATLAppFloorplans().click();
		System.out.println("Click on Floor Plans");
		Thread.sleep(1000);
		//Verify Floor Plan Page
		//Assert.assertTrue(atlexhp.getATLVerifyFloorPlans().isDisplayed());
		Assert.assertTrue(atlexhp.getATLVerifyFloorPlans().isDisplayed());
		System.out.println("Verify Floor Plan Page");

	//Click on Exhibitors And Brands Tab
		exhp.getExhibitorsAndBrands().click();
		System.out.println("Click on Exhibitors And Brands Tab");
		Thread.sleep(1000);
		//Click on categories
		atlappexh.getATLAppatlaappCategories().click();
		System.out.println("Click on Categoris");
		Thread.sleep(1000);
		//Verify All Brands Page
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Categories"));
		System.out.println("Verify Categories Page");

		/*//CLick on Exhibitor Directory
		exhp.getExhibitorDirectory().click();
		System.out.println("Click on Exhibitor Directory");
		//Verify Exhibitor Directory Page
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Exhibitor Directory"));	
		System.out.println("Verify Exhibitor Directory Page");*/
		
	}
	
	
	@Test(enabled=false)
	public void TS008_ATLApp_VerifyAllLinksUnderTheBestOfFashionTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T09: To verify Fashion Gallery Tab

		utl=new Utility(driver);
		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		ed = new UXPExhibitorDirectoryPage(driver);
		gs = new UXPGlobalSearchPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		atled = new ATLExhibitorDirectoryPage (driver);
		atlm=new ATLAppMarketsTabPage(driver);
		atlappexh=new ATLAppExhibitorsAndProductTabPage(driver);
		atlexhp=new ATLExhibitorsAndProductsTabPage(driver);
		atat=new ATLAttendPage(driver);		
		atlatt=new ATLAppAttendTabPage(driver);
		atlf=new ATLAppFashionGalleryTabPage(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(prop.getProperty("atlappurl"));
		Thread.sleep(5000);
		
	//Verify Lookbooks and Brand Books link
		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		Thread.sleep(2000);
		//Click on Lookbooks and Brand Books link
		atlf.getLookbooksAndBrandBooks().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Lookbooks-and-Brand-Books"));
		System.out.println("Lookbooks and Brand Books page opens successfully");
		Thread.sleep(5000);
		
	//Verify Videos ljnk
		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		Thread.sleep(1000);
		String winHandleBefore = driver.getWindowHandle();
		//Click on Videos Link 
		atlf.getatlAppvideosImages().click();
		Thread.sleep(3000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("youtube.com"));
		System.out.println("Videos link opens successfully");
		driver.close();
		driver.switchTo().window(winHandleBefore);

	//Verify In The News link
		//Click on Fashion Gallery Tab
		//atlf.getatlAppFashionGalleryTab().click();
		//Click on In The News Link 
		Thread.sleep(500);
		atlf.getatlAppNews().click();
		Thread.sleep(3000);
		Assert.assertTrue(exhp.getverifyBreadcrumb_ATLAPP().getText().contains("In The News"));
		System.out.println("In The News page opens successfully");
		
	//Verify Trends link
		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		Thread.sleep(1000);
		//Click on In Trends Link 
		atlf.getTrends().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Trends"));
		System.out.println("Trends page opens successfully");
	}
	

	@Test(enabled=false)
	public void TS009_ATLApp_VerifyAllLinksUnderExhibitTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T010: To verify Exhibit Tab
		
		utl=new Utility(driver);
		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		ed = new UXPExhibitorDirectoryPage(driver);
		gs = new UXPGlobalSearchPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		atled = new ATLExhibitorDirectoryPage (driver);
		atlm=new ATLAppMarketsTabPage(driver);
		atlappexh=new ATLAppExhibitorsAndProductTabPage(driver);
		atlexhp=new ATLExhibitorsAndProductsTabPage(driver);
		atat=new ATLAttendPage(driver);		
		atlatt=new ATLAppAttendTabPage(driver);
		atlf=new ATLAppFashionGalleryTabPage(driver);
		atlva=new UXPAttendPage(driver);
		atlExhi=new ATLAppExhibitTabPage(driver);
		atlexh=new ATLExhibitPage(driver);
		el=new EXPLoginPage(driver);
		
		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(4000);
		
	//Exhibit With Us link
		//Click on Exhibit Tab
		atlexh.getATLExhibitTab().click();
		Thread.sleep(1000);
		//Click on Exhibit With Us link
		atlexh.getExhibitWithUs().click();
		Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyBreadcrumb().getText().contains("Atlanta Apparel"));	
		System.out.println("Exhibit With Us page opens successfully");
	
	//Exhibit at Atlanta Apparel link
		//Click on Exhibit Tab
		atlexh.getATLExhibitTab().click();
		Thread.sleep(1000);
		//Click on Exhibit at Atlanta Apparel link
		atlexh.getExhibitAtAtlantaApparel().click();
		Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyBreadcrumb().getText().contains("Atlanta Apparel"));
		System.out.println("Exhibit at Atlanta Apparel page opens successfully");
		
	//Exhibit in Social Occasion link
		//Click on Exhibit Tab
		atlexh.getATLExhibitTab().click();
		Thread.sleep(1000);
		//Click on Exhibit in Social Occasion link
		atlexh.getExhibitInSocialOccasion().click();
		Thread.sleep(4000);
		Assert.assertTrue(driver.getCurrentUrl().contains("Social-Occasion"));
		System.out.println("Exhibit in Social Occasion page opens successfully");
		
	//Advertising and sponsorship link
		//Click on Exhibit Tab
		atlexh.getATLExhibitTab().click();
		Thread.sleep(1000);
		//Click on Advertising and sponsorship link
		atlexh.getAdvertisingAndSponsorship().click();
		Thread.sleep(5000);
		Assert.assertTrue(exhp.getVerifyBreadcrumb().getText().contains("Advertising + Sponsorship"));	
		System.out.println("Advertising and sponsorship page opens successfully");

	//Show Dates link
		//Click on Exhibit Tab
		atlexh.getATLExhibitTab().click();
		Thread.sleep(1000);
		//Click Show Dates Link 
		atlexh.getShowDates().click();
		//Verify Show Dates 
		Thread.sleep(5000);
		Assert.assertTrue(exhp.getVerifyBreadcrumb().getText().contains("Complete Show Dates"));	
		System.out.println("Show Dates page opens successfully");

	//Exhibitor Portal Login link
		atlexh.getATLExhibitTab().click();
		Thread.sleep(1000);
		String winHandleBefore = driver.getWindowHandle();
		//Click on Exhibitor Portal Login' sub-menu
		atlexh.getATLExhibitorPortalLoginMenu().click();
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://prodmvdp.b2clogin.com/"));
		System.out.println("Exhibitor Portal Login link opens successfully");
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
	//Exhibitor Resources
		//Click on Exhibit Tab
		//atlexh.getATLExhibitTab().click();
		//Click on Exhibitor Resources link
		atlexh.getATLExhibitorResources().click();
		Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyBreadcrumb().getText().contains("Resources"));	
		System.out.println("Exhibitor Resources page opens successfully");
	
	}

	
	//Due to re-branding changes
	@Test(enabled=false)//priority=1
	public void TS012_ATLApp_VerifyMarketPlannerLoginTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T01: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		utl = new Utility(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		/*//Navigate to Atlanta Apparel site
		driver.get(prop.getProperty("atlappurl"));;
		Thread.sleep(8000);
		lap.getIUnderstandBtn().click();
		Thread.sleep(8000);*/
		//Login to Market Planner
		utl.verifyMPLoginFunctionality();
		//Verify that Market Planner Home page should be displayed
		Assert.assertTrue(lap.getMPLinkText().isDisplayed());
	}
	
	//Due to re-branding changes
	@Test(enabled=false)//priority=2
	public void TS013_ATLApp_VerifyMarketPlannerProfileOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-002: To verify Profile option in Market Planner

		lap = new UXPLandingPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);
		ps = new UXPProfileAndSettingsPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click Profile and Settings tab under Market Planner and verify result
		ps.getWelcomeText().click();
		ps.getProfileAndSettings().click();
		Thread.sleep(10000);
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlappurl") + "Profile"));
		System.out.println("Profile Page is displayed successfully");
	}
	
	//Due to re-branding changes
	@Test(enabled=false)//priority=3
	public void TS014_ATLApp_VerifyMarketPlannerExhibitorPortalOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-003: To verify Exhibitor Portal option in Market Planner

		lap = new UXPLandingPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);
		amexh = new AMExhibitTabPage(driver);
		el = new pageObjects.ExhibitorPortal.EXPLoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		atlps.getATLWelcomeText().click();
		atlps.getAMCExhibitorPortalOptn().click();
		//Verify that 'EXP Login' page should be displayed
		//Thread.sleep(5000);
		Assert.assertTrue(el.getVerifyExpHomePage().isDisplayed());
		System.out.println("Exhibitor Portal is displayed properly.");
		driver.get(prop.getProperty("atlappurl"));
		//Thread.sleep(8000);

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
		//driver.quit();
	}

}