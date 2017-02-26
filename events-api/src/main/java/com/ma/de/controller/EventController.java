package com.ma.de.controller;

import com.ma.de.domain.Event;
import com.ma.de.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * Created by mariusz on 25/02/17.
 */

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping("/events/{location}")
    public List<Event> getEventsForLocation(@PathVariable String location) {

        if(StringUtils.isEmpty(location)){
            return Collections.EMPTY_LIST;
        }

        return eventService.getEventsForLocation(location);
    }
}
