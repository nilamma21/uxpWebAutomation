package pageObjects.LasVegasMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPFooterLinksNavigationPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By marketInfo = By.xpath("//a[@href='/market-info']"); //Locator for Market information in footer links
	By marketInfoATL = By.xpath("//a[@href='/Markets']"); //Locator for Market information in footer links
	By marketInfoAMC = By.xpath("//a[@href='/about']"); //Locator for Market information in footer links AMC
	By pressCenter = By.xpath("//a[@href='/Market-Info/Press-Center']"); //Locator for Press Center in footer links
	By pressCenterAMC = By.xpath("//a[@href='/About/Press-Center']"); //Locator for Press Center in footer links
	By pressCenterATL = By.xpath("//a[@href='/Markets/Press-Center']"); //Locator for Press Center in footer links
	By ourBrandsATL = By.xpath("//a[@href='/exhibitor/directory']"); //Locator for Our brands in footer links ATL
	By DownloadTheApp = By.xpath("//a[contains(text(),'Download the @Market App')]"); //Locator for Download The App in footer links
	By ContactUs = By.xpath("(//a[contains(text(),'Contact Us')])[2]"); //Locator for Contact Us in footer links
	By ContactUsATL = By.xpath("//a[contains(text(),'Contact Us')]"); //Locator for Contact Us in footer links
	By Careers = By.xpath("//a[@href='/market-info/careers']"); //Locator for Careers in footer links
	By CareersATL = By.xpath("//a[contains(text(),'Careers')]"); //Locator for Careers in footer links
	By PrivacyPolicy = By.xpath("//a[contains(text(),'Privacy Policy')]"); // Locator for Privacy Policy in footer links
	By TermsAndConditions = By.partialLinkText("Terms"); // Locator for Terms and Conditions in footer links
	By AmericasMart = By.xpath("//a[@href='https://www.americasmart.com']"); //Locator for Americas Mart in footer links
	By AmericasMart_ATLApp = By.xpath("(//a[contains(text(),'AmericasMart')])"); //Locator for Americas Mart in footer links of ATLApp
	By AmericasMart_ATLAppFooter = By.xpath("(//div[@class='imc-section imc-section--padded']//preceding::a[contains(text(),'AmericasMart')])[1]"); //Locator for Americas Mart in footer links of ATLApp
	By lvapplink_ATL = By.xpath("(//a[contains(@href,'https://www.lasvegas-apparel.com/')])[1]"); //Locator for Las Vegas Apparel footer link
	By lvapplink_ATL_Footer = By.xpath("(//a[contains(@href,'https://www.lasvegas-apparel.com/?')])[2]"); //Locator for Las Vegas Apparel footer link
	By lvmlink_ATL = By.xpath("//a[contains(text(),'Las Vegas Market')]"); //Locator for Las Vegas market footer link
	By lvmlink_ATLM = By.xpath("//a[contains(@href,'https://www.lasvegas-apparel.com/')]"); //Locator for Las Vegas market footer link
	By lvmlink_ATL_Footer = By.xpath("(//div[@class='imc-section imc-section--padded']//preceding::a[contains(text(),'Las Vegas Apparel')])[1]"); //Locator for Las Vegas market footer link
	By AtlantaApparel = By.xpath("//div[@class='imc-accordion imc-vr--titan imc-category--heading']/descendant::a[text()='Atlanta Apparel']"); //Locator for Atlanta Apparel in footer links
	By AtlantaMarket = By.xpath("//div[contains(@class,'imc-accordion imc-vr--titan imc-category--heading')]//a[contains(text(),'Atlanta Market')]"); //Locator for Atlanta Matket in footer links
	By HighPointMarket = By.xpath("//a[contains(text(),'ANDMORE at High Point Market')]"); //Locator for High Point Market in footer links
	By lvapplink = By.xpath("(//a[contains(@href,'https://www.lasvegas-apparel.com')])[2]"); //Locator for Las Vegas Apparel footer link
	By InternationalMarketCenters = By.xpath("//a[contains(text(),'International Market Centers')]"); //Locator for International Market Centers in footer links
	By JuniperMarket = By.xpath("//a[contains(@href,'https://www.junipermarket.com')]"); //Locator for Juniper Market  in footer links
	By facebookicon = By.xpath("//a[@href='https://www.facebook.com/lvmarket']//div//*[name()='svg']"); //Locator for Facebook link in footer
	By instagramicon =  By.xpath("//a[@href='https://www.instagram.com/lasvegasmarket/']//div//*[name()='svg']"); //Locator for Instagram link in footer
	By instagramiconATLM =  By.xpath("//a[@href='https://www.instagram.com/americasmartatl/']//div//*[name()='svg']"); //Locator for Instagram link in footer
	By youtubeicon = By.xpath("//a[@href='https://www.youtube.com/channel/UCh8pZYxnmh7Wjrnf3d_OsWg']//div//*[name()='svg']"); //Locator You Tube icon
	By pinteresticon = By.xpath("//a[@href='https://www.pinterest.com/lasvegasmarket/']//div//*[name()='svg']"); //Locator for Pinterest icon
	By twittericon = By.xpath("//a[@href='https://twitter.com/lasvegasmarket']//div//*[name()='svg']"); //Locator for Twitter icon
	By twittericonATLM = By.xpath("//a[@href='https://twitter.com/americasmartatl']//div//*[name()='svg']"); //Locator for Twitter icon
	By linkedinicon = By.xpath("//a[@href='https://www.linkedin.com/company/las-vegas-market']//div//*[name()='svg']"); //Locator for LinkedIn icon
	By footerLVMLogo = By.xpath("//img[@src='https://www.lasvegasmarket.com/-/media/Channel-Logos/LVM-footer.svg']"); //Locator for Footer LVM logo
	By VerifyCareers = By.xpath("//div[@id = 'content']/div[1]/div[1]/h1[1]"); //Locator for verify Careers
	By VerifyTermsOfUse = By.xpath("//div[@id = 'primary']/h1"); //Locator for Terms of Use
	By VerifyPrivacyPolicy = By.xpath("//*[contains (text(), 'WEB PRIVACY STATEMENT']"); //Locator for privacy Policy
	By abtatlmktlink = By.xpath("//a[@href='/Market-Info/About-Us']"); //Locator for About Atlanta Market footer link
	By lvmprivacypolicy = By.xpath("(//a[contains(text(),'Privacy Policy')])[position()=2]"); //Locator for Privacy Policy on LVM Footer
	By ClosePopUpAmericasmart = By.xpath("//div[@class = ' contact-exit']"); //Locator for Close Pop Up after opening Americas Mart footer link
	By atlprivacypolicy = By.xpath("//a[contains(text(),'Privacy Policy')]"); //Locator for Privacy Policy on LVM Footer
	By andmore = By.xpath("(//div[contains(@class,'imc-gallery__item imc-gallery__item--minheight imc-content-nav-container--column')]/div/p/a[contains(text(),'ANDMORE')])[2]"); //Locator for ANDMORE in footer links
	By CasualMarket = By.xpath("(//a[contains(text(),'Casual Market Atlanta')])[2]");
	By ContactUsLVA = By.xpath("//a[@href='/about/contact-us']");
	
/*	By HighPointMarket = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[1]/div[1]/a[1]"); //Locator for High Point Market in footer links
	By AtlantaMarket = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[2]/div[1]/a[1]"); //Locator for Atlanta Matket in footer links
	By AtlantaApparel = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[3]/div[1]/a[1]"); //Locator for Atlanta Apparel in footer links
	By AmericasMart = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[4]/div[1]/a[1]"); //Locator for Americas Mart in footer links
	By InternationalMarketCenters = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[2]/div[5]/div[1]/a[1]"); //Locator for International Market Centers in footer links
	By DownloadTheApp = By.xpath("//a[contains(text(),'Download the App')]"); //Locator for Download The App in footer links
	By ContactUs = By.xpath("(//a[@href='/Contact-Us'])[position()=2]"); //Locator for Contact Us in footer links
	By Careers = By.xpath("//a[@href='/Market-Info/Careers']"); //Locator for Careers in footer links
	By TermsAndConditions = By.xpath("//nav[@class='imc-footer-links imc-content imc-content--invert']/div[1]/div[3]/div[4]/div[1]/a[1]"); // Locator for Terms and Conditions in footer links
	By PrivacyPolicy = By.xpath("//a[contains(text(),'Privacy Policy')]"); // Locator for Privacy Policy in footer links
	By VerifyCareers = By.xpath("//div[@id = 'content']/div[1]/div[1]/h1[1]"); //Locator for verify Careers
	By ClosePopUpAmericasmart = By.xpath("//div[@class = ' contact-exit']"); //Locator for Close Pop Up after opening Americas Mart footer link
	By VerifyTermsOfUse = By.xpath("//div[@id = 'primary']"); //Locator for Terms of Use
	By VerifyPrivacyPolicy = By.xpath("//*[contains (text(), 'WEB PRIVACY STATEMENT']"); //Locator for privacy Policy
	By facebookicon = By.xpath("//a[@href='https://www.facebook.com/lvmarket']//div//*[name()='svg']"); //Locator for Facebook link in footer
	By instagramicon =  By.xpath("//a[@href='https://www.instagram.com/lasvegasmarket/']//div//*[name()='svg']"); //Locator for Instagram link in footer
	By youtubeicon = By.xpath("//a[@href='https://www.youtube.com/channel/UCh8pZYxnmh7Wjrnf3d_OsWg']//div//*[name()='svg']"); //Locator You Tube icon
	By pinteresticon = By.xpath("//a[@href='https://www.pinterest.com/lasvegasmarket/']//div//*[name()='svg']"); //Locator for Pinterest icon
	By twittericon = By.xpath("//a[@href='https://twitter.com/lasvegasmarket']//div//*[name()='svg']"); //Locator for Twitter icon
	By linkedinicon = By.xpath("//a[@href='https://www.linkedin.com/company/las-vegas-market']//div//*[name()='svg']"); //Locator for LinkedIn icon
	By abtatlmktlink = By.xpath("//a[@href='/Market-Info/About-Us']"); //Locator for About Atlanta Market footer link
	By lvapplink = By.xpath("(//a[@href='https://www.lasvegas-apparel.com/'])[position()=2]"); //Locator for Las Vegas Apparel footer link
	By lvmprivacypolicy = By.xpath("(//a[contains(text(),'Privacy Policy')])[position()=2]"); //Locator for Privacy Policy on LVM Footer
	*/
	public UXPFooterLinksNavigationPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getlvmlink_ATL_Footerr() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmlink_ATL_Footer));
		return driver.findElement(lvmlink_ATL_Footer);
	}
	
	public WebElement getlvapplink_ATL_Footer() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvapplink_ATL_Footer));
		return driver.findElement(lvapplink_ATL_Footer);
	}
	
	public WebElement getHighPointMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HighPointMarket));
		return driver.findElement(HighPointMarket);
	}
	
	public WebElement getAtlantaMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AtlantaMarket));
		return driver.findElement(AtlantaMarket);
	}
	
	public WebElement getAtlantaApparel() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AtlantaApparel));
		return driver.findElement(AtlantaApparel);
	}
	
	public WebElement getAmericasMart() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AmericasMart));
		return driver.findElement(AmericasMart);
	}
	
	public WebElement getInternationalMarketCenters() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(InternationalMarketCenters));;
		return driver.findElement(InternationalMarketCenters);
	}
	
	public WebElement getDownloadTheApp() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DownloadTheApp));
		return driver.findElement(DownloadTheApp);
	}
	
	public WebElement getContactUs() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContactUs));
		return driver.findElement(ContactUs);
	}
	
	public WebElement getCareers() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Careers));
		return driver.findElement(Careers);
	}
	
	public WebElement getTermsAndConditions() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(TermsAndConditions));;
		return driver.findElement(TermsAndConditions);
	}
	
	public WebElement getPrivacyPolicy() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PrivacyPolicy));
		return driver.findElement(PrivacyPolicy);
	}
	
	public WebElement getVerifyCareers() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyCareers));
		return driver.findElement(VerifyCareers);
	}
	
	public WebElement getClosePopUpAmericasmart() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClosePopUpAmericasmart));
		return driver.findElement(ClosePopUpAmericasmart);
	}
	
	public WebElement getVerifyTermsOfUse() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyTermsOfUse));
		return driver.findElement(VerifyTermsOfUse);
	}
	
	public WebElement getVerifyPrivacyPolicy() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyPrivacyPolicy));
		return driver.findElement(VerifyPrivacyPolicy);
	}
	
	public WebElement getFacebookIcon() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(facebookicon));
		return driver.findElement(facebookicon);
	}
	
	public WebElement getInstagramIcon() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(instagramicon));
		return driver.findElement(instagramicon);
	}
	
	public WebElement getYouTubeIcon() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(youtubeicon));
		return driver.findElement(youtubeicon);
	}
	
	public WebElement getPinterestIcon() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pinteresticon));
		return driver.findElement(pinteresticon);
	}
	
	public WebElement getTwitterIcon() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(twittericon));
		return driver.findElement(twittericon);
	}
	
	public WebElement getLinkedInIcon() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(linkedinicon));
		return driver.findElement(linkedinicon);
	}
	
	public WebElement getAbtAtlMktLink() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(abtatlmktlink));
		return driver.findElement(abtatlmktlink);
	}
	
	public WebElement getLVAPPLink() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvapplink));
		return driver.findElement(lvapplink);
	}
	
	public WebElement getLVMPrivacyPolicyPLink() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmprivacypolicy));
		return driver.findElement(lvmprivacypolicy);
	}
	
	public WebElement getmarketInfo() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(marketInfo));
		return driver.findElement(marketInfo);
	}
	
	public WebElement getmarketInfoATL() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(marketInfoATL));
		return driver.findElement(marketInfoATL);
	}
	
	public WebElement getContactUsATL() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContactUsATL));
		return driver.findElement(ContactUsATL);
	}
	
	public WebElement getCareersATL() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CareersATL));
		return driver.findElement(CareersATL);
	}
	
	public WebElement getAmericasMart_ATLApp() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AmericasMart_ATLApp));
		return driver.findElement(AmericasMart_ATLApp);
	}
	
	public WebElement getAmericasMart_ATLAppFooter() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AmericasMart_ATLAppFooter));
		return driver.findElement(AmericasMart_ATLAppFooter);
	}
	
	public WebElement getatlprivacypolicy() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlprivacypolicy));
		return driver.findElement(atlprivacypolicy);
	}
	
	public WebElement getpressCenterATL() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pressCenterATL));
		return driver.findElement(pressCenterATL);
	}
	
	public WebElement getOurBrandsATL() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ourBrandsATL));
		return driver.findElement(ourBrandsATL);
	}
	
	public WebElement getlvapplink_ATL() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvapplink_ATL));
		return driver.findElement(lvapplink_ATL);
	}
	
	public WebElement getlvmlink_ATL() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmlink_ATL));
		return driver.findElement(lvmlink_ATL);
	}	
	
	public WebElement getJuniperMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(JuniperMarket));
		return driver.findElement(JuniperMarket);
	}	
	
	public WebElement getpressCenter() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pressCenter));
		return driver.findElement(pressCenter);
	}	
	
	public WebElement getlvmlink_ATLM() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmlink_ATLM));
		return driver.findElement(lvmlink_ATLM);
	}	
	
	public WebElement getInstagramiconATLM() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(instagramiconATLM));
		return driver.findElement(instagramiconATLM);
	}	
	
	public WebElement gettwittericonATLM() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(twittericonATLM));
		return driver.findElement(twittericonATLM);
	}	
	
	public WebElement marketInfoAMC() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(marketInfoAMC));
		return driver.findElement(marketInfoAMC);
	}		
	
	public WebElement getpressCenterAMC() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pressCenterAMC));
		return driver.findElement(pressCenterAMC);
	}	
	
	public WebElement getandmore() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(andmore));;
		return driver.findElement(andmore);
	}
	
	public WebElement getCasualMarket() throws InterruptedException {
	wait = new WebDriverWait (driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(CasualMarket));;
	return driver.findElement(CasualMarket);
	}
	
	public WebElement getContactUsLVA() throws InterruptedException {
	wait = new WebDriverWait (driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(ContactUsLVA));;
	return driver.findElement(ContactUsLVA);
	}
}
