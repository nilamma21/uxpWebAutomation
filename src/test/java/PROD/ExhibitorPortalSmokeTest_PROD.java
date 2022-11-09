package PROD;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.ExhibitorPortal.*;
import pageObjects.AmericasMart.AMHeaderLinksPage;
import pageObjects.AmericasMart.AMOpenYearRoundPage;
import pageObjects.LasVegasMarket.UXPLandingPage;
import pageObjects.LasVegasMarket.UXPLoginPage;
import resources.GenerateData;
import resources.SendEmail;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class ExhibitorPortalSmokeTest_PROD extends base {
	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	UXPLandingPage lap;
	UXPLoginPage lp;
	EXPNotificationsTabPage nt;
	EXPLoginPage el;
	EXPSettingsPage st;
	AMHeaderLinksPage amhe;
	EXPDigitalShowroomTabPage yd;
	EXPApplicationsAndLeasesTabPage al;
	EXPRegistrationAndServicesTabPage rs;
	EXPMarketTabPage mar;
	EXPFooterLinksPage efl;
	SendEmail se;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException
	{
		//DOMConfigurator.configure("log4j.xml");
		driver = initializeDriver(); //requires for Parallel text execution
//		utl = new Utility(driver);
//		lap = new UXPLandingPage(driver);

		/*//Navigate to Exhibitor Portal
		driver.manage().window().maximize();
		driver.get(prop.getProperty("expurl"));
		 */
	}

	@Test(priority=01)
	public void TS001_VerifyExhibitorPortalLoginTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		el = new EXPLoginPage(driver);
		utl = new Utility(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Navigate to Exhibitor Portal
		driver.manage().window().maximize();
		driver.get(prop.getProperty("expurl"));
		
		//Login to EXP
		el.getEmailAddress().sendKeys(prop.getProperty("username"));
		el.getPassword().sendKeys(prop.getProperty("password"));
		el.getSignInBtn().click();
		//Thread.sleep(5000);
		lap.getIUnderstandBtn().click();
		//Thread.sleep(5000);

		//Verify that Exhibitor Portal Home page should be displayed
		Assert.assertTrue(el.getVerifyExpHomePage().isDisplayed());
		System.out.println("Exhibitor Portal home page is displayed properly.");
	}

	@Test(priority=02)
	public void TS002_VerifyNotificationsTabTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		nt = new EXPNotificationsTabPage(driver);
		st = new EXPSettingsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click Notifications icon and verify results
		nt.getNotifications().click();
		Assert.assertEquals(st.getVerifyManageUsers().getText(), "Exhibitor Portal Message Center");
		System.out.println("Exhibitor Portal notifications page is displayed properly.");
	}

	@Test(priority=03)
	public void TS003_VerifySettingsTabTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		st = new EXPSettingsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		try {
		//Click Settings icon and verify results
		st.getSettings().click();
		Assert.assertTrue(st.getVerifySettings().isDisplayed());
		System.out.println("Settings panel is displayed properly.");

		//Click EXP Guide icon and verify results

		st.getEXPGuide().click();
		String winHandleBefore1 = driver.getWindowHandle();

		for(String winHandle1 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle1);}

		Assert.assertTrue(st.getVerifyEXPGuide().isDisplayed());
		System.out.println("Exhibitor Portal Guide opened successfully.");
		driver.close();
		driver.switchTo().window(winHandleBefore1);


		//Click Manage Users icon and verify results

		st.getManageUsers().click();
		Assert.assertTrue(st.getVerifyManageUsers().getText().contains("Users"));
		System.out.println("Manage Users page is displayed properly.");
		st.getSettings().click();

		//Click Corporate Info icon and verify results

		st.getCorporateInfo().click();
		Assert.assertEquals(st.getVerifyManageUsers().getText(), "Corporate Info");
		System.out.println("Corporate Info page is displayed properly.");



		//Click Contact Customer Support icon and verify results

		/*driver.get(prop.getProperty("setcussupurl"));
				Assert.assertTrue(st.getVerifyEXPGuide().isDisplayed());
				System.out.println("Customer Support page opened successfully.");
				driver.get(prop.getProperty("expurl"));//Code commented as captcha appears for Customer Support link
		 */

	} catch(StaleElementReferenceException e) {
        }

	}

	@Test(priority=04)
	public void TS004_VerifyAllLinkUnderEXPRegistrationsAndServicesTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T101: To verify the All Link Under Your Digi Showroom and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		al=new EXPApplicationsAndLeasesTabPage(driver);
		rs=new EXPRegistrationAndServicesTabPage(driver);
		el=new EXPLoginPage(driver);
		st = new EXPSettingsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		//Click on Registration And Services Tab 
		try {
		//el.getVerifyExpHomePage().click();
		rs.getEXPRegAndServicesTab().click();
		System.out.println("Registration And Services Tab ");
		Assert.assertTrue(st.getVerifySettings().isDisplayed());
		System.out.println("Registration and Services section is displayed properly.");

		//Exhibitor Registration
		rs.getEXPExhibitorReg().click();
		System.out.println("Exhibitor Registration ");
		//Verify Exhibitor Registration Page Header
		Assert.assertTrue(st.getVerifyManageUsers().getText().contains("Market Registrations"));
		System.out.println("Verify Exhibitor Registration Page");
		driver.navigate().back();

		rs.getEXPRegAndServicesTab().click();
		System.out.println("Registration And Services Tab ");

		//Click on Atlanta Services
		System.out.println("Atlanta Services");

		String winHandleBefore1 = driver.getWindowHandle();
		rs.getEXPAtlantaServices().click();		

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://wem.americasmart.com/"));
		// Close the new window, if that window no more required
		//driver.close();
		System.out.println("New Window");
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore1);


		System.out.println("Registration And Services Tab ");

		//Click on Atlanta Advertising and services
		System.out.println("Atlanta Advertising and Sponcership");

		String winHandleBefore2 = driver.getWindowHandle();
		rs.getEXPAtlantaAdvertisingAndSponcership().click();		
		//Click on Exhibitor Portal Login' sub-menu
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://wem.americasmart.com/"));
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore2);

		System.out.println("Registration And Services Tab ");
		//Click on Atlanta Paymet
		System.out.println("Atlanta payment");

		String winHandleBefore3 = driver.getWindowHandle();
		rs.getEXPAtlantaPayment().click();		
		//Click on Exhibitor Portal Login' sub-menu
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://wem.americasmart.com/"));
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore3);

		System.out.println("Registration And Services Tab ");
		//Click on Americas Mart Expo Tool Kit
		rs.getEXPAAmericasMartLogisticsExhibitorToolkit().click();
		String winHandleBefore4 = driver.getWindowHandle();

		//Click on Exhibitor Portal Login' sub-menu
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.expotoolkit.com/"));
		System.out.println("Expo Tool Kit page verified successfully");
		driver.close();
		driver.switchTo().window(winHandleBefore4);

		} catch(StaleElementReferenceException e) {
        }

	}


	@Test(priority=05)
	public void TS005_VerifyAllLinkUnderEXPApplicationsAndLeasesTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T101: To verify the All Link Under Applications And Leases it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		al=new EXPApplicationsAndLeasesTabPage(driver);
		rs=new EXPRegistrationAndServicesTabPage(driver);
		el=new EXPLoginPage(driver);
		st = new EXPSettingsPage(driver);


		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("EXP page");


		//Click on Applications And Leases Tab 

		al.getEXPApplicationsAndLeasesTab().click();
		System.out.println("Applications And Leases Tab ");
		Assert.assertTrue(st.getVerifySettings().isDisplayed());
		System.out.println("Registration and Services section is displayed properly.");

		//Click on Atlanta Permenat Space
		rs.getEXPExhibitorReg().click();


		System.out.println("Atlanta Permenat Space");
		//Verify Atlanta Permanent Space page
		Assert.assertTrue(st.getVerifyManageUsers().getText().contains("Apply for Permanent Showroom Space at AmericasMart"));

		al.getEXPApplicationsAndLeasesTab().click();
		System.out.println("Applications And Leases Tab ");
		//Click Apply for Trade show Space
		System.out.println("Atlanta Apply For Tradeshow Space");
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		al.getEXPAtlantaApplyForTradeshowSpace().click();		

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://wem.americasmart.com/"));
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)

		driver.switchTo().window(winHandleBefore);
		System.out.println("Applications And Leases Tab ");
		//Click on Atlanta Manager Trade show
		System.out.println("Atlanta Manage Tradeshow Space");
		// Store the current window handle
		String winHandleBefore1 = driver.getWindowHandle();
		al.getEXPAtlantaApplyForTradeshowSpace().click();		
		//Click on Exhibitor Portal Login' sub-menu
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://wem.americasmart.com/"));
		driver.close();
		driver.switchTo().window(winHandleBefore1);


		System.out.println("Applications And Leases Tab ");
		System.out.println("Atlanta Payment ");
		//String winHandleBefore2 = driver.getWindowHandle();
		rs.getEXPAtlantaServices().click();	
		//Click on Exhibitor Portal Login' sub-menu

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://wem.americasmart.com/"));
		System.out.println("Verify AtlPayment");
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore1);



		System.out.println("Applications And Leases Tab");
		System.out.println("Las Vegas Permanent Space");
		//Click on Las Vegas Permanent Space
		//al.getEXPApplicationsAndLeasesTab().click();
		//String winHandleBefore3 = driver.getWindowHandle();
		rs.getEXPAAmericasMartLogisticsExhibitorToolkit().click();		
		//Click on Exhibitor Portal Login' sub-menu
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Verify that 'EXP Login' page should be displayed
		Thread.sleep(5000);
		Assert.assertTrue(al.getVerifyPermanantSpace().getText().contains("Leasing Contact Form"));
		System.out.println("Leasing");
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore1);


		System.out.println("Applications And Leases Tab ");
		//Click on Las Vegas Gift and Trade show Space
		System.out.println("Las Vegas Gift and Trade show Space ");


		//	String winHandleBefore4 = driver.getWindowHandle();
		al.getEXPLasVegasGiftHomeTradeshowSpace().click();		
		//Click on Exhibitor Portal Login' sub-menu
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(al.getVerifyGiftHomeTradeshow().getText().contains("Gift and Home Temporaries"));
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore1);
		System.out.println("Applications And Leases Tab ");
		System.out.println("Las Vegas Furnitre and Trade show Space ");
		//Click on Las Vegas Furnitre and Trade show Space
		String winHandleBefore5 = driver.getWindowHandle();
		al.getEXPLasVegasFurnitureTradeshowSpace().click();		
		//Click on Exhibitor Portal Login' sub-menu
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(al.getVerifyGiftHomeTradeshow().getText().contains("EXHIBIT SPACE APPLICATION"));
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore5);

	}

	@Test(priority=06)
	public void TS006_VerifyAllLinkUnderYourDigiShowroomTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T101: To verify the All Link Under Your Digi Showroom and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		yd=new EXPDigitalShowroomTabPage(driver);
		el = new EXPLoginPage(driver);
		st = new EXPSettingsPage(driver);
		rs = new EXPRegistrationAndServicesTabPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		try {
		//Click on Your Digital Showroom Drop-down
		yd.getEXPYourDigiShowroom().click();
		Assert.assertTrue(st.getVerifySettings().isDisplayed());
		System.out.println("Digital Showroom is displayed properly.");

		//Click on Profile Info
		rs.getEXPExhibitorReg().click();
		//verify profile info page
		Assert.assertTrue(yd.getEXPValidateProfile().isDisplayed());

		//Click on Your Digital Showroom Dropdown
		yd.getEXPYourDigiShowroom().click();
		//Click on Lines
		rs.getEXPAtlantaServices().click();
		//verify Lines page
		Assert.assertTrue(st.getVerifyManageUsers().getText().contains("Managing Your Manufacturing Lines"));

		//Click on Your Digital Showroom Dropdown
		yd.getEXPYourDigiShowroom().click();
		//Click on Product
		rs.getEXPAtlantaAdvertisingAndSponcership().click();
		//verify Product page
		Assert.assertTrue(st.getVerifyManageUsers().getText().contains("Products"));

		//Click on Your Digital Showroom Dropdown
		yd.getEXPYourDigiShowroom().click();;
		System.out.println("Your Digital Showroom");
		//Click on Catalog Flipbook
		rs.getEXPAtlantaPayment().click();
		System.out.println("Catalog Flipbook");
		//verify Catalog page
		Assert.assertTrue(st.getVerifyManageUsers().getText().contains("Catalogs"));

		//Click on Your Digital Showroom Dropdown
		yd.getEXPYourDigiShowroom().click();
		System.out.println("Your Digital Showroom");
		//Click on JuniperData Link
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		rs.getEXPAAmericasMartLogisticsExhibitorToolkit().click();	
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		Assert.assertTrue(driver.getTitle().contains("Welcome to Juniper Data"));
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		} catch(StaleElementReferenceException e) {
        }

	}



	@Test(priority=07)
	public void TS007_VerifyAllLinkUnderEXPMarketTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-T101: To verify the All Link Under Market tab and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		amhe = new AMHeaderLinksPage(driver);
		al=new EXPApplicationsAndLeasesTabPage(driver);
		rs=new EXPRegistrationAndServicesTabPage(driver);
		el=new EXPLoginPage(driver);
		mar=new EXPMarketTabPage(driver);
		st=new EXPSettingsPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on Registration And Services Tab 
		mar.getEXPMarketTab().click();
		//Exhibitor Registration
		rs.getEXPExhibitorReg().click();
		//Verify Exhibitor Registration Page Header
		Assert.assertTrue(mar.getEXPManageMarketHeader().getText().contains("Manage Your Markets"));

		mar.getEXPMarketTab().click();
		//Click on Exhibitor Resources
		al.getEXPAtlantaApplyForTradeshowSpace().click();
		Assert.assertTrue(st.getVerifyManageUsers().getText().contains("Exhibitor Resources"));

		mar.getEXPMarketTab().click();
		rs.getEXPAtlantaServices().click();
		Assert.assertTrue(st.getVerifyManageUsers().getText().contains("Manage"));	

		/*mar.getEXPMarketTab().click();
				System.out.println("Market Tab ");

				//Click on Exhibitor Resources
				System.out.println("Market");
				Thread.sleep(5000);
				rs.getEXPAAmericasMartLogisticsExhibitorToolkit().click();
				System.out.println("Verify Market");
				Assert.assertTrue(st.getVerifyManageUsers().getText().contains("Manage"));*/
	}

	@Test(priority=8)
	public void TS008_VerifyExhibitorPortalFooterLinksTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		el = new EXPLoginPage(driver);
		efl = new EXPFooterLinksPage(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Scroll till footer links
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click Exhibitor Portal Symbol and verify results
		efl.getExhibitorPortalSymbol().click();
		Assert.assertTrue(el.getVerifyExpHomePage().isDisplayed());
		System.out.println("EXP home page is displayed properly.");

		//Scroll till footer links
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click Americas Mart link and verify results
		efl.getAmericasMart().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/"));
		System.out.println("Amricas mart page is displayed properly.");
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());


		//Click Atlanta Maeket link and verify results
		efl.getAtlantaMarket().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		System.out.println("Atlanta market page is displayed properly.");
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click Atlanta Apparel link and verify results
		efl.getAtlantaApparel().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		System.out.println("Atlanta Apparel page is displayed properly.");
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click ADAC link and verify results
		efl.getADAC().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://adacatlanta.com/"));
		System.out.println("ADAC page is displayed properly.");
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click IMC Highpoint Market link and verify results
		efl.getHighPointMarket().click();
		String winHandleBefore = driver.getWindowHandle();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("http://www.imchighpointmarket.com/"));
		System.out.println("Atlanta market page is displayed properly.");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click Las Vegas Market link and verify results
		efl.getLasVegasMarket().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/"));
		System.out.println("Las Vegas market page is displayed properly.");
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click Las Vegas Design Center link and verify results
		efl.getLasVegasDesignCenter().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/Year-Round/LVDC"));
		System.out.println("Las Vegas design center page is displayed properly.");
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click Privacy Policy link and verify results
		efl.getPrivacyPolicy().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/Privacy-Policy"));
		System.out.println("Privacy Policy page is displayed properly.");
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click Terms and Conditions link and verify results
		efl.getTermsAndConditions().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imcenters.com/terms-of-use/"));
		System.out.println("Terms and Conditions page is displayed properly.");
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click About Us link and verify results
		efl.getAboutIMC().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imcenters.com/our-story/"));
		System.out.println("About us page is displayed properly.");
		driver.get(prop.getProperty("expurl"));
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