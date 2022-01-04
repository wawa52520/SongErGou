package com.cygxtest.services.impl;

import com.cygxtest.entity.Role;
import com.cygxtest.entity.User;
import com.cygxtest.mapper.UserMapper;
import com.cygxtest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServicesImpl  implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public String getPasswordByUsername(String username) {
        return userMapper.getPasswordByUsername(username);
    }

    @Override
    public Integer selectUserIdByUsername(String username) {
        return userMapper.selectUserIdByUsername(username);
    }
}
