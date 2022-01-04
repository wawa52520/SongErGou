package com.cygxtest.services.impl;

import com.cygxtest.entity.UserRole;
import com.cygxtest.mapper.UserRoleMapper;
import com.cygxtest.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServicesImpl implements UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;
    @Override
    public List<UserRole> selectRoleIdByUserID(Integer userId) {
        return userRoleMapper.selectRoleIdByUserID(userId);
    }
}
