package com.example.blog.service;

import com.example.blog.entity.JwtAuthResponse;
import com.example.blog.entity.LoginData;
import com.example.blog.entity.UserData;
import com.example.blog.exception.MisMatchException;
import com.example.blog.exception.NotFoundException;
import com.example.blog.repository.UserDataRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {

    @Autowired
    UserDataRespository userDataRespository;

    //get all user data
    public List<UserData> getAllUserData(){
        return userDataRespository.findAll();
    }

    //create or update user data
    public UserData addUserData(UserData userData) {
        return userDataRespository.save(userData);
    }

    //get user data by email
    public UserData getUserDataByEmail(String email) {
        return userDataRespository.findByEmail(email);
    }

    //send token with user data
    public JwtAuthResponse createToken(LoginData loginData) {
        UserData userData = userDataRespository.findByEmail(loginData.getEmail());
        if(userData != null){
            if(loginData.getPassword().equals(userData.getPassword())){
                userData.setPassword("********");
                return new JwtAuthResponse("token",userData);
            }
            else{
                throw new MisMatchException("Password is worry, please");
            }
        }
        else {
            throw new NotFoundException("email not found");
        }
    }
}
