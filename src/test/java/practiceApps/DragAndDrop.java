/**
 * task 6: 
1. open app
2. click on views
3. click on drag and drop
4. drag first dot onto 3rd dot.
 */
package practiceApps;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DragAndDrop extends ApkDemoApp{
	
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = launchApp();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AndroidElement views = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		views.click();
		
		AndroidElement dragAndDrop = driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']");
		dragAndDrop.click();
		
		AndroidElement firstDrag = driver.findElementByXPath("//android.view.View[@index='1']");
		
		
		AndroidElement thirdDrop = driver.findElementByXPath("//android.view.View[@index='4']");
		
		TouchAction action = new TouchAction(driver);
		action.longPress(firstDrag).moveTo(thirdDrop).release().perform();
		
		driver.quit();
		
	}

}
