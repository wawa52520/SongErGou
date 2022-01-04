package com.cygxtest.services.impl;

import com.cygxtest.entity.Resources;
import com.cygxtest.mapper.ResourcesMapper;
import com.cygxtest.services.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResourcesServicesImpl implements ResourcesService {
    @Autowired
    ResourcesMapper resourcesMapper;

    @Override
    public List<Resources> selectPermissionsByRoleId(Integer roleId) {
        return resourcesMapper.selectPermissionsByRoleId(roleId);
    }
}
