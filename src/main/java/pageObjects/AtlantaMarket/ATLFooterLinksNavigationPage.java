package pageObjects.AtlantaMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLFooterLinksNavigationPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By highpointmarket = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[1]/div[1]/a[1]"); //Locator for High Point Market in footer links
	By atlantamarket = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[2]/div[1]/a[1]"); //Locator for Atlanta Matket in footer links
	By atlantaapparel = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[3]/div[1]/a[1]"); //Locator for Atlanta Apparel in footer links
	By americasmart = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[4]/div[1]/a[1]"); //Locator for Americas Mart in footer links
	By internationalmarketcenters = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[5]/div[1]/a[1]"); //Locator for International Market Centers in footer links
	By downloadtheapp = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[3]/div[1]/div[1]/a[1]"); //Locator for Download The App in footer links
	By contactus = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[3]/div[4]/div[1]/a[1]"); //Locator for Contact Us in footer links
	By careers = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[3]/div[2]/div[1]/a[1]"); //Locator for Careers in footer links
	By MediaPressReleases = By.xpath("//a[contains(text(), 'Media & Press Releases')]"); //Locator for Media and Press Releases
	By termsandconditions = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[3]/div[4]/div[1]/a[1]"); // Locator for Terms and Conditions in footer links
	By privacypolicy = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[3]/div[5]/div[1]/a[1]"); // Locator for Privacy Policy in footer links
	By verifycareers = By.xpath("//div[@id = 'content']/div[1]/div[1]/h1[1]"); //Locator for verify Careers
	By closepopupamericasmart = By.xpath("//div[@class = ' contact-exit']"); //Locatory for Close Pop Up after opening Americas Mart footer link
	By verifytermsofuse = By.xpath("//div[@id = 'primary']"); //Locator for Terms of Use
	By verifyprivacypolicy = By.xpath("//*[contains (text(), 'Privacy Policy')]"); //Locator for porivacy Policy
	By facebookicon = By.xpath("//a[@href='https://www.facebook.com/AmericasmartAtl']//div//*[name()='svg']"); //Locator for Facebook link in footer
	By instagramicon =  By.xpath("//a[@href='https://www.instagram.com/americasmartatl/']//div//*[name()='svg']"); //Locator for Instagram link in footer
	By youtubeicon = By.xpath("//a[@href='https://www.youtube.com/user/AmericasMart']//div//*[name()='svg']"); //Locator You Tube icon
	By twittericon = By.xpath("//a[@href='https://twitter.com/americasmartatl']//div//*[name()='svg']"); //Locator for Twitter icon
	By atlimclinkprod = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[7]/div[1]/a[1]"); //Locator IMC Footer link
	By atlhpmktlinkprod = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[4]/div[1]/a[1]"); //Locator for High Point footer link

	public ATLFooterLinksNavigationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getHighPointMarket() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(highpointmarket);
	}

	public WebElement getAtlantaMarket() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(atlantamarket);
	}

	public WebElement getAtlantaApparel() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(atlantaapparel);
	}

	public WebElement getAmericasMart() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(americasmart);
	}

	public WebElement getInternationalMarketCenters() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(internationalmarketcenters);
	}

	public WebElement getDownloadTheApp() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(downloadtheapp);
	}

	public WebElement getContactUs() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(contactus);
	}

	public WebElement getCareers() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(careers);
	}

	public WebElement getTermsAndConditions() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(termsandconditions);
	}

	public WebElement getPrivacyPolicy() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(privacypolicy);
	}
	
	public WebElement getVerifyCareers() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(verifycareers);
	}
	
	public WebElement getClosePopUpAmericasmart() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(closepopupamericasmart);
	}
	
	public WebElement getVerifyTermsOfUse() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(verifytermsofuse);
	}
	
	public WebElement getVerifyPrivacyPolicy() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(verifyprivacypolicy);
	}
	
	public WebElement getFacebookIcon() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(facebookicon);
	}
	public WebElement getInstagramIcon() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(instagramicon);
	}
	public WebElement getYouTubeIcon() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(youtubeicon);
	}
	public WebElement getTwitterIcon() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(twittericon);
	}
	public WebElement getATLIMCLinkProd() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(atlimclinkprod);
	}
	public WebElement getATLHPMktLink() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(atlhpmktlinkprod);
	}
	public WebElement getMediaPressReleases() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(MediaPressReleases);
	}
}



