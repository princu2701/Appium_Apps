package NativeApps;

//Add Static Import

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

//Add element import

import static io.appium.java_client.touch.offset.ElementOption.element;

//Add import for time  

import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

//=================

public class apidemos extends capabilities {

	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void bt() throws MalformedURLException {

		driver = cap();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test

	public void test1() {

		System.out.println("Api Done");

		driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();

		driver.findElement(MobileBy.AccessibilityId("Accessibility Node Provider")).click();

	}

	@Test

	public void preference() {

		// To use text in appium

		// We will need two things => Android Ui Automator and UiSelector

		driver.findElement(MobileBy.AccessibilityId("Preference")).click();

		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();

		driver.findElement(MobileBy.id("android:id/checkbox")).click();

		// Now we will use text and for using text we need AndroidUiAutomator and
		// UiSelector

		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"WiFi settings\")")).click();

		driver.findElement(MobileBy.id("android:id/edit")).sendKeys("Prince Raj");

		driver.hideKeyboard();

		driver.findElement(MobileBy.id("android:id/button2")).click();

		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}

	@Test

	public void notifications() {

		driver.openNotifications();

		// To click on options Battery Saver in Notifications we use

		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();

		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();

		// To go to homepage after clicking on battery saver option

		driver.pressKey(new KeyEvent(AndroidKey.HOME));

	}

	@Test

	public void scrolls() {

		// If we want to scroll we need three things

		// 1 -> ui scrollable, ui Selector, scrollintoview

		// Click on view button

		driver.findElement(MobileBy.AccessibilityId("Views")).click();

		// Now we will Scroll and click to view button

		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"))
				.click();

	}

	@Test

	public void longpress() {

		driver.findElement(MobileBy.AccessibilityId("Views")).click();

		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();

		driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();

		AndroidElement Cat = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Cat Names\")"));

		// Long press will now do using touch actions

		TouchAction tAction = new TouchAction(driver);

		// First we have to import static and longpress options

		tAction.longPress(longPressOptions().withElement(element(Cat)).withDuration(ofSeconds(3))).release().perform();

		// Swiping and Dragging Dropping

	}

	@Test

	public void swipe() {

		driver.findElement(MobileBy.AccessibilityId("Views")).click();

		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();

		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();

		AndroidElement ele1 = driver.findElement(MobileBy.AccessibilityId("12"));

		AndroidElement ele2 = driver.findElement(MobileBy.AccessibilityId("5"));

		// Drag and Drop using Touch Actions

		TouchAction tAction = new TouchAction(driver);

		// Use longpress for Drag and Drop also using Touch Actions

		tAction.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3)))
				.moveTo(element(ele2)).release().perform();

	}

	// Steps for Drag and Drop

	// Launch app

	// views

	// Do drag drop

	// Use touchActions

	@Test

	public void switchapps() {

		// To Os - Sms Messaging

		// Click on three dots and click on phone to get number

		// Enter Data and Send

		// Go to messaging app and checking

		driver.findElement(MobileBy.AccessibilityId("OS")).click();

		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();

		driver.findElement(MobileBy.AccessibilityId("Enable SMS broadcast receiver")).click();

		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650) 555-1212");

		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("Hii");

		driver.hideKeyboard();

		driver.findElement(MobileBy.AccessibilityId("Send")).click();

		// Use activate app for switching

		driver.activateApp("com.google.android.apps.messaging");

		String msg = driver.findElement(MobileBy.id("")).getText();

		System.out.println(msg);

		// Switching back to apiDemos

		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));

		// Performing double app switch so that we can move to recent last app used

		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));

		driver.pressKey(new KeyEvent(AndroidKey.HOME));

		System.out.println("Native Apps Done");

	}
//	
//	@Test 
//	
//	public void self() {
//		
//	}

}
