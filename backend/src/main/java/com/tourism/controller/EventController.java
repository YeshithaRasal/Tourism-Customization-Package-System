package com.tourism.controller;

import com.tourism.model.Event;
import com.tourism.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    EventRepository eventRepository;

    @GetMapping("/{destinationId}")
    public List<Event> getEventsByDestination(@PathVariable Long destinationId) {
        LocalDate today = LocalDate.now();
        return eventRepository.findByDestinationIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(destinationId, today, today);
    }
}
