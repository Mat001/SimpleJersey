package com.simplejersey.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/*
 * @XmlRootElement annotation (part of JAXB) allows for ActivityResource to be displayed as XML 
 * as specified in the @Produces annotation
 * about JAXB read here: http://stackoverflow.com/questions/607141/what-is-jaxb-and-why-would-i-use-it
 */

@Entity	// annotate with @Entity if you want to the class instance (Activity) in mongo - yes we want that
@XmlRootElement	
public class Activity
{
	@Id
	private ObjectId id;	// this is needed by default - see morphia tutorials
	
	// use @Property("my_description") only when using a different name for the field value
	private String description;
	
	private int duration;
	
	private String Id;
	
	private String name;
	
	// @Embeded		// think this should be embeded
	// https://github.com/mongodb/morphia/wiki/EntityAnnotation
	private User user;
	
	private int age;
	
	
	@XmlElement(name="desc")		// @XmlElement changes word inside xml tag (from description to desc)
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public int getDuration()
	{
		return duration;
	}
	
	public void setDuration(int duration)
	{
		this.duration = duration;
	}

	public String getId()
	{
		return Id;
	}

	public void setId(String id)
	{
		Id = id;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
