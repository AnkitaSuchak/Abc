/**
 * 
Task 2:
1. Open api demo app
2. tap on Preference
3. tap on preference dependencies
4. select the wifi checkbox
5. tap on wifi settings
6. enter text "hello world"
7. click on Ok.
 */
package practiceApps;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Wifi extends ApkDemoApp {

	public static void main(String args[]) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = launchApp();

		// driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));").click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AndroidElement preference = driver.findElementByXPath("//android.widget.TextView[@text='Preference']");
		preference.click();

		AndroidElement dependencies = driver.findElementByXPath("//android.widget.TextView[contains(@text,'Preference dependencies')]");
		dependencies.click();
		
		AndroidElement wifiCheckbox = driver.findElementByXPath("//android.widget.CheckBox");
		wifiCheckbox.click();

		AndroidElement wifi = driver.findElementByXPath("//android.widget.TextView[contains(@text,'WiFi settings')]");
		wifi.click();

		AndroidElement wifiText = driver.findElementByXPath("//android.widget.EditText[@resource-id='android:id/edit']");
		wifiText.clear();
		wifiText.sendKeys("Hello World");

		AndroidElement okButton = driver.findElementByXPath("//android.widget.Button");
		okButton.click();
	}
}