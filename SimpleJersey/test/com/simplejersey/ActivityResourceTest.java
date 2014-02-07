package com.simplejersey;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.simplejersey.model.Activity;

public class ActivityResourceTest
{

	@Test
	public void testGetActivity()
	{
		ActivityResource ar = new ActivityResource();
		Activity a = ar.getActivity("1234");
		
		System.out.println("Activity a: " + a);
		
		assertNotNull(a);
	}

}
