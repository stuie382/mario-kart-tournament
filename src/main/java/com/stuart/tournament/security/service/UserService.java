package com.stuart.tournament.security.service;

import com.stuart.tournament.security.entity.User;

public interface UserService {
    void save(User user);

    void saveAdmin(User user);

    User findByUsername(String username);
}
