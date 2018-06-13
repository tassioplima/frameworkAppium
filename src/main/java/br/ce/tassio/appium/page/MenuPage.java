package br.ce.tassio.appium.page;

import org.openqa.selenium.By;

import br.ce.tassio.appium.core.BasePage;

public class MenuPage extends BasePage {
	
	
	public void acessarFormulario() {
		
		clickElement(By.xpath("//*[@text='Formulário']"));
	}

}
