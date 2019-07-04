package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
	
	WebDriver driver;
	public GoogleSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//input[@name='q']")
	WebElement googleSearch;
	
	public void googleeSearch(){
		googleSearch.sendKeys("Google Testing",Keys.ENTER);
		System.out.println("Entered text in Google Search");
		System.out.println("Google Test Done");
		

	}

}
