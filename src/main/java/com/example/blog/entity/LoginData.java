package com.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class LoginData {
    private String email;
    private String password;
}
