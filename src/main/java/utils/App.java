package br.com.userede.fv.mobile.bean.enums;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.userede.fv.mobile.bean.interfaces.MobileApplication;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobilePlatform;

/**
 * 
 * @author Filipe Mapelli Siqueira
 * @since 2018-02-08
 *
 */
public enum App implements MobileApplication{

	COCKPIT {

		@Override
		public AndroidDriver<WebElement> getDriver() {
			return getDriver("br.com.userede.cockpit");
		}

	},

	ACELERA {

		@Override
		public AndroidDriver<WebElement> getDriver() {
			return getDriver("br.com.userede.acelera");
		}

	};

	private AndroidDriver<WebElement> driver;

	/**
	 * Retorna {@code AndroidDriver} para o aplicativo.
	 * 
	 * @param appPackage
	 * @return {@link AndroidDriver}
	 */
	public AndroidDriver<WebElement> getDriver(String appPackage) {

		//startAppium();
		try {
			// URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver<WebElement>(getCapabilities(appPackage));
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return driver;
	}

	/**
	 * Retorna {@code DesiredCapabilities}
	 * 
	 * @param appPackage
	 * @return {@link DesiredCapabilities}
	 * @throws IOException
	 */
	private DesiredCapabilities getCapabilities(String appPackage) throws IOException {

		Scanner scanner = null;
		scanner = new Scanner(Runtime.getRuntime().exec(new String[] { "/bin/bash", "-l", "-c", "adb get-serialno" })
				.getInputStream());
		String deviceSerialNumver = (scanner != null && scanner.hasNext()) ? scanner.next() : "";
		scanner.close();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Galaxy");
		capabilities.setCapability("platformName", MobilePlatform.ANDROID);
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("udid", deviceSerialNumver);
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", "MainActivity_");

		return capabilities;

	}

}
