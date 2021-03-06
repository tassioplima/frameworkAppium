package utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {

	private static DesiredCapabilities  cap;

	public AppiumServiceBuilder builder;

	public AppiumDriverLocalService service;

	public void startServer() {

		cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.FULL_RESET, true);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		cap.setCapability(MobileCapabilityType.APP, ".\\resources\\CTAppium-1-1.apk");
		

		builder = new AppiumServiceBuilder().withCapabilities(cap);

		service = builder.build();

		service.start();

	}

	public void stopServer() {

		service.stop();
	}
	
	
	
	

}
