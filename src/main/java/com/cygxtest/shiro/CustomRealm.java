package com.cygxtest.shiro;





import com.cygxtest.common.Result;
import com.cygxtest.entity.Resources;
import com.cygxtest.entity.Role;
import com.cygxtest.entity.User;
import com.cygxtest.entity.UserRole;
import com.cygxtest.services.ResourcesService;
import com.cygxtest.services.RoleService;
import com.cygxtest.services.UserRoleService;
import com.cygxtest.services.UserService;
import com.cygxtest.util.JwtUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 自定义 Realm
 * @Date 2018-03-25
 * @Time 21:46
 */
@Component
public class CustomRealm extends AuthorizingRealm {

 @Autowired
    UserService userService;
 @Autowired
 RoleService roleService;
 @Autowired
    UserRoleService userRoleService;
 @Autowired
    ResourcesService resourcesService;



    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }






    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("————身份认证方法————");
        String token = (String) authenticationToken.getPrincipal();
        System.out.println(token);
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
         System.out.println(username);

        if (username == null || !JwtUtil.verify(token, username)) {
           throw new ShiroException("token认证失败！");
           // System.out.println("aaaa");

        }

        // 从数据库获取对应用户名密码的用户
        String password = userService.getPasswordByUsername(username);
        if (null == password) {
            throw new AccountException("用户名不正确");
        }

        return new SimpleAuthenticationInfo(token, token, "MyRealm");

    }


    /**
     * 获取授权信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————权限认证————");
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String username = JwtUtil.getUsername(token);
       // System.out.println(username);
        Integer getUserId = userService.selectUserIdByUsername(username);
      //  System.out.println(getUserId);
        List<Role> roleNameList = roleService.selectRolesByUserid(getUserId);
      //  System.out.println(roleNameList);
       // System.out.println(roleNameList);
        for (Role role:roleNameList
             ) {
            info.addRole(role.getName());
        }


        List<UserRole> roleIdList =  userRoleService.selectRoleIdByUserID(getUserId);
     //   System.out.println(roleIdList);
        for (UserRole userRole: roleIdList
            ) {
            Integer a = Integer.valueOf(userRole.getRoleId().toString()) ;
       List<Resources>  resourcesPermissionList =  resourcesService.selectPermissionsByRoleId(a);
     //   System.out.println(resourcesPermissionList);

            for (Resources resources: resourcesPermissionList
                 ) {
                info.addStringPermission(resources.getPermission());
            }


       }



        return info;
    }
}
