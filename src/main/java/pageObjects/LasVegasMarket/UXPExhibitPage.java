package pageObjects.LasVegasMarket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPExhibitPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	By exhibittab = By.xpath("//div[@class='imc-header__container-wrapper ']/descendant::span[contains(text(),'Exhibitor Directory')]"); //Locator for Exhibit tab
	By whyexhibitmenu = By.xpath("//a[contains(text(),'Why Exhibit?')]"); //Locator for Why Exhibit sub-menu
	By exhibitoppt = By.xpath("//a[contains(text(),'Exhibit Opportunities')]"); //Locator for Exhibit Opportunities sub-menu
	By advnspnrshp = By.xpath("//a[contains(text(),'Advertising & Sponsorships')]"); //Locator for Advertising & Sponsorships sub-menu
	By tipsforexhibitors = By.xpath("//a[contains(text(),'Tips for Exhibitors')]"); //Locator for Tips for exhibitors sub-menu
	By exhibitorregtn = By.xpath("//a[contains(text(),'Exhibitor Registration')]"); //Locator for Exhibitor Registration sub-menu
	By explogin = By.xpath("//a[contains(text(),'Exhibitor Portal Login')]"); //Locator for Exhibitor Portal Login sub-menu
	By junipersubmenu = By.xpath("//a[contains(text(),'Juniper')]"); //Locator for Juniper sub-menu
	By advnspnrshptitle = By.xpath("//span[contains(text(),'Advertising and Sponsorship Opportunities')]"); //Locator for Advertising & Sponsorships page title
	By exhtipstitle = By.xpath("//span[contains(text(),'Exhibitor Tips')]"); //Locator Exhibitor tips page title
	By exhibitbrdcrumb = By.xpath("//ul[@class='imc-breadcrumb']/li[2]/a"); //Locator for Exhibit Breadcrumb menu
	By exhibitopprbrdcrumb = By.xpath("//ul[@class='imc-breadcrumb']/li[3]/a"); //Locator for Exhibit Opportunities menu
	By exploginpagetitle = By.xpath("//h2[contains(text(),'Sign in with your existing account')]"); //Locator for Exhibitor Portals Login page title
	By advnspnshpbrdcrumbuat = By.xpath("//a[contains(text(),'Marketing and Sponsorship Opportunities')]"); //UAT_Locator for Advertising & Sponsorships page title
	By exhibitorresourcesprod = By.xpath("//div[@class = 'imc-section']/div[1]/div[5]/div[2]/div[3]/div[1]/a[1]"); // Locator for Exhibitor Resources option in Exhibit menu
	By applytoexhibit = By.xpath("(//a[contains(text(),'Apply to Exhibit')])[1]");
	
	By exhibittabNew = By.xpath("//div[@class='imc-breakpoint-display--hide-tablet']/div[1]/div[1]"); //Locator for Exhibit tab
	By visitTabNew = By.xpath("//div[@class='imc-breakpoint-display--hide-tablet']/div[1]/div[2]"); //Locator for Visit tab
	By discoverTabNew = By.xpath("//div[@class='imc-breakpoint-display--hide-tablet']/div[1]/div[3]"); //Locator for Discover tab
	By sourceYearRoundTabNew = By.xpath("//div[@class='imc-breakpoint-display--hide-tablet']/div[1]/div[5]"); //Locator for Discover tab
	By exhibitTab = By.xpath("//div[@class='imc-breakpoint-display--hide-tablet']/div[1]/div[4]"); //Locator for Discover tab
	By exhibitorDirectoryUnderExhibitorDirectoryTab = By.xpath("(//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[contains(text(),'Exhibitor Directory')])[1]"); //Locator for Discover tab
	By PopularFiltersUnderExhibitorDirectoryTab = By.xpath("//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//span[contains(text(),'Popular Filters')]"); //Locator for Discover tab
	By registerUnderVisitTab = By.xpath("//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/Visit/Register']"); //Locator for Register
	By MarketDatesHoursUnderVisitTab = By.xpath("//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/Visit/Market-Dates-and-Hours']"); //Locator for Market Dates & Hours
	By VisitAboutUnderVisitTab = By.xpath("//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/Visit/About']"); //Locator for Visit About
	By MarketPlanUnderVisitTab = By.xpath("//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[contains(text(),'Market Plan')]"); //Locator for Market Plan
	By TravelUnderVisitTab = By.xpath("//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/Visit/Travel']"); //Locator for visit travel
	By DiningUnderVisitTab = By.xpath("//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/Visit/Dining']"); //Locator for Dining
	By ServicesAmenitiesUnderVisitTab = By.xpath("//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/Visit/Services-and-Amenities']"); //Locator for Services & Amenities
	By FAQsUnderVisitTab = By.xpath("//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/Visit/About/FAQs']"); //Locator for FAQs
	
	By ExploreLasVegasMarketUnderDiscoverTab = By.xpath("(//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[contains(text(),'Explore Las Vegas Market')])[1]"); //Locator for FAQs
	By ToolsAndInspirationUnderDiscoverTab = By.xpath("//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/Discover/Tools-and-Inspiration']"); //Locator for FAQs
	By PlanYourMarketUnderDiscoverTab = By.xpath("(//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/Visit/Plan-Your-Market'])[2]"); //Locator for FAQs
	By WhatsNewUnderDiscoverTab = By.xpath("//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/Discover/Whats-New']"); //Locator for FAQs
	By EventsUnderDiscoverTab = By.xpath("//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/Discover/Events-and-Seminars']"); //Locator for FAQs
	By ExhibitorDirectoryUnderDiscoverTab = By.xpath("(//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/exhibitor/exhibitor-directory'])[2]"); //Locator for FAQs
	By ExhibitAtLasVegasMarketUnderExhibitTab = By.xpath("//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/Exhibit']"); //Locator for FAQs
	By ExhibitorResourcesUnderExhibitTab = By.xpath("//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/Exhibit/Exhibitor-Resources']"); //Locator for FAQs
	By YearRoundUndersourceYearRoundTab = By.xpath("//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/Year-Round']"); //Locator for FAQs
	By ExhibitorDirectoryUndersourceYearRoundTab = By.xpath("(//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/exhibitor/exhibitor-directory'])[3]"); //Locator for FAQs
	By ContactUsUndersourceYearRoundTab = By.xpath("//div[@class='desktop-menu imc-content--fixed imc-content--full-width imc-breakpoint-display--hide-tablet']//a[@href='/Contact-Us']"); //Locator for FAQs
	
	public UXPExhibitPage(WebDriver driver) {
		this.driver = driver; 			
	}
	public WebElement getExhibitAtLasVegasMarketUnderExhibitTab() {
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(ExhibitAtLasVegasMarketUnderExhibitTab));
	        return driver.findElement(ExhibitAtLasVegasMarketUnderExhibitTab);
	    }
	public WebElement getExhibitorResourcesUnderExhibitTab() {
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(ExhibitorResourcesUnderExhibitTab));
	        return driver.findElement(ExhibitorResourcesUnderExhibitTab);
	    }
	public WebElement getYearRoundUndersourceYearRoundTab() {
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(YearRoundUndersourceYearRoundTab));
	        return driver.findElement(YearRoundUndersourceYearRoundTab);
	    }
	public WebElement getExhibitorDirectoryUndersourceYearRoundTab() {
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(ExhibitorDirectoryUndersourceYearRoundTab));
	        return driver.findElement(ExhibitorDirectoryUndersourceYearRoundTab);
	    }
	public WebElement getContactUsUndersourceYearRoundTab() {
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(ContactUsUndersourceYearRoundTab));
	        return driver.findElement(ContactUsUndersourceYearRoundTab);
	    }
	public WebElement getExhibitorDirectoryUnderDiscoverTab() {
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(ExhibitorDirectoryUnderDiscoverTab));
	        return driver.findElement(ExhibitorDirectoryUnderDiscoverTab);
	    }

	public WebElement getExploreLasVegasMarketUnderDiscoverTab() {
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(ExploreLasVegasMarketUnderDiscoverTab));
	        return driver.findElement(ExploreLasVegasMarketUnderDiscoverTab);
	    }
		
	public WebElement getToolsAndInspirationUnderDiscoverTab() {
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(ToolsAndInspirationUnderDiscoverTab));
	        return driver.findElement(ToolsAndInspirationUnderDiscoverTab);
	    }
		
	public WebElement getPlanYourMarketUnderDiscoverTab() {
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(PlanYourMarketUnderDiscoverTab));
	        return driver.findElement(PlanYourMarketUnderDiscoverTab);
	    }
	public WebElement getWhatsNewUnderDiscoverTab() {
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(WhatsNewUnderDiscoverTab));
	        return driver.findElement(WhatsNewUnderDiscoverTab);
	    }	
	
	public WebElement getEventsUnderDiscoverTab() {
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(EventsUnderDiscoverTab));
	        return driver.findElement(EventsUnderDiscoverTab);
	    }	
	public WebElement getexhibittabNew() {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(exhibittabNew));
        return driver.findElement(exhibittabNew);
    }
	
	public WebElement getexhibitorDirectoryUnderExhibitorDirectoryTab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(exhibitorDirectoryUnderExhibitorDirectoryTab));
		return driver.findElement(exhibitorDirectoryUnderExhibitorDirectoryTab);
	}
	public WebElement getexhibitTab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(exhibitTab));
		return driver.findElement(exhibitTab);
	}
	public WebElement getsourceYearRoundTabNew() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(sourceYearRoundTabNew));
		return driver.findElement(sourceYearRoundTabNew);
	}
	public WebElement getdiscoverTabNew() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(discoverTabNew));
		return driver.findElement(discoverTabNew);
	}
	public WebElement getvisitTabNew() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(visitTabNew));
		return driver.findElement(visitTabNew);
	}
    public WebElement getFAQsUnderVisitTab() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(FAQsUnderVisitTab));
        return driver.findElement(FAQsUnderVisitTab);
    }

    public WebElement getServicesAmenitiesUnderVisitTab() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(ServicesAmenitiesUnderVisitTab));
        return driver.findElement(ServicesAmenitiesUnderVisitTab);
    }

    public WebElement getDiningUnderVisitTab() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(DiningUnderVisitTab));
        return driver.findElement(DiningUnderVisitTab);
    }

    public WebElement getTravelUnderVisitTab() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(TravelUnderVisitTab));
        return driver.findElement(TravelUnderVisitTab);
    }

    public WebElement getMarketPlanUnderVisitTab() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(MarketPlanUnderVisitTab));
        return driver.findElement(MarketPlanUnderVisitTab);
    }

    public WebElement getVisitAboutUnderVisitTab() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(VisitAboutUnderVisitTab));
        return driver.findElement(VisitAboutUnderVisitTab);
    }

    public WebElement getMarketDatesHoursUnderVisitTab() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(MarketDatesHoursUnderVisitTab));
        return driver.findElement(MarketDatesHoursUnderVisitTab);
    }

    public WebElement getRegisterUnderVisitTab() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(registerUnderVisitTab));
        return driver.findElement(registerUnderVisitTab);
    }

    public WebElement getPopularFiltersUnderExhibitorDirectoryTab() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(PopularFiltersUnderExhibitorDirectoryTab));
        return driver.findElement(PopularFiltersUnderExhibitorDirectoryTab);
    }

    public WebElement getExhibitorDirectoryUnderExhibitorDirectoryTab() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(exhibitorDirectoryUnderExhibitorDirectoryTab));
        return driver.findElement(exhibitorDirectoryUnderExhibitorDirectoryTab);
    }


	public WebElement getExhibitTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(exhibittab));
		return driver.findElement(exhibittab);		
	}
	
	
	public WebElement getWhyExhibitMenu() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(whyexhibitmenu));
		return driver.findElement(whyexhibitmenu);		
	}
	public WebElement getExhibitOpptMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitoppt));
		return driver.findElement(exhibitoppt);		
	}
	public WebElement getAdvertisingnSponsershipsMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(advnspnrshp));
		return driver.findElement(advnspnrshp);		
	}
	public WebElement getTipsForExhibitorsMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(tipsforexhibitors));
		return driver.findElement(tipsforexhibitors);		
	}
	public WebElement getExhibitorRegtnMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorregtn));
		return driver.findElement(exhibitorregtn);		
	}
	public WebElement getExhibitorPortalLoginMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(explogin));
		return driver.findElement(explogin);		
	}
	public WebElement getJuniperMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(junipersubmenu));
		return driver.findElement(junipersubmenu);		
	}
	public WebElement getAdvertisingnSponsershipsTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(advnspnrshptitle));
		return driver.findElement(advnspnrshptitle);		
	}
	public WebElement getExhibitorTipsTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhtipstitle));
		return driver.findElement(exhtipstitle);		
	}
	public WebElement getExhibitBrdcrumb() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitbrdcrumb));
		return driver.findElement(exhibitbrdcrumb);		
	}
	public WebElement getExhibitOpprBrdcrumb() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitopprbrdcrumb));
		return driver.findElement(exhibitopprbrdcrumb);		
	}
	public WebElement getEXPLoginPageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exploginpagetitle));
		return driver.findElement(exploginpagetitle);		
	}
	public WebElement getAdvSpnsershpBrdcrumbUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(advnspnshpbrdcrumbuat));
		return driver.findElement(advnspnshpbrdcrumbuat);		
	}
	public WebElement getexhibitorresourcesprod() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(exhibitorresourcesprod));
		return driver.findElement(exhibitorresourcesprod);		
	}
	public WebElement getapplytoexhibit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(applytoexhibit));
		return driver.findElement(applytoexhibit);		
	}

}


