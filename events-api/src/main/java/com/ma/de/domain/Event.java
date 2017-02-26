package com.ma.de.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.StringUtils;

/**
 * Created by mariusz on 25/02/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

    private String id;
    private String title;
    private String description;

    @JsonProperty("start_time") private String date;
    @JsonProperty("postal_code") private String postalCode;
    @JsonProperty("venue_address") private String venueAddress;
    @JsonProperty("city_name") private String city;

    public Event() {}

    public Event(String title, String date) {

        this.title = title;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
