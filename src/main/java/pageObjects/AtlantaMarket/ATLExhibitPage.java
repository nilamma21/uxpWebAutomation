package pageObjects.AtlantaMarket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLExhibitPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	By atlexhibittab = By.xpath("(//div[@class='imc-breakpoint-display--hide-tablet']/descendant::span[contains(text(),'Exhibit')]/../..)[2]"); //Locator for Exhibit tab
	By atlexhibitatatlanta = By.xpath("(//a[contains(@href,'/Exhibit')])[position()=1]"); //Locator for Exhibitor at Atlanta Market sub-menu
	By atlwhyexhibitmenu = By.xpath("//a[contains(text(),'Why Exhibit?')]"); //Locator for Why Exhibit sub-menu
	By atlapplytoexhibit = By.xpath("//a[@href='/Exhibit/Apply-to-Exhibit']"); //Locator for Exhibitor at Atlanta Market sub-menu
	By atlexhibitorregtn = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Exhibitor Registration')]"); //Locator for Exhibitor Registration sub-menu
	By atlexplogin = By.xpath("//a[contains(text(),'Exhibitor Portal Login')]"); //Locator for Exhibitor Portal Login sub-menu
	By atljunipersubmenu = By.xpath("(//a[contains(text(),'Juniper')])[position()=2]"); //Locator for Juniper sub-menu
	By atlexhibitbrdcrumb = By.xpath("//ul[@class='imc-breadcrumb']/li[2]/a"); //Locator for Exhibit Breadcrumb menu
	By atlexploginpagetitle = By.xpath("//h2[contains(text(),'Sign in with your existing account')]"); //Locator for Exhibitor Portals Login page title
	By atlexhibitorresources = By.xpath("//a[@href='/Exhibit/Resources' and contains(text(),'Exhibitor Resources')]"); // Locator for Exhibitor Resources option in Exhibit menu
	By atlapplytoexhibitbrdcrmb = By.xpath("//ul[@class='imc-breadcrumb']/li[3]/a"); //Locator for Apply to Exhibit breadcrumb
	By atlexhregstnbrdcrmb = By.xpath("//ul[@class='imc-breadcrumb']/li[4]/a"); //Locator for Exhibitor Registration breadcrumb
	By atlexhresourcesbrdcrumb = By.xpath("//ul[@class='imc-breadcrumb']/li[3]/a"); //Locator for Exhibitor Respources breadcrumb
	By buyerFactSheet = By.xpath("//a[@href='/Exhibit/Buyer-Fact-Sheet']");
	By AdvertisingAndSponsorship = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Advertising & Sponsorship')]");
	By ShowDates = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Show Dates')]");
	By ExhibitWithUs = By.xpath("//a[@href='/Exhibit/Atlanta-Apparel' and contains(text(),'Exhibit With Us')]");
	By ExhibitAtAtlantaApparel = By.xpath("//a[@href='/Exhibit/Atlanta-Apparel' and contains(text(),'Exhibit at Atlanta Apparel')]");
	By ExhibitInSocialOccasion = By.xpath("//a[@href='/Exhibit/Social-Occasion' and contains(text(),'Exhibit in Social Occasion')]");
	By AlreadyAnExhibitor = By.xpath("//a[contains(text(),'Already an Exhibitor')]");
	
	public ATLExhibitPage(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getATLExhibitTab() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibittab));
		return driver.findElement(atlexhibittab);		
	}
	
	public WebElement getATLWhyExhibitMenu() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlwhyexhibitmenu));
		return driver.findElement(atlwhyexhibitmenu);		
	}
	public WebElement getATLExhibitorRegtnMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitorregtn));
		return driver.findElement(atlexhibitorregtn);		
	}
	public WebElement getATLExhibitorPortalLoginMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexplogin));
		return driver.findElement(atlexplogin);		
	}
	public WebElement getATLJuniperMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atljunipersubmenu));
		return driver.findElement(atljunipersubmenu);		
	}
	
	public WebElement getATLExhibitBrdcrumb() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitbrdcrumb));
		return driver.findElement(atlexhibitbrdcrumb);		
	}

	public WebElement getATLEXPLoginPageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexploginpagetitle));
		return driver.findElement(atlexploginpagetitle);		
	}

	public WebElement getATLExhibitorResources() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitorresources));
		return driver.findElement(atlexhibitorresources);		
	}
	public WebElement getATLExhibitAtAtlanta() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitatatlanta));
		return driver.findElement(atlexhibitatatlanta);		
	}
	public WebElement getATLApplyToExhibit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlapplytoexhibit));
		return driver.findElement(atlapplytoexhibit);		
	}

	public WebElement getATLApplyToExhibitBrdcrmb() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlapplytoexhibitbrdcrmb));
		return driver.findElement(atlapplytoexhibitbrdcrmb);		
	}
	
	public WebElement getATLExhRegstnBrdcrmb() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhregstnbrdcrmb));
		return driver.findElement(atlexhregstnbrdcrmb);		
	}

	public WebElement getATLExhResourcesBrdcrmb() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhresourcesbrdcrumb));
		return driver.findElement(atlexhresourcesbrdcrumb);		
	}
	public WebElement getbuyerFactSheet() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(buyerFactSheet));
		return driver.findElement(buyerFactSheet);		
	}
	public WebElement getAdvertisingAndSponsorship() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AdvertisingAndSponsorship));
		return driver.findElement(AdvertisingAndSponsorship);
	}
	public WebElement getShowDates() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ShowDates));
		return driver.findElement(ShowDates);
	}
	public WebElement getExhibitWithUs() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ExhibitWithUs));
		return driver.findElement(ExhibitWithUs);
	}
	public WebElement getExhibitAtAtlantaApparel() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ExhibitAtAtlantaApparel));
		return driver.findElement(ExhibitAtAtlantaApparel);
	}
	public WebElement getExhibitInSocialOccasion() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ExhibitInSocialOccasion));
		return driver.findElement(ExhibitInSocialOccasion);
	}
	public WebElement getAlreadyAnExhibitor() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AlreadyAnExhibitor));
		return driver.findElement(AlreadyAnExhibitor);
	}
}


