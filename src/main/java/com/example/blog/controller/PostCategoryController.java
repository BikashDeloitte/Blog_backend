package com.example.blog.controller;

import com.example.blog.entity.PostCategory;
import com.example.blog.service.PostCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PostCategoryController {

    @Autowired
    PostCategoryService postCategoryService;

    //get all post category
    @GetMapping("/category")
    public ResponseEntity<List<PostCategory>> getPostCategory(){
        return ResponseEntity.ok(postCategoryService.getPostCategory());
    }

}
