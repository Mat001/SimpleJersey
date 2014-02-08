/*
 * repository is what DAO used to be  !!
 */

package com.simplejersey.repository;

import java.util.List;

import com.simplejersey.model.Activity;

public interface ActivityRepository
{

	List<Activity> findAllActivities();

	Activity findActivity(String activityId);

	void create(Activity activity);

	Activity update(Activity activity);

	void delete(String activityId);

}