package pageObjects.AtlantaApparel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAppFashionGalleryTabPage 
{
	public WebDriver driver;
	public WebDriverWait wait;

	By atlAppFashionGalleryTab = By.xpath("//div[@class='imc-section']/div[1]/div[5]/div[1]/a[1]"); 
	By atlAppfashionGalleryLink = By.xpath("//div[@class='imc-section']/div[1]/div[5]/div[2]/div[1]/div[1]/a[1]"); 
	By atlAppfashionGalleryLinkImg = By.xpath("//div[@class='imc-section']/div[1]/div[5]/div[2]/div[1]/div[1]/a[2]");
	By atlAppLookBook = By.xpath("//div[@class='imc-section']/div[1]/div[5]/div[2]/div[2]/div[1]/a[1]");
	By atlAppLookBookImg = By.xpath("//div[@class='imc-section']/div[1]/div[5]/div[2]/div[2]/div[1]/a[2]");
	By atlAppvideosImages = By.xpath("//div[@class='imc-section']/div[1]/div[5]/div[2]/div[3]/div[1]/a[1]");
	By atlAppvideosImagesImg = By.xpath("//div[@class='imc-section']/div[1]/div[5]/div[2]/div[3]/div[1]/a[2]");
	By atlAppNews = By.xpath("//div[@class='imc-section']/div[1]/div[5]/div[2]/div[4]/div[1]/a[1]");
	By atlAppNewsImg = By.xpath("//div[@class='imc-section']/div[1]/div[5]/div[2]/div[4]/div[1]/a[2]");
	
	public ATLAppFashionGalleryTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getatlAppFashionGalleryTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlAppFashionGalleryTab));
		return driver.findElement(atlAppFashionGalleryTab);		
	}

	public WebElement getatlAppfashionGalleryLink() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAppfashionGalleryLink));
		return driver.findElement(atlAppfashionGalleryLink);		
	}

	public WebElement getatlAppfashionGalleryLinkImg() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(atlAppfashionGalleryLinkImg));
		return driver.findElement(atlAppfashionGalleryLinkImg);		
	}

	public WebElement getatlAppLookBook() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAppLookBook));
		return driver.findElement(atlAppLookBook);		
	}
	public WebElement getatlAppLookBookImg() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAppLookBookImg));
		return driver.findElement(atlAppLookBookImg);		
	}
	public WebElement getatlAppvideosImages() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAppvideosImages));
		return driver.findElement(atlAppvideosImages);		
	}
	public WebElement getatlAppvideosImagesImg() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAppvideosImagesImg));
		return driver.findElement(atlAppvideosImagesImg);		
	}
	public WebElement getatlAppNews() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAppNews));
		return driver.findElement(atlAppNews);		
	}
	public WebElement getatlAppatlAppNewsImg() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlAppNewsImg));
		return driver.findElement(atlAppNewsImg);		
	}

}
