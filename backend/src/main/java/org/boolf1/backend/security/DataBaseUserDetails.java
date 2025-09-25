package org.boolf1.backend.security;

import java.util.HashSet;
import java.util.Set;

import org.boolf1.backend.model.Role;
import org.boolf1.backend.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DataBaseUserDetails implements UserDetails {

    private final Integer id;
    private final String username;
    private final String password;
    private final Set<GrantedAuthority> permissions;

    public DataBaseUserDetails(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();

        permissions = new HashSet<GrantedAuthority>();
        for (Role role : user.getRoles()) {
            permissions.add(new SimpleGrantedAuthority(role.getName()));
        }
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<GrantedAuthority> getAuthorities() {
        return permissions;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
