package com.simplejersey.client;

import com.simplejersey.model.Activity;

public class Testclass
{
	public void testG()
	{
		ActivityClient client = new ActivityClient();
		
		Activity activity = client.getActivity("1234");
		
		System.out.println(activity);
		
		if(activity.equals(null))
		{
			System.out.println("Activity is null!!!");
		}
		else
			System.out.println("Activity is not null.");
	}
}
