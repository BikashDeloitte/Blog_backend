package com.example.blog.util;

import com.example.blog.Dto.CommentDto;
import com.example.blog.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class Mapping {
    public CommentDto commentToCommentDto(Comment comment) {
        String fullName = comment.getUserData().getMiddleName() == "" ?
                comment.getUserData().getFirstName() +" "+ comment.getUserData().getLastName()
                :
                comment.getUserData().getFirstName() +" "+ comment.getUserData().getMiddleName() +" "+ comment.getUserData().getLastName();
        return CommentDto.builder()
                .id(comment.getId())
                .Comment(comment.getComment())
                .userName(fullName)
                .commentDate(comment.getCommentDate())
                .build();
    }

    public Comment commentDtoToComment(CommentDto commentDto) {
        return Comment.builder()
                .id(commentDto.getId())
                .Comment(commentDto.getComment())
                .commentDate(commentDto.getCommentDate())
                .build();
    }
}
