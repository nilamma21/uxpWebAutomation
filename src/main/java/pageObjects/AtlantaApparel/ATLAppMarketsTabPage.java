package pageObjects.AtlantaApparel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAppMarketsTabPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By ATLAppHeaders = By.xpath("//div[@class ='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[2]/a[1]");
	By ATLCompleteShowDates = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[1]/div[2]/a[1]");
	By ATLPressReleases = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[1]/div[3]/a[1]");
	By ATLInTheNews = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[1]/div[4]/a[1]");
	By ATLAppImage = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[2]/div[1]/a[2]");
	By ATLAppHeadersnext = By.xpath("//div[@class ='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[3]/a[1]");
	By ATLAppHeadersnextnext = By.xpath("//div[@class ='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[3]");
	By ATLAppLink = By.xpath("//div[@class='imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[2]/div[2]/a[1]");
	By ATLAppHeadersProduct = By.xpath("//div[@class ='imc-gallery imc-gallery--65-35 breadcrumbs__round']/div[1]/ul[1]/li[5]/a[1]");

	By ATLVowImg = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[3]/div[1]/a[2]");
	By ATLVowLink = By.xpath("//div[@class='imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[3]/div[2]/a[1]");
	By ATLWorldOfPromImg = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[4]/div[1]/a[2]");
	By ATLWorldOfPromLink = By.xpath("//div[@class='imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[4]/div[2]/a[1]");

	By ATLLasVegasAppImg = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[5]/div[1]/a[2]");
	By ATLLasVegasAppLink = By.xpath("//div[@class='imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[5]/div[2]/a[1]");


	//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[3]/div[1]/a[2]
	public ATLAppMarketsTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getATLAppHeaders()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLAppHeaders));
		return driver.findElement(ATLAppHeaders);

	}
	public WebElement getATLAppHeadersnext()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLAppHeadersnext));
		return driver.findElement(ATLAppHeadersnext);

	}
	public WebElement getATLAppHeadersnextnext()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLAppHeadersnextnext));
		return driver.findElement(ATLAppHeadersnextnext);

	}
	public WebElement getATLAppHeadersProduct()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLAppHeadersProduct));
		return driver.findElement(ATLAppHeadersProduct);
	}

	public WebElement getATLCompleteShowDates()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLCompleteShowDates));
		return driver.findElement(ATLCompleteShowDates);

	}
	public WebElement getATLPressReleases()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLPressReleases));
		return driver.findElement(ATLPressReleases);

	}
	public WebElement getATLInTheNews()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLInTheNews));
		return driver.findElement(ATLInTheNews);

	}
	public WebElement getATLAppImage()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLAppImage));
		return driver.findElement(ATLAppImage);
	}

	public WebElement getATLAppLink()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLAppLink));
		return driver.findElement(ATLAppLink);
	}
	public WebElement getATLVowImage()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLVowImg));
		return driver.findElement(ATLVowImg);
	}

	public WebElement getATLVowLink()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLVowLink));
		return driver.findElement(ATLVowLink);
	}

	public WebElement getATLWorldOfPromImg()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLWorldOfPromImg));
		return driver.findElement(ATLWorldOfPromImg);
	}

	public WebElement getATLWorldOfPromLink()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLWorldOfPromLink));
		return driver.findElement(ATLWorldOfPromLink);
	}

	public WebElement getATLLasVegasAppImg()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLLasVegasAppImg));
		return driver.findElement(ATLLasVegasAppImg);
	}

	public WebElement getATLLasVegasAppLink()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLLasVegasAppLink));
		return driver.findElement(ATLLasVegasAppLink);
	}
}
