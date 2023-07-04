package com.snippet.spring.mybatisplus;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.snippet.spring.dao.entity.Order;
import com.snippet.spring.dao.entity.User;
import com.snippet.spring.dao.mapper.OrderMapper;
import com.snippet.spring.dao.mapper.UserMapper;
import com.snippet.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Transactional(rollbackFor = Exception.class) // 测试下默认自动回滚
 * create by whr on 2023/2/15
 */
@SpringBootTest
public class InsertTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    @Rollback(value = false)
    public void insert_batch_column_test() {
        long startTime = System.nanoTime();
        List<User> users = createUsers();
        userMapper.insertBatchSomeColumn(users);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime); // 6_662_785_700  6s
    }

    @Test
    @Rollback(value = false)
    public void save_batch_test() {
        List<User> users = createUsers();
        long startTime = System.nanoTime();
        userService.saveBatch(users);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime); // 27_099_770_500  27s
    }

    @Test
    @Rollback(value = false)
    public void deleteData() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(User::getCreatedAt, "2023-04-30 00:00:50").le(User::getCreatedAt, "2023-04-30 23:59:50");
        userMapper.delete(queryWrapper);
    }

    public List<User> createUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 500_000; i++) {
            User user = new User();
            user.setId(IdUtil.getSnowflakeNextId());
            user.setUsername(generateUsername());
            user.setPassword("123456");
            user.setStatus(new Random().nextInt(2));
            user.setPhone(generatePhone());
            user.setCreatedAt(LocalDateTime.now().plusDays(new Random().nextInt(201) - 100));
            user.setEmail(generateEmail());
            user.setType(new Random().nextInt(2));
            users.add(user);
        }
        return users;
    }

    private String generateUsername() {
        Random random = new Random();
        int nameLength = random.nextInt(10 - 5 + 1) + 5;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nameLength; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }

        return sb.toString();
    }

    private String generatePhone() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("1"); // 手机号第一位固定为1
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10)); // 后续10位随机生成数字
        }
        return sb.toString();
    }

    private String generateEmail() {
        Random random = new Random();

        StringBuilder sb = new StringBuilder();
        sb.append("user").append(random.nextInt(1000)); // 生成长度为4的用户名
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com"}; // 邮箱域名列表
        String domain = domains[random.nextInt(domains.length)]; // 随机选取一个域名

        return sb + "@" + domain;
    }

    @Autowired
    private OrderMapper orderMapper;

    @Test
    @Rollback(value = false)
    public void insert_batch_column_order_test() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            List<Order> orders = createOrders();
            orderMapper.insertBatchSomeColumn(orders);
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime); // 6_662_785_700  6s
    }

    public List<Order> createOrders() {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < 200_000; i++) {
            Order order = new Order();
            order.setId(IdUtil.getSnowflakeNextId());
            order.setUserId(IdUtil.getSnowflakeNextId());
            order.setStatus(new Random().nextInt(3));
            order.setCreatedAt(LocalDateTime.now().plusDays(new Random().nextInt(201) - 100));
            order.setType(new Random().nextInt(4));
            orders.add(order);
        }
        return orders;
    }
}