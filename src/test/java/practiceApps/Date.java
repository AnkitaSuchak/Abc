/**
 * Task1 for appium: 
1. open api demos app
2. click on views
3. click on date widgets
4. click on inline
5. swipe hour hand from 3 PM to 9 PM
 */
package practiceApps;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Date  extends ApkDemoApp{

	public static void main(String args[]) throws MalformedURLException{
		AndroidDriver<AndroidElement> driver=launchApp();
		
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AndroidElement views = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		views.click();
		
		
		AndroidElement date = driver.findElementByXPath("//android.widget.TextView[contains(@text,'Date')]");
		date.click();
		
		
		
		AndroidElement inline =driver.findElementByXPath("//android.widget.TextView[contains(@text,'Inline')]");
		inline.click();
		
		AndroidElement hour =driver.findElementByXPath("//*[contains(@content-desc,'3')]");
		hour.click();
		
		AndroidElement minutes =driver.findElementByXPath("//*[contains(@content-desc,'45')]");
		minutes.click();
	}
}
