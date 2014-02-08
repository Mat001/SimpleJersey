package com.simplejersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.simplejersey.model.Activity;
import com.simplejersey.model.User;
import com.simplejersey.repository.ActivityRepository;
import com.simplejersey.repository.ActivityRepositoryStub;

@Path("activities")
// http:localhost:8080/SimpleJersey/rest/activities
public class ActivityResource
{
	private ActivityRepository activityRepository = new ActivityRepositoryStub();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	// note that JAXB converts POJO to JSON via XML!!!!! Our XML annotations
	// affect JSON!
	public List<Activity> getAllActivities()
	{
		return activityRepository.findAllActivities();
	}

	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	// media type that we use to put into the web form. post into DB
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	// what is @Produces useful for here??????
	public Activity createActivityParams(Activity activity)
	{
		// useful info (in server console)
		System.out.println("\n********************************************");
		System.out.println("Description: " + activity.getDescription());
		System.out.println("Duration: " + activity.getDuration());
		System.out.println("Age: " + activity.getAge());
		System.out.println("\n********************************************");

		activityRepository.create(activity);

		return activity;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{activityId}")
	// http:localhost:8080/SimpleJersey/rest/activities/1234
	public Response getActivity(@PathParam("activityId") String activityId)
	{	
		// exception handling in case a bad id has been passed as parameter
		/*
		 * if activityId is null or is less than 4 characters, then show message bead request (301).
		 * if not, then retrieve activity and assign it to the variable activity.
		 * if this activity is null then, activity was not found -> show message not found (404)
		 * if all ok and activity is not null, then return activity and show ok response. 
		 */
		
		// equals() I used here for comparison - in tutorial tutor used == !
		// I chose equals() because equals is used when you want to see if two objects have the same value. 
		// == would be used to see if two object are the same object (point to the same object, have the same reference)
		// so I believe equals() should be used
		// here we use equals because we're comparing values, not references
		// but it doesn't seem to matter in this case, both work fine
		if(activityId.equals(null) || activityId.length() < 4)	
			return Response.status(Status.BAD_REQUEST).build();
		
		Activity activity = activityRepository.findActivity(activityId);
		
		if(activity == null)	// here use ==, not equals() because we're comparing references
			return Response.status(Status.NOT_FOUND).build();
		
		return Response.ok().entity(activity).build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("{activityId}/user")
	// http:localhost:8080/SimpleJersey/rest/activities/1234/user
	public User getActivityUser(@PathParam("activityId") String activityId)
	{
		// chaining method calls on an object is called nested retrieve or
		// walking object graph
		// finds user that pertains to that activity
		return activityRepository.findActivity(activityId).getUser(); 
	}
	/*
	// **************************************************************************************************
	// ***** OPTIONAL - I ADDED WEB FORM (instead of Postman extension )
	// ***************************
	@GET
	@Path("webform")
	// http:localhost:8080/SimpleJersey/rest/activities/webform
	@Produces(MediaType.TEXT_HTML)
	public String app()
	{
		ReadFile page = new ReadFile("/home/matjaz/Documents/app2/webform.html");
		String sometext = page.readText();
		return sometext;
	}

	// then add the retrieval part...
	@Path("/created")
	// http:localhost:8080/SimpleJersey/rest/activities/created
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createViaForm(@FormParam("activityId") String activityId)
	{
		// store the message
		return Response.status(200).entity("Activity ID : " + activityId).build();
	}
	*/
	// **************************************************************************************************
	// **************************************************************************************************

}
