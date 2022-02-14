package com.stuart.tournament.controller;

import com.stuart.tournament.security.dto.UserRegistrationDto;
import com.stuart.tournament.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    /**
     * Autowired UserService instance
     */
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Define the end point when registration is accessed with a GET request.
     *
     * @return registration.html
     */
    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    /**
     * Define the end point when registration is accessed with a POST request.
     *
     * @param registrationDto The details of the user to register with the system
     *
     * @return A redirect back to the registration.html with the success flag set
     */
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

}
