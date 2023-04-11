package com.spring.demo.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.spring.demo.dao.mapper.AdminMapper;
import com.spring.demo.model.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @创建人 ly
 * @时间 03-27
 * @描述
 */
@Repository
@RequiredArgsConstructor
public class AdminDao {
    private final AdminMapper adminMapper;

    public Admin getByName(String userName) {
        LambdaQueryWrapper<Admin> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Admin::getUsername, userName);
        return adminMapper.selectOne(queryWrapper);
    }
}
