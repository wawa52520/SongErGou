package com.cygxtest.mapper;

import com.cygxtest.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {

  List<UserRole> selectRoleIdByUserID(Integer userID);
}
