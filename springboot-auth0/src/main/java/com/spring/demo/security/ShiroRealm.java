package com.spring.demo.security;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.spring.demo.dao.AdminDao;
import com.spring.demo.model.Admin;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**\
 * 设置正确数据
 */
@Component
@RequiredArgsConstructor
public class ShiroRealm extends AuthorizingRealm {

    private final AdminDao adminDao;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();
        Admin byName = adminDao.getByName(username);
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, byName.getPassword().toCharArray(), this.getName());
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
