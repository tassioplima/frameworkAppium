package server;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TesteSevidorAppiumClasse {
	
	private static DesiredCapabilities cap;

	public static void main(String[] args) throws InterruptedException {
		
		cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.FULL_RESET, true);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
	    cap.setCapability(MobileCapabilityType.APP, ".\\resources\\CTAppium-1-1.apk");
	    
		
		
		AppiumServiceBuilder builder = new AppiumServiceBuilder().withCapabilities(cap);
		
		AppiumDriverLocalService service = builder.build();
		
		service.start();
		
		 AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(cap);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();
		
		Thread.sleep(300);
		
		service.stop();
	
	}
}
