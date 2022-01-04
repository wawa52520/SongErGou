package com.cygxtest.services.impl;

import com.cygxtest.entity.Role;
import com.cygxtest.mapper.RoleMapper;
import com.cygxtest.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServicesImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;


    @Override
    public List<Role> selectRolesByUserid(Integer userid) {
        return  roleMapper.selectRolesByUserid(userid);
    }
}
