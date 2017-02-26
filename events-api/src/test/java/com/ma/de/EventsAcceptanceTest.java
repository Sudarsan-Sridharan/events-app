package com.ma.de;

import com.ma.de.controller.EventController;
import com.ma.de.domain.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

/**
 * Created by mariusz dekarski on 25/02/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EventsAcceptanceTest {

    @Autowired
    private EventController eventController;

    private static final String LOCATION = "London";

    @Test
    public void get_music_events_for_London(){

        List<Event> eventList = eventController.getEventsForLocation(LOCATION);
        assertThat(eventList.size(), greaterThan(0));

    }
}
