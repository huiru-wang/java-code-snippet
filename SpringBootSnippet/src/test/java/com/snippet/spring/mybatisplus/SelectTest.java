package com.snippet.spring.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.snippet.spring.dao.entity.User;
import com.snippet.spring.dao.mapper.UserMapper;
import com.snippet.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * create by whr on 2023/2/19
 */
@SpringBootTest
public class SelectTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService UserService;

    @Test
    public void select_by_lambda_test() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.le(User::getId, 1627314511772188795L);
        List<User> res = userMapper.selectList(queryWrapper);
        System.out.println(res.size());
    }

    @Test
    public void select_page_test() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.le(User::getId, 1627314511772188795L);
        Page<User> page = new Page<>(1, 100);
        Page<User> res = userMapper.selectPage(page, queryWrapper);
        System.out.println(res.getTotal());  // 总数
        System.out.println(res.getPages()); // 总页
        System.out.println(res.getCurrent());   // 当前页
        System.out.println(res.getSize());  // 当前页记录数
        List<User> records = res.getRecords();
        System.out.println(records.size()); // 100
    }
}
