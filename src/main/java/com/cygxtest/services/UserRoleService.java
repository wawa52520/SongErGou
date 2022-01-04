package com.cygxtest.services;

import com.cygxtest.entity.UserRole;

import java.util.List;

public interface UserRoleService {
  List<UserRole> selectRoleIdByUserID(Integer userId);
}
