package com.example.blog.service;

import com.example.blog.entity.PostCategory;
import com.example.blog.repository.PostCategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCategoryService {

    @Autowired
    PostCategoryRespository postCategoryRespository;

    //get all post category
    public List<PostCategory> getPostCategory(){
        return postCategoryRespository.findAll();
    }
}
