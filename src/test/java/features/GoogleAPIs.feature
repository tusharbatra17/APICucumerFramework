Feature: Add Place in Google Maps

@Regression
Scenario Outline: Adding a New Place on Google Maps
Given Add Place Payload with "<name>" "<language>" "<address>"
When User calls "addPlaceAPI" with "post" Request
Then The API Call is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"



Examples:
	|  name   |  language  |    address         |
	| AAhouse | English    | World Cross Center |
#	| BBhouse | French     | Sea Cross Center   |
	
	
@Regression
Scenario: Verifying the GET API Functionality
Given Get Place Payload
When User calls "getPlaceAPI" with "get" Request
Then The API Call is success with status code 200


Scenario: Verifying the DELETE API Functionality
Given Delete Place Payload
When User calls "deletePlaceAPI" with "post" Request
Then The API Call is success with status code 200
And "status" in response body is "OK"