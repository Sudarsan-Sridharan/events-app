package com.ma.de.service;

import com.ma.de.domain.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

/**
 * Created by mariusz on 25/02/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class EventfulServiceImplTest {

    private static final String LOCATION = "London";
    private static final String EVENT_TITLE = "Title";

    @Mock
    private EventfulServiceImpl eventService;

    @Test
    public void get_events_for_given_location(){

        String eventDate = LocalDate.of(2017, 2, 25).format(DateTimeFormatter.ISO_DATE);

        List<Event> eventList = Arrays.asList(new Event(EVENT_TITLE, eventDate),
                new Event(EVENT_TITLE, eventDate));

        given(eventService.getEventsForLocation(LOCATION)).willReturn(eventList);

        assertThat(eventService.getEventsForLocation(LOCATION).size(), is(2));
    }
}
