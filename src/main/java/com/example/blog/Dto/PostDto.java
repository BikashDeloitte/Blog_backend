package com.example.blog.Dto;

import com.example.blog.entity.PostCategory;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private PostCategory category;
    private String postCreateName;
    private LocalDate createdDate;
}
