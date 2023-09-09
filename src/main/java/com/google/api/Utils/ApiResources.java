package com.google.api.Utils;

public enum ApiResources {

	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	
	ApiResources(String resource) {
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}
	
	public final static String BASE_URI = "https://rahulshettyacademy.com";
	public final static String ADD_PLACE_PROPERTIES = "C:\\Users\\daya3\\eclipse-workspace\\GoogleAPIFramework\\src\\main\\resources\\addPlacePayloadData.properties";



	 

}
