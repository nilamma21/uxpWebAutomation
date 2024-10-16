package pageObjects.AtlantaMarket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLMarketInfoPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlmarketinfoheader = By.xpath("//div[@class ='imc-section']/div[1]/div[1]/div[1]/a[1]"); //Locator for Market Info tab in header
	By atlaboutsubmenu = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[1]/div[1]/a[1]"); // Locator for About option in Market Info
	By atldatesandhrssubmenu = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[2]/div[1]/a[1]"); // Locator for Dates and Hours sub-menu
	By atlregistrationsubmenu = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']//descendant::a[contains(text(),'Registration')]"); // Locator for Registration sub-menu
	By atlpresscentersubmenu = By.xpath("(//a[contains(@href, '/Market-Info/Press-Center')])[position()=1]"); //Locator for Press Center sub-menu
	By atlantanextsubmenu = By.xpath("//a[contains(@href, '/News-and-Trends/Atlanta-Next')]"); //Locator for Press Center sub-menu
	By atlvideogallerysubmenu = By.xpath("//a[contains(text(),'Video Gallery')]"); //Locator for Video Gallery sub-menu
	By atlindustrypartsubmenu = By.xpath("//a[contains(@href, '/Market-Info/Industry-Partners')]"); //Locator for Industry Partners
	By atlaboutpageheader = By.xpath("//strong[contains(text(), 'ABOUT')]"); //Locator for About us page header
	By atlmektdatespageheader = By.xpath("//*[contains(text(), 'MARKET DATES & HOURS')]"); //Locator for Market Dates & Hours page header
	By atlregstnpageheader = By.xpath("//a[contains(text(), 'Registration')]"); //Locator for Registration page header
	By atlpresscenterpageheader = By.xpath("//a[contains(text(), 'Press Releases')]");//Locator for Press Center page header
	By atlatlantanextpageheader = By.xpath("(//a[contains(text(), 'Atlanta Next')])[position()=1]"); //Locator for Atlanta Next page header
	By atlvideogallerypageheader = By.xpath("//strong[contains(text(), 'VIDEO')]");//Locator for Video Gallery page header
	By atlinduspartpageheader = By.xpath("//a[contains(text(), 'Industry Partners')]"); //Locator for Industry Partners page header
	By ATLMarket101 = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']//descendant::a[contains(text(),'Market 101')]");
	By ATLFloorPlan = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']//descendant::a[contains(text(),'Floor Plans')]");
	By ATLGettingToMarket = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']//descendant::a[contains(text(),'Getting to Market')]");
	By ATLIndustryPartners = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']//descendant::a[contains(text(),'Industry Partners')]");
	By ATLGettingToMarketHeader = By.xpath("//strong[contains(text(), 'GETTING TO')]"); //Locator for getting to market page header
	By ATLDownloadOurNewApp = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']//descendant::a[contains(text(),'Download our NEW App!')]");//Locator for Download ourNEW App menu
	By ATLPlanYourMarket = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']//descendant::a[contains(text(),'Plan Your Market')]");
	
	public ATLMarketInfoPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getATLMarketInfoHeader() throws InterruptedException{
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(atlmarketinfoheader));
		return driver.findElement(atlmarketinfoheader);
	}
	
	public WebElement getATLAboutSubMenu(){
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlaboutsubmenu));
		return driver.findElement(atlaboutsubmenu);
	}

	public WebElement getATLDatesAndHrsSubMenu() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atldatesandhrssubmenu));
		return driver.findElement(atldatesandhrssubmenu);
	}
	
	public WebElement getATLRegistrationsSubMenu() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlregistrationsubmenu));
		return driver.findElement(atlregistrationsubmenu);
	}
	public WebElement getATLPressCenterSubMenu() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlpresscentersubmenu));
		return driver.findElement(atlpresscentersubmenu);
	}
	public WebElement getAtlantaNextSubMenu() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlantanextsubmenu));
		return driver.findElement(atlantanextsubmenu);
	}
	public WebElement getATLVideoGallerySubMenu() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlvideogallerysubmenu));
		return driver.findElement(atlvideogallerysubmenu);
	}
	public WebElement getATLIndustryPartSubMenu() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlindustrypartsubmenu));
		return driver.findElement(atlindustrypartsubmenu);
	}
	public WebElement getATLAboutUsPageHeader() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlaboutpageheader));
		return driver.findElement(atlaboutpageheader);
	}
	public WebElement getATLMrketDatesHrsPageHeader() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlmektdatespageheader));
		return driver.findElement(atlmektdatespageheader);
	}
	public WebElement getATLRegstnPageHeader() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlregstnpageheader));
		return driver.findElement(atlregstnpageheader);
	}
	public WebElement getATLPressCenterPageHeader() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlpresscenterpageheader));
		return driver.findElement(atlpresscenterpageheader);
	}
	public WebElement getATLAtlantaNextPageHeader() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlatlantanextpageheader));
		return driver.findElement(atlatlantanextpageheader);
	}
	public WebElement getATLVideoGalleryPageHeader() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlvideogallerypageheader));
		return driver.findElement(atlvideogallerypageheader);
	}
	public WebElement getATLIndusPartPageHeader() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlinduspartpageheader));
		return driver.findElement(atlinduspartpageheader);
	}
    public WebElement getATLMarket101() throws InterruptedException {
      wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.visibilityOfElementLocated(ATLMarket101));
      return driver.findElement(ATLMarket101);
  }
    public WebElement getATLFloorPlan() throws InterruptedException {
      wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.visibilityOfElementLocated(ATLFloorPlan));
      return driver.findElement(ATLFloorPlan);
  }
    public WebElement getATLGettingToMarket() throws InterruptedException {
      wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.visibilityOfElementLocated(ATLGettingToMarket));
      return driver.findElement(ATLGettingToMarket);
  }
    public WebElement getATLIndustryPartners() throws InterruptedException {
      wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.visibilityOfElementLocated(ATLIndustryPartners));
      return driver.findElement(ATLIndustryPartners);
  }
    public WebElement getATLGettingToMarketHeader() throws InterruptedException {
      wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.visibilityOfElementLocated(ATLGettingToMarketHeader));
      return driver.findElement(ATLGettingToMarketHeader);
  }	
	public WebElement getATLDownloadOurNewApp() throws InterruptedException {
	  wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(ATLDownloadOurNewApp));
	  return driver.findElement(ATLDownloadOurNewApp);
  } 
	public WebElement getATLPlanYourMarket() throws InterruptedException {
	  wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(ATLPlanYourMarket));
	  return driver.findElement(ATLPlanYourMarket);
  }
  
}
