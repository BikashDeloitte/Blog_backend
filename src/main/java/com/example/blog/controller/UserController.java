package com.example.blog.controller;

import com.example.blog.Dto.UserDataDto;
import com.example.blog.entity.JwtAuthResponse;
import com.example.blog.entity.LoginData;
import com.example.blog.entity.UserData;
import com.example.blog.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserDataService userDataService;

    //get all user data
    @GetMapping("/userdata")
    public ResponseEntity<List<UserDataDto>> getAllUserData(){
        List<UserDataDto> allUserData = userDataService.getAllUserData();
        return ResponseEntity.ok(allUserData);
    }

    //create user data
    @PostMapping("/userdata")
    public ResponseEntity<UserDataDto> addUserData(@Valid @RequestBody UserDataDto userDataDto){
        UserDataDto result = userDataService.addUserData(userDataDto);
        return ResponseEntity.ok(result);
    }

    //get user data by email
    @GetMapping("/userData/{email}")
    public ResponseEntity<UserDataDto> getUserDataByEmail(@PathVariable String email){
        UserDataDto userData = userDataService.getUserDataByEmail(email);
        return ResponseEntity.ok(userData);
    }

    //get token with user data
    @PostMapping("/token")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody LoginData loginData){
        JwtAuthResponse jwtAuthResponse = userDataService.createToken(loginData);
        return ResponseEntity.ok(jwtAuthResponse);
    }
}
