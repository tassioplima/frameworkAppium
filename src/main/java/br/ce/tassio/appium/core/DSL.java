package br.ce.tassio.appium.core;

import static br.ce.tassio.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class DSL {

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
		getDriver().findElement(By.xpath("//*[@text='"+texto+"']")).click();
		
	}
	
	public void selectCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clickText(valor);
	}
	
	
	public void getElement(String xpath) {
		
		getDriver().findElement(By.xpath(xpath));
		
	}
	
	
}
