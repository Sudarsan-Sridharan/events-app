package com.ma.de.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mariusz on 26/02/17.
 */
@Controller
public class EventController {

    @RequestMapping(value = "/event-web")
    public String index() {
        return "index";
    }
}
