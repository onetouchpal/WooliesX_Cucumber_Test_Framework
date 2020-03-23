package com.cucumberFramework.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cucumberFramework.helper.WaitHelper;

public class AddToCartPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//ul[@id='homefeatured']/li[1]/div[@class='product-container' and 1]/div[@class='left-block' and 1]")
	WebElement articleaddtocart;
	
	@FindBy(xpath="//ul[@id='homefeatured']/li[1]/div[@class='product-container' and 1]/div[@class='right-block' and 2]/div[@class='button-container' and 2]/a[@class='button ajax_add_to_cart_button btn btn-default' and 1]/span[1]")
	WebElement addtocart;
	
	@FindBy(xpath="//span[@class='continue btn btn-default button exclusive-medium']")
	public WebElement clickcontinueshopping;
	
	@FindBy(xpath="//ul[@id='homefeatured']/li[2]/div[@class='product-container' and 1]/div[@class='left-block' and 1]/div[@class='product-image-container' and 1]")
	public WebElement secondArticleToCart;
	
	@FindBy(xpath="//ul[@id='homefeatured']/li[2]/div[@class='product-container' and 1]/div[@class='right-block' and 2]/div[@class='button-container' and 2]/a[@class='button ajax_add_to_cart_button btn btn-default' and 1]/span[1]")
	public WebElement Secondaddtocart;
	
	@FindBy(xpath="//a[@class='btn btn-default button button-medium']")
	public WebElement proceedtocheckout;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
	public WebElement nextproceedtocheckout;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement emailaddress;
	
	@FindBy(xpath="//input[@id='passwd']")
	public WebElement password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	public WebElement signinButton;
	
	@FindBy(xpath="//a[@class='logout']")
	public WebElement signoutbutton;
	
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']")
	public WebElement aftersigninproceedtocheckout;
	 
	@FindBy(xpath="//div[@id='uniform-cgv']")
	public WebElement termsofservice;
	
	@FindBy(xpath="//button[@class='button btn btn-default standard-checkout button-medium']")
	public WebElement standardcheckout;
	
	@FindBy(xpath="//a[@class='cheque']")
	public WebElement paymentmethod;
	
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']")
	public WebElement confirmorder;
	
	
	
	WaitHelper waitHelper;
	
	public AddToCartPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.WaitForElement(userName, 60);
	}
	public void clickAddToCart(){
		Actions builder = new Actions(driver);
		builder.moveToElement(articleaddtocart).build().perform();
		builder.moveToElement(addtocart).build().perform();
		addtocart.click();
	}

	public void addSecondItemToCart() {
		Actions builder = new Actions(driver);
		waitHelper.WaitForElement(secondArticleToCart, 60);
		builder.moveToElement(secondArticleToCart).build().perform();
		waitHelper.WaitForElement(Secondaddtocart, 60);
		builder.moveToElement(Secondaddtocart).build().perform();
		Secondaddtocart.click();
	}

	public void clickContinueShopping() {
		waitHelper.WaitForElement(clickcontinueshopping, 60);
		clickcontinueshopping.click();
	}

	public void proceedToCheckOut() {
		waitHelper.WaitForElement(proceedtocheckout, 60);
		proceedtocheckout.click();
	}

	public void nextProceedToCheckOut() {
		waitHelper.WaitForElement(nextproceedtocheckout, 60);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", nextproceedtocheckout);
		nextproceedtocheckout.click();
	}

	public void enterEmailaddress(String emailAddress) {
		waitHelper.WaitForElement(emailaddress, 60);
		this.emailaddress.sendKeys(emailAddress);
	}

	public void enterPassword(String password) {
		
		this.password.sendKeys(password);
	}

	public void clickSigninButton() {
		waitHelper.WaitForElement(signinButton, 60);
		signinButton.click();
	}
	
	public void afterSigninProceedToCheckout() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", aftersigninproceedtocheckout);
		aftersigninproceedtocheckout.click();
	}
	public void termsOfService() {
		waitHelper.WaitForElement(termsofservice, 60);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", termsofservice);
		termsofservice.click();
		
	}
	public void standardCheckOut() {
		waitHelper.WaitForElement(standardcheckout, 60);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", standardcheckout);
		standardcheckout.click();
		
	}
	
	public void paymentMethod() {
		waitHelper.WaitForElement(paymentmethod, 60);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", paymentmethod);
		paymentmethod.click();
	}
	public void confirmMyOrder() {
		waitHelper.WaitForElement(confirmorder, 60);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", confirmorder);
		confirmorder.click();
		
	}
	
	

}
