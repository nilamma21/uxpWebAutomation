package pageObjects.AtlantaApparel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAppFooterLinksNavigationPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By AmericasMart = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[1]/div[1]/a[1]"); //Locator for High Point Market in footer links
	By AtlantaMarket = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[2]/div[1]/a[1]"); //Locator for Atlanta Matket in footer links
	By IMCHeighPointMarket = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[3]/div[1]/a[1]"); //Locator for Atlanta Apparel in footer links
	By LasVegasMarket = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[4]/div[1]/a[1]"); //Locator for Americas Mart in footer links
	By InternationalMarketCenters = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[5]/div[1]/a[1]"); //Locator for International Market Centers in footer links

	By DownloadTheApp = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[3]/div[1]/div[1]/a[1]"); //Locator for Download The App in footer links
	By PressRealeas = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[3]/div[2]/div[1]/a[1]"); //Locator for Contact Us in footer links
	By Careers = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[3]/div[3]/div[1]/a[1]"); //Locator for Careers in footer links
	By ContactUs = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[3]/div[4]/div[1]/a[1]"); // Locator for Terms and Conditions in footer links
	By PrivacyPolicy = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[3]/div[5]/div[1]/a[1]"); // Locator for Privacy Policy in footer links
	By VerifyCareers = By.xpath("//div[@id = 'content']/div[1]/div[1]/h1[1]"); //Locator for verify Careers
	By ClosePopUpAmericasmart = By.xpath("//div[@class = ' contact-exit']"); //Locatory for Close Pop Up after opening Americas Mart footer link
	By lvapplink = By.xpath("(//a[@href='https://www.lasvegas-apparel.com/'])[position()=2]"); //Locator for Las Vegas Apparel footer link
	By facebookicon = By.xpath("//div[@class='section-wrapper imc-section--neutral-heavy']/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]"); //Locator for Facebook link in footer
	By instagramicon =  By.xpath("//div[@class='section-wrapper imc-section--neutral-heavy']/section[1]/div[1]/div[1]/div[1]/div[2]/div[3]"); //Locator for Instagram link in footer
	By youtubeicon = By.xpath("//div[@class='section-wrapper imc-section--neutral-heavy']/section[1]/div[1]/div[1]/div[1]/div[2]/div[4]"); //Locator You Tube icon
	By snapchat = By.xpath("//div[@class='section-wrapper imc-section--neutral-heavy']/section[1]/div[1]/div[1]/div[1]/div[2]/div[5]"); //Locator for snapchat icon
	By twittericon = By.xpath("//div[@class='section-wrapper imc-section--neutral-heavy']/section[1]/div[1]/div[1]/div[1]/div[2]/div[2]"); //Locator for Twitter icon

	By footerlogo = By.xpath("//div[@class='imc-vr imc-footer-logo']/a[1]");
	By footerAddress = By.xpath("//div[@id='root']/footer[1]/div[1]/div[1]/div[2]/a[1]/div[1]/span[1]");

	public ATLAppFooterLinksNavigationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getHighPointMarket() throws InterruptedException {
		//Wait till Sign In page is displayed
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(IMCHeighPointMarket));
		return driver.findElement(IMCHeighPointMarket);


	}

	public WebElement getAtlantaMarket() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AtlantaMarket));
		return driver.findElement(AtlantaMarket);

	}

	public WebElement getAmericasMart() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AmericasMart));
		return driver.findElement(AmericasMart);

	}

	public WebElement getInternationalMarketCenters() throws InterruptedException {
		//Wait till Sign In page is displayed
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(InternationalMarketCenters));
		return driver.findElement(InternationalMarketCenters);

	}

	public WebElement getDownloadTheApp() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(DownloadTheApp));
		return driver.findElement(DownloadTheApp);

	}

	public WebElement getContactUs() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ContactUs));
		return driver.findElement(ContactUs);

	}

	public WebElement getCareers() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Careers));
		return driver.findElement(Careers);

	}

	public WebElement getPrivacyPolicy() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PrivacyPolicy));
		return driver.findElement(PrivacyPolicy);

	}



	public WebElement getLasVegasMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LasVegasMarket));
		return driver.findElement(LasVegasMarket);

	}

	public WebElement getPressRealeas() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PressRealeas));
		return driver.findElement(PressRealeas);

	}

	public WebElement getFacebookIcon() throws InterruptedException {
		System.out.println("FB");
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(facebookicon));
		return driver.findElement(facebookicon);
	}
	public WebElement getInstagramIcon() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(instagramicon));
		return driver.findElement(instagramicon);
	}
	public WebElement getYouTubeIcon() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(youtubeicon));
		return driver.findElement(youtubeicon);
	}
	public WebElement getTwitterIcon() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(twittericon));
		return driver.findElement(twittericon);
	}
	public WebElement getsnapchatIcon() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(snapchat));
		return driver.findElement(snapchat);
	}

	public WebElement getfooterlogo() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(footerlogo));
		return driver.findElement(footerlogo);
	}

	public WebElement getfooterAddress() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(footerAddress));
		return driver.findElement(footerAddress);
	}



}
