package com.example.blog.util;

import com.example.blog.Dto.CommentDto;
import com.example.blog.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class Mapping {
    public CommentDto commentToCommentDto(Comment comment){
        String fullName = comment.getUserData().getFirstName()+comment.getUserData().getMiddleName()+comment.getUserData().getLastName();
        return new CommentDto(comment.getId(), comment.getComment(), fullName, comment.getCommentDate());
    }

    public Comment commentDtoToComment(CommentDto commentDto){
        return new Comment(commentDto.getId(), commentDto.getComment(), commentDto.getCommentDate());
    }
}
