package com.simplejersey.repository;

import java.util.logging.Logger;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;
import com.simplejersey.model.Activity;


public class MongoConnection
{
	Datastore ds;
	
	public MongoConnection()
	{
		Logger.getAnonymousLogger().severe("SimpleJersey: MongoDB is connected.");
		
		try
		{
			ds = new Morphia().map(Activity.class).createDatastore(new MongoClient("localhost", 27017), "SimpleJersey");
		} 
		catch (Exception e)
		
		{	e.printStackTrace();  }
		
	}
	
	public Datastore getDatastore()
	{ return ds; }
}
