package com.ma.de.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by mariusz on 26/02/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventfulSearchResult {

    private Events events;
    @JsonProperty("total_items") private int totalItems;

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
}



