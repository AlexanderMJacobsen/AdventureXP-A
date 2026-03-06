package com.xpgruppe.AdventureXP.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xpgruppe.AdventureXP.model.Activity;
import com.xpgruppe.AdventureXP.repository.ActivityRepository;

@Service
public class ActivityService {

	private final ActivityRepository activityRepository;


	public ActivityService(ActivityRepository activityRepository){
		this.activityRepository = activityRepository;
	}

	public Activity getActivity(Long id) {

		Activity activity = activityRepository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found with id: " + id));
		return activity;
	}

	public Activity createActivity(Activity activity) {
		return activityRepository.save(activity);
	}

	public Activity updateActivity(Long id, Activity updatedActivity) {

		Activity existingActivity = activityRepository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found with id: " + id));

		existingActivity.setTitle(updatedActivity.getTitle());
		existingActivity.setDescription(updatedActivity.getDescription());
		existingActivity.setStartDate(updatedActivity.getStartDate());
		existingActivity.setEndDate(updatedActivity.getEndDate());
		return activityRepository.save(existingActivity);
	}

	public void deleteActivity(Long id) {
		Activity existingActivity = activityRepository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found with id: " + id));
		activityRepository.delete(existingActivity);
	}

	public List<Activity> getAllActivitys() {
		List<Activity> activities = new ArrayList<>();

		Activity a1 = new Activity();
		a1.setTitle("Sumobrydning");
		a1.setDescription("Sjov og kaotisk kamp i sumodragter.");

		Activity a2 = new Activity();
		a2.setTitle("Paintball");
		a2.setDescription("Actionfyldt holdkamp med malingkugler.");

		Activity a3 = new Activity();
		a3.setTitle("Minigolf");
		a3.setDescription("Hyggelig og konkurrencepræget minigolf.");

		Activity a4 = new Activity();
		a4.setTitle("Wipeout");
		a4.setDescription("Forhindringsbane med fart, balance og grin.");

		Activity a5 = new Activity();
		a5.setTitle("Gokart");
		a5.setDescription("Ræs mod vennerne på gokartbanen.");

		activities.add(a1);
		activities.add(a2);
		activities.add(a3);
		activities.add(a4);
		activities.add(a5);

		return activities;
	}


}
