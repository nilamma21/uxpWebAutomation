package PROD;

import static org.testng.Assert.assertTrue;

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
		//DOMConfigurator.configure("log4j.xml");
		
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
	public void TS001_ATLApp_VerifyAllLinksUnderYearRoundTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T011: To Year Round Tab

		utl=new Utility(driver);
		atlm=new ATLAppMarketsTabPage(driver);
		atly=new UXPYearRoundPage(driver);
		atlyr=new ATLAppYearRoundTabPage(driver);
		
		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		//Click on Year Round Tab
		atly.getYearRoundTab().click();
		System.out.println("Click on Year Round Tab");
		//CLick AmericasMart Link 
		Thread.sleep(1000);
		atly.getYearRound().click();//changed to AmericasMart
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
		Assert.assertTrue(driver.getTitle().contains("Shop the Mart"));	
		System.out.println("Verify Shop The Mart page ");

		//driver.get(prop.getProperty("atlappurl"));	
	}
	
	@Test(enabled=false)//priority=2
	public void TS002_ATLApp_MarketRecap() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T798: Market Recap page opens successfully.
		utl=new Utility(driver);
		lap = new UXPLandingPage(driver);
		
		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Verify Market Recap link is working properly
		lap.getMarketRecap().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/Attend/App"));
		System.out.println("Market Recap page is working properly.");
		//driver.get(prop.getProperty("atlappurl"));
	}
	
	@Test(priority=3)
	public void TS003_ATLApp_VerifyAllLinksUnderAttendTabTest() throws InterruptedException, IOException
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
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
		Thread.sleep(3000);
		Assert.assertTrue(exhp.getverifyBreadcrumb_ATLAPP().getText().contains("Services & Amenities"));
		System.out.println("Services and Amenities page is displayed properly");
		
		//Click on Attend Tab
		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on FAQs
		atlatt.getATLFAQs().click(); 
		Thread.sleep(3000);
		System.out.println("Click on FAQs");
		//Verify Faq Page
		Assert.assertTrue(exhp.getverifyBreadcrumb_ATLAPP().getText().contains("FAQs"));	
		System.out.println("Vefiry FAQ Page");	

		//Click on Attend Tab
		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on Hotels
		atlatt.getATLHotels().click(); 
		Thread.sleep(3000);
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
		Thread.sleep(3000);
		System.out.println("Click on Travel");
		//Verify Hotels Page
		//Thread.sleep(1000);
		Assert.assertTrue(exhp.getverifyBreadcrumb_ATLAPP().getText().contains("Travel"));	
		System.out.println("Vefiry Travel Page ");	

		//Click on Attend Tab
		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on Events img
		atlatt.getATLEvents().click(); 
		Thread.sleep(3000);
		System.out.println("Click on Events");
	//	Thread.sleep(1000);
		//Verify Hotels Page
		//System.out.println(atlm.getATLAppHeadersnext().getText());
		Assert.assertTrue(exhp.getverifyBreadcrumb_ATLAPP().getText().contains("Events"));	
		System.out.println("Vefiry Events Page ");	

		//Click on Attend Tab
		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on Dining img
		atlatt.getATLDining().click(); 
		Thread.sleep(3000);
		System.out.println("Click on Dining");
		//Thread.sleep(1000);
		//Verify Hotels Page
		Assert.assertTrue(exhp.getverifyBreadcrumb_ATLAPP().getText().contains("Dining"));	
		System.out.println("Vefiry Dining Page ");

		atat.getATLAttendTab().click();
		System.out.println("Click on Attend Tab");
		//CLick on Download app img
		atlatt.getATLDownloadApp().click(); 
		Thread.sleep(3000);
		System.out.println("Click on Donwload App");
		//Thread.sleep(3000);
		//Verify Hotels Page
		Assert.assertTrue(driver.getTitle().contains("Plan Your Market"));	
		System.out.println("Vefiry Download App Page ");
	}

	@Test(priority=4)
	public void TS004_ATLApp_VerifyGlobalSearchFunctionalityTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T04: To verify global search functionality

		utl=new Utility(driver);
		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		gs = new UXPGlobalSearchPage(driver);
		gbs = new ATLAppGlobalSearchPage(driver);
		atlm = new ATLAppMarketsTabPage(driver);

		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		gs.getGlobalSearchTextBox().sendKeys((prop.getProperty("globalsearchinput")));
		gs.getSearchButton().click();
		Thread.sleep(10000);
		utl.scrollToElement(gs.getVerifyGlobalSeacrh());
		String searchterm = gs.getVerifyGlobalSeacrh().getText();
		//Thread.sleep(8000);
		Assert.assertTrue(searchterm.contains(prop.getProperty("globalsearchinput")));
		System.out.println("Global Search functionality is working properly.");
		//driver.get(prop.getProperty("atlappurl"));
		
	}

	@Test(priority=5)
	public void TS005_ATLApp_VerifyExhibitorDirectoryTest() throws InterruptedException, IOException
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

		/*utl.scrollToElement(mi.getVerifyContactUs());
		amhe.getExhbAndProdsTab().click();
		gs.getSearchButton().click();*/
		Thread.sleep(10000);
		utl.scrollToElement(mi.getVerifyContactUs());
		Thread.sleep(3000);
		String searchterm = gs.getVerifyGlobalSeacrh().getText();
		Assert.assertTrue(searchterm.contains(prop.getProperty("exhibitordirectory")));
		System.out.println("Exhibitor Directory page is working properly.");
		
	}

	@Test(priority=6)
	public void TS006_ATLApp_VerifyAllLinksUnderMarketsTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T06: To verify Markets Tab

		utl=new Utility(driver);
		mi = new UXPMarketInfoPage(driver);
		atlm=new ATLAppMarketsTabPage(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("atlappurl"));
		Thread.sleep(5000);
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
		System.out.println("Click on Formal Image");
		//Verify Atlanta Apparel Page
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Formal Markets"));	//Due to re-branding changes. previous 'VOW', now 'Formal Markets'
		System.out.println("Verify Formal Markets Page");

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
		
		Thread.sleep(2000);
		mi.getMarketInfoHeader().click();
		System.out.println("Click on Markets Tab");
		//Click on Atlanta App Image
		atlm.getATLLasVegasAppImg().click();
		System.out.println("Click on Las Vegas App Image");
		//Verify Atlanta Apparel Page
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));	
		System.out.println("Verify Las Vegas App Img Page");
		//driver.get(prop.getProperty("atlappurl"));
		
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

	@Test(priority=7)
	public void TS007_ATLApp_VerifyAllLinksUnderExhibitorsAndBrandsTabTest() throws InterruptedException, IOException
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

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Exhibitors And Brands Tab
		driver.get(prop.getProperty("atlappurl"));
		Thread.sleep(5000);
		exhp.getExhibitorsAndBrands().click();
		System.out.println("Click on Exhibitors And Brands Tab");
		/*//CLick on Exhibitor Directory
		
		exhp.getExhibitorDirectory().click();
		System.out.println("Click on Exhibitor Directory");
		//Verify Exhibitor Directory Page
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Exhibitor Directory"));	
		System.out.println("Verify Exhibitor Directory Page");*/

		//Click on Exhibitors And Products Tab
		exhp.getExhibitorsAndProducts().click();
		System.out.println("Click on Exhibitors And Products Tab");
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Atlanta Apparel Exhibitor Directory"));	
		System.out.println("Verify Exhibitor, Lines & Product Directory Page");
		
		//Click on Floor Plans
		exhp.getExhibitorsAndBrands().click();
		atlappexh.getATLAppFloorplans().click();
		System.out.println("Click on Floor Plans");
		//Verify Floor Plan Page
		//Assert.assertTrue(atlexhp.getATLVerifyFloorPlans().isDisplayed());
		Assert.assertTrue(atlexhp.getATLVerifyFloorPlans().isDisplayed());
		System.out.println("Verify Floor Plan Page");

		//Click on Exhibitors And Brands Tab
		
		exhp.getExhibitorsAndBrands().click();
		System.out.println("Click on Exhibitors And Brands Tab");
		//Click on categories
		atlappexh.getATLAppatlaappCategories().click();
		System.out.println("Click on Categoris");
		//Verify All Brands Page
		Assert.assertTrue(atlm.getATLAppHeadersnext().getText().contains("Categories"));
		System.out.println("Verify Categories Page");


	}
	
	@Test(priority=8)
	public void TS008_ATLApp_VerifySocialMediaLinksTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T013: To verify the all social media links and it's redirection

		atlfo=new ATLAppFooterLinksNavigationPage(driver);
		utl=new Utility(driver);

		driver.get(prop.getProperty("atlappurl"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
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
	
	@Test(priority=11)
	public void TS009_ATLApp_VerifyAllLinksUnderTheBestOfFashionTabTest() throws InterruptedException, IOException
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
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("atlappurl"));
		Thread.sleep(5000);
		//Click on Fashion Gallery Tab
		//utl.scrollToElement(atlf.getatlAppFashionGalleryTab());
		atlf.getatlAppFashionGalleryTab().click();
		Thread.sleep(2000);
		//CLick on Click on Images sub-menu 
		atlf.getatlAppfashionGalleryLink().click();
		Thread.sleep(3000);
		//Verify Images page 
		Assert.assertTrue(driver.getCurrentUrl().contains(prop.getProperty("atlappurl")+"The-Best-Of/Lookbooks-and-Brand-Books"));	

		//Click on Fashion Gallery Tab
		/*atlf.getatlAppFashionGalleryTab().click();
		//CLick on Lookbooks Link 
		atlf.getatlAppLookBook().click();
		//Verify Lookbooks  Page
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Lookbooks"));	*/
		
		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		Thread.sleep(2000);
		//Click on Videos Link 
		String winHandleBefore = driver.getWindowHandle();
		atlf.getatlAppvideosImages().click();
		Thread.sleep(3000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		//Verify Videos  Page
		//Assert.assertTrue(exhp.getverifyBreadcrumb_ATLAPP().getText().contains("Videos"));	
		Assert.assertTrue(driver.getCurrentUrl().contains("youtube.com"));
		driver.close();
		driver.switchTo().window(winHandleBefore);

		//Click on Fashion Gallery Tab
		//atlf.getatlAppFashionGalleryTab().click();
		//Click on In The News Link 
		atlf.getatlAppNews().click();
		Thread.sleep(3000);
		//Verify In the News  Page
		Assert.assertTrue(exhp.getverifyBreadcrumb_ATLAPP().getText().contains("In The News"));	
		
		//Click on Fashion Gallery Tab
		atlf.getatlAppFashionGalleryTab().click();
		//Click on In Trends Link 
		atlf.getTrends().click();
		Thread.sleep(3000);
		//Verify In the Trends  Page
		Assert.assertTrue(driver.getCurrentUrl().contains("Trends"));	
	}
	

	@Test(priority=10)
	public void TS010_ATLApp_VerifyAllLinksUnderExhibitTabTest() throws InterruptedException, IOException
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
		//utl.scrollToElement(atlva.getAttend());
		atlva.getAttend().click();
		System.out.println("Click on Exhibit Tab");
		//CLick Exhibit at atlanta apparel Link 
		atlva.getHotels().click();
		System.out.println("CLick Advertising Sponsorship");
		//Verify Exhibit In Social Occasion 
		//Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyBreadcrumb().getText().contains("Advertising + Sponsorship"));	
		System.out.println("Verify Advertising Sponsorship ");

		//Click on Exhibit Tab
		atlva.getAttend().click();
		System.out.println("Click on Exhibit Tab");
		//CLick Show Dates Link 
		atlva.getTravel().click();
		System.out.println("CLick Show Dates");
		//Verify Show Dates 
		Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyBreadcrumb().getText().contains("Complete Show Dates"));	
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
		Thread.sleep(10000);
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://prodmvdp.b2clogin.com/"));
		System.out.println("Verify Exp Page");
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
		//Due to re-branding changes
/*		//CLick Exhibitor Resources Link 
		atlva.getDining().click();
		System.out.println("CLick Exhibit Exhibitor Resources");
		//Verify Exhibitor Resources
		//Thread.sleep(4000);
		Assert.assertTrue(exhp.getVerifyExhibitorDirectory().getText().contains("Resources"));	
		System.out.println("Verify Exhibitor Resources ");	
*/
	}

	@Test(priority=11)
	public void TS011_ATLApp_VerifyFooterLinksTest() throws InterruptedException, IOException
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		//Scroll till footer links
		utl.scrollToElement(fl.getmarketInfoATL());

		//Click Market Info link and verify results
		fl.getmarketInfoATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/Markets"));
		driver.get(prop.getProperty("atlappurl"));
		Thread.sleep(2000);
		utl.scrollToElement(fl.getmarketInfoATL());
		
		//Click on Press Center
		fl.getpressCenterATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/Markets/Press-Center"));
		driver.get(prop.getProperty("atlappurl"));
		Thread.sleep(2000);
		utl.scrollToElement(fl.getmarketInfoATL());
		
		// Click Download The App link and verify results
		fl.getDownloadTheApp().click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/Attend/App"));
		driver.get(prop.getProperty("atlappurl"));
		utl.scrollToElement(fl.getmarketInfoATL());
		
		//Click on Our Brand link
		fl.getOurBrandsATL().click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/exhibitor/directory"));
		driver.get(prop.getProperty("atlappurl"));
		Thread.sleep(2000);
		utl.scrollToElement(fl.getmarketInfoATL());
		
		// Click Contact Us link and verify results
		
		String winHandleBefore5 = driver.getWindowHandle();
		fl.getContactUsATL().click();
		for (String winHandle5 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle5);
		}
		//Assert.assertEquals(mi.getverifyContactUsATL().getText(), "Contact Us");
		Assert.assertTrue(driver.getCurrentUrl().contains("/About/Contact-Us"));
		driver.close();
		driver.switchTo().window(winHandleBefore5);
		
		// Click Careers link and verify results
		fl.getCareersATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("www.andmore.com/our-team"));
		driver.navigate().back();
		/*			
		//String winHandleBefore6 = driver.getWindowHandle();
		for (String winHandle6 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle6);
		}
		driver.close();
		driver.switchTo().window(winHandleBefore6);
*/	
		// Click on Terms & condition link
		
		// Switch to new tab
		String winHandleBefore7 = driver.getWindowHandle();
		fl.getTermsAndConditions().click();
		for (String winHandle7 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle7);
		}
		//Assert.assertEquals(fl.getVerifyTermsOfUse().getText(), "TERMS OF USE");
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/terms-of-use"));
		driver.close();
		driver.switchTo().window(winHandleBefore7);

		// Click Privacy Policy and verify results
		/*driver.get(prop.getProperty("atlappurl"));
		utl.scrollToElement(fl.getmarketInfoATL());*/
		// Click Privacy Policy link and verify results
		fl.getatlprivacypolicy().click();
		Thread.sleep(500);
		String winHandleBefore8 = driver.getWindowHandle();
		for (String winHandle8 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle8);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/privacy-policy"));
		driver.close();
		driver.switchTo().window(winHandleBefore8);
		// utl.scrollToElement(fl.getmarketInfoATL());
		/*driver.get(prop.getProperty("atlappurl"));
		utl.scrollToElement(fl.getmarketInfoATL());*/
		
		// Click Americas Mart link and verify results
		
		String winHandleBefore9 = driver.getWindowHandle();
		fl.getAmericasMart_ATLApp().click();
		for (String winHandle9 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle9);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore9);
		/*driver.get(prop.getProperty("atlappurl"));
		utl.scrollToElement(fl.getmarketInfoATL());*/
		
		// Click Atlanta Market link and verify results
		
		// Switch to new tab
		String winHandleBefore1 = driver.getWindowHandle();
		fl.getAtlantaMarket().click();
		for (String winHandle1 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle1);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore1);
		//utl.scrollToElement(fl.getmarketInfoATL());

		// Click on High Point Market link
		// Switch to new tab
		String winHandleBefore4 = driver.getWindowHandle();
		fl.getHighPointMarket().click();
		for (String winHandle4 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle4);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmorehighpointmarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore4);
		//utl.scrollToElement(fl.getmarketInfoATL());
		
		// Click on LVA Market link
		// Switch to new tab
		/*fl.getlvapplink_ATL().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));*/
		
		String winHandleBefore12 = driver.getWindowHandle();
		fl.getlvapplink_ATL_Footer().click();
		for (String winHandle4 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle4);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));
		//driver.close();
		driver.switchTo().window(winHandleBefore12);
		
		//driver.get(prop.getProperty("atlappurl"));
		//utl.scrollToElement(fl.getmarketInfoATL());
		
		// Click on LVM Market link
		// Switch to new tab
		String winHandleBefore11 = driver.getWindowHandle();
		fl.getlvmlink_ATL().click();
		for (String winHandle11 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle11);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore11);
			
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
		
		//Switch to new tab
		String winHandleBefore3 = driver.getWindowHandle();
		fl.getandmore().click();
		for(String winHandle3 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle3);}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore3);
		
		//driver.get(prop.getProperty("atlappurl"));
		
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
	
	//Due to re-branding changes
	@Test(enabled=false)//priority=2
	public void TS013_ATLApp_VerifyMarketPlannerProfileOptionTest() throws InterruptedException, IOException
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