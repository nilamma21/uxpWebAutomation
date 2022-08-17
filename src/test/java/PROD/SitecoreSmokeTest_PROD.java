package PROD;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.Sitecore.SitecoreSmokeTestLinks;
import resources.GenerateData;
import resources.Utility;
import resources.base;

@Listeners({TestListeners.class})
public class SitecoreSmokeTest_PROD extends base {
	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	SitecoreSmokeTestLinks sl;

	@BeforeClass
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		//utl = new Utility(driver);

		/*	//Navigate to Sitecore
		driver.manage().window().maximize();
		driver.get(prop.getProperty("sitecoreurl"));*/

	}

	@Test(priority=01)
	public void TS001_VerifySitecoreLoginTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T119: To verify Login functionality works properly

		sl = new SitecoreSmokeTestLinks(driver);
		utl = new Utility(driver);

		//Navigate to Sitecore
		driver.manage().window().maximize();
		driver.get(prop.getProperty("sitecoreurl"));

		sl.getUserName().sendKeys(prop.getProperty("sitecoreusername"));
		sl.getPassword().sendKeys(prop.getProperty("sitecorepassword"));
		sl.getLoginbtn().click();
		
		//Temp solution for login issue
		driver.get(prop.getProperty("sitecoreurl"));
		Assert.assertTrue(sl.getVerifyHomePage().isDisplayed());
		System.out.println("Login Successful.");
	}

	@Test(priority=05)
	public void TS002_VerifyContentEditorTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T121: To verify Content Editor page opens properly

		sl = new SitecoreSmokeTestLinks(driver);

		sl.getContentEditor().click();
		Assert.assertTrue(sl.getVerifyContentEditor().getText().contains("Content"));
		System.out.println("Content Editor opened successfully.");

	}

	@Test(priority=03)
	public void TS003_VerifyDigitalAdminPanelTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T122: To verify Digital Admin Panel page opens properly

		sl = new SitecoreSmokeTestLinks(driver);

		sl.getVerifyHomePage().click();
		sl.getDigitalAdminPanel().click();
		Assert.assertTrue(sl.getVerifyDigitalAdminPanel().getText().contains("Digital Admin Panel"));
		System.out.println("Digital Admin Panel opened successfully.");

	}

	@Test(priority=02)
	public void TS004_VerifyShowSpecialApprovalsTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T124: To verify Show Special Approvals page opens properly

		sl = new SitecoreSmokeTestLinks(driver);

		sl.getVerifyHomePage().click();
		sl.getShowSpecialApprovals().click();
		Assert.assertTrue(sl.getVerifyDigitalAdminPanel().getText().contains("Show Specials Approvals"));
		System.out.println("Show Special Approvals opened successfully.");

	}

	@Test(priority=04)
	public void TS005_VerifyExhibitorEventsApprovalTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T123: To verify Exhibitor Events Approval page opens properly

		sl = new SitecoreSmokeTestLinks(driver);

		sl.getVerifyHomePage().click();
		sl.getExhibitorEventsApproval().click();
		Assert.assertTrue(sl.getVerifyDigitalAdminPanel().getText().contains("Exhibitor Events Approvals"));
		System.out.println("Exhibitor Events Approval opened successfully.");

	}

	@Test(priority=06)
	public void TS006_VerifyIMCReportsTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T125: To verify IMC Reports page opens properly

		sl = new SitecoreSmokeTestLinks(driver);

		sl.getVerifyHomePage().click();
		sl.getIMCReports().click();
		Assert.assertTrue(sl.getVerifyDigitalAdminPanel().getText().contains("IMC Reports Panel"));
		System.out.println("IMC Reports opened successfully.");

	}

	@Test(priority=07)
	public void TS007_VerifyTaxonomyManagerTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T121: To verify Taxonomy Manager page opens properly

		sl = new SitecoreSmokeTestLinks(driver);

		sl.getVerifyHomePage().click();
		sl.getTaxonomyManager().click();
		Assert.assertTrue(sl.getVerifyDigitalAdminPanel().getText().contains("Taxonomy Manager"));
		System.out.println("Taxonomy Manager opened successfully.");

	}

	@Test(priority=8)
	public void TS008_VerifyEmailExperienceManagerTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T121: To verify Email Experience Manager page opens properly

		sl = new SitecoreSmokeTestLinks(driver);

		sl.getVerifyHomePage().click();
		sl.getEmailExperienceManager().click();
		Assert.assertTrue(sl.getVerifyDigitalAdminPanel().getText().contains("Email Experience Manager"));
		System.out.println("Email Experience Manager opened successfully.");

	}

	@Test(priority=9)
	public void TS009_VerifyControlPanelTest() throws InterruptedException, IOException
	{

		//The purpose of this test case to verify:-
		//UXP-T128: To verify Control Panel page opens properly

		sl = new SitecoreSmokeTestLinks(driver);

		sl.getVerifyHomePage().click();
		sl.getControlPanel().click();
		Assert.assertTrue(sl.getVerifyDigitalAdminPanel().getText().contains("Control Panel"));
		System.out.println("Control Panel opened successfully.");
		//sl.getVerifyHomePage().click();
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
