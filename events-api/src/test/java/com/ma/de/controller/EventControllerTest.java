package com.ma.de.controller;

import com.ma.de.controller.EventController;
import com.ma.de.domain.Event;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;

/**
 * Created by mariusz dekarski on 25/02/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(EventController.class)
public class EventControllerTest {

    private static final DateTimeFormatter EVENT_DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static final String EVENT_1_TITLE = "Event_1";
    public static final String EVENT_2_TITLE = "Event_2";
    private static final String RESPONSE_JSON = "[{\"id\":null,\"title\":\"Event_1\",\"description\":null,\"start_time\":\"25-02-2017\",\"postal_code\":null,\"venue_address\":null,\"city_name\":null},{\"id\":null,\"title\":\"Event_2\",\"description\":null,\"start_time\":\"25-02-2017\",\"postal_code\":null,\"venue_address\":null,\"city_name\":null}]";
    private static final String LOCATION = "London";
    public static final String URL_TEMPLATE = "/events/";
    private List<Event> eventList;
    private String eventDate;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EventController eventController;

    @Before
    public void setUp(){
        eventDate = LocalDate.of(2017, 2, 25).format(EVENT_DATE_FORMAT);
        eventList = Arrays.asList(new Event(EVENT_1_TITLE, eventDate),
                new Event(EVENT_2_TITLE, eventDate));
    }

    @Test
    public void get_events_for_location() throws Exception {
        given(eventController.getEventsForLocation(LOCATION)).willReturn(eventList);

        this.mvc.perform(get(URL_TEMPLATE + LOCATION).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().json(RESPONSE_JSON));
    }

    @Test
    public void get_empty_list_for_call_without_parameters() throws Exception {
        given(eventController.getEventsForLocation(null)).willReturn(eventList);

        this.mvc.perform(get(URL_TEMPLATE + LOCATION).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().json("[]"));
    }
}
