package com.example.blog.repository;

import com.example.blog.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRespository extends JpaRepository<UserData, Long> {
    UserData findByEmail(String email);
}
