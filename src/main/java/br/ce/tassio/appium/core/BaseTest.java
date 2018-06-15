package br.ce.tassio.appium.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	

	@After
	public void tearDown() {
		gerateScreenShot();
		DriverFactory.getDriver().resetApp();

	}
	
	@AfterClass
	public static void finalyClass() {
		
		DriverFactory.killDriver();
		
	}
	
	public void gerateScreenShot() {
		File screenshotAs = ((TakesScreenshot)  DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotAs, new File ("target/screenshot/" + testName.getMethodName() +".png") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
