package com.stuart.tournament.security.repository;

import com.stuart.tournament.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{

    Role findAllByName(String name);
}