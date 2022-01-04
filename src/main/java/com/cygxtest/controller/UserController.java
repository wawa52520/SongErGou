package com.cygxtest.controller;


import com.cygxtest.common.Result;
import com.cygxtest.entity.User;
import com.cygxtest.services.UserService;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/test")
public class UserController {
   @Autowired
    UserService userService;
    @GetMapping("/getMessage")
    @RequiresRoles("role:root")
    @RequiresPermissions("users")

//@RequiresRoles(logical = Logical.OR, value = { "admin"})

    public Result getMessage(){
        return Result.success();
    }

}
