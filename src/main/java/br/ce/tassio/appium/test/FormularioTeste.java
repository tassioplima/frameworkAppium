package br.ce.tassio.appium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import br.ce.tassio.appium.core.BaseTest;
import br.ce.tassio.appium.page.FormularioPage;
import br.ce.tassio.appium.page.MenuPage;

public class FormularioTeste extends BaseTest {
	
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
	
	@Test
	public void validaNome() {
		
		formulario.writeName("nome", "José Pedro");
		formulario.saveData();
		String retornoNome = formulario.returnTextName();
		
		assertEquals("Nome: José Pedro", retornoNome);
	}	
	
}