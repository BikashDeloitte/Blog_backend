package com.example.blog.Dto;

import com.example.blog.entity.PostCategory;
import com.example.blog.entity.UserData;
import lombok.*;

@Data
@Builder
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private PostCategory category;
    private UserData userData;
}
