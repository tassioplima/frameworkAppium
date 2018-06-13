package br.ce.tassio.appium.core;

import java.io.IOException;
import java.util.Scanner;
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
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(Runtime.getRuntime().exec(new String[] { "cmd.exe","/c","start", "adb get-serialno"})
					.getInputStream());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String deviceSerialNumber = (scanner != null && scanner.hasNext()) ? scanner.next() : "";
		scanner.close();

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceSerialNumber);
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
	
	
	private String returnDeviceName() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(Runtime.getRuntime().exec(new String[] { "cmd /c dir", "adb get-serialno" })
					.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String deviceSerialNumber = (scanner != null && scanner.hasNext()) ? scanner.next() : "";
		scanner.close();
		return deviceSerialNumber;
	}

}
