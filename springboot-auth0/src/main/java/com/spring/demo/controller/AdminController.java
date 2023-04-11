package com.spring.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @创建人 ly
 * @时间 04/11
 * @描述
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/login")
    public String adminLogin(String user, String password) {
        return "login";
    }
}
