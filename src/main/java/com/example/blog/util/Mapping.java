package com.example.blog.util;

import com.example.blog.Dto.CommentDto;
import com.example.blog.Dto.PostDto;
import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class Mapping {
    //comment -> commentDto
    public CommentDto commentToCommentDto(Comment comment) {
        String fullName = comment.getUserData().getMiddleName().equals("") ?
                comment.getUserData().getFirstName() +" "+ comment.getUserData().getLastName()
                :
                comment.getUserData().getFirstName() +" "+ comment.getUserData().getMiddleName() +" "+ comment.getUserData().getLastName();
        return CommentDto.builder()
                .id(comment.getId())
                .commentContent(comment.getCommentContent())
                .userName(fullName)
                .commentDate(comment.getCommentDate())
                .build();
    }

    //commentDto -> comment
    public Comment commentDtoToComment(CommentDto commentDto) {
        return Comment.builder()
                .id(commentDto.getId())
                .commentContent(commentDto.getCommentContent())
                .commentDate(commentDto.getCommentDate())
                .build();
    }

    //postDto -> post
    public Post postDtoToPost(PostDto postDto){
        return Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .build();
    }

    //post -> postDto
    public PostDto postToPostDto(Post post){
        String fullName = post.getUserData().getMiddleName().equals("") ?
                post.getUserData().getFirstName() +" "+ post.getUserData().getLastName()
                :
                post.getUserData().getFirstName() +" "+ post.getUserData().getMiddleName() +" "+ post.getUserData().getLastName();

        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .category(post.getCategory())
                .postCreateName(fullName)
                .createdDate(post.getCreatedDate())
                .build();
    }
}
