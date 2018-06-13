package br.ce.tassio.appium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.tassio.appium.core.DSL;
import br.ce.tassio.appium.core.DriverFactory;
import br.ce.tassio.appium.page.FormularioPage;
import br.ce.tassio.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class FormularioTeste  {
	
	
	private AndroidDriver<MobileElement> driver; 
	private DSL dsl = new DSL();
	private MenuPage menu = new MenuPage();
	private FormularioPage formulario = new FormularioPage();
	
	@Before
	public void inicializarAppium() {

		menu.acessarFormulario();
		
	}




	@Test
	public void desafioCadastro() throws MalformedURLException{
		
		formulario.writeName("nome", "Tassio");
		
		formulario.selectComboConsole("XBox One");
		
		formulario.selectCheckBox().click();
		formulario.selectSwitch().click();
		
		formulario.saveData();
		
		String retornoNome = formulario.returnTextName();
		
		String retornoValoresConsole = formulario.returnValueConsole();
		
		String retornoSwitch = formulario.returnValueSwith();
		String retornoCheckBox = formulario.returnValueCheckBox();
		
		//Asserts
		assertEquals("Nome: Tassio", retornoNome);
		
		assertEquals("Console: xone", retornoValoresConsole);

		assertEquals("Switch: Off", retornoSwitch);
		assertEquals("Checkbox: Marcado", retornoCheckBox);
		
		formulario.clearData();
		
	}

	@After
	public void tearDown() {

		DriverFactory.killDriver();

	}
	
	
}