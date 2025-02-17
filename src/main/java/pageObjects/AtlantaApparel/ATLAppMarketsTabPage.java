package pageObjects.AtlantaApparel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAppMarketsTabPage {

	public WebDriver driver; 
	public WebDriverWait wait;

	By ATLAppHeaders = By.xpath("//div[@class ='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[2]/a[1]");
	By ATLCompleteShowDates = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Complete Show Dates')]");
	By ATLPressReleases = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Press Releases')]");
	By ATLInTheNews = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'In The News')]");
	By ATLAppImage = By.xpath("//a[@href='/Markets/atlanta-apparel']//img[@class='imc-image--responsive imc-navigation-2tier-image']");
	By ATLAppHeadersnext = By.xpath("//div[@class ='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[3]/a[1]");
	By ATLAppHeadersnextnext = By.xpath("//div[@class ='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[3]");
	By ATLAppHeadersnextnextnext = By.xpath("//div[@class ='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[4]");
	By ATLAppLink = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Atlanta Apparel')]");
	By ATLAppHeadersProduct = By.xpath("//div[@class ='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[5]/a[1]");

	By ATLVowImg = By.xpath("//a[@href='/Markets/Formal-Markets']//img[@class='imc-image--responsive imc-navigation-2tier-image']");
	By ATLVowLink = By.xpath("//div[@class='imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[3]/div[2]/a[1]");
	By ATLWorldOfPromImg = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[4]/div[1]/a[2]");
	By ATLWorldOfPromLink = By.xpath("//div[@class='imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[4]/div[2]/a[1]");

	By ATLLasVegasAppImg = By.xpath("//a[@href='https://www.lasvegas-apparel.com/']//img[@class='imc-image--responsive imc-navigation-2tier-image']");
	By ATLLasVegasAppLink = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Las Vegas Apparel')]");
	
	By ATLFormalMarketsImg = By.xpath("//a[@href='/Markets/Formal-Markets']//img[@class='imc-image--responsive imc-navigation-2tier-image']");
	By ATLFormalMarketLink = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Formal Markets')]");
	//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[3]/div[1]/a[2]
	
	public ATLAppMarketsTabPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getATLAppHeaders()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLAppHeaders));
		return driver.findElement(ATLAppHeaders);

	}
	public WebElement getATLAppHeadersnext()throws InterruptedException{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLAppHeadersnext));
		return driver.findElement(ATLAppHeadersnext);

	}
	public WebElement getATLAppHeadersnextnext()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLAppHeadersnextnext));
		return driver.findElement(ATLAppHeadersnextnext);

	}
	public WebElement getATLAppHeadersnextnextnext()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLAppHeadersnextnextnext));
		return driver.findElement(ATLAppHeadersnextnextnext);

	}
	public WebElement getATLAppHeadersProduct()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLAppHeadersProduct));
		return driver.findElement(ATLAppHeadersProduct);
	}

	public WebElement getATLCompleteShowDates()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLCompleteShowDates));
		return driver.findElement(ATLCompleteShowDates);

	}
	public WebElement getATLPressReleases()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLPressReleases));
		return driver.findElement(ATLPressReleases);

	}
	public WebElement getATLInTheNews()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLInTheNews));
		return driver.findElement(ATLInTheNews);

	}
	public WebElement getATLAppImage()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLAppImage));
		return driver.findElement(ATLAppImage);
	}

	public WebElement getATLAppLink()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLAppLink));
		return driver.findElement(ATLAppLink);
	}
	public WebElement getATLVowImage()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLVowImg));
		return driver.findElement(ATLVowImg);
	}

	public WebElement getATLVowLink()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLVowLink));
		return driver.findElement(ATLVowLink);
	}

	public WebElement getATLWorldOfPromImg()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLWorldOfPromImg));
		return driver.findElement(ATLWorldOfPromImg);
	}

	public WebElement getATLWorldOfPromLink()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLWorldOfPromLink));
		return driver.findElement(ATLWorldOfPromLink);
	}

	public WebElement getATLLasVegasAppImg()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLLasVegasAppImg));
		return driver.findElement(ATLLasVegasAppImg);
	}

	public WebElement getATLLasVegasAppLink()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLLasVegasAppLink));
		return driver.findElement(ATLLasVegasAppLink);
	}
	public WebElement getATLFormalMarketsImg()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLFormalMarketsImg));
		return driver.findElement(ATLFormalMarketsImg);
	}
	public WebElement getATLFormalMarketLink()throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLFormalMarketLink));
		return driver.findElement(ATLFormalMarketLink);
	}
}
