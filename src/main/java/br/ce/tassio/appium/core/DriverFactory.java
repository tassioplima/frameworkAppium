package br.ce.tassio.appium.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static  AndroidDriver<MobileElement> driver; 

	public static AndroidDriver<MobileElement>getDriver() {
		if (driver == null) {
			createDriver();
		}
		return driver;
	}


	private static void createDriver() {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.FULL_RESET, true);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		cap.setCapability(MobileCapabilityType.APP, ".\\resources\\CTAppium-1-1.apk");

		driver = new AndroidDriver<MobileElement>(cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void killDriver() {

		if (driver != null) {
			driver.quit();
			driver = null;

		}
	}

}
