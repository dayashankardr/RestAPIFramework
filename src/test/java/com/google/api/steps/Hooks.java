package com.google.api.steps;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	AddPlace ap;
	
	@Before("@GoogleDeletePlaceAPI")
	public void beforeScenario() throws IOException{
		
		System.out.println("******************** Running From Hooks ************************\n");
		
		ap = new AddPlace();
		
		if(AddPlace.place_id == null) {
			ap.add_place_payload("Add","qaclick123");
			ap.user_calls_with_http_request("AddPlaceAPI", "POST");
			ap.api_call_is_success_with_status_code(200);
			ap.in_response_body_is("status", "OK");
			ap.placed_Id_is_generated();
			
			
		}
		
	}

}
