package br.ce.tassio.appium.page;

import br.ce.tassio.appium.core.BaseTest;

public class SplashPage extends BaseTest{
	
	
	private MenuPage menu = new MenuPage();
	
	public boolean elementSplash() {
		
		return menu.elementIsVisible("Splash");
		
		}
	
	
}
