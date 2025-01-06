package PROD;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.ExhibitorPortal.*;
import pageObjects.AmericasMart.AMHeaderLinksPage;
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
		driver = initializeDriver(); //requires for Parallel text execution
//		utl = new Utility(driver);
//		lap = new UXPLandingPage(driver);

		/*//Navigate to Exhibitor Portal
		driver.manage().window().maximize();
		driver.get(prop.getProperty("expurl"));
		 */
	}

	@Test(priority=1)
	public void TS001_EXP_VerifyExhibitorPortalLoginTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		el = new EXPLoginPage(driver);
		utl = new Utility(driver);

		//Navigate to Exhibitor Portal
		driver.manage().window().maximize();
		driver.get(prop.getProperty("expurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		//Login to EXP
		el.getEmailAddress().sendKeys(prop.getProperty("username"));
		el.getPassword().sendKeys(prop.getProperty("password"));
		el.getSignInBtn().click();
		Thread.sleep(2000);
		try {
			lap.getIUnderstandBtn().click();
		} catch (Exception e) {
		}
		//Thread.sleep(5000);

		//Verify that Exhibitor Portal Home page should be displayed
		Assert.assertTrue(el.getVerifyExpHomePage().isDisplayed());
		System.out.println("Exhibitor Portal home page is displayed properly.");
	}

	@Test(priority=2)
	public void TS002_EXP_VerifyNotificationsTabTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		nt = new EXPNotificationsTabPage(driver);
		st = new EXPSettingsPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click Notifications icon and verify results
		nt.getNotifications().click();
		Thread.sleep(1000);
		Assert.assertEquals(st.getVerifyManageUsers().getText(), "Exhibitor Portal Message Center");
		System.out.println("Exhibitor Portal notifications page is displayed properly.");
	}

	@Test(priority=8)
	public void TS003_EXP_VerifySettingsTabTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		st = new EXPSettingsPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Click Settings icon and verify results
		Thread.sleep(2000);
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
		Thread.sleep(3000);
		Assert.assertTrue(st.getVerifyManageUsers().getText().contains("Users"));
		System.out.println("Manage Users page is displayed properly.");
		st.getSettings().click();

		//Click Corporate Info icon and verify results

		st.getCorporateInfo().click();
		Thread.sleep(3000);
		Assert.assertEquals(st.getVerifyManageUsers().getText(), "Corporate Info");
		System.out.println("Corporate Info page is displayed properly.");



		//Click Contact Customer Support icon and verify results

		/*driver.get(prop.getProperty("setcussupurl"));
				Assert.assertTrue(st.getVerifyEXPGuide().isDisplayed());
				System.out.println("Customer Support page opened successfully.");
				driver.get(prop.getProperty("expurl"));//Code commented as captcha appears for Customer Support link
		 */

	}

	@Test(priority=9)
	public void TS004_EXP_VerifyAllLinkUnderEXPRegistrationsAndServicesTabTest() throws InterruptedException, IOException
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
		//driver.get(prop.getProperty("expurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Verify Exhibitor Registration Page
		//Click on Registration And Services Tab 
		rs.getEXPRegAndServicesTab().click();
		Assert.assertTrue(st.getVerifySettings().isDisplayed());
		//Click on Market Badge Registration
		rs.getMarketBadgeRegistration().click();
		Thread.sleep(3000);
		//Verify Exhibitor Registration Page Header
		Assert.assertTrue(st.getVerifyManageUsers().getText().contains("Market Registrations"));
		System.out.println("Exhibitor Registration Page Successfully Opened");
		driver.navigate().back();
		
		utl.scrollToTop();
	    //Verify Atlanta | Permanent Exhibits | Technology Services Page
        rs.getEXPRegAndServicesTab().click();
        Thread.sleep(500);
        //Click on Atlanta | Permanent Exhibits | Technology Services
        //String winHandleBefore7 = driver.getWindowHandle();
        rs.getATLTechnologyServicePermenantTab().click();
        Thread.sleep(3000);
        // Switch to new window opened
     /*   for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }*/
        //Verify that 'EXP Login' page should be displayed
        Assert.assertTrue(driver.getCurrentUrl().contains("https://exhibitors.andmore.com/Technology"));
        System.out.println("Atlanta | Permanent Exhibits | Technology Services Page Successfully Opened");
        // Close the new window, if that window no more required
        //driver.close();
        //driver.close();
        // Switch back to original browser (first window)
        //driver.switchTo().window(winHandleBefore7);
		
		
		//Verify Atlanta | Temporary Booths | Technology Services Page
      //Click on Registration And Services Tab 
      	rs.getEXPRegAndServicesTab().click();
		//Click on Atlanta Technology Services
		String winHandleBefore5 = driver.getWindowHandle();
		rs.getATLTechnologyServiceTab().click();
		Thread.sleep(3000);
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://andmore.safetynetaccess.com/"));
		System.out.println("Atlanta | Temporary Booths | Technology Services Page Successfully Opened");
		// Close the new window, if that window no more required
		//driver.close();
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore5);

/*
		//Verify Atlanta Services Page
		//Click on Atlanta Services
		String winHandleBefore1 = driver.getWindowHandle();
		rs.getATLServices().click();
		Thread.sleep(7000);
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://wem.americasmart.com/"));
		System.out.println("Atlanta Services Page Successfully Opened");
		// Close the new window, if that window no more required
		//driver.close();
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore1);
*/
		
		//Verify Atlanta | Electrical & Lighting Services Page
		//Click on Atlanta | Electrical & Lighting Services
		rs.getATLElectricalAndLightingServices().click();
		Thread.sleep(7000);
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://exhibitors.andmore.com/services"));
		System.out.println("Atlanta | Electrical & Lighting Services Page Successfully Opened");
		
		//Verify Atlanta | Advertising & Sponsorship Page
		//Click on Registration And Services Tab 
      	rs.getEXPRegAndServicesTab().click();
		//Click on Atlanta Advertising and services
		String winHandleBefore2 = driver.getWindowHandle();
		rs.getATLAdvertisingAndSponsorship().click();
		//Click on Exhibitor Portal Login' sub-menu
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://wem.americasmart.com/"));
		System.out.println("Atlanta | Advertising & Sponsorship Page Successfully Opened");
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore2);

		//Verify Atlanta | Payments Page
		//Click on Atlanta Payments
		rs.getATLPayments().click();
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://exhibitors.andmore.com/payments"));
		System.out.println("Atlanta | Payments Page Successfully Opened");
		utl.scrollToTop();
		//Verify AmericasMart Logistics | Exhibitor Toolkit Page
		//Click on Registration And Services Tab 
      	rs.getEXPRegAndServicesTab().click();
		//Click on AmericasMart Exhibitor Tool Kit
		rs.getAMCLogisticsAndExhToolkit().click();
		String winHandleBefore4 = driver.getWindowHandle();
		//Click on Exhibitor Portal Login' sub-menu
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.expotoolkit.com/"));
		System.out.println("AmericasMart Logistics | Exhibitor Toolkit Page Successfully Opened");
		driver.close();
		driver.switchTo().window(winHandleBefore4);

		//Verify Las Vegas | Permanent Booths | Technology Services Page
		//Click on Las Vegas Permanent Technology Services
		rs.getLVMPermanentTechnologyServiceTab().click();
		Thread.sleep(3000);
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://exhibitors.andmore.com/Technology"));
		System.out.println("Las Vegas | Permanent Booths | Technology Services Page Successfully Opened");
		// Close the new window, if that window no more required
		
		//Verify Las Vegas | Temporary Booths | Technology Services Page
		//Click on Temporary Registration And Services Tab 
      	rs.getEXPRegAndServicesTab().click();
		//Click on Las Vegas Technology Services
		String winHandleBefore6 = driver.getWindowHandle();
		rs.getLVMTemporaryTechnologyServiceTab().click();
		Thread.sleep(3000);
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://andmore.safetynetaccess.com/"));
		System.out.println("Las Vegas | Temporary Booths | Technology Services Page Successfully Opened");
		// Close the new window, if that window no more required
		//driver.close();
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore6);
		
	}

	@Test(priority=5)
	public void TS005_EXP_VerifyAllLinkUnderEXPApplicationsAndLeasesTest() throws InterruptedException, IOException
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

		driver.get(prop.getProperty("expurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("EXP page");

		Thread.sleep(1000);
		//Click on Applications And Leases Tab 
		utl.scrollToTop();
		al.getEXPApplicationsAndLeasesTab().click();
		System.out.println("Applications And Leases Tab ");
		Thread.sleep(3000);
		Assert.assertTrue(st.getVerifySettings().isDisplayed());
		System.out.println("Registration and Services section is displayed properly.");

		//Click on Atlanta Permenat Space
		rs.getEXPExhibitorReg().click();

		
		System.out.println("Atlanta Permenat Space");
		//Verify Atlanta Permanent Space page
		Assert.assertTrue(st.getVerifyManageUsers().getText().contains("Apply for Permanent Showroom Space at AmericasMart"));

		al.getEXPApplicationsAndLeasesTab().click();
		System.out.println("Applications And Leases Tab ");
		Thread.sleep(3000);
		//Click Apply for Trade show Space
		System.out.println("Atlanta Apply For Tradeshow Space");
		// Store the current window handle
		//String winHandleBefore = driver.getWindowHandle();
		al.getEXPAtlantaApplyForTradeshowSpace().click();		

		// Switch to new window opened
/*		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}*/
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://exhibitors.andmore.com/Apply-For-Space"));
		// Close the new window, if that window no more required
/*		driver.close();
		// Switch back to original browser (first window)

		driver.switchTo().window(winHandleBefore);*/
		System.out.println("Applications And Leases Tab ");
		//Click on Atlanta Manager Trade show
		System.out.println("Atlanta Manage Tradeshow Space");
		Thread.sleep(3000);
		al.getEXPApplicationsAndLeasesTab().click();
		// Store the current window handle
		//String winHandleBefore1 = driver.getWindowHandle();
		al.getEXPAtlantaApplyForTradeshowSpace().click();		
		//Click on Exhibitor Portal Login' sub-menu
		// Switch to new window opened
/*		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}*/
		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://exhibitors.andmore.com/Apply-For-Space"));
/*		driver.close();
		driver.switchTo().window(winHandleBefore1);*/

		
		System.out.println("Applications And Leases Tab ");
		System.out.println("Atlanta Payment ");
		Thread.sleep(3000);	
		al.getEXPApplicationsAndLeasesTab().click();
		//String winHandleBefore2 = driver.getWindowHandle();
		rs.getEXPAtlantaServices().click();	
		//Click on Exhibitor Portal Login' sub-menu

		// Switch to new window opened
/*		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}*/

		//Verify that 'EXP Login' page should be displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("https://exhibitors.andmore.com/payments"));
		System.out.println("Verify AtlPayment");
/*		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore2);*/



		System.out.println("Applications And Leases Tab");
		System.out.println("Las Vegas Permanent Space");
		//Click on Las Vegas Permanent Space
		utl.scrollToTop();
		al.getEXPApplicationsAndLeasesTab().click();
		Thread.sleep(500);
		//al.getEXPApplicationsAndLeasesTab().click();
		String winHandleBefore3 = driver.getWindowHandle();
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
		driver.switchTo().window(winHandleBefore3);


		System.out.println("Applications And Leases Tab ");
		//Click on Las Vegas Gift and Trade show Space
		System.out.println("Las Vegas Gift and Trade show Space ");

		Thread.sleep(3000);
		String winHandleBefore4 = driver.getWindowHandle();
		al.getEXPLasVegasGiftHomeTradeshowSpace().click();		
		//Click on Exhibitor Portal Login' sub-menu
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		//Verify that 'EXP Login' page should be displayed
		Thread.sleep(2000);
		Assert.assertTrue(driver.getTitle().contains("Gift and Home Temporaries"));
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore4);
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
		Thread.sleep(1000);
		Assert.assertTrue(driver.getTitle().contains("Home Furnishings Temporaries"));
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore5);

	}

	@Test(priority=6)
	public void TS006_EXP_VerifyAllLinkUnderYourDigiShowroomTest() throws InterruptedException, IOException
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
		driver.get(prop.getProperty("expurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		//utl.scrollToTop();
		//Click on Your Digital Showroom Drop-down
		yd.getEXPYourDigiShowroom().click();
		Thread.sleep(3000);
		Assert.assertTrue(st.getVerifySettings().isDisplayed());
		System.out.println("Digital Showroom is displayed properly.");

		//Click on Profile Info
		rs.getEXPExhibitorReg().click();
		Thread.sleep(3000);
		//verify profile info page
		Assert.assertTrue(yd.getEXPValidateProfile().isDisplayed());

		//Click on Your Digital Showroom Dropdown
		yd.getEXPYourDigiShowroom().click();
		Thread.sleep(3000);
		//Click on Lines
		rs.getEXPAtlantaServices().click();
		Thread.sleep(3000);
		//verify Lines page
		Assert.assertTrue(st.getVerifyManageUsers().getText().contains("Managing Your Manufacturing Lines"));

		//Click on Your Digital Showroom Dropdown
		yd.getEXPYourDigiShowroom().click();
		Thread.sleep(3000);
		//Click on Product
		rs.getEXPAtlantaAdvertisingAndSponcership().click();
		Thread.sleep(3000);
		//verify Product page
		Assert.assertTrue(st.getVerifyManageUsers().getText().contains("Products"));

		//Click on Your Digital Showroom Dropdown
		yd.getEXPYourDigiShowroom().click();
		Thread.sleep(3000);
		System.out.println("Your Digital Showroom");
		//Click on Catalog Flipbook
		rs.getEXPAtlantaPayment().click();
		Thread.sleep(3000);
		System.out.println("Catalog Flipbook");
		//verify Catalog page
		Assert.assertTrue(st.getVerifyManageUsers().getText().contains("Catalogs"));

		//Click on Your Digital Showroom Dropdown
		yd.getEXPYourDigiShowroom().click();
		Thread.sleep(3000);

		//Click on JuniperData Link
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		yd.getEXPJuniperData().click();	
		Thread.sleep(3000);
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(15000);
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("https://auth.junipercore.com/"));
		// Close the new window, if that window no more required
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

	}



	@Test(priority=7)
	public void TS007_EXP_VerifyAllLinkUnderEXPMarketTabTest() throws InterruptedException, IOException
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
		//driver.get(prop.getProperty("expurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		
		//Click on Registration And Services Tab 
		mar.getEXPMarketTab().click();
		Thread.sleep(500);
		//Exhibitor Registration
		rs.getEXPExhibitorReg().click();
		Thread.sleep(2000);
		//Verify Exhibitor Registration Page Header
		Assert.assertTrue(mar.getEXPManageMarketHeader().getText().contains("Manage Your Markets"));

		mar.getEXPMarketTab().click();
		Thread.sleep(500);
		//Click on Exhibitor Resources
		al.getEXPAtlantaApplyForTradeshowSpace().click();
		Thread.sleep(2000);
		Assert.assertTrue(st.getVerifyManageUsers().getText().contains("Exhibitor Resources"));

		mar.getEXPMarketTab().click();
		Thread.sleep(500);
		rs.getEXPAtlantaServices().click();
		Thread.sleep(2000);
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

	@Test(priority=4)
	public void TS008_EXP_VerifyExhibitorPortalFooterLinksTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
		el = new EXPLoginPage(driver);
		efl = new EXPFooterLinksPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Scroll till footer links
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click Exhibitor Portal Symbol and verify results
		efl.getExhibitorPortalSymbol().click();
		Assert.assertTrue(el.getVerifyExpHomePage().isDisplayed());
		System.out.println("EXP home page is displayed properly.");

		//Scroll till footer links
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click Americas Mart link and verify results
		String winHandleBefore2 = driver.getWindowHandle();
		efl.getAmericasMart().click();
		for (String winHandle2 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle2);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.americasmart.com/"));
		System.out.println("Amricas mart page is displayed properly.");
		driver.close();
		driver.switchTo().window(winHandleBefore2);
		Thread.sleep(2000);
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());


		//Click Atlanta Maeket link and verify results
		String winHandleBefore3 = driver.getWindowHandle();
		efl.getAtlantaMarket().click();
		for (String winHandle3 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle3);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlantamarket.com/"));
		System.out.println("Atlanta market page is displayed properly.");
		driver.close();
		driver.switchTo().window(winHandleBefore3);
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click Atlanta Apparel link and verify results
		String winHandleBefore4 = driver.getWindowHandle();
		efl.getAtlantaApparel().click();
		for (String winHandle4 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle4);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.atlanta-apparel.com/"));
		System.out.println("Atlanta Apparel page is displayed properly.");
		driver.close();
		driver.switchTo().window(winHandleBefore4);
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click ADAC link and verify results
		efl.getADAC().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://adacatlanta.com/"));
		System.out.println("ADAC page is displayed properly.");
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click Andmore Highpoint Market link and verify results
		efl.getHighPointMarket().click();
		String winHandleBefore = driver.getWindowHandle();

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(8000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmorehighpointmarket.com/"));
		System.out.println("Atlanta market page is displayed properly.");
		driver.close();
		driver.switchTo().window(winHandleBefore);
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());
		
		//Click Las Vegas Apparel link and verify results
		String winHandleBefore6 = driver.getWindowHandle();
		efl.getLasVegasApparel().click();
		for (String winHandle6 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle6);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegas-apparel.com/"));
		System.out.println("Las Vegas Apparel page is displayed properly.");
		driver.close();
		driver.switchTo().window(winHandleBefore6);
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click Las Vegas Market link and verify results
		String winHandleBefore7 = driver.getWindowHandle();
		efl.getLasVegasMarket().click();
		for (String winHandle7 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle7);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/"));
		System.out.println("Las Vegas market page is displayed properly.");
		driver.close();
		driver.switchTo().window(winHandleBefore7);
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click Las Vegas Design Center link and verify results
		String winHandleBefore8 = driver.getWindowHandle();
		efl.getLasVegasDesignCenter().click();
		for (String winHandle8 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle8);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.lasvegasmarket.com/Year-Round/LVDC"));
		System.out.println("Las Vegas design center page is displayed properly.");
		driver.close();
		driver.switchTo().window(winHandleBefore8);
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click Privacy Policy link and verify results
		efl.getPrivacyPolicy().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/privacy-policy"));
		System.out.println("Privacy Policy page is displayed properly.");
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());

		//Click Terms and Conditions link and verify results
		String winHandleBefore9 = driver.getWindowHandle();
		efl.getTermsAndConditions().click();
		for (String winHandle9 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle9);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/terms-of-use"));
		System.out.println("Terms and Conditions page is displayed properly.");
		driver.close();
		driver.switchTo().window(winHandleBefore9);
		driver.get(prop.getProperty("expurl"));
		utl.scrollToElement(efl.getExhibitorPortalSymbol());
		
		//Due to re-branding changes
/*		//Click About Us link and verify results
		efl.getAboutIMC().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.imcenters.com/our-story/"));
		System.out.println("About us page is displayed properly.");
		driver.get(prop.getProperty("expurl"));
*/		
		//Click ANDMORE About Us link and verify results
		efl.getandmore().click();
		String winHandleBefore5 = driver.getWindowHandle();
		for(String winHandle5 : driver.getWindowHandles()){
			driver.switchTo().window(winHandle5);}
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.andmore.com/about-us"));
		driver.close();
		driver.switchTo().window(winHandleBefore5);
		utl.scrollToElement(efl.getExhibitorPortalSymbol());
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