package com.example.my_spring_api.dto;

import lombok.Data;

@Data
public class SigninRequest {

    private String email;

    private String password;
}
