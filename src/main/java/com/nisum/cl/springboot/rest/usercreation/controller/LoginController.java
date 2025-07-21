package com.nisum.cl.springboot.rest.usercreation.controller;

import com.nisum.cl.springboot.rest.usercreation.dtos.LoginRequestDTO;
import com.nisum.cl.springboot.rest.usercreation.security.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtils;

    @Operation(summary = "Login de usuario", description = "Devuelve un token JWT para utilizar en operaciones que lo requieran")
    @PostMapping("/login")
    public String authenticateUser(@RequestBody LoginRequestDTO user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtUtils.generateToken(userDetails.getUsername());
    }
}