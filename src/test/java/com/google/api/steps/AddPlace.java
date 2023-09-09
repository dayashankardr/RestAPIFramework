package com.google.api.steps;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.api.PojoResponse.AddPlaceResponse;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import com.google.api.RequestSpecBuilders.ReqSpecBuilders;
import com.google.api.ResponseSpecBuilders.ResSpecBuilders;
import com.google.api.StepDefinitions.AddPlaceDefinitions;
import com.google.api.Utils.ApiResources;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class AddPlace {
	//private static final Logger logger = LogManager.getLogger(AddPlace.class);
	
	public RequestSpecification req;
	public Response response;
	public AddPlaceResponse addPlaceResponse;
	public ApiResources apiRes;
	public static String place_id;
	
	@Given("{string} place API payload with key {string}")
	public void add_place_payload(String httpMethod, String key) throws IOException {
		if(httpMethod.equalsIgnoreCase("Add"))
		{
			req = given()
			.spec(new ReqSpecBuilders().ReqSpec(key))
			.body(new AddPlaceDefinitions().AddPlaceAPIPayload());
		}
		else if(httpMethod.equalsIgnoreCase("Get")){
			req = given()
				.spec(new ReqSpecBuilders().ReqSpec(key))
			    .queryParam("place_id", place_id);
			    
		}
		else if(httpMethod.equalsIgnoreCase("Delete")){
			req = given().log().all()
					.spec(new ReqSpecBuilders().ReqSpec(key))
					.body(new AddPlaceDefinitions().deletePlaceAPIPayload(place_id));				
		}
		   
	}
	
	@Given("Add place API Payload with key {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void add_place_payload_with_key(String key, String lat, String lng, String accuracy, String name, String phone_number, String address, String types, String website, String language) throws FileNotFoundException, IOException {
		req = given()
				.spec(new ReqSpecBuilders().ReqSpec(key))
				.body(new AddPlaceDefinitions().getAddMultiplePlacePayload(key,lat,lng,accuracy,name,phone_number,address,types,website,language));
	   
	}
	
	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String apiResource, String httpMethod) {

		apiRes = ApiResources.valueOf(apiResource);
		
		if(httpMethod.equalsIgnoreCase("POST")) {
			response = req.when().post(apiRes.getResource());
		}
		else if(httpMethod.equalsIgnoreCase("GET")) {
			response = req.when().get(apiRes.getResource());
		}
		else if(httpMethod.equalsIgnoreCase("DELETE")){
			response = req.when().log().all()
					.delete(apiRes.getResource());
							
		}	
  }
	
	@Then("API call is success with status code {int}")
	public void api_call_is_success_with_status_code(int ExpectedstatusCode) {
		response.then().spec(new ResSpecBuilders().ResponseSpec()).extract().response();
		assertEquals(response.getStatusCode(),ExpectedstatusCode);

	}
	
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String resBodyKey, String resBodyValue) {
		JsonPath js = new JsonPath(response.asString());
		assertEquals(js.get(resBodyKey),resBodyValue);
	}
		
	@Then("Placed Id is generated")
	public void placed_Id_is_generated() {
		addPlaceResponse = response.as(AddPlaceResponse.class);
		place_id = addPlaceResponse.getPlace_id();
		System.out.println("AddPlaceAPI - Place Id = " +place_id);
	//	System.out.println("AddPlaceAPI - Place Id = " +place_id);
	}
	
	@Then("Place Details are Retreived")
	public void place_details_are_retreived() {
		System.out.println("GetPlaceAPI - Place Id details are Retreived = "+place_id);
	}
	
	@And("Place Id is Deleted")
	public void place_id_is_deleted() {
		System.out.println("DeletPlaceAPI - Place Id is Deleted = "+place_id);
	}
}
