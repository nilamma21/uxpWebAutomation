package pageObjects.LasVegasMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPExhibitPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	By exhibittab = By.xpath("(//a[contains(text(),'Exhibit')])[2]"); //Locator for Exhibit tab
	By whyexhibitmenu = By.xpath("//a[contains(text(),'Why Exhibit?')]"); //Locator for Why Exhibit sub-menu
	By exhibitoppt = By.xpath("//a[contains(text(),'Exhibit Opportunities')]"); //Locator for Exhibit Opportunities sub-menu
	By advnspnrshp = By.xpath("//a[contains(text(),'Advertising & Sponsorships')]"); //Locator for Advertising & Sponsorships sub-menu
	By tipsforexhibitors = By.xpath("//a[contains(text(),'Tips for Exhibitors')]"); //Locator for Tips for exhibitors sub-menu
	By exhibitorregtn = By.xpath("//a[contains(text(),'Exhibitor Registration')]"); //Locator for Exhibitor Registration sub-menu
	By explogin = By.xpath("//a[contains(text(),'Exhibitor Portal Login')]"); //Locator for Exhibitor Portal Login sub-menu
	By junipersubmenu = By.xpath("//a[contains(text(),'Juniper')]"); //Locator for Juniper sub-menu
	By advnspnrshptitle = By.xpath("//span[contains(text(),'Advertising and Sponsorship Opportunities')]"); //Locator for Advertising & Sponsorships page title
	By exhtipstitle = By.xpath("//span[contains(text(),'Exhibitor Tips')]"); //Locator Exhibitor tips page title
	
	public UXPExhibitPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	
	public WebElement getExhibitTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(exhibittab));
		return driver.findElement(exhibittab);		
	}
	
	public WebElement getWhyExhibitMenu() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(whyexhibitmenu));
		return driver.findElement(whyexhibitmenu);		
	}
	public WebElement getExhibitOpptMenu() {
		return driver.findElement(exhibitoppt);		
	}
	public WebElement getAdvertisingnSponsershipsMenu() {
		return driver.findElement(advnspnrshp);		
	}
	public WebElement getTipsForExhibitorsMenu() {
		return driver.findElement(tipsforexhibitors);		
	}
	public WebElement getExhibitorRegtnMenu() {
		return driver.findElement(exhibitorregtn);		
	}
	public WebElement getExhibitorPortalLoginMenu() {
		return driver.findElement(explogin);		
	}
	public WebElement getJuniperMenu() {
		return driver.findElement(junipersubmenu);		
	}
	public WebElement getAdvertisingnSponsershipsTitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibittab));
		return driver.findElement(advnspnrshptitle);		
	}
	public WebElement getExhibitorTipsTitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhtipstitle));
		return driver.findElement(exhtipstitle);		
	}
}


