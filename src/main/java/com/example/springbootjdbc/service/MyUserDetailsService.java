package com.example.springbootjdbc.service;

import com.example.springbootjdbc.model.UserPrincipal;
import com.example.springbootjdbc.model.Users;
import com.example.springbootjdbc.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);
        if(user == null){ // if user not found
            System.out.println("User not found ayee");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }
}
