package com.example.blog.service;

import com.example.blog.Dto.CommentDto;
import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import com.example.blog.entity.UserData;
import com.example.blog.repository.CommentRespository;
import com.example.blog.repository.PostRespository;
import com.example.blog.repository.UserDataRespository;
import com.example.blog.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    CommentRespository commentRespository;
    @Autowired
    PostRespository postRespository;
    @Autowired
    UserDataRespository userDataRespository;
    @Autowired
    Mapping mapping;

    //create comment
    public CommentDto addComment(String comments, Long postId, Long userId) {
        Optional<Post> post = postRespository.findById(postId);
        Optional<UserData> user = userDataRespository.findById(userId);
        //
        Comment comment = mapping.commentDtoToComment( CommentDto.builder().Comment(comments).build());

        //setting commented date
        comment.setCommentDate(LocalDate.now());

        //mapping post to comment
        post.ifPresent(comment::setPost);
        //mapping user who commented
        user.ifPresent(comment::setUserData);


        return mapping.commentToCommentDto(commentRespository.save(comment));
    }

    public List<CommentDto> getAllCommentByPostId(Long postId) {
        List<Comment> commentList = commentRespository.findByPostId(postId);
        List<CommentDto> commentDtoList = new ArrayList<>();
        commentList.forEach((comment -> {
            commentDtoList.add(mapping.commentToCommentDto(comment));
        }));
        return commentDtoList;
    }
}
