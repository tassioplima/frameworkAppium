package utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {

	private static DesiredCapabilities  cap;

	public AppiumServiceBuilder builder;

	public AppiumDriverLocalService service;

	protected AndroidDriver<MobileElement> driver;

	public AppiumServer() {
		super();
		this.driver = new AndroidDriver<MobileElement>(cap);
		cap = new DesiredCapabilities();
		builder = new AppiumServiceBuilder().withCapabilities(cap);

	}


	public void startServer() {

		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.FULL_RESET, true);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		cap.setCapability(MobileCapabilityType.APP, ".\\resources\\CTAppium-1-1.apk");


		service = builder.build();

		service.start();

	}

	public void stopServer() {

		service.stop();
	}



}
