package com.stuart.tournament.security.service;

import com.stuart.tournament.security.dto.UserRegistrationDto;
import com.stuart.tournament.security.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * The User service interface required by the DAO Authentication Provider.
 */
public interface UserService extends UserDetailsService {

    /**
     * Save a new user to the system, returning the new User entity.
     *
     * @param registrationDto - The new user attempting to register with the system
     * @return - The User entity if the registration was successful
     */
    User save(UserRegistrationDto registrationDto);
}
