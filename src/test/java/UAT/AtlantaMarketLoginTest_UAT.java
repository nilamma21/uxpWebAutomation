package UAT;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LasVegasMarket.UXPLandingPage;
import pageObjects.LasVegasMarket.UXPLoginPage;
import resources.Utility;
import resources.base;


public class AtlantaMarketLoginTest_UAT extends base {
	public Utility utl;
	UXPLandingPage lap;
	UXPLoginPage lp;
	
	@BeforeTest
	public void driverInitialize() throws IOException {
		driver = initializeDriver(); //requires for Parallel text execution
		utl = new Utility(driver);
		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);
	}
	
	@Test
	public void atlMarketOpen() throws InterruptedException {
		driver.get(prop.getProperty("atlmarketurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		lap.getLogin().click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		lp.getEmailAddress().sendKeys(prop.getProperty("username"));
		lp.getPassword().sendKeys(prop.getProperty("password"));
		lp.getSignInBtn().click();
		Thread.sleep(5000);
		
	}
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
	
}
