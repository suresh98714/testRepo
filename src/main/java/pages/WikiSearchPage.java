package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WikiSearchPage {
	
	WebDriver driver;
	public WikiSearchPage(WebDriver driver) {
		this.driver=driver;
		
	}

	@FindBy(how=How.XPATH,using="//input[@name='q']")
	WebElement wikiSearch;
	
	public void wikiSearch(){
		wikiSearch.sendKeys("Manual Testing",Keys.ENTER);		
	}
}
