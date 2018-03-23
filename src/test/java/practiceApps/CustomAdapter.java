/**
 * task 5: 
1. open app
2. click on views
3. click on expandable lists
4. custom adapter
5. long press people names
 */
package practiceApps;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CustomAdapter extends ApkDemoApp{
	
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = launchApp();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AndroidElement views = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		views.click();
		
		AndroidElement expandableList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		expandableList.click();
		
		AndroidElement customAdapter = driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");
		customAdapter.click();
		
		AndroidElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		TouchAction action = new TouchAction(driver);
		action.longPress(peopleNames).perform();
		
		driver.quit();
	}

}
