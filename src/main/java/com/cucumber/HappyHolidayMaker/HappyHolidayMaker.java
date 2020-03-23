package com.cucumber.HappyHolidayMaker;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

import com.cucumberFramework.helper.CommonHelper;
import com.cucumberFramework.helper.LoggerHelper;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//import io.restassured.specification.RequestSpecification;

public class HappyHolidayMaker {

	private String cityName;
	private String preferredDay;
	private Response jsonResponse;
	private String baseUri = "https://api.openweathermap.org/data/2.5";
	private String aapID = "87edb0ddb809adcd8773443f2a76d4e5";
	private List<Map<Object, Object>> jsonResponse01;
	Logger log = LoggerHelper.getLogger(HappyHolidayMaker.class);

	public void iLikeToHolidayIn(String city) {
		this.cityName = city;
	}

	public void iOnlyLikeToHolidayOn(String day) {
		this.preferredDay = day.substring(0, 3);
		// System.out.println("==="+this.preferredDay);

	}

	public boolean iLookUpTheWeather() {

		boolean flag = true;

		RestAssured.baseURI = baseUri;
		RequestSpecification request = RestAssured.given();

		try {
			jsonResponse = request.queryParam("q", cityName).queryParam("units", "metric").queryParam("cnt", "40")
					.queryParam("appid", aapID).get("forecast");
		} catch (JsonIOException json) {
			log.error("Not a valid Json" + jsonResponse.toString());
			flag = false;
		}
		return flag;
	}

	public boolean iReceiveTheWeather() {
		boolean flag = false;
		jsonResponse01 = this.jsonResponse.jsonPath().getList("list");
		Map<Object,Object> jsonResponse02 = this.jsonResponse.jsonPath().get("city");
		Object retunredCityName = jsonResponse02.get("name");
		if(retunredCityName.toString().trim().equals(cityName)) {
			flag = true;
			log.info("City Name Expected : "+cityName+" Actual City Name : "+retunredCityName);
		}else {
			log.info("City Name Expected : "+cityName+" Actual City Name : "+retunredCityName);
			flag = false;
		}
		return flag;
		// System.out.println("++++++++++++++++"+ jsonResponse01.size());
	}

	public boolean theTemperatureIsWarmerThan(String temp) {

		boolean flag = false;
		int counter = 0;

		for (int i = 0; i < jsonResponse01.size(); i++) {
			@SuppressWarnings("unchecked")
			Map<Object, Object> jsonResponse1 = (Map<Object, Object>) jsonResponse01.get(i).get("main");

			Object date = jsonResponse01.get(i).get("dt");

			Object jsonResponse2 = jsonResponse1.get("temp");

			CommonHelper commonHelper = new CommonHelper();

			String formattedDate = commonHelper.dateFormat(date);

			if (Double.valueOf(jsonResponse2.toString()) > Integer.valueOf(temp)) {
				if (formattedDate.startsWith(preferredDay) && counter==0) {
					log.info("Tourist can holiday on ::" + formattedDate.toString() + " ,when the temperature is::"
							+ jsonResponse2);
					flag = true;
					counter++;
				}
			}
		}
		return flag;
	}
}
