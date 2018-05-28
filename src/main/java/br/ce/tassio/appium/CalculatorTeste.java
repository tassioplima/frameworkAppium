package br.ce.tassio.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorTeste {
	
	
	
	@Test
	public void deveSomar() throws MalformedURLException {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
	    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    
		
	    MobileElement el6 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_1");
	    el6.click();
	    MobileElement el7 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
	    el7.click();
	    MobileElement el8 = (MobileElement) driver.findElementByAccessibilityId("plus");
	    el8.click();
	    MobileElement el9 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_1");
	    el9.click();
	    MobileElement el10 = (MobileElement) driver.findElementByAccessibilityId("equals");
	    el10.click();
	    MobileElement el11 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
	    Assert.assertEquals("13", el11.getText());
	    
	    
	    /*if (el11.equals("13")) {
		}
	    else{
	    	System.out.println("Erro no teste");
	    }*/
	    
	    driver.quit();
	    
	}
	
	

}
