package practiceApps;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class ApkDemoApp {

	static String path;
	static URL url;
	static WebDriverWait wait;

	public static AndroidDriver<AndroidElement> launchApp() throws MalformedURLException {

		path = System.getProperty("user.dir") + "\\src\\test\\resources\\apks\\ApiDemos.apk";
		url = new URL("http://127.0.0.1:4723/wd/hub");
		//System.out.println(path);

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus5");
		dc.setCapability(MobileCapabilityType.APP, path);
		// System.out.println(dc);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, dc);
		//wait = new WebDriverWait(driver, 10);
		return driver;

	}
}
