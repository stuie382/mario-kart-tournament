package com.stuart.tournament.security.entity;

import com.stuart.tournament.entity.Player;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The User that is registered with the system.
 */
@NoArgsConstructor
@Data
@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    private String username;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Collection<Role> roles;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Player player;

    public User(String firstName, String lastName, String username, String password, List<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.roles = new ArrayList<>(roles);
    }
}
