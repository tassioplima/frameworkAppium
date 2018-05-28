package br.ce.tassio.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

public class FormularioTeste {
	
	
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/Tassio/workspace/framewrokAppium/resources/CTAppium-1-1.apk");

	    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
	    elementosEncontrados.get(1).click();;
	    
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));   
	    campoNome.sendKeys("Tassio Lima");    
	    String text = campoNome.getText();
	    Assert.assertEquals("Tassio Lima", text);    
	    driver.quit();
	  
	}
	
	@Test
	public void deveInteragirComCombo() throws MalformedURLException {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/Tassio/workspace/framewrokAppium/resources/CTAppium-1-1.apk");

	    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();;    
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    driver.findElement(MobileBy.xpath("//android.widget.CheckedTextView[@text='XBox One']")).click();;
	    //driver.findElement(MobileBy.xpath("//android.widget.CheckedTextView[@text='PS4']"));
	    //driver.findElement(MobileBy.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']"));
	    
	    String text = driver.findElement(MobileBy.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    
	    Assert.assertEquals("XBox One", text);
	    driver.quit();
	  
	}
	
	@Test
	public void deveInteragirComSwitchCheckBox() throws MalformedURLException {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/Tassio/workspace/framewrokAppium/resources/CTAppium-1-1.apk");

	    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    
	    driver.findElement(By.xpath("//*[@text='Formulário']")).click();;
	    MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
	    MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
	    System.out.println("Valida botoes");
	    Assert.assertTrue(check.getAttribute("checked").equals("false"));
	    System.out.println("valida assert check");;
	    Assert.assertTrue(switc.getAttribute("checked").equals("true"));
	    System.out.println("valida assert switch");;
	    
	    check.click();
	    switc.click();
	    
	    Assert.assertFalse(check.getAttribute("checked").equals(false));
	    Assert.assertFalse(switc.getAttribute("checked").equals(true));
	    
	    driver.quit();
	  
	}

}
