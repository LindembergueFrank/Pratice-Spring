package com.repospring.management_guests.controller;

import com.repospring.management_guests.repository.Guests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuestsController {

    @Autowired
    private Guests guests;

    @GetMapping("/guests")
    public ModelAndView listing() {
        ModelAndView modelAndView = new ModelAndView("ListGuests");

        modelAndView.addObject("guests", guests.findAll());

        return modelAndView;
    }
}
