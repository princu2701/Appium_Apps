package Milestones;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import MileStones.first;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class firstapi extends first {

	AndroidDriver<AndroidElement> driver;

	@BeforeTest

	public void start() throws MalformedURLException {

		driver = miles();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test

	public void testself() throws InterruptedException {

		Thread.sleep(2000);

		driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();

		driver.findElement(MobileBy.AccessibilityId("Custom View")).click();
	}

}
