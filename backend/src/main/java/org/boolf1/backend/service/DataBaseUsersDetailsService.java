package org.boolf1.backend.service;

import java.util.Optional;

import org.boolf1.backend.model.User;
import org.boolf1.backend.repository.UserRepository;
import org.boolf1.backend.security.DataBaseUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DataBaseUsersDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            return new DataBaseUserDetails(user.get());
        } else {
            throw new UsernameNotFoundException("Username not found!");
        }
    }
}