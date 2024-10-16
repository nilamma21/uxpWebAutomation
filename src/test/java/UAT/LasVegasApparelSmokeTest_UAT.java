package UAT;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
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
public class LasVegasApparelSmokeTest_UAT extends base {
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
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
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

}
