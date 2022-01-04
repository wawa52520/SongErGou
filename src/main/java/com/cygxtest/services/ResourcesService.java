package com.cygxtest.services;

import com.cygxtest.entity.Resources;

import java.util.List;

public interface ResourcesService {
    List<Resources> selectPermissionsByRoleId(Integer roleId);

}
