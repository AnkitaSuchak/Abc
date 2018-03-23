package practiceApps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebBrowser {
	
	static URL url;
	static AndroidDriver<AndroidElement> driver;

	public static void main(String[] args) throws MalformedURLException {
		
		driver = Capabilities();
		//driver.get("http://google.com/");
		

		// stores web elements
		WebElement partialLinkTest, linkTest, firstName, lastName, sex, experience, date, profession, automationTool,
				continents, button;

		// stores list of selenium commands' options
		List<AndroidElement> seleniumCommands;

		// set property of chrome driver path
		// System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

		
		// launch the website
		driver.get("http://toolsqa.com/automation-practice-form/");

		// maximize the window
		//driver.manage().window().maximize();

		// partial link test using partial link text locator strategy
		partialLinkTest = driver.findElement(By.partialLinkText("Partial"));

		// link test using link text locator strategy
		linkTest = driver.findElement(By.linkText("Link Test"));

		// first name using name locator strategy
		firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("ankita");

		// close the browser
		driver.quit();
		
	}

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {

		url = new URL("http://127.0.0.1:4723/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus5");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		driver = new AndroidDriver<>(url, cap);
		return driver;
	}
}
