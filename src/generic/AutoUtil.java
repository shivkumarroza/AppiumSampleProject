package generic;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class AutoUtil {

		public static String getProperty(String path, String key)
		{	String value="";
			try {
			Properties p= new Properties();
			p.load(new FileReader(IAutoConst.CONFIG_PATH));
			value=p.getProperty(key);
			}catch(Exception e) {}
			return value;
		}
		
		public static void getScreenshot(AppiumDriver<WebElement> driver,String folder,String testName)
		{
			Date d= new Date();
			String sDate=d.toString();
			String dateTime=sDate.replaceAll(":", "_");
			String path=folder+testName+dateTime+".png";
			TakesScreenshot t=(TakesScreenshot)driver;
			File srcFile=t.getScreenshotAs(OutputType.FILE);
			File destiFile=new File(path);
			try {
				FileUtils.copyFile(srcFile, destiFile);
			} catch (IOException e) {
			}
		}
}
