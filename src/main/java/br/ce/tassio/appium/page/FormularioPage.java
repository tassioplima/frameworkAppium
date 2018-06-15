package br.ce.tassio.appium.page;

import org.openqa.selenium.WebElement;

import br.ce.tassio.appium.core.BasePage;
import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage {


	public void writeName(String id, String nome) {

		writeElement(MobileBy.AccessibilityId(id), nome);

	}

	public String getNome() {
		return getText(MobileBy.AccessibilityId("nome"));


	}

	public void selectComboConsole(String valor) {

		selectCombo(MobileBy.AccessibilityId("console"), valor);
	}

	public WebElement selectCheckBox() {

		return getElement("//android.widget.CheckBox");

	}

	public WebElement selectSwitch() {

		return getElement("//android.widget.Switch");


	}

	public void saveData() {

		getElement("//android.widget.TextView[@text='SALVAR']").click();
	}

	public void clearData() {

		getElement("//android.widget.TextView[@text='LIMPAR']").click();
	}

	public String returnTextName() {

		return getElement("//android.widget.TextView[@index='12']").getText();
	}

	public String returnValueConsole() {

		return getElement("//android.widget.TextView[@index='13']").getText();
	}

	public String returnValueSwith() {
		return getElement("//android.widget.TextView[@index='15']").getText();

	}

	public String returnValueCheckBox() {
		return getElement("//android.widget.TextView[@index='16']").getText();

	}
	
	public String returnDate() {
		return getElement("//android.widget.TextView[@index='17']").getText();
	}
	
	public String returnHour() {
		return getElement("//android.widget.TextView[@index='18']").getText();
		
	}
	
	public WebElement slowSave() {
		return getElement("//android.widget.TextView[@text='SALVAR DEMORADO']");
	}

}


