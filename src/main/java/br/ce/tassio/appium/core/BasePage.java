package br.ce.tassio.appium.core;

import static br.ce.tassio.appium.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

public class BasePage {
	
	public BasePage () {
		
	}
	
	public void writeElement(By by, String texto) {
		
		getDriver().findElement(by).sendKeys(texto);;
	}
	
	public String getText(By by) {
		
		String text = getDriver().findElement(by).getText();
		return text;
	}
	
	public void clickElement(By by) {
		
		getDriver().findElement(by).click();
		
	}
	
	public void clickText(String texto) {
		getDriver().findElement(By.xpath("//*[contains(@text,'"+texto+"')]")).click();
		
	}
	
	public void selectCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clickText(valor);
	}
	
	
	public MobileElement getElement(String xpath) {
		
		return getDriver().findElement(By.xpath(xpath));
		
	}
	
	public boolean isCheckedMarked(By by) {
		
		return getDriver().findElement(by).getAttribute("checked").equals("true");
		
	}
	
	public boolean isCheckedUnMakerd(By by) {
		
		return getDriver().findElement(by).getAttribute("checked").equals(false);
		
	}
	
	public boolean elementIsVisible(String texto) {
		
		List<MobileElement> findElements = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		return findElements.size() > 0;
		
		
	}

}
