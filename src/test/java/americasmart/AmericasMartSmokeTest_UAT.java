package americasmart;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.AmericasMart.AMAboutTabPage;
import pageObjects.AmericasMart.AMFooterLinksNavigationPage;
import pageObjects.AmericasMart.AMHeaderLinksPage;
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
	SendEmail se;

	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);
		amhe = new AMHeaderLinksPage(driver);

		//Navigate to Atlanta Market site
		driver.manage().window().maximize();
		driver.get(prop.getProperty("ammarturl"));
		Thread.sleep(8000);
		lap.getIUnderstandBtn().click();
		Thread.sleep(10000);
		amhe.getClosePrompt().click();
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
	}
	
	@Test(priority=3)
	public void TS003_VerifyAllSocialMediaLinksOnFooterTest() throws InterruptedException, IOException
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
		amhe.getClosePrompt().click();
		amfl.getYoutubeIcon().click();

		//Verify that 'AMC Instagram' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com/user/AmericasMart"));
		System.out.println("Instagram opened successfully");
		driver.get(prop.getProperty("ammarturl"));
		amhe.getClosePrompt().click();
	}
	
	@Test(priority=4)
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
	public void T005_VerifyAllHeaderChanelLinksTest() throws InterruptedException, IOException
	{
		
		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

				lap = new UXPLandingPage(driver);
				lp = new UXPLoginPage(driver);
				amhe = new AMHeaderLinksPage(driver);
				//cl = new AMCAllChannelsLinksPage(driver);
				hd=new UXPHeaderChannelLinksPage(driver);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
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
				System.out.println("AmericasMart URL");
				amhe.getClosePrompt().click();
				
				
							
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
				
				
	}
	
	/*@AfterSuite
	public void sendEmail()
	{
		se = new SendEmail();
		se.sendEmailWithAttachment();
	}*/

}



