package com.example.blog.repository;

import com.example.blog.entity.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCategoryRespository extends JpaRepository<PostCategory,Long> {
}
