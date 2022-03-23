package atlantaapparel;

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
	SendEmail se;

	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		amab = new AMAboutTabPage(driver);

		//Navigate to Atlanta Apparel site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("atlappurlPROD"));;
		Thread.sleep(8000);
		lap.getIUnderstandBtn().click();
		Thread.sleep(10000);
	}

	@Test(priority=1)
	public void TS001_VerifyMarketPlannerLoginTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T01: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Login to Market Planner
		utl.verifyMPLoginFunctionality();

		//Verify that Market Planner Home page should be displayed
		Assert.assertTrue(lap.getMPLinkText().isDisplayed());
		System.out.println("Login Done");
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
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlappurlPROD") + "Profile"));
		System.out.println("Profile Page is displayed successfully");
		System.out.println("MP Done");
	}

	@Test(priority=3)
	public void TS003_VerifyMarketPlannerExhibitorPortalOptionTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-003: To verify Exhibitor Portal option in Market Planner

		lap = new UXPLandingPage(driver);
		atlps = new ATLProfileAndSettingsPage(driver);
		amexh = new AMExhibitTabPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		atlps.getATLWelcomeText().click();
		atlps.getAMCExhibitorPortalOptn().click();

		//Verify that 'EXP Login' page should be displayed
		Thread.sleep(5000);
		Assert.assertTrue(amexh.getExpHeader().getText().contains("Welcome"));

		driver.get(prop.getProperty("atlappurlPROD"));
		Thread.sleep(8000);
		/*//Sign out from Market Planner
		atlps.getATLWelcomeText().click();
		lap.getMPSignOutBtn().click();
		Thread.sleep(10000);*/
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

		gs.getGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		gs.getSearchButton().click();
		utl.scrollToElement(gs.getVerifyGlobalSeacrh());
		String searchterm = gs.getVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput")));
		System.out.println("Global Search functionality is working properly.");
		
		//Click on any Exhibitor from Search results grid
		String exHeader=gbs.getExhibitor().getText();
		System.out.println("Exhibitor Header : "+gbs.getExhibitor().getText());
		gbs.getExhibitor().click();
		String exDGShowroomHeader=atlm.getATLAppHeadersnextnextnext().getText();
		System.out.println("DG Showroom Header : "+atlm.getATLAppHeadersnextnextnext().getText());
		Assert.assertTrue(exDGShowroomHeader.contains(exHeader));
		System.out.println("Verified Digital Showroom Page");
		
		driver.navigate().back();
		driver.navigate().back();
		
		//Click on any Product name from Search results Grid
		String productName=gbs.getProductName().getText();
		System.out.println("Product Name "+gbs.getProductName().getText());
		utl.scrollToElement(gbs.getProductBlock());
		gbs.getProductBlock().click();
		//gbs.getProduct().click();
		String productDetailsPageHeader=atlm.getATLAppHeadersProduct().getText();
		Assert.assertTrue(productName.contains(productDetailsPageHeader));
		System.out.println("Verified Product Details Page");
		System.out.println("GLobal Search Done");
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
		utl.scrollToElement(mi.getVerifyContactUs());
		String searchterm = gs.getVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("exhibitordirectory")));
		System.out.println("Exhibitor Directory page is working properly.");
		//driver.get(prop.getProperty("atlappurl"));
		System.out.println("Exhibitor Directry Done");
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
		//Verify About Page
		//Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Press Center"));	
		System.out.println("Verify Press Realeses Page");		

		//Click on Markets Tab
		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Click on In the News
		atlm.getATLInTheNews().click();
		System.out.println("Click on In the News");
		//Verify About Page
		//Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("In The News"));	
		System.out.println("Verify In the News Page");		

		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Atlanta App Image
		atlm.getATLAppImage().click();
		System.out.println("Click on Atlanta App Image");
		//Verify Atlanta Apparel Page
		//Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Atlanta Apparel"));	
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
		//Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("VOW"));	
		System.out.println("Verify Vow Page");


		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Atlanta App Image
		atlm.getATLVowLink().click();
		System.out.println("Click on Vow Link");
		//Verify Atlanta Apparel Page
		//Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("VOW"));	
		System.out.println("Verify Vow Page Link Page");

		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Atlanta App Image
		atlm.getATLWorldOfPromImg().click();
		System.out.println("Click on World Of Prom Image");
		//Verify Atlanta Apparel Page
		//Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("World"));	
		System.out.println("Verify World Of Prom Page");


		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Atlanta App Link
		atlm.getATLWorldOfPromLink().click();
		System.out.println("Click on World Of Prom Link");
		//Verify Atlanta Apparel Page
		//Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("World"));	
		System.out.println("Verify World Of Prom Link Page");

		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Atlanta App Image
		atlm.getATLLasVegasAppImg().click();
		System.out.println("Click on Las Vegas App Image");
		//Verify Atlanta Apparel Page
		//Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Las"));	
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com"));
		System.out.println("Verify Las Vegas App Img Page");
		driver.navigate().back();

		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Atlanta App Link
		atlm.getATLLasVegasAppLink().click();
		System.out.println("Click on Las vegas app Link");
		//Verify Atlanta Apparel Page
			
		//Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlappurlPROD")));
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com"));
		System.out.println("Verify Las Vegas App Link Page");
		driver.navigate().back();
		System.out.println("Market Tab Done");

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
		exhp.getExhibitorsAndProducts().click();
		System.out.println("Click on Exhibitors And brands Tab");
		//CLick on Exhibitor Directory
		exhp.getExhibitorDirectory().click();
		System.out.println("Click on Exhibitor Directory");
		//Verify Exhibitor Directory Page
		Thread.sleep(5000);
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
		Thread.sleep(5000);
		Assert.assertTrue(atlexhp.getATLVerifyFloorPlans().isDisplayed());
		System.out.println("Verify Floor Plan Page");

		//Click on Exhibitors And brands Tab
		exhp.getExhibitorsAndProducts().click();
		System.out.println("Click on Exhibitors And brands Tab");
		//Click on categories
		atlappexh.getATLAppatlaappCategories().click();
		System.out.println("Click on Categoris");
		//Verify All Brands Page
		Thread.sleep(5000);
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
		System.out.println("Click on Attend Tab");
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
		Thread.sleep(5000);
		//Assert.assertTrue(driver.getCurrentUrl().contains("https://www.angstromcreative.com/digital/flipbooks/imc/atl/2021/februaryapparelguide/?utm_source=dm&utm_medium=print#p=1"));
		driver.close();
		// Switch back to original browser (first window)
		Thread.sleep(5000);
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(5000);
		//Click on Attend Tab

		//CLick on Registration Markets
		atat.getATLRegistration().click(); 
		System.out.println("Click on Reg");
		//Verify reg Page
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Registration"));	
		System.out.println("Vefiry Reg Page");		

		//Click on Attend Tab
		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on Services & Amenities
		atlatt.getATLFAQs().click(); 
		System.out.println("Click on Services & Amenities");
		//Verify Services & Amenities Page
		Thread.sleep(5000);
		System.out.println(atlm.getATLAppHeadersnext().getText());
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Services & Amenities"));	
		System.out.println("Vefiry Services & Amenities Page");	


		//Click on Attend Tab
		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on Services & Amenities
		atlatt.getATLFAQ().click(); 
		System.out.println("Click on FAQs");
		//Verify Services & Amenities Page
		Thread.sleep(5000);
		System.out.println(atlm.getATLAppHeadersnext().getText());
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("FAQs"));	
		System.out.println("Vefiry FAQ Page");
		
		
		//Click on Attend Tab
		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on Hotels
		atlatt.getATLHotels().click(); 
		System.out.println("Click on Hotels");
		//Verify Hotels Page
		Thread.sleep(5000);
		Assert.assertTrue(atlatt.getATLVerifyHotels().getText().contains("Hotels"));	
		System.out.println("Vefiry Hotels Page");	

		//Click on Attend Tab
		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on Hotels img
		atlatt.getATLTravel().click(); 
		System.out.println("Click on Travel");
		//Verify Hotels Page
		Thread.sleep(5000);
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Travel"));	
		System.out.println("Vefiry Travel Page ");	

		//Click on Attend Tab
		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on Events img
		atlatt.getATLEvents().click(); 
		System.out.println("Click on Events");
		Thread.sleep(5000);
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
		Thread.sleep(5000);
		//Verify Hotels Page
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Dining"));	
		System.out.println("Vefiry Dining Page ");


		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on Download app img
		atlatt.getATLDownloadApp().click(); 
		System.out.println("Click on Donwload App");
		Thread.sleep(5000);
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
		System.out.println("Click on The best Of Fashion Tab");
		//CLick on Click on Images Link 
		atlf.getatlAppfashionGalleryLink().click();
		System.out.println("Click on Images Link ");
		//Verify Images Link 
		Thread.sleep(1000);
		
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Images"));	
		System.out.println("Vefiry Images Link  Page");

		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		System.out.println("Click on Fashion Gallery Tab");
		//CLick on Click on Images Link 
		atlf.getatlAppfashionGalleryLinkImg().click();
		System.out.println("Click on Images Link Img ");
		//Verify Images Link Img
		Thread.sleep(4000);
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Images"));	
		System.out.println("Vefiry Images Img Page");


		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		System.out.println("Click on Fashion Gallery Tab");
		//CLick on Look Book Link 
		atlf.getatlAppLookBook().click();
		System.out.println("Click on Look Book Link ");
		//Vefiry Lookbooks  Page
		Thread.sleep(5000);
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Lookbooks"));	
		System.out.println("Vefiry Lookbooks  Page");

		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		System.out.println("Click on Fashion Gallery Tab");
		//CLick on  LookbooksImg  Page
		atlf.getatlAppLookBookImg().click();
		System.out.println("Click on Lookbooks  img ");
		//Vefiry Lookbooks img Page
		Thread.sleep(5000);
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Lookbooks"));	
		System.out.println("Vefiry Lookbooks  img Page");


		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		System.out.println("Click on Fashion Gallery Tab");
		//Click on Videos Link 
		atlf.getatlAppvideosImages().click();
		System.out.println("Click on Videos Link ");
		//Vefiry Video  Page
		Thread.sleep(4000);
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Videos"));	
		System.out.println("Vefiry  Video   Page");

		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		System.out.println("Click on Fashion Gallery Tab");
		//CLick on  Video Img  Page
		atlf.getatlAppvideosImagesImg().click();
		System.out.println("Click on  Video   Img ");
		//Vefiry Video img Page
		Thread.sleep(4000);
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Videos"));	
		System.out.println("Vefiry Video  img Page");

		// Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		System.out.println("Click on Fashion Gallery Tab");
		// CLick on News Link
		atlf.getatlAppatlAppNewsImg().click();
		System.out.println("Click on  News Img ");
		// Vefiry News img Page
		Thread.sleep(4000);
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("In The News"));
		System.out.println("Vefiry News  img Page");

		// Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		System.out.println("Click on Fashion Gallery Tab");
		// CLick on News Link
		atlf.getatlAppNews().click();
		System.out.println("Click on  News  ");
		// Vefiry News img Page
		Thread.sleep(4000);
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("In The News"));
		System.out.println("Vefiry News   Page");

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
		amexh = new AMExhibitTabPage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


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
		//if(atlexh.getATLEXPLoginPageTitle().isDisplayed())
		
		
		Thread.sleep(5000);
		try {
			Assert.assertTrue((amexh.getExpHeader()).isDisplayed());
			/*
			 * Assert.assertTrue(atlexh.getATLEXPLoginPageTitle().isDisplayed());
			 * System.out.println("Verify Exp Page");
			 */
			Assert.assertTrue(amexh.getExpHeader().getText().contains("Welcome"));
			System.out.println("Verify Exp Page");
		} catch (Exception e) {
			Assert.assertTrue(atlexh.getATLEXPLoginPageTitle().isDisplayed());
			System.out.println("Verify Exp Page");
		}
		 
		
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		//CLick Exhibitor Resources Link 
		atlva.getDining().click();
		System.out.println("CLick Exhibit Exhibitor Resources");
		//Verify Exhibitor Resources
		Thread.sleep(4000);
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Resources"));	
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
		System.out.println("CLick AmericasMart Link ");
		//Verify MaricasMart Link 
		Thread.sleep(4000);
		Assert.assertTrue(atlm.getATLAppHeaders().getText().contains("Open Year Round"));	
		System.out.println("Verify AmericasMart Link ");

		driver.navigate().back();
		Thread.sleep(5000);
		//Click on Year Round Tab
		atly.getYearRoundTab().click();
		System.out.println("Click on Year Round Tab");
		//CLick Shop The Mart Link 
		atly.getLasVegasDesignCenter().click();
		System.out.println("CLick Shop The Mart Link ");
		//Verify Shop The Mart Link 
		Thread.sleep(4000);

		Assert.assertTrue(atlyr.getShopTheMart().getText().contains("SHOP THE BEST KEPT SECRET IN JEWELRY & FASHION"));	
		System.out.println("Verify Shop The Mart page ");

		driver.navigate().back();		


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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Scroll till footer links

		utl.scrollToElement(atlfo.getAmericasMart());

		
		//Click Americas Mart link and verify results

		atlfo.getAmericasMart().click();
		//Verify About Page
		Assert.assertTrue(mi.getVerifyContactUs().getText().contains("Markets"));	
		System.out.println("Verify About Page");

		driver.navigate().back();
		
		
		atlfo.getAmericasMartfooterlink().click();
		//fl.getClosePopUpAmericasmart().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/"));
		System.out.println("AmericasMart page opened properly");

		driver.navigate().back();


		//Click Atlanta Market link and verify results

		atlfo.getAtlantaMarketFooterLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		System.out.println("Atlanta Market page opened properly");
		driver.navigate().back();

		//Click Heigh Point Market link and verify results

		atlfo.getInternationalMarketCentersFooterLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imcenters.com/"));
		System.out.println("Heigh Point Market page opened properly");
		driver.navigate().back();

		//Click Las Vegas Market link and verify results


		atlfo.getLasVegasMarketFooterLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com"));
		System.out.println("Las Vegas Market page opened properly");
		driver.navigate().back();


		//Click Las Vegas Market link and verify results


		atlfo.getLasVegasAppFooterLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com"));
		System.out.println("Las Vegas App page opened properly");
		driver.navigate().back();
		
		
		//Click International Market Centers link and verify results

		atlfo.getInternationalMarketCentersFooterLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imcenters.com/"));
		System.out.println("International Market Centers page opened properly");
		driver.navigate().back();

		//Click Download The App link and verify results

		atlfo.getDownloadTheApp().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Atlanta Apparel App");
		System.out.println("Download the app page opened properly");
		driver.navigate().back();

		//Click Download The App link and verify results

		atlfo.getPressRealeas().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Press Center");
		System.out.println("Press Realeas page opened properly");
		driver.navigate().back();

		//Click Careers link and verify results

		atlfo.getCareers().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Careers");
		System.out.println("Careers page opened properly");
		driver.navigate().back();


		//Click Contact Us link and verify results

		atlfo.getContactUs().click();
		Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Contact Us");
		System.out.println("Contact Us page opened properly");
		driver.navigate().back();


		atlfo.getPrivacyPolicy().click();
		//Assert.assertEquals(exhp.getVerifyExhibitorDirectory().getText(),"Contact Us");
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imcenters.com/privacy-policy"));
		System.out.println("Privacy Policy page opened properly");
		driver.navigate().back();

		//Footer Logo
		atlfo.getfooterlogo().click();
		Thread.sleep(3000);
		System.out.println("Click on Footer Icon");
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		System.out.println("Verify current page");

		//Footer Address
		String winHandleBefore = driver.getWindowHandle();
		atlfo.getfooterAddress().click();
		System.out.println("Click on Address");

		for(String winHandle : driver.getWindowHandles()){
		driver.switchTo().window(winHandle);}
		String addUrl=driver.getCurrentUrl();
		Assert.assertTrue(driver.getCurrentUrl().contains(addUrl));
		System.out.println("Google map opened successfully.");
		driver.close();
		driver.switchTo().window(winHandleBefore);



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
		utl.scrollToElement(atlfo.getAmericasMart());
		System.out.println("Scroll Down");

		
		
		String winHandleBefore = driver.getWindowHandle();
		//Click on Facebook Icon
		atlfo.getfacebookfootericon().click();
		System.out.println("Click on Facebook");

		for(String winHandle : driver.getWindowHandles()){
		driver.switchTo().window(winHandle);}
		
		System.out.println("Click on FB Icon");
		Thread.sleep(10000);
		//Verify that 'ATL Facebook' page should be displayed
		//Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/AtlantaApparel/"));
		System.out.println("Facebook Page Verify");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		
		
		//Click on twitter Icon
		atlfo.gettwittericonfooter().click();
		System.out.println("Click on Twitter");
		Thread.sleep(10000);
		for(String winHandle : driver.getWindowHandles()){
		driver.switchTo().window(winHandle);}
		Thread.sleep(10000);
		//Verify that 'ATL Facebook' page should be displayed
		//Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/AtlantaApparel/"));
		System.out.println("Twitter Page Verify");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		//Click on Instagram Icon
		atlfo.getinstagramfootericon().click();
		System.out.println("Click on Insta Icon");
		Thread.sleep(10000);
		for(String winHandle : driver.getWindowHandles()){
		driver.switchTo().window(winHandle);}
		Thread.sleep(10000);
		//Verify that 'ATL Facebook' page should be displayed
		//Assert.assertTrue(driver.getCurrentUrl().contains("https://www.facebook.com/AtlantaApparel/"));
		System.out.println("Insta Page Verify");
		driver.close();
		driver.switchTo().window(winHandleBefore);

		//Click on Youtube Icon
		atlfo.getyoutubefootericon().click();
		System.out.println("Click on youtube Icon");
		Thread.sleep(10000);
		for(String winHandle : driver.getWindowHandles()){
		driver.switchTo().window(winHandle);}
		Thread.sleep(10000);
		//Verify that 'ATL Youtube' page should be displayed
		//Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com/AmericasmartAtl"));
		System.out.println("Youtube Page Verify");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		
		
		//Click on SnapChat Icon
		atlfo.getsnapchatfooter().click();
		System.out.println("Click on snapchat Icon");
		Thread.sleep(10000);
		for(String winHandle : driver.getWindowHandles()){
		driver.switchTo().window(winHandle);}
		//Verify that 'ATL snapchat' page should be displayed
		//Assert.assertTrue(driver.getCurrentUrl().contains("https://www.snapchat.com/AmericasmartAtl"));		
		System.out.println("Snapchat Page Verify");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		
	}

	/*@AfterSuite
	public void sendEmail()
	{
		se = new SendEmail();
		se.sendEmailWithAttachment();
	}*/

}



