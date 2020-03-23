package com.cucumberFramework.stepdefinitions;

import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.AddToCartPage;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToCartPageStepDefinitions extends TestBase {

	AddToCartPage addtocartPage = new AddToCartPage(driver);
	WaitHelper waitHelper = new WaitHelper(driver);

	@Given("^I am on the Practice page URL \"([^\"]*)\"$")
	public void i_am_on_the_Practice_page_URL(String webLink) throws Throwable {
		driver.get(webLink);
		
	}

	@Then("^I click on Add to cart button and add first article in the cart$")
	public void click_on_Add_to_cart_button_add_first_article() throws Throwable {
		addtocartPage.clickAddToCart();
		addtocartPage.clickContinueShopping();
		
	}

	@Then("^I add another item into my cart$")
	public void add_another_item_into_my_cart() throws Throwable {
		
		addtocartPage.addSecondItemToCart();
		
		addtocartPage.proceedToCheckOut();
	}
	@Then("^I proceed to checkout$")
	public void proceed_to_checkout() throws Throwable {
		
		addtocartPage.nextProceedToCheckOut();
	}
	@Then("^I should see Sign In Page$")
	public void i_should_see_Sign_In_Page() throws Throwable {
		addtocartPage.emailaddress.isDisplayed();
	}
	@When("^I enter Email address as \"([^\"]*)\"$")
	public void enter_email_address_as(String arg1) throws Throwable {
		
		addtocartPage.enterEmailaddress(arg1);
	}
	@When("^I enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String arg1) throws Throwable {
		waitHelper.WaitForElement(addtocartPage.password, 60);
		addtocartPage.enterPassword(arg1);
	}
	@When("^click on signin button$")
	public void click_on_signin_button() throws Throwable {
		addtocartPage.clickSigninButton();
	}
	
	@Then("^I am signed in$")
	public void i_am_already_signed_in() throws Throwable {
		addtocartPage.signoutbutton.isDisplayed();
	}
	@When("^I click on Proceed to checkout$")
	public void I_click_on_Proceed_to_checkout() {
		addtocartPage.afterSigninProceedToCheckout();
	}
	@Then("^I click on I agree to Terms of service$")
	public void I_click_on_I_agree_to_Terms_of_service() {
		addtocartPage.termsOfService();
	
		addtocartPage.standardCheckOut();
	}
	@Then("^I select Payment method$")
	public void I_select_payment_method() {
		addtocartPage.paymentMethod();
	}		
	@Then("^I confirm my order$")
	public void I_confirm_my_order() {
		addtocartPage.confirmMyOrder();
	}	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}