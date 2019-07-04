package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import browserUtility.Browser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.YahooSearchPage;
import utility.PropertyFileReader;

public class GlobalSearch {
	private WebDriver driver;
	PropertyFileReader prop=new PropertyFileReader();
	@Given("^Open Yahoo Page$")
	public void open_Yahoo_Page() throws InterruptedException, FileNotFoundException, IOException {
		Properties newPROP=prop.getproperty();
		driver=Browser.openBrowser(driver, newPROP.getProperty("browserName"),newPROP.getProperty("url"));
		
	}

	@Then("^Check \"([^\"]*)\" in yahoo search$")
	public void check_in_yahoo_search(String search) {
		new YahooSearchPage(driver).NavigatetoYahoo(search);
		driver.quit();
		
	}

}
