package script;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import screen.LoginScreen;

public class AppTest extends BaseTest {
	@Test
	public void testLogin() {
		String userName=Excel.getData(XL_PATH, "Sheet1", 0, 0);
		String password=Excel.getData(XL_PATH, "Sheet1", 0, 1);
		LoginScreen l=new LoginScreen(driver);
		driver.findElement(By.xpath("(//android.widget.Spinner[@class='android.widget.Spinner'])[2]")).click();
		driver.findElement(By.xpath("//*[@text='Login ']")).click();
		l.setUserName(userName);
		l.setPassword(password);
		l.clickLogin();
	}
}
