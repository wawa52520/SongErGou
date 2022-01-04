package com.cygxtest.controller;

import com.cygxtest.common.Result;
import com.cygxtest.services.UserService;
import com.cygxtest.util.JwtUtil;

import org.apache.shiro.ShiroException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController

public class LoginController {
@Autowired
    UserService userService;
    @PostMapping("/login")
    public Result login(@RequestParam("username") String username,
                        @RequestParam("password") String password){

 String realPassword =   userService.getPasswordByUsername(username);
 System.out.println(realPassword);
 if(realPassword == null){
     return Result.error("401","用户名错误");
 }
else if (!realPassword.equals(password)){
    return  Result.error("401","密码错误");
 }
else {
    return Result.success(JwtUtil.createToken(username));
 }

    }


}
