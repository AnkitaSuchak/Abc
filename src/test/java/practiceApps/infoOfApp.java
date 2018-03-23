/**
task 4:
1. open app
2. print current activity name
3. print orientation of the app
4. check if phone is locked or not
5. print context of the view(if the view is native, hybrid or webview)
 */
package practiceApps;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class infoOfApp extends ApkDemoApp {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = launchApp();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("current activity name: "+driver.currentActivity()+"\norientation of application: "+driver.getOrientation());
		
		if(driver.isLocked()) {
			System.out.println("phone is locked");
		}
		else {
			System.out.println("phone is unlocked");
		}
		System.out.println(driver.getContext());
		
		driver.quit();
	}
}
