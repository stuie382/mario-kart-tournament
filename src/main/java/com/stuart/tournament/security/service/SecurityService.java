package com.stuart.tournament.security.service;
public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}