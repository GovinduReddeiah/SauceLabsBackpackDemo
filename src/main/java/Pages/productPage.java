package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class productPage {

	WebDriver driver;

	public productPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement product;
	@FindBy(xpath = "//a//span")
	WebElement noOfProducts;
	@FindBy(css = ".shopping_cart_link")
	WebElement cartIcon;
	@FindBy(css = "#checkout")
	WebElement checkout;

	public CheckoutPage SelectProduct() {
		product.click();
		String num = noOfProducts.getText();
		int Nnum = Integer.parseInt(num);
		Assert.assertEquals(Nnum, 1);
		cartIcon.click();
		checkout.click();
		return new CheckoutPage(driver);
	}

}
