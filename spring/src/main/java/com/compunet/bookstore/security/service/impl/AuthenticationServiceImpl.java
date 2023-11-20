package com.compunet.bookstore.security.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.compunet.bookstore.persistence.models.User;
import com.compunet.bookstore.persistence.repositories.impl.UserRepository;
import com.compunet.bookstore.security.config.AuthRole;
import com.compunet.bookstore.security.payload.request.SignUpRequest;
import com.compunet.bookstore.security.payload.request.SigninRequest;
import com.compunet.bookstore.security.payload.response.JwtAuthenticationResponse;
import com.compunet.bookstore.security.service.AuthenticationService;
import com.compunet.bookstore.security.service.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        User user = User.builder().username(request.getUsername()).password(request.getPassword()).role(AuthRole.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}