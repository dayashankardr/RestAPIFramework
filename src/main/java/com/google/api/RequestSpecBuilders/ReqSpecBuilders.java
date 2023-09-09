package com.google.api.RequestSpecBuilders;

import com.google.api.Utils.ApiResources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ReqSpecBuilders {
	
	public static RequestSpecification req;
	
	public RequestSpecification ReqSpec(String key) {
		
		if(req == null) {
			return req = new RequestSpecBuilder()
					.setContentType(ContentType.JSON)
					.setBaseUri(ApiResources.BASE_URI)
					.addQueryParam("key", key)
					.build();
		}
		else
		{
			return req;
		}
		
	}
	
}
