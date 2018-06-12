package br.ce.tassio.appium;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.tassio.appium.core.DSL;
import br.ce.tassio.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class FormularioTeste  {
	
	
	private AndroidDriver<MobileElement> driver; 
	private DSL dsl = new DSL();
	
	
	@Before
	public void inicializarAppium() {
		
		driver = DriverFactory.getDriver();
		
	}




	@Test
	public void desafioCadastro() throws MalformedURLException{
		
		dsl.clickElement(By.xpath("//*[@text='Formulário']"));

		dsl.writeElement(MobileBy.AccessibilityId("nome"), "Tassio");
		
		dsl.selectCombo(MobileBy.AccessibilityId("console"), "Xbox One");
		
		dsl.clickElement(By.xpath("//android.widget.CheckBox"));
		
		dsl.clickElement(By.xpath("//android.widget.Switch"));
		
		dsl.clickElement(By.xpath("//android.widget.TextView[@text='SALVAR']"));
		
		String retornoNome = dsl.getText(By.xpath("//android.widget.TextView[@index='12']"));
		
		String retornoValoresConsole = dsl.getText(By.xpath("//android.widget.TextView[@index='13']"));
		
		String retornoSwitch = dsl.getText(By.xpath("//android.widget.TextView[@index='15']"));
		String retornoCheckBox = dsl.getText(By.xpath("//android.widget.TextView[@index='16']"));
		
		String data = dsl.getText(By.xpath("//android.widget.TextView[@index='17']"));
		String hora = dsl.getText(By.xpath("//android.widget.TextView[@index='18']"));
		
		dsl.clickElement(By.xpath("//android.widget.TextView[@text='LIMPAR']"));

		//Asserts
		assertEquals("Nome: Tassio", retornoNome);
		
		assertEquals("Console: xone", retornoValoresConsole);

		//assertEquals("On", getRetornoSwitch);
		assertEquals("Switch: Off", retornoSwitch);
		assertEquals("Checkbox: Marcado", retornoCheckBox);
		//assertEquals("Desabilitado", getCheckbox);

	}

	@After
	public void tearDown() {

		DriverFactory.killDriver();

	}
	
	
}