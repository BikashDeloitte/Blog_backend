package com.example.blog.service;

import com.example.blog.Dto.UserDataDto;
import com.example.blog.entity.JwtAuthResponse;
import com.example.blog.entity.LoginData;
import com.example.blog.entity.UserData;
import com.example.blog.exception.MisMatchException;
import com.example.blog.exception.NotFoundException;
import com.example.blog.repository.UserDataRespository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDataService {

    @Autowired
    UserDataRespository userDataRespository;

    //get all user data
    public List<UserDataDto> getAllUserData() {
        List<UserData> userDataList = userDataRespository.findAll();
        List<UserDataDto> userDataDtoList = new ArrayList<>();

        userDataList.forEach(s -> {
            UserDataDto userDataDto = UserDataDto.builder().build();
            BeanUtils.copyProperties(s, userDataDto);
            userDataDtoList.add(userDataDto);
        });
        return userDataDtoList;
    }

    //create or update user data
    public UserDataDto addUserData(UserDataDto userDataDto) {
        UserData userData = UserData.builder().build();
        BeanUtils.copyProperties(userDataDto, userData);
        userDataDto.setId(userDataRespository.save(userData).getId());
        return userDataDto;
    }

    //get user data by email
    public UserDataDto getUserDataByEmail(String email) {
        UserData userData = userDataRespository.findByEmail(email);
        UserDataDto userDataDto = UserDataDto.builder().build();
        BeanUtils.copyProperties(userData, userDataDto);
        return userDataDto;
    }

    //send token with user data
    public JwtAuthResponse createToken(LoginData loginData) {
        UserData userData = userDataRespository.findByEmail(loginData.getEmail());
        if(userData != null){
            if(loginData.getPassword().equals(userData.getPassword())){
                UserDataDto userDataDto = UserDataDto.builder().build();
                BeanUtils.copyProperties(userData,userDataDto);
                return JwtAuthResponse.builder().token("token").userData(userDataDto).build();
            }
            else{
                throw new MisMatchException("Password is wrong, please");
            }
        }
        else {
            throw new NotFoundException("email not found");
        }
    }
}
