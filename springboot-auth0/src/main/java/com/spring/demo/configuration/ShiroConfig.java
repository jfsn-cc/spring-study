package com.spring.demo.configuration;

import com.spring.demo.security.MyShiroFilter;
import com.spring.demo.security.ShiroRealm;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@RequiredArgsConstructor
public class ShiroConfig {

    private final MyShiroFilter myShiroFilter;
    private final ShiroRealm shiroRealm;

    private ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager());
        return factoryBean;
    }

    private SecurityManager securityManager() {
        SecurityManager securityManager = new DefaultSecurityManager(shiroRealm);
        return securityManager;
    }


}
