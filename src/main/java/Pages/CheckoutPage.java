package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Scrolls;

public class CheckoutPage {
	
	WebDriver driver ;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first-name")
	WebElement FName_InputField;
	
	@FindBy(id="last-name")
	WebElement LName_InputFiled;
	
	@FindBy(id="postal-code")
	WebElement PostalCode_InputFiled;
	
	@FindBy(id="continue")
	WebElement CheckOutToOverview;


	public OrderPlacingPage Checkout(String Fname, String LName, String PostalCode) {
		FName_InputField.sendKeys(Fname);
		LName_InputFiled.sendKeys(LName);
		PostalCode_InputFiled.sendKeys(PostalCode);
		Scrolls scrolls = new Scrolls(driver);
		scrolls.Scroll();
		CheckOutToOverview.click();
		return new OrderPlacingPage(driver);
	}

}
