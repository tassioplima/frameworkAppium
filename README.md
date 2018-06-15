# frameworkAppium
Framework Mobile usando linguagem java - Em construção

<h3>Especificação:</h3>

Usando framework de teste <b>jUnit (4.12)</b>, controle de versionamento github, gerenciador de dependência maven, framework automação Appium com linguagem Java, IDE eclipse Neon.

<h3>Requisitos:</h3>

node.js: https://nodejs.org/en/download/

instalação do appium via npm inicialize o <b>node.js command prompt:</b> npm install -g appium@1.7.2


<h3>Customizações </h3>

Procuro um serial number de celular no adb (Windows):

	Scanner scanner = null;
		try {
			scanner = new Scanner(Runtime.getRuntime().exec(new String[] { "cmd.exe","/c", "adb get-serialno"})
					.getInputStream());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String deviceSerialNumber = (scanner != null && scanner.hasNext()) ? scanner.next() : "";
		scanner.close();

<h3>Capabilities: </h3>

Capabilities do appium para execução

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

<h3>Dependências:</h3>

		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>3.12.0</version>
		</dependency>


		<dependency>
			<groupId>io.appium</groupId>
			<artifactId>java-client</artifactId>
			<version>6.0.0</version>
		</dependency>


		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>
