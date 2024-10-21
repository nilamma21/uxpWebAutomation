package PROD;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.reactivex.rxjava3.functions.Action;
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
public class LVMSmoke_PROD extends base {

	
	public WebDriverWait wait;
	public GenerateData genData;
	public Utility utl;
	UXPLandingPage lap;
	UXPLoginPage lp;
	UXPExhibitPage exh;
	UXPExhibitorsAndProductsTabPage exhp;
	UXPProfileAndSettingsPage ps;
	UXPMarketInfoPage mi;
	UXPExploreMarketPage expmrkt;
	UXPGlobalSearchPage gs;
	UXPFooterLinksNavigationPage fl;
	UXPExhibitorDirectoryPage ed;
	UXPAttendPage at;
	UXPYearRoundPage yr;
	UXPHeaderChannelLinksPage hd;
	SendEmail se;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		lap.getIUnderstandBtn().click();
     
		Thread.sleep(2000);
		utl.verifyCloseBtnPopup();
		
/*		driver.get(prop.getProperty("lvmurl"));
		lap.getIUnderstandBtn().click();
		Thread.sleep(3000);
		utl.verifyCloseBtnPopup();*/
	}
	@Test(priority=1)
	public void TS001_LVM_VerifyHeaderChannelLinksTest() throws InterruptedException, IOException
	{

		// The purpose of this test case to verify:-
		// UXP-: To verify header channel links
		hd = new UXPHeaderChannelLinksPage(driver);
		exh = new UXPExhibitPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Verify that Atlanta link is present
		Assert.assertTrue(hd.getAtlanta().getText().equalsIgnoreCase("ATLANTA"));
		
		
		  //Check Atlanta Apparel 
		hd.getAtlanta().click(); 
		Thread.sleep(2000);
		  Assert.assertTrue(hd.getAtlantaApparel().getText().
		  equalsIgnoreCase("Atlanta Apparel")); hd.getAtlantaApparel().click();
		  Assert.assertTrue(driver.getTitle().contains("Atlanta Apparel"));
		  driver.get(prop.getProperty("lvmurl")); Thread.sleep(2000);
		  
		  //Check Casual Market Atlanta //Check Casual Market Atlanta
		  hd.getAtlanta().click(); 
		  Thread.sleep(1000);
		  Assert.assertTrue(hd.getCasualMarketAtlanta().getText().
		  equalsIgnoreCase("Fall Cash & Carry")); hd.getCasualMarketAtlanta().click();
		  Thread.sleep(2000); 
		  String bredcumName=exh.getExhibitOpprBrdcrumb().getText();
		  Assert.assertTrue(bredcumName.contains("Fall Cash & Carry"));
		  
		  driver.get(prop.getProperty("lvmurl")); 
		  Thread.sleep(2000);
		  
		  //Check Atlanta Market 
		  hd.getAtlanta().click(); 
		  Thread.sleep(2000);
		  Assert.assertTrue(hd.getAtlantaMarket().getText().equalsIgnoreCase("Atlanta Market")); 
		  hd.getAtlantaMarket().click();
		  Assert.assertTrue(driver.getTitle().contains("Atlanta Market"));
		  driver.get(prop.getProperty("lvmurl")); 
		  Thread.sleep(2000);
		  
		  //Check Formal Markets 
		  hd.getAtlanta().click(); 
		  Thread.sleep(2000);
		  Assert.assertTrue(hd.getFormalMarkets().getText().equalsIgnoreCase("Formal Markets")); 
		  hd.getFormalMarkets().click();
		  Assert.assertTrue(driver.getTitle().contains("Formal Markets"));
		  driver.get(prop.getProperty("lvmurl")); 
		  Thread.sleep(2000);
		 
		
		// Check Mid-Season Buying Event: Fall Market hd.getAtlanta().click();
		/*
		 * Thread.sleep(2000);
		 * Assert.assertTrue(hd.getMidSeasonBuyingEventFallMarket().getText().
		 * equalsIgnoreCase("Mid-Season Buying Event: Fall Market"));
		 * hd.getMidSeasonBuyingEventFallMarket().click();
		 * Assert.assertTrue(driver.getTitle().contains("Fall Market at AmericasMart"));
		 * driver.get(prop.getProperty("lvmurl")); Thread.sleep(2000);
		 */
		hd.getAtlanta().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getCasualMarketAtlantaURL().getText().equalsIgnoreCase("Casual Market Atlanta"));
		hd.getCasualMarketAtlantaURL().click();
		Assert.assertTrue(driver.getTitle().contains("Casual Market Atlanta"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);

		/*
		 * hd.getAtlanta().click(); 
		 * Thread.sleep(2000); 
		 * try {
		 * Assert.assertTrue(hd.getCashAndCarryMarketsSpringandFall().getText().
		 * equalsIgnoreCase("Cash & Carry Markets: Spring and Fall"));
		 * hd.getCashAndCarryMarketsSpringandFall().click();
		 * Assert.assertTrue(driver.getTitle().contains("Spring Cash & Carry"));
		 * driver.get(prop.getProperty("lvmurl")); 
		 * Thread.sleep(2000); 
		 * }catch (Exception
		 * e) 
		 * { Assert.assertTrue(hd.getFllCashAndCarryMarketsSpringandFall().getText().
		 * equalsIgnoreCase("Fall Cash & Carry"));
		 * hd.getFllCashAndCarryMarketsSpringandFall().click();
		 * Assert.assertTrue(driver.getTitle().contains("Fall Cash & Carry"));
		 * driver.get(prop.getProperty("lvmurl")); 
		 * Thread.sleep(2000); }
		 */
		
		//Check ADAC
		hd.getAtlanta().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getADAC().getText().equalsIgnoreCase("ADAC"));
		hd.getADAC().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("ADAC"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Check AmericasMart
		hd.getAtlanta().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getAmericasMart().getText().equalsIgnoreCase("AmericasMart"));
		hd.getAmericasMart().click();
		Assert.assertTrue(driver.getTitle().contains("Wholesale Gift, Home, Rug and Apparel Markets"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Check Atlanta Convention Center
		hd.getAtlanta().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getAtlantaConventionCenter().getText().equalsIgnoreCase("Atlanta Convention Center"));
		hd.getAtlantaConventionCenter().click();
		Assert.assertTrue(driver.getTitle().contains("Atlanta Convention Center"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Verify that Las Vegas link is present
		Assert.assertTrue(hd.getLasVegas().getText().equalsIgnoreCase("LAS VEGAS"));
		
		//Check Las Vegas Market
		hd.getLasVegas().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getLasVegasMarket().getText().equalsIgnoreCase("Las Vegas Market"));
		hd.getLasVegasMarket().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Market"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Check Formal Markets
		hd.getLasVegas().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getFormalMarkets().getText().equalsIgnoreCase("Formal Markets"));
		hd.getFormalMarkets().click();
		Assert.assertTrue(driver.getTitle().contains("Formal Markets"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Check Las Vegas Apparel
		hd.getLasVegas().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getLasVegasApparel().getText().equalsIgnoreCase("Las Vegas Apparel"));
		hd.getLasVegasApparel().click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Apparel"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Check Las Vegas Design Center (LVDC)
		hd.getLasVegas().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getLasVegasDesignCenter().getText().equalsIgnoreCase("Las Vegas Design Center (LVDC)"));
		hd.getLasVegasDesignCenter().click();
		Assert.assertTrue(driver.getTitle().contains("Las Vegas Design Center"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
	
		//Check EXPO at World Market Center Las Vegas
		hd.getLasVegas().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getEXPOatWorldMarketCenterLasVegas().getText().equalsIgnoreCase("EXPO at World Market Center Las Vegas"));
		hd.getEXPOatWorldMarketCenterLasVegas().click();
		Assert.assertTrue(driver.getTitle().contains("The Expo At World Market Center"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Verify that High Point link is present
		Assert.assertTrue(hd.getHighPoint().getText().equalsIgnoreCase("HIGH POINT"));
		
		//Check ANDMORE at High Point Market
		hd.getHighPoint().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getANDMOREatHighPointMarket().getText().equalsIgnoreCase("ANDMORE at High Point Market"));
		hd.getANDMOREatHighPointMarket().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getCurrentUrl().contains("andmorehighpointmarket.com"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Check SHOPPE OBJECT High Point
		hd.getHighPoint().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getSHOPPEOBJECTHighPoint().getText().equalsIgnoreCase("SHOPPE OBJECT High Point"));
		hd.getSHOPPEOBJECTHighPoint().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("High Point Market | Shoppe Object - High Point"));
		driver.get(prop.getProperty("lvmurl"));
		Thread.sleep(2000);
		
		//Verify that New York link is present
		Assert.assertTrue(hd.getNewYork().getText().equalsIgnoreCase("NEW YORK"));
		
		//Check SHOPPE OBJECT
		hd.getNewYork().click();
		Thread.sleep(2000);
		Assert.assertTrue(hd.getSHOPPEOBJECT().getText().equalsIgnoreCase("SHOPPE OBJECT"));
		hd.getSHOPPEOBJECT().click();
		Assert.assertTrue(driver.getTitle().contains("Shoppe Object"));
		//driver.get(prop.getProperty("atlmrkturl"));
		Thread.sleep(2000);

	
	}
	@Test(priority=02)
	public void TS002_LVM_VerifAllLinksUnderExhibitorDirectoryTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-002: To verify the Exhibitor Directory TAB overview and it's functionality
		hd = new UXPHeaderChannelLinksPage(driver);
		lap = new UXPLandingPage(driver);
		exh = new UXPExhibitPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		  driver.get(prop.getProperty("lvmurl"));
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  Thread.sleep(3000);
		 
		//hd.getAtlanta().click();
		//Click on Exhibitor Directory tab
		
		System.out.println(exh.getexhibittabNew().getText());
		Thread.sleep(2000);
		exh.getexhibittabNew().click();
		
		//Click on Exhibitor Directory under Exhibitor Directory tab
		
		exh.getExhibitorDirectoryUnderExhibitorDirectoryTab().click();
		
	}
	
	
	@Test(priority=02)
	public void TS002_LVM_VerifAllLinksUnderExhibitTabTest() throws InterruptedException, IOException
	{
		//The purpose of this test case to verify:-
		//UXP-002: To verify the Exhibit menu overview and it's functionality

		lap = new UXPLandingPage(driver);
		exh = new UXPExhibitPage(driver);
		exhp = new UXPExhibitorsAndProductsTabPage(driver);

		driver.get(prop.getProperty("lvmurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));			
		Thread.sleep(3000);

		exh.getexhibittabNew().isDisplayed();
		//Click on Exhibit tab
		exh.getexhibittabNew().click();
	}
}
