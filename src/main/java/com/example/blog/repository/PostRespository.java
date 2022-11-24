package com.example.blog.repository;

import com.example.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRespository extends JpaRepository<Post,Long> {
}
