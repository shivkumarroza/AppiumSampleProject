package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;

public abstract class BaseTest implements IAutoConst {
	public AppiumDriver<WebElement> driver;
	
	@BeforeMethod
	public void launchApplication() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "MI");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", "com.qspiders");
		cap.setCapability("appActivity", "com.qspiders.MainActivity");
		String baseURL=AutoUtil.getProperty(CONFIG_PATH, "baseURL");
		try {
			driver=new AppiumDriver<>(new URL(baseURL), cap);
		} catch (MalformedURLException e) {
			
		}
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeApplication(ITestResult r) {
		String testName=r.getName();
		int status=r.getStatus();
		if(status==2)
		{
			AutoUtil.getScreenshot(driver, PHOT_PATH, testName);
		}
		driver.closeApp();
		
	}
}
