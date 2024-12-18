package pageObjects.AtlantaApparel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAppFashionGalleryTabPage 
{
	public WebDriver driver;
	public WebDriverWait wait;

	By atlAppFashionGalleryTab = By.xpath("//nav[@class='imc-navigation-container']/descendant::a[contains(text(),'The Best Of Fashion')]"); 
	By atlAppfashionGalleryLink = By.xpath("//div[@class='imc-section']/div[1]/div[5]/div[2]/div[1]/div[1]/a[1]"); 
	By atlAppfashionGalleryLinkImg = By.xpath("//div[@class='imc-section']/div[1]/div[5]/div[2]/div[1]/div[1]/a[2]");
	By atlAppLookBook = By.xpath("//div[@class='imc-section']/div[1]/div[5]/div[2]/div[2]/div[1]/a[1]");
	By atlAppLookBookImg = By.xpath("//div[@class='imc-section']/div[1]/div[5]/div[2]/div[2]/div[1]/a[2]");
	By atlAppvideosImages = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Videos')]");
	By atlAppvideosImagesImg = By.xpath("//div[@class='imc-section']/div[1]/div[5]/div[2]/div[3]/div[1]/a[2]");
	By atlAppNews = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'In The News')]");
	By atlAppNewsImg = By.xpath("//div[@class='imc-section']/div[1]/div[5]/div[2]/div[4]/div[1]/a[2]");
	By Trends = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Trends')]");
	By LookbooksAndBrandBooks = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Lookbooks and Brand Books')]");
	
	public ATLAppFashionGalleryTabPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getatlAppFashionGalleryTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlAppFashionGalleryTab));
		return driver.findElement(atlAppFashionGalleryTab);		
	}

	public WebElement getatlAppfashionGalleryLink() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAppfashionGalleryLink));
		return driver.findElement(atlAppfashionGalleryLink);		
	}

	public WebElement getatlAppfashionGalleryLinkImg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlAppfashionGalleryLinkImg));
		return driver.findElement(atlAppfashionGalleryLinkImg);		
	}

	public WebElement getatlAppLookBook() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAppLookBook));
		return driver.findElement(atlAppLookBook);		
	}
	public WebElement getatlAppLookBookImg() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAppLookBookImg));
		return driver.findElement(atlAppLookBookImg);		
	}
	public WebElement getatlAppvideosImages() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAppvideosImages));
		return driver.findElement(atlAppvideosImages);		
	}
	public WebElement getatlAppvideosImagesImg() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAppvideosImagesImg));
		return driver.findElement(atlAppvideosImagesImg);		
	}
	public WebElement getatlAppNews() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAppNews));
		return driver.findElement(atlAppNews);		
	}
	public WebElement getatlAppatlAppNewsImg() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAppNewsImg));
		return driver.findElement(atlAppNewsImg);		
	}
	public WebElement getTrends() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Trends));
		return driver.findElement(Trends);		
	}
	public WebElement getLookbooksAndBrandBooks() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LookbooksAndBrandBooks));
		return driver.findElement(LookbooksAndBrandBooks);		
	}

}
