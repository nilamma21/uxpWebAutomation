package exhibitorportal;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ExhibitorPortal.EXPApplicationsAndLeasesTabPage;
import ExhibitorPortal.EXPDigitalShowroomTabPage;
import ExhibitorPortal.EXPLoginPage;
import ExhibitorPortal.EXPMarketTabPage;
import ExhibitorPortal.EXPNotificationsTabPage;
import ExhibitorPortal.EXPRegistrationAndServicesTabPage;
import ExhibitorPortal.EXPSettingsPage;
import pageObjects.AmericasMart.AMHeaderLinksPage;
import pageObjects.AmericasMart.AMOpenYearRoundPage;
import pageObjects.LasVegasMarket.UXPLandingPage;
import pageObjects.LasVegasMarket.UXPLoginPage;
import resources.GenerateData;
import resources.SendEmail;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class ExhibitorPortalSmokeTest_UAT extends base {
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
	SendEmail se;

	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);
		
		//Navigate to Exhibitor Portal
		driver.manage().window().maximize();
		driver.get(prop.getProperty("expurl"));
			
	}

	@Test(priority=01)
	public void TS001_VerifyExhibitorPortalLoginTest() throws InterruptedException, IOException
	{
		
		//The purpose of this test case to verify:-
		//UXP-T101: To verify the Market Planner overview and it's functionality

				lap = new UXPLandingPage(driver);
				lp = new UXPLoginPage(driver);
				el = new EXPLoginPage(driver);
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//Login to Market Planner
				el.getEmailAddress().sendKeys(prop.getProperty("username"));
				el.getPassword().sendKeys(prop.getProperty("password"));
				el.getSignInBtn().click();
				Thread.sleep(5000);
				lap.getIUnderstandBtn().click();
				Thread.sleep(5000);
				
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
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//Click Notifications icon and verify results
				nt.getNotifications().click();
				Assert.assertEquals(nt.getVeirfyNotifications().getText(), "Exhibitor Portal Message Center");
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
				
				
				
	}
	
	@Test(priority=04)
	public void TS004_VerifyAllLinkUnderYourDigiShowroomTest() throws InterruptedException, IOException
	{
		
		//The purpose of this test case to verify:-
		//UXP-T101: To verify the All Link Under Your Digi Showroom and it's functionality

				lap = new UXPLandingPage(driver);
				lp = new UXPLoginPage(driver);
				amhe = new AMHeaderLinksPage(driver);
				yd=new EXPDigitalShowroomTabPage(driver);
				el=new EXPLoginPage(driver);
				

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println("EXP page");
			
				
				//Click on Your Digital Showroom Dropdown
				yd.getEXPYourDigiShowroom().click();
				System.out.println("Your Digital Showroom");
				//Click on Profile Info
				yd.getEXPProfileInfo().click();
				System.out.println("Profile Info");
				//verify profile info page
				Assert.assertTrue(yd.getEXPYourDigiShowroomAllHeader().getText().contains("Global"));
				//System.out.println(yd.getEXPYourDigiShowroomAllHeader().getText());
				
				//Click on Your Digital Showroom Dropdown
				yd.getEXPYourDigiShowroom().click();
				System.out.println("Your Digital Showroom");
				//Click on Lines
				yd.getEXPlines().click();
				System.out.println("Lines");
				//verify Lines page
				Assert.assertTrue(yd.getEXPYourDigiShowroomAllHeader().getText().contains("Managing Your Manufacturing Lines"));
				
				//Click on Your Digital Showroom Dropdown
				yd.getEXPYourDigiShowroom().click();
				System.out.println("Your Digital Showroom");
				//Click on Product
				yd.getEXPProduct().click();
				System.out.println("Produt");
				//verify Product page
				Assert.assertTrue(yd.getEXPYourDigiShowroomAllHeader().getText().contains("Products"));
	
				//Click on Your Digital Showroom Dropdown
				yd.getEXPYourDigiShowroom().click();;
				System.out.println("Your Digital Showroom");
				//Click on Catalog Flipbook
				yd.getEXPCatalogFlipbooks().click();
				System.out.println("Catalog Flipbook");
				//verify Catalog page
				Assert.assertTrue(yd.getEXPYourDigiShowroomAllHeader().getText().contains("Catalogs"));
				
				//Click on Your Digital Showroom Dropdown
				yd.getEXPYourDigiShowroom().click();
				System.out.println("Your Digital Showroom");
				//Click on JuniperData Link
				// Store the current window handle
				String winHandleBefore = driver.getWindowHandle();
				yd.getEXPJuniperData().click();		
				// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
				Assert.assertTrue(yd.getEXPJuniperDataHeader().isDisplayed());
				// Close the new window, if that window no more required
				driver.close();
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore);
			
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
				

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println("EXP page");
			
				
				//Click on Applications And Leases Tab 
				al.getEXPApplicationsAndLeasesTab().click();
				System.out.println("Applications And Leases Tab ");
				//Click on Atlanta Permenat Space
				al.getEXPAtlantaPermanentSpace().click();
				System.out.println("Atlanta Permenat Space");
				//Verify Atlanta Permanent Space page
				Assert.assertTrue(al.getEXPAtlantaPermanentSpaceHeader().getText().contains("Apply for Permanent Showroom Space at AmericasMart"));
				
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
				Assert.assertTrue(rs.getExpPortalHeader().getText().contains("Sign"));
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
				Assert.assertTrue(rs.getExpPortalHeader().getText().contains("Sign"));
				driver.close();
				driver.switchTo().window(winHandleBefore1);
				
				
				System.out.println("Applications And Leases Tab ");
				System.out.println("Atlanta Payment ");
				//String winHandleBefore2 = driver.getWindowHandle();
				al.getEXPAtlantaPayments().click();		
				//Click on Exhibitor Portal Login' sub-menu
				
				// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
				
				//Verify that 'EXP Login' page should be displayed
				Assert.assertTrue(rs.getExpPortalHeader().getText().contains("Sign"));
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
				al.getEXPLasVegasPermanentSpace().click();		
				//Click on Exhibitor Portal Login' sub-menu
				// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
				//Verify that 'EXP Login' page should be displayed
				Thread.sleep(5000);
				Assert.assertTrue(rs.getExpPermSpaceHeader().getText().contains("Leasing Contact Form"));
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
				Assert.assertTrue(rs.getExpGiftTradeshowHeader().getText().contains("Gift"));
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
				Assert.assertTrue(rs.getExpFurniTradeshowHeader().getText().contains("Furnishings "));
				// Close the new window, if that window no more required
				driver.close();
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore5);
			
	}

	@Test(priority=06)
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
				

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println("EXP page");
			
				
				//Click on Registration And Services Tab 
				rs.getEXPRegAndServicesTab().click();
				System.out.println("Registration And Services Tab ");
				//Exhibitor Registration
				rs.getEXPExhibitorReg().click();
				System.out.println("Exhibitor Registration ");
				//Verify Exhibitor Registration Page Header
				Assert.assertTrue(rs.getEXPExhibitorRegHeader().getText().contains("Market Registrations"));
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
				Assert.assertTrue(rs.getExpPortalHeader().getText().contains("Sign"));
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
				Assert.assertTrue(rs.getExpPortalHeader().getText().contains("Sign"));
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
				Assert.assertTrue(rs.getExpPortalHeader().getText().contains("Sign"));
				// Close the new window, if that window no more required
				driver.close();
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore3);
				
				System.out.println("Registration And Services Tab ");
				//Click on Atlanta Paymet
				System.out.println("AmericasMart Logistics | Exhibitor Toolkit");
			
				
	}
	
	@Test(priority=07)
	public void TS005_VerifyAllLinkUnderEXPMarketTabTest() throws InterruptedException, IOException
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
				

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println("EXP page");
				//Click on Registration And Services Tab 
				mar.getEXPMarketTab().click();
				System.out.println("Market Tab ");
				//Exhibitor Registration
				mar.getEXPManageYourMarket().click();
				System.out.println("Manage Your Market  ");
				//Verify Exhibitor Registration Page Header
				Assert.assertTrue(mar.getEXPManageMarketHeader().getText().contains("Manage Your Markets"));
				System.out.println("Verify Exhibitor Registration Page");
				
				
				mar.getEXPMarketTab().click();
				System.out.println("Market Tab ");
				
				//Click on Exhibitor Resources
				System.out.println("Exhibitor Resources");
				mar.getEXPExhibitorResources().click();
				System.out.println("Verify Exhibitor Resources");
				Assert.assertTrue(mar.getEXPExhibitorResourcesHeader().getText().contains("Exhibitor Resources"));
				
				
				mar.getEXPMarketTab().click();
				System.out.println("Market Tab ");
				
				//Click on Exhibitor Resources
				System.out.println("Market");
				mar.getEXPMarket().click();
				System.out.println("Verify Market");
				Assert.assertTrue(mar.getEXPMarketHeader().getText().contains("Manage"));				
	System.out.println("End");
	}

}