package com.example.blog.controller;

import com.example.blog.Dto.CommentDto;
import com.example.blog.entity.Comment;
import com.example.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    CommentService commentService;

    //add comment
    @PostMapping("/comment")
    public ResponseEntity<CommentDto> addComment(
            @RequestParam(value = "comments") String comments,
            @RequestParam(value = "postId") Long postId,
            @RequestParam(value = "userId", required = false) Long userId
    ){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(commentService.addComment(comments,postId,userId));
    }

    //get all comment by post id
    @GetMapping("/comment")
    public ResponseEntity<List<CommentDto>> getAllCommentByPostId(@RequestParam(value = "postId") Long postId){

        return ResponseEntity.ok(commentService.getAllCommentByPostId(postId));
    }
}
