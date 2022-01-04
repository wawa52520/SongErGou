package com.cygxtest.mapper;


import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

    String getPasswordByUsername(String username);
    Integer selectUserIdByUsername(String username);

}
