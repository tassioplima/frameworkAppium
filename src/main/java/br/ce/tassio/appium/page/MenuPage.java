package br.ce.tassio.appium.page;

import org.openqa.selenium.By;

import br.ce.tassio.appium.core.DSL;

public class MenuPage {
	
	private DSL dsl = new DSL();
	
	public void acessarFormulario() {
		
		dsl.clickElement(By.xpath("//*[@text='Formulário']"));
	}

}
