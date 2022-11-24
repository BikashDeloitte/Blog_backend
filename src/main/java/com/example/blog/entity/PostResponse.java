package com.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
