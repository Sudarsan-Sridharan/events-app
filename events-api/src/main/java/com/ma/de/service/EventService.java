package com.ma.de.service;

import com.ma.de.domain.Event;

import java.util.List;

/**
 * Created by mariusz on 25/02/17.
 */
public interface EventService {

    List<Event> getEventsForLocation(String location);
}
