package com.tourism.controller;

import com.tourism.model.Activity;
import com.tourism.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    com.tourism.repository.DestinationRepository destinationRepository;

    @GetMapping
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Activity getActivityById(@PathVariable Long id) {
        return activityRepository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found"));
    }

    @GetMapping("/destination/{destinationId}")
    public List<Activity> getActivitiesByDestination(@PathVariable Long destinationId) {
        return activityRepository.findByDestinationId(destinationId);
    }

    @PostMapping
    public Activity createActivity(@RequestBody Activity activity) {
        if (activity.getDestination() != null && activity.getDestination().getId() != null) {
            activity.setDestination(destinationRepository.findById(activity.getDestination().getId())
                    .orElseThrow(() -> new RuntimeException("Destination not found")));
        }
        return activityRepository.save(activity);
    }

    @PutMapping("/{id}")
    public Activity updateActivity(@PathVariable Long id, @RequestBody Activity activityDetails) {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new RuntimeException("Activity not found"));
        activity.setName(activityDetails.getName());
        if (activityDetails.getDestination() != null && activityDetails.getDestination().getId() != null) {
            activity.setDestination(destinationRepository.findById(activityDetails.getDestination().getId())
                    .orElseThrow(() -> new RuntimeException("Destination not found")));
        }
        activity.setPrice(activityDetails.getPrice());
        return activityRepository.save(activity);
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Long id) {
        activityRepository.deleteById(id);
    }
}
