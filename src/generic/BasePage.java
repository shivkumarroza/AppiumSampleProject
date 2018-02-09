package generic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;

public class BasePage {
	public static void verifyPageIsDisplayed(AppiumDriver<WebElement> driver, String eResult)
	{
		String sETO=AutoUtil.getProperty(IAutoConst.CONFIG_PATH, "ETO");
		long ETO=Long.parseLong(sETO);
		WebDriverWait wait = new WebDriverWait(driver, ETO);
		try {
				String aResult = driver.getTitle();
				if(aResult.equals(eResult))
				{
					Reporter.log("PASS: The specified page is Displayed");
				}
				else
				{
					Reporter.log("PASS: The specified page is NOT Displayed");
					Assert.fail();
				}
		}catch(Exception e) {}
	}
	
	public void verifyText(WebElement e, String etext)
	{
		String aText=e.getText();
		Assert.assertEquals(aText, etext);
	}
}
