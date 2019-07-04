package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features={"src/main/resources/Features/"},
		glue={"stepDefinitions"},
		tags={"@googlesearch,@GlobalSearch"},
		plugin={"pretty","html:tagret/site/cucumber-pretty",
				"json:target/cucumber.json"},
		monochrome=true)
public class TestRunner {
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun=true)
	public void setupClass(){
		testNGCucumberRunner=new TestNGCucumberRunner(this.getClass());
		
	}
	@Test(dataProvider="features")
	public void feature(PickleEventWrapper eventWrapper,CucumberFeatureWrapper cucumberFeature) throws Throwable{
		//testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		testNGCucumberRunner.runScenario(eventWrapper.getPickleEvent());
	}
	
	
	@DataProvider(parallel=true)
	public Object[][] features(){
		//return testNGCucumberRunner.provideFeatures();
		return testNGCucumberRunner.provideScenarios();
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDownClass(){
		testNGCucumberRunner.finish();
		
	}
	
	@BeforeSuite
	public void beforesute(){
		System.out.println("This is Before suite section");
	}


}
