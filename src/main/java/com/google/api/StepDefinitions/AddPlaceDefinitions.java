package com.google.api.StepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.google.api.PojoRequests.AddPlaceLocation;
import com.google.api.PojoRequests.AddPlaceRequest;
import com.google.api.PojoResponse.AddPlaceResponse;
import com.google.api.Utils.ApiResources;
import com.google.api.Utils.ReadPropertiesFile;

public class AddPlaceDefinitions {
	
	AddPlaceRequest addPlace;
	AddPlaceLocation location;
	AddPlaceResponse addPlaceResponse;
	
	ReadPropertiesFile read;
	Properties prop;
	List<String> list;
	

	public AddPlaceRequest AddPlaceAPIPayload() throws IOException {
		
		prop = new ReadPropertiesFile().readPropertiesFile(ApiResources.ADD_PLACE_PROPERTIES);
		
		location = new AddPlaceLocation();
		location.setLat(Double.parseDouble(prop.getProperty("lat")));
		location.setLng(Double.parseDouble(prop.getProperty("lng")));
		
		list = new ArrayList<String>();
		String[] types = prop.getProperty("types").split("#");
		for(String addTypesToList : types) {
			list.add(addTypesToList);
		}
		
		addPlace = new AddPlaceRequest();
		
		addPlace.setLocation(location);
		addPlace.setAccuracy(Integer.parseInt(prop.getProperty("accuracy")));
		addPlace.setName(prop.getProperty("name"));
		addPlace.setPhone_number(prop.getProperty("phone_number"));
		addPlace.setAddress(prop.getProperty("address"));
		addPlace.setTypes(list);
		addPlace.setWebsite(prop.getProperty("website"));
		addPlace.setLanguage(prop.getProperty("language"));
	
		
	/*	location = new AddPlaceLocation();
		location.setLat(-34.3434343);
		location.setLng(34.3434343);
		
		list = new ArrayList<String>();
		String[] types = {"tea Shop","Complex"};
		for(String addTypesToList : types) {
			list.add(addTypesToList);
		}
		
		addPlace = new AddPlaceRequest();
		
		addPlace.setLocation(location);
		addPlace.setAccuracy(50);
		addPlace.setName("Frontline house");
		addPlace.setPhone_number("(+91) 983 893 3937");
		addPlace.setAddress("29, side layout, cohen 09");
		addPlace.setTypes(list);
		addPlace.setWebsite("http://google.com");
		addPlace.setLanguage("French-IN");
		
	*/
		return addPlace;
		
	}
	
	public AddPlaceRequest getAddMultiplePlacePayload(String key, String lat, String lng, String accuracy, String name, String phone_number, String address, String types, String website, String language) throws IOException {
		
		//prop = new ReadPropertiesFile().readPropertiesFile(addPlaceProperties);
		
		location = new AddPlaceLocation();
		location.setLat(Double.parseDouble(lat));
		location.setLng(Double.parseDouble(lng));
		
		list = new ArrayList<String>();
		String[] typesData = types.split("#");
		for(String addTypesToList : typesData) {
			list.add(addTypesToList);
		}
		
		addPlace = new AddPlaceRequest();
		
		addPlace.setLocation(location);
		addPlace.setAccuracy(Integer.parseInt(accuracy));
		addPlace.setName(name);
		addPlace.setPhone_number(phone_number);
		addPlace.setAddress(address);
		addPlace.setTypes(list);
		addPlace.setWebsite(website);
		addPlace.setLanguage(language);
		
		return addPlace;
		
	}
	
	public String deletePlaceAPIPayload(String place_id) {
		
		return "{\r\n" + 
				"    \"place_id\": \""+place_id+"\"\r\n" + 
				"}";
		
	}
}
