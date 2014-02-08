package com.simplejersey.client;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.simplejersey.model.Activity;

public class ActivityClientTest
{

	// testing PUT method
	@Test
	public void testPut()
	{
		Activity activity = new Activity();
		
		activity.setId("3456");		// NEED TO SET ID !!!!  PUT method requires it!!
		activity.setDescription("Bikram yoga");
		activity.setDuration(75);
		
		ActivityClient client = new ActivityClient();
		
		activity = client.update(activity);
		
		assertNotNull(activity);
		
	}
	
	// testing POST method
	@Test
	public void testCreate()
	{
		ActivityClient client = new ActivityClient();
		
		// WE ARE NOT SETTING THE ID WITH THIS OBJECT - BECAUSE WE'RE using THE POST METHOD
		// POST method does not deal with id-s (PUT method does !!!)
		Activity activity = new Activity();
		activity.setDescription("swimming");
		activity.setDuration(90);
		
		activity = client.create(activity);
		
		assertNotNull(activity);
	}
	
	
	@Test
	public void testGetActivity()
	{
		ActivityClient client = new ActivityClient();
		
		Activity activity = client.getActivity("1234");
		
		System.out.println(activity);
		
		assertNotNull(activity);
	}
	
	@Test
	public void testGetList()
	{
		ActivityClient client = new ActivityClient();
		
		List<Activity> activities = client.getList();
		
		System.out.println(activities);
		
		assertNotNull(activities);
		
	}
	
	// we're expecting exception to be thrown (but we can't see it) and do for the test to pass
	@Test(expected=RuntimeException.class)	
	public void getWithBadRequest()
	{
		ActivityClient client = new ActivityClient();
		client.getActivity("123");		// test for when the id is too short
	}
	
	// test for when the id is different
	@Test(expected=RuntimeException.class)	
	public void getWithNotFound()
	{
		ActivityClient client = new ActivityClient();
		client.getActivity("7777");		
	}

}
