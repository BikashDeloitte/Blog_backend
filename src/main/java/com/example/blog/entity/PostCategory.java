package com.example.blog.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data @ToString @NoArgsConstructor @AllArgsConstructor
@Entity
public class PostCategory {
    @Id
    @GeneratedValue
    private Long id;
    private String category;
}
