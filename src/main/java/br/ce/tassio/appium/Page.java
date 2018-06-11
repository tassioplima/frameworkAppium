package br.ce.tassio.appium;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Page {
	
	protected AndroidDriver<MobileElement> driver;
	
	public Page() {
		super();
		this.driver = driver;
	}

	public MobileElement getElement (String xpath) {
		
		MobileElement element = (MobileElement) driver.findElement(By.xpath(xpath));
		
		return element;

	}
	
	
	
}
