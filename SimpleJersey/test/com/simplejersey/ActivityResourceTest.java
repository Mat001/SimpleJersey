package com.simplejersey;

import static org.junit.Assert.assertNotNull;

import javax.ws.rs.core.Response;

import org.junit.Test;

public class ActivityResourceTest
{

	@Test
	public void testGetActivity()
	{
		ActivityResource ar = new ActivityResource();
		Response a = ar.getActivity("1234");
		
		System.out.println("Activity/Response a: " + a);
		
		assertNotNull(a);
	}

}
