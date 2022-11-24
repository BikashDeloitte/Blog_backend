package com.example.blog.Dto;

import com.example.blog.entity.PostCategory;
import com.example.blog.entity.UserData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private PostCategory category;
    private UserData userData;
}
