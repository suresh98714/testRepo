package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YahooSearchPage {

	public WebDriver driver;
	
	public YahooSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='p']")
	public WebElement yahooSearch;
	
	public void NavigatetoYahoo(String searchText){
		yahooSearch.sendKeys(searchText,Keys.ENTER);
		
	}
	
}
