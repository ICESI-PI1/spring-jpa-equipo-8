package com.compunet.bookstore.security.service;

import com.compunet.bookstore.security.payload.request.SignUpRequest;
import com.compunet.bookstore.security.payload.request.SigninRequest;
import com.compunet.bookstore.security.payload.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(SigninRequest request);
}