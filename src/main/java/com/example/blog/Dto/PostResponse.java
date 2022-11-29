package com.example.blog.Dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostResponse {

    private List<PostDto> post;
    private int pageNumber;
    //total post in one paper
    private int pageSize;
    //total post
    private Long totalElement;
    private int totalPage;
    private boolean latePage;
}
