package com.stuart.tournament.security.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * The roles that a user can have in the system.
 */
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "role", schema = "mariokart")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 60)
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
