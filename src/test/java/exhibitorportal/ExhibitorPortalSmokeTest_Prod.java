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
public class ExhibitorPortalSmokeTest_Prod extends base {
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
				nt = new EXPNotificationsTabPage(driver);
				
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
				Assert.assertTrue(nt.getVeirfyNotifications().getText().contains("Users"));
				System.out.println("Manage Users page is displayed properly.");
				st.getSettings().click();
				
				//Click Corporate Info icon and verify results
				
				st.getCorporateInfo().click();
				Assert.assertEquals(nt.getVeirfyNotifications().getText(), "Corporate Info");
				System.out.println("Corporate Info page is displayed properly.");
				
				
				//Click Contact Customer Support icon and verify results
				
				/*driver.get(prop.getProperty("setcussupurl"));
				Assert.assertTrue(st.getVerifyEXPGuide().isDisplayed());
				System.out.println("Customer Support page opened successfully.");
				driver.get(prop.getProperty("expurl"));//Code commented as captcha appears for Customer Support link
				*/
				
				
				
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
				nt = new EXPNotificationsTabPage(driver);
				el=new EXPLoginPage(driver);
				

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println("EXP page");
			
				
				//Click on Your Digital Showroom Dropdown
				yd.getEXPYourDigiShowroom().click();
				Assert.assertTrue(st.getVerifySettings().isDisplayed());
				System.out.println("Digital Showroom section is displayed properly.");
				//Click on Profile Info
				yd.getEXPProfileInfo().click();
				
				//verify profile info page
				Assert.assertTrue(nt.getVeirfyNotifications().getText().contains("Global"));
				System.out.println("Profile Info page is displayed properly.");
				//System.out.println(yd.getEXPYourDigiShowroomAllHeader().getText());
				
				//Click on Your Digital Showroom Dropdown
				yd.getEXPYourDigiShowroom().click();
				
				//Click on Lines
				yd.getEXPlines().click();
				
				//verify Lines page
				Assert.assertTrue(nt.getVeirfyNotifications().getText().contains("Managing Your Manufacturing Lines"));
				System.out.println("Lines page is displayed properly.");
				
				//Click on Your Digital Showroom Dropdown
				yd.getEXPYourDigiShowroom().click();
				
				//Click on Product
				yd.getEXPProduct().click();
				
				//verify Product page
				Assert.assertTrue(nt.getVeirfyNotifications().getText().contains("Products"));
				System.out.println("Product page is displayed properly.");
				
				//Click on Your Digital Showroom Dropdown
				yd.getEXPYourDigiShowroom().click();;
				
				//Click on Catalog Flipbook
				yd.getEXPCatalogFlipbooks().click();
				
				//verify Catalog page
				Assert.assertTrue(nt.getVeirfyNotifications().getText().contains("Catalogs"));
				System.out.println("Catalogs page is displayed properly.");
				
				//Click on Your Digital Showroom Dropdown
				yd.getEXPYourDigiShowroom().click();
				
				//Click on JuniperData Link
				// Store the current window handle
				String winHandleBefore = driver.getWindowHandle();
				yd.getEXPJuniperData().click();		
				// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
				Assert.assertTrue(yd.getEXPJuniperDataHeader().isDisplayed());
				System.out.println("Juniper Data site is displayed properly.");
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
							
				
				//Click on Applications And Leases Tab 
				al.getEXPApplicationsAndLeasesTab().click();
				Assert.assertTrue(st.getVerifySettings().isDisplayed());
				System.out.println("Application and Leases section is displayed properly.");
				
				//Click on Atlanta Permenat Space
				yd.getEXPProfileInfo().click();
				
				//Verify Atlanta Permanent Space page
				Assert.assertTrue(nt.getVeirfyNotifications().getText().contains("Apply for Permanent Showroom Space at AmericasMart"));
				System.out.println("Atlanta Permanant space page is displayed properly.");
				al.getEXPApplicationsAndLeasesTab().click();
				
				//Click Apply for Trade show Space
				
				// Store the current window handle
				String winHandleBefore = driver.getWindowHandle();
				al.getEXPAtlantaApplyForTradeshowSpace().click();		
				
				// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
				//Verify that 'EXP Login' page should be displayed
				Assert.assertTrue(driver.getCurrentUrl().contains("https://wem.americasmart.com/"));
				System.out.println("Atlanta Apply for Trade Show page is displayed properly.");
				// Close the new window, if that window no more required
				driver.close();
				// Switch back to original browser (first window)
				
				driver.switchTo().window(winHandleBefore);
				
				//Click on Atlanta Manager Trade show
				
				// Store the current window handle
				String winHandleBefore1 = driver.getWindowHandle();
				al.getEXPAtlantaManageTradeshowSpace().click();		
				//Click on Exhibitor Portal Login' sub-menu
				// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
				//Verify that 'EXP Login' page should be displayed
				Assert.assertTrue(driver.getCurrentUrl().contains("https://wem.americasmart.com/"));
				System.out.println("Atlanta Manage for Trade Show page is displayed properly.");
				driver.close();
				driver.switchTo().window(winHandleBefore1);
				
				
				//String winHandleBefore2 = driver.getWindowHandle();
				yd.getEXPlines().click();	
				//Click on Exhibitor Portal Login' sub-menu
				
				// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
				
				//Verify that 'EXP Login' page should be displayed
				Assert.assertTrue(driver.getCurrentUrl().contains("https://wem.americasmart.com/"));
				System.out.println("Atlanta Payments page is displayed properly.");
				// Close the new window, if that window no more required
				driver.close();
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore1);
				
			
				//Click on Las Vegas Permanent Space
				//al.getEXPApplicationsAndLeasesTab().click();
				//String winHandleBefore3 = driver.getWindowHandle();
				yd.getEXPJuniperData().click();	
				//Click on Exhibitor Portal Login' sub-menu
				// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
				//Verify that 'EXP Login' page should be displayed
				Thread.sleep(5000);
				Assert.assertTrue(rs.getExpPermSpaceHeader().getText().contains("Leasing Contact Form"));
				System.out.println("Leasing Contact Form is displayed properly.");
				// Close the new window, if that window no more required
				driver.close();
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore1);
				
				
				//Click on Las Vegas Gift and Trade show Space
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
				yd=new EXPDigitalShowroomTabPage(driver);
				nt = new EXPNotificationsTabPage(driver);
				

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							
				
				//Click on Registration And Services Tab 
				rs.getEXPRegAndServicesTab().click();
				
				
				//Exhibitor Registration
				yd.getEXPProfileInfo().click();
				
				//Verify Exhibitor Registration Page Header
				Assert.assertTrue(nt.getVeirfyNotifications().getText().contains("Market Registrations"));
				System.out.println("Market Badge Registration page is displayed successfully.");
				rs.getEXPRegAndServicesTab().click();
				
				
				//Click on Atlanta Services
				String winHandleBefore1 = driver.getWindowHandle();
				yd.getEXPlines().click();		
			
				// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
				//Verify that 'EXP Login' page should be displayed
				Assert.assertTrue(driver.getCurrentUrl().contains("https://wem.americasmart.com/"));
				
				driver.close();
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore1);
				
				
				//Click on Atlanta Advertising and services
							
				String winHandleBefore2 = driver.getWindowHandle();
				yd.getEXPProduct().click();		
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
				
				
				//Click on Atlanta Paymet
				String winHandleBefore3 = driver.getWindowHandle();
				yd.getEXPCatalogFlipbooks().click();		
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
				
				
				//Click on Atlanta Paymet
				
				String winHandleBefore4 = driver.getWindowHandle();
				yd.getEXPJuniperData().click();		
				//Click on Exhibitor Portal Login' sub-menu
				// Switch to new window opened
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
				//Verify that 'EXP Login' page should be displayed
				Assert.assertTrue(driver.getCurrentUrl().contains("https://www.expotoolkit.com/"));
				// Close the new window, if that window no more required
				driver.close();
				// Switch back to original browser (first window)
				driver.switchTo().window(winHandleBefore4);
				
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
				yd=new EXPDigitalShowroomTabPage(driver);
				el=new EXPLoginPage(driver);
				mar=new EXPMarketTabPage(driver);
				st = new EXPSettingsPage(driver);
				nt = new EXPNotificationsTabPage(driver);
				

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//Click on Registration And Services Tab 
				mar.getEXPMarketTab().click();
				Assert.assertTrue(st.getVerifySettings().isDisplayed());
				System.out.println("Digital Showroom section is displayed properly.");
				
				//Exhibitor Registration
				yd.getEXPProfileInfo().click();
				
				//Verify Exhibitor Registration Page Header
				Assert.assertTrue(mar.getEXPManageMarketHeader().getText().contains("Manage Your Markets"));
				System.out.println("Manage your markets page opened successfully.");
				mar.getEXPMarketTab().click();
								
				//Click on Exhibitor Resources
				al.getEXPAtlantaApplyForTradeshowSpace().click();			
				Assert.assertTrue(nt.getVeirfyNotifications().getText().contains("Exhibitor Resources"));
				System.out.println("Documents and Resources page opened successfully.");
				
				mar.getEXPMarketTab().click();
				yd.getEXPlines().click();
				Assert.assertTrue(nt.getVeirfyNotifications().getText().contains("Manage"));				
				System.out.println("Manage Market page opened successfully.");
	}

}