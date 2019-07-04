package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import extentReports.Reports;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;
import utility.PropertyFileReader;

public class GoogleSearch extends Reports {
	private WebDriver driver;
static PropertyFileReader propReader=new PropertyFileReader();
	
	@Given("^Open chrome browser and open url$")
	public void open_chrome_browser_and_open_url() throws FileNotFoundException, IOException {
		ExtentTest logInfo=null;
		try {
			test=extent.createTest(Feature.class,"Google Search Check Feature");
			test=test.createNode(Scenario.class,"Google Search Check Scenario");
			logInfo=test.createNode(new GherkinKeyword("Given"),"Open Browser with URL");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().fullscreen();
			driver.get(PropertyFileReader.getproperty().getProperty("qaurl"));
			logInfo.pass("Opened Chrome Browser and entered URL");			
		} catch (AssertionError|Exception e) {
			testStepHandle("FAIL", driver, logInfo,e);
		}
		
	}

	@When("^Enter search criteria$")
	public void enter_search_criteria(){
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("When"),"Enter Search value in Google");
			new GoogleSearchPage(driver).googleeSearch();
			logInfo.pass("Entering text value in Google");
		} catch (AssertionError|Exception e) {
			testStepHandle("FAIL", driver, logInfo,e);
		}
		
	}

	@Then("^Click on Search button$")
	public void click_on_Search_button() {
		ExtentTest logInfo=null;
		try {
			logInfo=test.createNode(new GherkinKeyword("Then"),"Click the Search button");
			driver.findElement(By.xpath("//input[@name='q34']")).sendKeys(Keys.ENTER);
			logInfo.pass("Click the Search button");
		} catch (AssertionError|Exception e) {
			testStepHandle("FAIL", driver, logInfo,e);
		}		
		
		driver.quit();
		
	}
	
	

}
