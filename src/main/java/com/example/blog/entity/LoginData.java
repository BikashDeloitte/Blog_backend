package com.example.blog.entity;

import lombok.*;

@Data
@Builder
public class LoginData {
    private String email;
    private String password;
}
