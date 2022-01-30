package com.stuart.tournament.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    /**
     * Specify the page to load when accessing the base server URL.
     *
     * @return - The URL to redirect to.
     */
    @GetMapping("/")
    public String loadTracks() {
        return "redirect:tracks/list";
    }
}
