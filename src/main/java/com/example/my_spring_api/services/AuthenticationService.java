package com.example.my_spring_api.services;

import com.example.my_spring_api.dto.JwtAuthenticationResponse;
import com.example.my_spring_api.dto.RefreshTokenRequest;
import com.example.my_spring_api.dto.SignUpRequest;
import com.example.my_spring_api.dto.SigninRequest;
import com.example.my_spring_api.entities.User;

public interface AuthenticationService {

    User signup(SignUpRequest signUpRequest);

    JwtAuthenticationResponse signin(SigninRequest signinRequest);

    JwtAuthenticationResponse refreshtoken(RefreshTokenRequest refreshTokenRequest);
}
