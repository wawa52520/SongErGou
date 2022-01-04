package com.cygxtest.mapper;

import com.cygxtest.entity.Resources;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ResourcesMapper {
   List<Resources> selectPermissionsByRoleId(Integer roleId);
}
