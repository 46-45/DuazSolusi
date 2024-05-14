package com.example.my_spring_api.dto;

import lombok.Data;

@Data
public class SignUpRequest {

    private String name;

    private String email;

    private String password;
}
