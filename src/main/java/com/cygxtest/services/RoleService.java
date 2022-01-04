package com.cygxtest.services;

import com.cygxtest.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> selectRolesByUserid(Integer userid);
}
