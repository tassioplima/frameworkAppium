package br.ce.tassio.appium.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	@AfterClass
	public static void finalyClass() {
		
		DriverFactory.killDriver();
		
	}

	@After
	public void tearDown() {
		gerateScreeShot();
		DriverFactory.getDriver().resetApp();

	}
	
	public void gerateScreeShot() {
		File screenshotAs = ((TakesScreenshot)  DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotAs, new File ("target/screenshot/imagem.png") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
