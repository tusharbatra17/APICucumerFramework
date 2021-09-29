package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class stepDefinition {
	Response response;
	RequestSpecification req;
	static String place_id;
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws Throwable {
		req = given().spec(Utils.getCommonRequest()).body(TestDataBuild.getPlace(name, language, address));
    }

    @When("^User calls \"([^\"]*)\" with \"([^\"]*)\" Request$")
    public void user_calls_something_with_post_request(String resource, String method) throws Throwable {
    	
    	APIResources r = APIResources.valueOf(resource);
    	
    	if(method.equalsIgnoreCase("POST"))
    		response = req.when().post(r.getResource());
    	else if(method.equalsIgnoreCase("GET"))
    		response = req.when().get(r.getResource());
    	else if(method.equalsIgnoreCase("DELETE"))
    		response = req.when().delete(r.getResource());
    	
    	System.out.println(resource);
    	
    			//.then().log().all().spec(Utils.getCommonResponse()).extract().response();
    }

    @Then("^The API Call is success with status code 200$")
    public void the_api_call_is_success_with_status_code_200() throws Throwable {
    	assertEquals(response.getStatusCode(),200);
    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String key, String value) throws Throwable {
        assertEquals(Utils.getJsonPath(response,key),value);
        place_id = Utils.getJsonPath(response,"place_id");
    }
    
    @Given("Get Place Payload")
    public void get_place_payload() throws IOException {
        
        req = given().spec(Utils.getCommonRequest()).queryParam("place_id",place_id);
    }
    
    @Given("Delete Place Payload")
    public void delete_place_payload() throws IOException {
        req = (RequestSpecification) given().spec(Utils.getCommonRequest()).body(TestDataBuild.deletePlacePayload(place_id));
    }
}
