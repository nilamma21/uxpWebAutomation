package pageObjects.LasVegasMarket;

import java.time.Duration;

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
	By exhibitbrdcrumb = By.xpath("//ul[@class='imc-breadcrumb']/li[2]/a"); //Locator for Exhibit Breadcrumb menu
	By exhibitopprbrdcrumb = By.xpath("//ul[@class='imc-breadcrumb']/li[3]/a"); //Locator for Exhibit Opportunities menu
	By exploginpagetitle = By.xpath("//h2[contains(text(),'Sign in with your existing account')]"); //Locator for Exhibitor Portals Login page title
	By advnspnshpbrdcrumbuat = By.xpath("//a[contains(text(),'Marketing and Sponsorship Opportunities')]"); //UAT_Locator for Advertising & Sponsorships page title
	By exhibitorresourcesprod = By.xpath("//div[@class = 'imc-section']/div[1]/div[5]/div[2]/div[3]/div[1]/a[1]"); // Locator for Exhibitor Resources option in Exhibit menu
	By applytoexhibit = By.xpath("(//a[contains(text(),'Apply to Exhibit')])[1]");
	
	public UXPExhibitPage(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getExhibitTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(exhibittab));
		return driver.findElement(exhibittab);		
	}
	
	public WebElement getWhyExhibitMenu() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(whyexhibitmenu));
		return driver.findElement(whyexhibitmenu);		
	}
	public WebElement getExhibitOpptMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitoppt));
		return driver.findElement(exhibitoppt);		
	}
	public WebElement getAdvertisingnSponsershipsMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(advnspnrshp));
		return driver.findElement(advnspnrshp);		
	}
	public WebElement getTipsForExhibitorsMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(tipsforexhibitors));
		return driver.findElement(tipsforexhibitors);		
	}
	public WebElement getExhibitorRegtnMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorregtn));
		return driver.findElement(exhibitorregtn);		
	}
	public WebElement getExhibitorPortalLoginMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(explogin));
		return driver.findElement(explogin);		
	}
	public WebElement getJuniperMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(junipersubmenu));
		return driver.findElement(junipersubmenu);		
	}
	public WebElement getAdvertisingnSponsershipsTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(advnspnrshptitle));
		return driver.findElement(advnspnrshptitle);		
	}
	public WebElement getExhibitorTipsTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhtipstitle));
		return driver.findElement(exhtipstitle);		
	}
	public WebElement getExhibitBrdcrumb() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitbrdcrumb));
		return driver.findElement(exhibitbrdcrumb);		
	}
	public WebElement getExhibitOpprBrdcrumb() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitopprbrdcrumb));
		return driver.findElement(exhibitopprbrdcrumb);		
	}
	public WebElement getEXPLoginPageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exploginpagetitle));
		return driver.findElement(exploginpagetitle);		
	}
	public WebElement getAdvSpnsershpBrdcrumbUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(advnspnshpbrdcrumbuat));
		return driver.findElement(advnspnshpbrdcrumbuat);		
	}
	public WebElement getexhibitorresourcesprod() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorresourcesprod));
		return driver.findElement(exhibitorresourcesprod);		
	}
	public WebElement getapplytoexhibit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(applytoexhibit));
		return driver.findElement(applytoexhibit);		
	}

}


