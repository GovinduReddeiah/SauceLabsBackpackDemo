package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPlacingPage {
	
	WebDriver driver ;
	public OrderPlacingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="finish")
	WebElement PlacingOrderButton;
	
	
	
	public ConfirmationPage PlaceOrder() {
		PlacingOrderButton.click();
		return new ConfirmationPage(driver);
	}
	
	

}
