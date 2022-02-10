package com.stuart.tournament.security.repository;

import com.stuart.tournament.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface to allow access to the User data
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Attempt to find a user by the username provided.
     *
     * @param username - The username to check the system for.
     * @return - An optional containing the user.
     */
    Optional<User> findByUsername(String username);

}
