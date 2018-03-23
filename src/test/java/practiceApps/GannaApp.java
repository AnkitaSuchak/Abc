/**
 * 1. install gaana.com app
2. search for a song: "Dhinka chika Dhinka chika a a a a"
3. play the first song(complete)
4. play it again
5. pause after 2 min.
6. change audio quality
7. Turn vol to 70%
 */
package practiceApps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class GannaApp {
	static String path;
	static URL url;
	static WebDriverWait wait;

	public static AndroidDriver<AndroidElement> launchApp() throws MalformedURLException {

		path = System.getProperty("user.dir") + "\\src\\test\\resources\\apks\\GaanaMusic.apk";
		url = new URL("http://127.0.0.1:4723/wd/hub");
		// System.out.println(path);

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus5");
		dc.setCapability(MobileCapabilityType.APP, path);
		// System.out.println(dc);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url, dc);

		return driver;

	}

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = launchApp();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		AndroidElement allowAccess = driver.findElementByXPath("//android.widget.Button[@text='ALLOW']");
		allowAccess.click();

		// AndroidElement selectLanguage =
		// driver.findElementByXPath("//android.widget.TextView[contains(@text,'Hindi')]");
		// selectLanguage.click();

		AndroidElement getStart = driver.findElementByXPath("//android.widget.Button[@text='GET STARTED']");
		getStart.click();

		AndroidElement skipLogin = driver.findElementByXPath("//android.widget.TextView[@text='SKIP']");
		skipLogin.click();
		skipLogin.click();

		AndroidElement search = driver.findElementByXPath("//android.widget.TextView[@text = 'Search']");
		search.click();

		AndroidElement searchSong = driver.findElementByXPath("//android.widget.EditText[@resource-id = 'com.gaana:id/search_src_text']");
		searchSong.sendKeys("Dhinka chika Dhinka chika a a a a");
	}
}
