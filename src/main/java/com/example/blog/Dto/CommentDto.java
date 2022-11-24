package com.example.blog.Dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentDto {
    private Long id;
    private String Comment;
    private String userName;
    private LocalDate commentDate;

    public CommentDto(String comment) {
        Comment = comment;
    }
}
