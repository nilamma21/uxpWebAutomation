package pageObjects.LasVegasMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Utility;

public class UXPHeaderChannelLinksPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public Utility utl;

//	By AtlantaMarket = By.xpath("//ul[@class='links-wrap']/li[1]/a[1]"); // Locator for Atlanta Market header link
//	By AtlantaApparel = By.xpath("//ul[@class='links-wrap']/li[2]/a[1]"); // Locator for Atlanta Apparel header link
//	By AmericasMart = By.xpath("//ul[@class='links-wrap']/li[3]/a[1]"); // Locator for Americas Mart header link
//	By HighPoint = By.xpath("(//a[contains(text(),'ANDMORE at High Point Market')])[1]"); // Locator for IMC High Point Market header link
//	By LasVegas = By.xpath("(//a[contains(text(),'Las Vegas Market')])[1]"); // Locator for Las vegas Market header link
	
	//New Channel Links
	By Atlanta = By.xpath("//div[@class='top-nav-campus']/descendant::span[contains(text(),'ATLANTA')]"); // Locator for New Atlanta header link
		By AtlantaApparel = By.xpath("//div[@class='top-nav-dropdown-menu']/descendant::span[contains(text(),'Atlanta Apparel')]"); //Locator For Drop down Atlanta Apparel Link
		By CasualMarketAtlanta = By.xpath("//div[@class='top-nav-dropdown-menu']/descendant::span[contains(text(),'Casual Market Atlanta')]"); //Locator For Drop down Casual Market Atlanta Link
		By AtlantaMarket = By.xpath("//div[@class='top-nav-dropdown-menu']/descendant::span[contains(text(),'Atlanta Market')]"); //Locator For Drop down Atlanta Market Link
		By FormalMarkets = By.xpath("//div[@class='top-nav-dropdown-menu']/descendant::span[contains(text(),'Formal Markets')]"); //Locator For Drop down Formal Markets Link
		By MidSeasonBuyingEventFallMarket = By.xpath("//div[@class='top-nav-dropdown-menu']/descendant::span[contains(text(),'Mid-Season Buying Event: Fall Market')]"); //Locator For Drop down Cash And Carry Markets Spring and Fall Link
		By CashAndCarryMarketsSpringandFall = By.xpath("//div[@class='top-nav-dropdown-menu']/descendant::span[contains(text(),'Cash & Carry Markets: Spring and Fall')]"); //Locator For Drop down Cash And Carry Markets Spring and Fall Link
		By ADAC = By.xpath("//div[@class='top-nav-dropdown-menu']/descendant::span[contains(text(),'ADAC')]"); //Locator For Drop down ADAC Link
		By AmericasMart =  By.xpath("//div[@class='top-nav-dropdown-menu']/descendant::span[contains(text(),'AmericasMart')]"); //Locator For Drop down Americas Mart Link
		By AtlantaConventionCenter = By.xpath("//div[@class='top-nav-dropdown-menu']/descendant::span[contains(text(),'Atlanta Convention Center')]"); //Locator For Drop down Atlanta Convention Center Link
	
	By LasVegas = By.xpath("//div[@class='top-nav-campus']/descendant::span[contains(text(),'LAS VEGAS')]"); // Locator for New Las Vegas header link
		By LasVegasMarket = By.xpath("//div[@class='top-nav-dropdown-menu']/descendant::span[contains(text(),'Las Vegas Market')]"); //Locator For Drop down Las Vegas Market Link
		By LasVegasApparel = By.xpath("//div[@class='top-nav-dropdown-menu']/descendant::span[contains(text(),'Las Vegas Apparel')]"); //Locator For Drop down Las Vegas Apparel Link
		By LasVegasDesignCenter = By.xpath("//div[@class='top-nav-dropdown-menu']/descendant::span[contains(text(),'Las Vegas Design Center (LVDC)')]"); //Locator For Drop down Las Vegas Design Center Link
		By EXPOatWorldMarketCenterLasVegas = By.xpath("//div[@class='top-nav-campus']/descendant::span[contains(text(),'EXPO at World Market Center Las Vegas')]"); //Locator For Drop down EXPO at World Market Center Las Vegas Link
		
	By HighPoint = By.xpath("//div[@class='top-nav-campus']/descendant::span[contains(text(),'HIGH POINT')]"); // Locator for New High Point header link
		By ANDMOREatHighPointMarket = By.xpath("//div[@class='top-nav-campus']/descendant::span[contains(text(),'ANDMORE at High Point Market')]"); //Locator For Drop down ANDMORE at High Point Market Link
		By SHOPPEOBJECTHighPoint  = By.xpath("//div[@class='top-nav-campus']/descendant::span[contains(text(),'SHOPPE OBJECT High Point')]"); //Locator For Drop down SHOPPE OBJECT High Point Link
		
	By NewYork = By.xpath("//div[@class='top-nav-campus']/descendant::span[contains(text(),'NEW YORK')]"); // Locator for New York header link
		By SHOPPEOBJECT = By.xpath("//div[@class='top-nav-campus']/descendant::span[contains(text(),'SHOPPE OBJECT')]");  //Locator For Drop down SHOPPE OBJECT Link
		
		By CasualMarketAtlantaURL = By.xpath("//div[@class='top-nav-dropdown-menu']/descendant::span[contains(text(),'Casual Market Atlanta')]/../../.."); //Locator For Drop down Casual Market Atlanta Link		
		By FllCashAndCarryMarketsSpringandFall = By.xpath("//div[@class='top-nav-dropdown-menu']/descendant::span[contains(text(),'Fall Cash & Carry')]"); //Locator For Drop down Cash And Carry Markets Spring and Fall Link
		
		
	public UXPHeaderChannelLinksPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	// For Atlanta
	public WebElement getFllCashAndCarryMarketsSpringandFall() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FllCashAndCarryMarketsSpringandFall));
		return driver.findElement(FllCashAndCarryMarketsSpringandFall);
	}
	
	// For Atlanta
	public WebElement getCasualMarketAtlantaURL() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CasualMarketAtlantaURL));
		return driver.findElement(CasualMarketAtlantaURL);
	}
	
	
	public WebElement getAtlanta() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Atlanta));
		return driver.findElement(Atlanta);
	}
	
	public WebElement getAtlantaApparel() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AtlantaApparel));
		return driver.findElement(AtlantaApparel);
	}
	
	public WebElement getCasualMarketAtlanta() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CasualMarketAtlanta));
		return driver.findElement(CasualMarketAtlanta);
	}
	
	public WebElement getAtlantaMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AtlantaMarket));
		return driver.findElement(AtlantaMarket);
	}
	
	public WebElement getFormalMarkets() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FormalMarkets));
		return driver.findElement(FormalMarkets);
	}
	
	public WebElement getMidSeasonBuyingEventFallMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(MidSeasonBuyingEventFallMarket));
		return driver.findElement(MidSeasonBuyingEventFallMarket);
	}
	
	public WebElement getCashAndCarryMarketsSpringandFall() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CashAndCarryMarketsSpringandFall));
		return driver.findElement(CashAndCarryMarketsSpringandFall);
	}
	
	public WebElement getADAC() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ADAC));
		return driver.findElement(ADAC);
	}
	
	public WebElement getAmericasMart() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AmericasMart));
		return driver.findElement(AmericasMart);
	}
	
	public WebElement getAtlantaConventionCenter() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AtlantaConventionCenter));
		return driver.findElement(AtlantaConventionCenter);
	}
	
	// For LasVegas
	
	public WebElement getLasVegas() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LasVegas));
		return driver.findElement(LasVegas);
	}
	
	public WebElement getLasVegasMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LasVegasMarket));
		return driver.findElement(LasVegasMarket);
	}
	
	public WebElement getLasVegasApparel() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LasVegasApparel));
		return driver.findElement(LasVegasApparel);
	}
	
	public WebElement getLasVegasDesignCenter() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LasVegasDesignCenter));
		return driver.findElement(LasVegasDesignCenter);
	}
	
	public WebElement getEXPOatWorldMarketCenterLasVegas() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EXPOatWorldMarketCenterLasVegas));
		return driver.findElement(EXPOatWorldMarketCenterLasVegas);
	}
	
	// For High Point
	
	public WebElement getHighPoint() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HighPoint));
		return driver.findElement(HighPoint);
	}
	
	public WebElement getANDMOREatHighPointMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ANDMOREatHighPointMarket));
		return driver.findElement(ANDMOREatHighPointMarket);
	}
	
	public WebElement getSHOPPEOBJECTHighPoint() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SHOPPEOBJECTHighPoint));
		return driver.findElement(SHOPPEOBJECTHighPoint);
	}

	//For New York
	
	public WebElement getNewYork() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(NewYork));
		return driver.findElement(NewYork);
	}
	
	public WebElement getSHOPPEOBJECT() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SHOPPEOBJECT));
		return driver.findElement(SHOPPEOBJECT);
	}

}

