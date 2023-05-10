package pageObjects.AtlantaMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLNewsAndTrendsTabPage
{

	public WebDriver driver;
	public WebDriverWait wait;
	

	By atlNewsAndTrendsTap = By.xpath("//div[@class = 'imc-section']/div[1]/div[4]/div[1]/a[1]"); //Locator for News & Trends header tab
	By VerifyNewsSection = By.xpath("//div[@class = 'imc-section']/div[1]/div[4]/div[2]"); //Locator for verification of news and trends section
	By atlNewsAndTrends = By.xpath("//a[contains(text(),'News & Trends')]"); //Locator for News & Trends under header tab
	By atlsewsntrendssubmenu = By.xpath("//div[@class ='imc-section']/div[1]/div[4]/div[2]/div[1]/div[1]/a"); ////Locator for News & Trends sub menu
	By atlNewsAndTrendsPageHeader = By.xpath("(//a[contains(text(),'News & Trends')])[2]"); //Locator for News & Trends page Header
	By atlMarketSnapshot = By.xpath("//a[@href='/News-and-Trends/Market-Snapshot' and contains(text(),'Market Snapshot')]"); //Locator for Market Snapshot
	By atlMarketSnapshotPageHeader = By.xpath("//a[contains(text(),'Market Snapshot')]"); //Locator for Market Snapshot page Header
	By atlWebinarAndEducation=By.xpath("//a[contains(text(),'Webinars & Education')]");////Locator for Webinar & Education page
	By atlWebinarAndEducationHeader=By.xpath("//a[contains(text(),'Webinars & Education')]");////Locator for Webinar & Education page Header
	By atlAheadCurve=By.xpath("//a[@href='/News-and-Trends/Ahead-of-the-Curve' and contains(text(),'Ahead of the Curve')]");////Locator for Ahead of the Curve
	By atlAheadCurvePageHeader=By.xpath("//a[contains(text(),'Ahead of the Curve')]");////Locator for Ahead of the Curve Header
	By atlShopTheShow=By.xpath("//a[@href='/News-and-Trends/Shop-the-Show']");////Locator for Shop the show
	By atlShopTheShowPageHeader=By.xpath("//a[contains(text(),'Shop the ')]");////Locator for Shop the show page header
	By atlPressReleases=By.xpath("(//a[@href='/Market-Info/Press-Center' and contains(text(),'Press Releases')])[1]");////Locator for Press Releases
	By atlPressReleasesHeader=By.xpath("(//a[contains(text(),'Press Releases')])[1]");////Locator for Press Releases header
	By atlPublicationsLibrary=By.xpath("//a[@href='/News-and-Trends/publications']");////Locator for Publications Library
	By atlPublicationsLibraryHeader=By.xpath("//a[contains(text(),'Publications Library')]");//Locator for Publications Library header
	By atlInTheNews=By.xpath("//a[@href='/News-and-Trends/In-the-News']");////Locator for In the News
	By atlInTheNewsHeader=By.xpath("//a[contains(text(),'In the News')]");//Locator for In the News header
	By atlAtlantaNext=By.xpath("//a[@href='/News-and-Trends/Atlanta-Next']");////Locator for Atlanta Next
	By atlAtlantaNextHeader=By.xpath("(//a[contains(text(),'Atlanta Next')])[1]");//Locator for Atlanta Next header
	By atlPortmanPeachtree=By.xpath("(//a[@href='/News-and-Trends/Blog'])[position()=2]");////Locator for Portman Peachtree
	By atlPortmanPeachtreeHeader=By.xpath("//img[@src='https://uat-atlmkt.imcmvdp.com/-/media/Atlanta-Market/Blog/PortmanPeachtree_Logo_wTagline_Horizontal.svg']");//Locator for PortmanPeachtree header
	
	public ATLNewsAndTrendsTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getATLNewsAndTrendsTap() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(atlNewsAndTrendsTap);
	}
	
	public WebElement getATLNewsAndTrends() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlNewsAndTrends));
		return driver.findElement(atlNewsAndTrends);
	}
	
	public WebElement getATLNewsAndTrendsSubmenu() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlsewsntrendssubmenu));
		return driver.findElement(atlsewsntrendssubmenu);
	}
	
	public WebElement getATLNewsAndTrendsPageHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlNewsAndTrendsPageHeader));
		return driver.findElement(atlNewsAndTrendsPageHeader);
	}
	
	public WebElement getATLatlMarketSnapshot() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlMarketSnapshot));
		return driver.findElement(atlMarketSnapshot);
	}
	
	public WebElement getATLMarketSnapshotPageHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlMarketSnapshotPageHeader));
		return driver.findElement(atlMarketSnapshotPageHeader);
	}
	
	public WebElement getATLWebinarAndEducation() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlWebinarAndEducation));
		return driver.findElement(atlWebinarAndEducation);
	}
	public WebElement getATLWebinarAndEducationPageHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlWebinarAndEducationHeader));
		return driver.findElement(atlWebinarAndEducationHeader);
	}
	public WebElement getATLatlAheadCurve() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlAheadCurve));
		return driver.findElement(atlAheadCurve);
	}
	public WebElement getATLAheadCurvePageHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAheadCurvePageHeader));
		return driver.findElement(atlAheadCurvePageHeader);
	}
	public WebElement getATLShopTheShow() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlShopTheShow));
		return driver.findElement(atlShopTheShow);
	}
	public WebElement getATLShopTheShowPageHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlShopTheShowPageHeader));
		return driver.findElement(atlShopTheShowPageHeader);
	}
	public WebElement getATLPressReleases() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlPressReleases));
		return driver.findElement(atlPressReleases);
	}
	public WebElement getATLPressReleasesPageHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlPressReleasesHeader));
		return driver.findElement(atlPressReleasesHeader);
	}
	public WebElement getATLPublicationsLibrary() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlPublicationsLibrary));
		return driver.findElement(atlPublicationsLibrary);
	}
	public WebElement getATLPublicationsLibraryPageHeader() throws InterruptedException {
		Thread.sleep(7000);
//		wait = new WebDriverWait (driver,20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(atlPublicationsLibraryHeader));
		return driver.findElement(atlPublicationsLibraryHeader);
	}
	public WebElement getATLInTheNews() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlInTheNews));
		return driver.findElement(atlInTheNews);
	}
	public WebElement getATLInTheNewsPageHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlInTheNewsHeader));
		return driver.findElement(atlInTheNewsHeader);
	}
	public WebElement getATLAtlantaNext() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlAtlantaNext));
		return driver.findElement(atlAtlantaNext);
	}
	public WebElement getATLAtlantaNextHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAtlantaNextHeader));
		return driver.findElement(atlAtlantaNextHeader);
	}
	public WebElement getATLPortmanPeachtree() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlPortmanPeachtree));
		return driver.findElement(atlPortmanPeachtree);
	}
	public WebElement getATLPortmanPeachtreetHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAtlantaNextHeader));
		return driver.findElement(atlAtlantaNextHeader);
	}
	public WebElement getVerifyNewsSection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyNewsSection));
		return driver.findElement(VerifyNewsSection);
	}
	
}

