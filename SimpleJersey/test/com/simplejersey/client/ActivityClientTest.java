package com.simplejersey.client;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.simplejersey.model.Activity;

public class ActivityClientTest
{

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

}
