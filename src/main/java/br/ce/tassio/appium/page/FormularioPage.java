package br.ce.tassio.appium.page;

import org.openqa.selenium.WebElement;

import br.ce.tassio.appium.core.DSL;
import io.appium.java_client.MobileBy;

public class FormularioPage {

	private DSL dsl = new DSL();

	public void writeName(String id, String nome) {

		dsl.writeElement(MobileBy.AccessibilityId(id), nome);

	}

	public String getNome() {
		return dsl.getText(MobileBy.AccessibilityId("nome"));


	}

	public void selectComboConsole(String valor) {

		dsl.selectCombo(MobileBy.AccessibilityId("console"), valor);
	}

	public WebElement selectCheckBox() {

		return dsl.getElement("//android.widget.CheckBox");

	}

	public WebElement selectSwitch() {

		return dsl.getElement("//android.widget.Switch");


	}

	public void saveData() {

		dsl.getElement("//android.widget.TextView[@text='SALVAR']").click();
	}

	public void clearData() {

		dsl.getElement("//android.widget.TextView[@text='LIMPAR']").click();
	}

	public String returnTextName() {

		return dsl.getElement("//android.widget.TextView[@index='12']").getText();
	}

	public String returnValueConsole() {

		return dsl.getElement("//android.widget.TextView[@index='13']").getText();
	}

	public String returnValueSwith() {
		return dsl.getElement("//android.widget.TextView[@index='15']").getText();

	}

	public String returnValueCheckBox() {
		return dsl.getElement("//android.widget.TextView[@index='16']").getText();

	}
	
	public String returnDate() {
		return dsl.getElement("//android.widget.TextView[@index='17']").getText();
	}
	
	public String returnHour() {
		return dsl.getElement("//android.widget.TextView[@index='18']").getText();
		
	}

}


