package pageObjects.AtlantaMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLExhibitPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	By atlexhibittab = By.xpath("(//a[contains(text(),'Exhibit')])[2]"); //Locator for Exhibit tab
	By atlexhibitatatlanta = By.xpath("(//a[contains(@href,'/Exhibit')])[position()=1]"); //Locator for Exhibitor at Atlanta Market sub-menu
	By atlwhyexhibitmenu = By.xpath("//a[contains(text(),'Why Exhibit?')]"); //Locator for Why Exhibit sub-menu
	By atlapplytoexhibit = By.xpath("(//a[contains(@href,'/Exhibit')])[position()=3]"); //Locator for Exhibitor at Atlanta Market sub-menu
	By atlexhibitorregtn = By.xpath("//a[contains(text(),'Exhibitor Registration')]"); //Locator for Exhibitor Registration sub-menu
	By atlexplogin = By.xpath("//a[contains(text(),'Exhibitor Portal Login')]"); //Locator for Exhibitor Portal Login sub-menu
	By atljunipersubmenu = By.xpath("(//a[contains(text(),'Juniper')])[position()=2]"); //Locator for Juniper sub-menu
	By atlexhibitbrdcrumb = By.xpath("//ul[@class='imc-breadcrumb']/li[2]/a"); //Locator for Exhibit Breadcrumb menu
	By atlexploginpagetitle = By.xpath("//h2[contains(text(),'Sign in with your existing account')]"); //Locator for Exhibitor Portals Login page title
	By atlexhibitorresources = By.xpath("(//a[contains(@href,'Exhibit/Exhibitor-Resources')])[position()=1]"); // Locator for Exhibitor Resources option in Exhibit menu
	By atlapplytoexhibitbrdcrmb = By.xpath("//ul[@class='imc-breadcrumb']/li[3]/a"); //Locator for Apply to Exhibit breadcrumb
	By atlexhregstnbrdcrmb = By.xpath("//ul[@class='imc-breadcrumb']/li[4]/a"); //Locator for Exhibitor Registration breadcrumb
	By atlexhresourcesbrdcrumb = By.xpath("//ul[@class='imc-breadcrumb']/li[3]/a"); //Locator for Exhibitor Respources breadcrumb
	
	public ATLExhibitPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	
	public WebElement getATLExhibitTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlexhibittab));
		return driver.findElement(atlexhibittab);		
	}
	
	public WebElement getATLWhyExhibitMenu() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlwhyexhibitmenu));
		return driver.findElement(atlwhyexhibitmenu);		
	}
	public WebElement getATLExhibitorRegtnMenu() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitorregtn));
		return driver.findElement(atlexhibitorregtn);		
	}
	public WebElement getATLExhibitorPortalLoginMenu() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexplogin));
		return driver.findElement(atlexplogin);		
	}
	public WebElement getATLJuniperMenu() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atljunipersubmenu));
		return driver.findElement(atljunipersubmenu);		
	}
	
	public WebElement getATLExhibitBrdcrumb() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(atlexhibitbrdcrumb);		
	}

	public WebElement getATLEXPLoginPageTitle() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexploginpagetitle));
		return driver.findElement(atlexploginpagetitle);		
	}

	public WebElement getATLExhibitorResources() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitorresources));
		return driver.findElement(atlexhibitorresources);		
	}
	public WebElement getATLExhibitAtAtlanta() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitatatlanta));
		return driver.findElement(atlexhibitatatlanta);		
	}
	public WebElement getATLApplyToExhibit() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlapplytoexhibit));
		return driver.findElement(atlapplytoexhibit);		
	}

	public WebElement getATLApplyToExhibitBrdcrmb() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(atlapplytoexhibitbrdcrmb);		
	}
	
	public WebElement getATLExhRegstnBrdcrmb() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(atlexhregstnbrdcrmb);		
	}

	public WebElement getATLExhResourcesBrdcrmb() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(atlexhresourcesbrdcrumb);		
	}
	
	
	

}


