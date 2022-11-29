package com.example.blog.entity;

import com.example.blog.Dto.UserDataDto;
import lombok.*;

@Data
@Builder
public class JwtAuthResponse {
    private String token;
    private UserDataDto userData;
}
