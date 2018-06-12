package server;

import java.io.IOException;
import java.net.ServerSocket;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServerJava {

	private AppiumDriverLocalService service;
	private AppiumServiceBuilder builder;
	private DesiredCapabilities cap;
	
	public AppiumServerJava() {
		cap = new DesiredCapabilities();
		builder = new AppiumServiceBuilder();
	}
	
	
	public void startServer() {
		
		String ip = "127.0.0.1";
		int port = 4723;
		//Set Capabilities
		cap.setCapability("noReset", "false");
		cap.setCapability("platformName", "Android");
	    cap.setCapability("deviceName", "emulator-5554");
	    cap.setCapability("automationName", "uiautomator2");
	    cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\Tassio\\Documents\\Trabalhos e Projetos\\Java\\frameworkAppium\\resources\\CTAppium-1-1.apk");
	    
	    
		//Build the Appium service
		builder.withIPAddress(ip);
		builder.usingPort(port);
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
		
		//Start the server with the builder
		service =  AppiumDriverLocalService.buildService(builder);	
		service.start();
	}
	
	public void stopServer() {
		service.stop();
	}

	public boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}	

	public static void main(String[] args) throws InterruptedException {
		AppiumServerJava appiumServer = new AppiumServerJava();
		
		
			appiumServer.startServer();
			Thread.sleep(100);
			appiumServer.stopServer();
	
		
	}
}