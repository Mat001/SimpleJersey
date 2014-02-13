/**
 * - Repository is what DAO used to be  !!
 * - Stub mimics database data
 */

package com.simplejersey.repository;

import java.util.List;

import javax.ejb.EJB;

import org.mongodb.morphia.query.Query;

import com.simplejersey.model.Activity;
import com.simplejersey.model.User;

public class ActivityRepositoryStub implements ActivityRepository
{

	private MongoConnection dbConnection;
	
	// constructor to initialize Mongodb connection
	// using EJBs this instantiation would be taken care of by EJB!
	public ActivityRepositoryStub()
	{
		dbConnection = new MongoConnection();	// giang wrote this should have keyword 'this': this.dbConnection = ...
	}
	
	
	@Override
	public void create(Activity activity)
	{
		// here you would use INSERT statement and write activity to the database
		dbConnection.getDatastore().save(activity);
	}
	
	@Override
	public void delete(String activityId)
	{
		// delete from activity where activityId = ?
		dbConnection.getDatastore().delete(activityId);	// is this correct??
	}
	
	// get the list of all activities
	public List<Activity> findAllActivities()
	{
		/*
		// create a list of activities
		List<Activity> activities = new ArrayList<Activity>();
		
		// create activities
		
		Activity activity1 = new Activity();
		activity1.setDescription("swimming");
		activity1.setDuration(66);
		activity1.setAge(25);
		activities.add(activity1);
		
		Activity activity2 = new Activity();
		activity2.setDescription("cycling");
		activity2.setDuration(120);
		activity1.setAge(34);
		activities.add(activity2);
		
		return activities;
		*/
		
		Query<Activity> query = dbConnection.getDatastore().find(Activity.class);
		return query.asList();	// return list of activities
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

	@Override
	public Activity update(Activity activity)
	{
		// search the database to see if we have an activity with that id already
		// example: SELECT * FROM Activity WHERE id = ?
		// if size == 0
		// INSERT into Activity table
		// else
		// update the Activity table
		
		return activity;
	}
	
}
