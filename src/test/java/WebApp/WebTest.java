package WebApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WebTest extends CapWeb {

	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setup() throws MalformedURLException {

		driver = web();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test

	public void web1() {

		System.out.println("Web Apps Started");

		driver.get("https://www.google.com/");

		driver.findElement(MobileBy.cssSelector("[class='gLFyf']")).sendKeys("Masai", Keys.ENTER);

	}

}
