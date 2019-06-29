package extentReports;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports {
	
	public static ExtentHtmlReporter report=null;
	public static ExtentReports extent=null;
	public static ExtentTest test=null;
	
	public ExtentReports setUp(){
		String reportLocation="./Reports/Extent_Report.html";
		report=new ExtentHtmlReporter(reportLocation);
		report.config().setDocumentTitle("Automation Test Report");
		report.config().setReportName("Cucumber Dummy Project Report");
		report.config().setTheme(Theme.STANDARD);
		System.out.println("Extent Report location initialized");
		report.start();
		
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Application", "Google/Yahoo/Wiki search");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		System.out.println("System Info set in Extent Report");
		return extent;
		
	}
	
	public static void testStepHandle(String teststatus,WebDriver driver, ExtentTest extenttest, Throwable throwable){
	
		switch (teststatus) {
		case "FAIL":
			extenttest.fail(MarkupHelper.createLabel("Test Case is Failed: ", ExtentColor.RED));
			extenttest.error(throwable.fillInStackTrace());
			try {
				extenttest.addScreenCaptureFromPath(captureScreenshot(driver));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (driver!=null) {
				driver.quit();				
			}			
			break;
		case "PASS":
			extenttest.pass(MarkupHelper.createLabel("Test case is Passed: ", ExtentColor.GREEN));
			break;
		default:
			break;
		}
	}
	
	public static String captureScreenshot(WebDriver driver) throws IOException{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"\\screenshots\\" +getcurrentDateTime()+".jpg";
		File target=new File(dest);
		FileUtils.copyFile(source, target);
		return dest;
	}
		
	private static String getcurrentDateTime(){
		String str=null;
		try {
			DateFormat dateformat=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date=new Date();
			str=dateformat.format(date);
			str=str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
			
		} catch (Exception e) {
			
		}
		 return str;
	}
	

}
