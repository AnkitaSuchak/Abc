/**
 * task 3
 * 1. Open api demo app
	2. tap on Views
	3. Scroll until WebView is visible
	4. Click on WebView
 */
package practiceApps;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WebView extends ApkDemoApp {

	public static void main(String args[]) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = launchApp();

		// driver.findElementByAndroidUIAutomator("new UiScrollable(new
		// UiSelector()).scrollIntoView(text(\"Views\"));").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AndroidElement views = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		views.click();

		AndroidElement webView = driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
		webView.click();

	}
}
