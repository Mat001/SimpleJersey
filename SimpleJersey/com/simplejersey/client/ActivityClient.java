package com.simplejersey.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.simplejersey.model.Activity;

public class ActivityClient
{
	private Client client;	// Client comes from Jersey
	
	// constructor
	public ActivityClient()
	{
		client = ClientBuilder.newClient();		// ClientBuilder and newClient() come from Jersey
		// can add different things here: encoding etc.
	}
	
	// methods
	/*
	 * 1. get target. Using Jersey built-in objects and methods like Webtarget, .target, .path, .request, .get
	 * 	  here we specify the core part of URL
	 *    
	 *    WebTarget target = client.target("http://localhost:8080/SimpleJersey/rest/");
	 *
	 * 2. build a response
	 *    target.path("/activities" + id): here we append the part of URL we care about (/activities/id)
	 *    .request(): "Whatever the default MIME type is that you want me to hand me back, that's what I'll accept" - currently JSON
	 *    .get(Activity.class): "give me the activity and bind it to the Activity class."
	 *    
	 *    Activity response = target.path("/activities" + id).request().get(Activity.class);
	 *    
	 *    
	 *    (Both combined should form the final URL we want: http://localhost:8080/SimpleJersey/rest/activities/1234)
	 */
	
	// respond with an activity
	public Activity getActivity(String id)
	{	
		WebTarget target = client.target("http://localhost:8080/SimpleJersey/rest/");
		
		//Activity response = target.path("activities/" + id).request().get(Activity.class);
		// optionally specify media type (for ex. JSON) in request() - xml is default
		Activity response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Activity.class);
				
		return response;
	}
	
	// respond with list of activities
	public List<Activity> getList()
	{	
		WebTarget target = client.target("http://localhost:8080/SimpleJersey/rest/");
		
		// .get(List.class) won't work. Need to wrap with new GenericType<List<Activity>>() {}
		// using only List program wouldn't know how to handle it. GenericType object (provided by Jersey) knows how to handle that
		// Maps and Sets would have the same issue - same solution
		List<Activity> response = target.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>(){});
		
		return response;
	}
	
}
