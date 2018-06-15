package br.ce.tassio.appium.test;

import org.junit.Before;
import org.junit.Test;

import br.ce.tassio.appium.core.BaseTest;
import br.ce.tassio.appium.page.MenuPage;
import br.ce.tassio.appium.page.SplashPage;

public class SplashTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage splash = new SplashPage();
	
	@Before
	public void iniciarTeste() {
		menu.acessarSplash();
	}
	
	@Test
	public void deveAguardarSplashSumir() {
		
		splash.elementSplash();
		
	}
	

}
