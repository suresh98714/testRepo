package browserUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public static WebDriver openBrowser(WebDriver driver, String browserName, String url) throws InterruptedException{
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			Thread.sleep(5000);
			return driver;
		}else {
			if (browserName.equalsIgnoreCase("IE")) {
				WebDriverManager.iedriver().setup();
				driver=new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.get(url);
				return driver;				
			}
		}
		return null;
	}
	

}
