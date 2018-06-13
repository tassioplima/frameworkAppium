package utils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AppServer {
	
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
		String deviceSerialNumber = (scanner != null && scanner.hasNext()) ? scanner.next() : "";
		scanner.close();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Device");
		capabilities.setCapability("platformName", MobilePlatform.ANDROID);
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("udid", deviceSerialNumber);
		//capabilities.setCapability(MobileCapabilityType.APP, value);
		//capabilities.setCapability("appPackage", appPackage);
		//capabilities.setCapability("appActivity", "MainActivity_");

		return capabilities;

	}

}
