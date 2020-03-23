package com.cucumberFramework.stepdefinitions;

import org.testng.Assert;

import com.cucumber.HappyHolidayMaker.HappyHolidayMaker;
import com.cucumberFramework.testBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HappyHolidayMakerStepDefinitions extends TestBase {

	HappyHolidayMaker happyholidaymaker = new HappyHolidayMaker();

	@Given("^I like to holiday in \"([^\"]*)\"$")
	public void i_Like_To_Holiday_In(String city) throws Throwable {
		happyholidaymaker.iLikeToHolidayIn(city);
	}

	@Given("^I only like to holiday on \"([^\"]*)\"$")
	public void i_Only_Like_To_Holiday_On(String preferedDay) throws Throwable {
		happyholidaymaker.iOnlyLikeToHolidayOn(preferedDay);
	}

	@When("^I look up the weather forecast$")
	public void i_Look_Up_The_Weather() throws Throwable {
		Assert.assertTrue(happyholidaymaker.iLookUpTheWeather(),"The response is not valid JSON ");
	}

	@Then("^I receive the weather forecast$")
	public void i_Receive_The_Weather() throws Throwable {
		Assert.assertTrue(happyholidaymaker.iReceiveTheWeather(),"City Name retunred in the Json response is not same as requested");
	}

	@Then("^the temperature is warmer than \"([^\"]*)\" degrees$")
	public void the_Temperature_Is_Warmer_Than_Degrees(String preferredTemp) throws Throwable {
		Assert.assertTrue(happyholidaymaker.theTemperatureIsWarmerThan(preferredTemp),
				"Thursday weather returned is not > 10 degrees C\r\n" + " ");
		;
	}
}
