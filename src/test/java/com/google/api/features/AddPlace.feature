Feature: Add, Get and Delete Place in Google Maps

@GoogleAddPlaceAPI 
Scenario Outline: Verify if place is being Successfully added in Google Maps using AddPlaceAPI
    Given "Add" place API payload with key "qaclick123"
    When User calls "AddPlaceAPI" with "POST" http request
    Then API call is success with status code 200
    Then "status" in response body is "OK"
    Then "scope" in response body is "APP"
    Then Placed Id is generated
    
@GoogleAddMultiplePlaceAPI
Scenario Outline: Verify if multiple places is being Successfully added in Google Maps using AddPlaceAPI
    Given Add place API Payload with key "qaclick123", "<lat>", "<lng>", "<accuracy>", "<name>", "1234567890", "<address>", "<types>", "<website>", "<language>"
  	When User calls "AddPlaceAPI" with "POST" http request
    Then API call is success with status code 200
    Then "status" in response body is "OK"
    Then "scope" in response body is "APP"
    Then Placed Id is generated
    
Examples:
   |lat 	    | lng 	      | accuracy | name     | phone_Number  | address    | types          | website          | language |
   |56.767889 | 56.767889   | 10       | Home 123 | 9838933937    | Address 1  | Park#food      | http://WCG.com   | English  |
   |66.767889 | 66.767889   | 20       | Home 456 | 1234567890    | Address 2  | garden#studio  | http://FIS.com   | Turkish  |

   
   
@GoogleGetPlaceAPI
Scenario Outline:  Verify if place details are retreived from Google Maps using GetPlaceAPI
    Given "Get" place API payload with key "qaclick123"
    When User calls "GetPlaceAPI" with "GET" http request
    Then API call is success with status code 200
    Then Place Details are Retreived
    
@GoogleDeletePlaceAPI
Scenario Outline: Verify if place is deleted from Google Maps using DeletePlaceAPI
    Given "Delete" place API payload with key "qaclick123"
    When User calls "DeletePlaceAPI" with "POST" http request
    Then API call is success with status code 200
    And Place Id is Deleted
    Then "status" in response body is "OK"
