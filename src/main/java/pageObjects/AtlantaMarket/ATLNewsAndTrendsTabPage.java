package pageObjects.AtlantaMarket;

import java.time.Duration;

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
	By atlWebinarAndEducation=By.xpath("//a[@href='/News-and-Trends/Webinars-and-Education' and contains(text(),'Webinars & Education')]");////Locator for Webinar & Education page
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
		this.driver = driver; 			
	} 

	public WebElement getATLNewsAndTrendsTap() throws InterruptedException {
	  Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlNewsAndTrendsTap));
		return driver.findElement(atlNewsAndTrendsTap);
	}
	
	public WebElement getATLNewsAndTrends() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlNewsAndTrends));
		return driver.findElement(atlNewsAndTrends);
	}
	
	public WebElement getATLNewsAndTrendsSubmenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlsewsntrendssubmenu));
		return driver.findElement(atlsewsntrendssubmenu);
	}
	
	public WebElement getATLNewsAndTrendsPageHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlNewsAndTrendsPageHeader));
		return driver.findElement(atlNewsAndTrendsPageHeader);
	}
	
	public WebElement getATLatlMarketSnapshot() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlMarketSnapshot));
		return driver.findElement(atlMarketSnapshot);
	}
	
	public WebElement getATLMarketSnapshotPageHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlMarketSnapshotPageHeader));
		return driver.findElement(atlMarketSnapshotPageHeader);
	}
	
	public WebElement getATLWebinarAndEducation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlWebinarAndEducation));
		return driver.findElement(atlWebinarAndEducation);
	}
	public WebElement getATLWebinarAndEducationPageHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlWebinarAndEducationHeader));
		return driver.findElement(atlWebinarAndEducationHeader);
	}
	public WebElement getATLatlAheadCurve() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlAheadCurve));
		return driver.findElement(atlAheadCurve);
	}
	public WebElement getATLAheadCurvePageHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAheadCurvePageHeader));
		return driver.findElement(atlAheadCurvePageHeader);
	}
	public WebElement getATLShopTheShow() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlShopTheShow));
		return driver.findElement(atlShopTheShow);
	}
	public WebElement getATLShopTheShowPageHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlShopTheShowPageHeader));
		return driver.findElement(atlShopTheShowPageHeader);
	}
	public WebElement getATLPressReleases() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlPressReleases));
		return driver.findElement(atlPressReleases);
	}
	public WebElement getATLPressReleasesPageHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlPressReleasesHeader));
		return driver.findElement(atlPressReleasesHeader);
	}
	public WebElement getATLPublicationsLibrary() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlPublicationsLibrary));
		return driver.findElement(atlPublicationsLibrary);
	}
	public WebElement getATLPublicationsLibraryPageHeader() throws InterruptedException {
		Thread.sleep(7000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlPublicationsLibraryHeader));
		return driver.findElement(atlPublicationsLibraryHeader);
	}
	public WebElement getATLInTheNews() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlInTheNews));
		return driver.findElement(atlInTheNews);
	}
	public WebElement getATLInTheNewsPageHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlInTheNewsHeader));
		return driver.findElement(atlInTheNewsHeader);
	}
	public WebElement getATLAtlantaNext() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlAtlantaNext));
		return driver.findElement(atlAtlantaNext);
	}
	public WebElement getATLAtlantaNextHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAtlantaNextHeader));
		return driver.findElement(atlAtlantaNextHeader);
	}
	public WebElement getATLPortmanPeachtree() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlPortmanPeachtree));
		return driver.findElement(atlPortmanPeachtree);
	}
	public WebElement getATLPortmanPeachtreetHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAtlantaNextHeader));
		return driver.findElement(atlAtlantaNextHeader);
	}
	public WebElement getVerifyNewsSection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyNewsSection));
		return driver.findElement(VerifyNewsSection);
	}
	
}

