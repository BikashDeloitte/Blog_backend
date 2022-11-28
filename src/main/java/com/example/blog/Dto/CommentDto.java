package com.example.blog.Dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
public class CommentDto {
    private Long id;
    private String commentContent;
    private String userName;
    private LocalDate commentDate;
}
