package com.ma.de.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by mariusz on 26/02/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Events{

    private List<Event> event;


    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }
}
