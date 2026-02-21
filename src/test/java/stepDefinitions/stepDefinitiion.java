package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.CheckoutPage;
import Pages.ConfirmationPage;
import Pages.OrderPlacingPage;
import Pages.loginPage;
import Pages.productPage;
import Utils.ConfigFileReader;
import Utils.JsonFileReader;
import Utils.drivermanager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.databind.JsonNode;

public class stepDefinitiion {

	WebDriver driver = drivermanager.DriverInit();
	loginPage loginpage;
	productPage productPage;
	CheckoutPage checkOutPage;
	ConfirmationPage confirmationPage;
	String ErrorMessage;
	String ExpectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
	JsonNode user = JsonFileReader.getUsers();
	String username = user.get("UserName").asText();
	String password = user.get("Password").asText();
	String invalidUsername = user.get("invalidUserName").asText();
	String invalidpassword = user.get("inValidPassword").asText();
	
	
	
	
	@Given("I login as a standard user")
	public void login_with_UName_and_Password() throws IOException {
		loginpage = new loginPage(driver);
		String URL = ConfigFileReader.LoadPropertyFile("URL");
		productPage = loginpage.login(username, password, URL);

	}

	@When("I add “Sauce Labs Backpack” to the cart")
	public void i_added_SauceLabsBackpack_to_cat() {
		checkOutPage = productPage.SelectProduct();
	}

	@And("I checkout with valid customer details")
	public void i_checkout_with_valid_customer_details() {
		JsonNode checkOutData = JsonFileReader.getCheckoutData();
		String FName = checkOutData.get("Firstname").asText();
		String LName = checkOutData.get("LastName").asText();
		String PostalCode = checkOutData.get("PostalCode").asText();
		OrderPlacingPage orderPlacingPage = checkOutPage.Checkout(FName, LName, PostalCode);
		confirmationPage = orderPlacingPage.PlaceOrder();
	}

	@Then("I should see the order confirmation page")
	public void i_should_see_the_order_confirmation_page() {
		String ConfirmationText = confirmationPage.getConfirmationMessage();
		Assert.assertEquals(ConfirmationText, "Thank you for your order!");

	}
	
	@Given ("I attempt login with invalid credentials")
	public void i_attempt_login_with_invalid_credentials() throws IOException {
		loginpage = new loginPage(driver);
		String URL = ConfigFileReader.LoadPropertyFile("URL");
		ErrorMessage = loginpage.InvalidLogin(invalidUsername, invalidpassword, URL);
		
	}
	@Then("I should see an authentication error message")
	public void i_should_see_an_authentication_error_message() {
		Assert.assertEquals(ErrorMessage, ExpectedErrorMessage);
	}

}
