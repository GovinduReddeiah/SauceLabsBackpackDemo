package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement loginButton;
	
	@FindBy(css = "div.error")
	WebElement errorMessage;

	public productPage login(String UName, String Pswd, String url) {
		driver.get(url);
		userName.sendKeys(UName);
		password.sendKeys(Pswd);
		loginButton.click();
		return new productPage(driver);
	}
	
	public String InvalidLogin(String UName, String Pswd, String url) {
		driver.get(url);
		userName.sendKeys(UName);
		password.sendKeys(Pswd);
		loginButton.click();
		String ErrorMessage = errorMessage.getText();
		return ErrorMessage;
	}
}
