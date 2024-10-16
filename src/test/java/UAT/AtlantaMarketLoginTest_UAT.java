package UAT;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		lap.getLogin().click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		lp.getEmailAddress().sendKeys(prop.getProperty("username"));
		lp.getPassword().sendKeys(prop.getProperty("password"));
		lp.getSignInBtn().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		
		
	}
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
	
}
