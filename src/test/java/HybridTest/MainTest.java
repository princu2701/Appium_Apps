package HybridTest;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import HybridApps.Hybrid;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.android.nativekey.AndroidKey;
//import io.appium.java_client.android.nativekey.KeyEvent;

public class MainTest extends Hybrid {

	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setup() throws MalformedURLException {
		driver = cap();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testShoppingCart() {

		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();

		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bahamas\"))"))
				.click();

		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Prince Raj");

		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0).click();

		driver.findElements(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).get(0).click();

		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		String price1 = driver.findElement(MobileBy.xpath("//*[@text='$160.97']")).getText();

		String price2 = driver.findElement(MobileBy.xpath("//*[@text='$120.0']")).getText();

		String totalString = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl"))
				.getText();

		price1 = price1.substring(1);

		price2 = price2.substring(1);

		totalString = totalString.substring(1);

		// Parse the prices as double
		double itemPrice1 = Double.parseDouble(price1);

		double itemPrice2 = Double.parseDouble(price2);

		double displayedTotal = Double.parseDouble(totalString);

		// Print individual item prices
		System.out.println("Price of item 1: " + itemPrice1);

		System.out.println("Price of item 2: " + itemPrice2);

		System.out.println("Displayed total: " + displayedTotal);

		double calculatedTotal = itemPrice1 + itemPrice2;

		System.out.println("Calculated total: " + calculatedTotal);

		if (calculatedTotal == displayedTotal) {
			System.out.println("The displayed total is correct.");
		} else {
			System.out.println("The displayed total is incorrect!");
		}

	}
}
