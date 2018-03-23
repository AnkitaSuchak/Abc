/*
 *seek bar in apk demo app 
 */
package practiceApps;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SeekingBar extends ApkDemoApp {

	public static void main(String args[]) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = launchApp();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		AndroidElement animation = driver.findElementByXPath("//android.widget.TextView[@text='Animation']");
		animation.click();

		AndroidElement seeking = driver.findElementByXPath("//android.widget.TextView[@text='Seeking']");
		seeking.click();

		AndroidElement seekBar = driver.findElementByXPath("//android.widget.SeekBar");
		
		int startX = seekBar.getLocation().getX();
		int endX = seekBar.getSize().getWidth();

		int startY = seekBar.getLocation().getY();
		int endY = seekBar.getSize().getHeight();

		//System.out.println(startX+"\n"+endX+"\n"+startY+"\n"+endY);
		
		TouchAction action = new TouchAction(driver);
		action.press(startX, startY).moveTo(endX-100, endY+startY).release().perform();
	}
}
