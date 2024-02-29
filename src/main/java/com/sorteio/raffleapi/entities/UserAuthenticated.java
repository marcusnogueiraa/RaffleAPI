package com.sorteio.raffleapi.entities;

import com.sorteio.raffleapi.entities.User;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserAuthenticated implements UserDetails {
    private final User user;

    public UserAuthenticated(User user){
        this.user = user;
    }

    @Override 
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(() -> "ROLE_USER");
    }

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    @Override
    public String getUsername(){
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }
}
