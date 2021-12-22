package com.example.SpringDemo.controller;

import com.example.SpringDemo.model.UserEntity;
import com.example.SpringDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

@GetMapping("/fetchall")
public List<UserEntity> fetchallusers(){
    return userService.showAllusers();
}
@DeleteMapping("/delete/{id}")
    public List<UserEntity> deletebyId(@PathVariable String id){
        return userService.deleteUserById(Long.parseLong(id));
}
@PostMapping("/add")
    public UserEntity createUser(@RequestBody UserEntity userEntity){
    return userService.createUserEntity(userEntity);
}
@PutMapping("/edit")
    public UserEntity updateUser(@RequestBody UserEntity userEntity){
    return userService.updateUserEntity(userEntity);
}












}
