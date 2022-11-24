package com.example.blog.entity;

import lombok.*;

import java.util.List;

@Data
@Builder
public class PostResponse {

    private List<Post> post;
    private int pageNumber;
    //total post in one paper
    private int pageSize;
    //total post
    private Long totalElement;
    private int totalPage;
    private boolean latePage;
}
