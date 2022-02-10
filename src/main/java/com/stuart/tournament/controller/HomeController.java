package com.stuart.tournament.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * Define the end point used to log into the application.
     *
     * @return login
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * Define the end point used when access the root of the application.
     *
     * @return index
     */
    @GetMapping("/")
    public String home() {
        return "index";
    }

}
