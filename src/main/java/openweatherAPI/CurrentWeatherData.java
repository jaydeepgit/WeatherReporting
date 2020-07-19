package openweatherAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import ndtvUI.NDTVWeatherPage;

public class CurrentWeatherData extends NDTVWeatherPage{
	public static int tempvalueInOpenWeather;
	
	@Test(dependsOnMethods="ndtvUI.NDTVWeatherPage.cityWeather")
	public void  GetCurrentWeatherData() {
     // Base URL
	RestAssured.baseURI="https://api.openweathermap.org/data/2.5/weather?";
	// Authentication
	RestAssured.authentication=RestAssured.DEFAULT_AUTH;
	// Parameters
	Map<String, String> param = new HashMap<String, String>();
	param.put("appid","f4e9279040b7e72cdc01a0fdd4d3c27d");
	param.put("q", "Allahabad,");
	
	//Response
	Response response=RestAssured.given().log().all()
			.params(param)
			.contentType(ContentType.JSON)
			.get()
			;
	//printing the response
	response.prettyPrint();
	//Converting response in Json formatted value to read key and values
	JsonPath jsonResponse=response.jsonPath();
	//Extracting the Temp value
	float temp=jsonResponse.get("main.temp");
	float tempInCelsius=(temp - 273.15F);
	//Converting float value in int
	tempvalueInOpenWeather = (int) tempInCelsius;
	System.out.println("Temp in OpenWeather Degrees: "+tempvalueInOpenWeather);
	}
	
	
	@Test
	public void validateTemp() {
	Assert.assertEquals(tempvalueInOpenWeather, TempInNDTV);
	}
	
	
	
	@Test
	public void validateWithVarianceLogic() {
	for(int i=-5; i>=5; i++) {
		int newTempInOpenWeather= tempvalueInOpenWeather+i;
	
	if(newTempInOpenWeather==TempInNDTV)
		System.out.println("Temparature is matching");
      else 
		System.out.println("Temparature is not matching");
		
}
	}}

