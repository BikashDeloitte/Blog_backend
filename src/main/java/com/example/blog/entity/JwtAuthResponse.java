package com.example.blog.entity;

import lombok.*;

@Data
@Builder
public class JwtAuthResponse {
    private String token;
    private UserData userData;
}
