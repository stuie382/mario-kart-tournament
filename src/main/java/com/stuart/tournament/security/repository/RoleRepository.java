package com.stuart.tournament.security.repository;


import com.stuart.tournament.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface to allow access to the Role data.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
