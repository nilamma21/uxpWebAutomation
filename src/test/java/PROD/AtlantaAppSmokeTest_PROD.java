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

import pageObjects.ExhibitorPortal.EXPLoginPage;
import pageObjects.AmericasMart.AMAboutTabPage;
import pageObjects.AmericasMart.AMExhibitTabPage;
import pageObjects.AmericasMart.AMFooterLinksNavigationPage;
import pageObjects.AmericasMart.AMHeaderLinksPage;
import pageObjects.AmericasMart.AMMarketsAndEventsPage;
import pageObjects.AmericasMart.AMOpenYearRoundPage;
import pageObjects.AtlantaApparel.ATLAppAttendTabPage;
import pageObjects.AtlantaApparel.ATLAppExhibitTabPage;
import pageObjects.AtlantaApparel.ATLAppExhibitorsAndProductTabPage;
import pageObjects.AtlantaApparel.ATLAppFashionGalleryTabPage;
import pageObjects.AtlantaApparel.ATLAppFooterLinksNavigationPage;
import pageObjects.AtlantaApparel.ATLAppGlobalSearchPage;
import pageObjects.AtlantaApparel.ATLAppMarketsTabPage;
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

	@BeforeClass
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);

		//Navigate to Atlanta Apparel site
		//driver.manage().window().maximize();
		driver.get(prop.getProperty("atlappurl"));
		//Thread.sleep(8000);
		lap.getIUnderstandBtn().click();
		//Thread.sleep(5000);
	}

	@Test(priority=1)
	public void TS001_VerifyMarketPlannerLoginTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T01: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		utl = new Utility(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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

	@Test(priority=2)
	public void TS002_VerifyMarketPlannerProfileOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-002: To verify Profile option in Market Planner

		lap = new UXPLandingPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);
		ps = new UXPProfileAndSettingsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click Profile and Settings tab under Market Planner and verify result
		ps.getWelcomeText().click();
		ps.getProfileAndSettings().click();
		Thread.sleep(10000);
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlappurl") + "Profile"));
		System.out.println("Profile Page is displayed successfully");
	}

	@Test(priority=3)
	public void TS003_VerifyMarketPlannerExhibitorPortalOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-003: To verify Exhibitor Portal option in Market Planner

		lap = new UXPLandingPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);
		amexh = new AMExhibitTabPage(driver);
		el = new pageObjects.ExhibitorPortal.EXPLoginPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlps.getATLWelcomeText().click();
		atlps.getAMCExhibitorPortalOptn().click();

		//Verify that 'EXP Login' page should be displayed
		//Thread.sleep(5000);
		Assert.assertTrue(el.getVerifyExpHomePage().isDisplayed());
		System.out.println("Exhibitor Portal is displayed properly.");
		driver.get(prop.getProperty("atlappurl"));
		//Thread.sleep(8000);
	
	}
	
	@Test(priority=4)
	public void TS004_VerifyGlobalSearchFunctionalityTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T04: To verify global search functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		gs = new UXPGlobalSearchPage(driver);
		gbs = new ATLAppGlobalSearchPage(driver);
		atlm = new ATLAppMarketsTabPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		gs.getGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		gs.getSearchButton().click();
		//Thread.sleep(5000);
		utl.scrollToElement(gs.getVerifyGlobalSeacrh());
		String searchterm = gs.getVerifyGlobalSeacrh().getText();
		Thread.sleep(3000);
		Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput")));
		System.out.println("Global Search functionality is working properly.");
		driver.get(prop.getProperty("atlappurl"));
		
	}

	@Test(priority=5)
	public void TS005_VerifyExhibitorDirectoryTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T05: To verify Exhibitor Directory

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		ed = new UXPExhibitorDirectoryPage(driver);
		gs = new UXPGlobalSearchPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		atled = new ATLExhibitorDirectoryPage (driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Verify exhibitor directory page is successfully opened
		atled.getATLExhibitorDirectory().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Atlanta Apparel Exhibitor Directory");

		//Scroll till exhibitor directory
		utl.scrollToElement(exhp.getVerifyExhibitorDirectory());

		//Verify exhibitor data is displayed or not as per search criteria
		System.out.println("Exhibitor Directory is opened properly.");
		gs.getGlobalSearchTextBox().sendKeys((prop.getProperty("exhibitordirectory")));
		gs.getSearchButton().click();

		utl.scrollToElement(mi.getVerifyContactUs());
		amhe.getExhbAndProdsTab().click();
		gs.getSearchButton().click();
		Thread.sleep(1000);
		utl.scrollToElement(mi.getVerifyContactUs());
		String searchterm = gs.getVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("exhibitordirectory")));
		System.out.println("Exhibitor Directory page is working properly.");
		
	}

	@Test(priority=6)
	public void TS006_VerifyAllLinksUnderMarketsTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T06: To verify Markets Tab

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		ed = new UXPExhibitorDirectoryPage(driver);
		gs = new UXPGlobalSearchPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		atled = new ATLExhibitorDirectoryPage (driver);
		atlm=new ATLAppMarketsTabPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Click on Markets Tab
		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//CLick on About
		mi.getAboutLasVegasMarket().click();
		
		//System.out.println("CLick on About");
		//Verify About Page
		Assert.assertTrue(mi.getVerifyContactUs().getText().contains("Markets"));	
		System.out.println("Verify About Page");

		//Click on Markets Tab
		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Complete show dates
		atlm.getATLCompleteShowDates().click();
		System.out.println("Click on Complete show dates");
		//Verify About Page
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Complete Show Dates"));	
		System.out.println("Verify Complete show dates Page");		

		//Click on Markets Tab
		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on press releases
		atlm.getATLPressReleases().click();
		System.out.println("Click on press releases");

		//System.out.println(atlm.getATLAppHeadersnext().getText());
		//Verify Press Releases Page
		Thread.sleep(3000);
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Press Center"));	
		System.out.println("Verify Press Realeses Page");		

		//Click on Markets Tab
		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Click on In the News
		atlm.getATLInTheNews().click();
		System.out.println("Click on In the News");
		//Verify In the News Page
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("In The News"));	
		System.out.println("Verify In the News Page");		

		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Atlanta App Image
		atlm.getATLAppImage().click();
		System.out.println("Click on Atlanta App Image");
		//Verify Atlanta Apparel Page
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Atlanta Apparel"));	
		System.out.println("Verify Atlanta Apparel Page");


		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Atlanta App Image
		atlm.getATLAppLink().click();
		System.out.println("Click on Atlanta App Link");
		//Verify Atlanta Apparel Page
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Atlanta Apparel"));
		System.out.println("Verify Atlanta Apparel Link Page");

		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Atlanta App Image
		atlm.getATLVowImage().click();
		System.out.println("Click on Vow Image");
		//Verify Atlanta Apparel Page
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("VOW"));	
		System.out.println("Verify Vow Page");


		mi.getMarketInfoHeader().click();
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
		
		Thread.sleep(2000);
		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Atlanta App Image
		atlm.getATLLasVegasAppImg().click();
		System.out.println("Click on Las Vegas App Image");
		//Verify Atlanta Apparel Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));	
		System.out.println("Verify Las Vegas App Img Page");
		driver.get(prop.getProperty("atlappurl"));
		
		Thread.sleep(2000);
		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Atlanta App Link
		atlm.getATLLasVegasAppLink().click();
		System.out.println("Click on Las vegas app Link");
		//Verify Atlanta Apparel Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));	
		System.out.println("Verify Las Vegas App Link Page");
		driver.get(prop.getProperty("atlappurl"));
	}

	@Test(priority=7)
	public void TS007_VerifyAllLinksUnderExhibitorsAndBrandsTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T07: To verify Exhibitors And Brands Tab

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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Exhibitors And Brands Tab
		Thread.sleep(1000);
		exhp.getExhibitorsAndProducts().click();
		System.out.println("Click on Exhibitors And brands Tab");
		//CLick on Exhibitor Directory
		
		exhp.getExhibitorDirectory().click();
		System.out.println("Click on Exhibitor Directory");
		//Verify Exhibitor Directory Page
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Exhibitor Directory"));	
		System.out.println("Verify Exhibitor Directory Page");

		//Click on Exhibitors And brands Tab
		exhp.getExhibitorsAndProducts().click();
		System.out.println("Click on Exhibitors And brands Tab");
		//Click on Floor Plans
		atlappexh.getATLAppFloorplans().click();
		System.out.println("Click on Floor Plans");
		//Verify Floor Plan Page
		//Assert.assertTrue(atlexhp.getATLVerifyFloorPlans().isDisplayed());
		Assert.assertTrue(atlexhp.getATLVerifyFloorPlans().isDisplayed());
		System.out.println("Verify Floor Plan Page");

		//Click on Exhibitors And brands Tab
		exhp.getExhibitorsAndProducts().click();
		System.out.println("Click on Exhibitors And brands Tab");
		//Click on categories
		atlappexh.getATLAppatlaappCategories().click();
		System.out.println("Click on Categoris");
		//Verify All Brands Page
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Categories"));
		System.out.println("Verify Categories Page");


	}
	@Test(priority=8)
	public void TS008_VerifyAllLinksUnderAttendTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T08: To verify Attend Tab

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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Attend Tab
		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on Click on Adding our Markets
		atlatt.getATLAttendingMarkets().click();
		System.out.println("Click on Adding our Markets");
		//Verify Attend Page
		Assert.assertTrue(mi.getVerifyContactUs().getText().contains("Attend"));	
		System.out.println("Vefiry Adding our Markets Page");

		//Click on Attend Tab
		atat.getATLAttendTab().click();
	
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		atlatt.getATLBuyrsGuide().click();
		System.out.println("Click on Buyers Guide");
		for(String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
		}
		System.out.println("Switch window");
		//Verify that 'EXP Login' page should be displayed
		//Assert.assertTrue(driver.getCurrentUrl().contains("https://www.angstromcreative.com/digital/flipbooks/imc/atl/2021/februaryapparelguide/?utm_source=dm&utm_medium=print#p=1"));
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
		//Click on Attend Tab

		//CLick on Registration Markets
		atat.getATLRegistration().click(); 
		System.out.println("Click on Reg");
		//Verify reg Page
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Registration"));	
		System.out.println("Vefiry Reg Page");		
		
		//Click Services and Amenities link
		atat.getATLAttendTab().click();
		atlatt.getServicesAmenities().click();
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Services & Amenities"));
		System.out.println("Services and Amenities page is displayed properly");
		
		//Click on Attend Tab
		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on FAQs
		atlatt.getATLFAQs().click(); 
		System.out.println("Click on FAQs");
		//Verify Faq Page
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("FAQs"));	
		System.out.println("Vefiry FAQ Page");	

		//Click on Attend Tab
		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on Hotels
		atlatt.getATLHotels().click(); 
		System.out.println("Click on Hotels");
		//Verify Hotels Page
		//Thread.sleep(2000);
		Assert.assertTrue(atlatt.getATLVerifyHotels().getText().contains("Hotels"));	
		System.out.println("Vefiry Hotels Page");	

	
		//Click on Attend Tab
		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on Hotels img
		atlatt.getATLTravel().click(); 
		System.out.println("Click on Travel");
		//Verify Hotels Page
		//Thread.sleep(1000);
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Travel"));	
		System.out.println("Vefiry Travel Page ");	

		//Click on Attend Tab
		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on Events img
		atlatt.getATLEvents().click(); 
		System.out.println("Click on Events");
	//	Thread.sleep(1000);
		//Verify Hotels Page
		//System.out.println(atlm.getATLAppHeadersnext().getText());
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Events"));	
		System.out.println("Vefiry Events Page ");	


		//Click on Attend Tab
		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on Dining img
		atlatt.getATLDining().click(); 
		System.out.println("Click on Dining");
		//Thread.sleep(1000);
		//Verify Hotels Page
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Dining"));	
		System.out.println("Vefiry Dining Page ");


		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on Download app img
		atlatt.getATLDownloadApp().click(); 
		System.out.println("Click on Donwload App");
		//Thread.sleep(3000);
		//Verify Hotels Page
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Atlanta Apparel App"));	
		System.out.println("Vefiry Download App Page ");
	}

	@Test(priority=9)
	public void TS009_VerifyAllLinksUnderFashionGalleryTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T09: To verify Fashion Gallery Tab

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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		System.out.println("Click on Fashion Gallery Tab");
		//CLick on Click on Fashion Gallery Link 
		atlf.getatlAppfashionGalleryLink().click();
		System.out.println("Click on Fashion Gallery Link ");
		//Verify Fashion Gallery Link 
		//Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Images"));	
		System.out.println("Vefiry Fashion Gallery Link  Page");

		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		System.out.println("Click on Fashion Gallery Tab");
		//CLick on Click on Fashion Gallery Link 
		atlf.getatlAppfashionGalleryLinkImg().click();
		System.out.println("Click on Fashion Gallery Link Img ");
		//Verify Fashion Gallery Link Img
		//Thread.sleep(2000);
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Images"));	
		System.out.println("Vefiry Fashion Gallery Link Img Page");


		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		System.out.println("Click on Fashion Gallery Tab");
		//CLick on Look Book Link 
		atlf.getatlAppLookBook().click();
		System.out.println("Click on Look Book Link ");
		//Vefiry Lookbooks  Page
		//Thread.sleep(2000);
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Lookbooks"));	
		System.out.println("Vefiry Lookbooks  Page");
		
		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		System.out.println("Click on Fashion Gallery Tab");
		//CLick on Look Book Link 
		atlf.getatlAppLookBookImg().click();
		System.out.println("Click on Look Book Link ");
		//Vefiry Lookbooks  Page
		//Thread.sleep(2000);
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Lookbooks"));	
		System.out.println("Vefiry Lookbooks  Page");

		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		System.out.println("Click on Fashion Gallery Tab");
		//Click on Videos and Images Link 
		atlf.getatlAppvideosImages().click();
		System.out.println("Click on Videos and Images Link ");
		//Vefiry Lookbooks  Page
		//Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Videos"));	
		System.out.println("Verify  Video and Images   Page");

		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		System.out.println("Click on Fashion Gallery Tab");
		//CLick on  LookbooksImg  Page
		atlf.getatlAppvideosImagesImg().click();
		System.out.println("Click on  Video and Images  Img ");
		//Vefiry Lookbooks img Page
		//Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Videos"));	
		System.out.println("Vefiry Video and Images  img Page");

		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		System.out.println("Click on Fashion Gallery Tab");
		//Click on Videos and Images Link 
		atlf.getatlAppNews().click();
		//Vefiry Lookbooks  Page
		//Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("In The News"));	
		System.out.println("Verify  In the News   Page");

		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		System.out.println("Click on Fashion Gallery Tab");
		//CLick on  LookbooksImg  Page
		atlf.getatlAppatlAppNewsImg().click();
		//Vefiry Lookbooks img Page
		//Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("In The News"));	
		System.out.println("Vefiry In the News  img Page");
	}
	

	@Test(priority=10)
	public void TS010_VerifyAllLinksUnderExhibitTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T010: To verify Exhibit Tab

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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*//Click on Exhibit Tab
		atlva.getAttend().click();
		System.out.println("Click on Exhibit Tab");
		//CLick Exhibit with us Link 
		atlva.getWhyAttend().click();
		System.out.println("CLick Exhibit with us Link ");
		//Verify CLick Exhibit with us Link 
		Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Atlanta Apparel"));	
		System.out.println("Verify CLick Exhibit with us Link ");


		//Click on Exhibit Tab
		atlva.getAttend().click();
		System.out.println("Click on Exhibit Tab");
		//CLick Exhibit at atlanta apparel Link 
		atlva.getRegistration().click();
		System.out.println("CLick Exhibit at atlanta apparel");
		//Verify Exhibit at atlanta apparel 
		Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Atlanta Apparel"));	
		System.out.println("Verify Exhibit at atlanta apparel ");

		//Click on Exhibit Tab
		atlva.getAttend().click();
		System.out.println("Click on Exhibit Tab");
		//CLick Exhibit at atlanta apparel Link 
		atlExhi.getatlAppExhibitInSocialOccasion().click();
		System.out.println("CLick Exhibit In Social Occasion");
		//Verify Exhibit In Social Occasion 
		Thread.sleep(4000);
		
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Exhibit in Social Occasion"));	
		System.out.println("Verify Exhibit In Social Occasion ");

*/
		//Click on Exhibit Tab
		atlva.getAttend().click();
		System.out.println("Click on Exhibit Tab");
		//CLick Exhibit at atlanta apparel Link 
		atlva.getHotels().click();
		System.out.println("CLick Advertising Sponsorship");
		//Verify Exhibit In Social Occasion 
		//Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Advertising + Sponsorship"));	
		System.out.println("Verify Advertising Sponsorship ");

		//Click on Exhibit Tab
		atlva.getAttend().click();
		System.out.println("Click on Exhibit Tab");
		//CLick Show Dates Link 
		atlva.getTravel().click();
		System.out.println("CLick Show Dates");
		//Verify Show Dates 
		//Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Complete Show Dates"));	
		System.out.println("Verify Show Dates ");

		atlva.getAttend().click();
		System.out.println("Click on Exhibit Tab");

		String winHandleBefore = driver.getWindowHandle();
		//Click on Exhibitor Portal Login' sub-menu
		atlexh.getATLExhibitorPortalLoginMenu().click();
		System.out.println("Click on EXP ");
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(el.getVerifyExpHomePage().isDisplayed());
		System.out.println("Verify Exp Page");
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		//CLick Exhibitor Resources Link 
		atlva.getDining().click();
		System.out.println("CLick Exhibit Exhibitor Resources");
		//Verify Exhibitor Resources
		//Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Resources"));	
		System.out.println("Verify Exhibitor Resources ");	
	}

	@Test(priority=11)
	public void TS011_VerifyAllLinksUnderYearRoundTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T011: To Year Round Tab

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
		atly=new UXPYearRoundPage(driver);
		atlyr=new ATLAppYearRoundTabPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Year Round Tab
		atly.getYearRoundTab().click();
		System.out.println("Click on Year Round Tab");
		//CLick AmericasMart Link 
		atly.getYearRound().click();
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
		
		/*driver.get(prop.getProperty("atlappurl"));
		atly.getYearRoundTab().click();*/
		atly.getYearRoundTab().click();
		//CLick Shop The Mart Link 
		atly.getLasVegasDesignCenter().click();
		System.out.println("CLick Shop The Mart Link ");
		//Verify Shop The Mart Link 
		//Thread.sleep(4000);
		Assert.assertTrue(atlyr.getShopTheMart().getText().contains("SHOP THE BEST KEPT SECRET IN JEWELRY & FASHION"));	
		System.out.println("Verify Shop The Mart page ");

		driver.get(prop.getProperty("atlappurl"));		


	}

	@Test(priority=12)
	public void TS012_VerifyFooterLinksTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-Ts012: To verify Footer Links Navigation

		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		fl = new UXPFooterLinksNavigationPage(driver);
		atlfo=new ATLAppFooterLinksNavigationPage(driver);
		utl=new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Scroll till footer links
		utl.scrollToElement(fl.getmarketInfoATL());

		//Click Market Info link and verify results
		fl.getmarketInfoATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/Markets"));
		System.out.println("Market Info Page open successfully");
		driver.get(prop.getProperty("atlappurl"));
		utl.scrollToElement(fl.getmarketInfoATL());
		
		//Click on Press Center
		fl.getpressCenterATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/Markets/Press-Center"));
		System.out.println("Press center Page open successfully");
		driver.get(prop.getProperty("atlappurl"));
		utl.scrollToElement(fl.getmarketInfoATL());
		
		// Click Download The App link and verify results
		fl.getDownloadTheApp().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Atlanta Apparel App");
		System.out.println("Download App Page open successfully");
		driver.get(prop.getProperty("atlappurl"));
		utl.scrollToElement(fl.getmarketInfoATL());
		
		//Click on Our Brancd link
		fl.getOurBrandsATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/exhibitor/directory"));
		System.out.println("Our Brands Page open successfully");
		driver.get(prop.getProperty("atlappurl"));
		utl.scrollToElement(fl.getmarketInfoATL());
		
		// Click Contact Us link and verify results
		fl.getContactUsATL().click();
		String winHandleBefore5 = driver.getWindowHandle();
		for (String winHandle5 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle5);
		}
		Assert.assertEquals(mi.getverifyContactUsATL().getText(), "Contact Us");
		System.out.println("Contact us Page open successfully");
		driver.close();
		driver.switchTo().window(winHandleBefore5);
		utl.scrollToElement(fl.getmarketInfoATL());
		
		// Click Careers link and verify results
		String winHandleBefore6 = driver.getWindowHandle();
		fl.getCareersATL().click();
		for (String winHandle6 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle6);
		}
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(), "Careers");
		// driver.get(prop.getProperty("atlappurl"));
		System.out.println("Careers Page open successfully");
		driver.close();
		driver.switchTo().window(winHandleBefore6);
		utl.scrollToElement(fl.getmarketInfoATL());
		
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
		driver.get(prop.getProperty("atlappurl"));
		utl.scrollToElement(fl.getmarketInfoATL());
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
		// utl.scrollToElement(fl.getmarketInfoATL());
		driver.get(prop.getProperty("atlappurl"));
		utl.scrollToElement(fl.getmarketInfoATL());
		
		// Click Americas Mart link and verify results
		fl.getAmericasMart_ATLApp().click();
		String winHandleBefore9 = driver.getWindowHandle();
		for (String winHandle9 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle9);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/"));
		System.out.println("AmericasMart Page open successfully");
		driver.close();
		driver.switchTo().window(winHandleBefore9);
		driver.get(prop.getProperty("atlappurl"));
		utl.scrollToElement(fl.getmarketInfoATL());
		
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
		utl.scrollToElement(fl.getmarketInfoATL());

/*		// Click Atlanta Apparel link and verify results
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
		utl.scrollToElement(fl.getmarketInfoATL());
		*/
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
		utl.scrollToElement(fl.getmarketInfoATL());
		
		// Click on LVA Market link
		// Switch to new tab
		fl.getlvapplink_ATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));
		System.out.println("Las Vegas App Page open successfully");
		driver.get(prop.getProperty("atlappurl"));
		utl.scrollToElement(fl.getmarketInfoATL());
		
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
		utl.scrollToElement(fl.getmarketInfoATL());		
		
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
		utl.scrollToElement(fl.getmarketInfoATL());		
		
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
		utl.scrollToElement(fl.getmarketInfoATL());			
		
	}

	@Test(priority=13)
	public void TS013_VerifySocialMediaLinksTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T013: To verify the all social media links and it's redirection

		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		mi = new UXPMarketInfoPage(driver);
		fl = new UXPFooterLinksNavigationPage(driver);
		atlfo=new ATLAppFooterLinksNavigationPage(driver);


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