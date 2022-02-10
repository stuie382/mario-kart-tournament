package com.stuart.tournament.security.service;

import com.stuart.tournament.security.dto.UserRegistrationDto;
import com.stuart.tournament.security.entity.Role;
import com.stuart.tournament.security.entity.User;
import com.stuart.tournament.security.repository.RoleRepository;
import com.stuart.tournament.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    /**
     * Autowired UserRepository instance.
     */
    private final UserRepository userRepository;

    /**
     * Autowired password encoder bean.
     */
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * Autowired RoleRepository instance.
     */
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder,
                           RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {
        Role userRole = roleRepository.findByName("ROLE_USER");
        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getUsername(),
                passwordEncoder.encode(registrationDto.getPassword()),
                List.of(userRole));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.get().getUsername(),
                user.get().getPassword(),
                mapRolesToAuthorities(user.get().getRoles()));
    }

    private static Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(
                        role.getName()))
                .collect(Collectors.toList());
    }
}
