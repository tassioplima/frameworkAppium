package br.ce.tassio.appium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Page {
	
	public AndroidDriver<MobileElement> driver;
	
	public Page(AndroidDriver<MobileElement> driver) {
		super();
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public MobileElement getElement (String xpath) {
		
		MobileElement element = driver.findElement(By.xpath(xpath));
		
		return element;

	}
	
	
	
}
