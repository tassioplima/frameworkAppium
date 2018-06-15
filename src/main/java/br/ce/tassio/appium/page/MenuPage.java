package br.ce.tassio.appium.page;

import org.openqa.selenium.By;

import br.ce.tassio.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuPage extends BasePage {
	
	@AndroidFindBy(xpath = "//*[@text='Formulário']")
	private MobileElement acessarFormularioFactory;
	
	public MobileElement getAcessarFormularioFactory() {
		return acessarFormularioFactory;
	}

	public void acessarFormulario() {
		
		clickElement(By.xpath("//*[@text='Formulário']"));
	}
	
	public void acessarSplash() {
		
		getElement("//*[@text='Splash']").click();;
		
	}
	
	public void acessarAlerta() {
		
		getElement("//*[@text='Alerta']").click();;
		
	}

}
