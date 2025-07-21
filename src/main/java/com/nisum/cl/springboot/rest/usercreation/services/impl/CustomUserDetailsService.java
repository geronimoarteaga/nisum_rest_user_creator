package com.nisum.cl.springboot.rest.usercreation.services.impl;

import com.nisum.cl.springboot.rest.usercreation.entities.UserInfo;
import com.nisum.cl.springboot.rest.usercreation.services.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserInfo user = userInfoService.findByUsername(email);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found with username: " + email);
        }
        return new User(
                user.getEmail(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}