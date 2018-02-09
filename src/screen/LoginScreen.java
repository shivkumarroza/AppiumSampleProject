package screen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class LoginScreen {
	@FindBy(xpath="//*[@text='Mobile number or Email']")
	private WebElement unTB;
	
	@FindBy(xpath="//*[@text='Password']")
	private WebElement passTB;
	
	@FindBy(id="edit-user-login-form-submit")
	private WebElement loginBTN;
	
	public LoginScreen(AppiumDriver<WebElement> driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String username)
	{
		unTB.sendKeys(username);
	}
	
	public void setPassword(String pass)
	{
		passTB.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		loginBTN.click();
	}

}
