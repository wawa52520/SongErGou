package com.cygxtest.services;

import com.cygxtest.entity.Role;
import com.cygxtest.entity.User;
import com.cygxtest.services.impl.UserServicesImpl;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {


    String getPasswordByUsername(String username);
    Integer selectUserIdByUsername(String username);
}
