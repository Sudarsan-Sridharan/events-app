package com.ma.de.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ma.de.domain.Event;
import com.ma.de.domain.EventfulSearchResult;
import com.ma.de.domain.Events;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by mariusz on 25/02/17.
 */
@Service
public class EventfulServiceImpl implements EventService {

    private static final Logger logger = Logger.getLogger(EventfulServiceImpl.class);

    @Value("${application.key}")
    private String applicationKey = "jW4gNrLwvg7z7Rh6";

    private String URL = "http://api.eventful.com/json/events/search" +
            "?app_key=" + applicationKey +
            "&location=%s&page_size=20";

    //TODO pagination is included in remote service now for assignment reason I limit to first 20

    private RestTemplate restTemplate = restTemplate();

    @Override
    public List<Event> getEventsForLocation(String location) {
        List<Event> list = Collections.EMPTY_LIST;
        String fullURL = String.format(URL, location);

        logger.info("Getting result for " + fullURL);

        EventfulSearchResult queryResult = restTemplate.getForObject(fullURL, EventfulSearchResult.class);

        if(queryResult.getEvents() != null){
            list =  queryResult.getEvents().getEvent();
        }
        logger.info("Total items matching criteria: " + queryResult.getTotalItems() + " returning: " + list.size());

        return list;
    }

    private RestTemplate restTemplate() {
        RestTemplate restTemp = new RestTemplate();
        List<HttpMessageConverter<?>> converters = restTemp.getMessageConverters();
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter jsonConverter = (MappingJackson2HttpMessageConverter) converter;
                jsonConverter.setObjectMapper(new ObjectMapper());
                jsonConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("application", "json", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET), new MediaType("text", "javascript", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET)));
            }
        }
        return restTemp;
    }


}
