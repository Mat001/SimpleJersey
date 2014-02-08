/*
 * Repository is what DAO used to be  !!
 * 
 * Stub mimics database data
 */

package com.simplejersey.repository;

import java.util.ArrayList;
import java.util.List;

import com.simplejersey.model.Activity;
import com.simplejersey.model.User;

public class ActivityRepositoryStub implements ActivityRepository
{
	
	@Override
	public void create(Activity activity)
	{
		// here you would use INSERT statement and write activity to the database
		
	}
	
	public List<Activity> findAllActivities()
	{
		// create a list of activities
		List<Activity> activities = new ArrayList<Activity>();
		
		// create activities
		Activity activity1 = new Activity();
		activity1.setDescription("swimming");
		activity1.setDuration(55);
		activity1.setAge(25);
		activities.add(activity1);
		
		Activity activity2 = new Activity();
		activity2.setDescription("cycling");
		activity2.setDuration(120);
		activity1.setAge(34);
		activities.add(activity2);
		
		return activities;
	}
	
	@Override
	public Activity findActivity(String activityId)
	{
		// WE WOULD PULL FROM DATABASE HERE ! In this case activity id.
		
		// test - temporarily hardcoding for test purposes - eventually this data would come from DB
		if(activityId.equals("7777"))
			return null;
			
		Activity activity1 = new Activity();
		
		activity1.setId("1234");
		activity1.setDescription("swimming");
		activity1.setDuration(55);
		activity1.setAge(25);
		
		User user = new User();
		user.setId(5678);
		user.setName("Matjaz");
		
		activity1.setUser(user);
		
		return activity1;
	}
	
}
