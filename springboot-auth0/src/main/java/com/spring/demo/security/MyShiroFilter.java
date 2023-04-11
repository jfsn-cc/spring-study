package com.spring.demo.security;

import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 自定义拦截器
 */
@Component
public class MyShiroFilter extends AuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        boolean loginRequest = isLoginRequest(request, response);
        return loginRequest;
    }
}
