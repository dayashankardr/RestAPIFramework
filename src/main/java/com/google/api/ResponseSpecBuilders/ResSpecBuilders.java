package com.google.api.ResponseSpecBuilders;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResSpecBuilders {

	public static ResponseSpecification res;
	
	public ResponseSpecification ResponseSpec(){
		
		res =  new ResponseSpecBuilder()
			.expectContentType(ContentType.JSON)
			.expectStatusCode(200)
			.build();
	return res;

	}
}
