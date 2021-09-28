package resources;

import java.util.ArrayList;
import java.util.List;
import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public static AddPlace getPlace(String name, String language, String address)
	{

	AddPlace ap = new AddPlace();
	ap.setAccuracy(50);
	ap.setAddress(address);
	ap.setLanguage(language);
	ap.setName(name);
	ap.setPhone_number("(+91) 983 893 3937");
	ap.setWebsite("http://google.com");
	
	Location l = new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	
	ap.setLocation(l);
	
	List<String> myList = new ArrayList<String>();
	myList.add("shoe park");
	myList.add("shop");
	
	ap.setTypes(myList);
	
	return ap;
	}
	
	public static String deletePlacePayload(String place_id)
	{
		return "{\"place_id\": \""+place_id+"\"}";
	}
}
