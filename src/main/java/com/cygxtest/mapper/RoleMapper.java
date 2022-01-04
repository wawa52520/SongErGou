package com.cygxtest.mapper;

import com.cygxtest.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RoleMapper {
    List<Role> selectRolesByUserid(Integer userid);
}
