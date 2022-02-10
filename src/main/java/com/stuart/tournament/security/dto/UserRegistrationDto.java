package com.stuart.tournament.security.dto;

import lombok.*;

/**
 * The DTO for user registration.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDto {

    private String firstName;

    private String lastName;

    private String username;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String password;

}
